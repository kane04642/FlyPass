# .github/scripts/generate-portal.ps1
param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$CommitSha,
    [string]$SerenityExists,
    [string]$JacocoExists
)

# Convertir los parámetros string a booleanos
$SerenityExistsBool = $SerenityExists -eq "True"
$JacocoExistsBool = $JacocoExists -eq "True"

$fecha = Get-Date -Format 'yyyy-MM-dd HH:mm:ss'

Write-Host "Generando portal para: $BuildName"
Write-Host "Carpeta: $BuildFolder"
Write-Host "Serenity existe: $SerenityExistsBool"
Write-Host "JaCoCo existe: $JacocoExistsBool"

$html = @"
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portal de Reportes - Oficina Virtual</title>
    <style>
        body {
            font-family: "Segoe UI", Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 40px 20px;
        }
        .header {
            text-align: center;
            color: white;
            margin-bottom: 40px;
        }
        .header h1 {
            font-size: 2.5em;
            margin-bottom: 10px;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.3);
        }
        .current-build {
            background: white;
            border-radius: 15px;
            padding: 30px;
            margin-bottom: 30px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
            border-left: 5px solid #27ae60;
        }
        .btn {
            display: inline-block;
            background: #3498db;
            color: white;
            padding: 12px 25px;
            text-decoration: none;
            border-radius: 25px;
            font-weight: bold;
            margin: 10px 5px;
            transition: all 0.3s ease;
        }
        .btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
        }
        .btn-success {
            background: #27ae60;
        }
        .btn-success:hover {
            background: #219653;
        }
        .btn-warning {
            background: #f39c12;
        }
        .btn-warning:hover {
            background: #e67e22;
        }
        .build-info {
            background: #f8f9fa;
            padding: 15px;
            border-radius: 8px;
            margin: 15px 0;
        }
        .file-status {
            margin-top: 10px;
        }
        .status-ok {
            color: #27ae60;
            font-weight: bold;
        }
        .status-missing {
            color: #e74c3c;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Portal de Reportes de Pruebas</h1>
            <p>Ejecuciones automatizadas - Oficina Virtual</p>
        </div>

        <div class="current-build">
            <h2>Ejecucion Mas Reciente</h2>
            <div class="build-info">
                <p><strong>Nombre:</strong> $BuildName</p>
                <p><strong>Commit:</strong> $CommitSha</p>
                <p><strong>Fecha:</strong> $fecha</p>
                <p><strong>Carpeta:</strong> $BuildFolder</p>
            </div>

            <div class="file-status">
"@

if ($SerenityExistsBool) {
    $html += "<a href=`"$BuildFolder/serenity/index.html`" class=`"btn btn-success`" target=`"_blank`">Reporte Serenity Completo</a>"
} else {
    $html += '<span class="status-missing">Reporte Serenity no disponible</span>'
}

if ($JacocoExistsBool) {
    $html += "<a href=`"$BuildFolder/jacoco/index.html`" class=`"btn btn-warning`" target=`"_blank`">Cobertura de Codigo JaCoCo</a>"
} else {
    $html += '<span class="status-missing">Reporte JaCoCo no disponible</span>'
}

$html += @"
            </div>
        </div>

        <div style="text-align: center; color: white;">
            <p><em>Cada ejecucion se conserva en una carpeta independiente con nombre descriptivo</em></p>
            <p>Portal generado el: $fecha</p>
        </div>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function() {
            const links = document.querySelectorAll("a.btn");
            links.forEach(link => {
                link.addEventListener("click", function(e) {
                    const href = this.getAttribute("href");
                    console.log("Navegando a:", href);
                });
            });
        });
    </script>
</body>
</html>
"@

$html | Out-File -FilePath "./index.html" -Encoding UTF8
Write-Host "Portal principal generado exitosamente"