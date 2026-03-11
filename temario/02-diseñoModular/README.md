# Diseño modular

## ¿Por qué?

En el desarrollo de software actual, frecuentemente se enfrentan proyectos que terminan con resultados insatisfactorios: sistemas que fallan en cumplir con los requisitos establecidos, sobrepasan los plazos planificados o exceden los presupuestos asignados. Esta situación refleja problemas fundamentales en la práctica del desarrollo de software.

El origen de estas dificultades puede identificarse en diversas manifestaciones de una calidad deficiente:

|Ineficacia|Ineficiencia|Inefectividad|
|-|-|-|
|No se consigue entregar el producto en el **plazo** establecido.|No se puede desarrollar el sistema dentro del **coste** previsto.|No se logra ofrecer la funcionalidad requerida en el **ámbito** acordado.|

Más allá de estas variables económicas, los sistemas desarrollados con frecuencia presentan problemas de calidad que afectan a todo su ciclo de vida:

- **Baja fiabilidad**: El sistema falla con frecuencia en entornos de producción.
- **Escasa usabilidad**: Los usuarios encuentran el sistema difícil de utilizar.
- **Insuficiente interoperabilidad**: El sistema no se integra adecuadamente con otros sistemas.
- **Pobre seguridad**: La aplicación presenta vulnerabilidades explotables.

Sin embargo, el problema más crítico y costoso a largo plazo es la **deficiente mantenibilidad**, que se manifiesta en sistemas:

- **Viscosos**: No se pueden *entender* con facilidad debido a su *estructura* compleja y desorganizada.
- **Rígidos**: No se pueden *modificar* con facilidad porque cualquier *cambio* requiere ajustes en múltiples lugares.
- **Frágiles**: No se pueden *probar* con facilidad porque las modificaciones provocan *errores en partes aparentemente no relacionadas*.
- **Inmóviles**: No se pueden *reutilizar* con facilidad porque sus componentes están fuertemente *acoplados* entre sí.

Estas deficiencias suelen ser el resultado de una **complejidad arbitraria** introducida por decisiones de diseño inadecuadas o por la ausencia de un diseño deliberado.

### ¿Pero, el [diseño](/temario/01-diseño/README.md#cómo) no basta?

Una creencia errónea pero común es que un diseño inspirado directamente en el modelo del dominio garantiza por sí mismo un código de calidad. Sin embargo, la experiencia demuestra que este enfoque puede resultar en sistemas con graves problemas estructurales:

<div align=center>

|![](/images/modelosUML/disenoModular.svg)
|-:
<sub>[Código fuente](/modelosUML/disenoModular.puml)</sub>

||||
|-|-|-|
Clases que acumulan demasiadas responsabilidades por ser "expertos en información"|Componentes acoplados a múltiples tecnologías (interfaz, persistencia, comunicaciones)|Entidades que asumen responsabilidades que deberían estar distribuidas.

|Viscoso|Rígido|Inmóvil|Frágil|
|-|-|-|-|
Presencia de multitud de **clases enormes** con **métodos enormes** con **acoplamientos cíclicos** sin un nítido reparto de responsabiliades|**Responsabilidades repartidas por multitud de clases** que requieren modificaciónes si cambian los requisitos correspondientes.|Presencia de **multitud de clases acopladas a multitud de clases de diversas tecnologías** (GUI, comunicaciones, bases de datos, servicios, etc.​)|**Ausencia de red de seguridad de pruebas unitarias** por imposibilidad de realizar pruebas sobre las clases anteriores

</div>

> [Otro ejemplo](ejemplo/diseñoBasadoMdD.md)

Los intentos de desarrollar un sistema de calidad sin principios de diseño sólidos suelen conducir a estructuras difíciles de entender, modificar, probar y reutilizar.

## ¿Qué?

El Diseño Modular constituye un enfoque fundamental para abordar los problemas anteriormente descritos. Se trata de un conjunto de principios y prácticas orientados a estructurar el software en componentes bien definidos, con responsabilidades claras e interacciones controladas.

Este enfoque tiene sus raíces en los trabajos pioneros de:

- **Larry Constantine**, quien definió las métricas de cohesión en la década de 1960.
- **David Parnas**, que publicó "Sobre los criterios que se utilizarán en la descomposición de sistemas en módulos" en 1972.
- **Larry Constantine, Ed Yourdon y Wayne Stevens**, quienes desarrollaron formalmente el concepto de Diseño Estructurado en 1974.
- **Ed Yourdon y Larry Constantine**, que consolidaron estos principios en su obra "Diseño Estructurado" en 1979.

El Diseño Modular se fundamenta en tres criterios fundamentales que debe cumplir todo módulo (sea método, clase o paquete):

