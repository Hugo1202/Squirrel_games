# Squirrel Games

## Descripción

Squirrel Games es un proyecto de simulación basado en un juego de organización y gestión de participantes, inspirado en dinámicas tipo "Squid Game". El juego incluye diferentes tipos de roles (participantes, guardias, managers, soldados, etc.) y pruebas con distintos niveles de dificultad y riesgo. El proyecto está desarrollado en **Java** y utiliza **Maven** como gestor de dependencias. Además, cuenta con una interfaz web interactiva y documentación generada automáticamente.

---

## 📁 Estructura del Proyecto

```
Squirrel_games/
├── .classpath
├── .gitignore
├── .project
├── pom.xml                <- Configuración principal de Maven
├── README.md              <- Información del proyecto
├── docs/                  <- Documentación generada automáticamente
│   ├── index.html         <- Página de inicio de la documentación
│   ├── legal/             <- Licencias y términos legales
│   ├── squirrelGames/     <- Clases documentadas
│   └── script-files/      <- Archivos de soporte para la documentación
├── src/
│   ├── main/java/         <- Código fuente del juego
│   │   ├── enums/         <- Enumeraciones (WeaponType, TipoPrueba, etc.)
│   │   ├── excepciones/   <- Excepciones personalizadas
│   │   ├── juego/         <- Lógica del juego (Main, Juego, Organization, etc.)
│   ├── test/java/         <- Pruebas unitarias con JUnit
│   │   ├── testJuego/     <- Tests del juego
├── web/                   <- Interfaz web del juego
│   ├── css/               <- Hojas de estilo CSS
│   ├── js/                <- Scripts de interacción y animación
│   ├── img/               <- Imágenes del proyecto
│   ├── pag/               <- Páginas adicionales (documentación, descargas, etc.)
└── target/                <- Archivos generados por Maven (compilados)
```

---

## 📌 Clases Principales

### 📂 Paquete 'juego'
- `Juego.java`: Controlador principal del juego.
- `Main.java`: Punto de entrada al programa.
- `Organization.java`: Gestión de la organización y sus miembros.
- `Participantes.java`: Representa a los participantes del juego.
- `Persona.java`: Clase base común a todos los personajes.
- `PinkGuards.java`: Clase abstracta para los guardias.
- `Managers.java`: Managers que supervisan las operaciones.
- `Soldiers.java`: Soldados con armamento específico.
- `Workers.java`: Trabajadores con roles definidos.
- `Prueba.java`: Define las pruebas que enfrentan los participantes.

---

### 📂 Paquete 'enumeraciones'
- `Department.java`: Enumeración de departamentos.
- `EnumSexo.java`: Enumeración de sexos.
- `TipoPrueba.java`: Enumeración de tipos de pruebas.
- `WeaponType.java`: Enumeración de tipos de armas.

---

### 📂 Paquete 'excepciones'
- `InfiltradoNoEliminableException.java`: Maneja errores relacionados con infiltrados.
- `InvalidSupervisorException.java`: Error al asignar supervisor incorrecto.
- `OrganizationException.java`: Excepción general de la organización.

---

### 🧪 Tests
- `TestJuego.java`: Conjunto de pruebas unitarias con **JUnit** para verificar el flujo principal del juego.

---

## 🌐 Interfaz Web
- `index.html`: Página principal del juego.
- `css/style.css`: Estilos generales del sitio web.
- `js/script.js`: Scripts de animación e interacción.
- `pag/documentacion/doc_usuario.html`: Documentación de usuario.

---

## 📄 Documentación
El proyecto genera documentación automática disponible en la carpeta `docs/`. Incluye:
- Clases documentadas en `docs/squirrelGames/`
- Licencias y términos legales en `docs/legal/`
- Índice de búsqueda en `docs/index.html`

---

## 🔗 Enlace a la página web Squirrel Games
[Squirrel Games](https://hugo1202.github.io/Squirrel_games/) - ¡Juega ahora!

