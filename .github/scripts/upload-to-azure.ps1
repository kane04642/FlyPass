param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$StorageAccount,
    [string]$SasToken
)

Write-Host "🚀 Subiendo portal a Azure Static Website usando AZCOPY..."

# ===== VALIDACIONES =====
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

# ===== DESCARGAR AZCOPY =====
Write-Host "⬇️ Descargando AzCopy..."

Invoke-WebRequest -Uri "https://aka.ms/downloadazcopy-v10-windows" -OutFile "azcopy.zip"
Expand-Archive azcopy.zip -DestinationPath "./azcopy" -Force

$AzCopyExe = (Get-ChildItem -Path "./azcopy" -Recurse -Filter "azcopy.exe").FullName

Write-Host "✔ AzCopy listo en: $AzCopyExe"

# ===== DEFINIR DESTINO =====
$Destination = "https://$StorageAccount.blob.core.windows.net/`$web?$SasToken"

Write-Host "📌 Destino Azure: $Destination"

# ===== ELIMINAR ARCHIVOS ANTIGUOS DEL $web =====
Write-Host "🧹 Eliminando contenido anterior del sitio..."

& $AzCopyExe rm $Destination --recursive=true

Write-Host "✔ Contenido anterior eliminado."

# ===== SUBIR NUEVO CONTENIDO =====
Write-Host "📤 Subiendo nueva versión del portal..."

& $AzCopyExe copy "$BuildFolder/*" "$Destination" --recursive=true

Write-Host "🎉 Publicación completada correctamente."
Write-Host "🌍 URL DEL PORTAL ACTUALIZADO:"
Write-Host "👉 https://$StorageAccount.z20.web.core.windows.net"
