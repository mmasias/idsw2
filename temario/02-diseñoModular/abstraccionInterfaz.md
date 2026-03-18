# Abstracción de interfaz

## ¿Por qué?

Una interfaz es el punto de conexión entre partes de un sistema: el conjunto de operaciones que un componente expone para que otros lo usen, especificando qué operaciones están disponibles, qué parámetros requieren, qué devuelven y qué errores pueden producirse.

> *Una interfaz bien diseñada no sólo describe lo que un sistema hace, sino que revela su intención, ocultando detalles no esenciales.*
>
> — Kent Beck

Cuando las interfaces se diseñan de manera inconsistente, incompleta o excesivamente detallada, los componentes que las usan quedan expuestos a cambios internos que deberían serles irrelevantes.

## ¿Qué?

La Abstracción de interfaz es un principio de diseño que define cómo los componentes exponen su funcionalidad y se comunican entre sí, proporcionando contratos claros, consistentes y adecuadamente abstraídos.

Este principio formaliza la separación entre el "qué" (la funcionalidad proporcionada) y el "cómo" (los detalles de implementación), estableciendo los fundamentos para un acoplamiento bajo y una evolución controlada.

<div align=center>

|Principio del menor compromiso|Principio de la menor sorpresa|
|-|-|
|Formulado por Abelson y Sussman, este principio establece que la interfaz de un objeto debe proporcionar su comportamiento esencial, y nada más.|Este principio establece que una abstracción debe capturar todo el comportamiento de un objeto, ni más ni menos, sin ofrecer sorpresas o efectos secundarios.|
|*La interfaz de un módulo debería capturar la mínima cantidad de suposiciones que los clientes necesitan para usarlo correctamente.*|*Los sistemas deberían comportarse de manera que los usuarios no se sorprendan con comportamientos inesperados.*|
|Esto implica que una interfaz debe:|En términos prácticos:|
|- Incluir solo las operaciones necesarias|- Las funciones deben hacer lo que sus nombres sugieren|
|- Evitar detalles de implementación|- Los comportamientos similares deben seguir patrones consistentes|
|- Minimizar las restricciones sobre los clientes|- Las excepciones al comportamiento común deben estar claramente señaladas|

</div>

### Características de interfaces bien diseñadas

#### Suficiente

Debe capturar suficientes características de la abstracción para permitir una interacción significativa y eficiente. De lo contrario, el componente sería inútil.

<div align=center>
<table>
<tr>
<th>Insuficiente</th><th>Suficiente</th>
</tr>
<tr>
<td>

```java
public interface Coleccion {
    void agregar(Object elemento);
    // Falta método para recuperar elementos
}
```
</td><td>

```java
public interface Coleccion {
    void agregar(Object elemento);
    Object obtener(int indice);
}
```
</td>
</tr>
</table>
</div>

#### Completa

Debe cubrir todos los aspectos significativos de la abstracción, siendo lo suficientemente general como para ser comúnmente utilizable por cualquier cliente.

<div align=center>
<table>
<tr>
<th>Completa</th>
</tr>
<tr>
<td>

```java
public interface Coleccion<T> {
    void agregar(T elemento);
    T obtener(int indice);
    boolean contiene(T elemento);
    int tamaño();
    boolean estaVacia();
    void eliminar(T elemento);
    Iterator<T> iterador();
}
```
</td>
</tr>
</table>
</div>

#### Primitiva

Las operaciones deben ser fundamentales e indiscutiblemente necesarias. Una operación es primitiva si solo puede implementarse a través del acceso a la representación subyacente o si, aunque podría implementarse sobre otras operaciones primitivas, hacerlo sería significativamente menos eficiente.

<div align=center>
<table>
<tr>
<th>Primitiva</th>
</tr>
<tr>
<td>

```java
public interface Coleccion {
    void agregar(Object elemento);
    Object obtener(int indice);
    int tamaño();
    // estaVacia() no es primitiva: puede derivarse como tamaño() == 0
}
```
</td>
</tr>
</table>
</div>

> [Tipos de interfaces](interfacesTipos.md)

## ¿Para qué?

<div align=center>

| Abstracción de Interfaz Efectiva |||| Abstracción de Interfaz Deficiente |
|-|-:|:-:|:-|-|
|Contratos claros y explícitos      |**Fluidez**|     *vs*|**Viscosidad**  | Interfaces confusas o inconsistentes |
|Cambios de implementación ocultos  |**Flexibilidad**|*vs*|**Rigidez**| Cambios internos afectan a consumidores |
|Pruebas automáticas efectivas       |**Robustez**|*vs*|**Fragilidad**| Imposibilidad de verificar comportamiento |
|Fácil adición de implementaciones  |**Reusabilidad**|    *vs*|**Inmovilidad**  | Difícil adaptación a nuevos contextos |

</div>

La metáfora del "enchufe eléctrico" ilustra perfectamente este principio:

