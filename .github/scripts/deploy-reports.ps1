param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$StorageAccount,
    [string]$StorageKey
)

Write-Host "=== DIAGNÓSTICO COMPLETO INICIADO ==="
Write-Host "Storage Account: $StorageAccount"
Write-Host "Build Folder: $BuildFolder"

# 1. Verificar configuración de Azure Storage
Write-Host "`n=== CONFIGURACIÓN AZURE STORAGE ==="
try {
    $staticWebsite = az storage blob service-properties show `
        --account-name $StorageAccount `
        --account-key $StorageKey `
        --query "staticWebsite" `
        --output json
    Write-Host "Configuración Static Website:"
    Write-Host $staticWebsite
} catch {
    Write-Host "❌ No se pudo obtener la configuración del static website" -ForegroundColor Red
}

# 2. Verificar estructura local
Write-Host "`n=== ESTRUCTURA LOCAL ==="
Write-Host "Directorio actual: $(Get-Location)"
Write-Host "`nContenido de la carpeta build:"
if (Test-Path "./$BuildFolder") {
    Get-ChildItem "./$BuildFolder" -Recurse | Select-Object FullName, Length | Format-Table
} else {
    Write-Host "❌ CARPETA $BuildFolder NO EXISTE" -ForegroundColor Red
    exit 1
}

# 3. Verificar archivos críticos
Write-Host "`n=== ARCHIVOS CRÍTICOS LOCALES ==="
$criticalFiles = @(
    @{Path = "./$BuildFolder/serenity/index.html"; Name = "Serenity Index"},
    @{Path = "./$BuildFolder/serenity/serenity.css"; Name = "Serenity CSS"},
    @{Path = "./$BuildFolder/serenity/4.a51bb60f.js"; Name = "Serenity JS"},
    @{Path = "./index.html"; Name = "Portal Principal"}
)

foreach ($file in $criticalFiles) {
    if (Test-Path $file.Path) {
        $size = (Get-Item $file.Path).Length
        Write-Host "✅ $($file.Name): $($file.Path) ($size bytes)" -ForegroundColor Green
    } else {
        Write-Host "❌ $($file.Name): $($file.Path) - NO EXISTE" -ForegroundColor Red
    }
}

# 4. Generar portal de diagnóstico
Write-Host "`n=== GENERANDO PORTAL DE DIAGNÓSTICO ==="
$fecha = Get-Date -Format 'yyyy-MM-dd HH:mm:ss'

