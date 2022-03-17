---
marp: true
theme: default
---
# Disciplinas técnicas
## lo que produce el software
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
* Establecemos un contrato con los desarrolladores para describir lo que el sistema debería hacer, descrito con las palabras anteriores (su vocabulario)
* Vista externa del sistema, puede tener inconsistencias, redundancias
* Estructurado en casos de uso.
* Ya es software, mirado como una caja negra: entradas y salidas
* Tenemos que especificar cómo tiene que ser la interfaz, UX, (de la web y de las otros componentes: apps, windows) funcionales, no funcionales
---
#### Disciplinas técnicas > lo que produce el software
## Análisis
* Descubrir clases y responsabilidades.
* Descrito en lenguaje de los desarrolladores, pero superficial (sin tecnologías).
    * Se factoriza cada Caso de Uso en clases Controladores, Vistas y Modelos.
        * M: Datos, modelos, json que llegan del back, lo que recibo de un GET
        * V: DTOs que disparan JSON en el back, entradas, salidas, vistas.
        * C: Procesos, recursos, CRUDs
---
#### Disciplinas técnicas > lo que produce el software
## Diseño
---
#### Disciplinas técnicas > lo que produce el software
## Implementación
---
#### Disciplinas técnicas > lo que produce el software
## Pruebas