<div align=center>

|Alta cohesión|Bajo acoplamiento|Tamaño adecuado|
|-|-|-|
|Los elementos dentro de un módulo deben estar fuertemente relacionados entre sí y contribuir a un propósito unificado.|Las dependencias entre módulos deben minimizarse para reducir el impacto de los cambios y facilitar la evolución independiente.|Cada componente debe tener dimensiones apropiadas para su nivel de abstracción, facilitando su comprensión y mantenimiento.

</div>

Estos tres principios, aplicados de manera consistente, constituyen la base para crear software que sea simultáneamente comprensible, modificable, testeable y reutilizable.

### Cohesión

<div align=center>

|||
|-|-|
La cohesión, o más específicamente, la cohesión funcional, es una medida de cómo de fuerte están relacionadas y enfocadas las responsabilidades que son de un elemento. Estos elementos incluyen sistemas, paquetes, clases y métodos.<br><br><sub>Larman, UML y Patrones</sub>|<sub>*Si una persona no integra a sus colaboradores (partes, agregados, asociados y/o usos), sobrecarga su canal cognitivo (capacidad cuantitativa mental) al responsabilizarse de múltiples asuntos en lugar de uno único.*</sub>

|Alta cohesión|Baja cohesión|
|-|-|
Responsabilidades muy relacionadas|Responsabilidades poco relacionadas 
No hace una enorme cantidad de trabajo|Con una enorme cantidad de trabajo
Delega en otros|Asignando un "grano muy grande" de abstracción o asumiendo responsabilidades que deberían haber sido delegadas en otros
Una clase con alta cohesión tiene un número relativamente pequeño de métodos, con una funcionalidad muy relacionadas, y no hace demasiado trabajo. Colabora con otros objetos para compartir el esfuerzo si la tarea es grande|Clase con responsabilidades ligeras y únicas en unas pocas áreas diferentes que están lógicamente relacionadas con el concepto de la clase, pero no entre sí.

</div>

#### Compromisos

Casos muy específicos en los que se justifica la aceptación de una cohesión menor:

- ***Clases de utilidad***: agrupación de responsabilidades o código en una clase o componente para simplificar el mantenimiento de una persona aunque se advierte que tal agrupación también puede hacer el mantenimiento peor.
  - Ej.: la clase System en Java (`java.lang.System`). Agrupa `in`, `out`, `err`, `gc()`, `arraycopy()`, `currentTimeMillis()`, `exit()`, `getenv()`... Responsabilidades sin relación funcional entre sí: I/O estándar, gestión de memoria, operaciones de array, tiempo del sistema, control de proceso. Cohesión funcional: nula. La justificación no es de diseño sino de mantenimiento operativo: un único punto de acceso a servicios de bajo nivel del runtime evita que el desarrollador deba conocer qué clase concreta gestiona cada aspecto de la JVM. La agrupación está justificada si los elementos agrupados comparten un *contexto de uso* estable aunque no compartan responsabilidad funcional, y si la audiencia del componente es lo suficientemente amplia como para que el punto de acceso único tenga valor real.
- ***Servidores distribuidos***: por mantenimiento y rendimiento (justificado!!!) a veces es deseable crear menos y más grandes objetos servidores, menos cohesivos que proporcionan una interfaz para muchas operaciones. 
  - Ej.: la fachada de un servicio REST complejo. En sistemas distribuidos, cada llamada remota tiene un coste fijo: latencia, serialización y riesgo de fallo de red. Un diseño de grano fino con objetos muy cohesivos puede exigir decenas de viajes de red para completar una sola operación de negocio, lo que lo hace inviable en producción. La solución es una fachada de grano grueso que expone operaciones completas (`procesarPedido()`, `consultarEstadoCliente()`) aunque agrupe responsabilidades heterogéneas. La baja cohesión es el precio explícito de reducir llamadas remotas; internamente, esa fachada delega en objetos cohesivos. La justificación exige que el problema de rendimiento sea real y medible, no una suposición.

### Acoplamiento

|||
|-|-|
El acoplamiento es una medida de la fuerza con la que un elemento está conectado a (o *tiene conocimiento de*, o *se basa en*) otros elementos. Estos elementos incluyen sistemas, paquetes, clases y métodos.|*Si una persona interactúa con demasiados colaboradores (partes, agregados, asociados y/o usos), sobrecarga su canal cognitivo (capacidad cuantitativa mental) al superar su capacidad de atención simultánea.*

<div align=center>

