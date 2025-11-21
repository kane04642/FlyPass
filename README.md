# 🧪 Automatización Web — Oficina Virtual (Calidda)
    Framework de automatización desarrollado en **Java 17**, utilizando **Serenity BDD**, **Screenplay**, **Cucumber**, **Gradle**, y el patrón **Page Object Model (POM)**.  
    Este proyecto automatiza los principales flujos funcionales del portal **Oficina Virtual** de Calidda.
    
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
        │ └── java/com/calidda/ov
        │ ├── constantes
        │ ├── interactions
        │ ├── questions
        │ ├── tasks
        │ └── userinterface
        │
        └── test
        ├── java/com/calidda/ov
        │ ├── runners
        │ └── stepdefinitions
        │ ├── consultaCupo
        │ ├── hooks
        │ ├── pagoRecibos
        │ ├── reclamoCliente
        │ ├── reclamoNoCliente
        │ └── registro
        │
        └── resources/features
        ├── ConsultaCupo.feature
        ├── Login.feature
        ├── PagoRecibo.feature
        ├── PagoRecibos.feature
        ├── ReclamoCliente.feature
        ├── ReclamoNoCliente.feature
        └── RegistrarCliente.feature


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
        Los componentes visuales están gestionados usando `Target` dentro del paquete:

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
        qa_Virtual
        dev
        noCliente


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

    👤 Autor
    
    Daniel Contreras
    QA Automation Engineer
    14+ años de experiencia en QA Manual & Automation