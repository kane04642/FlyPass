param(
    [string]$BuildsListJson,
    [string]$OutputFile
)

Write-Host "🧩 Generando portal maestro..."

# Convertir JSON a lista de builds
$builds = $BuildsListJson | ConvertFrom-Json

# Ordenar por fecha descendente
$builds = $builds | Sort-Object Fecha -Descending

# Construir HTML
$html = @"
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Reportes - Portal Maestro</title>

<style>
body { font-family: Arial, sans-serif; background: #eef2f3; padding: 40px; }
.container { max-width: 900px; margin: auto; background: white; padding: 30px; border-radius: 12px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
h1 { color: #2c3e50; }
table { width: 100%; border-collapse: collapse; margin-top: 20px; }
th, td { padding: 14px; border-bottom: 1px solid #ddd; }
th { background: #3498db; color: white; }
a { color: #2980b9; text-decoration: none; font-weight: bold; }
a:hover { text-decoration: underline; }
tr:hover { background: #f9f9f9; }
</style>

</head>
<body>

<div class="container">
<h1>📊 Portal Maestro - Reportes Oficina Virtual</h1>
<p>Listado de todas las ejecuciones subidas al Azure Static Website.</p>

<table>
<thead>
<tr>
<th>Build</th>
<th>Fecha</th>
<th>SHA</th>
<th>Reportes</th>
</tr>
</thead>
<tbody>
"@

foreach ($b in $builds) {

    $serenity = "https://$($b.Storage).z20.web.core.windows.net/$($b.Carpeta)/serenity/index.html"
    $jacoco   = "https://$($b.Storage).z20.web.core.windows.net/$($b.Carpeta)/jacoco/index.html"
    $diag     = "https://$($b.Storage).z20.web.core.windows.net/$($b.Carpeta)/diagnostic.html"

    $html += @"
<tr>
<td>$($b.Nombre)</td>
<td>$($b.Fecha)</td>
<td>$($b.SHA)</td>
<td>
    <a href='$serenity' target='_blank'>Serenity</a> |
    <a href='$jacoco' target='_blank'>Jacoco</a> |
    <a href='$diag' target='_blank'>Diagnóstico</a>
</td>
</tr>
"@
}

$html += @"
</tbody>
</table>

</div>
</body>
</html>
"@

Set-Content -Path $OutputFile -Value $html -Encoding UTF8

Write-Host "✅ Portal maestro generado: $OutputFile"
