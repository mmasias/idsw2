# Cohesión

## ¿Por qué?

Los sistemas viscosos, rígidos, frágiles e inmóviles tienen habitualmente un denominador común: sus componentes asumen responsabilidades que no guardan relación entre sí. La cohesión es el principio que mide y guía ese reparto.

## ¿Qué?

La cohesión es un principio fundamental del diseño modular que mide la fortaleza con la que se relacionan las responsabilidades asignadas a un elemento del software.

> "La cohesión, o más específicamente, la **cohesión funcional**, es una **medida de cómo de fuerte están relacionadas y enfocadas las responsabilidades** que son de un elemento. Estos elementos incluyen **sistemas, paquetes, clases y métodos**."
>
> — Craig Larman, UML y Patrones

Este concepto fue formulado inicialmente por Larry Constantine en la década de 1960, y refinado posteriormente en colaboración con Ed Yourdon y Wayne Stevens. La cohesión constituye uno de los tres pilares fundamentales del diseño modular, junto con el bajo acoplamiento y el tamaño adecuado.

### Niveles de cohesión

Se pueden identificar los siguientes niveles de cohesión, ordenados de mejor a peor:

<table>
<tr>
<td>1. <b>Cohesión funcional</b> (la más alta)</td>
<td>El módulo realiza una única tarea bien definida.</td>
<td>

```java
public double calcularAreaCirculo(double radio) {
    return Math.PI * radio * radio;
}
```
</td>
</tr>
<tr>
<tr></tr>
<td>2. <b>Cohesión secuencial</b></td>
<td>La salida de una parte del módulo sirve como entrada para otra.</td>
<td>

```java
public String procesarTexto(String texto) {
    String textoNormalizado = texto.toLowerCase().trim();
    return eliminarCaracteresEspeciales(textoNormalizado);
}
```
</td>
</tr>
<tr>
<tr></tr>
<td>3. <b>Cohesión comunicacional</b></td>
<td>Las partes del módulo operan sobre los mismos datos.</td>
<td>

```java
public class ProcesadorPedido {
    public void procesarPedido(Pedido pedido) {
        validarStock(pedido);
        calcularTotal(pedido);
        aplicarDescuentos(pedido);
    }
}
```
</td>
</tr>
<tr></tr>
<tr>
<td>4. <b>Cohesión procedimental</b></td>
<td>Las partes del módulo se ejecutan en secuencia pero operan sobre datos diferentes y pertenecen a responsabilidades distintas.</td>
<td>

```java
public void procesarNuevoPedido(
    int idPedido, Cliente cliente,
    List<Producto> productos) {
    verificarDisponibilidadProductos(productos);
    actualizarHistorialCliente(cliente);
    generarFactura(idPedido, productos);
    registrarEstadisticasVenta(productos);
    enviarCorreoConfirmacion(cliente.getEmail(), idPedido);
}
```
</td>
</tr>
<tr>
<tr></tr>
<td>5. <b>Cohesión temporal</b></td>
<td>Actividades agrupadas por el momento en que se ejecutan, no por su relación funcional.</td>
<td>

```java
public void inicializarSistema() {
    conectarBaseDatos();
    cargarConfiguracion();
    iniciarInterfazUsuario();
}
```
</td>
</tr>
<tr>
<tr></tr>
<td>6. <b>Cohesión lógica</b></td>
<td>El módulo realiza funciones lógicamente relacionadas pero funcionalmente diferentes, seleccionadas mediante un parámetro de control.</td>
<td>

```java
public void procesarEntrada(String tipo, Object datos) {
    switch(tipo) {
        case "teclado": 
            procesarTeclado(datos); 
            break;
        case "mouse":   
            procesarMouse(datos);   
            break;
        case "voz":     
            procesarVoz(datos);     
            break;
    }
}
```
</td>
</tr>
<tr>
<tr></tr>
<td>7. <b>Cohesión coincidental</b> (la más baja)</td>
<td>Las partes del módulo no tienen relación entre sí.</td>
<td>

```java
public class Utilidades {
    public static void enviarEmail() {
         /*...*/ 
    }
    public static double calcularImpuesto() {
        /*...*/ 
    }
    public static void optimizarImagen() {
        /*...*/ 
    }
}
```
</td>
</tr>
</table>

