public class EjemploAsociacion {
    public static void main(String[] args) {
        // ASOCIACIÓN: Relación duradera entre objetos independientes
        
        // Los objetos asociados existen de forma independiente
        DiscoSSD disco = new DiscoSSD(512);
        System.out.println("Disco SSD creado con " + disco.getCapacidadGB() + " GB de capacidad");
        
        // Se establece una asociación duradera entre ordenador y disco
        Ordenador ordenador = new Ordenador(disco);
        System.out.println("Ordenador creado con un disco de " + ordenador.getCapacidadDiscoGB() + " GB");
        
        // La asociación permite a un objeto utilizar funcionalidades del otro
        System.out.println("Usando el ordenador para almacenar datos:");
        ordenador.almacenarDatos("documento.txt");
        
        // Los cambios en un objeto asociado afectan a la relación
        System.out.println("Actualizando firmware del disco...");
        disco.actualizarFirmware();
        System.out.println("El ordenador ahora usa el disco con firmware actualizado");
        
        // En asociación, un objeto servidor puede asociarse con múltiples clientes
        Ordenador ordenador2 = new Ordenador(disco);
        System.out.println("Otro ordenador creado con el mismo disco");
        System.out.println("Este segundo ordenador también tiene acceso a un disco de " + 
                          ordenador2.getCapacidadDiscoGB() + " GB");
    }
}

class Ordenador {
    // ASOCIACIÓN: referencia duradera a un objeto independiente
    private DiscoSSD disco;
    
    // En la asociación, el objeto cliente (Ordenador) mantiene una referencia
    // al objeto servidor (DiscoSSD) pero no controla su ciclo de vida
    public Ordenador(DiscoSSD disco) {
        this.disco = disco;
    }
    
    public int getCapacidadDiscoGB() {
        return disco.getCapacidadGB();
    }
    
    public void almacenarDatos(String archivo) {
        System.out.println("Almacenando " + archivo + " en el disco SSD...");
        disco.escribirDatos(archivo);
    }
    
    // Si el Ordenador se destruye, el disco SSD sigue existiendo
    // (a diferencia de la composición)
}

class DiscoSSD {
    private int capacidadGB;
    private String versionFirmware;
    
    public DiscoSSD(int capacidadGB) {
        this.capacidadGB = capacidadGB;
        this.versionFirmware = "1.0";
    }
    
    public int getCapacidadGB() {
        return capacidadGB;
    }
    
    public void escribirDatos(String datos) {
        System.out.println("Escribiendo datos en el disco SSD: " + datos);
    }
    
    public void actualizarFirmware() {
        this.versionFirmware = "2.0";
        System.out.println("Firmware actualizado a la versión " + versionFirmware);
    }
}