> "Una buena interfaz funciona como un enchufe eléctrico estándar: ofrece un contrato claro (voltaje, forma), oculta detalles complejos (cómo se genera la electricidad), permite sustitución (diferentes fuentes de energía) y posibilita evolución independiente (la red eléctrica puede actualizarse sin cambiar los enchufes)."

## ¿Cómo?

Para aplicar efectivamente el principio de Abstracción de Interfaz en el diseño de software, se pueden seguir estas estrategias prácticas:

### Identificar y resolver problemas de interfaz

El primer paso es detectar síntomas de interfaces mal diseñadas:

- [Clases alternativas con interfaces diferentes](sc.acdi.md)
- [Comportamiento obvio no implementado](sc.coni.md)
- [Responsabilidad fuera de lugar](sc.mr.md)

### Diseñar interfaces sólidas

#### Nombrado semántico

Los nombres de interfaces y métodos deben comunicar claramente su propósito.

<div align=center>
<table>
<tr>
<th>Poco claro</th><th>Mejor</th>
</tr>
<tr>
<td>
    
```java
interface IProcessor {
    Object process(Object input);
}
```
</td><td>

```java
interface TransformadorTexto {
    String transformar(String entrada);
}
```   
</td>
</tr>
</table>
</div>

#### Consistencia en patrones

Mantener convenciones coherentes a través de todas las interfaces.


<div align=center>
<table>
<tr>
<th>Inconsistente</th><th>Consistente</th>
</tr>
<tr>
<td>

```java
interface RepositorioCliente {
    Cliente buscarPorId(String id);
    List<Cliente> getByName(String name);
    void save(Cliente cliente);
    void deleteCustomer(String id);
}
```
</td><td>

```java
interface RepositorioCliente {
    Cliente buscarPorId(String id);
    List<Cliente> buscarPorNombre(String nombre);
    void guardar(Cliente cliente);
    void eliminar(String id);
}
```
</td>
</tr>
</table>
</div>

#### Granularidad adecuada

Diseñar las interfaces con el nivel adecuado de detalle.

<div align=center>
<table>
<tr>
<th>Demasiado</th><th>Mejor</th>
</tr>
<tr>
<td>

```java
interface Autenticador {
    boolean validarCredenciales(String usuario,
                                String contraseña);
}

interface GestorSesiones {
    String crearSesion(String idUsuario);
}

interface ValidadorTokens {
    boolean validarToken(String token);
}
```
</td><td>


```java
interface ServicioAutenticacion {
    ResultadoAutenticacion autenticar(String usuario,
                                      String contraseña);
    boolean validarSesion(String token);
    void cerrarSesion(String token);
}
```
</td>
</tr>
</table>
</div>

#### Segregar las interfaces

Dividir interfaces grandes en más pequeñas y específicas.

<div align=center>
<table>
<tr>
<th>Monolito</th><th>Mejor</th>
</tr>
<tr>
<td>

```java
interface Documento {
    void abrir();
    void leer();
    void escribir();
    void formatear();
    void imprimir();
    void mostrarPrevisualizacion();
}
```
</td>
<td>

```java
interface DocumentoLegible {
    void abrir();
    void leer();
}

interface DocumentoEditable extends DocumentoLegible {
    void escribir();
    void formatear();
}

interface DocumentoImprimible {
    void imprimir();
    void mostrarPrevisualizacion();
}
```
</td>
</tr>
</table>
</div>

### Técnicas de implementación

#### Interfaces explícitas vs. implícitas

En lenguajes con soporte para interfaces explícitas (Java, C#), utilizarlas para declarar contratos formales:

```java
// Interfaz explícita en Java
public interface Ordenable {
    int comparar(Ordenable otro);
}

public class Producto implements Ordenable {
    private String nombre;
    private double precio;
    
    @Override
    public int comparar(Ordenable otro) {
        Producto otroProducto = (Producto) otro;
        return Double.compare(this.precio, otroProducto.precio);
    }
}
```

#### Interfaces fluidas

> [Interfaces fluidas](ejemplo/src/interfacesFluidas/README.md)

Diseñar interfaces que permitan encadenamiento de métodos para operaciones relacionadas:

```java
// Interfaz fluida
public class ConsultaSQL {
    public ConsultaSQL seleccionar(String... campos) {
        // Implementación
        return this;
    }
    
    public ConsultaSQL desde(String tabla) {
        // Implementación
        return this;
    }
    
    public ConsultaSQL donde(String condicion) {
        // Implementación
        return this;
    }
    
    public ConsultaSQL ordenarPor(String campo) {
        // Implementación
        return this;
    }
    
    public ResultadoConsulta ejecutar() {
        // Implementación
        return new ResultadoConsulta();
    }
}

// Uso
ResultadoConsulta resultado = new ConsultaSQL()
    .seleccionar("id", "nombre", "precio")
    .desde("productos")
    .donde("precio > 100")
    .ordenarPor("nombre")
    .ejecutar();
```

> [+Advanced](interfacesAvanzado.md)
