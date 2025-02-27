public class EjemploComposicion {
    public static void main(String[] args) {
        Libro libro = new Libro();
        System.out.println("Libro creado con " + libro.getNumeroPaginas() + " páginas");
        
        // Las páginas están encapsuladas dentro del libro (característica de la composición)
        System.out.println("Contenido de la primera página: " + libro.getContenidoPagina(0));
        
        libro.escribirEnPagina(0, "Este es el inicio de nuestra historia...");
        System.out.println("Contenido actualizado: " + libro.getContenidoPagina(0));
    }
}

class Libro {
    // COMPOSICIÓN: el contenedor (Libro) crea y controla el ciclo de vida de sus partes (Páginas)
    private Pagina[] paginas;
    
    public Libro() {
        // En la composición, el objeto contenedor crea y gestiona el ciclo de vida
        // de los objetos contenidos
        this.paginas = new Pagina[100];
        for (int i = 0; i < 100; i++) {
            this.paginas[i] = new Pagina();
        }
    }
    
    public int getNumeroPaginas() {
        return paginas.length;
    }
    
    public String getContenidoPagina(int numeroPagina) {
        if (numeroPagina >= 0 && numeroPagina < paginas.length) {
            return paginas[numeroPagina].getContenido();
        }
        return "Página no válida";
    }
    
    public void escribirEnPagina(int numeroPagina, String contenido) {
        if (numeroPagina >= 0 && numeroPagina < paginas.length) {
            paginas[numeroPagina].setContenido(contenido);
        }
    }
    
    // Al destruirse el objeto Libro, todas sus páginas también se destruyen
    // (característica definitoria de la composición)
}

class Pagina {
    private String contenido;
    
    public Pagina() {
        this.contenido = "Página en blanco";
    }
    
    public String getContenido() {
        return contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}