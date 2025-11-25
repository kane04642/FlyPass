param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$StorageAccount,
    [string]$SasToken
)

Write-Host "🚀 Subiendo a Azure..."

if (-not (Test-Path $BuildFolder)) {
    Write-Host "❌ ERROR: No existe la carpeta $BuildFolder"
    exit 1
}

Write-Host "📁 Carpeta a subir: $BuildFolder"
Write-Host "🌐 Storage Account: $StorageAccount"

# Aquí puedes agregar tu comando azcopy si lo deseas
Write-Host "✔ Simulación de carga completada"
