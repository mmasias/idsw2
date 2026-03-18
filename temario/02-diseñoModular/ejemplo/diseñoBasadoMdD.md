# Sistema de gestión de una biblioteca

Sistema de gestión de biblioteca.

## Modelado del dominio inicial

Siguiendo el análisis del dominio, identificamos estas entidades principales:

- Libro
- Usuario
- Préstamo
- Biblioteca

## Implementación

![](/images/temario/02-diseñoModular/ejemplo/diseñoMDD.svg)

```java
class Biblioteca {
    private List<Libro> inventarioLibros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamosActivos;
    private BaseDatos baseDatos;
    private InterfazUsuario interfaz;
    private ServicioEmail servicioEmail;
    
    // Constructor
    public Biblioteca() {
        this.inventarioLibros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamosActivos = new ArrayList<>();
        this.baseDatos = new BaseDatos();
        this.interfaz = new InterfazUsuario(this);
        this.servicioEmail = new ServicioEmail();
    }
    
    // Métodos CRUD para libros
    public void agregarLibro(Libro libro) {
        inventarioLibros.add(libro);
        baseDatos.guardarLibro(libro);
        interfaz.mostrarMensaje("Libro agregado: " + libro.getTitulo());
    }
    
    public Libro buscarLibroPorISBN(String isbn) {
        return inventarioLibros.stream()
            .filter(libro -> libro.getIsbn().equals(isbn))
            .findFirst()
            .orElse(null);
    }
    
    // Métodos CRUD para usuarios
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        baseDatos.guardarUsuario(usuario);
        servicioEmail.enviarBienvenida(usuario.getEmail());
        interfaz.mostrarMensaje("Usuario registrado: " + usuario.getNombre());
    }
    
    // Gestión de préstamos
    public void prestarLibro(String isbn, int idUsuario) {
        Libro libro = buscarLibroPorISBN(isbn);
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        
        if (libro != null && usuario != null && libro.isDisponible()) {
            Prestamo prestamo = new Prestamo(libro, usuario);
            prestamosActivos.add(prestamo);
            libro.setDisponible(false);
            
            // Actualiza la base de datos
            baseDatos.registrarPrestamo(prestamo);
            
            // Genera recibo
            String recibo = generarRecibo(prestamo);
            interfaz.mostrarRecibo(recibo);
            
            // Envía notificación
            servicioEmail.enviarConfirmacionPrestamo(usuario.getEmail(), libro.getTitulo());
        } else {
            interfaz.mostrarError("No se puede realizar el préstamo");
        }
    }
    
    public void devolverLibro(String isbn) {
        Libro libro = buscarLibroPorISBN(isbn);
        if (libro != null) {
            Prestamo prestamo = buscarPrestamoActivoPorLibro(libro);
            if (prestamo != null) {
                prestamosActivos.remove(prestamo);
                libro.setDisponible(true);
                
                // Verificar si hay multa
                if (prestamo.estaVencido()) {
                    double multa = calcularMulta(prestamo);
                    prestamo.getUsuario().agregarMulta(multa);
                    interfaz.mostrarMensaje("Multa generada: $" + multa);
                    servicioEmail.notificarMulta(prestamo.getUsuario().getEmail(), multa);
                }
                
                baseDatos.actualizarEstadoLibro(libro);
                baseDatos.cerrarPrestamo(prestamo);
                
                interfaz.mostrarMensaje("Libro devuelto: " + libro.getTitulo());
            }
        }
    }
    
    // Generación de reportes
    public void generarReporteLibrosMasSolicitados() {
        List<ReporteLibro> reporte = baseDatos.obtenerEstadisticasPrestamos();
        interfaz.mostrarReporte(reporte);
    }
    
    // Muchos otros métodos...
}

class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private boolean disponible;
    
    // Getters, setters, etc.
}

class Usuario {
    private int id;
    private String nombre;
    private String email;
    private List<Double> multas;
    
    public void agregarMulta(double monto) {
        multas.add(monto);
    }
    
    // Getters, setters, etc.
}

class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    
    public boolean estaVencido() {
        // Lógica para determinar si el préstamo está vencido
        return false;
    }
    
    // Getters, setters, etc.
}
```

## Problemas identificados

### 1. Clase *Biblioteca* acumula demasiadas responsabilidades

La clase `Biblioteca` se ha convertido en un "experto en información" que:

- Gestiona el inventario de libros
- Administra usuarios
- Controla préstamos
- Maneja la persistencia en base de datos
- Interactúa con la interfaz de usuario
- Envía comunicaciones por email
- Genera reportes
- Calcula multas

### 2. Acoplamiento a múltiples tecnologías

La clase `Biblioteca` está acoplada a:

- Interfaz de usuario (`interfaz.mostrarMensaje()`)
- Persistencia (`baseDatos.guardarLibro()`)
- Comunicaciones (`servicioEmail.enviarConfirmacionPrestamo()`)

### 3. Entidades con responsabilidades mal distribuidas

- `Biblioteca` tiene toda la lógica de negocio
- `Libro` y `Usuario` son simples contenedores de datos
- La lógica de multas está dividida entre `Biblioteca` y `Usuario`

## Consecuencias

Este diseño, aunque refleja directamente el modelo del dominio, genera serios problemas:

1. **Mantenibilidad reducida**: Cualquier cambio en la lógica de préstamos, comunicaciones o interfaz requiere modificar la clase `Biblioteca`.
1. **Testabilidad complicada**: Probar la función `prestarLibro()` requiere configurar la base de datos, interfaz y servicio de email.
1. **Acoplamiento alto**: Si cambia la implementación de la base de datos o del servicio de email, se debe modificar la clase `Biblioteca`.
1. **Reutilización limitada**: La lógica de préstamos no puede reutilizarse sin arrastrar toda la clase `Biblioteca`.
1. **Extensibilidad reducida**: Agregar un nuevo tipo de notificación (como SMS) requiere modificar la clase `Biblioteca`.

> [Ver la solución con diseño modular](diseñoModular.md)