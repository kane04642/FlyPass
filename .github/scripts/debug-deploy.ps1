param(
    [string]$BuildName,
    [string]$BuildFolder,
    [string]$StorageAccount,
    [string]$SasToken
)

Write-Host "-------------------------------------------"
Write-Host "🏗️  Iniciando proceso de despliegue"
Write-Host "-------------------------------------------"
Write-Host "📦 Build: $BuildName"
Write-Host "📁 Carpeta: $BuildFolder"
Write-Host "☁️  Storage Account: $StorageAccount"
Write-Host "-------------------------------------------"

# Validar carpeta del build
if (-not (Test-Path $BuildFolder)) {
    Write-Error "❌ Carpeta de build no encontrada: $BuildFolder"
    exit 1
}

# Solo copiar Serenity
if (Test-Path "target/site/serenity") {
    Write-Host "📁 Copiando reportes Serenity..."
    Copy-Item "target/site/serenity" "$BuildFolder/serenity" -Recurse -Force
} else {
    Write-Host "⚠ No existe target/site/serenity — nada para copiar."
}

# (Jacoco eliminado completamente, no se copia nada)

# Generar diagnóstico
$diagnosticPath = Join-Path $BuildFolder "diagnostic.html"
$diagnosticHtml = @"
<html>
<body>
<h2>Diagnóstico de Ejecución</h2>
<p>Build: $BuildName</p>
<p>Fecha: $(Get-Date)</p>
<p>Resultado: OK</p>
</body>
</html>
"@

Set-Content -Path $diagnosticPath -Value $diagnosticHtml -Encoding UTF8
Write-Host "📝 Archivo de diagnóstico generado: $diagnosticPath"

Write-Host "-------------------------------------------"
Write-Host "🚀 Despliegue listo para subir a Azure"
Write-Host "-------------------------------------------"
