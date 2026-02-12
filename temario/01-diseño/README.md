# Diseño

## ¿Por qué?

Hemos visto:

|Que el software sufre de inefectividad|Que la solución no es más código|Que controlar la complejidad es la esencia de la programación
|-|-|-|
|Proyectos que incumplen su ámbito, tiempo o coste; sistemas con mala calidad (poca fiabilidad, usabilidad, seguridad); y código difícil de mantener — **viscoso**, **rígido**, **frágil**, **inmovil** — debido a una **complejidad arbitraria** que lo hace incomprensible.|sino mejor diseño: la sencillez (*Divide et impera*), el principio KISS (Keep It Simple, Stupid), y el **código limpio** que se lee como una prosa bien escrita.|Y que la **simplicidad llevada al extremo se convierte en elegancia**
||Que los programas deben ser escritos para que los lean las personas y sólo incidentalmente, para que lo ejecuten las máquinas

## ¿Qué?

> [**RAE**](https://dle.rae.es/dise%C3%B1o)

<div align=center>

|Análisis|Diseño|
|-|-|
|Analizar los requisitos a través de su refinamiento y estructura para realizar una compresión más precisa de los requisitos, una descripción de los requisitos que es fácil de mantener y ayuda a estructurar el sistema.|Desarrollar enfocados en los requisitos no funcionales y en el dominio de la solución para preparar para la implementación y pruebas del sistema|
|Dar una especificación más precisa de los requisitos obtenidos en la captura de requisitos|Adquirir una comprensión profunda sobre los aspectos de los requisitos no funcionales y limitaciones relacionadas con:|
|Describir usando el lenguaje de los desarrolladores y poder introducir más formalismo y ser utilizado para razonar sobre el funcionamiento interno del sistema<br><br>Estructurar los requisitos de manera que facilite su comprensión, cambiándolos y, en general, mantenerlos<br><br>Acercase al diseño, aunque sea un modelo en sí mismo, y es por tanto un elemento esencial cuando el sistema está conformado en diseño e implementación|- los lenguajes de programación,<br>- la reutilización de componentes,<br>- sistemas operativos<br>- tecnologías de distribución y concurrencia,<br>- tecnologías de bases de datos,<br>- tecnologías de interfaz de usuario,<br>- tecnologías de gestión de transacciones,<br>- y así sucesivamente|
|**[¡Diseño al inicio!](https://www.softdevbigideas.com/just-enough-design-up-front.html)** (JEDUF, Just Enough Design Upfront vs BDUF, Big Design Upfront)|**Diseño sistemas**|
|- Vista de diseño/lógica|- Vistas de implementación/desarrollo|
||- Vista física/despligue|

</div>

## ¿Para qué?

El diseño responde a tres preguntas clave:

1. **¿Cómo dividimos un problema grande en problemas pequeños manejables?**
   - Mediante *descomposición* y *modularización*

1. **¿Cómo organizamos las piezas para que funcionen juntas?**
   - Mediante *relaciones* y *arquitectura*

1. **¿Cómo describimos esta organización para que otros la entiendan?**
   - Mediante *notación* y *convenciones* (UML, código legible, documentación)

## ¿Cómo?

<div align=center>

|||
|-|-|
**Modelo del dominio**|Origen de identificadores del problema/solución.

|Cuando los programadores piensan en los problemas, en términos de comportamientos y responsabilidades de los objetos, traen con ellos un caudal de intuición, ideas y conocimientos provenientes de su experiencia diaria —|En lugar de un saqueador de bits que saquea estructuras de datos, nosotros tenemos un universo de objetos con buen comportamiento que cortésmente se solicitan entre sí cumplir diversos deseos —|
|-|-|
|*Budd, Programación Orientada a Objetos. 1994*|*Ingalls, Design Principles Behind Smalltalk. Byte vol. 6(8)*|

</div>

- Cómo ***encontrar*** clases
  - [Estrategias de clasificación](01-estrategiasClasificacion.md).
    - [Descomposición Funcional](01.1-descomposicionFuncional.md) (antipatrón)
- Cómo ***organizar*** las clases
  - [Relaciones entre clases](02-relacionesClases.md).
    - [Composición vs Herencia](04-composicionVsHerencia.md).
- Cómo ***describir*** lo anteriormente identificado
  - [Legibilidad de los artefactos](03-legibilidad.md).

> [Lectura extra](99-diseñoIdeasExtras.md)