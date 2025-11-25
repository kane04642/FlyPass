Write-Host "🌐 Generando Portal Maestro..."

$BuildFolder = $env:BUILD_FOLDER
$BuildName   = $env:BUILD_NAME

if ([string]::IsNullOrWhiteSpace($BuildFolder)) {
    Write-Host "❌ ERROR: BUILD_FOLDER no está definido."
    exit 1
}

if ([string]::IsNullOrWhiteSpace($BuildName)) {
    Write-Host "❌ ERROR: BUILD_NAME no está definido."
    exit 1
}

$path = Join-Path $BuildFolder "portal-maestro.html"

$html = @"
<html>
<head><title>Portal Maestro</title></head>
<body>
<h1>Portal Maestro - $BuildName</h1>
<p>Reporte consolidado.</p>
</body>
</html>
"@

Set-Content -Path $path -Value $html -Encoding UTF8

Write-Host "✅ Portal Maestro generado en: $path"
