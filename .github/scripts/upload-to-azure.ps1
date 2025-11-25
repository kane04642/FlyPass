param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$StorageAccount,
    [string]$SasToken
)

Write-Host "🚀 Subiendo portal a Azure Static Website (sin eliminar archivos previos)..."

# Validaciones mínimas
if (-not (Test-Path $BuildFolder)) {
    Write-Host "❌ ERROR: La carpeta del build no existe: $BuildFolder"
    exit 1
}

if ([string]::IsNullOrWhiteSpace($StorageAccount)) {
    Write-Host "❌ ERROR: No se especificó StorageAccount"
    exit 1
}

if ([string]::IsNullOrWhiteSpace($SasToken)) {
    Write-Host "❌ ERROR: No se especificó SasToken"
    exit 1
}

Write-Host "📁 Carpeta a subir: $BuildFolder"
Write-Host "🌐 Storage Account: $StorageAccount"

# === Descargar AZCOPY ===
Write-Host "⬇️ Descargando AzCopy..."
Invoke-WebRequest -Uri "https://aka.ms/downloadazcopy-v10-windows" -OutFile "azcopy.zip"
Expand-Archive azcopy.zip -DestinationPath "./aztools" -Force

$AzCopyExe = (Get-ChildItem -Path "./aztools" -Recurse -Filter "azcopy.exe").FullName
Unblock-File -Path $AzCopyExe

# === Destino ===
$Destination = "https://$StorageAccount.blob.core.windows.net/`$web?$SasToken"

Write-Host "📌 Destino Azure: $Destination"

# === SUBIR SIN BORRAR, SIN LISTAR ===
Write-Host "📤 Subiendo nueva versión SIN eliminar contenido previo..."
& $AzCopyExe copy "$BuildFolder/*" "$Destination" --recursive=true --overwrite=true --log-level=INFO

Write-Host "🎉 Publicación finalizada (sin borrar archivos previos)"
Write-Host "🌍 Portal accesible en: https://$StorageAccount.z20.web.core.windows.net"
