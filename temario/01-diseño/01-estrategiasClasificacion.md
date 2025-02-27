# Estrategias de clasificación

## Descripción informal (método de Abbott)

||||
|-|-|-|
|Abbott sugiere escribir una descripción del problema (o una parte de un problema) y luego subrayar los sustantivos y verbos.|Los nombres representan objetos candidatos, y los verbos representan operaciones candidatos en ellos.|

- El enfoque de Abbott es útil porque es simple y obliga a los desarrolladores a trabajar en el vocabulario del espacio del problema.

Inconveniente:

- No es un enfoque riguroso y sin duda no escala bien para nada más allá de problemas bastante triviales. El lenguaje humano es un vehículo de expresión tremendamente impreciso, por lo que la calidad de la lista resultante de los objetos y las operaciones depende de la habilidad de la escritura de su autor: sinónimos, anáforas, metáforas, …​
- Por otra parte, cualquier sustantivo puede ser verbo, y cualquier verbo puede ser sustantivo, cosificación. Ej.: gestionar vs gestión; oxigenar vs oxigeno; pulsar vs pulso; …​;

***Ejemplo:***

*"La bibliotecaria registra los nuevos libros en el sistema cuando llegan a la biblioteca. Los estudiantes pueden buscar libros por título o autor, y luego solicitar préstamos. Cada préstamo tiene una duración máxima de dos semanas. El sistema envía recordatorios por email cuando la fecha de devolución está próxima. Si un estudiante no devuelve el libro a tiempo, se genera una multa diaria."*

|Sustantivos (posibles objetos)|Verbos (posibles operaciones)|Limitaciones|
|-|-|-|
|Bibliotecaria / Libros / Sistema / Biblioteca / Estudiantes / Título / Autor / Préstamo / Recordatorios / Email / Fecha / Multa|Registrar / Buscar / Solicitar / Enviar / Prestar / Devolver / Generar|Préstamo / Prestar

Sin embargo, nos da un punto de partida para identificar los elementos básicos del sistema.

## Análisis clásico

Un número de metodólogos han propuesto diversas fuentes de clases y objetos, derivados de los requisitos del dominio del problema:

|Fuentes|*Para el ejemplo de la biblioteca:*|
|-|-|
|**Cosas, objetos físicos o grupos de objetos** que son tangibles|Libros / Estanterías / Carnets de biblioteca / Códigos de barras / Etiquetas de identificación / Terminales / Ordenadores|
|**Conceptos, principios o ideas no tangibles** *per se* utilizados para organizar o realizar un seguimiento de las actividades comerciales y/o comunicaciones|Préstamo / Reserva / Multa / Período de préstamo / Categorías de libros / Estado del libro (prestado, disponible, en reparación)|
|**Gente, seres humanos** que llevan a cabo alguna función, usuarios que juegan diferentes roles en la interacción con la aplicación.|Bibliotecarios / Estudiantes / Personal administrativo / Visitantes|
|**Organizaciones, colecciones formalmente organizadas de personas y recursos** que tienen una misión definida, cuya existencia es en gran medida independiente de los individuos|Biblioteca / Departamentos académicos / Editoriales / Servicios de mantenimiento|
|**Lugares** físicos, oficinas y sitios importantes para la aplicación|Salas de lectura / Área de préstamo / Depósito de libros / Sección de referencia / Sala de computadoras|
|**Dispositivos** con los que interactúa la aplicación|Escáneres de códigos / Impresoras de recibos / Sistemas de seguridad (detectores en puertas) / Computadoras de consulta|
|**Otros sistemas externos** con los que interactúa la aplicación|Sistema de gestión académica / Sistema de pagos / Sistema de correo electrónico / Base de datos bibliográfica externa|
|**Cosas que pasan**, por lo general de otra cosa en una fecha determinada, eventos|Préstamo de libro / Devolución / Vencimiento / Generación de multa / Renovación de préstamo / Pérdida de libro|

Este análisis es más estructurado y exhaustivo que la descripción informal, ya que obliga a considerar diferentes aspectos del sistema desde distintas perspectivas predefinidas

Presenta, sin embargo, limitaciones:

