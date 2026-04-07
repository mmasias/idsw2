# Diseño por contrato

## ¿Por qué?

El desarrollo de software fiable enfrenta constantemente el desafío de asegurar el comportamiento correcto de los componentes y sus interacciones.

> *Un caso típico que ilustra estos problemas es la siguiente situación:*
>
> - *Un método divide dos números sin verificar si el divisor es cero, asumiendo que el código llamante habrá realizado esta verificación.*
> - *El código llamante, por su parte, asume que el método manejará adecuadamente los divisores inválidos.*
>
> *El resultado es un error en tiempo de ejecución que podría haberse evitado con una definición clara de responsabilidades.*

Sin contratos formales, la respuesta habitual es la programación defensiva: verificaciones redundantes dispersas por todo el código.

```java
public void procesarPedido(Pedido pedido) {
    if (pedido == null) {
        throw new IllegalArgumentException("El pedido no puede ser nulo");
    }
    if (pedido.getCliente() == null) {
        throw new IllegalArgumentException("El cliente del pedido no puede ser nulo");
    }
    if (pedido.getItems() == null || pedido.getItems().isEmpty()) {
        throw new IllegalArgumentException("El pedido debe contener al menos un ítem");
    }

    for (Item item : pedido.getItems()) {
        if (item == null) {
            throw new IllegalArgumentException("El ítem no puede ser nulo");
        }
        if (item.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        // Procesamiento...
    }
}
```

## ¿Qué?

El Diseño por Contrato (Design by Contract™ o DbC) es un enfoque de desarrollo de software introducido por Bertrand Meyer en el lenguaje de programación Eiffel, que formaliza las obligaciones mutuas entre componentes mediante la especificación explícita de precondiciones, postcondiciones e invariantes.

> "Considerar las relaciones entre una clase y sus clientes como un contrato formal expresando los derechos y las obligaciones de cada parte."
>
> — Bertrand Meyer

### Precondiciones

Condiciones que el cliente debe garantizar antes de invocar una operación. Si se incumplen, el error es del cliente, no del proveedor.

```java
public double raizCuadrada(double numero) {
    assert numero >= 0 : "Precondición violada: numero >= 0";
    return Math.sqrt(numero);
}
```

### Postcondiciones

Garantías que el proveedor ofrece después de ejecutar la operación. Si se incumplen, el error es del proveedor.

```java
public double dividir(double dividendo, double divisor) {
    assert divisor != 0 : "Precondición violada: divisor != 0";

    double resultado = dividendo / divisor;

    assert Math.abs(resultado * divisor - dividendo) < 0.0001
        : "Postcondición violada: resultado * divisor debe aproximar dividendo";

    return resultado;
}
```

### Invariantes de clase

Condiciones que deben mantenerse durante toda la vida de un objeto, antes y después de cada operación pública.

```java
public class PilaAcotada {
    private final Object[] elementos;
    private final int capacidad;
    private int tamaño;

    public PilaAcotada(int capacidadMax) {
        assert capacidadMax > 0 : "La capacidad debe ser positiva";

        this.capacidad = capacidadMax;
        this.elementos = new Object[capacidad];
        this.tamaño = 0;

        verificarInvariante();
    }

    public void apilar(Object elemento) {
        verificarInvariante();
        assert !estaLlena() : "Precondición violada: la pila está llena";

        int oldTamaño = tamaño;
        elementos[tamaño++] = elemento;

        assert tamaño == oldTamaño + 1
            : "Postcondición violada: tamaño no incrementó correctamente";
        assert cima().equals(elemento)
            : "Postcondición violada: el elemento no está en la cima";
        verificarInvariante();
    }

    public Object cima() {
        assert !estaVacia() : "Precondición violada: la pila está vacía";
        return elementos[tamaño - 1];
    }

    public boolean estaVacia() { return tamaño == 0; }
    public boolean estaLlena() { return tamaño == capacidad; }

    private void verificarInvariante() {
        assert tamaño >= 0 && tamaño <= capacidad
            : "Invariante violado: 0 <= tamaño <= capacidad";
        assert elementos != null : "Invariante violado: elementos no es null";
    }
}
```

## ¿Para qué?

