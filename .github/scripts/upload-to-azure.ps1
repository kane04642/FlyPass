param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$StorageAccount,
    [string]$SasToken
)

Write-Host "🚀 Subiendo portal a Azure Static Website usando AZCOPY..."

if ([string]::IsNullOrWhiteSpace($BuildFolder) -or -not (Test-Path $BuildFolder)) {
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

# === Descargar AzCopy ===
Write-Host "⬇️ Descargando AzCopy..."
Invoke-WebRequest -Uri "https://aka.ms/downloadazcopy-v10-windows" -OutFile "azcopy.zip"
Expand-Archive azcopy.zip -DestinationPath "./azcopy" -Force

$AzCopyExe = (Get-ChildItem -Path "./azcopy" -Recurse -Filter "azcopy.exe").FullName
Write-Host "✔ AzCopy localizado en: $AzCopyExe"

# === Definir destino ===
$Destination = "https://$StorageAccount.blob.core.windows.net/`$web?$SasToken"
Write-Host "📌 Destino Azure: $Destination"

# === Eliminar archivos previos ===
Write-Host "🧹 Limpiando destino anterior..."
& $AzCopyExe rm $Destination --recursive=true

# === Subir nuevos archivos ===
Write-Host "📤 Subiendo nueva versión..."
& $AzCopyExe copy "$BuildFolder/*" "$Destination" --recursive=true

Write-Host "🎉 Publicación finalizada."
Write-Host "🌍 Portal actualizado: https://$StorageAccount.z20.web.core.windows.net"
