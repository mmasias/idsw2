# 🤔

```java
interface Movible {
    void mover();
}

interface Hablante {
    void hablar();
}

interface Cazador {
    void cazar();
}

interface Limpiador {
    void limpiar();
}
```

---

```java
class Gato implements Movible, Hablante, Cazador {
    @Override
    public void mover() {
        System.out.println("El gato se está moviendo");
    }

    @Override
    public void hablar() {
        System.out.println("El gato dice: Miau!");
    }

    @Override
    public void cazar() {
        System.out.println("El gato está cazando");
    }
}
```

---

```java
class Aspiradora implements Movible, Limpiador {
    @Override
    public void mover() {
        System.out.println("La aspiradora se está moviendo");
    }

    @Override
    public void limpiar() {
        System.out.println("La aspiradora está limpiando");
    }
}
```

---

```java
class Mapa {
    private Movible objetoMovible;
    private Hablante objetoHablante;
    private Cazador objetoCazador;
    private Limpiador objetoLimpiador;

    public Mapa(Movible objetoMovible, Hablante objetoHablante, Cazador objetoCazador, Limpiador objetoLimpiador) {
        this.objetoMovible = objetoMovible;
        this.objetoHablante = objetoHablante;
        this.objetoCazador = objetoCazador;
        this.objetoLimpiador = objetoLimpiador;
    }

    public void moverObjeto() {
        objetoMovible.mover();
    }

    public void hacerHablarObjeto() {
        objetoHablante.hablar();
    }

    public void hacerCazarObjeto() {
        objetoCazador.cazar();
    }

    public void hacerLimpiarObjeto() {
        objetoLimpiador.limpiar();
    }
}
```

---

```java
public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Aspiradora aspiradora = new Aspiradora();

        Mapa mapa1 = new Mapa(gato, gato, gato, aspiradora);
        mapa1.moverObjeto();
        mapa1.hacerHablarObjeto();
        mapa1.hacerCazarObjeto();
        mapa1.hacerLimpiarObjeto();

        Mapa mapa2 = new Mapa(aspiradora, gato, gato, aspiradora);
        mapa2.moverObjeto();
        mapa2.hacerHablarObjeto();
        mapa2.hacerCazarObjeto();
        mapa2.hacerLimpiarObjeto();
    }
}
```