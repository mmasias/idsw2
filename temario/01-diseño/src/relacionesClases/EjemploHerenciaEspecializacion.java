public class EjemploHerenciaEspecializacion {
    public static void main(String[] args) {
        // Creamos diferentes figuras
        Coordenada centro1 = new Coordenada(0, 0);
        Circulo circulo = new Circulo(centro1, 5);
        
        Coordenada centro2 = new Coordenada(10, 10);
        Rectangulo rectangulo = new Rectangulo(centro2, 4, 6);
        
        // Demostramos polimorfismo usando la clase base Figura
        Figura[] figuras = {circulo, rectangulo};
        
        System.out.println("Información de las figuras:");
        for (Figura figura : figuras) {
            System.out.println("\nTipo de figura: " + figura.getClass().getSimpleName());
            System.out.println("Centro: (" + figura.getCentro().getX() + 
                              ", " + figura.getCentro().getY() + ")");
            System.out.println("Área: " + figura.getArea());
            System.out.println("Perímetro: " + figura.getPerimetro());
        }
        
        // Movemos las figuras y mostramos los nuevos valores
        System.out.println("\nMoviendo las figuras...");
        for (Figura figura : figuras) {
            figura.mover(5, 5);
            System.out.println("\n" + figura.getClass().getSimpleName() + 
                              " - Nuevo centro: (" + figura.getCentro().getX() + 
                              ", " + figura.getCentro().getY() + ")");
        }
        
        // También podemos acceder a métodos específicos de cada subclase
        System.out.println("\nAccediendo a métodos específicos:");
        System.out.println("Radio del círculo: " + circulo.getRadio());
        System.out.println("Ancho del rectángulo: " + rectangulo.getAncho());
        System.out.println("Alto del rectángulo: " + rectangulo.getAlto());
    }
}

class Coordenada {
    private float x;
    private float y;
    
    public Coordenada(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public float getX() {
        return x;
    }
    
    public void setX(float x) {
        this.x = x;
    }
    
    public float getY() {
        return y;
    }
    
    public void setY(float y) {
        this.y = y;
    }
}

abstract class Figura {
    protected Coordenada centro;
    
    public Figura(Coordenada centro) {
        this.centro = centro;
    }
    
    public void mover(float x, float y) {
        centro.setX(centro.getX() + x);
        centro.setY(centro.getY() + y);
    }
    
    public Coordenada getCentro() {
        return centro;
    }
    
    public abstract float getPerimetro();
    
    public abstract float getArea();
}

class Circulo extends Figura {
    private float radio;
    
    public Circulo(Coordenada centro, float radio) {
        super(centro);
        this.radio = radio;
    }
    
    public float getRadio() {
        return radio;
    }
    
    @Override
    public float getPerimetro() {
        return 2 * (float)Math.PI * radio;
    }
    
    @Override
    public float getArea() {
        return (float)Math.PI * radio * radio;
    }
}

class Rectangulo extends Figura {
    private float ancho;
    private float alto;
    
    public Rectangulo(Coordenada centro, float ancho, float alto) {
        super(centro);
        this.ancho = ancho;
        this.alto = alto;
    }
    
    public float getAncho() {
        return ancho;
    }
    
    public float getAlto() {
        return alto;
    }
    
    @Override
    public float getPerimetro() {
        return 2 * (ancho + alto);
    }
    
    @Override
    public float getArea() {
        return ancho * alto;
    }
}