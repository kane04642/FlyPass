Write-Host "📄 Generando HTML principal..."

# === OBTENER VARIABLE DEL PIPELINE ===
$BuildFolder = $env:BUILD_FOLDER

if ([string]::IsNullOrWhiteSpace($BuildFolder)) {
    Write-Host "❌ ERROR: La variable BUILD_FOLDER no está definida."
    exit 1
}

# Crear carpeta si no existe
if (-not (Test-Path $BuildFolder)) {
    New-Item -ItemType Directory -Force -Path $BuildFolder
}

# Construir ruta final
$path = Join-Path $BuildFolder "index.html"

# Contenido HTML base
$html = @"
<html>
<head>
<title>Portal OV</title>
</head>
<body>
<h1>Portal OV</h1>
<p>Reporte generado automáticamente.</p>
</body>
</html>
"@

# Generar archivo
Set-Content -Path $path -Value $html -Encoding UTF8

Write-Host "✅ Archivo generado en: $path"
