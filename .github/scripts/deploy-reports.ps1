param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$StorageAccount,
    [string]$StorageKey
)

Write-Host "=== DEPLOY OPTIMIZADO INICIADO ==="
Write-Host "Build: $BuildName"
Write-Host "Carpeta: $BuildFolder"

# 1. Verificación rápida de archivos críticos
Write-Host "`n=== VERIFICACIÓN RÁPIDA ==="
$criticalFiles = @(
    "./$BuildFolder/serenity/index.html",
    "./$BuildFolder/serenity/serenity.css",
    "./$BuildFolder/jacoco/index.html"
)

foreach ($file in $criticalFiles) {
    if (Test-Path $file) {
        Write-Host "✅ $(Split-Path $file -Leaf)" -ForegroundColor Green
    } else {
        Write-Host "❌ $(Split-Path $file -Leaf)" -ForegroundColor Red
    }
}

# 2. Generar portal principal (versión simplificada)
Write-Host "`n=== GENERANDO PORTAL ==="
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Reportes de Pruebas Automatizadas</h1>
        <p><strong>Build:</strong> $BuildName</p>
        <p><strong>Fecha:</strong> $fecha</p>
        <div>
            <a href="$BuildFolder/serenity/index.html" class="btn btn-success">Reporte Serenity</a>
            <a href="$BuildFolder/jacoco/index.html" class="btn btn-warning">Reporte JaCoCo</a>
        </div>
    </div>
</body>
</html>
"@

$htmlContent | Out-File -FilePath "./index.html" -Encoding UTF8
Write-Host "✅ Portal generado"

# 3. Subida optimizada a Azure
Write-Host "`n=== SUBIENDO A AZURE (MÉTODO OPTIMIZADO) ==="

try {
    # 3.1 Subir portal principal
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
    Write-Host "✅ Portal subido" -ForegroundColor Green

    # 3.2 Subir TODA la carpeta build de una vez con upload-batch
    Write-Host "Subiendo carpeta de reportes (método batch)..."
    az storage blob upload-batch `
        --account-name $StorageAccount `
        --destination '$web' `
        --source "./$BuildFolder" `
        --auth-mode key `
        --account-key $StorageKey `
        --overwrite `
        --only-show-errors

    Write-Host "✅ Todos los archivos subidos" -ForegroundColor Green

    # 4. Verificación rápida en Azure
    Write-Host "`n=== VERIFICACIÓN EN AZURE ==="

    # Verificar solo archivos críticos
    $criticalBlobs = @(
        "$BuildFolder/serenity/index.html",
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
            Write-Host "✅ $blob" -ForegroundColor Green
        } else {
            Write-Host "❌ $blob" -ForegroundColor Red
        }
    }

} catch {
    Write-Host "❌ Error: $($_.Exception.Message)" -ForegroundColor Red
    exit 1
}

Write-Host "`n=== DEPLOY COMPLETADO ===" -ForegroundColor Green
Write-Host "🌐 Portal: https://$StorageAccount.z6.web.core.windows.net/"
Write-Host "📊 Serenity: https://$StorageAccount.z6.web.core.windows.net/$BuildFolder/serenity/index.html"
Write-Host "📈 JaCoCo: https://$StorageAccount.z6.web.core.windows.net/$BuildFolder/jacoco/index.html"