# Diseño

## ¿Por qué?

## ¿Qué?

<div align=center>

|Análisis|Diseño|
|-|-|
|Analizar los requisitos a través de su refinamiento y estructura para realizar una compresión más precisa de los requisitos, una descripción de los requisitos que es fácil de mantener y ayuda a estructurar el sistema.|Desarrollar enfocados en los requisitos no funcionales y en el dominio de la solución para preparar para la implementación y pruebas del sistema|
|Dar una especificación más precisa de los requisitos obtenidos en la captura de requisitos|Adquirir una comprensión profunda sobre los aspectos de los requisitos no funcionales y limitaciones relacionadas con:|
|Describir usando el lenguaje de los desarrolladores y poder introducir más formalismo y ser utilizado para razonar sobre el funcionamiento interno del sistema|- los lenguajes de programación,|
|Estructurar los requisitos de manera que facilite su comprensión, cambiándolos y, en general, mantenerlos|- la reutilización de componentes,|
|Acercase al diseño, aunque sea un modelo en sí mismo, y es por tanto un elemento esencial cuando el sistema está conformado en diseño e implementación|- sistemas operativos,|
||- tecnologías de distribución y concurrencia,|
||- tecnologías de bases de datos,|
||- tecnologías de interfaz de usuario,|
||- tecnologías de gestión de transacciones,|
||- y así sucesivamente|
|**Diseño suficiente** (JEDUF, Just Enough Design Upfront vs BDUF, Big Design Upfront)|**Diseño sistemas**|
|- Vista de diseño/lógica|- Vistas de implementación/desarrollo|
||- Vista física/despligue|

</div>

## ¿Para qué?

## ¿Cómo?


### Modelo del dominio

Origen de identificadores del problema/solución.

<div align=center>

|Cuando los programadores piensan en los problemas, en términos de comportamientos y responsabilidades de los objetos, traen con ellos un caudal de intuición, ideas y conocimientos provenientes de su experiencia diaria —|En lugar de un saqueador de bits que saquea estructuras de datos, nosotros tenemos un universo de objetos con buen comportamiento que cortésmente se solicitan entre sí cumplir diversos deseos —|
|-|-|
|*Budd, Programación Orientada a Objetos. 1994*|*Ingalls, Design Principles Behind Smalltalk. Byte vol. 6(8)*|

</div>

- [Estrategias de clasificación](01-estrategiasClasificacion.md).
  - [Descomposición Funcional](01.1-descomposicionFuncional.md) (antipatrón)
- [Relaciones entre clases](02-relacionesClases.md).
- [Composición vs Herencia](04-composicionVsHerencia.md).

### Legibilidad

Destino de identificadores del problema/solución junto con palabras reservadas y signos de puntuación.

- [Legibilidad de los artefactos](03-legibilidad.md).
