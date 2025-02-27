public class EjemploAsociacion {
    public static void main(String[] args) {
        // Creamos un disco SSD independiente
        DiscoSSD disco = new DiscoSSD(512);
        System.out.println("Disco SSD creado con " + disco.getCapacidadGB() + " GB de capacidad");
        
        // Creamos un ordenador que usa ese disco específico
        Ordenador ordenador = new Ordenador(disco);
        System.out.println("Ordenador creado con un disco de " + ordenador.getCapacidadDiscoGB() + " GB");
        
        // Ambos objetos tienen ciclos de vida independientes pero mantienen
        // una relación duradera (el ordenador referencia al disco)
        System.out.println("Usando el ordenador para almacenar datos:");
        ordenador.almacenarDatos("documento.txt");
        
        // Si cambiamos algo en el disco, afecta al ordenador porque
        // mantienen una relación de asociación
        System.out.println("Actualizando firmware del disco...");
        disco.actualizarFirmware();
        System.out.println("El ordenador ahora usa el disco con firmware actualizado");
        
        // Podríamos usar el mismo disco en otro ordenador
        Ordenador ordenador2 = new Ordenador(disco);
        System.out.println("Otro ordenador creado con el mismo disco");
        System.out.println("Este segundo ordenador también tiene acceso a un disco de " + 
                          ordenador2.getCapacidadDiscoGB() + " GB");
    }
}

class Ordenador {
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