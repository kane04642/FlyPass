param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$StorageAccount,
    [string]$StorageKey
)

Write-Host "=== DIAGNÓSTICO COMPLETO INICIADO ==="
Write-Host "Build: $BuildName"
Write-Host "Carpeta: $BuildFolder"
Write-Host "Storage Account: $StorageAccount"

# 1. Verificar estructura local completa
Write-Host "`n=== VERIFICANDO ESTRUCTURA LOCAL ==="
Write-Host "Directorio actual: $(Get-Location)"
Write-Host "Contenido del directorio raíz:"
Get-ChildItem "." | Select-Object Name, Attributes | Format-Table

Write-Host "`nContenido de la carpeta build:"
if (Test-Path "./$BuildFolder") {
    Get-ChildItem "./$BuildFolder" -Recurse | Select-Object FullName, Length | Format-Table
} else {
    Write-Host "❌ CARPETA $BuildFolder NO EXISTE" -ForegroundColor Red
    exit 1
}

# Verificar archivos críticos
Write-Host "`n=== VERIFICANDO ARCHIVOS CRÍTICOS ==="
$criticalFiles = @(
    @{Path = "./$BuildFolder/serenity/index.html"; Name = "Serenity Index"},
    @{Path = "./$BuildFolder/serenity/serenity.css"; Name = "Serenity CSS"},
    @{Path = "./$BuildFolder/jacoco/index.html"; Name = "JaCoCo Index"}
)

foreach ($file in $criticalFiles) {
    if (Test-Path $file.Path) {
        Write-Host "✅ $($file.Name): $($file.Path)" -ForegroundColor Green
    } else {
        Write-Host "❌ $($file.Name): $($file.Path) - NO EXISTE" -ForegroundColor Red
    }
}

# 2. Generar portal principal
Write-Host "`n=== GENERANDO PORTAL PRINCIPAL ==="
$fecha = Get-Date -Format 'yyyy-MM-dd HH:mm:ss'

$htmlContent = @"
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Reportes - Oficina Virtual</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
        .container { max-width: 800px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px; }
        h1 { color: #2c3e50; }
        .btn { display: inline-block; padding: 10px 20px; margin: 10px; background: #3498db; color: white; text-decoration: none; border-radius: 5px; }
        .btn-success { background: #27ae60; }
        .btn-warning { background: #f39c12; }
        .debug-info { background: #f8f9fa; padding: 10px; border-radius: 5px; margin: 10px 0; font-family: monospace; font-size: 12px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Reportes de Pruebas Automatizadas</h1>
        <p><strong>Build:</strong> $BuildName</p>
        <p><strong>Fecha:</strong> $fecha</p>

        <div class="debug-info">
            <strong>URLs de acceso:</strong><br>
            Serenity: $BuildFolder/serenity/index.html<br>
            JaCoCo: $BuildFolder/jacoco/index.html
        </div>

        <div>
            <a href="$BuildFolder/serenity/index.html" class="btn btn-success">Reporte Serenity</a>
            <a href="$BuildFolder/jacoco/index.html" class="btn btn-warning">Reporte JaCoCo</a>
        </div>
    </div>
</body>
</html>
"@

$htmlContent | Out-File -FilePath "./index.html" -Encoding UTF8
Write-Host "✅ Portal principal generado"

# 3. Subir a Azure Storage con verificación
Write-Host "`n=== SUBIENDO A AZURE STORAGE ==="

try {
    # 3.1 Subir portal principal
    Write-Host "Subiendo portal principal (index.html)..."
    az storage blob upload `
        --account-name $StorageAccount `
        --container-name '$web' `
        --file "./index.html" `
        --name "index.html" `
        --auth-mode key `
        --account-key $StorageKey `
        --overwrite
    Write-Host "✅ Portal principal subido" -ForegroundColor Green

    # 3.2 Subir archivos de Serenity individualmente
    Write-Host "`nSubiendo archivos de Serenity..."
    $serenityFiles = Get-ChildItem "./$BuildFolder/serenity" -Recurse -File
    Write-Host "Encontrados $($serenityFiles.Count) archivos en Serenity"

    foreach ($file in $serenityFiles) {
        $relativePath = $file.FullName.Replace("$((Get-Location).Path)\$BuildFolder\serenity\", "").Replace("\", "/")
        $blobName = "$BuildFolder/serenity/$relativePath"

        Write-Host "Subiendo: $blobName"
        az storage blob upload `
            --account-name $StorageAccount `
            --container-name '$web' `
            --file $file.FullName `
            --name $blobName `
            --auth-mode key `
            --account-key $StorageKey `
            --overwrite
    }
    Write-Host "✅ Todos los archivos de Serenity subidos" -ForegroundColor Green

    # 3.3 Subir archivos de JaCoCo si existen
    if (Test-Path "./$BuildFolder/jacoco") {
        Write-Host "`nSubiendo archivos de JaCoCo..."
        $jacocoFiles = Get-ChildItem "./$BuildFolder/jacoco" -Recurse -File
        Write-Host "Encontrados $($jacocoFiles.Count) archivos en JaCoCo"

        foreach ($file in $jacocoFiles) {
            $relativePath = $file.FullName.Replace("$((Get-Location).Path)\$BuildFolder\jacoco\", "").Replace("\", "/")
            $blobName = "$BuildFolder/jacoco/$relativePath"

            Write-Host "Subiendo: $blobName"
            az storage blob upload `
                --account-name $StorageAccount `
                --container-name '$web' `
                --file $file.FullName `
                --name $blobName `
                --auth-mode key `
                --account-key $StorageKey `
                --overwrite
        }
        Write-Host "✅ Todos los archivos de JaCoCo subidos" -ForegroundColor Green
    }

    # 4. Verificar archivos en Azure
    Write-Host "`n=== VERIFICANDO ARCHIVOS EN AZURE ==="

    Write-Host "Archivos en la carpeta $BuildFolder/serenity:"
    az storage blob list `
        --account-name $StorageAccount `
        --container-name '$web' `
        --prefix "$BuildFolder/serenity/" `
        --auth-mode key `
        --account-key $StorageKey `
        --query "[].name" --output tsv

    Write-Host "`nVerificando archivos críticos en Azure:"
    $criticalBlobs = @(
        "$BuildFolder/serenity/index.html",
        "$BuildFolder/serenity/serenity.css",
        "index.html"
    )

    foreach ($blob in $criticalBlobs) {
        $exists = az storage blob exists `
            --account-name $StorageAccount `
            --container-name '$web' `
            --name $blob `
            --auth-mode key `
            --account-key $StorageKey `
            --query "exists" --output tsv

        if ($exists -eq "true") {
            Write-Host "✅ $blob EXISTE en Azure" -ForegroundColor Green
        } else {
            Write-Host "❌ $blob NO EXISTE en Azure" -ForegroundColor Red
        }
    }

} catch {
    Write-Host "❌ Error durante la subida: $($_.Exception.Message)" -ForegroundColor Red
    exit 1
}

Write-Host "`n=== DEPLOY COMPLETADO EXITOSAMENTE ===" -ForegroundColor Green
Write-Host "URLs de acceso:"
Write-Host "🌐 Portal Principal: https://$StorageAccount.z6.web.core.windows.net/"
Write-Host "📊 Reporte Serenity: https://$StorageAccount.z6.web.core.windows.net/$BuildFolder/serenity/index.html"
Write-Host "📈 Reporte JaCoCo: https://$StorageAccount.z6.web.core.windows.net/$BuildFolder/jacoco/index.html"