# *#2Think*

Este ejercicio presenta un sistema de gestión de documentos que debe manejar diferentes estrategias de almacenamiento.

## Con herencia

```java

public class App {
    public static void main(String[] args) {

        Documento documentoLocal = new Documento("Informe", "Contenido del informe");
        documentoLocal.guardar();
        
        DocumentoEnNube documentoEnNube = new DocumentoEnNube("Presupuesto", "Detalles del presupuesto", "https://cloud.example.com");
        documentoEnNube.guardar();
    }
}

class Documento {
    private String titulo;
    private String contenido;
    
    public Documento(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }
    
    public void guardar() {
        System.out.println("Guardando documento: " + titulo);
        (...)
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getContenido() {
        return contenido;
    }
}

class DocumentoEnNube extends Documento {
    private String urlAlmacenamiento;
    
    public DocumentoEnNube(String titulo, String contenido, String urlAlmacenamiento) {
        super(titulo, contenido);
        this.urlAlmacenamiento = urlAlmacenamiento;
    }
    
    @Override
    public void guardar() {
        System.out.println("Guardando documento en la nube: " + getTitulo());
        System.out.println("URL: " + urlAlmacenamiento);
        (...)
    }
}
```

## Justificación del cambio

Aunque este código funciona, presenta varios problemas:

- Si cambiamos la implementación de `Documento`, afectará automáticamente a `DocumentoEnNube`.
- Si `Documento` añade nuevos métodos que asumen almacenamiento local, `DocumentoEnNube` podría romper ese contrato.
- ¿Qué sucede si queremos un documento que se guarde tanto localmente como en la nube? La herencia nos limita a una sola clase padre.
- La herencia nos obliga a sobrescribir el método `guardar()`, cuando realmente lo que cambia es la estrategia de almacenamiento, no el concepto de documento.
- La estrategia de almacenamiento queda fijada en tiempo de compilación y no puede cambiarse dinámicamente.

## Propuesta de cambio

Convirtamos esta jerarquía de herencia en una composición:

- Extraemos la lógica de almacenamiento a una interfaz.
- Implementamos diferentes estrategias de almacenamiento.
- El documento contendrá ***una referencia*** a la estrategia de almacenamiento.
- Esto le permitirá cambiar dinámicamente el cómo se guarda un documento.

## Con composición

```java
interface EstrategiaAlmacenamiento {
    void guardar(String titulo, String contenido);
}

class AlmacenamientoLocal implements EstrategiaAlmacenamiento {
    @Override
    public void guardar(String titulo, String contenido) {
        System.out.println("Guardando documento localmente: " + titulo);
        (...)
    }
}

class AlmacenamientoNube implements EstrategiaAlmacenamiento {
    private String urlAlmacenamiento;
    
    public AlmacenamientoNube(String urlAlmacenamiento) {
        this.urlAlmacenamiento = urlAlmacenamiento;
    }
    
    @Override
    public void guardar(String titulo, String contenido) {
        System.out.println("Guardando documento en la nube: " + titulo);
        System.out.println("URL: " + urlAlmacenamiento);
        (...)
    }
}

class Documento {
    private String titulo;
    private String contenido;
    private EstrategiaAlmacenamiento estrategia;
    
    public Documento(String titulo, String contenido, EstrategiaAlmacenamiento estrategia) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.estrategia = estrategia;
    }
    
    public void guardar() {
        estrategia.guardar(titulo, contenido);
    }
    
    public void cambiarEstrategia(EstrategiaAlmacenamiento nuevaEstrategia) {
        this.estrategia = nuevaEstrategia;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getContenido() {
        return contenido;
    }
}

public class App {
    public static void main(String[] args) {
        
        Documento documento1 = new Documento("Informe", "Contenido del informe", new AlmacenamientoLocal());
        documento1.guardar();
        
        Documento documento2 = new Documento("Presupuesto", "Detalles del presupuesto", new AlmacenamientoNube("https://cloud.example.com"));
        documento2.guardar();
        
        System.out.println("Cambiando estrategia de almacenamiento...");
        documento1.cambiarEstrategia(new AlmacenamientoNube("https://backup.example.com"));
        documento1.guardar();        
    }
}
```

Con este enfoque basado en composición:

- La clase `Documento` no depende de implementaciones concretas de almacenamiento.
- La estrategia de almacenamiento puede cambiarse en tiempo de ejecución.
- Podemos crear nuevas estrategias de almacenamiento sin modificar la clase `Documento`.
- `Documento` gestiona los datos del documento, mientras que las estrategias gestionan cómo se almacenan.
- Podríamos implementar fácilmente una estrategia de almacenamiento híbrida que guardara tanto local como en la nube.

Esta solución representa un uso de composición donde "un documento tiene una estrategia de almacenamiento" en lugar de "un documento en nube es un documento".

## Comparación

<div align=center>

|![](/images/modelosUML/ejemploHerenciaComposicionHERENCIA.svg)|![](/images/modelosUML/ejemploHerenciaComposicionCOMPOSICION.svg)
|-|-|

</div>