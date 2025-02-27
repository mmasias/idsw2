# Getters, setters y otros pecados

Los **getters** y **setters** son métodos en programación orientada a objetos que permiten acceder y modificar los valores de los atributos de una clase de manera controlada. Estos métodos pueden parecer simplemente prácticos, pero su uso adecuado o inadecuado puede tener implicaciones significativas en el diseño de software. 

Aquí analizaremos si son buenos, malos, y bajo qué circunstancias deberían implementarse.

## Ventajas de getters y setters

1. **Encapsulación**: Facilitan la encapsulación de datos al permitir que el acceso a los campos privados de una clase se realice de manera controlada. Esto significa que puedes cambiar la representación interna de los datos sin cambiar cómo otros objetos interactúan con ellos.
2. **Control adicional**: Permiten implementar lógica adicional cuando se accede o se modifica un campo. Por ejemplo, puedes verificar que el valor esté dentro de un rango aceptable antes de asignarlo a un campo.
3. **Flexibilidad de interfaz**: Hacen que el acceso a los datos de un objeto sea más flexible. Un setter, por ejemplo, podría emitir un evento o notificar a otros objetos sobre el cambio de estado.

## Desventajas de Getters y Setters

1. **Violación de encapsulación**: Paradójicamente, aunque están destinados a proteger la encapsulación, su uso incorrecto puede exponer detalles internos de la implementación de una clase más de lo deseable, facilitando el acoplamiento indebido entre clases.
2. **Sobrecarga de interfaz**: Añadir getters y setters por cada campo puede hacer que la interfaz de la clase se sobrecargue innecesariamente, lo que va en contra de la simplicidad y puede aumentar la complejidad del mantenimiento.
3. **Menor uso de OOP**: El uso excesivo de getters y setters puede llevar a un diseño basado en procesos en lugar de un diseño orientado a objetos, donde los comportamientos deberían estar encapsulados dentro de las clases junto con los datos que utilizan.

## ¿Cuándo usarlos?

- **Necesidad de lógica adicional**: Si necesitas realizar comprobaciones o modificaciones adicionales al obtener o establecer un valor.
- **Control de acceso**: Si diferentes campos requieren diferentes niveles de acceso, como privado para setters y público para getters.
- **Interfaz externa**: Cuando estás diseñando una API pública y necesitas mantener la consistencia y la flexibilidad para los usuarios de la API.
- **Encapsulación**: Cuando cambiar la implementación interna sin afectar a los consumidores de la clase es una prioridad.

### ¿Cuándo evitarlos?

- **Encapsulación simple**: Si los datos pueden ser `public` y no requieren control adicional, podrías considerar no usar getters/setters. Aunque esta es una práctica generalmente desaconsejada en OOP, puede ser adecuada en estructuras de datos simples y cerradas.
- **Clases de datos**: En clases que actúan puramente como contenedores de datos sin comportamiento adicional (como en los objetos de transferencia de datos), aunque incluso aquí se podría argumentar que la encapsulación aún es útil.
- **Demasiada exposición**: Si la exposición de todos los campos de una clase no es necesaria, no deberías crear getters y setters automáticamente.

## Conclusión

No existe una regla única para todos los casos sobre si los getters y setters son buenos o malos. Su uso depende del contexto específico y de los objetivos de diseño. **Implementarlos automáticamente en cada clase y para cada campo no es recomendable.** En su lugar, evalúe la necesidad de encapsulación, el nivel de acceso y la lógica adicional necesaria para cada campo.

Un diseño de software cuidadoso y considerado, que realmente aproveche las características de la programación orientada a objetos, es la mejor práctica.
