package DOO.DD.DD02.v000mal;

import java.util.Random;
import java.util.Scanner;

public class Simulacion {
    private Mundo mundo;
    private Aspiradora aspiradora;
    private Gato gato;
    private Random random;
    private boolean modoAutomatico;
    private boolean modoInteligente;
    private int turno;
    
    public Simulacion(int filas, int columnas) {
        this.mundo = new Mundo(filas, columnas);
        this.random = new Random();
        this.modoAutomatico = true;
        this.modoInteligente = false;
        this.turno = 0;
    }
    
    public void inicializar() {
        mundo.generarObstaculos(5);
        
        mundo.generarSuciedad(30);
        
        int filaAspiradora, columnaAspiradora;
        do {
            filaAspiradora = random.nextInt(mundo.filas);
            columnaAspiradora = random.nextInt(mundo.columnas);
        } while (!mundo.posicionAccesible(filaAspiradora, columnaAspiradora));
        
        this.aspiradora = new Aspiradora(filaAspiradora, columnaAspiradora);
        
        this.gato = null;
    }
    
    public void ejecutarTurno() {
        turno++;
        System.out.println("Turno " + turno);
        
        if (aspiradora.getBateria() > 0 && aspiradora.getBasuraRecogida() < aspiradora.getCapacidadBolsa()) {
            if (modoAutomatico) {
                if (modoInteligente) {
                    Posicion posicionMasSucia = mundo.buscarPosicionMasSucia();
                    if (posicionMasSucia != null) {
                        aspiradora.moverHaciaObjetivo(mundo, posicionMasSucia);
                    } else {
                        aspiradora.moverAleatorio(mundo);
                    }
                } else {
                    aspiradora.moverAleatorio(mundo);
                }
            } else {
                System.out.println("Modo manual: usa WASD para mover la aspiradora.");
            }
        }
        
        if (gato == null) {
            if (random.nextInt(100) < 10) {
                int filaGato, columnaGato;
                do {
                    filaGato = random.nextInt(mundo.filas);
                    columnaGato = random.nextInt(mundo.columnas);
                } while (!mundo.posicionAccesible(filaGato, columnaGato));
                
                gato = new Gato(filaGato, columnaGato, 10);
                System.out.println("¡Un gato ha aparecido!");
            }
        } else {
            boolean gatoSigueEnMundo = gato.moverYEnsuciar(mundo);
            if (!gatoSigueEnMundo) {
                System.out.println("El gato ha desaparecido.");
                gato = null;
            }
        }
        
        mundo.imprimir(aspiradora, gato);
        
        mostrarEstadisticas();
    }
    
    public void mostrarEstadisticas() {
        System.out.println("Batería: " + aspiradora.getBateria() + "%");
        System.out.println("Bolsa de basura: " + aspiradora.getBasuraRecogida() + 
                           "/" + aspiradora.getCapacidadBolsa());
        System.out.println("Pasos dados: " + aspiradora.getPasos());
        System.out.println("Suciedad restante: " + mundo.calcularSuciedadTotal() + " unidades");
        System.out.println("Modo: " + (modoAutomatico ? 
                          (modoInteligente ? "Automático Inteligente" : "Automático Aleatorio") : 
                          "Manual"));
    }
    
    public void toggleModoAutomatico() {
        modoAutomatico = !modoAutomatico;
        System.out.println("Modo cambiado a: " + (modoAutomatico ? "Automático" : "Manual"));
    }
    
    public void toggleModoInteligente() {
        modoInteligente = !modoInteligente;
        System.out.println("Modo inteligente: " + (modoInteligente ? "Activado" : "Desactivado"));
    }
    
    public void moverAspiradoraManual(char direccion) {
        int nuevaFila = aspiradora.getPosicion().getFila();
        int nuevaColumna = aspiradora.getPosicion().getColumna();
        
        switch (direccion) {
            case 'w': nuevaFila--; break; // arriba
            case 'a': nuevaColumna--; break; // izquierda
            case 's': nuevaFila++; break; // abajo
            case 'd': nuevaColumna++; break; // derecha
        }
        
        if (mundo.posicionAccesible(nuevaFila, nuevaColumna)) {
            aspiradora.getPosicion().setFila(nuevaFila);
            aspiradora.getPosicion().setColumna(nuevaColumna);
            aspiradora.limpiar(mundo);
        } else {
            System.out.println("No se puede mover en esa dirección.");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Simulacion simulacion = new Simulacion(10, 20);
        simulacion.inicializar();
        
        System.out.println("Simulación de Aspiradora");
        System.out.println("------------------------");
        System.out.println("Comandos:");
        System.out.println("  ENTER: Ejecutar turno");
        System.out.println("  m: Cambiar modo (automático/manual)");
        System.out.println("  i: Cambiar modo inteligente (aleatorio/buscar suciedad)");
        System.out.println("  w/a/s/d: Mover aspiradora manualmente");
        System.out.println("  r: Recargar batería");
        System.out.println("  v: Vaciar bolsa");
        System.out.println("  q: Salir");
        System.out.println("------------------------");
        
        simulacion.mundo.imprimir(simulacion.aspiradora, simulacion.gato);
        simulacion.mostrarEstadisticas();
        
        boolean salir = false;
        while (!salir) {
            System.out.print("> ");
            String comando = scanner.nextLine().trim().toLowerCase();
            
            if (comando.isEmpty()) {
                simulacion.ejecutarTurno();
            } else {
                char c = comando.charAt(0);
                switch (c) {
                    case 'q':
                        salir = true;
                        break;
                    case 'm':
                        simulacion.toggleModoAutomatico();
                        break;
                    case 'i':
                        simulacion.toggleModoInteligente();
                        break;
                    case 'r':
                        simulacion.aspiradora.cargarBateria();
                        break;
                    case 'v':
                        simulacion.aspiradora.vaciarBolsa();
                        break;
                    case 'w':
                    case 'a':
                    case 's':
                    case 'd':
                        if (!simulacion.modoAutomatico) {
                            simulacion.moverAspiradoraManual(c);
                            simulacion.mundo.imprimir(simulacion.aspiradora, simulacion.gato);
                            simulacion.mostrarEstadisticas();
                        } else {
                            System.out.println("Debes cambiar a modo manual primero (m).");
                        }
                        break;
                    default:
                        System.out.println("Comando no reconocido.");
                }
            }
            
            if (simulacion.mundo.calcularSuciedadTotal() == 0) {
                System.out.println("¡Enhorabuena! Se ha limpiado toda la suciedad.");
                System.out.println("Pasos totales: " + simulacion.aspiradora.getPasos());
                simulacion.mundo.imprimir(simulacion.aspiradora, simulacion.gato);
                salir = true;
            }
            
            if (simulacion.aspiradora.getBateria() <= 0) {
                System.out.println("¡La aspiradora se ha quedado sin batería!");
                System.out.println("Pulsa 'r' para recargarla o 'q' para salir.");
            }
            
            if (simulacion.aspiradora.getBasuraRecogida() >= simulacion.aspiradora.getCapacidadBolsa()) {
                System.out.println("¡La bolsa de la aspiradora está llena!");
                System.out.println("Pulsa 'v' para vaciarla o 'q' para salir.");
            }
        }
        
        System.out.println("Fin de la simulación.");
        scanner.close();
    }
}