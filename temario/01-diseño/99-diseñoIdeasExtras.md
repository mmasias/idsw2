# Lecturas extras

## del ¿Por qué?

"El objetivo final de cualquier actividad de ingeniería es algún tipo de documentación. Una vez finalizado el diseño, la documentación se entrega al equipo de fabricación. Este es un grupo completamente diferente, con habilidades completamente distintas a las del equipo de diseño. ***Si los documentos de diseño realmente representan un diseño completo, el equipo de fabricación puede proceder a construir el producto. De hecho, pueden construir gran parte del producto, sin necesidad de intervención de los diseñadores.***"

*Jack W. Reeves , “ ¿Qué es el diseño de software? ”, 1992*

## del ¿Qué?

> **El diseño es la herramienta** que nos permite transformar un problema complejo en una solución manejable, comprensible y mantenible. Es el puente entre el caos del código sin estructura y la armonía de un sistema bien construido.

Al hablar de la arquitectura de un sistema, hay al menos cinco áreas diferentes (aunque relacionadas) que deben considerarse.

<div align=center>

|Información|Funcional|Interfaces|Tecnología/Infraestructura|Software|
|-|-|-|-|-|
¿Cuáles son las principales entidades/objetos/facetas que debe considerar el sistema y cómo se identificará cada una de estas cosas?|¿Qué funciones comerciales se realizarán y cómo se relacionan entre sí y con otras funciones que están fuera del alcance?|¿Cómo navegará el usuario a través del sistema, cómo se verá el sistema y qué tipo de controles especiales u otros elementos de UI pueden ser necesarios?|¿Qué tecnologías utilizará el proyecto y qué papel desempeñarán? ¿En qué infraestructura (tanto hardware como software) se ejecutará la aplicación? ¿Qué herramientas de desarrollo se utilizarán?|¿Qué módulos de software, o tipos de módulos, se escribirán y cómo se relacionarán entre sí?

</div>

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

## del ¿Para qué?

El diseño existe para resolver problemas fundamentales que surgen cuando construimos sistemas complejos:

<div align=center>

|Problema|Propósito|
|-|-|
|**Complejidad cognitiva**|Manejar la complejidad mediante **abstracción** y **descomposición** en unidades comprensibles|
|**Cambio constante**|Crear sistemas **flexibles** y **extensibles** que absorban cambios sin romperse|
|**Riesgo de fracaso**|Reducir la **incertidumbre** mediante decisiones tempranas sobre arquitectura y estructura|
|**Dificultad de mantenimiento**|Facilitar la **evolución** del sistema mediante código legible y modular|
|**Colaboración en equipo**|Establecer un **lenguaje compartido** y estructura clara que permita trabajo paralelo|
|**Reutilización ineficiente**|Identificar **componentes reutilizables** y patrones probados|
|**Deuda técnica acumulada**|Prevenir o gestionar la **deuda técnica** mediante decisiones arquitectónicas sólidas|

</div>

