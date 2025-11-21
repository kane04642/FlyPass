param(
    [string]$BuildFolder,
    [string]$StorageAccount,
    [string]$SasToken
)

Write-Host "🚀 Iniciando carga a Azure Static Website..."
Write-Host "📁 Carpeta local: $BuildFolder"
Write-Host "☁️ Storage Account: $StorageAccount"

if (-not (Test-Path $BuildFolder)) {
    Write-Error "❌ No existe la carpeta a subir: $BuildFolder"
    exit 1
}

# Endpoint de Static Website
$baseUrl = "https://$StorageAccount.z20.web.core.windows.net"

$files = Get-ChildItem -Path $BuildFolder -Recurse -File

foreach ($file in $files) {

    # Ruta relativa dentro del contenedor $web
    $relativePath = $file.FullName.Replace((Resolve-Path $BuildFolder), "").TrimStart("\").Replace("\", "/")

    $uploadUrl = "$baseUrl/$relativePath`?$SasToken"

    Write-Host "⬆️ Subiendo: $relativePath"

    $headers = @{
        "x-ms-blob-type" = "BlockBlob"
    }

    try {
        Invoke-RestMethod -Method Put `
            -Uri $uploadUrl `
            -Headers $headers `
            -InFile $file.FullName `
            -ContentType "application/octet-stream"

        Write-Host "   ✔ OK"

    } catch {
        Write-Host "   ❌ Error subiendo ${relativePath}: $_"
    }
}

Write-Host "🎉 Carga completada correctamente."
