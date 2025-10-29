param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$StorageAccount,
    [string]$StorageKey
)

Write-Host "=== INICIANDO DEPLOY DE REPORTES ==="
Write-Host "Build: $BuildName"
Write-Host "Carpeta: $BuildFolder"

# Generar portal principal
Write-Host "Generando portal principal..."
$portalContent = @'
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
        <p><strong>Build:</strong>
'@ + $BuildName + @'</p>
        <p><strong>Fecha:</strong>
'@ + (Get-Date -Format 'yyyy-MM-dd HH:mm:ss') + @'</p>
        <div>
            <a href="
'@ + $BuildFolder + @'/serenity/index.html" class="btn btn-success">Reporte Serenity</a>
            <a href="
'@ + $BuildFolder + @'/jacoco/index.html" class="btn btn-warning">Reporte JaCoCo</a>
        </div>
    </div>
</body>
</html>
'@

$portalContent | Out-File -FilePath "./index.html" -Encoding UTF8
Write-Host "Portal generado"

# Verificar archivos locales
Write-Host "Verificando archivos locales..."
if (Test-Path "./$BuildFolder/serenity/index.html") {
    Write-Host "✅ serenity/index.html existe"
} else {
    Write-Host "❌ serenity/index.html NO existe"
}

if (Test-Path "./$BuildFolder/jacoco/index.html") {
    Write-Host "✅ jacoco/index.html existe"
} else {
    Write-Host "❌ jacoco/index.html NO existe"
}

# Subir a Azure
Write-Host "Subiendo a Azure Storage..."

try {
    # Subir portal principal
    az storage blob upload `
        --account-name $StorageAccount `
        --container-name '$web' `
        --file "./index.html" `
        --name "index.html" `
        --auth-mode key `
        --account-key $StorageKey `
        --overwrite
    Write-Host "✅ Portal subido"

    # Subir carpeta build
    az storage blob upload-batch `
        --account-name $StorageAccount `
        --destination '$web' `
        --source "./$BuildFolder" `
        --auth-mode key `
        --account-key $StorageKey `
        --overwrite
    Write-Host "✅ Carpeta build subida"

} catch {
    Write-Host "❌ Error: $($_.Exception.Message)"
    exit 1
}

Write-Host "=== DEPLOY COMPLETADO ==="