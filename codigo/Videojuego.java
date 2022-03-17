import java.util.Scanner;
public class Videojuego{
    public static void main(String[] args){
        boolean puerta = false;
        String rumbo = "";
        int letreroFila = 10;
        int letreroColumna = 12;
        int salidaFila = 34;
        int salidaColumna = 25;
        int opcionFila = 0;
        int llaveFila = 34;
        int llaveColumna = 0;
        int gemaFila = 0;
        int gemaColumna = 17;
        int npc1 = 0;
        int posNpcFila = 11;
        int posNpcColumna = 12;
        int npc2 = 0;
        int posNpc2Fila = 28;
        int posNpc2Columna = 22;
        int npc3 = 0;
        int posNpc3Fila = 32;
        int posNpc3Columna = 18;
        int npc4 = 0;
        int posNpc4Fila = 23;
        int posNpc4Columna = 6;
        int posFila = 0;
        int posColumna = 0;
        int rangoAntorcha = 4;
        boolean error = false;
        String entrada = "";
        String [] movimiento = {"w","s","a","d","f"};
        String salir = "";
        String juego = "";
        Scanner opcion = new Scanner(System.in);
        Scanner config = new Scanner(System.in);

        int inicio[][] = {
            {0,1},
            {0,2},
            {0,3},
            {0,4}
        };

        int [][] mundo = {
            {0,0,3,3,3,3,3,5,5,0,0,5,5,5,5,5,5,0,1,3,3,3,3,3,3,3},
            {3,0,4,4,4,3,3,3,3,4,0,4,4,4,5,5,5,0,1,3,4,0,0,0,5,3},
            {3,3,3,0,0,3,0,0,0,0,0,5,5,4,5,5,5,0,1,1,0,3,3,3,3,3},
            {4,3,3,3,0,3,3,3,3,4,0,5,5,4,4,4,5,0,0,0,0,0,0,0,5,4},
            {4,0,0,0,0,3,3,3,3,0,0,5,5,4,5,5,5,3,3,3,3,3,3,0,3,4},
            {3,3,3,3,0,4,4,4,4,0,3,5,5,4,4,5,5,0,3,4,4,3,3,0,3,4},
            {0,4,4,3,0,0,0,0,0,3,5,5,5,5,4,5,5,0,0,0,0,3,3,0,3,4},
            {0,4,4,3,0,3,3,3,3,3,5,5,5,5,4,5,5,3,3,3,3,3,3,0,0,4},
            {0,0,0,3,0,3,3,1,5,5,5,5,5,5,5,5,5,1,3,0,0,0,0,0,5,3},
            {5,4,0,0,2,3,3,1,1,1,1,1,1,1,1,1,1,1,3,4,4,3,4,0,3,3},
            {5,4,5,3,0,0,0,0,4,4,4,4,4,1,4,4,4,4,4,3,3,3,3,0,5,3},
            {5,4,5,3,0,0,4,0,0,0,0,0,0,6,0,0,0,0,0,3,3,3,3,0,5,0},
            {0,4,3,3,0,0,4,0,4,4,4,4,4,1,4,4,4,4,4,0,0,0,0,4,4,0},
            {0,3,3,3,0,4,4,1,1,1,1,1,1,1,1,1,1,1,3,4,0,3,3,3,4,0},
            {3,4,4,0,0,4,0,1,5,5,5,5,5,5,4,5,5,1,3,3,0,3,3,4,4,0},
            {3,4,4,3,0,3,0,5,5,5,5,5,4,4,4,4,4,3,3,3,4,0,3,0,0,0},
            {3,4,0,3,0,3,0,3,3,3,3,4,4,5,5,5,4,0,3,3,3,0,3,0,3,0},
            {3,4,0,3,0,3,0,0,0,3,4,4,5,5,4,5,4,0,3,3,3,0,3,3,0,0},
            {3,4,4,3,0,3,3,3,3,3,5,5,5,5,4,5,5,0,0,0,3,0,3,3,0,0},
            {3,4,0,3,0,0,0,0,3,5,5,4,4,4,4,4,5,3,0,0,0,0,3,3,3,0},
            {3,4,0,3,3,0,3,0,3,4,4,4,5,5,4,4,4,4,3,0,0,3,3,3,4,2},
            {3,4,0,0,3,3,3,0,3,4,5,5,5,5,4,5,4,4,3,3,3,3,3,4,0,0},
            {3,3,3,0,3,3,3,3,0,0,4,5,5,5,4,5,5,4,0,0,3,3,3,3,3,0},
            {3,3,3,0,3,4,4,3,3,0,0,5,5,5,5,5,0,3,4,0,0,4,5,0,0,0},
            {3,3,0,0,0,4,4,4,3,0,0,0,0,0,0,0,0,3,3,0,0,0,5,5,3,0},
            {0,0,0,3,4,4,4,4,3,0,3,0,3,0,3,3,0,3,3,3,0,3,4,0,0,0},
            {0,5,5,3,4,4,4,4,3,0,3,0,3,0,0,3,0,3,3,3,0,3,4,4,5,3},
            {0,5,3,3,0,0,3,3,3,0,3,3,3,3,3,0,0,4,3,3,0,0,4,4,5,3},
            {0,0,5,0,0,3,3,3,3,0,0,3,3,0,3,3,0,0,4,4,3,3,4,5,5,3},
            {3,0,0,0,0,0,0,0,3,0,0,3,3,0,3,0,0,3,3,4,4,3,3,3,3,3},
            {0,0,0,3,3,3,3,3,0,0,0,0,3,0,0,0,0,5,3,3,3,3,3,3,3,3},
            {3,0,3,3,3,3,3,0,0,3,0,3,0,5,5,5,5,5,5,0,0,3,0,2,0,3},
            {3,4,0,0,0,3,3,0,3,0,0,3,3,0,5,0,0,0,0,0,0,0,0,3,0,3},
            {3,4,3,3,4,4,3,0,3,0,0,3,0,0,0,0,0,0,3,3,0,0,0,3,0,3},
            {4,4,3,4,4,4,3,0,0,3,0,0,0,0,0,0,3,3,3,3,3,3,3,3,0,0}
        };
        
        // Ciclo del juego--------------------
        while(salir != movimiento[4]){
            limpiar();
            juego = " ";
            for(int i = 0;i<mundo.length/2-5;i++){mostrar("");}//Relleno en la parte superior de la pantalla en base al tama#o de la matriz---------
            mostrar("                  0000000     000      000 000   0000000    ");
            mostrar("                  0          00 00    00  0  00  00____     ");
            mostrar("                  0   000   00---00   00  0  00  00         ");
            mostrar("                  0000000  00     00  00  0  00  0000000  v.0.3");
            mostrar("");
            mostrar("");
            // Relleno de la pantalla principal-----------------------------
            for(int fila= 0; fila<inicio.length; fila++){
                _mostrar("                              ");
                for(int columna = 0; columna<inicio[0].length; columna++){
                    if((fila == opcionFila) && (columna == 0)) {
                        _mostrar("==>");
                    } 
                    else{
                        if (inicio[fila][columna]==0) 	{_mostrar("   ");}
                        else if (inicio[fila][columna]==1) 	{_mostrar("  JUGAR   ");}
                        else if (inicio[fila][columna]==2) 	{_mostrar("CONTROLES ");}
                        else if (inicio[fila][columna]==3) 	{_mostrar("  AYUDA   ");}
                        else if (inicio[fila][columna]==4) 	{_mostrar("  SALIR   ");}
                        else if (inicio[fila][columna]==5)  {_mostrar(" RESUMIR  ");}
                    }
                } 
                 mostrar("                         ");
            }
            for(int i = 0;i<mundo.length/2-3;i++){mostrar("");}//Relleno en la parte inferior de la pantalla en base al tama#o de la matriz---------------
            mostrar("================================================================================");
            mostrar("  Comandos : | "+movimiento[0]+" | "+movimiento[1]+" | ingrese \"ok\" para seleccionar ");
            _mostrar("  -> ");
            entrada = opcion.nextLine();
            mostrar("================================================================================");

            // Seccion de seleccion en el menu principal----------------------
            if(entrada.equals("ok")){
                limpiar();

                // Opcion de Jugar en el menu principal-------------------------------
                if(opcionFila == 0){
                    inicio[0][1] = 5; // RESUMIR

                    // Ciclo repetitivo del juego--------------------------------
                    while(juego != movimiento[4]){
                        limpiar();
                        mostrar("====================================Gedienca====================================");
                        error = true;

                        // Relleno del mapa en base a una matris nxn-----------------------
                        for(int fila= 0; fila<mundo.length; fila++){
                            _mostrar("|");
                            for(int columna = 0; columna<mundo[0].length; columna++){
                                if(((fila < posFila+rangoAntorcha) && (fila > posFila-rangoAntorcha)) && ((columna < posColumna+rangoAntorcha) && (columna > posColumna-rangoAntorcha))){
                                    if(((fila == posNpcFila) && (columna == posNpcColumna))||((fila == posNpc2Fila) && (columna == posNpc2Columna))||((fila == posNpc3Fila) && (columna == posNpc3Columna))||((fila == posNpc4Fila) && (columna == posNpc4Columna))){
                                    _mostrar("w+w");
                                    }
                                    else if((fila == posFila) && (columna == posColumna)) {
                                        _mostrar("_0_");
                                    } 
                                    else if((fila == gemaFila) && (columna == gemaColumna)){
                                        _mostrar(" @ ");
                                    }
                                    else if((fila == llaveFila) && (columna == llaveColumna)){
                                        _mostrar("=O ");
                                    }
                                    else if((fila == salidaFila) && (columna == salidaColumna)){
                                        _mostrar("{@}");
                                    }
                                    else if((fila == letreroFila) && (columna == letreroColumna)){
                                        _mostrar(" T ");
                                    }
                                    else{
                                        if 		(mundo[fila][columna]==0) 	{_mostrar(" . ");}
                                        else if (mundo[fila][columna]==1) 	{_mostrar("[#]");}
                                        else if (mundo[fila][columna]==2) 	{_mostrar("[ ]");}
                                        else if (mundo[fila][columna]==3) 	{_mostrar("/^\\");}
                                        else if (mundo[fila][columna]==4) 	{_mostrar(".oO");}						
                                        else if (mundo[fila][columna]==5) 	{_mostrar("~~~");}
                                        else if (mundo[fila][columna]==6)   {_mostrar("[X]");}
                                    } 
                                }
                                else{
                                    _mostrar("   ");
                                }
                            }
                            mostrar("|");
                        }

                        mostrar("================================================================================");
                        mostrar("  Comandos : | "+movimiento[0]+" | "+movimiento[1]+" | "+movimiento[2]+" | "+movimiento[3]+" | "+movimiento[4]+" | "+rumbo);
                        _mostrar("  -> ");
                        entrada = opcion.nextLine();

                        // Seccion de desplazamiento del personaje------------------------------
                        for(int i = 0; i<movimiento.length;i++){
                            if(entrada.equals(movimiento[i])){

                                if(entrada.equals(movimiento[0]) && (posFila != 0) && ((mundo[posFila-1][posColumna]==0)||(mundo[posFila-1][posColumna]==2)||(mundo[posFila-1][posColumna]==4)) && ((((posFila-1)*10)+posColumna) != ((posNpcFila*10)+posNpcColumna))){
                                    posFila = posFila - 1;
                                    rumbo = "Caminando hacia el NORTE";
                                }
                                else if(entrada.equals(movimiento[1]) && (posFila != mundo.length - 1) && ((mundo[posFila+1][posColumna]==0)||(mundo[posFila+1][posColumna]==2)||(mundo[posFila+1][posColumna]==4)) && ((((posFila+1)*10)+posColumna) != ((posNpcFila*10)+posNpcColumna))){
                                    posFila = posFila + 1;
                                    rumbo = "Caminando hacia el SUR";
                                }
                                else if(entrada.equals(movimiento[2]) && (posColumna != 0) && ((mundo[posFila][posColumna-1]==0)||(mundo[posFila][posColumna-1]==2)||(mundo[posFila][posColumna-1]==4)) && ((((posFila)*10)+posColumna-1) != ((posNpcFila*10)+posNpcColumna))){
                                    posColumna = posColumna - 1;
                                    rumbo = "Caminando hacia el OESTE";
                                }
                                else if(entrada.equals(movimiento[3]) && (posColumna != mundo[0].length - 1) && ((mundo[posFila][posColumna+1]==0)||(mundo[posFila][posColumna+1]==2)||(mundo[posFila][posColumna+1]==4)) && ((((posFila)*10)+posColumna+1) != ((posNpcFila*10)+posNpcColumna))){
                                    posColumna = posColumna + 1;
                                    rumbo = "Caminando hacia el ESTE";
                                }
                                else if(entrada.equals(movimiento[4])){
                                    juego = movimiento[4];
                                    limpiar();
                                }
                                error = false;
                            }
                        }
                        if(error == true){
                            mostrar("");
                        }

                        // Acciones aleatorias de los NPC's------------------------------
                        npc1 = (int)(Math.random() * 5);
                        npc2 = (int)(Math.random() * 5);
                        npc3 = (int)(Math.random() * 5);
                        npc4 = (int)(Math.random() * 5);

                        // Movimientos del NPC 1 ---------------------------------
                        if((npc1 == 1) && (posNpcFila != 0) && ((mundo[posNpcFila-1][posNpcColumna]==0)||(mundo[posNpcFila-1][posNpcColumna]==2)||(mundo[posNpcFila-1][posNpcColumna]==4)) && ((((posNpcFila-1)*10)+posNpcColumna) != ((posFila*10)+posColumna))){
                            posNpcFila = posNpcFila -1;
                        }
                        else if((npc1 == 2) && (posNpcFila != mundo.length - 1) && ((mundo[posNpcFila+1][posNpcColumna]==0)||(mundo[posNpcFila+1][posNpcColumna]==2)||(mundo[posNpcFila+1][posNpcColumna]==4)) && ((((posNpcFila+1)*10)+posNpcColumna) != ((posFila*10)+posColumna))){
                            posNpcFila = posNpcFila +1;
                        }
                        else if((npc1 == 3) && (posNpcColumna != 0) && ((mundo[posNpcFila][posNpcColumna-1]==0)||(mundo[posNpcFila][posNpcColumna-1]==2)||(mundo[posNpcFila][posNpcColumna-1]==4)) && ((((posNpcFila)*10)+posNpcColumna-1) != ((posFila*10)+posColumna))){
                            posNpcColumna = posNpcColumna -1;
                        }
                        else if((npc1 == 4) && (posNpcColumna != mundo[0].length - 1) && ((mundo[posNpcFila][posNpcColumna+1]==0)||(mundo[posNpcFila][posNpcColumna+1]==2)||(mundo[posNpcFila][posNpcColumna+1]==4)) && ((((posNpcFila)*10)+posNpcColumna+1) != ((posFila*10)+posColumna))){
                            posNpcColumna = posNpcColumna +1;
                        }

                        // Movimientos del NPC 2 ---------------------------------
                        if((npc2 == 1) && (posNpc2Fila != 0) && ((mundo[posNpc2Fila-1][posNpc2Columna]==0)||(mundo[posNpc2Fila-1][posNpc2Columna]==2)||(mundo[posNpc2Fila-1][posNpc2Columna]==4)) && ((((posNpc2Fila-1)*10)+posNpc2Columna) != ((posFila*10)+posColumna))){
                            posNpc2Fila = posNpc2Fila -1;
                        }
                        else if((npc2 == 2) && (posNpc2Fila != mundo.length - 1) && ((mundo[posNpc2Fila+1][posNpc2Columna]==0)||(mundo[posNpc2Fila+1][posNpc2Columna]==2)||(mundo[posNpc2Fila+1][posNpc2Columna]==4)) && ((((posNpc2Fila+1)*10)+posNpc2Columna) != ((posFila*10)+posColumna))){
                            posNpc2Fila = posNpc2Fila +1;
                        }
                        else if((npc2 == 3) && (posNpc2Columna != 0) && ((mundo[posNpc2Fila][posNpc2Columna-1]==0)||(mundo[posNpc2Fila][posNpc2Columna-1]==2)||(mundo[posNpc2Fila][posNpc2Columna-1]==4)) && ((((posNpc2Fila)*10)+posNpc2Columna-1) != ((posFila*10)+posColumna))){
                            posNpc2Columna = posNpc2Columna -1;
                        }
                        else if((npc2 == 4) && (posNpc2Columna != mundo[0].length - 1) && ((mundo[posNpc2Fila][posNpc2Columna+1]==0)||(mundo[posNpc2Fila][posNpc2Columna+1]==2)||(mundo[posNpc2Fila][posNpc2Columna+1]==4)) && ((((posNpc2Fila)*10)+posNpc2Columna+1) != ((posFila*10)+posColumna))){
                            posNpc2Columna = posNpc2Columna +1;
                        }

                        // Movimientos del NPC 3 ---------------------------------
                        if((npc3 == 1) && (posNpc3Fila != 0) && ((mundo[posNpc3Fila-1][posNpc3Columna]==0)||(mundo[posNpc3Fila-1][posNpc3Columna]==2)||(mundo[posNpc3Fila-1][posNpc3Columna]==4)) && ((((posNpc3Fila-1)*10)+posNpc3Columna) != ((posFila*10)+posColumna))){
                            posNpc3Fila = posNpc3Fila -1;
                        }
                        else if((npc3 == 2) && (posNpc3Fila != mundo.length - 1) && ((mundo[posNpc3Fila+1][posNpc3Columna]==0)||(mundo[posNpc3Fila+1][posNpc3Columna]==2)||(mundo[posNpc3Fila+1][posNpc3Columna]==4)) && ((((posNpc3Fila+1)*10)+posNpc3Columna) != ((posFila*10)+posColumna))){
                            posNpc3Fila = posNpc3Fila +1;
                        }
                        else if((npc3 == 3) && (posNpc3Columna != 0) && ((mundo[posNpc3Fila][posNpc3Columna-1]==0)||(mundo[posNpc3Fila][posNpc3Columna-1]==2)||(mundo[posNpc3Fila][posNpc3Columna-1]==4)) && ((((posNpc3Fila)*10)+posNpc3Columna-1) != ((posFila*10)+posColumna))){
                            posNpc3Columna = posNpc3Columna -1;
                        }
                        else if((npc3 == 4) && (posNpc3Columna != mundo[0].length - 1) && ((mundo[posNpc3Fila][posNpc3Columna+1]==0)||(mundo[posNpc3Fila][posNpc3Columna+1]==2)||(mundo[posNpc3Fila][posNpc3Columna+1]==4)) && ((((posNpc3Fila)*10)+posNpc3Columna+1) != ((posFila*10)+posColumna))){
                            posNpc3Columna = posNpc3Columna +1;
                        }

                        // Movimientos del NPC 4 ---------------------------------
                        if((npc4 == 1) && (posNpc4Fila != 0) && ((mundo[posNpc4Fila-1][posNpc4Columna]==0)||(mundo[posNpc4Fila-1][posNpc4Columna]==2)||(mundo[posNpc4Fila-1][posNpc4Columna]==4)) && ((((posNpc4Fila-1)*10)+posNpc4Columna) != ((posFila*10)+posColumna))){
                            posNpc4Fila = posNpc4Fila -1;
                        }
                        else if((npc4 == 2) && (posNpc4Fila != mundo.length - 1) && ((mundo[posNpc4Fila+1][posNpc4Columna]==0)||(mundo[posNpc4Fila+1][posNpc4Columna]==2)||(mundo[posNpc4Fila+1][posNpc4Columna]==4)) && ((((posNpc4Fila+1)*10)+posNpc4Columna) != ((posFila*10)+posColumna))){
                            posNpc4Fila = posNpc4Fila +1;
                        }
                        else if((npc4 == 3) && (posNpc4Columna != 0) && ((mundo[posNpc4Fila][posNpc4Columna-1]==0)||(mundo[posNpc4Fila][posNpc4Columna-1]==2)||(mundo[posNpc4Fila][posNpc4Columna-1]==4)) && ((((posNpc4Fila)*10)+posNpc4Columna-1) != ((posFila*10)+posColumna))){
                            posNpc4Columna = posNpc4Columna -1;
                        }
                        else if((npc4 == 4) && (posNpc4Columna != mundo[0].length - 1) && ((mundo[posNpc4Fila][posNpc4Columna+1]==0)||(mundo[posNpc4Fila][posNpc4Columna+1]==2)||(mundo[posNpc4Fila][posNpc4Columna+1]==4)) && ((((posNpc4Fila)*10)+posNpc4Columna+1) != ((posFila*10)+posColumna))){
                            posNpc4Columna = posNpc4Columna +1;
                        }

                        // Incremento del rango de vista al estar sobre la gema y descripcion------------------
                        if((((posFila)*10)+posColumna) == ((gemaFila*10)+gemaColumna)){
                            rangoAntorcha = 100;
                            rumbo = "Puedes verlo todo con LA GEMA!";
                        }
                        else{rangoAntorcha = 400;}

                        // Seccion de accion con la llave y muestra de descripcion------------------
                        if((((posFila)*10)+posColumna) == ((llaveFila*10)+llaveColumna)){
                            llaveFila = 100;
                            llaveColumna = 100;
                            for(int fila= 0; fila<mundo.length; fila++){
                                for(int columna = 0; columna<mundo[0].length; columna++){
                                    if(mundo[fila][columna] == 6){
                                        mundo[fila][columna] = 2;
                                    }
                                }
                            }
                            rumbo = "LLAVE ENCONTRADA!!";
                            puerta = true;
                        }

                        // Seccion de punto de llegada y reinicio del juego------------------------
                        if((((posFila)*10)+posColumna) == ((salidaFila*10)+salidaColumna)){
                            limpiar();
                            juego = movimiento[4];
                            inicio[0][1] = 1;
                            puerta = false;
                            mundo[11][13] = 6;
                            posFila = 0;
                            posColumna = 0;
                            llaveFila = 34;
                            llaveColumna = 0;
                            posNpcFila = 11;
                            posNpcColumna = 12;
                            posNpc2Fila = 28;
                            posNpc2Columna = 22;
                            posNpc3Fila = 32;
                            posNpc3Columna = 18;
                            posNpc4Fila = 23;
                            posNpc4Columna = 6;
                            for(int i = 0;i<mundo.length/2-1;i++){mostrar("");}
                            mostrar("                        oooooooo ooooooo  ooo    oo");
                            mostrar("                        oo         oo     oo oo  oo");
                            mostrar("                        ooooo      oo     oo  oo oo");
                            mostrar("                        oo         oo     oo   oooo");
                            mostrar("                        oo       ooooooo  oo     oo");
                            mostrar("                                          ");
                            for(int i = 0;i<mundo.length/2-1;i++){mostrar("");}
                            entrada = opcion.nextLine();
                        }

                        // Seccion de mensaje del cartel en base al estado de la puerta--------------------
                        if((((posFila)*10)+posColumna) == ((letreroFila*10)+letreroColumna)){
                            if(puerta == false){
                                rumbo = "Una puerta cerrada, SE ABRE CON UNA LLAVE!";
                            }
                            else{                               
                                rumbo = "WOW encontraste la llave, BUEN TRABAJO!";
                            }
                        }
                    }
                }

                // Opcion de configuracion de controles------------------
                else if(opcionFila == 1){
                    mostrar("====================================Gedienca=====================================");
                    mostrar("  Ingrese la opcion que desee cambiar o presione \"enter\" para regresar");
                    mostrar("  (a) "+movimiento[0]+" (arriba)");
                    mostrar("  (b) "+movimiento[1]+" (abajo)");
                    mostrar("  (c) "+movimiento[2]+" (izquierda)");
                    mostrar("  (d) "+movimiento[3]+" (derecha)");
                    mostrar("  (e) "+movimiento[4]+" (salir)");
                    _mostrar("  -> ");
                    entrada = opcion.nextLine();
                    mostrar("=================================================================================");
                
                    if(entrada.equals("a")){
                        mostrar("  Ingrese la nueva letra");
                        _mostrar("  -> "); 
                        entrada = opcion.nextLine();
                        movimiento[0] = entrada;
                        mostrar("=================================================================================");
                        mostrar("  Cambiado Exitosamente!"); 
                        entrada = opcion.nextLine();
                    }
                    else if(entrada.equals("b")){
                        mostrar("  Ingrese la nueva letra");
                        _mostrar("  -> "); 
                        entrada = opcion.nextLine();
                        movimiento[1] = entrada;
                        mostrar("=================================================================================");
                        mostrar("  Cambiado Exitosamente!"); 
                        entrada = opcion.nextLine();
                    }
                    else if(entrada.equals("c")){
                        mostrar("  Ingrese la nueva letra");
                        _mostrar("  -> "); 
                        entrada = opcion.nextLine();
                        movimiento[2] = entrada;
                        mostrar("=================================================================================");
                        mostrar("  Cambiado Exitosamente!"); 
                        entrada = opcion.nextLine();
                    }
                    else if(entrada.equals("d")){
                        mostrar("  Ingrese la nueva letra");
                        _mostrar("  -> "); 
                        entrada = opcion.nextLine();
                        movimiento[3] = entrada;
                        mostrar("=================================================================================");
                        mostrar("  Cambiado Exitosamente!"); 
                        entrada = opcion.nextLine();
                    }
                    else if(entrada.equals("e")){
                        mostrar("  Ingrese la nueva letra");
                        _mostrar("  -> "); 
                        entrada = opcion.nextLine();
                        movimiento[4] = entrada;
                        mostrar("=================================================================================");
                        mostrar("  Cambiado Exitosamente!"); 
                        entrada = opcion.nextLine();
                    }
                    else{mostrar("");}
                }

                else if(opcionFila == 2){
                    mostrar("====================================Gedienca=====================================");
                    mostrar("  AREAS EN LAS QUE PUEDES AVANZAR");
                    mostrar("       _0_  =  Personaje que usas para desplazarte por el mapa.");
                    mostrar("        .   =  Representa el area donde el personaje se puede mover.");
                    mostrar("       .oO  =  Arbustos, puedes moverte sobre ellos.");
                    mostrar("       [ ]  =  Puerta abierta.");
                    mostrar("  AREAS EN LAS QUE NO PUEDES AVANZAR.");
                    mostrar("       ~~~  =  El personaje no puede moverse en el agua.");
                    mostrar("       /^\\  =  Las monta#nas son demasiado empinadas como para avanzar por ahi.");
                    mostrar("       [#]  =  Un muro es imposible de trepar.");
                    mostrar("       [X]  =  Una puerta cerrada, se puede abrir con una llave.");
                    mostrar("       w+w  =  NPC, es un enemigo que retrasa tu camino, te impide el paso.");
                    mostrar("  ITEMS DEL JUEGO");
                    mostrar("        @   =  Gema psiquica, te permite ver el mapa mientras estes sobre ella.");
                    mostrar("       =O   =  Llave de puerta, te permite abrir una puerta cerrada.");
                    mostrar("       T    =  Cartel, te da informacion que te puede ser util.");
                    mostrar("  CONTROLES DEL JUEGO E INTERFAZ DE JUEGO");
                    mostrar("        "+movimiento[0]+"   =  Te permite moverte hacia arriba.");
                    mostrar("        "+movimiento[1]+"   =  Te permite moverte hacia abajo.");
                    mostrar("        "+movimiento[2]+"   =  Te permite moverte hacia la izquierda.");
                    mostrar("        "+movimiento[3]+"   =  Te permite moverte hacia la derecha.");
                    mostrar("        "+movimiento[4]+"   =  Te permite regrasar al menu principal.");
                    mostrar("");
                    mostrar("  En la parte de abajo se muestra una breve descripcion de los comandos");
                    mostrar("  que puedes usar para moverte por el mapa y te da una descripcion de los");
                    mostrar("  movimientos que realices.");
                    mostrar("");
                    mostrar("  Si te paras sobre un cartel podras ver lo que dice en la descripcion");
                    mostrar("  y lo mismo con una llave, podras ver cuando la hayas recogido");
                    mostrar("====================================Gedienca=====================================");
                    mostrar("v.0.3                   Presiona \"Enter\" para regresar            Copyright 2020");
                    entrada = opcion.nextLine();
                }

                else if(opcionFila == 3){salir = movimiento[4];}
            }
            else{
                for(int i = 0; i<movimiento.length;i++){
                    if(entrada.equals(movimiento[i])){
                        if(entrada.equals(movimiento[0]) && (opcionFila != 0) && (inicio[opcionFila-1][0]==0)){
                            opcionFila = opcionFila - 1;
                        }
                        else if(entrada.equals(movimiento[1]) && (opcionFila != inicio.length-1) && (inicio[opcionFila+1][0]==0)){
                            opcionFila = opcionFila + 1;
                        }
                        error = false;
                    }
                }
                if(error == true){
                    mostrar("");
                }
            }
        }
        
    }
	// Funciones Extras para estetica del programa
    public static void limpiar(){
    	try {
    	    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    	} catch (Exception e) {
    	}
    }
    public static void mostrar(String dato){System.out.println(dato);}
	public static void _mostrar(String dato){System.out.print(dato);}
}