|Bajo|Moderado|Alto|
|-|-|-|
No es dependiente de muchos elementos||Sí es dependiente de muchos elementos
Especialmente en las clases que son de naturaleza *muy* genéricas y con una alta probabilidad para su reutilización.|Es normal y necesario para la creación de un sistema orientado a objetos en el que las tareas se cumplen por una colaboración entre los objetos conectados|Con elementos estables y generalizados rara vez es un problema. El alto acoplamiento *per se* no es el problema. El problema es el acoplamiento a elementos que son inestables en alguna dimensión, como su interfaz, su implementación, o su mera presencia.

</div>

Los diseñadores han de elegir sus batallas en la reducción de acoplamiento y centrarse en los puntos de alta inestabilidad o evolución realista.

### Tamaño

<div align=center>

|||
|-|-|
El tamaño es una medida de la cantidad de código que compone un elemento: líneas de código, número de métodos, número de atributos, número de parámetros. A diferencia de la cohesión —que describe la relación entre responsabilidades— y del acoplamiento —que describe las conexiones con otros elementos—, el tamaño mide el volumen bruto de lógica que un elemento contiene y que un lector debe procesar de forma simultánea.<br><br><sub>McConnell, Code Complete</sub>|<sub>*Si una persona acumula demasiadas tareas en un único espacio de trabajo, sobrecarga su canal cognitivo aunque cada tarea sea simple: la carga no procede de la complejidad individual de cada tarea, sino del volumen total que debe mantenerse activo al mismo tiempo.*</sub>

|Tamaño reducido|Tamaño excesivo|
|-|-|
Lógica contenida en unidades mínimas comprensibles|Lógica acumulada en unidades de gran volumen
Favorece la lectura, el test unitario y la localización de errores|Dificulta la comprensión, el aislamiento de fallos y el mantenimiento
Consecuencia natural de alta cohesión y bajo acoplamiento|Síntoma frecuente de baja cohesión o de responsabilidades no delegadas
Un elemento de tamaño reducido puede entenderse de forma independiente, sin retener en memoria el contexto de otras partes del sistema|Un elemento de gran tamaño obliga a mantener simultáneamente múltiples contextos, superando la capacidad de la memoria de trabajo

</div>

#### Compromisos

Casos muy específicos en los que se justifica la aceptación de un tamaño mayor:

- ***Máquinas de estado o parsers de protocolo***: la implementación de un protocolo complejo (un autómata TCP, un parser de gramática formal) puede requerir una estructura extensa —un `switch` de gran escala, una serie de producción completa— que, si se descompone artificialmente en métodos pequeños, pierde la correspondencia estructural con la especificación que implementa. Esa correspondencia es ella misma una forma de documentación verificable: cada estado del diagrama debe poder localizarse directamente en el código.
  - La justificación exige que la especificación de referencia exista y sea estable, y que la descomposición alternativa no preserve esa trazabilidad.

- ***Objetos de valor con semántica cerrada***: una clase como `BigDecimal` o una implementación completa de fecha y hora necesita un conjunto amplio de operaciones para ser autosuficiente. Dividirla en múltiples clases colaboradoras introduce acoplamiento para compensar exactamente lo que la división eliminó, sin reducir la complejidad real.
  - La justificación exige que todas las operaciones compartan un único dominio semántico estable y que la clase no tenga dependencias externas: el tamaño es entonces la representación directa de la riqueza del concepto, no de una falta de diseño.



## ¿Para qué?

La aplicación sistemática de los principios del Diseño Modular produce sistemas con las siguientes características positivas:

<div align=center>

|Eficacia|Eficiencia|Efectividad|
|-|-|-|
|Se consigue entregar el producto en los plazos establecidos.|Se desarrolla el sistema dentro de los costos previstos.|Se logra cumplir con el ámbito funcional requerido.|

</div>

Más allá de las variables económicas, los sistemas desarrollados bajo estos principios presentan cualidades técnicas superiores:

- **Alta fiabilidad**: El sistema funciona consistentemente según lo esperado.
- **Buena usabilidad**: Los usuarios pueden interactuar con el sistema de manera intuitiva.
- **Adecuada interoperabilidad**: El sistema se integra fácilmente con otros sistemas.
- **Robusta seguridad**: La aplicación resiste intentos de explotación maliciosa.

Sin embargo, la ventaja más significativa y valiosa a largo plazo es la **excelente mantenibilidad**, que se manifiesta en sistemas:

- **Fluidos**: Se pueden entender con facilidad gracias a su estructura clara y organizada.
- **Flexibles**: Se pueden modificar con facilidad porque los cambios están localizados.
- **Robustos**: Se pueden probar con facilidad porque las modificaciones no provocan efectos secundarios inesperados.
- **Reusables**: Se pueden reutilizar componentes con facilidad porque están débilmente acoplados.

<div align=center>

