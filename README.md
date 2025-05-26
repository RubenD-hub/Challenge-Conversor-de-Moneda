<a name="readme-top"></a>

<br>
<div align="center">
  <img src="img/Badge-Conversor.png" alt="Logo" width="200">

![Alura]
  <h1>Challenge: Conversor de Monedas 💲➡💵</h1>
  <p>
    🤯Un increíble proyecto donde podrás hacer diferentes conversiones de divisas, solicitando
    las tazas de conversion actualizadas en tiempo real.🔄🕒

  </p>
</div>

---

<details>

  <summary>Indice</summary>

- [🤔Acerca del proyecto](#acerca-del-proyecto)
- [👷‍♂️Construido con:](#️construido-con)
- [🛠Cómo empezar.](#cómo-empezar)
    - [📜Requisitos](#requisitos)
    - [💻](#)
- [🛶Funcionamiento](#funcionamiento)
    - [🚓Evaluaciones y Restricciones](#evaluaciones-y-restricciones)

</details>

---

## 🤔Acerca del proyecto

Este interesante proyecto, haremos uso de los conocimientos aprendidos en el curso
**Java Orientación a Objetos** impartido por **ALURA Latam - ONE** (Oracle Next Education).

Este proyecto hará uso de:
- Listas
- Programacion Orientada a Objetos POO
- Lectura y Escritura de archivos de texto y JSON
- Peticiones a una API
- Uso de excepciones

Con lo que creamos una aplicación para la converion de divisas, mediante el ingreso del
monto a convertir a su equivalencia en otra divisa, con la ayuda de la API [ExchangeRate-API](https://www.exchangerate-api.com/img/hr-logo-2022-ldpi-rc.png)
para obtener las tasas de cambio actualizadas.

Otras funcionalidades que ofrece la aplicacion son:
- Agregar los tipos de conversion
- Poder hacer diferentes tipos de conversion
- Uso de un menu amigable
- Consuta del historial de converiones hechas.

---

## 👷‍♂️Construido con:

Su construcción fue mediante las siguientes herramientas:

![Java]
![IntelliJ IDEA]
![Git]
![GitHub]

## 🛠Cómo empezar.
Como paso inicial, descargue este repositorio con el proyecto.
### 📜Requisitos
- Tener instalado Java JDK 17.0.6. 
- OPCIONAL: Un IDE que ejecute Java (IntelliJIDEA, NeatBeans)
- Conexión a internet para consultar la API.

### 💻

## 🛶Funcionamiento

### 🚓Evaluaciones y Restricciones

<p align="right"><a href="#readme-top">regresar al inicio</a></p>

[Java]:https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=white
[IntelliJ IDEA]:https://img.shields.io/badge/IntelliJIDEA-000000.svg?logo=intellij-idea&logoColor=white
[Git]:https://img.shields.io/badge/Git-F05032?logo=git&logoColor=fff

[GitHub]:https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=white
[Alura]:https://custom-icon-badges.demolab.com/badge/Alura-001332?logo=alura-white&logoColor=fff

Funcionalidades:
Selección interactiva de monedas de origen y destino.
Conversión precisa utilizando tasas oficiales.
Listado completo de monedas con sus nombres en español.
Manejo de errores para entradas inválidas y problemas de conexión.
Persistencia opcional de resultados en consola o archivo (en futuras versiones)


Cómo ejecutar el proyecto
Clona el repositorio en tu equipo local.
Abre el proyecto con tu IDE Java preferido.
Ejecuta la clase Principal.java ubicada en el paquete main.
Sigue las instrucciones en consola para seleccionar divisas y realizar conversiones.
Ingresa el monto a convertir y obtén el resultado en tiempo real.
Nota: Si introduces una divisa no disponible o un valor inválido, el sistema te lo indicará mediante un mensaje claro.

## **Estructura del Proyecto**
```plaintext
dinexar-java/
│── src/                        # Código fuente del proyecto
│   └── com/
│       └── aluracursos/         # Paquete base del proyecto
│           └── dinexar/         # Subpaquete específico de la aplicación
│               ├── modelo/      # Contiene las clases modelo para el historial
│               │   └── Conversion.java
│               ├── servicio/    # Contiene las clases de servicios
│               │   └── ConsultaMoneda.java
│               ├── util/        # Funciones y utilidades generales
│               │   └── Monedas.java
│               ├── aplicacion/  # Contiene la clase principal de la aplicación
│               │   └── AplicacionDinexar.java
│               └── main/        # Contiene la clase principal de ejecución
│                   └── Principal.java
│── .gitignore                  # Archivos y directorios ignorados por Git
│── README.md                    # Documentación del proyecto
```

private static final String BLUE = "\u001B[34m";
private static final String GREEN = "\u001B[32m";
private static final String YELLOW = "\u001B[33m";
private static final String CYAN = "\u001B[36m";
private static final String RED = "\u001B[31m";
private static final String MAGENTA = "\u001B[35m";
private static final String RESET = "\u001B[0m";
private static final int WIDTH = 60;

A su vez, en el proyecto se ponen en práctica los siguientes fundamentos:


Main: Su única responsabilidad es la de inicializar la aplicación, configurar el menú principal y controlar el flujo de la interacción del usuario. No se encarga de la lógica de negocio de las tasas o los cálculos.

Rates: Se encarga específicamente de obtener y mostrar las tasas de cambio.

Calculator: Su responsabilidad es tomar la entrada del usuario y realizar los cálculos de conversión de moneda.

ApiClient: Su única tarea es comunicarse con la API externa para obtener la información necesaria.

InputHandler: Maneja la entrada del usuario de forma segura y con validación.

MenuBuilder: Se dedica a la creación y visualización del menú interactivo.

UserInterface: Proporciona métodos para mostrar mensajes formateados al usuario, manteniendo la presentación separada de la lógica.

Clases en el paquete models: Representan las estructuras de datos de la aplicación, como las monedas (Currencies), el par de monedas (CurrenciesPair), las opciones del menú (MenuOptions) y la información de las tasas (RatesInformation).

Uso de patrones de diseño implícitos
Factory (Simple Factory): Aunque no es un patrón formalmente implementado con una clase factory explícita, la clase MenuBuilder actúa como una especie de fábrica para crear y gestionar las opciones del menú y sus acciones asociadas.

Strategy: El uso de Runnable para las acciones del menú permite definir diferentes estrategias (las implementaciones de run() en los métodos referenciados) que se ejecutan según la selección del usuario.

Robustez y manejo de errores
Validación de la clave de API: El programa verifica al inicio que la variable de entorno MI_API_KEY esté configurada, evitando fallos posteriores por falta de autenticación.

Manejo de excepciones de la API: La clase ApiClient implementa un manejo detallado de los posibles errores de la API, proporcionando mensajes informativos basados en el tipo de error recibido (clave inválida, cuota alcanzada, etc.).

Manejo de excepciones de entrada: InputHandler utiliza bloques try-catch para asegurar que la entrada del usuario sea válida (números decimales positivos y códigos de moneda existentes).

Propagación y manejo de InterruptedException: Se maneja la excepción InterruptedException al interactuar con la API, asegurando una respuesta adecuada en caso de interrupción del hilo.

Organización y modularidad
Uso de paquetes: La aplicación está claramente organizada en paquetes (models, services, utils), lo que facilita la comprensión, el mantenimiento y la escalabilidad del código. Cada paquete agrupa clases con responsabilidades relacionadas.

Clases pequeñas y enfocadas: Cada clase tiende a tener una responsabilidad bien definida, lo que hace que el código sea más legible y fácil de probar.

Uso de características avanzadas de Java:
Enums (Currencies): Se utiliza un enum para representar los códigos de moneda, lo que garantiza la seguridad de tipos y facilita la gestión de las monedas soportadas.

Records (CurrenciesPair): Se utiliza un record para representar un par de monedas de forma concisa e inmutable.

Lambdas y Referencias a Métodos: El MenuBuilder utiliza referencias a métodos (rates::showExchangeRates, calculator::showExchangeCalculator) y una lambda (() -> System.out.println("Saliendo ...")) para asociar acciones a las opciones del menú, lo que hace que el código sea más conciso y expresivo.

StringBuilder: Se utiliza StringBuilder en MenuBuilder para construir eficientemente las cadenas del menú.

HttpClient: Se utiliza la API de HttpClient introducida en Java 11 para realizar las llamadas HTTP a la API externa.