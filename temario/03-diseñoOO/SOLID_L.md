# Sustitución de Liskov (LSP)

## ¿Por qué?

```java
class Cajero {
    public void procesar(CuentaBancaria cuenta, double importe) {
        if (cuenta.getSaldo() >= importe) {
            cuenta.retirar(importe);
        }
    }
}
```

El `Cajero` trabaja con `CuentaBancaria` y asume que, si el saldo es suficiente, `retirar()` no falla. Sin embargo:

```java
class CuentaAhorro extends CuentaBancaria {
    private static final double MINIMO = 100;

    @Override
    public void retirar(double cantidad) {
        if (saldo - cantidad < MINIMO)
            throw new IllegalStateException("Saldo mínimo no alcanzado");
        saldo -= cantidad;
    }
}
```

`CuentaAhorro` añade una precondición más fuerte: no basta con `saldo >= cantidad`, también se requiere `saldo - cantidad >= 100`. El `Cajero` no sabe nada de ese requisito y explota cuando el saldo está entre el importe y el mínimo. Sustituir `CuentaBancaria` por `CuentaAhorro` rompe el programa.

## ¿Qué?

Los objetos de una clase derivada deben poder sustituir a los de la clase base sin alterar el comportamiento observable del programa.

La sustituibilidad no se refiere a la estructura interna del objeto, sino al **contrato visible** que el cliente espera. Una clase derivada puede extender el comportamiento, pero no puede:

- Añadir precondiciones más fuertes (exigir más al llamante de lo que exige la base)
- Debilitar postcondiciones (garantizar menos al llamante de lo que garantiza la base)
- Romper invariantes de la clase base
- Lanzar excepciones inesperadas

[Tratamiento formal del LSP](LSP.md)

## ¿Para qué?

El polimorfismo funciona correctamente: el código cliente opera con referencias al tipo base y se beneficia de las implementaciones derivadas sin adaptaciones especiales.

Cuando se viola el LSP, el cliente acaba haciendo comprobaciones de tipo (`instanceof`) para manejar las excepciones al contrato, lo que destruye el polimorfismo y aumenta el acoplamiento.

## ¿Cómo?

Para `CuentaAhorro`, el problema es que añade una restricción que la base no contempla. La solución es modelar el mínimo como parte del contrato compartido:

```java
abstract class CuentaBancaria {
    protected double saldo;
    protected double saldoMinimo;

    public void retirar(double cantidad) {
        if (saldo - cantidad < saldoMinimo)
            throw new IllegalStateException("Saldo mínimo no alcanzado");
        saldo -= cantidad;
    }
}

class CuentaAhorro extends CuentaBancaria {
    public CuentaAhorro(double saldoInicial) {
        this.saldo = saldoInicial;
        this.saldoMinimo = 100;
    }
}

class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente(double saldoInicial) {
        this.saldo = saldoInicial;
        this.saldoMinimo = 0;
    }
}
```

Ahora el contrato de `retirar()` es uniforme para todos los subtipos. El `Cajero` no necesita saber qué tipo concreto está usando.

Cuando la violación del LSP aparece, a menudo señala un problema en la jerarquía: la derivada no es un subtipo genuino de la base, sino algo diferente que comparte implementación. En ese caso, la herencia no es la relación correcta.

## Compromiso

La sustituibilidad completa es el ideal. En la práctica, pequeñas violaciones son tolerables en sistemas cerrados donde el cliente conoce los subtipos y la probabilidad de extensión es nula.

El problema crece con el sistema: cada nueva subclase puede traer nuevas excepciones al contrato, y el cliente acumula `instanceof` hasta que el diseño se hace inmanejable.

## *#2Think*

```java
abstract class Ave {
    public abstract void volar();
}

class Aguila extends Ave {
    public void volar() { System.out.println("El águila vuela"); }
}

class Pinguino extends Ave {
    public void volar() {
        throw new UnsupportedOperationException("Los pingüinos no vuelan");
    }
}
```

- ¿Viola `Pinguino` el LSP? ¿En qué condición lo viola y en cuál no?
- ¿Cómo rediseñarías la jerarquía para que la sustituibilidad se mantenga?
