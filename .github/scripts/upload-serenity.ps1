param(
    [string]$StorageAccount,
    [string]$SasToken,
    [string]$SourceFolder
)

Write-Host "🚀 Subiendo reporte Serenity al Azure Static Website..."

# Convertir SAS a formato correcto (agregar ? al inicio si falta)
if ($SasToken.StartsWith("?") -eq $false) {
    $SasToken = "?" + $SasToken
}

$container = "\$web"

# SERENITY REPORT DIRECTORIO
$indexFile = Join-Path $SourceFolder "index.html"

if (!(Test-Path $indexFile)) {
    Write-Host "❌ ERROR: No se encontró el archivo index.html de Serenity en $SourceFolder"
    exit 1
}

Write-Host "📄 Archivo Serenity encontrado: $indexFile"

# Leer contenido del index
$fileContent = Get-Content -Path $indexFile -Raw
$byteArray = [System.Text.Encoding]::UTF8.GetBytes($fileContent)

# Construir URL final
$blobUrl = "https://$StorageAccount.blob.core.windows.net/$container/index.html$SasToken"

Write-Host "🌐 URL destino: $blobUrl"

# Headers obligatorios
$headers = @{
    "x-ms-blob-type" = "BlockBlob"
    "Content-Type"  = "text/html"
}

try {
    Invoke-RestMethod -Uri $blobUrl -Method Put -Headers $headers -Body $byteArray
    Write-Host "🎉 Serenity Report subido correctamente."
}
catch {
    Write-Host "❌ ERROR SUBIENDO ARCHIVO:"
    Write-Host $_
    exit 1
}
