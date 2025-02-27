import java.util.ArrayList;
import java.util.List;

public class EjemploSistemaDocumentos {
    public static void main(String[] args) {
        // Creamos documentos con contenido
        Documento doc1 = new Documento("Informe trimestral");
        Documento doc2 = new Documento("Presupuesto anual");
        Documento doc3 = new Documento("Plan estratégico");
        
        System.out.println("Documentos creados:");
        System.out.println("- " + doc1.getTitulo());
        System.out.println("- " + doc2.getTitulo());
        System.out.println("- " + doc3.getTitulo());
        
        // Creamos carpetas y agregamos documentos (AGREGACIÓN)
        Carpeta carpetaFinanzas = new Carpeta("Finanzas");
        carpetaFinanzas.agregarDocumento(doc1);
        carpetaFinanzas.agregarDocumento(doc2);
        
        Carpeta carpetaPlanes = new Carpeta("Planes");
        carpetaPlanes.agregarDocumento(doc3);
        carpetaPlanes.agregarDocumento(doc2); // Nota: doc2 está en ambas carpetas
        
        System.out.println("Documentos en carpeta Finanzas:");
        carpetaFinanzas.listarDocumentos();
        
        System.out.println("Documentos en carpeta Planes:");
        carpetaPlanes.listarDocumentos();
        
        // Un usuario edita un documento (ASOCIACIÓN)
        Usuario usuario = new Usuario("Carlos");
        usuario.abrirDocumento(doc1);
        System.out.println(usuario.getNombre() + " está editando: " + doc1.getTitulo());
        
        // Otro usuario edita otro documento
        Usuario usuario2 = new Usuario("Ana");
        usuario2.abrirDocumento(doc3);
        System.out.println(usuario2.getNombre() + " está editando: " + doc3.getTitulo());
        
        // Un impresor imprime un documento (USO)
        Impresor impresor = new Impresor();
        System.out.println("Imprimiendo documento...");
        impresor.imprimir(doc2, 2); // Relación temporal sin referencias persistentes
        
        // Simulamos que la carpeta Finanzas se elimina
        System.out.println("La carpeta Finanzas se elimina");
        carpetaFinanzas = null;
        
        // Los documentos siguen existiendo aunque la carpeta se haya eliminado (característica de agregación)
        System.out.println("El documento '" + doc1.getTitulo() + "' sigue existiendo");
        System.out.println("El documento '" + doc2.getTitulo() + "' sigue en la carpeta Planes:");
        carpetaPlanes.listarDocumentos();
    }
}

class Documento {
    private String titulo;
    private Contenido contenido; // COMPOSICIÓN - el contenido no existe sin el documento
    
    public Documento(String titulo) {
        this.titulo = titulo;
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
    
    // Cuando el documento se destruye, su contenido también se destruye (composición)
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
    private List<Documento> documentos; // AGREGACIÓN - los documentos existen independientemente
    
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
    
    // Si la carpeta se destruye, los documentos siguen existiendo (agregación)
}

class Usuario {
    private String nombre;
    private List<Documento> documentosAbiertos; // ASOCIACIÓN - relación duradera pero no de contenencia
    
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
    // USO - relación temporal sin almacenar referencias al objeto usado
    public void imprimir(Documento doc, int copias) {
        System.out.println("Imprimiendo " + copias + " copias del documento: " + doc.getTitulo());
        // La relación con el documento termina cuando el método termina
    }
}