# Inversión de dependencias (DIP)

DIP es una aplicación del [bajo acoplamiento](../02-diseñoModular/acoplamiento.md) al diseño orientado a objetos: las dependencias deben apuntar hacia abstracciones estables, no hacia implementaciones concretas.

## ¿Por qué?

```java
class Mapa {
    private Gato gato;
    private Aspiradora aspiradora;

    public Mapa() {
        this.gato = new Gato();
        this.aspiradora = new Aspiradora();
    }

    public void moverTodo() {
        gato.mover();
        aspiradora.mover();
    }
}
```

`Mapa` es un módulo de alto nivel que coordina la simulación. `Gato` y `Aspiradora` son módulos de bajo nivel con implementaciones concretas. `Mapa` depende directamente de ambos: conoce sus tipos, los instancia, no puede funcionar sin ellos.

Añadir `Robot` al sistema obliga a modificar `Mapa`. Sustituir `Gato` por otra implementación requiere tocar `Mapa`. Probar `Mapa` en aislamiento es imposible sin los objetos reales.

## ¿Qué?

1. Los módulos de alto nivel no deben depender de los de bajo nivel. Ambos deben depender de abstracciones.
2. Las abstracciones no deben depender de los detalles. Los detalles deben depender de las abstracciones.

La dependencia entre módulos apunta hacia la abstracción, no hacia la implementación concreta.

## ¿Para qué?

- `Mapa` puede funcionar con cualquier conjunto de objetos movibles sin modificación.
- Los módulos de bajo nivel pueden evolucionar o ser reemplazados de forma independiente.
- Es posible probar `Mapa` con implementaciones de prueba sin efectos colaterales.

## ¿Cómo?

Introducir la abstracción `Movible` (la misma que define ISP) e inyectar las dependencias desde fuera:

```java
class Mapa {
    private List<Movible> objetos;

    public Mapa(List<Movible> objetos) {
        this.objetos = objetos;
    }

    public void moverTodo() {
        for (Movible objeto : objetos) {
            objeto.mover();
        }
    }
}

class Simulacion {
    public static void main(String[] args) {
        List<Movible> objetos = new ArrayList<>();
        objetos.add(new Gato());
        objetos.add(new Aspiradora());
        objetos.add(new Robot());

        Mapa mapa = new Mapa(objetos);
        mapa.moverTodo();
    }
}
```

`Mapa` no sabe que existen `Gato`, `Aspiradora` ni `Robot`. Solo sabe que tiene objetos `Movible`. La construcción y el ensamblado ocurren en el punto de entrada (`Simulacion`), no en el módulo que usa las dependencias.

La abstracción `Movible` es la misma que define ISP. ISP asegura que la interfaz solo contiene lo que el cliente necesita; DIP asegura que el cliente depende de esa interfaz y no de implementaciones concretas. Los dos principios actúan sobre el mismo punto desde ángulos distintos.

### Formas de inyección

| Tipo | Código | Cuándo usarla |
| --- | --- | --- |
| Por constructor | `new Mapa(objetos)` | Dependencia obligatoria y fija durante la vida del objeto |
| Por setter | `mapa.setObjetos(objetos)` | Dependencia opcional o que puede cambiar tras la construcción |
| Por método | `mapa.moverTodo(objetos)` | Dependencia específica de una operación, no del objeto |

La inyección por constructor es la preferida: hace explícitas las dependencias y produce objetos siempre en estado válido.

## Compromiso

No todo necesita inversión. Las dependencias sobre código estable (la biblioteca estándar de Java, tipos básicos) no justifican una capa de abstracción.

La inversión tiene coste: más interfaces, más clases, ensamblado explícito. Solo vale la pena en los puntos donde la implementación es probable que cambie o donde la testabilidad en aislamiento tiene valor real.

## *#2Think*

```java
class ServicioNotificacion {
    private EmailSender emailSender = new EmailSender();

    public void notificar(String mensaje) {
        emailSender.enviar(mensaje);
    }
}
```

- ¿Qué módulo es de alto nivel y cuál de bajo nivel?
- ¿Cómo introducirías la abstracción e inyectarías la dependencia?
- Si en el futuro hay que notificar también por SMS, ¿qué cambia en tu diseño respecto al original?
