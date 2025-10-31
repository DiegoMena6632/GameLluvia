# Modificación Proyecto GameLluvia

Este proyecto es una modificación del juego "GameLluvia" para la asignatura Programación Avanzada (ICI2241). El objetivo principal es refactorizar la base del juego aplicando principios de Programación Orientada a Objetos (POO), herencia e interfaces para añadir nuevas mecánicas de *power-ups*.

## Descripción del Juego

GameLluvia es una aplicación de destreza y reflejos basada en el motor `libGDX`. El objetivo del jugador es controlar un "tarro" en la parte inferior de la pantalla para recolectar la mayor cantidad de "Gotas Buenas" (azules) posibles, mientras evita las "Gotas Malas" (rojas) que restan vidas.

Esta versión añade nuevas entidades:
* **Gota Escudo:** Otorga inmunidad temporal.
* **Gota SuperVelocidad:** Duplica la velocidad del tarro temporalmente.

## Tecnologías Utilizadas

* **Lenguaje:** Java (Oracle JDK 11)
* **Motor Gráfico:** libGDX
* **IDE (Requerido):** Eclipse
* **Entrega:** Archivo `.zip` del proyecto.

---

## Instrucciones de Instalación y Ejecución

Sigue estos pasos para importar y ejecutar el proyecto en **Eclipse IDE** usando el archivo `.zip` proporcionado.

### 1. Requisitos Previos

* Tener **Eclipse IDE** instalado (versión compatible con JDK 11).
* Tener **Oracle JDK 11** instalado y configurado en Eclipse.

### 2. Instalación (Importar desde .zip)

1.  **Descargar** el archivo `.zip` que contiene el proyecto.
2.  **Descomprimir** el archivo `.zip` en una ubicación de fácil acceso (por ejemplo: `C:\Users\TuUsuario\EclipseProjects\GameLluvia`).

3.  **Abrir Eclipse IDE**.

4.  **Importar el proyecto:**
    * Ve al menú superior: **File** -> **Import...**
    * En la ventana que se abre, expande la carpeta **General**.
    * Selecciona **"Existing Gradle Projects "** y haz clic en **Next**.
    * En la siguiente pantalla, haz clic en **"Project root directory"** y luego en **"Browse..."**.
    * Navega y selecciona la **carpeta principal** que descomprimiste en el paso 2 .
    * Haz clic en **Finish**.

### 3. Ejecución en Eclipse

1.  Una vez importado, busca la vista **"Package Explorer"** en Eclipse. Verás el projecto "GameLLuvia-main".

3.  Expande el proyecto y se deben de seleccionar las siguientes carpetas (en el orden establecido) `lwgjl3`-`src`-`main`-`java`-`ayud`- `ejemplo`-`lwgjl3`.

4.  Haz clic derecho en el archivo `Lwgjl3Launcher.java` y selecciona: **"Run As"** -> **"Run configuration"**.

5.  En el nuevo panel que aparecera tan solo se debe apretar el boton en la esquina inferior izquiera **"Run As"**.

6.El juego empezara a ejecutarse.
---

## Autores

* Diego Mena
* Benjamín Vargas
* Ashlee Cortés
