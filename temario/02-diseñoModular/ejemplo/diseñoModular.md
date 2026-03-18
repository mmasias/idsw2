# Sistema de gestión de una biblioteca — diseño modular

> Solución al [diseño basado en modelo del dominio](diseñoBasadoMdD.md).

## Rediseño

<div align=center>

|![](/images/temario/02-diseñoModular/ejemplo/solucionModular.svg)|
|-:|
<sub>[*Código fuente*](solucionModular.puml)</sub>

</div>

El criterio de partición no es "¿qué entidades hay en el dominio?" sino "¿qué decisiones pueden cambiar de forma independiente?". Cada clase oculta una de esas decisiones.

- `GestorInventario` — qué libros existen y cuáles están disponibles
- `GestorUsuarios` — qué usuarios están registrados
- `ServicioPrestamos` — lógica de préstamo y devolución
- `CalculadorMultas` — política de multas por retraso
- `Biblioteca` — coordinación y acceso a infraestructura (base de datos, email)

```java
class GestorInventario {
    private List<Libro> libros;

    public GestorInventario() {
        this.libros = new ArrayList<>();
    }

    public void agregar(Libro libro) {
        libros.add(libro);
    }

    public Libro buscarPorISBN(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
}

class GestorUsuarios {
    private List<Usuario> usuarios;

    public GestorUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void registrar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
}

class CalculadorMultas {
    private static final double MULTA_POR_DIA = 0.50;

    public double calcular(Prestamo prestamo) {
        if (!prestamo.estaVencido()) {
            return 0;
        }
        return prestamo.getDiasRetraso() * MULTA_POR_DIA;
    }
}

class ServicioPrestamos {
    private List<Prestamo> prestamosActivos;
    private GestorInventario inventario;
    private GestorUsuarios gestorUsuarios;
    private CalculadorMultas calculadorMultas;

    public ServicioPrestamos(GestorInventario inventario, GestorUsuarios gestorUsuarios) {
        this.prestamosActivos = new ArrayList<>();
        this.inventario = inventario;
        this.gestorUsuarios = gestorUsuarios;
        this.calculadorMultas = new CalculadorMultas();
    }

    public Prestamo prestar(String isbn, int idUsuario) {
        Libro libro = inventario.buscarPorISBN(isbn);
        Usuario usuario = gestorUsuarios.buscarPorId(idUsuario);
        if (libro == null || usuario == null || !libro.isDisponible()) {
            return null;
        }
        libro.setDisponible(false);
        Prestamo prestamo = new Prestamo(libro, usuario);
        prestamosActivos.add(prestamo);
        return prestamo;
    }

    public Prestamo devolver(String isbn) {
        Libro libro = inventario.buscarPorISBN(isbn);
        if (libro == null) {
            return null;
        }
        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.getLibro().equals(libro)) {
                prestamosActivos.remove(prestamo);
                libro.setDisponible(true);
                return prestamo;
            }
        }
        return null;
    }

    public double calcularMulta(Prestamo prestamo) {
        return calculadorMultas.calcular(prestamo);
    }
}

class Biblioteca {
    private GestorInventario inventario;
    private GestorUsuarios gestorUsuarios;
    private ServicioPrestamos servicioPrestamos;
    private BaseDatos baseDatos;
    private ServicioEmail servicioEmail;

    public Biblioteca() {
        this.inventario = new GestorInventario();
        this.gestorUsuarios = new GestorUsuarios();
        this.servicioPrestamos = new ServicioPrestamos(inventario, gestorUsuarios);
        this.baseDatos = new BaseDatos();
        this.servicioEmail = new ServicioEmail();
    }

    public void agregarLibro(Libro libro) {
        inventario.agregar(libro);
        baseDatos.guardarLibro(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        gestorUsuarios.registrar(usuario);
        baseDatos.guardarUsuario(usuario);
        servicioEmail.enviarBienvenida(usuario.getEmail());
    }

    public void prestarLibro(String isbn, int idUsuario) {
        Prestamo prestamo = servicioPrestamos.prestar(isbn, idUsuario);
        if (prestamo != null) {
            baseDatos.registrarPrestamo(prestamo);
            servicioEmail.enviarConfirmacionPrestamo(
                prestamo.getUsuario().getEmail(),
                prestamo.getLibro().getTitulo()
            );
        }
    }

    public void devolverLibro(String isbn) {
        Prestamo prestamo = servicioPrestamos.devolver(isbn);
        if (prestamo != null) {
            double multa = servicioPrestamos.calcularMulta(prestamo);
            if (multa > 0) {
                prestamo.getUsuario().agregarMulta(multa);
                servicioEmail.notificarMulta(prestamo.getUsuario().getEmail(), multa);
            }
            baseDatos.cerrarPrestamo(prestamo);
        }
    }
}
```

## Comparación

<div align=center>

|Problema|Diseño basado en MdD|Diseño modular|
|-|-|-|
|Responsabilidades de `Biblioteca`|8+: inventario, usuarios, préstamos, multas, persistencia, email, interfaz, reportes|1: coordinar y delegar|
|Lógica de multas|Repartida entre `Biblioteca` y `Usuario`|Contenida en `CalculadorMultas`|
|Acoplamiento a infraestructura|Extendido por todas las operaciones de dominio|Concentrado en `Biblioteca`|
|Testabilidad de `prestarLibro`|Requiere base de datos, interfaz y email activos|`ServicioPrestamos.prestar()` no depende de infraestructura|
|Impacto de cambiar la política de multas|Modificar `Biblioteca` y `Usuario`|Modificar solo `CalculadorMultas`|

</div>