Sin contratos, un fallo puede manifestarse lejos de su causa: un método recibe un argumento inválido, devuelve un resultado inconsistente, y el error no aparece hasta varias llamadas más tarde. Con un contrato explícito, el fallo ocurre exactamente donde se viola el acuerdo — en el cliente si incumple una precondición, en el proveedor si incumple una postcondición.

Las precondiciones tienen además un efecto secundario valioso en testing: documentan los casos de entrada inválida directamente en el código. Cada `assert` es implícitamente un caso de prueba negativo que no requiere test adicional.

## ¿Cómo?

### Niveles de aplicación

<div align=center>

| Nivel | Mecanismo | Cuándo |
|-|-|-|
| Verificación en runtime | `assert` de Java | Desarrollo y pruebas |
| Verificación estática | Herramientas de análisis (JML, Checker Framework) | Componentes críticos |

</div>

```java
public void transferir(Cuenta origen, Cuenta destino, double monto) {
    assert monto > 0 : "Precondición violada: monto debe ser positivo";
    assert origen.getSaldo() >= monto : "Precondición violada: saldo insuficiente";

    origen.retirar(monto);
    destino.depositar(monto);
}
```

### `assert` vs excepciones

La distinción más práctica del DbC en Java es cuándo usar cada mecanismo:

<div align=center>

| | `assert` | Excepción |
|-|-|-|
| **Cuándo** | Código interno, llamante bajo tu control | Frontera del sistema: entrada de usuario, API externa |
| **Si falla** | Indica un bug del programador | Indica una condición de entorno o uso incorrecto del API |
| **En producción** | Se puede desactivar (`-ea` / `-da`) | Siempre activa |

</div>

```java
// Precondición interna — assert es suficiente
private double calcularDescuento(double precio, double porcentaje) {
    assert precio > 0 : "precio debe ser positivo";
    assert porcentaje >= 0 && porcentaje <= 1 : "porcentaje debe estar en [0,1]";
    return precio * porcentaje;
}

// Frontera del sistema — excepción obligatoria
public void procesarPago(String numeroCuenta, double importe) {
    if (numeroCuenta == null || numeroCuenta.isEmpty()) {
        throw new IllegalArgumentException("Número de cuenta inválido");
    }
    if (importe <= 0) {
        throw new IllegalArgumentException("El importe debe ser positivo");
    }
    // ...
}
```

## Adopción en la práctica

DbC como Meyer lo concibió —contratos formales completos con precondiciones, postcondiciones e invariantes verificados sistemáticamente— no terminó de arraigar en el desarrollo mainstream de Java. El legado es asimétrico.

|Precondiciones|Invariantes|Postcondiciones|
|-|-|-|
|Funcionaron|Sobreviven de forma degradada|Uso muy limitado|
Son naturales: quien escribe un método ya piensa en qué debe ser cierto para que funcione. Formalizarlas con `assert`, `Objects.requireNonNull` o `Preconditions.checkArgument` (Guava) añade muy poca fricción y da un beneficio claro — localizar el fallo en el punto de incumplimiento. Las anotaciones `@NonNull`/`@Nullable` son su forma más ligera y extendida.|La idea de que el objeto siempre está en estado válido es poderosa conceptualmente, pero el patrón `verificarInvariante()` al inicio y al final de cada método público es verboso y nadie lo mantiene. En la práctica, los invariantes de clase en el sentido DbC completo no arraigaron. Lo que sobrevive es más modesto: la validación en el constructor —el objeto nace en estado correcto— y el uso de `final` para expresar invariantes simples por inmutabilidad.|Expresar una postcondición útil suele requerir reimplementar parte de la lógica del método para verificarla. Una postcondición sobre `ordenar()` sería "el array está ordenado y contiene los mismos elementos" — pero comprobarlo en runtime es O(n) adicional, y escribirlo en código es casi tan costoso como el método original. En la práctica, las postcondiciones se delegan a los tests, que expresan lo mismo con más flexibilidad y sin coste en producción. El testing basado en propiedades (QuickCheck, jqwik) es la realización moderna de esta idea.


**La parte que sí cuajó** es DbC como forma de pensar, no como mecanismo: la disciplina de preguntarse *¿qué debe ser cierto antes?* y *¿qué garantizo después?* mejora el diseño aunque no se escriba un solo `assert`. Clarifica responsabilidades, reduce la programación defensiva redundante y hace explícito lo que de otro modo quedaría como supuesto implícito en el código.

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
