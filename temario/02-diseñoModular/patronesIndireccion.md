# Patrones de indirección

## ¿Por qué?

El desarrollo de sistemas complejos enfrenta constantemente el problema del acoplamiento excesivo entre componentes. Cuando los elementos de un sistema conocen demasiados detalles unos de otros y dependen directamente entre sí, se genera un escenario donde los cambios en un componente pueden provocar una cascada de modificaciones en todo el sistema.

Un caso típico:

```java
public class Cliente {
    private int id;
    private String nombre;
    private String email;
    
    public void guardar() {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "user", "pass");
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO clientes (id, nombre, email) VALUES (?, ?, ?)");
        stmt.setInt(1, id);
        stmt.setString(2, nombre);
        stmt.setString(3, email);
        stmt.executeUpdate();
        conn.close();
    }
    
    public void mostrarEnPantalla() {
        JFrame frame = new JFrame("Detalles de Cliente");
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("ID:"));
        panel.add(new JLabel(String.valueOf(id)));
        panel.add(new JLabel("Nombre:"));
        panel.add(new JLabel(nombre));
        panel.add(new JLabel("Email:"));
        panel.add(new JLabel(email));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void enviarEmailBienvenida() {
        // Código de envío de email...
    }
    
    // Getters y setters...
}
```

Este código presenta múltiples problemas:

- Alta dependencia a tecnologías específicas (JDBC, Swing)
- Mezcla de responsabilidades (dominio, persistencia, visualización, notificación)
- Imposibilidad de reutilización en diferentes contextos
- Extrema dificultad para realizar pruebas unitarias

## ¿Qué?

Los Patrones de indirección son estrategias de diseño que introducen componentes intermediarios para desacoplar elementos de un sistema, permitiendo que evolucionen independientemente y reduciendo el impacto de los cambios.

> "La mayoría de los problemas en las Ciencias de la Computación pueden ser resueltos con otro nivel de indirección"
>
> — David Wheeler

Este principio fundamental reconoce que la introducción controlada de capas de abstracción entre componentes permite reducir sus dependencias directas, facilitando la evolución, comprensión y mantenimiento del sistema.

### Fundamentos de la Indirección

La indirección proporciona múltiples beneficios:

1. **Permite compartir lógica**: Un intermediario puede encapsular comportamiento común a múltiples componentes.
1. **Explica la intención por separado de la implementación**: La interfaz de un intermediario describe qué hace, mientras su implementación explica cómo lo hace.
1. **Aísla los cambios**: Modificaciones en un componente no afectan directamente a otros.
1. **Codifica lógica condicional elegantemente**: Permite sustituir complejas estructuras condicionales por polimorfismo.

### Patrones de indirección fundamentales

El Diseño Modular identifica cuatro patrones de indirección principales:

#### Invención pura

Este patrón propone crear clases artificiales (que no representan conceptos del dominio) con responsabilidades específicas para mejorar la cohesión y reducir el acoplamiento.

```java
// En lugar de mezclar responsabilidades en Cliente
public class FormateoCliente {
    public String formatearNombreCompleto(Cliente cliente) {
        return cliente.getApellido() + ", " + cliente.getNombre();
    }
    
    public String formatearDireccionPostal(Cliente cliente) {
        return cliente.getCalle() + "\n" + 
               cliente.getCiudad() + ", " + cliente.getEstado() + " " + 
               cliente.getCodigoPostal();
    }
}
```

#### Vista separada

Este patrón separa la responsabilidad de visualización/presentación de la lógica de negocio, asegurando que el código que manipula la presentación solo manipule la presentación.

```java
// Modelo: solo datos y lógica de dominio
public class Cliente {
    private int id;
    private String nombre;
    private String email;
    
    // Getters y setters...
    // Lógica de dominio relacionada con el concepto Cliente
}

// Vista: solo visualización
public class VistaCliente {
    private Cliente cliente;
    
    public VistaCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void mostrar() {
        JFrame frame = new JFrame("Detalles de Cliente");
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("ID:"));
        panel.add(new JLabel(String.valueOf(cliente.getId())));
        panel.add(new JLabel("Nombre:"));
        panel.add(new JLabel(cliente.getNombre()));
        panel.add(new JLabel("Email:"));
        panel.add(new JLabel(cliente.getEmail()));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
```

