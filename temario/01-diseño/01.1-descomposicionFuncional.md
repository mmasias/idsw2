# Antipatrón descomposición funcional

## ¿Por qué?

La descomposición funcional es un problema común que aparece cuando los desarrolladores piensan en términos de funciones y procedimientos, y tratan de trasladar ese pensamiento directamente a la programación orientada a objetos. Este antipatrón surge del intento de "disfrazar" código procedural como si fuera orientado a objetos.

## ¿Qué?

La descomposición funcional ocurre cuando, en lugar de pensar en términos de objetos y sus responsabilidades, tomamos un enfoque procedural y simplemente convertimos cada función o procedimiento en una clase. Esto resulta en un diseño que, aunque usa la sintaxis de objetos, mantiene una mentalidad completamente procedural.

### Ejemplo

<div align=center>

|[Con DF](/temario/01-diseño/src/vConDF/)|[Sin DF](/temario/01-diseño/src/vSinDF/)|
|-|-|
|ActualizarInventario|Venta|
|CalcularPrecio|Producto|
|GenerarFactura||
|ProcesarVenta||
|Producto||
|ValidarInventario||

</div>

## ¿Para qué?

Reconocer este antipatrón nos permite:

- Identificar cuando estamos simplemente "disfrazando" código procedural.
- Mejorar nuestro diseño orientado a objetos.
- Entender mejor cómo pensar en términos de objetos y responsabilidades.
- Evitar crear jerarquías de clases que son realmente procedimientos disfrazados.

## ¿Cómo?

Para evitar caer en este antipatrón, podemos seguir estas pautas:

1. Pensar en términos de objetos y sus responsabilidades naturales.
1. Evitar crear clases cuyo nombre sea un verbo o acción.
1. Preguntarnos si una clase representa una entidad real de nuestro dominio.
1. Analizar si estamos simplemente envolviendo una función en una clase.
1. Identificar qué objeto debería ser realmente responsable de cada comportamiento.

### Síntomas

- Clases cuyos nombres son verbos (CalcularPrecio, ValidarDatos, ProcesarVenta).
- Clases que tienen un único método (generalmente llamado ejecutar(), procesar() o run()).
- Una clase "controladora" que orquesta todas las operaciones.
- Clases que no tienen estado, solo comportamiento.
- Jerarquía de clases que refleja una descomposición de pasos procedurales.

## Consecuencias

- Código que es más difícil de mantener y entender.
- Objetos sin identidad clara en el dominio del problema.
- Dificultad para reutilizar el código.
- Mayor acoplamiento entre componentes.
- Pérdida de las ventajas de la orientación a objetos.
- Dificultad para extender o modificar el comportamiento.

## Observaciones adicionales

- Este antipatrón es especialmente común en desarrolladores con fuerte background en programación procedural.
- A veces puede ser tentador crear una clase para cada operación, pensando que esto hace el código más "orientado a objetos".
- La clave está en identificar los objetos naturales del dominio y sus responsabilidades.
- Una buena pregunta para detectarlo es: "¿Esta clase representa algo o solo hace algo?".
