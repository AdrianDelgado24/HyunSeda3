# Tercera Iteración de Software para Hyun Seda

**Ingeniería de Software 2**

**Presentado por:**
- Juan Esteban Muñoz Gómez
- Laura Sofía Botina Montero
- Adrián Fernando Delgado Serna
- Felipe Armand Pino Sierra

**Profesor:**
WILSON LIBARDO PANTOJA YEPEZ

**Universidad del Cauca**
**Facultad de Ingeniería Electrónica y Telecomunicaciones**
**Ingeniería de Sistemas**

---

## Introducción
En este documento, se presenta un análisis detallado del proyecto de Hyun Seda, una empresa dedicada a la producción de seda sostenible, de calidad y respetuosa con el medio ambiente que ha evolucionado su modelo de negocio hacia un enfoque digital con el objetivo de expandir su alcance y aumentar su visibilidad en el mercado.

Además, conscientes de la importancia de una presencia en línea sólida, Hyun Seda ha contratado servicios tercerizados para el desarrollo de un ecommerce y la gestión de productos. Si bien esta decisión inicial fue tomada para cubrir necesidades inmediatas, como la preparación para un evento importante, se ha identificado la necesidad de una solución a largo plazo que sea autónoma y rentable.

En este contexto, se propone el diseño e implementación de un sistema propio que no solo cumpla con los requisitos funcionales y no funcionales del negocio, sino que también garantice la eficiencia, seguridad y escalabilidad necesarias para el crecimiento continuo de Hyun Seda. Este documento abordará aspectos clave como la arquitectura del sistema, las tecnologías seleccionadas y las pruebas de usabilidad, con el fin de proporcionar una guía integral para el desarrollo exitoso de esta iniciativa. 

---

## Requisitos Funcionales
Se hace referencia a la hoja de cálculo de HistoriasEpicas HyunSeda de la plantilla de historias de usuario.

