# Acerca de este ejemplo

## Situación inicial

<div align=center>

|Universidad|Universidad|Universidad|
|:-:|:-:|:-:|
|[v1](OCP01)|[v2](OCP02)|[v3](OCP03)|
|Alumnos|Alumnos Erasmus|Alumnos Virtuales|

</div>

### *Sí*

|||
|-|-|
|**Principio Abierto/Cerrado**|El sistema está **abierto para extensión** (podemos añadir nuevos tipos de alumnos)|
||Pero **cerrado para modificación** (no necesitamos cambiar la clase `Universidad` ni `Alumno`)|
|**Polimorfismo**|La clase `Universidad` trabaja con referencias al tipo base `Alumno`|
||Puede operar con cualquier subclase sin conocer sus detalles específicos|
|**Estructura evolutiva**|Empezamos con un sistema simple|
||Lo extendemos gradualmente sin modificar el código existente|
||Cada tipo de alumno encapsula su comportamiento específico|
|**Métodos sobreescritos**|`calcularTasaMatricula()` se sobreescribe para proporcionar lógica específica|
||`generarInforme()` extiende el comportamiento base y añade información específica|

### [*Pero...*](limitaciones.md)