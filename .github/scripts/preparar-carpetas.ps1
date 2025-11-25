Write-Host "🔧 Preparando carpetas del build OV..."

$buildFolder = "build-ov"

# Eliminar si existe
if (Test-Path $buildFolder) {
    Remove-Item -Recurse -Force $buildFolder
}

# Crear estructura
New-Item -ItemType Directory -Force -Path $buildFolder
New-Item -ItemType Directory -Force -Path "$buildFolder/serenity"
New-Item -ItemType Directory -Force -Path "$buildFolder/jacoco"
New-Item -ItemType Directory -Force -Path "$buildFolder/html"

Write-Host "📁 Carpetas preparadas correctamente:"
Write-Host "- $buildFolder/serenity"
Write-Host "- $buildFolder/jacoco"
Write-Host "- $buildFolder/html"
