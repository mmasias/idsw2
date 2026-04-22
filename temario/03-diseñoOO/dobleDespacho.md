# Doble despacho

El [Estadio 3 trampa](limitacionesDiseñoModular.md) mostró que una jerarquía bien diseñada puede quedar saboteada por un cliente que discrimina por tipo concreto. El doble despacho elimina ese `instanceof` sin perder la capacidad de comportarse de forma distinta según el tipo concreto.

## Enfoque 4: técnica del doble despacho

La técnica delega en el propio objeto la responsabilidad de "saber qué tipo soy", aprovechando el polimorfismo en lugar de las comprobaciones de tipo.

<div align=center>

|![Doble despacho — Visitor](/images/modelosUML/dobleDespacho.svg)
|-

</div>


```java
abstract class Animal {
    void respirar() { /* ... */ }
    void dormir()   { /* ... */ }

    abstract void aceptar(VisitanteAnimal visitante);
}

class Perro extends Animal {
    public void moverCola() { /* ... */ }

    @Override
    public void aceptar(VisitanteAnimal visitante) {
        visitante.visitar(this); // primer despacho
    }
}

class Pajaro extends Animal {
    public void posarseEnMano() { /* ... */ }
    public void cantarFeliz()   { /* ... */ }

    @Override
    public void aceptar(VisitanteAnimal visitante) {
        visitante.visitar(this); // primer despacho
    }
}

interface VisitanteAnimal {
    void visitar(Perro perro);
    void visitar(Pajaro pajaro);
}

class CuidadorAnimal implements VisitanteAnimal {

    @Override
    public void visitar(Perro perro) {
        System.out.println("Le doy croquetas premium");
        perro.moverCola();
    }

    @Override
    public void visitar(Pajaro pajaro) {
        System.out.println("Le doy semillas especiales para aves");
        pajaro.posarseEnMano();
        pajaro.cantarFeliz();
    }

    public void cuidar(Animal animal) {
        System.out.println("Limpio la jaula/caseta");
        animal.aceptar(this); // segundo despacho
    }
}
```



### Cómo funciona

Cuando `cuidar` llama a `animal.aceptar(this)`:

1. Java resuelve qué `aceptar` invocar según el tipo concreto de `animal` — **primer despacho** (polimorfismo sobre la jerarquía de `Animal`).
2. Dentro de `aceptar`, el objeto llama a `visitante.visitar(this)`. Como `this` es ya el tipo concreto (`Perro` o `Pajaro`), Java resuelve qué sobrecarga de `visitar` invocar — **segundo despacho** (sobrecarga estática resuelta con el tipo concreto).

La combinación de los dos mecanismos elimina el `instanceof` sin perder el comportamiento diferenciado.

## Compromiso

Añadir un nuevo `Animal` (por ejemplo, `Gato`) requiere:

- Crear `Gato extends Animal` con su `aceptar`.
- Añadir `visitar(Gato)` a la interfaz `VisitanteAnimal`.
- Implementar ese método en **todos** los visitantes existentes.

La jerarquía de `Animal` es extensible; la interfaz `VisitanteAnimal` no lo es sin coste. El doble despacho desplaza la rigidez: ya no está en el cliente, está en el contrato del visitante.

## *#2Think*

```java
class Veterinario implements VisitanteAnimal {
    public void visitar(Perro perro)   { /* revisión canina */ }
    public void visitar(Pajaro pajaro) { /* revisión aviar  */ }

    public void revisar(Animal animal) {
        animal.aceptar(this);
    }
}
```

- ¿Qué ocurre si se añade `Gato` a la jerarquía? ¿Qué clases hay que modificar y cuáles no?
- ¿Por qué Java sabe en tiempo de ejecución que debe llamar a `visitar(Perro)` y no a `visitar(Pajaro)`?
- Si solo hubiera un visitante y no se prevén más, ¿merece la pena introducir esta complejidad?

---

[🗒️ El mismo patrón con otro dominio](../../src/DOO/DD/DD02/README.md)
