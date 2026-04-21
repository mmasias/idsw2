# Segregación de interfaces (ISP)

ISP es una aplicación de la [abstracción de interfaces](../02-diseñoModular/abstraccionInterfaz.md) al diseño orientado a objetos.

## ¿Por qué?

```java
interface Objeto {
    void mover();
    void hablar();
    void cazar();
    void limpiar();
}

class Gato implements Objeto {
    public void mover()   { System.out.println("El gato se mueve"); }
    public void hablar()  { System.out.println("El gato dice: miau"); }
    public void cazar()   { System.out.println("El gato caza"); }
    public void limpiar() { /* un gato no limpia */ }
}

class Aspiradora implements Objeto {
    public void mover()   { System.out.println("La aspiradora avanza"); }
    public void hablar()  { /* una aspiradora no habla */ }
    public void cazar()   { /* una aspiradora no caza */ }
    public void limpiar() { System.out.println("La aspiradora aspira"); }
}
```

`Gato` y `Aspiradora` dependen de métodos que no necesitan. Si se añade `void nadar()` a `Objeto`, ambas clases se ven forzadas a implementarlo aunque ninguna nade. Un cambio en una parte de la interfaz que no les concierne las obliga a recompilar, adaptar y probar.

## ¿Qué?

Los clientes no deben depender de interfaces que no utilizan.

Una interfaz demasiado grande acopla a sus implementadores con métodos ajenos. Cuando esa interfaz cambia, todas las clases que la implementan se ven arrastradas por el cambio aunque este no les afecte.

## ¿Para qué?

Interfaces pequeñas y específicas por capacidad:

- Aíslan a las clases de los cambios que no les corresponden.
- Expresan con precisión qué capacidades usa cada parte del sistema.
- Facilitan la composición: una clase puede implementar varias interfaces según sus capacidades reales.

## ¿Cómo?

Segregar `Objeto` en interfaces por capacidad:

```java
interface Movible   { void mover();   }
interface Hablante  { void hablar();  }
interface Cazador   { void cazar();   }
interface Limpiador { void limpiar(); }

class Gato implements Movible, Hablante, Cazador {
    public void mover()  { System.out.println("El gato se mueve sigilosamente"); }
    public void hablar() { System.out.println("El gato dice: miau"); }
    public void cazar()  { System.out.println("El gato caza un ratón"); }
}

class Aspiradora implements Movible, Limpiador {
    public void mover()   { System.out.println("La aspiradora avanza por el suelo"); }
    public void limpiar() { System.out.println("La aspiradora recoge el polvo"); }
}

class Robot implements Movible, Hablante, Limpiador {
    public void mover()   { System.out.println("El robot se desplaza"); }
    public void hablar()  { System.out.println("El robot dice: hola"); }
    public void limpiar() { System.out.println("El robot limpia la superficie"); }
}
```

Añadir `Nadador` no afecta a ninguna de las tres clases salvo que alguna lo implemente. Cada clase solo compila contra las interfaces que le corresponden.

[Un ejemplo más completo](SOLID_I_ejemploMasCompleto.md)

## Compromiso

La segregación también puede ir demasiado lejos. Si `Movible` y `Hablante` siempre se usan juntas y nunca por separado, mantenerlas como interfaces distintas añade fricción sin beneficio.

La pregunta correcta no es "¿puedo separar esto?" sino "¿hay clientes que usan solo una parte?". Si todos los clientes usan los mismos métodos juntos, la interfaz está bien dimensionada.

## *#2Think*

```java
interface RepositorioPedido {
    void guardar(Pedido pedido);
    Pedido buscarPorId(int id);
    List<Pedido> listarTodos();
    void actualizar(Pedido pedido);
    void eliminar(int id);
    List<Pedido> buscarPorFecha(String fecha);
    List<Pedido> buscarPorCliente(int clienteId);
    void exportarCSV(String ruta);
}
```

- ¿Qué clientes distintos podrían usar esta interfaz?
- ¿Qué métodos necesita cada uno?
- ¿Cómo segregarías la interfaz?
