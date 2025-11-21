param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$Storage
)

Write-Host "📄 Generando HTML principal..."

# Plantilla HTML
$html = @"
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Reportes - Oficina Virtual</title>
<style>
body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
.container { max-width: 800px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px; }
h1 { color: #2c3e50; }
.btn { display: inline-block; padding: 10px 20px; margin: 10px; background: #3498db; color: white; text-decoration: none; border-radius: 4px; }
.btn-success { background: #27ae60; }
.btn-warning { background: #f39c12; }
</style>
</head>

<body>
<div class="container">
<h1>Reportes de Pruebas Automatizadas</h1>
<p><strong>Build:</strong> $BuildName</p>
<p><strong>Fecha:</strong> $(Get-Date)</p>

<div>
<a href="https://$Storage.z20.web.core.windows.net/$BuildFolder/serenity/index.html" class="btn btn-success">Reporte Serenity</a>
<a href="https://$Storage.z20.web.core.windows.net/$BuildFolder/jacoco/index.html" class="btn btn-warning">Reporte Jacoco</a>
<a href="https://$Storage.z20.web.core.windows.net/$BuildFolder/diagnostic.html" class="btn">Diagnóstico</a>
</div>

</div>
</body>
</html>
"@

# Guardar archivo
$path = Join-Path $BuildFolder "index.html"
Set-Content -Path $path -Value $html -Encoding UTF8

Write-Host "✅ Archivo generado: $path"
