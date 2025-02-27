# Segregación de interfaces

Una clase no debe verse obligada a implementar interfaces que no utiliza

*==>  interfaces deben ser pequeñas y específicas*

```java

interface Objeto {
    void mover();
    void hablar();
    void cazar();
    void limpiar();
}

class Gato implements Objeto {
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

    @Override
    public void limpiar() {
        System.out.println("El gato no limpia");
    }    
}

class Aspiradora implements Objeto {
    @Override
    public void mover() {
        System.out.println("La aspiradora se está moviendo");
    }

    @Override
    public void hablar() {
        System.out.println("La aspiradora hace ruido");
    }

    @Override
    public void cazar() {
        System.out.println("La aspiradora no caza");
    }

    @Override
    public void limpiar() {
        System.out.println("La aspiradora limpia");
    } 
}

class Mapa {
    // ...
}
```

---

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

class Gato implements Movible, Hablante, Cazador {
    // Implementación de los métodos de las interfaces
}

class Aspiradora implements Movible, Hablante {
    // Implementación de los métodos de las interfaces
}

class Mapa {
    // ...
}
```

[Un ejemplo más completo](/docs/SOLID_et_al/SOLID_I_ejemploMasCompleto.md)