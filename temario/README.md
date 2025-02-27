# Temario

## Introducción

> [Nivel: la base...](00-introduccion/README.md)

- [x] [Software & Complejidad](00-introduccion/software.md)  [*oldDiapos*](https://docs.google.com/presentation/d/1N0wtTid8iFAlyR8TNDbCR3FxIkJYvQ_p5kC3pqkkB1c/edit?usp=sharing) / [*oldDiapos*](https://docs.google.com/presentation/d/1K8TusDz7jbpSQkffZdF_-TLDTjfjfxWs-dr9Lf7js80/edit?usp=sharing)
- [x] [Análisis y Diseño](https://docs.google.com/presentation/d/1fPbUOZ6epnsC0RzccIc-VI7f-WO2lnzxWnnpEryBTVg/edit?usp=sharing)

## Diseño

> Nivel: línea...

<div align="center">

| Tema |
|------|
| [✓] [Estrategias de clasificación](01-diseño/01-estrategiasClasificacion.md) ([Presentación](https://docs.google.com/presentation/d/1GJ-J5IKzcYiXpODAjQpXQaGmkeu8ClJ3ho_OXcZOpE4/edit?usp=sharing)) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Descomposición Funcional](01-diseño/01.1-descomposicionFuncional.md) (antipatrón) |
| [✓] [Relaciones entre clases](01-diseño/02-relacionesClases.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [xColaboración](https://docs.google.com/presentation/d/1pMD3ONO1Urug8n9ZWnnURv0lS_0F0PNi1O5rv73nROY/edit?usp=sharing) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [xTransmisión](https://docs.google.com/presentation/d/1ghZkWWi5LOSibOTaVjteYxgyBm6G83nhW5B5BVqkV6c/edit?usp=sharing) |
| [✓] [Clean code: legibilidad](01-diseño/03-legibilidad.md) ([Presentación](https://docs.google.com/presentation/d/1JKWWhu-AzPAJ0xSPxwuM0zmDvt86FjU7WPLhK1UMmoI/edit?usp=sharing)) |
| [✓] [Composición vs Herencia](01-diseño/04-composicionVsHerencia.md) |

</div>

### Caso ejemplo: [repo de **theWorld**](https://github.com/puntoReflex/pyAspiradora)

- Clases por colaboración: *rama mundo-habitacion-baldosa-gato*
- Clases por transmisión: *rama mundo-habitacion-baldosa-elemento*

## Diseño modular

> Nivel: clases y métodos...

<div align="center">

| Tema |
|------|
| [ ] **Cohesión** |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Alternative classes with different interfaces](02-diseñoModular/01-cohesion/01-alternativeClasses.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Features envy - Envidia de características](02-diseñoModular/01-cohesion/02-featuresEnvy.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Data class - Clase de datos](02-diseñoModular/01-cohesion/03-dataClass.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Divergent Change - Cambios divergentes](02-diseñoModular/01-cohesion/04-divergentChange.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Shotgun Surgery - Cirugía a escopetazos](02-diseñoModular/01-cohesion/05-shotgunSurgery.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Data Clumps - Grupo de datos](02-diseñoModular/01-cohesion/06-dataClumps.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Primitive Obsession - Obsesión por tipos primitivos](02-diseñoModular/01-cohesion/07-primitiveObsession.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Lazy Classes - Clases perezosas](02-diseñoModular/01-cohesion/08-lazyClasses.md) |
| [ ] **Acoplamiento** |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Inappropriate Intimacy - Inapropiada intimidad](02-diseñoModular/02-acoplamiento/01-inappropriateIntimacy.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Incomplete Library Class - Clase de biblioteca incompleta](02-diseñoModular/02-acoplamiento/02-incompleteLibraryClass.md) |
| [ ] **Granularidad** |
| [ ] **Relacionados con el tamaño** |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Long Parameter List - Listas de parámetros larga](02-diseñoModular/03-tamaño/01-longParameterList.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Long Method - Métodos largos](02-diseñoModular/03-tamaño/02-longMethod.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Large Class - Clase grande](02-diseñoModular/03-tamaño/03-largeClass.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Temporary Fields - Campos temporales](02-diseñoModular/03-tamaño/04-temporaryFields.md) |
| [ ] **Reflexiones varias** |
| &nbsp;&nbsp;&nbsp;&nbsp;[ ] [Acerca de... getters y setter](02-diseñoModular/04-reflexiones/01-gettersSetter.md) |
| [ ] **Patrón Modelo, Vista, Controlador (Código)** |

</div>

## Diseño orientado a objetos

> Nivel: Jerarquías de clasificación

<div align="center">

| Tema |
|------|
| **SOLID** |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] S [Principio de responsabilidad única](03-diseñoOO/01-solid/01-responsabilidadUnica.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[✓] [Ejemplo: Biblioteca](03-diseñoOO/01-solid/01.1-ejemploBiblioteca.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[✓] [Ejemplo: Empleado](03-diseñoOO/01-solid/01.2-ejemploEmpleado.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] O [Principio de abierto/cerrado](03-diseñoOO/01-solid/02-abiertoCerrado.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] L [Principio de Sustitución de Liskov](03-diseñoOO/01-solid/03-sustitucionLiskov.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] I [Principio de segregación de interfaces](03-diseñoOO/01-solid/04-segregacionInterfaces.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[✓] [Ejemplo completo](03-diseñoOO/01-solid/04.1-ejemploCompleto.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] D [Principio de Inversión de Dependencias](03-diseñoOO/01-solid/05-inversionDependencias.md) |
| **Otros principios** |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Ley de Demeter](03-diseñoOO/02-principios/01-leyDemeter.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Inversión de Control](casos/IoC.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Inyección de Dependencias](casos/inyeccionDependenciasCaso.md) |
| **Estrategias de diseño** |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Herencia vs Composición](03-diseñoOO/03-estrategias/01-herenciaComposicion.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Composición sobre Herencia](03-diseñoOO/03-estrategias/02-composicionSobreHerencia.md) |
| &nbsp;&nbsp;&nbsp;&nbsp;[✓] [Herencia sobre Composición](03-diseñoOO/03-estrategias/03-herenciaSobreComposicion.md) |

</div>

## Más cosas por ver...

### Patrones de diseño

### Arquitectura de software

### Arquitectura MV*

## Temario++

- [x] Artículos varios recopilados en la [carpeta de documentos](/documentos/README.md).
