param(
    [string]$StorageAccount,
    [string]$SasToken,
    [string]$SourceFolder
)

Write-Host "🚀 Subiendo TODO el reporte Serenity al Azure Static Website..."

# Asegurar formato del SAS
if ($SasToken.StartsWith("?") -eq $false) {
    $SasToken = "?" + $SasToken
}

# Contenedor estático obligatorio
$container = '$web'

# Validar directorio origen
if (!(Test-Path $SourceFolder)) {
    Write-Host "❌ ERROR: No existe la carpeta de Serenity: $SourceFolder"
    exit 1
}

Write-Host "📁 Carpeta origen: $SourceFolder"

# Obtener todos los archivos del reporte (recursivo)
$files = Get-ChildItem -Path $SourceFolder -Recurse -File

foreach ($file in $files) {

    # Construir ruta relativa
    $relativePath = $file.FullName.Replace($SourceFolder, "").TrimStart("\","/")

    # Construir URL final
    $blobUrl = "https://$StorageAccount.blob.core.windows.net/$container/$relativePath$SasToken"

    Write-Host "📤 Subiendo: $relativePath"

    # Leer bytes
    $bytes = [System.IO.File]::ReadAllBytes($file.FullName)

    # Detectar MIME-Type
    $contentType = "application/octet-stream"
    $ext = $file.Extension.ToLower()

    switch ($ext) {
        ".html" { $contentType = "text/html" }
        ".js"   { $contentType = "application/javascript" }
        ".css"  { $contentType = "text/css" }
        ".json" { $contentType = "application/json" }
        ".png"  { $contentType = "image/png" }
        ".jpg"  { $contentType = "image/jpeg" }
        ".jpeg" { $contentType = "image/jpeg" }
        ".svg"  { $contentType = "image/svg+xml" }
        ".woff" { $contentType = "font/woff" }
        ".woff2"{ $contentType = "font/woff2" }
    }

    # Headers necesarios
    $headers = @{
        "x-ms-blob-type" = "BlockBlob"
        "Content-Type"   = $contentType
    }

    # Subir archivo
    try {
        Invoke-RestMethod -Uri $blobUrl -Method Put -Headers $headers -Body $bytes
    }
    catch {
        Write-Host "❌ ERROR al subir $relativePath"
        Write-Host $_
        exit 1
    }
}

Write-Host "🎉 Reporte Serenity COMPLETO subido exitosamente."
Write-Host "🌍 Disponible en: https://$StorageAccount.z20.web.core.windows.net/"
