# Software

## ¿Por qué?

### Hardware

La humanidad gracias a sus herramientas y, en particular, al conocimiento (ciencias, ingenierías, etc.), ha construido grandes sistemas artificiales: acueductos, telares con tarjetas perforadas, red eléctrica, red telefónica, etc.​ para automatizar tareas, o sea, simplificar y reutilizar

- 8000 aec., Los sumerios construyen telares para cubrirse
- 1642 ec., Blaise Pascal construye la Pascalina, primera calculadora mecánica girando ruedas
- 1801 ec., Jacquard construye el primer telar mecánico y automático con tarjetas perforadas para definir los dibujos
- 1842 ec., Charles Babbage y Ada Lovalace trabajan sobre la Máquina Analítica, con las tarjetas perforadas de los telares …​ pero no llegó a funcionar aunque Ada ya escribió las primeras líneas de código de la historia.
- 1884 ec., Hollerith desarrolló la Máquina Tabular de tarjetas perforadas para ordenar el registro de propiedad en la Conquista del Oeste
- 1936 ec., Konrad Zuse, ingeniero alemán, diseñó y fabricó la Z1, la que para muchos es la primera computadora programable de la historia

## ¿Qué?

<div align=center>

|Software||
|:-:|-|
|**Es la información que suministra el desarrollador al ordenador<br><br>para que manipule -de forma automática-<br><br>la información que suministrará el usuario**<br><br><div align=right>*[Brad Cox](https://keepcoding.io/blog-frr/brad-cox-creador-de-objective-c-in-memoriam/), inventor del [Objetive-C](https://es.wikipedia.org/wiki/Objective-C)*</div>|![](/images/modelosUML/modelosUML/sistemaDeInformacion.svg)|

</div>

### Naturaleza de lenguajes y formatos

<div align=center>

||||
|-|-|-|
|Programas en lenguajes de programación (Java, C/C++, …​),|Scripts para la generación de páginas dinámicas en aplicaciones Web (JSP, PHP,…​),|Datos de configuración en diversos formatos (texto libre, XML, JSON, …​)|
|Scripts para la creación de las tablas de las bases de datos y su población (SQL),|Presentaciones en lenguajes de formato para aplicaciones Web (HTML, CSS, …​)|Multimedia en formatos de imagen, sonido o video para elementos gráficos en la Interfaz de Usuario (*.png, *.waw, *.mpeg, …​)|

</div>

## ¿Para qué?

<div align=center>

| | Capacidad cualitativa | Capacidad cuantitativa |
| :--- | :--- | :--- |
| **Ser humano** | Muy buena: reconocimiento de patrones, asociaciones, recursividad, ... | Muy mala: pequeña, errores por cansancio, desmotivación, ... y muy lentos |
| **Máquina** | En progreso : modelos recientes (GPT-4) ya logran engañar a humanos en pruebas ciegas (~54%-73%), aunque su comprensión real sigue en debate. ([Ver estudio](https://arxiv.org/abs/2503.23674)) | Muy buena: sin errores y a toda velocidad |
| ***No obstante!!!*** | *La brecha se ha reducido: [patrones](https://x.com/mfarajtabar/status/1844456880971858028?s=61) / [Turing](https://cacm.acm.org/news/beyond-turing-testing-llms-for-intelligence/)* | *La brecha se mantiene (o se amplifica!!!)* |

---

|![](/images/modelosUML/modelosUML/software.svg)|
|-|

</div>

### Sistema de información

|Conjunto de elementos orientados al tratamiento y administración de datos e información|organizados y listos para su uso posterior|generados para cubrir una necesidad o un objetivo|
|:-:|:-:|:-:|

- **Gestión** (CRUD), es el tratamiento de la información:
  - **altas** (Create) de información en el sistema
  - **bajas** (Delete) de información en el sistema
  - **modificaciones** (Update) de información en el sistema
  - **consultas** (Read) de información en el sistema

## ¿Cómo?

**El trabajo con software es el más complejo que jamás haya emprendido la humanidad** — F. Brooks

<div align=center>

|Métrica|Don Quijote de la Mancha|Proyecto de software|
|-|-|-|
|**Extensión**|300.000 palabras|Proyecto mediano: 100.000 lineas y ~3 palabras/línea|
|**Entidades**|*Dulcinea, Sancho Panza*, …​ decenas|*identificadores* …​ centenares|
|**Autor**|Miguel de Cervantes Saavedra|6-8 personas|
|**Duración**|18 años|entre 6 meses y años|
|**Coste**|"gratis" (en la cárcel)|Miles de €|
|**Ámbito**|suyo|Definido por otra(s) persona(s)|

</div>

> [***Hablando de proyectos...***](pySW.md)

### Sistemas

<div align=center>

|Sistema de software|¿Es complejo?|
|-|-|
|Conjunto de clases/módulos relacionándose por herencia, composición, … o interdependientes formando una aplicación.<br><br>Cada aplicación está:<br><br>- Delimitada por su entorno tecnológico-comercial<br>- Descrito por su arquitectura de software y requisitos <br>- Expresado en su ejecución|Software de una aplicación media (~100.000 líneas de código) tiene una complejidad que excede con creces la capacidad intelectual humana|

</div>

### Características de los sistemas complejos

<div align=center>

|Estructura jerárquica|Elementos primitivos relativos|Separación de asuntos|Patrones comunes|Formas intermedias estables|
|-|-|-|-|-|
|Un sistema complejo está compuesto de subsistemas interrelacionados que a su vez tienen sus propios subsistemas y así hasta que se alcanza algún elemento del más bajo nivel.|La elección de qué componentes en un sistema son primitivos es relativamente arbitraria y suele estar a discreción del observador del sistema|Las intra-conexiones de componentes son más fuertes que las inter-conexiones de componentes. |Los sistemas jerárquicos se componen generalmente de sólo unos pocos tipos diferentes de subsistemas en varias combinaciones y órdenes. |Un sistema complejo que funciona invariablemente se encuentra que ha evolucionado a partir de un sistema sencillo que funcionó.<br>[*Ley de Gall*](https://github.com/mmasias/hacker-laws?tab=readme-ov-file#galls-law) 
|Los niveles de su jerarquía representan los diferentes niveles de abstracción cada uno construido sobre otro y cada uno comprensible por sí mismo.|.|Este hecho tiene el efecto de separar los componentes con dinámica de alta frecuencia (involucrando la interacción entre componentes) de los de dinámica de baja frecuencia. |Nos encontramos con una gran similitud en la forma de mecanismos compartidos unificando esta vasta jerarquía.|Un sistema complejo diseñado desde cero no funciona y no puede ser remendado para hacer que funcione. 
|En cada nivel de abstracción, encontramos una colección de elementos que colaboran para proveer servicios a niveles superiores|.|Hay una clara separación de asuntos entre las partes de diferentes niveles de abstracción|.|Hay que comenzar de nuevo, a partir de un sistema sencillo de trabajo
|Ej.: El ejército|Ej.: Un mapa<br>Para un geógrafo político la unidad primitiva sería el país.<br>Para un urbanista, el barrio o distrito.<br>Para un arquitecto, el edificio o parcela.<br>Para un diseñador de interiores, la habitación.|En un hospital moderno: área de quirófanos, recepción, área de urgencias.|Sistema circulatorio en diferentes especies. Aunque cada especie ha evolucionado de manera diferente, el patrón básico se repite: un sistema de bombeo central que distribuye nutrientes y oxígeno a través de una red de conductos.|Ford modelo T vs [Tucker Automobile](https://es.wikipedia.org/wiki/Tucker_48)|

</div>

***“La observación general es que el principal enemigo de la fiabilidad, y tal vez de la calidad del software en general, es la complejidad”*** - Bertrand Meyer

### Software & Sistemas complejos I

|Abstracción||
|-|-|
|“Proceso mental de extracción de las características esenciales de algo, ignorando los detalles superfluos”<br><br><div align=right>*Booch*</div>|- Proporciona límites conceptuales claramente definidos.<br> - Es subjetiva.<br> - Separa el comportamiento esencial de un objeto de su implantación.<br> - Es paralela al vocabulario del dominio.|
|**Encapsulación**||
|“Proceso por el que se ocultan los detalles del soporte de las características esenciales de una abstracción”<br><br><div align=right>*Booch*</div>|- Proporciona barreras explícitas entre abstracciones ⇒ Conduce a una clara separación de asuntos.<br>- ∴ Podremos cambiar los soportes de las características de una abstracción sin afectar a quienes la utilicen.|

#### Abstracción & Encapsulación

Todo aquello que no sea necesario dar a conocer, **no se debe dar a conocer**.

<div align=center>

`Clase = interfaz + implementación`

</div>

Entonces:

1. La abstracción debe preceder a las decisiones de implantación.
1. Ninguna parte de un sistema complejo debe depender de detalles internos de otra parte.
1. **Interfaz**: vista exterior. Único lugar donde establecemos las suposiciones que puede hacer un cliente.
1. **Implementación**: Mecanismo para conseguir el comportamiento deseado.

#### Modularidad

“Proceso de descomposición de un sistema en un conjunto de piezas poco acopladas y cohesivas”  [Booch]

<div align=center>

|Acoplamiento|Cohesión|
|-|-|
|"*El acoplamiento “[...] es la medida de fuerza de la asociación establecida por una conexión entre un módulo -elemento- y otro. El acoplamiento fuerte complica un sistema porque los módulos son más difíciles de comprender, cambiar o corregir por sí mismos si están muy interrelacionados con otros módulos*” [Booch, 96]. |“*La cohesión mide el grado de conectividad entre los elementos de un solo módulo.*” [Booch, 96] |
|Por tanto, hay que minimizar las dependencias entre módulos|Por tanto, un módulo cohesivo debe tener significado propio por sí mismo agrupando abstracciones lógicamente relacionadas|

---

|Descomponer para||
|-|-|
|poder refinar independientemente.|
|crear límites bien definidos.|
|entender algunas partes a la vez en lugar de todas a la vez.|
||***divide et impera***|

</div>

Debería ser posible cambiar la implementación de unos módulos sin el conocimiento de la aplicación ni de otros módulos y sin afectar el comportamiento de los otros módulos.

El bajo acoplamiento de un módulo se basa en la **abstracción** que limita su interfaz a lo esencial y en la **encapsulación** que oculta todos los detalles necesarios para su implantación pero innecesarios para otros módulos que se relacionen con éste.

#### Jerarquía

“Clasificación u ordenamiento de las abstracciones” [Booch]

Organización de elementos en niveles de responsabilidad, clasificación o composición.

### Software & Sistemas complejos II

¿Permite el software modelar las características de los sistemas complejos?

<div align=center>

|Estructura jerárquica|Elementos primitivos relativos|Separación de asuntos|Patrones comunes|Formas intermedias estables|
|-|-|-|-|-|
|Gracias a sus jerarquías de herencia, composición, paquetes con clases con atributos y métodos, métodos con sentencias, sentencias con expresiones, …​|Gracias a sus tipos primitivos dependiendo del lenguaje (enteros, cadena de caracteres?, fechas?, …) y los definidos por el usuario|Gracias a la encapsulación y modularidad|Gracias a algunos métodos de clases que corresponden al paso de mensajes a objetos|Gracias a las metodologías iterativas o por culpa de nuevas tecnologías o nuevas necesidades|

</div>

> [Proyectos de software](proyectosSoftware.md)