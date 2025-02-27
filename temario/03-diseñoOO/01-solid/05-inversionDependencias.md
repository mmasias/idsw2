# Inversión de dependencias

---

```java

public class Simulacion {

    public static void main(String[] args) {
        Mapa mapa = new Mapa();

        while (true){
            mapa.moverGato();
            mapa.moverAspiradora();
        }
    }
}

class Mapa {

    private Gato gato;
    private Aspiradora aspiradora;

    public Mapa() {
        this.gato = new Gato();
        this.aspiradora = new Aspiradora();
    }

    public void moverGato() {
        gato.mover();
    }

    public void moverAspiradora() {
        aspiradora.mover();
    }
}

class Gato {
    public void mover() {
        System.out.println("El gato se está moviendo");
    }
}

class Aspiradora {
    public void mover() {
        System.out.println("La aspiradora se está moviendo");
    }
}
```

---

```java

public class Simulacion {
    public static void main(String[] args) {

        ObjetoMovible gato = new Gato();
        ObjetoMovible aspiradora = new Aspiradora();

        Mapa mapa = new Mapa(gato, aspiradora);

        while (true){
            mapa.moverObjetoMovible1();
            mapa.moverObjetoMovible2();
        }
    }
}

class Mapa {
    
    private ObjetoMovible ObjetoMovible1;
    private ObjetoMovible ObjetoMovible2;

    public Mapa(ObjetoMovible ObjetoMovible1, ObjetoMovible ObjetoMovible2) {
        this.ObjetoMovible1 = ObjetoMovible1;
        this.ObjetoMovible2 = ObjetoMovible2;
    }

    public void moverObjetoMovible1() {
        ObjetoMovible1.mover();
    }

    public void moverObjetoMovible2() {
        ObjetoMovible2.mover();
    }
}

interface ObjetoMovible {
    void mover();
}

class Gato implements ObjetoMovible {
    @Override
    public void mover() {
        System.out.println("El gato se está moviendo");
    }
}

class Aspiradora implements ObjetoMovible {
    @Override
    public void mover() {
        System.out.println("La aspiradora se está moviendo");
    }
}

```

---