|Sobreidentificación de clases|Enfoque demasiado centrado en lo tangible|Falta de priorización|Problemas de granularidad|Contexto limitado|Dificultad con los aspectos dinámicos|
|-|-|-|-|-|-|
|Puede llevar a identificar demasiados objetos/clases potenciales|Al centrarse mucho en elementos físicos y estructurales, puede perderse aspectos importantes del comportamiento del sistema|No proporciona criterios claros para decidir qué debe ser una clase y qué no|No ayuda a determinar el nivel adecuado de abstracción|No considera adecuadamente el contexto específico del sistema|No captura bien los aspectos dinámicos del sistema|
|No todos los elementos identificados necesariamente merecen ser una clase|No captura bien las interacciones y los flujos de trabajo|No ayuda a determinar la importancia relativa de cada elemento identificado|Puede ser difícil decidir cuándo dividir o combinar clases|Puede llevar a incluir elementos que son relevantes en el dominio pero no para el sistema específico|Puede pasar por alto comportamientos importantes que no están asociados a elementos físicos|
|Puede resultar en un sistema sobrecargado con clases innecesarias|Puede llevar a un diseño muy orientado a datos en lugar de a comportamiento|Puede ser difícil decidir si algo debe ser un atributo o una clase independiente|No proporciona guías sobre la jerarquía de clases|No tiene en cuenta las restricciones técnicas o de implementación|No considera adecuadamente los flujos de trabajo y procesos|

## Análisis del dominio

Un intento para identificar los objetos, las operaciones y las relaciones [son los que] los expertos de dominio perciben como importantes sobre el dominio.

||||
|-|-|-|
|Un experto del dominio normalmente no será un desarrollador de software: es (*simplemente*) una persona que está íntimamente familiarizado con todos los elementos de un problema particular.|Un experto del dominio habla el vocabulario del dominio.|A menudo, un experto del dominio es simplemente un usuario, como un ingeniero del tren o expendedor en un sistema ferroviario, o una enfermera o un médico en un hospital.|

Para el mismo ejemplo de la biblioteca, para aplicar el análisis del dominio necesitaríamos consultar con expertos del dominio. Asumiendo entrevistas hipotéticas con estos expertos, podríamos obtener información como esta:

|Bibliotecario profesional|Auxiliar de biblioteca|Usuario frecuente|Administrador|
|-|-|-|-|
|Para nosotros es crucial mantener el control del catálogo. Cada libro tiene un número único de registro y pertenece a una o más colecciones. Los libros raros o valiosos tienen restricciones especiales de préstamo. Necesitamos saber en todo momento dónde está cada ejemplar y su estado de conservación.|Lo más importante es poder procesar rápidamente los préstamos y devoluciones. Necesitamos verificar fácilmente si un usuario tiene multas pendientes o ha excedido su cuota de préstamos. También gestionamos las reservas de libros que están prestados.|Lo que más uso es la búsqueda en el catálogo. Necesito poder buscar por título, autor, tema o palabras clave. También es importante poder renovar mis préstamos online y ver el historial de mis préstamos anteriores.|Necesitamos estadísticas de uso de la colección, reportes de libros más solicitados, y control de presupuesto para nuevas adquisiciones. También es importante el control de usuarios morosos y la gestión de multas.|

Esta información del dominio nos ayuda a:

1. Identificar la terminología específica del dominio
1. Entender las reglas de negocio reales
1. Conocer los procesos más importantes
1. Comprender las necesidades reales de los diferentes tipos de usuarios
1. Identificar las restricciones y políticas importantes

¿Limitaciones? Claro, como todo, como siempre:

