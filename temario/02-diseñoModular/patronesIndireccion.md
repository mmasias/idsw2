# Patrones de indirección

## ¿Por qué?

Cuando dos componentes se conocen directamente, un cambio en uno puede forzar cambios en el otro. El acoplamiento no es un problema abstracto: tiene consecuencias concretas en cada modificación del sistema.

```java
class GestorPedidos {
    void confirmar(int idPedido) {
        // GestorPedidos conoce el esquema de la base de datos
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/tienda", "usuario", "clave");
        PreparedStatement stmt = conn.prepareStatement(
            "UPDATE pedidos SET estado = 'CONFIRMADO' WHERE id = ?");
        stmt.setInt(1, idPedido);
        stmt.executeUpdate();
        conn.close();

        // GestorPedidos conoce el servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.empresa.com");
        // ... enviar notificación al cliente...
    }
}
```

`GestorPedidos` conoce la URL de la base de datos, el esquema SQL y la configuración SMTP. Cambiar de MySQL a PostgreSQL, o de correo directo a un servicio externo, obliga a modificar `GestorPedidos`, cuya responsabilidad es coordinar pedidos, no gestionar infraestructura.

## ¿Qué?

Los patrones de indirección son estrategias de diseño que introducen un componente intermediario entre dos elementos que de otro modo dependerían directamente el uno del otro.

> "La mayoría de los problemas en las Ciencias de la Computación pueden resolverse con otro nivel de indirección. Pero eso normalmente creará otro problema."
>
> - David Wheeler

La primera frase es el principio; la segunda es el compromiso. La indirección reduce el acoplamiento entre los extremos, pero el intermediario tiene un coste: más clases, más saltos de ejecución, más conceptos que entender.

El intermediario puede tomar distintas formas según su responsabilidad:

<div align=center>

| Patrón | El intermediario es... | Ejemplo |
|-|-|-|
| **Invención pura** | Una clase de servicio sin equivalente en el dominio | `CalculadorPrecio`, `FormateadorInforme` |
| **Vista separada** | Una capa de presentación sin lógica de negocio | `VistaPedido`, `InformePedido` |
| **Controlador** | Un coordinador entre eventos externos y el dominio | `ControladorPedido`, `ProcesadorPago` |
| **Creador** | Un objeto responsable de construir otros objetos | `FabricaPedidos`, `PedidoBuilder` |

</div>

Los cuatro son variantes del mismo principio: un componente con responsabilidad clara que desacopla a los demás.

## ¿Para qué?

La ganancia concreta de la indirección es la **sustituibilidad**: si `GestorPedidos` depende de la interfaz `RepositorioPedidos` en lugar de de la clase `RepositorioPedidosMySQL`, se puede sustituir la implementación sin tocar `GestorPedidos`. Esto aplica a testing (sustituir por un repositorio en memoria), a migración tecnológica (cambiar la base de datos) y a extensión del sistema (añadir un nuevo canal de notificación).

## ¿Cómo?

### Vista separada -> MVC

El modelo de dominio no debería saber cómo se presenta. Un `Pedido` no debería construir ventanas ni generar HTML: esa responsabilidad pertenece a una capa separada.

```java
// Sin vista separada: Pedido conoce la tecnología de presentación
class Pedido {
    void mostrar() {
        System.out.println("Pedido #" + id + " - Estado: " + estado);
        // Cambiar de consola a interfaz gráfica obliga a modificar Pedido
    }
}
```

La solución es extraer la presentación a su propia clase:

```java
class Pedido {
    private int id;
    private String estado;

    int getId()       { return id; }
    String getEstado() { return estado; }
    void confirmar()  { this.estado = "CONFIRMADO"; }
}

interface VistaPedido {
    void mostrarEstado(String estado);
    void mostrarError(String mensaje);
}

class VistaPedidoConsola implements VistaPedido {
    public void mostrarEstado(String estado) {
        System.out.println("Estado del pedido: " + estado);
    }
    public void mostrarError(String mensaje) {
        System.err.println("Error: " + mensaje);
    }
}
```

