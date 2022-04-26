class EduardoDavidEstradaRivera{
    public static void main(String[] args) {
        int dia = 1;
        while(dia <= 3 ) {

            int columnaEstropeada = 0;
            int plantaEstropeada = 0;

            for (int y = 1; y<=7; y++){ // Averia en una planta
                double probabilidadAveria = Math.random();

                if(probabilidadAveria >= 0.85 && plantaEstropeada == 0){
                    plantaEstropeada = y;
                }
            }

            for (int x = 1; x<=5; x++){ // Caida de un rayo
                double probabilidadRayo = Math.random();

                if(probabilidadRayo >= 0.75 && columnaEstropeada == 0){
                    columnaEstropeada = x;
                }
            }

            for(int h = 0; h < 24; h++){
                System.out.println("Hora " + h + " del dia " + dia);
                for(int i = 7; i>0; i--){
                    System.out.print(i);
                    for(int j = 1; j<=5; j++){
                        double probabilidadVentana = Math.random();
                        double probabilidadLuz = Math.random();
                        boolean ventanaAbierta = probabilidadVentana > 0.7 ? false: true;
                        boolean luzEncendida = probabilidadLuz > 0.6 ? false: true;
                        if(i == plantaEstropeada || j == columnaEstropeada){
                            System.out.print(" [x] ");
                        }
                        else if(ventanaAbierta){
                            if(luzEncendida){
                                System.out.print(" [O] ");
                            }
                            else{
                                System.out.print(" [.] ");
                            }
                        }
                        else{
                            System.out.print(" [#] ");
                        }
                    }
                    System.out.println(); 
                }
    
            }
            dia++;
        }
        
    }
}