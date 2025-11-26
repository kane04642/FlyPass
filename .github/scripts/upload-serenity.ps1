param(
    [string]$StorageAccount,
    [string]$SasToken,
    [string]$SourceFolder
)

Write-Host "🚀 Subiendo TODOS los archivos de Serenity a AZURE Static Website..."

# Normalizar SAS
if ($SasToken.StartsWith("?") -eq $false) {
    $SasToken = "?" + $SasToken
}

$container = '$web'

# Convertir SourceFolder a ruta absoluta real
$absoluteSource = Resolve-Path $SourceFolder
$absoluteSource = $absoluteSource.Path

Write-Host "📁 Carpeta absoluta origen: $absoluteSource"

# Obtener todos los archivos del reporte
$files = Get-ChildItem -Path $absoluteSource -Recurse -File

foreach ($file in $files) {

    # Ruta relativa correcta, sin unidad ni drive
    $relativePath = $file.FullName.Replace($absoluteSource, "").TrimStart('\','/')

    # Subcarpeta "serenity/"
    $relativePath = "serenity/" + $relativePath

    Write-Host "📤 Subiendo: $relativePath"

    # Leer bytes
    $bytes = [System.IO.File]::ReadAllBytes($file.FullName)

    # Construir URL final
    $blobUrl = "https://$StorageAccount.blob.core.windows.net/$container/$relativePath$SasToken"

    # Headers
    $headers = @{
        "x-ms-blob-type" = "BlockBlob"
        "Content-Type"   = "application/octet-stream"
    }

    try {
        Invoke-RestMethod -Uri $blobUrl -Method Put -Headers $headers -Body $bytes
    }
    catch {
        Write-Host "❌ ERROR SUBIENDO ARCHIVO $relativePath"
        Write-Host $_.Exception.Message
        exit 1
    }
}

Write-Host "🎉 Reporte Serenity SUBIDO:"
Write-Host "👉 https://$StorageAccount.z20.web.core.windows.net/serenity/index.html"
