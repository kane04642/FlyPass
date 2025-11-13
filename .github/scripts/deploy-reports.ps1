param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$StorageAccount,
    [string]$SasToken
)

Write-Host "-------------------------------------------"
Write-Host "🏗️  Iniciando proceso de despliegue debug"
Write-Host "-------------------------------------------"
Write-Host "📦 Build: $BuildName"
Write-Host "📁 Carpeta: $BuildFolder"
Write-Host "☁️  Cuenta de almacenamiento: $StorageAccount"
Write-Host "-------------------------------------------"

# Validar parámetros
if (-not (Test-Path $BuildFolder)) {
    Write-Error "❌ Carpeta de build no encontrada: $BuildFolder"
    exit 1
}

# Simular despliegue a Azure Blob Storage (puedes reemplazarlo por Azure CLI real)
Write-Host "🔄 Subiendo archivos a contenedor Azure Storage..."
Start-Sleep -Seconds 3
Write-Host "✅ Archivos de $BuildFolder listos para cargar en $StorageAccount con SAS token."

# Generar diagnóstico (ejemplo simple)
$diagnosticPath = Join-Path $BuildFolder "diagnostic.html"
$htmlDiag = @"
<html><body>
<h2>Diagnóstico de Ejecución</h2>
<p>Build: $BuildName</p>
<p>Hora de ejecución: $(Get-Date)</p>
<p>Resultado: ✅ Éxito</p>
</body></html>
"@
Set-Content -Path $diagnosticPath -Value $htmlDiag -Encoding UTF8

Write-Host "✅ Archivo de diagnóstico generado: $diagnosticPath"
Write-Host "-------------------------------------------"
Write-Host "🚀 Despliegue completado con éxito."
