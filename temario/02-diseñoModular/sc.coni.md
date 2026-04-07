# Comportamiento obvio no implementado

Ocurre cuando una clase u interfaz omite operaciones que cualquier cliente esperaría razonablemente dado su nombre o propósito declarado. La abstracción está incompleta: promete más de lo que entrega.

**Causas habituales:** el desarrollador implementó solo el lado de la abstracción que necesitaba en ese momento, sin completarla. Es frecuente en operaciones simétricas donde solo se desarrolla una dirección: abrir sin cerrar, conectar sin desconectar, depositar sin retirar.

**Consecuencias:** los clientes no pueden completar su tarea a través de la abstracción y se ven forzados a acceder a la implementación concreta o a replicar externamente la lógica que debería estar encapsulada.

## Ejemplo

### Problema

```java
class CuentaBancaria {
    private double saldo;

    void depositar(double cantidad) {
        saldo += cantidad;
    }
    // No hay forma de retirar dinero
}
```

### Solución propuesta

```java
class CuentaBancaria {
    private double saldo;

    void depositar(double cantidad) {
        saldo += cantidad;
    }

    void retirar(double cantidad) {
        saldo -= cantidad;
    }

    double consultarSaldo() {
        return saldo;
    }
}
```

El nombre `CuentaBancaria` implica un ciclo completo de operaciones financieras. Una cuenta que solo acepta ingresos no representa la abstracción que anuncia.
