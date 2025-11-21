param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$StorageAccount,
    [string]$SasToken
)

Write-Host "-------------------------------------------"
Write-Host "🏗️  Iniciando proceso de despliegue debug"
Write-Host "-------------------------------------------"
Write-Host "📦 Build: $BuildName"
Write-Host "📁 Carpeta: $BuildFolder"
Write-Host "☁️  Storage: $StorageAccount"
Write-Host "-------------------------------------------"

if (-not (Test-Path $BuildFolder)) {
    Write-Error "❌ Carpeta no encontrada: $BuildFolder"
    exit 1
}

Write-Host "🔄 Generando diagnóstico..."
$diagnosticPath = Join-Path $BuildFolder "diagnostic.html"

$htmlDiag = @"
<html><body>
<h2>Diagnóstico de Ejecución</h2>
<p>Build: $BuildName</p>
<p>Fecha: $(Get-Date)</p>
<p>Resultado: OK</p>
</body></html>
"@

Set-Content -Path $diagnosticPath -Value $htmlDiag -Encoding UTF8

Write-Host "✅ Archivo diagnostic.html generado"
Write-Host "-------------------------------------------"
Write-Host "🚀 Fin del proceso debug"
