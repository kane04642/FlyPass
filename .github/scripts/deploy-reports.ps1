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

$fecha = Get-Date -Format 'yyyy-MM-dd HH:mm:ss'

# Construir el HTML línea por línea sin usar here-strings
$htmlContent = "<!DOCTYPE html>`n"
$htmlContent += "<html>`n"
$htmlContent += "<head>`n"
$htmlContent += "    <meta charset=`"utf-8`">`n"
$htmlContent += "    <title>Reportes - Oficina Virtual</title>`n"
$htmlContent += "    <style>`n"
$htmlContent += "        body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }`n"
$htmlContent += "        .container { max-width: 800px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px; }`n"
$htmlContent += "        h1 { color: #2c3e50; }`n"
$htmlContent += "        .btn { display: inline-block; padding: 10px 20px; margin: 10px; background: #3498db; color: white; text-decoration: none; border-radius: 5px; }`n"
$htmlContent += "        .btn-success { background: #27ae60; }`n"
$htmlContent += "        .btn-warning { background: #f39c12; }`n"
$htmlContent += "    </style>`n"
$htmlContent += "</head>`n"
$htmlContent += "<body>`n"
$htmlContent += "    <div class=`"container`">`n"
$htmlContent += "        <h1>Reportes de Pruebas Automatizadas</h1>`n"
$htmlContent += "        <p><strong>Build:</strong> $BuildName</p>`n"
$htmlContent += "        <p><strong>Fecha:</strong> $fecha</p>`n"
$htmlContent += "        <div>`n"
$htmlContent += "            <a href=`"$BuildFolder/serenity/index.html`" class=`"btn btn-success`">Reporte Serenity</a>`n"
$htmlContent += "            <a href=`"$BuildFolder/jacoco/index.html`" class=`"btn btn-warning`">Reporte JaCoCo</a>`n"
$htmlContent += "        </div>`n"
$htmlContent += "    </div>`n"
$htmlContent += "</body>`n"
$htmlContent += "</html>`n"

$htmlContent | Out-File -FilePath "./index.html" -Encoding UTF8
Write-Host "Portal generado"

# Verificar archivos locales
Write-Host "Verificando archivos locales..."
if (Test-Path "./$BuildFolder/serenity/index.html") {
    Write-Host "✅ serenity/index.html existe"
} else {
    Write-Host "❌ serenity/index.html NO existe"
    Write-Host "Buscando archivos de Serenity..."
    Get-ChildItem -Path "." -Recurse -Filter "*serenity*" -Directory | ForEach-Object { Write-Host "Encontrado: $($_.FullName)" }
}

if (Test-Path "./$BuildFolder/jacoco/index.html") {
    Write-Host "✅ jacoco/index.html existe"
} else {
    Write-Host "⚠️ jacoco/index.html NO existe - Esto es normal si no hay cobertura"
}

# Subir a Azure
Write-Host "Subiendo a Azure Storage..."

try {
    # Subir portal principal
    Write-Host "Subiendo portal principal..."
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
    Write-Host "Subiendo carpeta de reportes..."
    az storage blob upload-batch `
        --account-name $StorageAccount `
        --destination '$web' `
        --source "./$BuildFolder" `
        --auth-mode key `
        --account-key $StorageKey `
        --overwrite
    Write-Host "✅ Carpeta build subida"

    # Verificar que los archivos están en Azure
    Write-Host "Verificando archivos en Azure..."
    az storage blob list `
        --account-name $StorageAccount `
        --container-name '$web' `
        --prefix "$BuildFolder/" `
        --auth-mode key `
        --account-key $StorageKey `
        --query "[].name" --output tsv

} catch {
    Write-Host "❌ Error: $($_.Exception.Message)"
    exit 1
}

Write-Host "=== DEPLOY COMPLETADO ==="