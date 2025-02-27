public class EjemploUso {
    public static void main(String[] args) {
        // Creamos un alumno y un autobús independientemente
        Alumno alumno = new Alumno("Ana");
        Autobus autobus = new Autobus("Línea 42");
        
        System.out.println(alumno.getNombre() + " necesita ir a la universidad");
        
        // La relación de uso es temporal - solo durante el método viaje()
        alumno.viaje(autobus);
        
        // Después del viaje, no hay relación persistente entre el alumno y el autobús
        System.out.println("Después del viaje, " + alumno.getNombre() + 
                          " continúa con sus actividades independientemente del autobús");
        alumno.estudiar();
        
        // El autobús sigue su ruta habitual sin relación con el alumno específico
        System.out.println("El " + autobus.getLinea() + " continúa su ruta normal");
        autobus.continuarRuta();
        
        // Otro día, el mismo alumno puede usar un autobús diferente
        Autobus otroAutobus = new Autobus("Línea 15");
        System.out.println("Al día siguiente, " + alumno.getNombre() + " toma otro autobús");
        alumno.viaje(otroAutobus);
    }
}

class Alumno {
    private String nombre;
    
    public Alumno(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    // En la relación de uso, el cliente (Alumno) utiliza temporalmente 
    // los servicios del servidor (Autobus) sin mantener una referencia permanente
    public void viaje(Autobus autobus) {
        System.out.println(nombre + " va a usar el " + autobus.getLinea() + ":");
        autobus.subir();
        autobus.pagarBoleto();
        System.out.println(nombre + " viaja durante 20 minutos...");
        autobus.bajar();
        
        // No hay atributo que almacene el autobús - la relación termina al finalizar el método
    }
    
    public void estudiar() {
        System.out.println(nombre + " asiste a clases y estudia en la biblioteca");
    }
}

class Autobus {
    private String linea;
    
    public Autobus(String linea) {
        this.linea = linea;
    }
    
    public String getLinea() {
        return linea;
    }
    
    public void subir() {
        System.out.println("- Subiendo al autobús " + linea);
    }
    
    public void pagarBoleto() {
        System.out.println("- Pagando boleto");
    }
    
    public void bajar() {
        System.out.println("- Bajando del autobús");
    }
    
    public void continuarRuta() {
        System.out.println("El autobús " + linea + " sigue su recorrido habitual");
    }
}