#### Controlador

Este patrón asigna la responsabilidad de manejar eventos del sistema a una clase dedicada que actúa como intermediaria entre la interfaz de usuario y la lógica de negocio.

```java
// Controlador: maneja los eventos y coordina el flujo
public class ControladorCliente {
    private ServicioCliente servicio;
    private VistaCliente vista;
    
    public ControladorCliente(ServicioCliente servicio) {
        this.servicio = servicio;
    }
    
    public void mostrarDetalles(int idCliente) {
        Cliente cliente = servicio.buscarPorId(idCliente);
        if (cliente != null) {
            vista = new VistaCliente(cliente);
            vista.mostrar();
        } else {
            mostrarError("Cliente no encontrado");
        }
    }
    
    public void crearNuevoCliente(String nombre, String email) {
        try {
            Cliente nuevoCliente = servicio.crear(nombre, email);
            mostrarMensaje("Cliente creado con éxito: " + nuevoCliente.getId());
        } catch (Exception e) {
            mostrarError("Error al crear cliente: " + e.getMessage());
        }
    }
    
    // Métodos auxiliares...
}
```

#### Creador

Este patrón asigna la responsabilidad de crear instancias a clases específicas, siguiendo criterios como:

- La clase contiene o agrega el objeto creado
- La clase registra el objeto creado
- La clase usa estrechamente el objeto creado
- La clase posee los datos de inicialización necesarios

```java
// Creador: responsable de instanciar objetos
public class FabricaClientes {
    private RepositorioCliente repositorio;
    
    public FabricaClientes(RepositorioCliente repositorio) {
        this.repositorio = repositorio;
    }
    
    public Cliente crearClienteEstandar(String nombre, String email) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setEmail(email);
        cliente.setCategoria("Estándar");
        cliente.setFechaRegistro(LocalDate.now());
        repositorio.guardar(cliente);
        return cliente;
    }
    
    public Cliente crearClienteVIP(String nombre, String email, String recomendadoPor) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setEmail(email);
        cliente.setCategoria("VIP");
        cliente.setRecomendadoPor(recomendadoPor);
        cliente.setFechaRegistro(LocalDate.now());
        repositorio.guardar(cliente);
        return cliente;
    }
}
```

### Patrones de indirección adicionales

Además de los cuatro patrones fundamentales, existen varios patrones de diseño que implementan el principio de indirección:

1. **Adaptador**: Convierte la interfaz de una clase en otra que los clientes esperan.
2. **Fachada**: Proporciona una interfaz unificada para un conjunto de interfaces en un subsistema.
3. **Proxy**: Proporciona un sustituto para otro objeto para controlar el acceso a éste.
4. **Decorador**: Añade responsabilidades a los objetos dinámicamente.
5. **Mediador**: Define un objeto que encapsula cómo un conjunto de objetos interactúan.

## ¿Para qué?

<div align=center>

| Indirección |||| Acoplamiento |
|-|-:|:-:|:-|-|
|Código comprensible por partes |**Fluidez**|     *vs*|**Viscosidad**  | Componentes imposibles de entender aisladamente |
|Cambios localizados sin propagación |**Flexibilidad**|*vs*|**Rigidez**| Cambios en cascada a través del sistema |
|Pruebas unitarias efectivas |**Robustez**|*vs*|**Fragilidad**| Imposibilidad de probar componentes aisladamente |
|Componentes intercambiables |**Reusabilidad**|    *vs*|**Inmovilidad**  | Componentes atados a su contexto original |

</div>

La metáfora del "sistema eléctrico moderno" captura perfectamente este principio:

