param(
    [string]$StorageAccount,
    [string]$SasToken,
    [string]$SourceFolder
)

Write-Host "🚀 Subiendo TODOS los archivos de Serenity a carpeta /serenity/ en Static Website..."

if ($SasToken.StartsWith("?") -eq $false) {
    $SasToken = "?" + $SasToken
}

$container = '$web'

if (!(Test-Path $SourceFolder)) {
    Write-Host "❌ ERROR: No existe la carpeta Serenity: $SourceFolder"
    exit 1
}

$files = Get-ChildItem -Path $SourceFolder -Recurse -File

foreach ($file in $files) {

    $relativePath = $file.FullName.Replace($SourceFolder, "").TrimStart("\","/")
    $relativePath = "serenity/" + $relativePath  # 📌 Subcarpeta obligatoria

    $blobUrl = "https://$StorageAccount.blob.core.windows.net/$container/$relativePath$SasToken"

    Write-Host "📤 Subiendo: $relativePath"

    $bytes = [System.IO.File]::ReadAllBytes($file.FullName)

    $headers = @{
        "x-ms-blob-type" = "BlockBlob"
        "Content-Type"   = "application/octet-stream"
    }

    try {
        Invoke-RestMethod -Uri $blobUrl -Method Put -Headers $headers -Body $bytes
    }
    catch {
        Write-Host "❌ ERROR SUBIENDO"
        Write-Host $_
        exit 1
    }
}

Write-Host "🎉 Reporte Serenity SUBIDO en:"
Write-Host "👉 https://$StorageAccount.z20.web.core.windows.net/serenity/index.html"
