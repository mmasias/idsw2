# Modularidad

## ¿Por qué?

El software que crece sin una estrategia de descomposición explícita se convierte rápidamente en un problema inabarcable. Un sistema de 100.000 líneas de código no puede comprenderse como una unidad: la capacidad cognitiva humana tiene límites precisos y bien documentados.

El enfoque más habitual —y más dañino— ante este problema es la descomposición basada en los pasos del algoritmo: se identifica la secuencia de operaciones que el sistema debe ejecutar y se crea un módulo para cada paso. Esta estrategia tiene un defecto fundamental:

> "Si el criterio de descomposición es el flujo de ejecución, los módulos cambian juntos cuando el algoritmo cambia."

El resultado es un sistema donde:

- **Ningún módulo puede entenderse de forma aislada**: para comprender el paso 3, hay que conocer el estado que deja el paso 2.
- **Los cambios se propagan**: modificar la lógica de un paso obliga a revisar los módulos adyacentes que consumen o producen ese estado.
- **El desarrollo en paralelo es inviable**: los módulos comparten estado intermedio y no pueden desarrollarse ni probarse de forma independiente.
- **La reutilización es prácticamente imposible**: los módulos están concebidos para ese algoritmo concreto, no como unidades con valor propio.

David Parnas (1972) identificó este problema con precisión: la pregunta relevante no es *si* descomponer, sino *cómo trazar la frontera* entre módulos.

## ¿Qué?

La modularidad es el principio de descomposición del software en unidades con fronteras bien definidas, responsabilidades claras y una superficie de comunicación mínima con el resto del sistema.

Un módulo es un concepto de diseño, no un concepto técnico. Se materializa en distintos niveles de la jerarquía del sistema:

<div align=center>

|Método|Clase|Paquete|
|-|-|-|
|Unidad mínima de encapsulación de lógica|Unidad de encapsulación de estado y comportamiento|Unidad de encapsulación de clases relacionadas|
|Oculta un algoritmo o una decisión de implementación|Oculta la representación interna de un concepto|Oculta la estructura interna de un subsistema|

</div>

El criterio de Parnas para trazar correctamente las fronteras es la **ocultación de información** (*information hiding*): cada módulo debe encapsular una decisión de diseño susceptible de cambiar, de modo que ese cambio no obligue a modificar ningún otro módulo.

> "Propongo que se utilice como criterio de modularización la ocultación de decisiones de diseño difíciles o susceptibles de cambiar. Cada módulo se caracteriza entonces por su conocimiento de una decisión de diseño que oculta a todos los demás."
>
> — David Parnas, *On the Criteria To Be Used in Decomposing Systems into Modules* (1972)

La frontera correcta no separa *pasos* de un algoritmo, sino *decisiones*: la decisión sobre qué estructura de datos usar internamente, la decisión sobre qué API externa invocar, la decisión sobre cómo persistir el estado. Cuando esa decisión cambia, solo cambia el módulo que la oculta.

## ¿Para qué?

Una descomposición basada en ocultación de información produce sistemas donde:

- **Cada módulo puede entenderse de forma aislada**: conocer su interfaz es suficiente para usarlo; conocer su implementación solo es necesario para modificarlo.
- **Los cambios quedan contenidos**: modificar la decisión oculta en un módulo no afecta a los módulos que lo usan, siempre que la interfaz se mantenga estable.
- **El desarrollo puede paralizarse**: módulos con interfaces definidas pueden desarrollarse y probarse de forma independiente por distintos miembros del equipo.
- **La reutilización es posible**: un módulo que oculta una decisión concreta puede transportarse a otro contexto que necesite esa misma capacidad.

<div align=center>

| Modularidad efectiva |||| Modularidad deficiente |
|-|-:|:-:|:-|-|
|Comprensible por partes        |**Fluidez**|     *vs*|**Viscosidad**  | Requiere retener el sistema completo |
|Cambios localizados            |**Flexibilidad**|*vs*|**Rigidez**| Cambios que se propagan |
|Desarrollo paralelo viable     |**Robustez**|*vs*|**Fragilidad**| Módulos interdependientes, imposibles de probar solos |
|Unidades transportables        |**Reusabilidad**|    *vs*|**Inmovilidad**  | Código atado a su contexto original |

</div>

## ¿Cómo?

### Número de módulos

<div align=center>

|Costes de la modularización|Es un compromiso, un equilibrio|
|-|-|
|- el ***coste de desarrollo*** de cada módulo, pocos muy grandes es más costoso que muchos muy pequeños<br>- el ***coste de integración*** de todos los módulos, muy pocos cuesta poco y muchos cuesta mucho|![](/images/compromisosModularizacion.jpg)

</div>

Se parte un problema para ser efectivos, eficaces y eficientes, resolviendo problemas más pequeños, **¡pero cuando el problema requiere partirse y no antes**!

<div align=center>

|Aplicación mediana (100.000 LoC)|Muchos módulos|Número equilibrado de módulos|Pocos módulos
|-|:-:|:-:|:-:|
|Costes de desarrollo|**Reducido**|*Equilibrado*|Disparado
|Costes de integración|Disparado|*Equilibrado*|**Reducido**
|Costes totales|Disparado|*Equilibrado*|Disparado

</div>

### Distribución de responsabilidades

<div align=center>

||||
|-|:-:|-|
|![](/images/modularizacionMalDistribuida.png)|También de forma equilibrada,<br>con una media y una desviación típica<br>reducidas de la carga relativa de la responsabilidad total:<br>se trata de partir el problema,<br>no de trasladarlo!|![](/images/modularizacionBienDistribuida.png)|

</div>
