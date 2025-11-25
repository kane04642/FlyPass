Write-Host "🗂 Preparando carpetas del build OV..."

# ==== LEER VARIABLES DEL PIPELINE ====
$BuildFolder = $env:BUILD_FOLDER

if ([string]::IsNullOrWhiteSpace($BuildFolder)) {
    Write-Host "❌ ERROR: La variable BUILD_FOLDER no está definida."
    exit 1
}

Write-Host "📁 Carpeta base: $BuildFolder"

# ==== ELIMINAR CARPETA SI EXISTE ====
if (Test-Path $BuildFolder) {
    Write-Host "🔄 Eliminando carpeta existente..."
    Remove-Item -Recurse -Force $BuildFolder
}

# ==== CREAR ESTRUCTURA ====
Write-Host "📁 Creando carpetas..."

New-Item -ItemType Directory -Force -Path $BuildFolder | Out-Null
New-Item -ItemType Directory -Force -Path "$BuildFolder/serenity" | Out-Null
New-Item -ItemType Directory -Force -Path "$BuildFolder/jacoco" | Out-Null
New-Item -ItemType Directory -Force -Path "$BuildFolder/html" | Out-Null

Write-Host "✅ Carpetas preparadas correctamente:"
Write-Host "   - $BuildFolder"
Write-Host "   - $BuildFolder/serenity"
Write-Host "   - $BuildFolder/jacoco"
Write-Host "   - $BuildFolder/html"