$htmlContent = @"
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Diagnóstico - Oficina Virtual</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
        .container { max-width: 1000px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px; }
        h1 { color: #2c3e50; border-bottom: 2px solid #3498db; padding-bottom: 10px; }
        .btn { display: inline-block; padding: 10px 20px; margin: 10px; background: #3498db; color: white; text-decoration: none; border-radius: 5px; }
        .btn-success { background: #27ae60; }
        .btn-warning { background: #f39c12; }
        .debug-section { background: #f8f9fa; padding: 15px; border-radius: 5px; margin: 15px 0; border-left: 4px solid #3498db; }
        .url-test { font-family: monospace; background: #2c3e50; color: white; padding: 10px; border-radius: 3px; margin: 5px 0; }
        .success { color: #27ae60; }
        .error { color: #e74c3c; }
    </style>
</head>
<body>
    <div class="container">
        <h1>🔍 Diagnóstico - Reportes de Pruebas</h1>

        <div class="debug-section">
            <h3>📋 Información del Build</h3>
            <p><strong>Nombre:</strong> $BuildName</p>
            <p><strong>Fecha:</strong> $fecha</p>
            <p><strong>Carpeta en Azure:</strong> $BuildFolder</p>
        </div>

        <div class="debug-section">
            <h3>🔗 URLs de Prueba</h3>
            <p>Haz clic en estos enlaces para verificar:</p>
            <div class="url-test">
                <a href="$BuildFolder/serenity/index.html" class="btn btn-success" target="_blank">🔗 Reporte Serenity Completo</a>
                <a href="$BuildFolder/serenity/index.html" class="btn" target="_blank">🔗 Solo Serenity Index</a>
            </div>
            <p><strong>URL completa:</strong> https://$StorageAccount.z6.web.core.windows.net/$BuildFolder/serenity/index.html</p>
        </div>

        <div class="debug-section">
            <h3>📊 Verificación de Archivos</h3>
            <p>Los siguientes archivos deben existir en Azure Storage:</p>
            <ul>
                <li><strong>$BuildFolder/serenity/index.html</strong> - <span id="serenity-status">⏳ Verificando...</span></li>
                <li><strong>$BuildFolder/serenity/serenity.css</strong> - <span id="css-status">⏳ Verificando...</span></li>
                <li><strong>index.html</strong> - <span id="portal-status">⏳ Verificando...</span></li>
            </ul>
        </div>
    </div>

    <script>
        // Verificar archivos en Azure
        async function checkFile(url, elementId) {
            try {
                const response = await fetch(url, { method: 'HEAD' });
                const element = document.getElementById(elementId);
                if (response.ok) {
                    element.innerHTML = '✅ Existe';
                    element.className = 'success';
                } else {
                    element.innerHTML = '❌ No existe (' + response.status + ')';
                    element.className = 'error';
                }
            } catch (error) {
                const element = document.getElementById(elementId);
                element.innerHTML = '❌ Error: ' + error.message;
                element.className = 'error';
            }
        }

        // Verificar todos los archivos cuando se cargue la página
        document.addEventListener('DOMContentLoaded', function() {
            const baseUrl = 'https://$StorageAccount.z6.web.core.windows.net/';
            checkFile(baseUrl + '$BuildFolder/serenity/index.html', 'serenity-status');
            checkFile(baseUrl + '$BuildFolder/serenity/serenity.css', 'css-status');
            checkFile(baseUrl + 'index.html', 'portal-status');
        });
    </script>
</body>
</html>
"@

$htmlContent | Out-File -FilePath "./diagnostic.html" -Encoding UTF8
Write-Host "✅ Portal de diagnóstico generado"

# 5. Subir archivos a Azure
Write-Host "`n=== SUBIENDO ARCHIVOS A AZURE ==="

try {
    # Subir portal de diagnóstico
    Write-Host "Subiendo portal de diagnóstico..."
    az storage blob upload `
        --account-name $StorageAccount `
        --container-name '$web' `
        --file "./diagnostic.html" `
        --name "diagnostic.html" `
        --auth-mode key `
        --account-key $StorageKey `
        --overwrite `
        --only-show-errors

    # Subir portal principal
    Write-Host "Subiendo portal principal..."
    az storage blob upload `
        --account-name $StorageAccount `
        --container-name '$web' `
        --file "./index.html" `
        --name "index.html" `
        --auth-mode key `
        --account-key $StorageKey `
        --overwrite `
        --only-show-errors

    # Subir carpeta completa
    Write-Host "Subiendo carpeta de reportes..."
    az storage blob upload-batch `
        --account-name $StorageAccount `
        --destination '$web' `
        --source "./$BuildFolder" `
        --auth-mode key `
        --account-key $StorageKey `
        --overwrite `
        --only-show-errors

    Write-Host "✅ Todos los archivos subidos" -ForegroundColor Green

} catch {
    Write-Host "❌ Error durante la subida: $($_.Exception.Message)" -ForegroundColor Red
    exit 1
}

# 6. Verificar archivos en Azure
Write-Host "`n=== VERIFICANDO ARCHIVOS EN AZURE ==="

$blobsToCheck = @(
    "index.html",
    "diagnostic.html",
    "$BuildFolder/serenity/index.html",
    "$BuildFolder/serenity/serenity.css",
    "$BuildFolder/serenity/4.a51bb60f.js"
)

foreach ($blob in $blobsToCheck) {
    try {
        $exists = az storage blob exists `
            --account-name $StorageAccount `
            --container-name '$web' `
            --name $blob `
            --auth-mode key `
            --account-key $StorageKey `
            --query "exists" --output tsv

        if ($exists -eq "true") {
            Write-Host "✅ $blob" -ForegroundColor Green
        } else {
            Write-Host "❌ $blob" -ForegroundColor Red
        }
    } catch {
        Write-Host "❌ Error verificando $blob : $($_.Exception.Message)" -ForegroundColor Red
    }
}

# 7. Listar algunos archivos en Azure para verificación
Write-Host "`n=== LISTANDO ARCHIVOS EN AZURE ==="
az storage blob list `
    --account-name $StorageAccount `
    --container-name '$web' `
    --prefix "$BuildFolder/serenity/" `
    --auth-mode key `
    --account-key $StorageKey `
    --query "[].name" --output tsv | Select-Object -First 20

Write-Host "`n=== DIAGNÓSTICO COMPLETADO ===" -ForegroundColor Green
Write-Host "🌐 Portal de Diagnóstico: https://$StorageAccount.z6.web.core.windows.net/diagnostic.html"
Write-Host "📊 Reporte Serenity: https://$StorageAccount.z6.web.core.windows.net/$BuildFolder/serenity/index.html"
Write-Host "📋 Portal Principal: https://$StorageAccount.z6.web.core.windows.net/"