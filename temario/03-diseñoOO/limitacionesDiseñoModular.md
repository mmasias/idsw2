# Limitaciones del diseño modular

Este ejemplo ilustra perfectamente el desafío de encontrar el equilibrio adecuado en la modularización:

## Enfoque 1: una única clase asume toda la responsabilidad

<table>

<tr>
<td  valign=top>

![Enfoque 1 — God class con condicionales por tipo](/images/modelosUML/ldm_enfoque1.svg)

### Problemas identificados

- **Baja cohesión**: La clase tiene múltiples responsabilidades.
- **Clase grande**: Propenso a crecer con nuevos subtipos.
- **Validaciones por tipo**: Uso de condicionales en lugar del polimorfismo.

> Estadio 1 — ***God class con condicionales por tipo***

</td><td>

```java
class Animal {
    private Cabeza cabeza;
    private Cuerpo cuerpo;
    private Extremidades[] extremidades;
    private Alas alas;
    private Cola cola;
    private String tipo; // "Perro", "Pájaro", etc.
    
    Animal(String tipo) {
        // ...
    }
    
    public void moverse() {
        if (tipo.equals("Perro")) {
            // Correr en cuatro patas
        } else if (tipo.equals("Pájaro")) {
            // Volar batiendo alas
        }
    }
    
    public void comunicarse() {
        if (tipo.equals("Perro")) {
            // Ladrar
        } else if (tipo.equals("Pájaro")) {
            // Cantar
        }
    }
    
    public void comer() {
        if (tipo.equals("Perro")) {
            // Masticar carnívoro
        } else if (tipo.equals("Pájaro")) {
            // Picotear semillas
        }
    }
}

// Uso
Cliente cliente = new Animal("Pájaro");
```
</td>
</tr>

</table>

## Enfoque 2: una clase por cada tipo de elemento

<table>

<tr>
<td valign=top>

![Enfoque 2 — Clases sin abstracción común](/images/modelosUML/ldm_enfoque2.svg)

### Problemas identificados

- **Alto acoplamiento**: Clientes conocen *todas* las clases derivadas.
- **DRY**: Código duplicado en las clases (moverse, comunicarse).
- **Dificultad para extensión**: Cada nuevo tipo requiere una clase *completa* nueva.

> Estadio 2 — ***Clases concretas sin abstracción común.***

</td><td>

```java
class Perro {
    private Cabeza cabeza;
    private Cuerpo cuerpo;
    private Extremidades[] patas;
    private Cola cola;
    
    public Perro() {
        // ...
    }
    
    public void moverse() {
        // Correr en cuatro patas
    }
    
    public void comunicarse() {
        // Ladrar con distintos tonos
    }
    
    public void comer() {
        // Masticar y devorar
    }
}

class Pajaro {
    private Cabeza cabeza;
    private Cuerpo cuerpo;
    private Alas alas;
    private Cola cola;
    
    public Pajaro() {
        // ...
    }
    
    public void moverse() {
        // Volar batiendo alas
    }
    
    public void comunicarse() {
        // Cantar melodiosamente
    }
    
    public void comer() {
        // Picotear con precisión
    }
}

// Uso
Cliente cliente = new Pajaro(); // o new Perro();
```

</td>
</tr>

</table>

## Enfoque 3: jerarquía de clases

Una mejor solución podría ser:

<table>

<tr>
<td valign=top>

![Enfoque 3 — Jerarquía con clase abstracta](/images/modelosUML/ldm_enfoque3.svg)

### Ventajas

- **Alta cohesión**: Cada clase tiene una responsabilidad clara
- **Bajo acoplamiento**: Los clientes trabajan con la abstracción (Animal)
- **DRY**: Código común centralizado en la clase base
- **Flexibilidad**: Soporta polimorfismo y extensibilidad

> Estadio 3 — ***Jerarquía con clase abstracta.***

</td><td>

```java
abstract class Animal {
    private Cabeza cabeza;
    private Cuerpo cuerpo;
    
    public void respirar() {
        // Implementación común
    }
    
    public void dormir() {
        // Implementación común
    }
    
    public abstract void moverse();
    public abstract void comunicarse();
    public abstract void comer();
}

class Perro extends Animal {
    private Extremidades[] patas;
    private Cola cola;
    
    @Override
    public void moverse() {
        // Correr en cuatro patas
    }
    
    @Override
    public void comunicarse() {
        // Ladrar con distintos tonos
    }
    
    @Override
    public void comer() {
        // Masticar y devorar
    }
}

class Pajaro extends Animal {
    private Alas alas;
    private Cola cola;
    
    @Override
    public void moverse() {
        // Volar batiendo alas
    }
    
    @Override
    public void comunicarse() {
        // Cantar melodiosamente
    }
    
    @Override
    public void comer() {
        // Picotear con precisión
    }
}

// Uso
Cliente cliente = zoologico.getAnimal();
```

</td>
</tr>

</table>


### Aún hay problemas!!!

En el diseño con herencia propuesto, un cliente podría intentar diferenciar el comportamiento según el tipo concreto:

```java
public class Cuidador {
    public void alimentar(Animal animal) {
        System.out.println("Soy un cuidador que alimenta a los animales");
        if (animal instanceof Pajaro) {
            System.out.println("Le doy semillas especiales para aves");
            ((Pajaro) animal).posarseEnMano();
            System.out.println("Le silbo una melodía que le gusta");
            ((Pajaro) animal).cantarFeliz();
        } else {
            System.out.println("Le doy croquetas premium");
            ((Perro) animal).moverCola();
        }
    }
}
```

<div align=center>

|![Estadio 3 trampa — instanceof en el cliente](/images/modelosUML/ldm_enfoque3trampa.svg)
|-|

</div>

Este enfoque presenta varios problemas:

1. Al diferenciar el comportamiento según el tipo concreto, estamos indicando que las subclases no son verdaderamente intercambiables.
1. Cuando se añada un nuevo tipo (por ejemplo, `Gato`), se han de modificar todos los bloques `if-else` que comprueban tipos.
1. Los clientes deben conocer todos los tipos concretos en la jerarquía, lo cual crea un alto acoplamiento.
1. No podemos añadir nuevas implementaciones sin modificar el código existente.

> Entonces: si el código que consume la abstracción necesita discriminar por tipo concreto, la abstracción no está haciendo su trabajo.

## Recapitulando

<div align=center>

||||
|-|-|-|
Estadio 1|God class con condicionales por tipo|El anti-patrón fundamental: baja cohesión, escalado lineal del caos, polimorfismo sustituido por instanceof/switch.
Estadio 2|Clases concretas sin abstracción común.|Resuelve la cohesión pero rompe DRY y acopla al cliente con todas las clases concretas. El cliente necesita saber qué existe para poder instanciar.
Estadio 3|Jerarquía con clase abstracta.|Introduce el nivel de abstracción correcto: el cliente opera sobre Animal, el código común sube a la base, el comportamiento específico baja a las subclases vía @Override.
Estadio 3 — trampa|`instanceof` + casting en el cliente|La abstracción queda saboteada desde fuera. Viola LSP: si el consumidor discrimina por tipo concreto, el polimorfismo no está funcionando. Escala igual de mal que el Estadio 1.

</div>

> Otros ejemplos
> 
> ||||
> |-|-|-|
> [Aspiradora/Celda](../../src/DOO/DD/DD02/README.md)|[Sistema de pedidos](../../src/DOO/DD/DD03/README.md)|Mundo


<div align=right>

*Sigue en [doble despacho](dobleDespacho.md)...*

</div>