### Alta vs. baja cohesión

En el diseño de software, se distinguen dos situaciones contrapuestas:

<div align=center>

|Alta cohesión|Baja cohesión|
|-|-|
|Se asignan responsabilidades muy relacionadas entre sí|Se asignan responsabilidades escasamente relacionadas|
|No se realiza una cantidad excesiva de trabajo|Se realiza una cantidad desproporcionada de trabajo|
|Se delega adecuadamente a otros objetos|Se asumen responsabilidades que deberían delegarse|
|Se implementa un número relativamente pequeño de métodos con funcionalidad relacionada|Se asignan responsabilidades moderadas pero de áreas diferentes|
|Se colabora con otros objetos para distribuir el esfuerzo||

</div>

### Compromisos y excepciones

Casos muy específicos en los que se justifica la aceptación de una cohesión menor:


||||
|-|-|-|
***Clases de utilidad***|Agrupación de responsabilidades o código en una clase o componente para simplificar el mantenimiento de una persona aunque se advierte que tal agrupación también puede hacer el mantenimiento peor.|Ej.: la clase System en Java (`java.lang.System`). Agrupa `in`, `out`, `err`, `gc()`, `arraycopy()`, `currentTimeMillis()`, `exit()`, `getenv()`... Responsabilidades sin relación funcional entre sí: I/O estándar, gestión de memoria, operaciones de array, tiempo del sistema, control de proceso. Cohesión funcional: nula. La justificación no es de diseño sino de mantenimiento operativo: un único punto de acceso a servicios de bajo nivel del runtime evita que el desarrollador deba conocer qué clase concreta gestiona cada aspecto de la JVM. La agrupación está justificada si los elementos agrupados comparten un *contexto de uso* estable aunque no compartan responsabilidad funcional, y si la audiencia del componente es lo suficientemente amplia como para que el punto de acceso único tenga valor real.
|***Servidores distribuidos***|Por mantenimiento y rendimiento (justificado!!!) a veces es deseable crear menos y más grandes objetos servidores, menos cohesivos que proporcionan una interfaz para muchas operaciones.|Ej.: la fachada de un servicio REST complejo. En sistemas distribuidos, cada llamada remota tiene un coste fijo: latencia, serialización y riesgo de fallo de red. Un diseño de grano fino con objetos muy cohesivos puede exigir decenas de viajes de red para completar una sola operación de negocio, lo que lo hace inviable en producción. La solución es una fachada de grano grueso que expone operaciones completas (`procesarPedido()`, `consultarEstadoCliente()`) aunque agrupe responsabilidades heterogéneas. La baja cohesión es el precio explícito de reducir llamadas remotas; internamente, esa fachada delega en objetos cohesivos. La justificación exige que el problema de rendimiento sea real y medible, no una suposición.
|***Frameworks legacy***|Sistemas heredados donde la refactorización representaría un riesgo mayor que mantener la baja cohesión existente.

## ¿Para qué?

La alta cohesión es lo que produce los sistemas fluidos, flexibles, reusables y robustos descritos en el diseño modular. A nivel de componente: cada elemento puede entenderse, modificarse y reutilizarse de forma aislada porque tiene un único propósito claro.

## ¿Cómo?

Para aplicar correctamente el principio de cohesión en el diseño de software, deben seguirse estas estrategias prácticas:

### Identificar "code smells" que señalan problemas de cohesión

- **[Envidia de características](sc.fe.md)**: Cuando un método parece más interesado en los datos o comportamientos de otra clase que en los propios.
- **[Clase de datos](sc.dc.md)**: Clases con solo atributos y getters/setters sin comportamiento real que encapsule reglas de negocio.
- **[Cambios divergentes](sc.dch.md)**: Cuando una clase cambia por múltiples razones no relacionadas, indicando responsabilidades mezcladas.
- **[Cirugía con escopeta](sc.ss.md)**: Cuando un solo cambio conceptual requiere modificar muchas clases distintas, señalando responsabilidades fragmentadas.
- **[Grupo de datos](sc.dcl.md)**: Los mismos grupos de campos aparecen juntos en múltiples lugares, sugiriendo que deberían ser su propia clase.
- **[Obsesión por tipos primitivos](sc.po.md)**: Uso excesivo de tipos primitivos en lugar de pequeñas clases de dominio con alta cohesión.
- **[Clases perezosas](sc.lc.md)**: Clases que hacen demasiado poco para justificar su existencia, fragmentando conceptos que deberían estar juntos.

