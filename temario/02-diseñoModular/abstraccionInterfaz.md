# Abstracción de interfaz

## ¿Por qué?

Una interfaz es la superficie que un componente expone para que otros lo usen: el conjunto de operaciones disponibles, los parámetros que requieren, lo que devuelven y los errores que pueden producirse.

> *Una interfaz bien diseñada no sólo describe lo que un sistema hace, sino que revela su intención, ocultando detalles no esenciales.*
>
> — Kent Beck

Cuando las interfaces se diseñan mal —incompletas, inconsistentes, o con detalles de implementación filtrados— el código que las usa queda expuesto a cambios internos que deberían serle irrelevantes.

## ¿Qué?

La abstracción de interfaz es un principio de diseño que establece cómo los componentes deben exponer su funcionalidad: contratos claros, consistentes y adecuadamente abstraídos. Su objetivo es separar el *qué* (la funcionalidad ofrecida) del *cómo* (los detalles de implementación).

Dos principios orientan este diseño:

<div align=center>

|Principio del menor compromiso|Principio de la menor sorpresa|
|-|-|
|Formulado por Abelson y Sussman: la interfaz debe proporcionar el comportamiento esencial, y nada más.|Una abstracción debe capturar todo el comportamiento de un objeto, ni más ni menos, sin efectos secundarios inesperados.|
|*La interfaz de un módulo debería capturar la mínima cantidad de suposiciones que los clientes necesitan para usarlo correctamente.*|*Los componentes deben comportarse exactamente como su nombre y firma sugieren.*|

</div>

Estos principios se concretan en tres propiedades que toda interfaz bien diseñada debe satisfacer.

### Suficiente

La interfaz debe incluir las operaciones necesarias para que la interacción sea posible. Sin ellas, el componente es inutilizable.

<div align=center>
<table>
<tr>
<th>Insuficiente</th><th>Suficiente</th>
</tr>
<tr>
<td>

```java
public interface Pila {
    void apilar(Object elemento);
    // No hay forma de recuperar nada
}
```
</td><td>

```java
public interface Pila {
    void apilar(Object elemento);
    Object desapilar();
}
```
</td>
</tr>
</table>
</div>

### Completa

La interfaz debe cubrir todos los aspectos significativos de la abstracción, siendo lo suficientemente general para cualquier cliente razonable.

<div align=center>
<table>
<tr>
<th>Completa</th>
</tr>
<tr>
<td>

```java
public interface Pila {
    void apilar(Object elemento);
    Object desapilar();
    Object cima();
    int tamaño();
    boolean estaVacia();
}
```
</td>
</tr>
</table>
</div>

### Primitiva

Las operaciones deben ser fundamentales: solo se incluye lo que requiere acceso a la representación interna, o lo que implementar sobre otras primitivas sería significativamente menos eficiente.

<div align=center>
<table>
<tr>
<th>Primitiva</th>
</tr>
<tr>
<td>

```java
public interface Pila {
    void apilar(Object elemento);
    Object desapilar();
    Object cima();
    int tamaño();
    // estaVacia() no es primitiva: equivale a tamaño() == 0
}
```
</td>
</tr>
</table>
</div>

> [Tipos de interfaces](interfacesTipos.md)

## ¿Para qué?

Una interfaz bien abstraída desacopla al que usa un componente de cómo está implementado. Si `GestorPedidos` depende de la clase concreta `PilaEnlazada`, cualquier cambio en su implementación obliga a revisar `GestorPedidos`. Si depende de la interfaz `Pila`, el cambio queda contenido.

Este es el mecanismo por el que la abstracción de interfaz contribuye directamente al [acoplamiento bajo](acoplamiento.md): el acoplamiento se produce inevitablemente —los componentes se usan entre sí— pero queda anclado a una abstracción estable en lugar de a un detalle volátil.

## ¿Cómo?

### Diseñar con granularidad adecuada

Una interfaz demasiado fragmentada obliga a los clientes a depender de múltiples contratos para completar una sola operación coherente.

<div align=center>
<table>
<tr>
<th>Fragmentación artificial</th><th>Granularidad correcta</th>
</tr>
<tr>
<td>

```java
interface AbrirConexion {
    void abrir();
}

interface CerrarConexion {
    void cerrar();
}

interface EnviarMensaje {
    void enviar(String mensaje);
}
```
</td><td>

```java
interface Conexion {
    void abrir();
    void cerrar();
    void enviar(String mensaje);
}
```
</td>
</tr>
</table>
</div>

Las tres operaciones de la izquierda no tienen utilidad independiente: ningún cliente abrirá sin cerrar, ni enviará sin haber abierto. La fragmentación no aporta flexibilidad; solo añade ruido.

### Segregar interfaces grandes

El razonamiento opuesto aplica cuando una interfaz única agrupa responsabilidades que distintos clientes necesitan por separado.

<div align=center>
<table>
<tr>
<th>Monolito</th><th>Segregada</th>
</tr>
<tr>
<td>

```java
interface Documento {
    void abrir();
    String leer();
    void escribir(String contenido);
    void imprimir();
}
```
</td>
<td>

```java
interface DocumentoLegible {
    void abrir();
    String leer();
}

interface DocumentoEditable {
    void escribir(String contenido);
}

interface DocumentoImprimible {
    void imprimir();
}
```
</td>
</tr>
</table>
</div>

Un visor de documentos solo necesita `DocumentoLegible`. Una impresora, solo `DocumentoImprimible`. Obligarlos a depender del monolito es acoplamiento innecesario.

> Ver también: [ISP — Principio de segregación de interfaces](../03-diseñoOO/SOLID_I.md)

### Identificar problemas de interfaz

Los siguientes code smells indican interfaces mal diseñadas:

- [Clases alternativas con interfaces diferentes](sc.acdi.md)
- [Comportamiento obvio no implementado](sc.coni.md)
- [Responsabilidad fuera de lugar](sc.mr.md)

### Interfaces fluidas

Patrón que permite encadenar llamadas a métodos en una única expresión, devolviendo `this` en cada paso intermedio. Produce APIs expresivas que se leen casi como lenguaje natural.

> [Interfaces fluidas — ejemplo completo](ejemplo/src/interfacesFluidas/README.md)

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
