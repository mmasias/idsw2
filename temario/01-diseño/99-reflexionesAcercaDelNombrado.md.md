# Cuando el nombrado revela la arquitectura

## Contexto

En 2007, un proyecto web para una empresa de cursos de español se desarrolló en PHP. 

<div align=center>

||||
|-|-|-|
A día de hoy no tenemos documentos de arquitectura, ni diagramas de navegación, ni guías de estilo escritas: solo el código.|Sin embargo, al revisar la estructura de archivos del proyecto surge una correspondencia con un artefacto formal de ingeniería de requisitos: el **diagrama de contexto**.|El artefacto nunca existió durante el desarrollo. La estructura del código lo hacía innecesario.

</div>

## El proyecto: estructura de archivos

El [directorio](https://github.com/mmasias/pyQualityCourses/tree/main/var/www/html) del editor de administración contenía sus archivos.

De modo directo, la convención de nombrado permite deducir la arquitectura completa del sistema.

## Lectura arquitectónica: lo que los nombres revelan

### El patrón base

Cada entidad del sistema sigue una estructura predecible:

|Componente|Convención|Rol|
|-|-|-|
|`editor.Lista[Entidad].php`|Listado|Vista de consulta y punto de entrada a la gestión|
|`editor.Lista[Entidad]_tp.htm`|Plantilla del listado|Separación vista/lógica|
|`editor.[Entidad].php`|Editor|Vista de edición/creación de un registro individual|
|`editor.[Entidad]_tp.htm`|Plantilla del editor|Separación vista/lógica|
|`editor.[Entidad]._Graba.php`|Acción de guardado|Transición que no cambia de vista|
|`editor.[Entidad]._Eliminar.php`|Acción de eliminación|Transición que retorna al listado|

Con lo que tendríamos:

|Rol|FrontPage|Países|Ciudades|Servicios|ServicioCiudadPais|MetaTags|
|-|-|-|-|-|-|-|
|**Lista**||editor.ListaPaises.php|editor.ListaCiudades.php|editor.ListaServicios.php|editor.ListaServicioCiudadesPais.php|editor.lista.metaTags.php|
|**Lista _tp**||editor.ListaPaises_tp.htm|editor.ListaCiudades_tp.htm|editor.ListaServicios_tp.htm|editor.ListaServicioCiudadesPais_tp.htm|editor.lista.metaTags_tp.htm|
|**Editor**|editor.FrontPage.php|editor.Paises.php|editor.CiudadPais.php||editor.ServicioCiudadPais.php|editor.MetaTags.php|
|**Editor _tp**|editor.FrontPage_tp.htm|editor.Paises_tp.htm|editor.CiudadPais_tp.htm||editor.ServicioCiudadPais_tp.htm|editor.MetaTags_tp.htm|
|**_Graba**|editor.FrontPage._Graba.php|editor.Paises._Graba.php|editor.CiudadPais._Graba.php|editor.Servicios._Graba.php|editor.ServicioCiudadPais._Graba.php|editor.MetaTags._Graba.php|
|**_Eliminar**||editor.Paises._Eliminar.php|editor.Ciudades._Eliminar.php|editor.Servicios._Eliminar.php|||
|**Otros**||editor.Paises._ActualizaOrden.php|editor.Ciudades._Graba.php|editor.ServicioPais.php||editor.lista.metaTags_graba.php|
|||editor.Paises._Edita.php||editor.ServicioPais_tp.htm|||
|||||editor.ServicioPais._Graba.php|||

### Trazabilidad con el diagrama de estados

Proyectados sobre un diagrama de contexto formal, los archivos se mapean directamente a estados y transiciones:

|Archivo|Elemento del diagrama|
|-|-|
|`editor.FrontPage.php`|Estado: `SISTEMA_DISPONIBLE`|
|`editor.ListaPaises.php`|Estado: `PAISES_ABIERTO`|
|`editor.Paises.php`|Estado: `PAIS_ABIERTO`|
|`editor.Paises._Graba.php`|Transición: `editarPais()` — autotransición en `PAIS_ABIERTO`|
|`editor.Paises._Eliminar.php`|Transición: `eliminarPais()` — de `PAISES_ABIERTO` a `PAISES_ABIERTO`|
|`editor.ListaCiudades.php`|Estado: `CIUDADES_ABIERTO`|
|`editor.CiudadPais.php`|Estado: `CIUDAD_ABIERTA`|
|`editor.CiudadPais._Graba.php`|Transición: `editarCiudad()` — autotransición en `CIUDAD_ABIERTA`|
|`editor.Ciudades._Eliminar.php`|Transición: `eliminarCiudad()` — de `CIUDADES_ABIERTO` a `CIUDADES_ABIERTO`|

El patrón se repite para Servicios, ServicioPais, ServicioCiudadPais y MetaTags.

### Navegación implícita

Las transiciones de navegación entre estados también quedan codificadas:

- Desde `editor.FrontPage.php` se accede a cualquier `editor.Lista[Entidad].php` → equivale a las transiciones `abrirPaises()`, `abrirCiudades()`, etc. del diagrama.
- Desde cualquier `editor.Lista[Entidad].php` se accede a `editor.[Entidad].php` → equivale a `crearEntidad()` o `editarEntidad()`.
- Desde cualquier `editor.[Entidad].php` se retorna a `editor.Lista[Entidad].php` → equivale a `abrirEntidades()` o `completarGestion()`.

El grafo completo de navegación es reconstruible sin documentación adicional.

## Lo que también se ve: las imperfecciones

Un proyecto real no es un ejemplo de libro. Y las imperfecciones son igual de instructivas que los aciertos.

### Ruptura de consistencia

`editor.lista.metaTags.php` rompe la convención en tres puntos simultáneos: "lista" en minúscula, "metaTags" en camelCase en vez de CamelCase, y punto como separador donde el resto usa concatenación directa. Probablemente fue la última entidad añadida, o se desarrolló en un momento diferente, o intervino otra mano.

La ruptura se detecta *precisamente* porque el resto del sistema es consistente. Si todo fuera caótico, esta variación pasaría desapercibida. La consistencia funciona como sistema de alerta: cuando se rompe, algo cambió.

### Entidad compleja que desborda el patrón

Países incluye `editor.Paises._ActualizaOrden.php` y `editor.Paises._Edita.php`, transiciones adicionales que no existen en las demás entidades. Países tiene más carga relacional que el resto (los servicios y ciudades dependen de él), y esa complejidad adicional se filtra en archivos extra que rompen la simetría CRUD básica.

Este fenómeno se repite en sistemas más grandes: en un sistema de gestión de horarios universitarios construido con el mismo patrón conceptual, la entidad "Profesor" es la que rompe la simetría con subestados adicionales (preferencias, asignaciones a cursos), por las mismas razones.

### Código muerto

Mugre arqueológica:

- `editor.ListaPaises_tp.htm.OLD` — una plantilla reemplazada que nunca se eliminó.
- `index.FUNCIONAL-2007-02-25-10-06.php` — una versión funcional fechada, conservada "por si acaso".
- `index.ORIGINAL.php`, `index---.php` — versiones anteriores sin sistema de control de versiones que las gestione.

Cada uno de estos archivos es un ejemplo directo de código muerto: fragmentos que ya no participan en el sistema pero permanecen en él, complicando la lectura y generando incertidumbre sobre qué es vigente y qué no.

## Principios en acción

### Nombrado: los nombres revelan la intención

La convención `editor.[rol].[Entidad].[acción].php` permite a cualquier desarrollador que se incorpore al proyecto:

1. Identificar qué entidades gestiona el sistema.
2. Saber qué operaciones están disponibles para cada entidad.
3. Localizar el archivo exacto que necesita modificar.
4. Predecir qué archivos debe crear para añadir una nueva entidad.

Todo esto sin abrir un solo archivo, sin leer una línea de código, sin consultar documentación.

### Consistencia: el patrón como contrato

La repetición del mismo esquema entidad tras entidad establece un contrato implícito. Cualquier desviación (como el caso de MetaTags) señala un punto de atención. La consistencia no es una cualidad estética: es un mecanismo de detección de anomalías.

### Estándares: el código como su propia documentación

No existía documento de convenciones. No hacía falta. La estructura del directorio *era* el estándar: su propio código proporcionaba los ejemplos. Cualquier desarrollador podía deducir las reglas observando el patrón existente y replicarlo para la siguiente entidad.