|Dependencia de expertos|Problemas de comunicación|Alcance y completitud|Resistencia al cambio|Tiempo y recursos|Evolución del dominio|
|-|-|-|-|-|-|
|Requiere acceso a expertos del dominio, que no siempre están disponibles|Los expertos pueden tener dificultad para articular su conocimiento implícito|Los expertos pueden enfocarse solo en su área de expertise|Los expertos pueden estar muy apegados a sistemas o procesos existentes|Requiere inversión significativa de tiempo para entrevistas y validación|El conocimiento del dominio puede cambiar durante el desarrollo|
|La calidad del análisis depende de la experiencia y comunicación del experto|Puede haber brechas de comunicación entre expertos y desarrolladores|Pueden omitirse aspectos importantes que los expertos dan por sentado|Pueden resistirse a nuevas formas de hacer las cosas|Los expertos suelen tener limitaciones de disponibilidad|Nuevas regulaciones o tecnologías pueden afectar el análisis|
|Diferentes expertos pueden tener visiones contradictorias|La terminología puede ser interpretada de manera diferente|Puede ser difícil obtener una visión completa del sistema|Pueden no ver el potencial de mejora que ofrece la tecnología|El proceso puede ser costoso si requiere múltiples sesiones|Los expertos pueden no estar al día con los últimos cambios|
|Los expertos pueden estar sesgados por su rol específico|El vocabulario técnico puede no ser consistente entre diferentes expertos|Los expertos pueden no estar familiarizados con nuevas tecnologías o posibilidades|Pueden sugerir replicar sistemas antiguos sin considerar nuevas posibilidades|La validación y reconciliación de diferentes perspectivas puede ser lenta|Puede ser difícil anticipar evoluciones futuras del dominio|

## Análisis del comportamiento

***El conocimiento que un objeto mantiene y las acciones que un objeto puede realizar. Las responsabilidades tienen el propósito de transmitir un sentido de la finalidad de un objeto y su lugar en el sistema. Las responsabilidades de un objeto son todos los servicios que presta a todos los contratos que apoya***

Mientras que los enfoques clásicos anteriormente mencionados se centran en cosas tangibles en el dominio del problema, otra escuela de pensamiento en el análisis orientado a objetos se centra en el comportamiento dinámico como la fuente primaria de clases y objetos.

## Patrón experto en la información

Existen dos tipos básicos de obligaciones de un objeto en términos de su comportamiento/responsabilidad:

|Responsabilidad de conocer de un objeto|Responsabilidad de hacer de un objeto|
|-|-|
|Sobre unos datos privados encapsulados, sobre objetos relacionados, y sobre las cosas que pueden obtener o calcular|Algo en sí mismo, como la creación de un objeto o hacer un cálculo, iniciar acciones en otros objetos y el control y la coordinación de actividades en otros objetos
||Se implementan utilizando métodos que, o bien actúan solos o colaboran con otros métodos y objetos. Una responsabilidad no es lo mismo que un método y se ve influida por la granularidad de la responsabilidad.
||El acceso a las bases de datos relacionales puede implicar decenas de clases y cientos de métodos, empaquetados en un subsistema.
||Por el contrario, la responsabilidad de "crear una venta" puede implicar sólo uno o unos métodos

Propone la aplicación directa del modelo del dominio, con una analogía en el mundo real, como muchas cosas en la tecnología de objetos. Esto conduce a diseños en los que un objeto de software hace las operaciones que realizan normalmente las cosas del mundo real inanimadas a las que representa.

**Principio general de la asignación de responsabilidades a los objetos**: asignar la responsabilidad a la clase que tiene la información necesaria para cumplir con la responsabilidad

- Se debe tener en cuenta que el cumplimiento de una responsabilidad a menudo requiere la información que se transmite a través de diferentes clases de objetos. Esto implica que hay muchos expertos "parciales" de información que colaborarán en la tarea.
- A medida que los miembros del equipo caminan a través del escenario, pueden asignar nuevas responsabilidades a una clase existente, agrupar ciertas responsabilidades para formar una nueva clase, o más comúnmente, dividen las responsabilidades de una clase en más de grano fino y distribuyen estas responsabilidades a clases diferentes.

Para el ejemplo de la biblioteca, aplicar análisis del comportamiento requiere tomar algunos objetos clave y analizar sus responsabilidades:

