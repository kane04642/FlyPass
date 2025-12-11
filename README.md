# 🧪 Automatización Web — FlyPass
    Framework de automatización desarrollado en **Java 17**, utilizando **Serenity BDD**, **Screenplay**, **Cucumber**, **Gradle**, y el patrón **Page Object Model (POM)**.  

    
    ---

## 🚀 Tecnologías y Herramientas Utilizadas

    | Componente | Versión / Detalle |
    |-----------|-------------------|
    | **Java** | 17 |
    | **Gradle** | Wrapper incluido |
    | **Serenity BDD** | 4.x (Screenplay + Cucumber + JUnit5) |
    | **Cucumber** | Integrado con Serenity |
    | **POM + Screenplay Pattern** | Implementados |
    | **IntelliJ IDEA** | IDE principal |
    | **Chrome WebDriver** | Configurado vía `serenity.conf` |
    BDD (Gherkin)** | Features en español

## 📁 Estructura del Proyecto
        src
        ├── main
        │ └── java/com/saucedemo/f2x
        │ ├── constantes
        │ ├── interactions
        │ ├── questions
        │ ├── tasks
        │ └── userinterface
        │
        └── test
        ├── java/com/saucedemo/f2x
        │ ├── runners
        │ └── stepdefinitions
        │ ├── hooks
        │
        └── resources/features
        ├── Login.feature

---

## 🧱 Arquitectura del Framework

### 🔹 **Screenplay Pattern**
    Implementa:
    - Actors
      - Tasks
      - Interactions
      - Questions
      - Targets (Page Objects mejorados)
    
    Ventajas:
    - Reutilización
      - Bajo acoplamiento
      - Escalabilidad

### 🔹 **Page Object Model (POM)**
        Los componentes visuales están gestionados usando `Target` dentro del paquete

### 🔹 **BDD con Cucumber**
    Los escenarios siguen Gherkin y están ubicados en:
            src/test/resources/features/


Los step definitions orquestan las interacciones con Screenplay.
---

## ⚙️ Configuración WebDriver — `serenity.conf`

    El navegador configurado es **Chrome**, con:
    
    - Modo incógnito
      - Ventana maximizada
      - Certificados inseguros permitidos
      - Media stream simulado
      - Notificaciones bloqueadas
      - Manejo avanzado de alertas
      - Timeouts personalizados

### Ambientes configurados:
        default
        qa
        dev

---
    
    ## 🏗️ build.gradle — Configuraciones principales
    
    Incluye:
    - Serenity Core
      - Serenity Screenplay
      - Serenity Screenplay Webdriver
      - Cucumber
      - JUnit4 + JUnit5
      - Slf4j
      - SonarQube
      - JaCoCo
      - Java 17
    
    Reportes generados automáticamente:  
    ✔ Serenity  
    ✔ JaCoCo (XML + HTML)

---

        ## ▶️ Ejecución del Proyecto
        
        ### 1️⃣ Ejecutar todos los escenarios
        ```bash
        gradlew clean test aggregate
        --ejecutar con un ambiente especifico        
        gradlew clean test -Denvironment=qa
        4️⃣ Modo silencioso
        gradlew clean test -q
        📊 Reportes
        ✔ Serenity Report
        Ruta:
        target/site/serenity/index.html

## 🧱 Estrategia de CI/CD Basada en GitHub Actions para la Automatización de Pruebas
- Objetivos:
Integración continua ante cada push y pull request a la rama main.
Ejecución de pruebas funcionales automatizadas.
Generación y publicación de reportes Serenity y logs.
Preparación automática del entorno (Java, Gradle).
Validación del estado del build (aprobado o fallido)
✔ Paso 1: Checkout del repositorio
GitHub Actions descarga el código fuente para preparar el ambiente:
✔ Paso 2: Configuración del entorno Java (JDK 17)
El pipeline asegura que la automatización se ejecute con la versión correcta de Java:
✔ Paso 3: Permisos para Gradle Wrapper
✔ Paso 4: Limpieza de reportes previos: Garantiza que los reportes de Serenity no se mezclen con ejecuciones previas.
✔ Paso 5: Ejecución de pruebas automatizadas
✔ Paso 6: Publicación del Reporte Serenity
✔ Paso 7: Publicación de logs y reportes adicionales

    👤 Autor
    
    Daniel Contreras
    QA Automation Engineer

    14+ años de experiencia en QA Manual & Automation