Pero ahora hay un problema nuevo: ¿quién coordina la interacción? La vista no debería modificar el modelo directamente, y el modelo no debería conocer la vista. El **Controlador** resuelve exactamente esto:

```java
class ControladorPedido {
    private Pedido pedido;
    private VistaPedido vista;

    ControladorPedido(Pedido pedido, VistaPedido vista) {
        this.pedido = pedido;
        this.vista = vista;
    }

    void confirmarPedido() {
        pedido.confirmar();
        vista.mostrarEstado(pedido.getEstado());
    }
}
```

`ControladorPedido` es una **Invención pura**: no representa ningún concepto del dominio, es un intermediario diseñado para coordinar. El resultado es el patrón **Modelo-Vista-Controlador (MVC)**:

- El **Modelo** (`Pedido`) contiene el estado y la lógica de dominio. No sabe nada de la presentación.
- La **Vista** (`VistaPedido`) sabe presentar. No modifica el modelo directamente.
- El **Controlador** (`ControladorPedido`) responde a acciones externas, actualiza el modelo y pide a la vista que se refresque.

La clave arquitectural es que `VistaPedido` es una interfaz: el mismo `ControladorPedido` puede trabajar con `VistaPedidoConsola`, `VistaPedidoWeb` o un doble de prueba sin ningún cambio.

### Creador -> Builder

El patrón **Creador** identifica quién debería ser responsable de instanciar un objeto: normalmente, quien lo contiene, lo registra o tiene los datos necesarios para inicializarlo.

Cuando esa construcción es simple, un constructor ordinario es suficiente. El problema aparece cuando el objeto tiene muchos parámetros opcionales o requiere varios pasos de configuración:

```java
// Construcción ambigua: ¿qué significa cada argumento?
Pedido pedido = new Pedido(cliente, direccion, null, true, 0.0, "NUEVO");
```

El patrón **Builder** convierte la creación en una secuencia explícita de pasos nombrados, con validación al final:

```java
class PedidoBuilder {
    private Cliente cliente;
    private Direccion direccion;
    private List lineas = new ArrayList();
    private double descuento = 0.0;

    PedidoBuilder(Cliente cliente) {
        this.cliente = cliente;
    }

    PedidoBuilder conDireccion(Direccion direccion) {
        this.direccion = direccion;
        return this;
    }

    PedidoBuilder conProducto(Producto producto, int cantidad) {
        lineas.add(new LineaPedido(producto, cantidad));
        return this;
    }

    PedidoBuilder conDescuento(double porcentaje) {
        this.descuento = porcentaje;
        return this;
    }

    Pedido construir() {
        if (cliente == null)
            throw new IllegalStateException("El pedido debe tener cliente");
        if (lineas.isEmpty())
            throw new IllegalStateException("El pedido debe tener al menos un producto");
        return new Pedido(cliente, direccion, lineas, descuento);
    }
}
```

```java
// Uso: cada paso tiene nombre explícito
Pedido pedido = new PedidoBuilder(cliente)
    .conDireccion(direccion)
    .conProducto(camiseta, 2)
    .conProducto(pantalon, 1)
    .conDescuento(10.0)
    .construir();
```

`PedidoBuilder` es otra **Invención pura**: no existe ningún "builder de pedidos" en el dominio de negocio. Es un intermediario cuya única función es hacer que la construcción sea legible y segura.

### El compromiso

La segunda frase de Wheeler es la que habitualmente se omite. Cada intermediario añade:

- Una clase más que leer, entender y mantener
- Un salto de ejecución más que seguir al depurar
- Una capa de abstracción que puede resultar innecesaria si el sistema es simple

La señal de que hay demasiada indirección: una clase tiene una sola implementación posible y no hay ningún motivo realista para que aparezca otra. En ese caso el intermediario no desacopla - solo complica.

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
