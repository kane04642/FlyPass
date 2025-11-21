param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$StorageAccount,
    [string]$SasToken
)

Write-Host "-------------------------------------------"
Write-Host "🏗️  Iniciando proceso de diagnóstico"
Write-Host "-------------------------------------------"
Write-Host "📦 Build: $BuildName"
Write-Host "📁 Carpeta: $BuildFolder"
Write-Host "☁️  Storage: $StorageAccount"
Write-Host "-------------------------------------------"

if (-not (Test-Path $BuildFolder)) {
    Write-Error "❌ Carpeta de build no encontrada: $BuildFolder"
    exit 1
}

Write-Host "🔄 Generando archivo diagnostic.html..."

$diagnosticPath = Join-Path $BuildFolder "diagnostic.html"

$htmlDiag = @"
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Diagnóstico de Ejecución</title>
</head>
<body>
<h2>Diagnóstico de Ejecución</h2>
<p>Build: $BuildName</p>
<p>Fecha: $(Get-Date)</p>
<p>Resultado: ✅ Éxito (modo debug)</p>
</body>
</html>
"@

Set-Content -Path $diagnosticPath -Value $htmlDiag -Encoding UTF8

Write-Host "✅ Archivo diagnostic.html generado: $diagnosticPath"
Write-Host "-------------------------------------------"
Write-Host "🚀 Fin del proceso debug"