### Técnicas de diseño & refactorización

- **Extraer método**: Debe separarse un fragmento de código en un método con un nombre representativo.

   ```java
   // Antes
   public void procesarPedido() {
       // Verificar disponibilidad
       for (Item item : items) {
           if (item.getStock() < item.getCantidad()) {
               throw new StockInsuficienteException();
           }
       }
       
       // Calcular total
       double total = 0;
       for (Item item : items) {
           total += item.getPrecio() * item.getCantidad();
       }
       
       // etc...
   }
   
   // Después
   public void procesarPedido() {
       verificarDisponibilidad();
       double total = calcularTotal();
       // etc...
   }
   
   private void verificarDisponibilidad() {
       for (Item item : items) {
           if (item.getStock() < item.getCantidad()) {
               throw new StockInsuficienteException();
           }
       }
   }
   
   private double calcularTotal() {
       double total = 0;
       for (Item item : items) {
           total += item.getPrecio() * item.getCantidad();
       }
       return total;
   }
   ```

- **Extraer clase**: Debe crearse una nueva clase para responsabilidades específicas.

   ```java
   // Antes
   public class Pedido {
       private List<Item> items;
       private Cliente cliente;
       private double total;
       
       // Lógica de pedido
       
       // Métodos para envío
       public void calcularCostoEnvio() { /*...*/ }
       public void seleccionarTransportista() { /*...*/ }
       public void generarEtiquetaEnvio() { /*...*/ }
   }
   
   // Después
   public class Pedido {
       private List<Item> items;
       private Cliente cliente;
       private double total;
       private Envio envio;
       
       // Lógica de pedido
   }
   
   public class Envio {
       private Transportista transportista;

       public void calcularCosto(Pedido pedido) { /*...*/ }
       public void seleccionarTransportista() { /*...*/ }
       public void generarEtiqueta(Pedido pedido) { /*...*/ }
   }
   ```

- **Mover método/campo**: Debe reubicarse funcionalidad en la clase apropiada.

   ```java
   // Antes
   public class Cliente {
       // ...
       public double calcularDescuentoPedido(Pedido pedido) {
           if (esClienteVIP()) {
               return pedido.getTotal() * 0.1;
           }
           return 0;
       }
   }
   
   // Después
   public class Cliente {
       // ...
       public boolean esClienteVIP() {
           return // ...
       }
   }
   
   public class Pedido {
       // ...
       public double calcularDescuento(Cliente cliente) {
           if (cliente.esClienteVIP()) {
               return getTotal() * 0.1;
           }
           return 0;
       }
   }
   ```

- **Introducir objeto-parámetro**: Deben agruparse parámetros relacionados en una clase.

   ```java
   // Antes
   public void registrarEnvio(String calle, String ciudad, 
                           String provincia, String codigoPostal,
                           String pais) {
       // ...
   }
   
   // Después
   public void registrarEnvio(Direccion direccion) {
       // ...
   }
   
   public class Direccion {
       private String calle;
       private String ciudad;
       private String provincia;
       private String codigoPostal;
       private String pais;
       
       // Constructor, getters, etc.
   }
   ```

### Métricas para evaluar la cohesión

Pueden emplearse métricas formales para medir la cohesión:

- **LCOM (Lack of Cohesion in Methods)**: Mide la disparidad entre métodos de una clase. Un valor alto indica baja cohesión.
- **LCOM4**: Una versión mejorada de LCOM que considera las relaciones indirectas entre métodos.
- **TCC (Tight Class Cohesion)**: Mide el porcentaje de pares de métodos visibles públicamente que comparten al menos un atributo.
- **LCC (Loose Class Cohesion)**: Similar a TCC pero considera conexiones indirectas.

### Herramientas de análisis estático de código

Herramientas como SonarQube, JDepend o el analizador de métricas de IntelliJ IDEA pueden detectar automáticamente problemas de cohesión y cuantificarlos con las métricas anteriores.
