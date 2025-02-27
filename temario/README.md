# Temario

## Introducción

> [Nivel: la base...](00-introduccion/README.md)

- [x] [Software & Complejidad](00-introduccion/software.md)  [*oldDiapos*](https://docs.google.com/presentation/d/1N0wtTid8iFAlyR8TNDbCR3FxIkJYvQ_p5kC3pqkkB1c/edit?usp=sharing) / [*oldDiapos*](https://docs.google.com/presentation/d/1K8TusDz7jbpSQkffZdF_-TLDTjfjfxWs-dr9Lf7js80/edit?usp=sharing)
- [x] [Análisis y Diseño](https://docs.google.com/presentation/d/1fPbUOZ6epnsC0RzccIc-VI7f-WO2lnzxWnnpEryBTVg/edit?usp=sharing)

## Diseño

> Nivel: línea...

- [x] [Estrategias de clasificación](01-diseño/01-estrategiasClasificacion.md) ([Presentación](https://docs.google.com/presentation/d/1GJ-J5IKzcYiXpODAjQpXQaGmkeu8ClJ3ho_OXcZOpE4/edit?usp=sharing))
  - [x] [Descomposición Funcional](01-diseño/01.1-descomposicionFuncional.md) (antipatrón)
- [x] [Relaciones entre clases](01-diseño/02-relacionesClases.md)
    - [x] [xColaboración](https://docs.google.com/presentation/d/1pMD3ONO1Urug8n9ZWnnURv0lS_0F0PNi1O5rv73nROY/edit?usp=sharing)
    - [x] [xTransmisión](https://docs.google.com/presentation/d/1ghZkWWi5LOSibOTaVjteYxgyBm6G83nhW5B5BVqkV6c/edit?usp=sharing)
- [x] [Clean code: legibilidad](01-diseño/03-legibilidad.md) ([Presentación](https://docs.google.com/presentation/d/1JKWWhu-AzPAJ0xSPxwuM0zmDvt86FjU7WPLhK1UMmoI/edit?usp=sharing))
- [x] [Composición vs Herencia](01-diseño/04-composicionVsHerencia.md)

### Caso ejemplo: [repo de **theWorld**](https://github.com/puntoReflex/pyAspiradora)

- Clases por colaboración: *rama mundo-habitacion-baldosa-gato*
- Clases por transmisión: *rama mundo-habitacion-baldosa-elemento*

## Diseño modular

> Nivel: clases y métodos...

- [ ] Cohesión
- [ ] Acoplamiento
- [ ] Granularidad
- [ ] Smell Codes
  - Relacionados con la cohesión
    - [x] [Alternative classes with different interfaces - Clases alternativas con distintas interfaces](02-diseñoModular/sc.acdi.md)
    - [x] [Features envy - Envidia de características](02-diseñoModular/sc.fe.md)
    - [x] [Data class - Clase de datos](02-diseñoModular/sc.dc.md)
    - [x] [Divergent Change - Cambios divergentes](02-diseñoModular/sc.dch.md)
    - [x] [Shotgun Surgery - Cirugía a escopetazos](02-diseñoModular/sc.ss.md)
    - [x] [Data Clumps - Grupo de datos](02-diseñoModular/sc.dcl.md)
    - [x] [Primitive Obssesion - Obsesión por tipos primitivos](02-diseñoModular/sc.po.md)
    - [x] [Lazy Classes - Clases perezosas](02-diseñoModular/sc.lc.md)
  - Relacionados con el acoplamiento
    - [x] [Inappropriate Intimacy - Inapropiada intimidad](02-diseñoModular/sc.ii.md)
    - [x] [Incomplete Library Class - Clase de biblioteca incompleta](02-diseñoModular/sc.ilc.md)
  - Relacionados con el tamaño
    - [x] [Long Parameter List - Listas de parámetros larga](02-diseñoModular/sc.lpl.md)
    - [x] [Long Method - Métodos largos](02-diseñoModular/sc.lm.md)
    - [x] [Large Class - Clase grande](02-diseñoModular/sc.lcl.md)
    - [x] [Temporary Fields - Campos temporales](02-diseñoModular/sc.tf.md)
  - Reflexiones varias
    - [ ] [Acerca de... getters y setter](02-diseñoModular/gettersSetter.md)
- [ ] Patrón Modelo, Vista, Controlador (Código)

## Diseño orientado a objetos

> Nivel: Jerarquías de clasificación

- [x] S [Principio de responsabilidad única](03-diseñoOO/SOLID_S.md)
- [x] O [Principio de abierto/cerrado](03-diseñoOO/SOLID_O.md)
- [x] L [Principio de Sustitución de Liskov](03-diseñoOO/SOLID_L.md)
- [x] I [Principio de segregación de interfaces](03-diseñoOO/SOLID_I.md)
- [x] D [Principio de Inversión de Dependencias](03-diseñoOO/SOLID_D.md)
- [x] [Demeter](03-diseñoOO/demeter.md)
- [x] [Inversión de Control](casos/IoC.md)
- [x] [Inyección de Dependencias](casos/inyeccionDependenciasCaso.md)

## Más cosas por ver...

### Patrones de diseño

### Arquitectura de software

### Arquitectura MV*

## Temario++

- [x] Artículos varios recopilados en la [carpeta de documentos](/documentos/README.md).

---

Con todo esto, [a día de hoy deberíamos saber](aDiaDeHoy.md)...