> "Un sistema bien diseñado con patrones de indirección es como la red eléctrica moderna: los dispositivos no se conectan directamente a los generadores sino a través de transformadores, interruptores y adaptadores. Estos intermediarios permiten que tanto generadores como dispositivos evolucionen independientemente, y facilitan la sustitución de unos por otros sin afectar al sistema completo."

## ¿Cómo?

Para aplicar efectivamente los Patrones de Indirección en el diseño de software, se pueden seguir estas estrategias prácticas:

### Aplicar el patrón de Invención pura

#### Crear clases de servicio

Extraer estas responsabilidades en clases dedicadas:

```java
// Antes: Responsabilidad en la entidad
public class Producto {
    private double precio;
    private double impuesto;
    
    public double calcularPrecioFinal(String regionImpositiva, boolean esReventa) {
        double precioBase = precio;
        if (esReventa) {
            precioBase *= 0.9; // 10% descuento
        }
        
        double tasaImpuesto;
        switch (regionImpositiva) {
            case "UE": tasaImpuesto = 0.21; break;
            case "USA": tasaImpuesto = 0.08; break;
            default: tasaImpuesto = 0.16;
        }
        
        return precioBase * (1 + tasaImpuesto);
    }
}

// Después: Responsabilidad extraída
public class CalculadorPrecio {
    public double calcularPrecioFinal(Producto producto, String regionImpositiva, boolean esReventa) {
        double precioBase = producto.getPrecio();
        if (esReventa) {
            precioBase *= 0.9; // 10% descuento
        }
        
        double tasaImpuesto = obtenerTasaImpuesto(regionImpositiva);
        return precioBase * (1 + tasaImpuesto);
    }
    
    private double obtenerTasaImpuesto(String regionImpositiva) {
        switch (regionImpositiva) {
            case "UE": return 0.21;
            case "USA": return 0.08;
            default: return 0.16;
        }
    }
}

// La entidad queda limpia
public class Producto {
    private double precio;
    private double impuesto;
    
    // Getters y setters...
}
```

### Aplicar el patrón vista separada

#### Separar *Modelo* de la *Visualización*

```java
// Separación clara de responsabilidades
public class InformePedido {
    private Pedido pedido;
    
    public InformePedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    // Método de la vista: formateo HTML
    public String generarHTML() {
        StringBuilder html = new StringBuilder();
        html.append("<h1>Pedido #").append(pedido.getId()).append("</h1>");
        html.append("<p>Cliente: ").append(pedido.getCliente().getNombre()).append("</p>");
        html.append("<table><tr><th>Producto</th><th>Cantidad</th><th>Precio</th></tr>");
        
        for (LineaPedido linea : pedido.getLineas()) {
            html.append("<tr><td>").append(linea.getProducto().getNombre()).append("</td>");
            html.append("<td>").append(linea.getCantidad()).append("</td>");
            html.append("<td>").append(formatearMoneda(linea.getPrecio())).append("</td></tr>");
        }
        
        html.append("</table>");
        html.append("<p>Total: ").append(formatearMoneda(pedido.getTotal())).append("</p>");
        
        return html.toString();
    }
    
    // Método de la vista: formateo PDF
    public byte[] generarPDF() {
        // Código para generar PDF...
        return new byte[0];
    }
    
    private String formatearMoneda(double valor) {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        return df.format(valor);
    }
}
```

#### Implementar Patrones MV*

Utilizar patrones como:

- Modelo-Vista-Controlador (MVC)
- Modelo-Vista-Presentador (MVP)
- Modelo-Vista-VistaModelo (MVVM)

