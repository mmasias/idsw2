import java.util.ArrayList;
import java.util.List;

public class EjemploSistemaDocumentos {
    public static void main(String[] args) {
        // Este ejemplo muestra un sistema donde conviven los 4 tipos de relaciones
        
        // Creamos documentos (con una relación de composición interna con su contenido)
        Documento doc1 = new Documento("Informe trimestral");
        Documento doc2 = new Documento("Presupuesto anual");
        Documento doc3 = new Documento("Plan estratégico");
        
        System.out.println("Documentos creados:");
        System.out.println("- " + doc1.getTitulo());
        System.out.println("- " + doc2.getTitulo());
        System.out.println("- " + doc3.getTitulo());
        
        // AGREGACIÓN: Carpetas que contienen documentos pero no controlan su ciclo de vida
        Carpeta carpetaFinanzas = new Carpeta("Finanzas");
        carpetaFinanzas.agregarDocumento(doc1);
        carpetaFinanzas.agregarDocumento(doc2);
        
        Carpeta carpetaPlanes = new Carpeta("Planes");
        carpetaPlanes.agregarDocumento(doc3);
        carpetaPlanes.agregarDocumento(doc2); // Un documento puede estar en varias carpetas
        
        System.out.println("Documentos en carpeta Finanzas:");
        carpetaFinanzas.listarDocumentos();
        
        System.out.println("Documentos en carpeta Planes:");
        carpetaPlanes.listarDocumentos();
        
        // ASOCIACIÓN: Usuarios mantienen referencias persistentes a documentos
        Usuario usuario = new Usuario("Carlos");
        usuario.abrirDocumento(doc1);
        System.out.println(usuario.getNombre() + " está editando: " + doc1.getTitulo());
        
        Usuario usuario2 = new Usuario("Ana");
        usuario2.abrirDocumento(doc3);
        System.out.println(usuario2.getNombre() + " está editando: " + doc3.getTitulo());
        
        // USO: El impresor utiliza el documento temporalmente sin mantener referencia
        Impresor impresor = new Impresor();
        System.out.println("Imprimiendo documento...");
        impresor.imprimir(doc2, 2);
        
        // Demostrando independencia de ciclo de vida en la agregación
        System.out.println("La carpeta Finanzas se elimina");
        carpetaFinanzas = null;
        
        System.out.println("El documento '" + doc1.getTitulo() + "' sigue existiendo");
        System.out.println("El documento '" + doc2.getTitulo() + "' sigue en la carpeta Planes:");
        carpetaPlanes.listarDocumentos();
    }
}

class Documento {
    private String titulo;
    // COMPOSICIÓN: Contenido no puede existir sin su documento
    private Contenido contenido;
    
    public Documento(String titulo) {
        this.titulo = titulo;
        // Creación del componente en el constructor - característica de composición
        this.contenido = new Contenido(titulo + " - contenido inicial");
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getContenido() {
        return contenido.getTexto();
    }
    
    public void setContenido(String texto) {
        contenido.setTexto(texto);
    }
    
    // Cuando el documento se destruye, su contenido también se destruye
    // Esta es la diferencia clave con la agregación
}

class Contenido {
    private String texto;
    
    public Contenido(String texto) {
        this.texto = texto;
    }
    
    public String getTexto() {
        return texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }
}

class Carpeta {
    private String nombre;
    // AGREGACIÓN: documentos existen independientemente de la carpeta
    private List<Documento> documentos;
    
    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.documentos = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void agregarDocumento(Documento doc) {
        if (!documentos.contains(doc)) {
            documentos.add(doc);
        }
    }
    
    public void eliminarDocumento(Documento doc) {
        documentos.remove(doc);
    }
    
    public void listarDocumentos() {
        if (documentos.isEmpty()) {
            System.out.println("  La carpeta está vacía");
            return;
        }
        
        for (Documento doc : documentos) {
            System.out.println("  - " + doc.getTitulo());
        }
    }
    
    // Si la carpeta se destruye, los documentos siguen existiendo
    // Esta es la diferencia clave con la composición
}

class Usuario {
    private String nombre;
    // ASOCIACIÓN: referencia duradera a documentos independientes
    private List<Documento> documentosAbiertos;
    
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.documentosAbiertos = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void abrirDocumento(Documento doc) {
        documentosAbiertos.add(doc);
    }
    
    public void cerrarDocumento(Documento doc) {
        documentosAbiertos.remove(doc);
    }
    
    public List<Documento> getDocumentosAbiertos() {
        return new ArrayList<>(documentosAbiertos);
    }
}

class Impresor {
    // USO: relación temporal durante la operación de impresión
    public void imprimir(Documento doc, int copias) {
        System.out.println("Imprimiendo " + copias + " copias del documento: " + doc.getTitulo());
        // No hay atributo que almacene el documento - relación termina al finalizar el método
    }
}