||LIBRO|PRÉSTAMO|USUARIO|SISTEMA DE NOTIFICACIONES|
|-|-|-|-|-|
|**Responsabilidades de conocer**|Su identificador único|Qué libro está prestado|Sus datos personales|Qué préstamos están próximos a vencer
||Su estado actual (disponible, prestado, en reparación)|Quién lo tiene prestado|Sus préstamos actuales|Qué usuarios tienen multas pendientes
||Su ubicación física|Cuándo se realizó el préstamo|Su historial de préstamos|Qué reservas están disponibles
||Su historial de préstamos|Cuándo debe devolverse|Sus multas pendientes|Plantillas de mensajes
||Sus metadatos (autor, título, editorial)|Si tiene renovaciones|Sus privilegios de préstamo
|**Responsabilidades de hacer**|Actualizarse como prestado/devuelto|Calcular fecha de vencimiento|Solicitar préstamos|Enviar recordatorios de vencimiento
||Reportar su disponibilidad|Generar multas por retraso|Realizar búsquedas|Notificar multas
||Registrar daños o necesidad de mantenimiento|Renovarse si es posible|Hacer reservas|Avisar de reservas disponibles
|||Registrar la devolución|Pagar multas|Registrar el envío de notificaciones
||||Actualizar sus datos

> *Tarjetas CRC*

Este enfoque nos ayuda a:

- Definir claramente qué debe hacer cada objeto.
- Establecer los límites de responsabilidad.
- Identificar las colaboraciones necesarias.
- Mantener la cohesión de las clases.
- Facilitar el mantenimiento del sistema.

Limitaciones, limitaciones, limitaciones...

|Subjetividad en la asignación|Complejidad en la colaboración|Dificultad para balancear responsabilidades|Mantenimiento y evolución|Acoplamiento|
|-|-|-|-|-|
|Es difícil determinar el nivel adecuado de granularidad de las responsabilidades|A medida que aumentan las responsabilidades, las colaboraciones se vuelven más complejas|Algunos objetos pueden acabar con demasiadas responsabilidades|Añadir nuevas responsabilidades puede romper el diseño existente|Las responsabilidades pueden crear dependencias no deseadas|
|La misma responsabilidad podría asignarse a diferentes objetos|Puede ser difícil mantener la trazabilidad de las interacciones|Otros pueden quedar con muy pocas responsabilidades|Las responsabilidades pueden volverse difusas con el tiempo|Puede ser difícil aislar cambios en el sistema|
|No hay reglas claras sobre cómo dividir responsabilidades complejas|El rendimiento puede verse afectado por demasiadas colaboraciones|Es complejo decidir cuándo dividir una clase sobrecargada|La documentación de responsabilidades puede quedarse obsoleta|El testing puede complicarse por las interdependencias|
|Diferentes analistas pueden llegar a diseños muy diferentes|Riesgo de crear dependencias circulares|La redistribución de responsabilidades puede afectar a muchas clases|Las colaboraciones pueden volverse más complejas con cada cambio|Las responsabilidades compartidas pueden crear acoplamiento excesivo|

## Análisis de casos de uso

A medida que el equipo se guía a través de cada escenario de cada caso de uso, se deben identificar los objetos que participan en el escenario, las responsabilidades de cada objeto, y las formas en esos objetos colaboran con otros objetos, en términos de las operaciones de cada uno invoca en el otro. De esta manera, el equipo se ve obligado a elaborar una clara separación de las responsabilidades entre todas las abstracciones.

Entonces se procede por un estudio de cada escenario, posiblemente utilizando técnicas similares a las prácticas de la industria de la televisión: storyboard (guión gráfico) y películas.

No es necesario profundizar en estos escenarios al principio; simplemente podemos enumerarlos. Estos escenarios describen colectivamente las funciones del sistema de la aplicación.

A medida que continúa el proceso de desarrollo, estos escenarios iniciales se ampliaron para considerar las condiciones excepcionales, así como los comportamientos secundarios del sistema. Los resultados de estos escenarios secundarios introducen nuevas abstracciones para añadir, modificar o reasignar las responsabilidades de abstracciones existentes.

Los escenarios también sirven como la base de las pruebas del sistema.

Para el ejemplo de la biblioteca, aplicar el análisis de casos de uso implica centrárnos en identificar escenarios y elaborar una clara separación de responsabilidades entre las abstracciones.