```java
// Ejemplo simplificado de MVC
// Modelo
public class Pedido {
    // Datos y lógica de negocio...
}

// Vista
public interface VistaPedido {
    void mostrarPedido(Pedido pedido);
    void mostrarError(String mensaje);
    void cerrar();
}

// Implementación concreta de la vista
public class VistaPedidoSwing implements VistaPedido {
    private JFrame frame;
    private JTable tablaPedidos;
    
    @Override
    public void mostrarPedido(Pedido pedido) {
        // Código de UI...
    }
    
    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void cerrar() {
        frame.dispose();
    }
    
    // Métodos para capturar eventos de usuario y pasarlos al controlador...
}

// Controlador
public class ControladorPedido {
    private Pedido modelo;
    private VistaPedido vista;
    private ServicioPedido servicio;
    
    public ControladorPedido(VistaPedido vista, ServicioPedido servicio) {
        this.vista = vista;
        this.servicio = servicio;
    }
    
    public void cargarPedido(int idPedido) {
        try {
            modelo = servicio.obtenerPorId(idPedido);
            vista.mostrarPedido(modelo);
        } catch (Exception e) {
            vista.mostrarError("Error al cargar pedido: " + e.getMessage());
        }
    }
    
    public void actualizarPedido(Map<String, Object> cambios) {
        try {
            // Actualizar modelo...
            servicio.guardar(modelo);
            vista.mostrarPedido(modelo);
        } catch (Exception e) {
            vista.mostrarError("Error al actualizar: " + e.getMessage());
        }
    }
    
    public void cerrar() {
        vista.cerrar();
    }
}
```

### Aplicar el patrón Controlador

#### Crear controladores específicos

Implementar controladores según dos estrategias principales:

##### Controlador de caso de uso

Un controlador por cada caso de uso o historia de usuario.

```java
// Controlador específico para el caso de uso "Procesar Pedido"
public class ProcesarPedidoController {
    private ServicioPedido servicioPedido;
    private ServicioInventario servicioInventario;
    private ServicioFacturacion servicioFacturacion;
    
    // Constructor con inyección de dependencias...
    
    public ResultadoProcesamiento procesarPedido(int idPedido) {
        Pedido pedido = servicioPedido.obtenerPorId(idPedido);
        
        // Verificar disponibilidad
        boolean hayStock = servicioInventario.verificarDisponibilidad(pedido);
        if (!hayStock) {
            return ResultadoProcesamiento.stockInsuficiente();
        }
        
        // Reservar productos
        servicioInventario.reservarProductos(pedido);
        
        // Generar factura
        Factura factura = servicioFacturacion.generarFactura(pedido);
        
        // Actualizar estado
        pedido.setEstado(EstadoPedido.PROCESADO);
        servicioPedido.actualizar(pedido);
        
        return ResultadoProcesamiento.exitoso(factura.getId());
    }
}
```

##### Controlador de dispositivo/subsistema

Un controlador para cada dispositivo o subsistema principal.

```java
// Controlador para el subsistema de facturación
public class FacturacionController {
    private ServicioFacturacion servicioFacturacion;
    private ServicioCliente servicioCliente;
    private NotificacionService notificacionService;
    
    // Constructor con inyección de dependencias...
    
    public Factura generarFactura(DatosFacturacion datos) {
        Cliente cliente = servicioCliente.obtenerPorId(datos.getIdCliente());
        Factura factura = servicioFacturacion.crear(cliente, datos.getItems());
        
        if (datos.isNotificarCliente()) {
            notificacionService.enviarFactura(factura);
        }
        
        return factura;
    }
    
    public List<Factura> buscarFacturasPendientes(int idCliente) {
        return servicioFacturacion.buscarPendientesPorCliente(idCliente);
    }
    
    public void marcarComoPagada(int idFactura, String metodoPago) {
        Factura factura = servicioFacturacion.obtenerPorId(idFactura);
        factura.setPagada(true);
        factura.setMetodoPago(metodoPago);
        factura.setFechaPago(LocalDateTime.now());
        
        servicioFacturacion.actualizar(factura);
        notificacionService.enviarConfirmacionPago(factura);
    }
}
```

### Aplicar el patrón Creador

#### Determinar responsabilidades de creación

Identificar qué objetos deben ser responsables de crear otros, siguiendo estos criterios:

- B contiene o agrega objetos de A
- B registra instancias de A
- B usa estrechamente objetos de A
- B tiene los datos de inicialización para A

