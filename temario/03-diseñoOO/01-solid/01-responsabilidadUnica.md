# Principio de responsabilidad única (SRP)

## ¿Por qué?

- *Problema de responsabilidades múltiples:* Una clase debe tener una única responsabilidad para ser fácilmente comprensible, modificable y mantenible.
- *Fragilidad del software:* Módulos que se ven afectados por cambios no relacionados debido a dependencias entre múltiples responsabilidades.
- *Dificultad para probar:* Las clases con múltiples responsabilidades son más difíciles de probar en un entorno aislado.

## ¿Qué?

- *Principio de responsabilidad única (SRP):* Una clase debe tener una sola razón para cambiar. Este principio fue acuñado por Robert Martin.
 
## ¿Para qué?

- *Separación clara de responsabilidades:* Mejora la comprensibilidad del código y su mantenimiento.
- *Flexibilidad y reutilización:* Facilita el cambio sin afectar otras partes del sistema.
- *Mejora en las pruebas:* Aísla los cambios, permitiendo pruebas más simples y efectivas.

## ¿Cómo?

### ¿A qué hace referencia el término "cambiar" en el SRP?

*Cambiar* se refiere a la modificación o actualización del código de una clase debido a cambios en los requisitos del negocio, corrección de errores o adición de nuevas funcionalidades.

- Clase con más de una responsabilidad >> hace más de una cosa. 
  - Si hace más de una cosa >> es posible que deba cambiar en más de una ocasión.
     - Cambia mucho >> aumenta la complejidad y el riesgo de errores.

||
|-|
Cada clase debe tener una única responsabilidad bien definida y limitada
Cualquier cambio necesario en esa responsabilidad solo debería requerir cambios en la propia clase, sin afectar a otras partes del sistema.

De esta manera, se pueden mantener las clases de forma independiente y se reduce el acoplamiento entre ellas, lo que facilita el mantenimiento, la reutilización y la evolución del sistema.

## Ejemplos

- [Ejemplo con empleado y salario](S_ejemplosEmpleadoSalario.md)
- [Ejemplo con una biblioteca](S_ejemploBibliotecaPrestamo.md)


## Cohesión

- *Cohesión:* Grado en que los subelementos dentro de un módulo están relacionados entre sí.
- *Tipos de cohesión:* Desde coincidental (la menos deseada) hasta funcional (la más deseada).

|Tipo de cohesión|Descripción|Ejemplo|
|-|-|-|
|Coincidente   | Las tareas de un módulo están agrupadas arbitrariamente y no tienen relación entre sí. | Un módulo que tiene funciones de cálculo matemático junto a funciones de lectura de archivos. |
|Lógica        | Las funciones del módulo están agrupadas por su tipo, pero solo se ejecuta una según una condición. | Un módulo que contiene funciones para diferentes operaciones de impresión, donde una condición determina si se imprime en PDF, papel o fax. |
|Temporal      | Las funciones de un módulo están agrupadas porque se ejecutan en el mismo tiempo, como durante la inicialización. | Un módulo que contiene funciones para inicializar las configuraciones de red, pantalla y sonido al arrancar un sistema. |
|Procedimental | Las funciones están relacionadas porque se ejecutan en un orden secuencial específico. | Un módulo que valida un formulario, lo guarda y luego envía una confirmación al usuario en un flujo ordenado. |
|Comunicacional| Las funciones están relacionadas porque utilizan los mismos datos o recursos de entrada/salida. | Un módulo que contiene funciones para validar, calcular e imprimir un informe financiero usando la misma fuente de datos. |
|Secuencial    | Las funciones están relacionadas porque la salida de una es la entrada de otra.    | Un módulo que procesa datos en tres etapas: lectura, transformación y escritura. La salida de una etapa alimenta a la siguiente. |
|Funcional     | Todas las funciones del módulo están orientadas a una única tarea claramente definida. | Un módulo dedicado a la autenticación de usuarios que tiene funciones para verificar credenciales, generar tokens y mantener sesiones activas. |

Estos tipos de cohesión van desde la menos deseada (coincidental o accidental) hasta la más deseada (funcional).
