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
// Ejemplo de programación defensiva
public void procesarPedido(Pedido pedido) {
    // Verificación en el método llamador
    if (pedido == null) {
        throw new IllegalArgumentException("El pedido no puede ser nulo");
    }
    if (pedido.getCliente() == null) {
        throw new IllegalArgumentException("El cliente del pedido no puede ser nulo");
    }
    if (pedido.getItems() == null || pedido.getItems().isEmpty()) {
        throw new IllegalArgumentException("El pedido debe contener al menos un ítem");
    }
    
    // Lógica de negocio...
    for (Item item : pedido.getItems()) {
        // Más verificaciones defensivas
        if (item == null) {
            throw new IllegalArgumentException("El ítem no puede ser nulo");
        }
        if (item.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        
        // Procesamiento del ítem...
    }
    
    // Más código...
}
```

## ¿Qué?

El Diseño por Contrato (Design by Contract™ o DbC) es un enfoque de desarrollo de software introducido por Bertrand Meyer en el lenguaje de programación Eiffel, que formaliza las obligaciones mutuas entre componentes mediante la especificación explícita de precondiciones, postcondiciones e invariantes.

> "Considerar las relaciones entre una clase y sus clientes como un contrato formal expresando los derechos y las obligaciones de cada parte."
>
> — Bertrand Meyer


Este enfoque proporciona un marco sistemático para definir y verificar el comportamiento esperado de los componentes, tratando sus interacciones como contratos formales que establecen:

- Lo que el cliente debe garantizar **antes** de invocar una operación
- Lo que el proveedor garantiza **después** de ejecutar la operación
- Las propiedades que **siempre** se mantienen durante la vida del objeto

### Elementos del contrato

<div align=center>

|Precondiciones|Postcondiciones|Invariantes|
|-|-|-|
|Representan las obligaciones del cliente (código llamante) y los beneficios para el servidor (código llamado).|Representan las obligaciones del servidor y los beneficios para el cliente.|Representan la consistencia interna que la clase debe mantener.|

</div>

#### Precondiciones

Las precondiciones especifican las restricciones que deben cumplirse antes de que un método pueda ejecutarse correctamente. Representan las obligaciones del cliente (código llamante) y los beneficios para el servidor (código llamado).

<div align=center>
<table>
<tr>
<th>Contrato</th><th>Implementación</th>
</tr>
<tr>
<td>

**Calcula la raíz cuadrada de un número.**

- ***numero*** El número para calcular su raíz cuadrada
- ***condición*** numero >= 0
- ***postcondicion***
  - ***devuelve*** La raíz cuadrada del número
</td><td>

```java
public double raizCuadrada(double numero) {
    assert numero >= 0 : "La precondición 'numero >= 0' ha sido violada";
    
    return Math.sqrt(numero);
}
```
</td>
</tr>
</table>
</div>

Las precondiciones:

- Son responsabilidad del cliente verificarlas antes de la llamada
- Liberan al servidor de manejar casos fuera del contrato
- Deben ser comprobables antes de la ejecución del método

#### Postcondiciones

Las postcondiciones especifican las garantías que proporciona un método después de su ejecución exitosa. Representan las obligaciones del servidor y los beneficios para el cliente.

<div align=center>
<table>
<tr>
<th>Contrato</th><th>Implementación</th>
</tr>
<tr>
<td>

**Busca un elemento en una colección ordenada.**

- ***coleccion*** La colección ordenada donde buscar
- ***elemento*** El elemento a buscar
- ***postcondicion***
  - ***devuelve*** El índice del elemento en la colección o -1 si no se encuentra.
  - ***garantizando*** resultado >= -1 && resultado < coleccion.length
    - resultado != -1 implica coleccion[resultado] == elemento
    - resultado == -1 implica !existe i: coleccion[i] == elemento

</td><td>

```java
public int busquedaBinaria(int[] coleccion, int elemento) {
    // Implementación...
    int resultado = /* cálculo */;
    
    assert resultado >= -1 && resultado < coleccion.length : 
        "La postcondición 'resultado >= -1 && resultado < coleccion.length' ha sido violada";
    assert resultado == -1 || coleccion[resultado] == elemento : 
        "La postcondición 'resultado != -1 implica coleccion[resultado] == elemento' ha sido violada";
    
    return resultado;
}
```
</td>
</tr>
</table>
</div>

Las postcondiciones:

- Son responsabilidad del servidor garantizarlas
- Definen los resultados esperados del método
- Pueden referirse al estado previo a la ejecución (con notaciones como "old" en Eiffel)

#### Invariantes de clase

Los invariantes de clase especifican condiciones que deben mantenerse durante toda la vida de un objeto, tanto antes como después de cualquier operación pública. Representan la consistencia interna que la clase debe mantener.

<div align=center>

||Contrato|
|-|-|
|**Invariante**|- 0 <= tamaño <= capacidad<br>- elementos no es null
|`public void apilar(Object elemento)`|- ***elemento*** El elemento a añadir<br>- ***condicion*** !estaLlena()<br>- ***postcondicion***<br>&nbsp;&nbsp;- tamaño == old(tamaño) + 1<br>&nbsp;&nbsp;- cima() == elemento

</div>

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

        assert tamaño == oldTamaño + 1 : "Postcondición violada: tamaño no incrementó correctamente";
        assert cima() == elemento : "Postcondición violada: el elemento no está en la cima";
        verificarInvariante();
    }
    
    private void verificarInvariante() {
        assert tamaño >= 0 && tamaño <= capacidad : "Invariante violado: 0 <= tamaño <= capacidad";
        assert elementos != null : "Invariante violado: elementos no es null";
    }
    
    // Otros métodos...
}
```

Los invariantes:

- Deben ser verdaderos después de la construcción del objeto
- Deben mantenerse antes y después de cada método público
- Pueden estar temporalmente violados dentro de los métodos privados

### Características del enfoque DbC

#### Enfoque en la corrección

El DbC se centra en asegurar la corrección del software, considerando los contratos como una especificación formal del comportamiento esperado.

#### Distinción de responsabilidades

Establece una clara distinción entre:

- **Error lógico**: Violación de una precondición, postcondición o invariante dentro de la especificación del programa
- **Error excepcional**: Situación fuera de la especificación (fallo del sistema, error de comunicación, etc.)

#### Herramientas de implementación

Se implementa mediante:

- **Aserciones**: Para verificar contratos en tiempo de ejecución
- **Anotaciones**: Para documentar contratos estáticamente
- **Herramientas de análisis**: Para verificar contratos en tiempo de compilación

## ¿Para qué?

<div align=center>

| Diseño por Contrato Efectivo |||| Ausencia de Contratos Formales |
|-|-:|:-:|:-|-|
|Errores detectados tempranamente  |**Robustez**|     *vs*|**Fragilidad**  | Errores propagados y detectados tardíamente |
|Responsabilidades claras          |**Fluidez**|*vs*|**Viscosidad**| Confusión sobre quién verifica qué |
|Código limpio y directo           |**Flexibilidad**|*vs*|**Rigidez**| Verificaciones redundantes en múltiples lugares |
|Documentación precisa y verificable|**Reusabilidad**|    *vs*|**Inmovilidad**  | Comportamiento poco documentado o no verificado |

</div>

La metáfora del "contrato legal" captura perfectamente este principio:

> "Así como un contrato legal define claramente las obligaciones y garantías entre las partes, reduciendo malentendidos y litigios, el Diseño por Contrato define formalmente las responsabilidades entre componentes de software, minimizando errores y facilitando la detección de violaciones en las primeras etapas del desarrollo."

## ¿Cómo?

Para aplicar efectivamente el Diseño por Contrato en el desarrollo de software, se pueden seguir estas estrategias prácticas:

### Establecer una estrategia de contratos

#### Elegir el nivel de aplicación

Decidir cómo se implementarán los contratos:

##### Nivel documentación

Contratos expresados en comentarios y documentación.

  ```java
  /**
   * Divide dos números.
   * 
   * @param dividendo El número a dividir
   * @param divisor El número por el cual dividir
   * @return El resultado de la división
   * @throws IllegalArgumentException si divisor es cero
   * @pre divisor != 0
   * @post Math.abs(resultado * divisor - dividendo) < 0.0001
   */
  public double dividir(double dividendo, double divisor) {
      if (divisor == 0) {
          throw new IllegalArgumentException("El divisor no puede ser cero");
      }
      return dividendo / divisor;
  }
  ```

##### Nivel verificación en runtime

Contratos verificados durante la ejecución.

  ```java
  public double dividir(double dividendo, double divisor) {
      // Verificación de precondición
      assert divisor != 0 : "Precondición violada: divisor != 0";
      
      double resultado = dividendo / divisor;
      
      // Verificación de postcondición
      assert Math.abs(resultado * divisor - dividendo) < 0.0001 : 
          "Postcondición violada: resultado inconsistente";
      
      return resultado;
  }
  ```

##### Nivel verificación estática

Contratos verificados en tiempo de compilación.

  ```java
  // Usando JML (Java Modeling Language)
  //@ requires divisor != 0;
  //@ ensures Math.abs(\result * divisor - dividendo) < 0.0001;
  public double dividir(double dividendo, double divisor) {
      return dividendo / divisor;
  }
  ```

### Implementar contratos de manera progresiva

#### Definir precondiciones

Especificar claramente qué debe cumplirse antes de llamar a un método:

```java
/**
 * Transfiere fondos entre cuentas.
 * 
 * @param origen Cuenta de origen
 * @param destino Cuenta de destino
 * @param monto Cantidad a transferir
 * @pre origen != null
 * @pre destino != null
 * @pre monto > 0
 * @pre origen.getSaldo() >= monto
 */
public void transferir(Cuenta origen, Cuenta destino, double monto) {
    // Verificación de precondiciones
    Objects.requireNonNull(origen, "Cuenta origen no puede ser nula");
    Objects.requireNonNull(destino, "Cuenta destino no puede ser nula");
    if (monto <= 0) {
        throw new IllegalArgumentException("El monto debe ser positivo");
    }
    if (origen.getSaldo() < monto) {
        throw new IllegalArgumentException("Saldo insuficiente");
    }
    
    // Implementación...
}
```

#### Definir postcondiciones

Especificar las garantías que ofrece el método después de su ejecución:

```java
/**
 * Busca un cliente en la base de datos.
 * 
 * @param id Identificador del cliente
 * @return Cliente encontrado o null si no existe
 * @post resultado == null || resultado.getId().equals(id)
 */
public Cliente buscarPorId(String id) {
    Cliente cliente = repositorio.buscar(id);
    
    // Verificación de postcondición
    assert cliente == null || cliente.getId().equals(id) : 
        "Postcondición violada: ID del cliente inconsistente";
    
    return cliente;
}
```

#### Definir invariantes

Especificar condiciones que deben mantenerse durante toda la vida del objeto:

```java
/**
 * Representa una cuenta bancaria.
 * 
 * @inv saldo >= saldoMinimo
 * @inv numeroCuenta != null && !numeroCuenta.isEmpty()
 */
public class CuentaBancaria {
    private final String numeroCuenta;
    private double saldo;
    private final double saldoMinimo;
    
    // Constructor, métodos...
    
    private void verificarInvariante() {
        assert saldo >= saldoMinimo : 
            "Invariante violado: saldo >= saldoMinimo";
        assert numeroCuenta != null && !numeroCuenta.isEmpty() : 
            "Invariante violado: numeroCuenta válido";
    }
}
```

### Balancear contratos y excepciones

#### Distinguir entre errores contractuales y excepcionales

- **Errores contractuales**: Violaciones de precondiciones, postcondiciones o invariantes (generalmente problemas de programación).
- **Errores excepcionales**: Situaciones fuera del control del programa (problemas externos).

```java
public File abrirArchivo(String ruta) {
    // Verificación de precondición (error contractual)
    if (ruta == null || ruta.isEmpty()) {
        throw new IllegalArgumentException("La ruta no puede ser nula o vacía");
    }
    
    try {
        // Posible error excepcional (archivo no existe, sin permisos, etc.)
        return new File(ruta);
    } catch (SecurityException e) {
        throw new IOException("No se puede acceder al archivo por restricciones de seguridad", e);
    }
}
```

#### Estrategias de verificación

Decidir cuándo y cómo verificar contratos:

- **Desarrollo/Pruebas**: Verificación agresiva y completa de todos los contratos.
- **Producción**: Verificación selectiva o desactivación por rendimiento.

```java
public class Configuracion {
    private static final boolean VERIFICAR_CONTRATOS = 
        Boolean.parseBoolean(System.getProperty("app.verificarContratos", "true"));
    
    public static void verificarPrecondicion(boolean condicion, String mensaje) {
        if (VERIFICAR_CONTRATOS && !condicion) {
            throw new PrecondicionVioladaException(mensaje);
        }
    }
    
    // Métodos similares para postcondiciones e invariantes...
}

// Uso
public void metodo(Parametro p) {
    Configuracion.verificarPrecondicion(p != null, "Parámetro no puede ser nulo");
    // Implementación...
}
```

### Integrar con el ciclo de desarrollo

#### Pruebas basadas en contratos

Diseñar casos de prueba específicamente para verificar contratos:

```java
@Test
public void transferir_MontoNegativo_LanzaExcepcion() {
    Cuenta origen = new Cuenta("123", 1000);
    Cuenta destino = new Cuenta("456", 500);
    
    // Prueba de precondición: monto > 0
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        servicio.transferir(origen, destino, -100);
    });
    
    assertTrue(exception.getMessage().contains("monto"));
}
```
