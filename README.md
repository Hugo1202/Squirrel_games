
# Squirrel Games

## Descripción

Squirrel Games es un proyecto de simulación basado en un juego de organización y gestión de participantes, inspirado en dinámicas tipo "Squid Game". El juego incluye diferentes tipos de roles (participantes, guardias, managers, soldados, etc.) y pruebas con distintos niveles de dificultad y riesgo. El proyecto está desarrollado en **Java** y utiliza **Maven** como gestor de dependencias.

---

## Estructura del Proyecto

```
Squirrel_games/
└── juego/
    ├── .classpath
    ├── .gitignore
    ├── .project
    ├── pom.xml                <- Configuración principal de Maven
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   ├── excepciones/
    │   │   │   └── juego/
    │   │   └── resources/      <- (Si es necesario, aquí irían recursos adicionales)
    │   └── test/
    │       ├── java/
    │       │   └── testJuego/  <- Tests unitarios
    │       └── resources/
    └── target/                  <- Generado por Maven (compilados)
```

---

## Clases Principales

### Paquete `juego`
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
- `TipoPrueba.java`: Enum con los tipos de prueba.
- `WeaponType.java`: Enum con los tipos de armas.
- `Department.java`: Enum con los distintos departamentos de trabajo.

---

### Paquete `excepciones`
- `IdRepetidoException`: Lanza si hay un ID duplicado.
- `InfiltradoNoEliminableException`: Maneja un caso particular de error.
- `InvalidSupervisorException`: Error al asignar supervisor.
- `OrganizationException`: Excepción general de la organización.

---

### Tests
- `OrganizationTest.java`: Tests unitarios de la organización.
- `TestJuego.java`: Conjunto de pruebas para verificar el flujo principal del juego.

---