||||
|-|-|-|
|**Escenario**|**Préstamo de libro**|**Búsqueda de libro**
|**Actores**|Estudiante, Bibliotecario, Sistema|Usuario, Sistema
|**Flujo**|1. Estudiante solicita préstamo de libro|1. Usuario ingresa criterios de búsqueda
||2. Bibliotecario escanea carnet de estudiante|2. Sistema busca coincidencias
||3. Sistema verifica estado del estudiante|3. Sistema muestra resultados
||4. Bibliotecario escanea libro|4. Sistema muestra ubicación y disponibilidad
||5. Sistema verifica disponibilidad
||6. Sistema registra préstamo
||7. Sistema actualiza estado del libro
||8. Sistema genera comprobante

Este enfoque nos ayuda a:

- Enfoque centrado en el usuario
- Visión dinámica del sistema
- Base para pruebas

Limitaciones, limitaciones, limitaciones...

|Puede ser incompleto|Nivel de detalle|Mantenimiento|Aspectos técnicos|Recursos|
|-|-|-|-|-|
|Riesgo de omitir escenarios importantes|Puede ser difícil determinar el nivel adecuado de granularidad|Los casos de uso pueden volverse obsoletos|No aborda directamente aspectos de implementación|Requiere tiempo considerable para documentar|
|Dificultad para cubrir todos los casos posibles|Riesgo de perderse en detalles excesivos|Actualización costosa al cambiar requisitos|Puede omitir consideraciones de arquitectura|Necesita participación activa de stakeholders|
|Puede pasar por alto requisitos no funcionales|Puede volverse inmanejable con muchos casos de uso|Puede ser difícil mantener la consistencia|No ayuda en decisiones técnicas|Puede ser costoso mantener actualizado|
|No captura bien requisitos de sistema o arquitectónicos|Difícil balance entre abstracción y detalle|La documentación puede crecer excesivamente|Puede subestimar complejidades técnicas|Requiere habilidad para identificar escenarios relevantes|

## En resumen (ChatGPT dixit)

|Método|Fortalezas Principales|Debilidades Críticas|Mejor para|
|-|-|-|-|
|Descripción informal (Abbott)|• Simple y rápido de aplicar<br>• Útil para problemas pequeños<br>• Fácil de entender|• No escala bien<br>• Impreciso<br>• Ambigüedad sustantivo/verbo|Prototipos rápidos y sistemas pequeños|
|Análisis clásico|• Estructurado y sistemático<br>• Cobertura amplia<br>• Fácil de seguir|• Puede generar demasiadas clases<br>• Muy centrado en lo tangible<br>• Falta criterios de priorización|Sistemas con muchos elementos físicos y roles claros|
|Análisis del dominio|• Rica en conocimiento del negocio<br>• Captura reglas reales<br>• Vocabulario preciso del dominio|• Depende de expertos<br>• Puede ser costoso y lento<br>• Posibles conflictos entre expertos|Sistemas complejos de dominio específico|
|Análisis del comportamiento|• Enfoque en responsabilidades<br>• Clara separación de concerns<br>• Buena base para OOP|• Subjetivo<br>• Complejidad en colaboraciones<br>• Difícil balance de responsabilidades|Sistemas con comportamientos complejos|
|Análisis de casos de uso|• Centrado en el usuario<br>• Base para testing<br>• Captura flujos reales|• Puede ser incompleto<br>• Mantenimiento costoso<br>• No cubre aspectos técnicos|Sistemas con fuerte interacción usuario-sistema|

## Recomendaciones de uso

Estos métodos no deberían verse como algo mutuamente excluyente, sino como herramientas complementarias que pueden usarse en diferentes momentos y situaciones del desarrollo.

1. Combinar métodos según la fase:
   - Inicio: Descripción informal para primeras ideas
   - Análisis: Análisis del dominio y Casos de uso para entender necesidades
   - Diseño: Análisis del comportamiento y Análisis clásico para estructura
1. Adaptar según el proyecto:
   - Proyectos pequeños: Descripción informal + Casos de uso
   - Proyectos medianos: Clásico + Comportamiento
   - Proyectos grandes: Combinación de todos los métodos
1. Factores a considerar:
   - Complejidad del dominio
   - Disponibilidad de expertos
   - Restricciones de tiempo y recursos
   - Experiencia del equipo
   - Criticidad del sistema