#### Implementar creadores específicos

Crear clases dedicadas a la creación de objetos complejos:

```java
// Creador básico
public class FabricaPedidos {
    private RepositorioCliente repoCliente;
    private RepositorioProducto repoProducto;
    
    public FabricaPedidos(RepositorioCliente repoCliente, RepositorioProducto repoProducto) {
        this.repoCliente = repoCliente;
        this.repoProducto = repoProducto;
    }
    
    public Pedido crearPedido(int idCliente, Map<Integer, Integer> productosYCantidades) {
        Cliente cliente = repoCliente.buscarPorId(idCliente);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente no encontrado");
        }
        
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setFecha(LocalDateTime.now());
        pedido.setEstado(EstadoPedido.NUEVO);
        
        double total = 0;
        
        for (Map.Entry<Integer, Integer> entry : productosYCantidades.entrySet()) {
            int idProducto = entry.getKey();
            int cantidad = entry.getValue();
            
            Producto producto = repoProducto.buscarPorId(idProducto);
            if (producto == null) {
                throw new IllegalArgumentException("Producto no encontrado: " + idProducto);
            }
            
            LineaPedido linea = new LineaPedido();
            linea.setPedido(pedido);
            linea.setProducto(producto);
            linea.setCantidad(cantidad);
            linea.setPrecioUnitario(producto.getPrecio());
            
            pedido.getLineas().add(linea);
            total += producto.getPrecio() * cantidad;
        }
        
        pedido.setTotal(total);
        return pedido;
    }
}
```

#### Utilizar patrones de creación

Implementar patrones de diseño específicos para la creación:

- Factory Method
- Abstract Factory
- Builder
- Prototype

```java
// Ejemplo de patrón Builder
public class PedidoBuilder {
    private Pedido pedido;
    private RepositorioProducto repoProducto;
    
    public PedidoBuilder(RepositorioProducto repoProducto) {
        this.repoProducto = repoProducto;
        this.pedido = new Pedido();
        this.pedido.setFecha(LocalDateTime.now());
        this.pedido.setEstado(EstadoPedido.NUEVO);
    }
    
    public PedidoBuilder conCliente(Cliente cliente) {
        this.pedido.setCliente(cliente);
        return this;
    }
    
    public PedidoBuilder conDireccionEnvio(Direccion direccion) {
        this.pedido.setDireccionEnvio(direccion);
        return this;
    }
    
    public PedidoBuilder conProducto(int idProducto, int cantidad) {
        Producto producto = repoProducto.buscarPorId(idProducto);
        LineaPedido linea = new LineaPedido();
        linea.setPedido(pedido);
        linea.setProducto(producto);
        linea.setCantidad(cantidad);
        linea.setPrecioUnitario(producto.getPrecio());
        
        pedido.getLineas().add(linea);
        recalcularTotal();
        
        return this;
    }
    
    public PedidoBuilder conDescuento(double porcentaje) {
        pedido.setDescuento(porcentaje);
        recalcularTotal();
        return this;
    }
    
    private void recalcularTotal() {
        double subtotal = pedido.getLineas().stream()
            .mapToDouble(l -> l.getPrecioUnitario() * l.getCantidad())
            .sum();
            
        double descuento = subtotal * (pedido.getDescuento() / 100.0);
        pedido.setTotal(subtotal - descuento);
    }
    
    public Pedido construir() {
        if (pedido.getCliente() == null) {
            throw new IllegalStateException("El pedido debe tener un cliente");
        }
        
        if (pedido.getLineas().isEmpty()) {
            throw new IllegalStateException("El pedido debe tener al menos una línea");
        }
        
        return pedido;
    }
}

// Uso del builder
Pedido pedido = new PedidoBuilder(repoProducto)
    .conCliente(cliente)
    .conDireccionEnvio(direccion)
    .conProducto(101, 2)
    .conProducto(205, 1)
    .conDescuento(5.0)
    .construir();
```
