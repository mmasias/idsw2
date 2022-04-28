---
marp: true
theme: default
---
# Disciplinas técnicas
## lo que produce el software
---
# El software es sagrado 
# y requiere de un ritual
---
#### Disciplinas técnicas > lo que produce el software
* Modelo del dominio
* Requisitos
* Análisis
* Diseño
* Implementación
* Pruebas
---
#### Disciplinas técnicas > lo que produce el software
## Modelo del dominio
* Todavía no se habla de software.
* Establecer:
    * Un vocabulario común.
    * El contexto.
    * Términos acordados.
* De los conceptos: diagramas de clases y de estados.
---
#### Disciplinas técnicas > lo que produce el software
## Requisitos
* Establece un contrato para describir lo que el sistema debería hacer.
* Vista externa del sistema, puede tener inconsistencias, redundancias
* Define los límites del sistema y es la base para planificar (técnicos, costes, tiempor)
* Estructurado en casos de uso.
* Ya es software, mirado como una caja negra: entradas y salidas.
---
#### Disciplinas técnicas > lo que produce el software
## Análisis
* Especificación más precisa de los requisitos.
* Descubrir clases y responsabilidades.
* Descrito en lenguaje de los desarrolladores, pero superficial (sin tecnologías).
    * Se factoriza cada **Caso de Uso** en clases Controladores, Vistas y Modelos.
        * M: Datos, modelos, json que llegan del back, lo que recibo de un GET
        * V: DTOs que disparan JSON en el back, entradas, salidas, vistas.
        * C: Procesos, recursos, CRUDs
---
#### Disciplinas técnicas > lo que produce el software
## Análisis
* Descrito en lenguaje de los desarrolladores: vista interna del sistema.
* Estructurado en clases estereotipadas MVC y paquetes.
* Vamos dando forma al sistema para su posterior diseño.
---
#### Disciplinas técnicas > lo que produce el software

|Requisitos|Análisis|
|-|-|
|Descrito en lenguage del cliente|Descrito en lenguage de desarrolladores|
|Visión externa del sistema|Visión interena del sistema|
|Estructura la vista externa por medio de requisitos|Estructurado la vista interna por medio de clases estereotipadas (M,V,C) y paquetes|
|Usado como contrato entre clientes y desarrolladores|Usado por desarrolladores para comprender que forma debería tener el sistema|

---
#### Disciplinas técnicas > lo que produce el software

|Requisitos|Análisis|
|-|-|
|Redundancia: mucha.|No debería contener redundancia ni inconsistencias.|
|Captura funcionalidad del sistema|Esboza como realizar dicha funcionalidad|

---

#### Disciplinas técnicas > lo que produce el software
## Diseño
* Diseño final de clases y responsabilidades específicas a la tecnología.
* Ya se puede hablar de la misma y dar detalles de implementación.
---
#### Disciplinas técnicas > lo que produce el software
## Implementación
* No se empieza a implementar hasta que este todo muy claro.
* Se codifican las clases descritas.

---
#### Disciplinas técnicas > lo que produce el software
## Pruebas