[Descargar Tercer reporte HE HyunSeda.xlsx](https://github.com/AdrianDel2/Lab2_solid/blob/main/img/Tercer%20reporte%20HE%20HyunSeda.xlsx)

---

## Prototipos y test de usabilidad

### Prototipos de interfaces
A continuación se presentan algunos prototipos de las interfaces del software.

![](https://github.com/AdrianDel2/Lab2_solid/blob/main/img/imagen1.png)
>Imagen 1. Prototipo de la interfaz del menú del producto. Elaboración propia.

![](https://github.com/AdrianDel2/Lab2_solid/blob/main/img/imagen2.png)
>Imagen 2. Prototipo de la interfaz agregar producto. Elaboración propia.

![](https://github.com/AdrianDel2/Lab2_solid/blob/main/img/imagen3.png)
>Imagen 3. Prototipo de la interfaz de la tienda Hyun Seda. Elaboración propia.

![](https://github.com/AdrianDel2/Lab2_solid/blob/main/img/imagen4.png)
>Imagen 4. Prototipo de la interfaz buscar producto. Elaboración propia.

### Test de usabilidad
A continuación se presenta el prototipo de la vista previa de los productos de la tienda como tal:
![](https://github.com/AdrianDel2/Lab2_solid/blob/main/img/imagen5.png)
>Imagen5.Prototipo visualizacion tienda

Y aquí se adjuntan los enlaces a los videos donde se hace la prueba de usabilidad:

- Video 1: https://github.com/AdrianDel2/Lab2_solid/assets/159732648/95b15388-f26c-4771-9a17-d03214cd44d8
- Video 2: https://github.com/AdrianDel2/Lab2_solid/assets/159732648/02d829cd-1950-49c0-b78d-3c4aaf9f9f25

---
###Pruebas Unitarias
Se presenta un resumen de las pruebas realizadas para el proyecto.
![]()
>Imagen 6. Captura de los test realizados para el software. Elaboración propia.

---

## Requisitos no funcionales
Los requisitos no funcionales identificados mediante la aplicación de un Mini-QAW en conjunto con el cliente son los siguientes:

1. **Performance:** Con el aumento de productos o la expansión del catálogo, existe el riesgo de que la base de datos se vea sobrecargada. Por lo tanto, se requiere una optimización eficiente para la carga de imágenes, archivos y otros recursos, garantizando así un rendimiento óptimo del sistema.

2. **Seguridad:** Hay tres roles distintos en el sistema. Es crucial contar con un sistema de autenticación que permita identificar a los usuarios mediante su correo electrónico y contraseña. Además, se necesita una gestión de roles que garantice que cada usuario tenga acceso únicamente a las funcionalidades correspondientes a su rol asignado.Por ejemplo, si un usuario ingresa como editor, solo debería visualizar el panel de control para editar el blog, sin acceso a funciones exclusivas de los administradores.

3. **Modificabilidad:** Se requiere que el sistema sea altamente adaptable y capaz de migrar sin inconvenientes a diferentes entornos. Debe estar diseñado con un bajo acoplamiento y una alta cohesión para garantizar que los componentes puedan ser modificados de forma independiente y que los cambios realizados sean fácilmente comprensibles.

4. **Escalabilidad:**Se requiere que el sistema sea escalable para manejar un aumento significativo en el tráfico y la carga de trabajo a medida que crezca el número de usuarios y productos en la plataforma. Esto implica implementar una arquitectura que pueda escalar horizontalmente, añadiendo más servidores o recursos según sea necesario para mantener el rendimiento del sistema.

Para cada uno de los anteriores atributos de calidad se planteó un escenario de calidad que son los siguientes:

### Atributo de calidad 1 (Performance)
- **Contexto:** Con el objetivo de ampliar su alcance y mejorar la visibilidad de sus productos, Hyun Seda ha implementado una landing page que ofrece información detallada sobre el proceso de producción, la historia de la seda y datos de contacto. Además, se creó temporalmente un blog para compartir noticias relevantes y aumentar la visibilidad.
- **Estímulo:** Un usuario realiza una acción en el sitio web como cargar una página, agregar un producto al carrito de compras o procesar un pedido.
- **Respuesta:** La plataforma en línea de Hyun Seda requiere una solución para gestionar el almacenamiento de archivos multimedia que evite que la base de datos aumente exponencialmente de tamaño por la carga de imágenes, proporcionando una experiencia de usuario fluida y sin demoras significativas.
- **Medición de la calidad:** Los criterios para evaluar el desempeño del sistema incluyen el tiempo de carga de la página principal y de productos, y la eficiencia en el manejo de archivos multimedia. La calidad se medirá mediante la rapidez y consistencia en la experiencia del usuario, así como la capacidad para mantener un rendimiento óptimo.
- **Resultado esperado:** Se espera que la plataforma en línea de Hyun Seda proporcione un rendimiento confiable y eficiente en todo momento. Los tiempos de carga deben ser rápidos y consistentes, asegurando que los usuarios puedan explorar productos, leer el blog y realizar compras de manera rápida y sin inconvenientes.

### Atributo de calidad 2 (Seguridad)
- **Contexto:** Hyun Seda gestiona el acceso a la edición de las características de su página web a través de la implementación de tres roles distintos: editor, administrador y super administrador.
- **Estímulo:** Un usuario interno accede al dashboard de empleados de Hyun Seda utilizando una cuenta y las credenciales correspondientes para iniciar sesión.
- **Respuesta:** El sistema debe garantizar que únicamente los usuarios registrados tengan acceso al dashboard de empleados. Una vez se ha iniciado sesión, se mostrarán las utilidades correspondientes al rol del usuario.
- **Medición de la calidad:** La calidad se mide por la efectividad en la autenticación, asegurando que solo los usuarios autorizados tengan acceso al dashboard y que cada tipo de usuario solo tenga acceso o capacidad de manipulación de lo que refiere a su jerarquía de usuario o la de un nivel jerárquico más profundo.
- **Resultado esperado:** El sistema garantiza que solo los usuarios autenticados y autorizados tengan acceso al dashboard que le corresponde con base en las credenciales ingresadas.

### Atributo de calidad 3 (Modificabilidad)
- **Contexto:** La empresa Hyun Seda ha desarrollado una página web para promocionar y vender sus productos. Desea asegurar que su página web sea altamente modificable, legible y adaptable a diferentes entornos.
- **Estímulo:** Un nuevo desarrollador se incorpora al equipo de Hyun Seda y necesita familiarizarse con el código y la arquitectura del sistema web existente para comenzar a trabajar en la implementación de nuevas características.
- **Respuesta:** El sistema debe ser concebido y construido con flexibilidad, permitiendo una adaptación sencilla a los cambios necesarios para incorporar nuevas funcionalidades y mejorar su portabilidad. Este objetivo se alcanzará mediante la aplicación rigurosa de los principios SOLID y garantizando una estructura bien organizada que mejore su legibilidad y mantenibilidad a lo largo del tiempo.
- **Medición de la calidad:** Los criterios para evaluar la modificabilidad del sistema incluyen la facilidad con la que los cambios pueden ser realizados sin impactar negativamente otras áreas del sistema, el tiempo y recursos necesarios para implementar dichos cambios, la habilidad de los desarrolladores para comprender y modificar el código existente, así como la estabilidad del sistema una vez que se han realizado las modificaciones.
- **Resultado esperado:** Se espera que el sistema de comercio electrónico se adapte fácilmente a los cambios necesarios para incorporar la nueva función de recomendaciones personalizadas. Estos cambios deben poder implementarse de forma rápida y eficiente, sin introducir errores o afectar negativamente la funcionalidad existente del sistema.

### Atributo de calidad 4 (Escalabilidad)
- **Contexto:** Con el continuo crecimiento de la empresa Hyun Seda y su presencia en línea, se anticipa un aumento en el tráfico de usuarios y la carga de trabajo en la plataforma web.Esto puede deberse a una mayor demanda de productos, promociones especiales o la expansión a nuevos mercados.
- **Estímulo:** A medida que el número de usuarios concurrentes aumenta o se introduce una mayor cantidad de productos en el catálogo, el sistema experimenta una mayor carga de trabajo y necesita manejar eficientemente este incremento en la demanda.
- **Respuesta:** El sistema debe ser capaz de escalar horizontalmente para manejar el aumento en el tráfico y la carga de trabajo. Esto implica agregar más recursos computacionales, como servidores y capacidad de almacenamiento, de manera dinámica según sea necesario.
- **Medición de la calidad:** Los criterios para evaluar la escalabilidad del sistema incluyen la capacidad para manejar un incremento significativo en el número de usuarios y transacciones, el tiempo de respuesta del sistema bajo cargas elevadas y la efectividad de la solución de escalamiento implementada.
- **Resultado esperado:** Se espera que el sistema de comercio electrónico de Hyun Seda mantenga un rendimiento óptimo y una disponibilidad constante, incluso durante picos de tráfico y cargas de trabajo elevadas. La capacidad de escalar horizontalmente asegura que el sistema pueda crecer de manera eficiente con la demanda.

### Tácticas de Arquitectura

1. **Atributo de calidad 1 (Performance):**
 - Processing Time: El procesamiento consume recursos, lo cual lleva tiempo. Los eventos son manejados por la ejecución de uno o más componentes, cuyo tiempo empleado es un recurso. Los recursos de hardware incluyen la CPU, almacenes de datos, ancho de banda de comunicación de red y memoria. Los recursos de software incluyen entidades definidas por el sistema en diseño. Por ejemplo, los buffers deben ser gestionados y el acceso a secciones críticas debe hacerse secuencialmente.
 - Aumentar la eficiencia de los recursos.
   
2. **Atributo de calidad 2 (Seguridad):**
 - Authenticate Actors: Autenticación significa asegurarse de que un actor (un usuario o una computadora remota) realmente sea quien o lo que pretende ser. Las contraseñas, contraseñas de un solo uso, certificados digitales e identificación biométrica proporcionan un medio para la autenticación.
   
3. **Atributo de calidad 3 (Modificabilidad):**
 - Aumentar la cohesión: El propósito de trasladar una responsabilidad de un módulo a otro es reducir la probabilidad de que los efectos secundarios afectan otras responsabilidades en el módulo original. Reducir el tamaño de un módulo.

4. **Escalabilidad:**
 - Rendimiento óptimo: Escalar el sistema para manejar aumentos en la demanda de recursos, manteniendo un rendimiento óptimo y garantizando la seguridad y la modificabilidad del sistema. Esto implica diseñar una arquitectura que permita agregar recursos fácilmente según sea necesario, sin comprometer la eficiencia de los recursos existentes ni la seguridad del sistema.
 - Crecimiento flexible: Diseñar el sistema para que pueda crecer de manera flexible y eficiente en respuesta a cambios en la carga de trabajo, manteniendo la autenticación de actores, la eficiencia de recursos y la cohesión del sistema. Esto implica una arquitectura modular y distribuida que permita agregar capacidades y recursos sin afectar negativamente la seguridad, el rendimiento o la facilidad de modificación del sistema.
---

## Diagrama Entidad Relación
![](https://github.com/AdrianDel2/Lab2_solid/blob/main/img/imagen7.png)
>Imagen 7. Diagrama entidad relación del microservicio de producto. Elaboración propia.

![](https://github.com/AdrianDel2/Lab2_solid/blob/main/img/imagen7.1.png)
>Imagen 7.1. Diagrama entidad relación del microservicio de usuario. Elaboración propia.

![](https://github.com/AdrianDel2/Lab2_solid/blob/main/img/imagen7.2.png)
>Imagen 7.2. Diagrama entidad relación del microservicio de item. Elaboración propia.


---

## Arquitectura del sistema

### Modelo C4

![](https://github.com/AdrianDel2/Lab2_solid/blob/main/img/imagen8.png)
>Imagen 8. Diagrama de contexto del modelo C4. Elaboración propia.

![](https://github.com/AdrianDel2/Lab2_solid/blob/main/img/imagen9.png)
>Imagen 9. Diagrama de contenedores del modelo C4. Elaboración propia.

![](https://github.com/AdrianDel2/Lab2_solid/blob/main/img/imagen10.png)
>Imagen 10. Diagrama de componentes del modelo C4. Elaboración propia.

![](https://github.com/AdrianDel2/Lab2_solid/blob/main/img/imagen11.png)
>Imagen 11. Diagrama de clases del microservicio de pago. Elaboración propia


---

## Decisiones de arquitectura y su justificación

### 1. Decisiones de arquitectura
1. En el contexto de la historia de usuario de agregar productos al carrito de compras, con el fin de resolver la preocupación de que los productos no sean visibles al instante y dificulten la experiencia del comprador, nos decidimos por la decisión de usar la arquitectura de MVC. Descartamos las opciones de usar las arquitecturas basadas en la orientación de eventos, tuberías y filtros, para lograr que los productos que se deseen comprar se actualicen en tiempo real en la interfaz gráfica del comprador para así mejorar la interacción con la tienda. Aceptando que se tendrá la desventaja que la escalabilidad de la aplicación se verá afectada, lo cual afectará la usabilidad de la aplicación al momento de querer realizar cambios en ella porque en dicha arquitectura se deben modificar varias capas para poder realizar un solo cambio.

2. En el contexto de la historia de usuario de realizar el pago, con el fin de resolver la interacción con varios sistemas de pago, nos decidimos por la decisión de usar la arquitectura hexagonal y descartamos la arquitectura microkernel, para lograr el aumento de la agilidad y poderse adaptar a cualquier plataforma de pago. Aceptando que se tendrá la desventaja con respecto al rendimiento del sistema porque cuando el sistema se encuentre muy distribuido, esto va a impactar negativamente al rendimiento.

3. En el contexto de la historia de usuario de agregar productos como administrador, con el fin de resolver el control de productos que se muestran en el catálogo de la tienda, nos decidimos por la decisión de implementar la arquitectura hexagonal para lograr el aumento en la testeabilidad para probar todos los debidos funcionamientos del microservicio sin afectar a los demás y que así se muestre todo correctamente, y descartamos las opciones de arquitecturas como orientado a eventos, aceptando que se tendrá la desventaja con respecto a la facilidad de despliegue porque cuando se requiera realizar cambios, se debería hacer una integración continua.

4. En el contexto de la historia de usuario de registrar envío ,con el fin de resolver el cálculo del precio de envío dependiendo de la ubicación del comprador, nos decidimos por la arquitectura de microservicios y descartamos las opciones de la arquitectura orientada a eventos, para lograr la agilidad de cálculo de envío de los productos, aceptando que se tendrá la desventaja con respecto al rendimiento porque cuando se desee escalar la aplicación esto resultaría en un aumento considerable de los costos.

5. En el contexto de la historia de usuario de buscar productos, con el fin de resolver la agilidad de interacción del entorno gráfico con el comprador, nos decidimos por la arquitectura hexagonal, para lograr la simplificación del sistema al momento de gestionar un envío, y descartamos la opción de implementar la arquitectura orientada a eventos, aceptando que se tendrá la desventaja con respecto al rendimiento porque cuando se muestren las múltiples interfaces gráficas al usuario es posible que baje el rendimiento de las mismas.

##2. Estilo Arquitectónico

### 2.1.Arquitectura Hexagonal:

#### Requisitos Funcionales:

1. **Gestión de Productos:**
    1.1. **Modelo:** Se encarga de la gestión de productos en la tienda, permitiendo al administrador agregar, actualizar y eliminar productos según sea necesario.
    1.2. **Vista:** Muestra los productos disponibles en la tienda, así como su clasificación por categoría, lo que permite a los visitantes encontrar y explorar los productos de manera intuitiva.
    1.3. **Controlador:** Gestiona las interacciones del usuario, como la solicitud de información sobre un producto específico o la adición de un producto al carrito de compras.

#### Requisitos No Funcionales:

2. **Escalabilidad y Mantenibilidad:**
    2.1. La arquitectura hexagonal permite escalar cada componente de forma independiente. Por ejemplo, si el módulo de gestión de productos necesita mayor capacidad de procesamiento debido a un incremento en la carga, solo este módulo puede ser escalado sin necesidad de modificar o impactar otros componentes del sistema.
    2.2. La separación clara entre la lógica de negocio y las interfaces externas, característica principal de la arquitectura hexagonal, asegura que los cambios en la lógica de negocio no afecten a las interfaces (y viceversa). Esto permite realizar actualizaciones, mejoras o correcciones de errores de manera aislada.

### 2.2. Arquitectura de Microservicios:

#### Requisitos No Funcionales:

1. **Modularidad y Flexibilidad:** La arquitectura de microservicios permite la gestión de funciones específicas, como el proceso de pago en el carrito de compras, como servicios independientes. Esto mejora la modularidad del sistema al facilitar la intercambiabilidad o actualización de estas funcionalidades sin afectar al conjunto central de la aplicación.
2. **Optimización del Rendimiento:** Al separar la funcionalidad de pago en servicios externos, se optimiza el rendimiento del sistema al reducir la carga en el núcleo central y distribuir eficientemente la carga de trabajo. Esto asegura que el sistema pueda manejar transacciones de pago y operaciones relacionadas con el carrito de compras sin comprometer la velocidad o la estabilidad.
3. **Seguridad:** La implementación de funciones específicas, como el proceso de pago, como servicios independientes, contribuye a mejorar la seguridad del sistema al limitar el acceso a funciones críticas solo a usuarios autorizados. Esto reduce el riesgo de vulnerabilidades de seguridad y protege la integridad de los datos del sistema y la privacidad de los usuarios.

### 3. Tipo de aplicación

Hasta el momento, la decisión de implementar una aplicación de escritorio se ha basado en varias consideraciones estratégicas. En primer lugar, esta elección permite ofrecer una versión preliminar al cliente de manera rápida y efectiva. Esta versión preliminar ofrece un entorno de simulación que permite al cliente experimentar de primera mano las funcionalidades clave del software. Además, esta aplicación de escritorio sirve como un prototipo funcional, permitiendo explorar y refinar las características esenciales de la aplicación en una escala más general.

Sin embargo, es importante destacar que esta implementación de escritorio no es un destino final, sino más bien un paso intermedio hacia el objetivo último: la migración a una aplicación web. Esta transición se justifica por varios motivos, siendo uno de los principales la reducción de costos asociados con los servicios web de terceros. La migración a una plataforma web permitirá a Hyun Seda eliminar la dependencia de estos servicios costosos y, en su lugar, optar por soluciones más rentables y personalizadas.

Además de los beneficios económicos, la migración a una aplicación web también ofrecerá una mayor accesibilidad y flexibilidad. Una vez en línea, el aplicativo estará disponible para un público más amplio, eliminando las limitaciones de plataforma y dispositivo asociadas con las aplicaciones de escritorio tradicionales. Esto facilitará la expansión del alcance del producto y su adopción por parte de un mayor número de usuarios.

En resumen, la implementación actual de una aplicación de escritorio representa un paso estratégico hacia el objetivo final de migrar a una aplicación web. Esta transición no solo permitirá a Hyun Seda reducir costos y mejorar la accesibilidad, sino que también sentará las bases para un crecimiento y desarrollo continuos del producto en el futuro.

## 4. Tecnologías

- **Spring Security JWT:** Spring Security es un framework de seguridad que proporciona autenticación y autorización completas para aplicaciones basadas en Spring. Ofrece un sistema robusto y extensible para la gestión de la seguridad en aplicaciones web y de servicio. Spring Security permite proteger endpoints REST, gestionar roles y permisos de usuario, y configurar políticas de seguridad de manera declarativa mediante anotaciones y configuraciones en archivos de propiedades. Esto resulta crucial en arquitecturas de microservicios, donde es fundamental garantizar la seguridad y el control de acceso a los diferentes servicios.

- **Java y Orientación a Objetos:** Java es un lenguaje orientado a objetos que facilita la implementación de patrones de diseño como MVC. En MVC, los modelos, vistas y controladores pueden ser representados como clases y objetos en Java, lo que proporciona una estructura clara y modular para la aplicación. Esta orientación a objetos también promueve la reutilización de código y la fácil extensibilidad, lo que contribuye a la modularidad y flexibilidad del sistema.

- **Framework Spring Boot:** Spring Boot es un framework de desarrollo de aplicaciones Java que facilita la creación de aplicaciones basadas en Spring con una configuración mínima. Proporciona un conjunto de herramientas y convenciones que simplifican el desarrollo, la configuración y la implementación de aplicaciones Java. Spring Boot es especialmente adecuado para la implementación de arquitecturas de microservicios, ya que ofrece características como la creación de servicios RESTful, la gestión de dependencias, la configuración automática y la integración con otros proyectos de Spring.

- **Lombok:** Lombok es una biblioteca de Java que permite reducir la verbosidad del código eliminando la necesidad de escribir métodos getters, setters, constructores y otros métodos comunes. Utilizando anotaciones, Lombok genera automáticamente el código boilerplate durante la compilación, lo que simplifica y agiliza el desarrollo de aplicaciones Java. Esta característica es especialmente útil en proyectos de microservicios donde se busca minimizar la cantidad de código repetitivo y mejorar la legibilidad del código.

- **JPA con Hibernate:** Java Persistence API (JPA) es una especificación de Java que proporciona un conjunto de interfaces y anotaciones para el mapeo objeto-relacional (ORM). Hibernate es uno de los proveedores de JPA más populares y ampliamente utilizados en el ecosistema Java. Hibernate simplifica el acceso y la manipulación de datos en aplicaciones Java al proporcionar una capa de abstracción sobre la base de datos relacional. Esta combinación de JPA con Hibernate facilita el desarrollo de aplicaciones Java con una capa de persistencia sólida y flexible, lo que es fundamental en arquitecturas de microservicios donde se requiere acceso eficiente a los datos.

- **H2Database:** H2Database es una base de datos relacional escrita en Java, diseñada para ser ligera, rápida y fácil de integrar en aplicaciones Java. Es ideal para entornos de desarrollo y pruebas debido a su capacidad de ser embebida en la aplicación y su soporte para la ejecución en memoria, lo que facilita la configuración y la portabilidad. Además, H2Database es compatible con los estándares SQL y ofrece características avanzadas como el soporte para procedimientos almacenados y disparadores. Su naturaleza sin servidor y su tamaño compacto la hacen adecuada para proyectos de microservicios donde se requiere una base de datos liviana y eficiente para el almacenamiento de datos transaccionales y la persistencia de datos temporales o de prueba.

- **Swagger:** Swagger es una herramienta que permite describir, documentar y consumir servicios web RESTful de forma fácil y efectiva. Con Swagger, los desarrolladores pueden definir la estructura de sus servicios web utilizando el formato YML o JSON y generar automáticamente documentación interactiva, clientes de servicio y código de servidor en varios lenguajes de programación. Esta capacidad de documentación automática y generación de código facilita la implementación y el consumo de servicios web en proyectos de microservicios, donde la comunicación entre servicios es fundamental y la documentación clara es esencial para garantizar la interoperabilidad.

- **Arquitectura Hexagonal:** La arquitectura hexagonal, también conocida como arquitectura de puertos y adaptadores, es un estilo de diseño de software que busca crear aplicaciones altamente mantenibles y testables mediante la separación de la lógica de negocio del código que interactúa con el exterior (como interfaces de usuario, bases de datos, y servicios externos). En esta arquitectura, la aplicación se estructura en capas concéntricas donde la lógica central (o núcleo) no depende de los detalles de implementación externa, permitiendo así una mayor flexibilidad y escalabilidad.

- **Arquitectura de Microservicios:** Tanto Java como las tecnologías mencionadas anteriormente son altamente compatibles con la arquitectura de microservicios. Esta arquitectura se basa en el principio de desarrollar aplicaciones como conjuntos de servicios pequeños e independientes, cada uno con su propia funcionalidad y datos. Java proporciona un entorno robusto y flexible para el desarrollo de microservicios, mientras que tecnologías como Spring Boot, Lombok, JPA con Hibernate y Swagger ofrecen herramientas y características específicas que facilitan la implementación, la gestión y el consumo de microservicios en entornos empresariales.

- **Optimización del Rendimiento:** Tanto Java como SQLite están diseñados para ser eficientes en términos de rendimiento. Java utiliza la compilación JIT (Just-In-Time) para optimizar el rendimiento del código en tiempo de ejecución, mientras que SQLite está optimizado para operaciones de lectura/escritura rápidas y eficientes en disco. Esta combinación ayuda a garantizar un rendimiento óptimo incluso en aplicaciones de escritorio que manejan grandes volúmenes de datos.

- **Seguridad:** Java y H2Database ofrecen características de seguridad sólidas que son esenciales para aplicaciones de escritorio. Java proporciona un entorno de ejecución seguro con mecanismos de control de acceso y verificación de tipos, mientras que H2Database ofrece opciones de cifrado de base de datos y control de acceso a nivel de archivo. Esto contribuye a proteger los datos sensibles y a garantizar la integridad del sistema contra posibles amenazas de seguridad.


---

## Demo del funcionamiento de la aplicacion
[Demo_APP](https://www.youtube.com/watch?v=baot7ztkntA)