|Diseño Modular Adecuado||||Diseño Modular Deficiente|
|-|-:|:-:|:-|-|
|Comprensible|**Fluidez**|*vs*|**Viscosidad**|Difícil de entender|
|Adaptable al cambio|**Flexibilidad**|*vs*|**Rigidez**|Resistente a modificaciones|
|Resistente a fallos|**Robustez**|*vs*|**Fragilidad**|Propenso a errores inesperados|
|Aprovechable en otros contextos|**Reusabilidad**|*vs*|**Inmovilidad**|Limitado a su contexto original|

</div>

Como expresa elocuentemente la analogía de la construcción de mosaicos:

<div align=center>

|![](/images/mosaicosGrandes.jpg)|![](/images/mosaicosPequeños.jpg)|
|-|-|
*Es difícil hacer cualquier mosaico con fichas grandes de varios colores (baja cohesión) y formas irregulares (alto acoplamiento).*|*Es fácil hacer cualquier mosaico con fichas pequeñas de un solo color (alta cohesión) y formas cuadradas (bajo acoplamiento).*

</div>

## ¿Cómo?

### Fundamentos

- **[Modularidad](modularidad.md)** y **[jerarquización](jerarquizacion.md)**: Para estructurar sistemas complejos en niveles comprensibles.

### Principios fundamentales

- **[Acoplamiento](acoplamiento.md)**: Para aprender a minimizar dependencias entre componentes
- **[Cohesión](cohesion.md)**: Para entender cómo crear componentes con responsabilidades enfocadas
- **[Tamaño](tamaño.md)**: Para dominar el arte de dimensionar adecuadamente cada elemento

### Técnicas complementarias

- **[Abstracción de interfaz](abstraccionInterfaz.md)**: Para definir contratos claros entre componentes
- **[Diseño por contrato](diseñoContrato.md)**: Para formalizar precondiciones, postcondiciones e invariantes
- **[Patrones de indirección](patronesIndireccion.md)**: Para implementar mecanismos específicos de desacoplamiento

### Resumen

|Acoplamiento|Cohesión|Tamaño|
|-|-|-|
|El acoplamiento mide el grado de interdependencia entre los módulos de un sistema.|La cohesión evalúa el grado en que los elementos dentro de un módulo se relacionan entre sí y contribuyen a un propósito unificado.|El principio de tamaño establece dimensiones óptimas para los diferentes componentes del software.|
|Una comprensión profunda de este principio incluye:|Un estudio detallado de este principio abarca:|Un análisis completo de este principio contempla:|
|**Definición formal** de acoplamiento y sus tipos|**Definición formal** de cohesión y sus implicaciones|**Restricciones dimensionales** recomendadas para cada nivel: paquete, clase y método|
|**Acoplamiento aferente vs. eferente** / **Acoplamiento directo vs. indirecto** y sus implicaciones|**Niveles de cohesión**, desde la coincidental (más baja) hasta la funcional (más alta)|**Fundamentos cognitivos** que justifican estas restricciones|
|**Ley de demeter** como guía para reducir el acoplamiento||**Complejidad ciclomática** como medida de complejidad del código|
|**Identificación de code smells** relacionados con el acoplamiento: intimidad inapropiada, cadenas de mensajes, feature envy, middle man|**Identificación de code smells** que señalan problemas de cohesión: envidia de características, clases de datos, cambios divergentes, cirugía a escopetazos, grupos de datos, obsesión por tipos primitivos, clases perezosas|**Identificación de code smells** vinculados a problemas de tamaño: métodos largos, listas de parámetros largas, clases grandes, anidamiento excesivo|
|**Métricas** para cuantificar el acoplamiento|**Técnicas de refactorización** para mejorar la cohesión|**Técnicas de refactorización** específicas para reducir el tamaño|
||**Métricas** para evaluar objetivamente la cohesión|**Herramientas de análisis** para monitorizar y controlar el tamaño|

### Sinergia de los tres principios

La verdadera potencia del Diseño Modular surge cuando estos tres principios se aplican de manera conjunta y coordinada:

- La **alta cohesión** facilita el **bajo acoplamiento** al concentrar responsabilidades relacionadas
- El **bajo acoplamiento** permite mantener un **tamaño adecuado** al separar claramente las preocupaciones
- El **tamaño adecuado** promueve la **alta cohesión** al limitar la cantidad de responsabilidades que puede asumir un módulo. Es la señal observable de que los otros dos principios se están aplicando correctamente.

## ¿Y ahora qué?

1. **Aplicar estos principios y técnicas** de manera práctica en proyectos reales, utilizando refactorizaciones sistemáticas para mejorar diseños existentes.
2. **Integrar herramientas de análisis** que permitan evaluar objetivamente la calidad del diseño según estos principios.
