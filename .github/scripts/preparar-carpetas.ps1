Write-Host "🗂 Preparando carpetas del build OV..."

$BuildFolder = $env:BUILD_FOLDER

if ([string]::IsNullOrWhiteSpace($BuildFolder)) {
    Write-Host "❌ ERROR: La variable BUILD_FOLDER no está definida."
    exit 1
}

Write-Host "📁 Carpeta base: $BuildFolder"

if (Test-Path $BuildFolder) {
    Write-Host "🔄 Eliminando carpeta existente..."
    Remove-Item -Recurse -Force $BuildFolder
}

Write-Host "📁 Creando estructura..."

New-Item -ItemType Directory -Force -Path $BuildFolder | Out-Null
New-Item -ItemType Directory -Force -Path "$BuildFolder/serenity" | Out-Null
New-Item -ItemType Directory -Force -Path "$BuildFolder/jacoco" | Out-Null
New-Item -ItemType Directory -Force -Path "$BuildFolder/html" | Out-Null

Write-Host "✅ Carpetas listas:"
Write-Host "   - $BuildFolder"
Write-Host "   - serenity/"
Write-Host "   - jacoco/"
Write-Host "   - html/"
