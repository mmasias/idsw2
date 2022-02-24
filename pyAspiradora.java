import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class pyAspiradora{

    static int[][] map= {
        {3,	4,	1,	3,	4,	1,	1,	4,	3,	2,	2,	2,	1,	1,	4,	4,	4,	2,	0,	0,	2,	1,	3,	0,	1},
        {3,	3,	1,	3,	3,	4,	0,	3,	4,	2,	4,	3,	4,	3,	4,	3,	1,	2,	3,	2,	4,	1,	2,	0,	1},
        {4,	1,	0,	2,	2,	3,	1,	1,	2,	2,	1,	1,	2,	2,	0,	2,	1,	4,	3,	0,	0,	3,	4,	0,	1},
        {1,	2,	2,	3,	3,	0,	1,	2,	0,	3,	0,	1,	0,	1,	0,	0,	0,	4,	4,	1,	2,	1,	4,	4,	0},
        {4,	2,	0,	0,	4,	0,	2,	4,	2,	3,	1,	2,	3,	2,	1,	0,	3,	3,	1,	1,	0,	2,	2,	4,	1},
        {4,	2,	3,	3,	4,	2,	1,	4,	2,	0,	3,	1,	1,	2,	3,	3,	4,	4,	0,	0,	4,	0,	4,	4,	2},
        {3,	0,	0,	0,	4,	0,	4,	4,	0,	4,	3,	3,	0,	0,	3,	1,	3,	1,	2,	4,	2,	4,	1,	1,	3},
        {2,	3,	3,	2,	4,	1,	0,	1,	2,	4,	4,	4,	3,	0,	4,	0,	0,	4,	4,	4,	4,	0,	2,	0,	3},
        {1,	3,	3,	2,	4,	4,	2,	3,	3,	4,	4,	4,	2,	2,	2,	0,	3,	0,	4,	4,	4,	2,	1,	0,	3},
        {0,	2,	1,	1,	4,	2,	1,	3,	2,	0,	0,	4,	3,	3,	3,	1,	3,	3,	3,	3,	1,	2,	1,	0,	0},
        {0,	1,	0,	2,	2,	3,	3,	2,	0,	1,	2,	2,	0,	0,	0,	3,	2,	4,	4,	4,	4,	4,	3,	2,	1},
        {3,	3,	2,	2,	4,	0,	1,	0,	1,	2,	1,	0,	0,	1,	1,	3,	1,	2,	2,	1,	1,	0,	3,	3,	4},
        {3,	0,	3,	0,	2,	4,	1,	3,	3,	1,	0,	0,	1,	1,	3,	1,	4,	0,	3,	3,	0,	2,	0,	2,	4},
        {2,	1,	0,	1,	4,	0,	2,	1,	3,	0,	0,	0,	1,	2,	4,	4,	3,	0,	2,	4,	0,	3,	1,	1,	3},
        {0,	4,	0,	3,	2,	1,	3,	1,	0,	3,	1,	4,	2,	0,	4,	1,	3,	1,	0,	0,	1,	4,	4,	2,	2},
        {4,	0,	4,	4,	2,	4,	4,	4,	0,	2,	2,	3,	1,	4,	3,	3,	3,	3,	1,	1,	4,	3,	2,	1,	4},
        {3,	0,	2,	0,	4,	1,	2,	3,	3,	2,	3,	1,	0,	1,	1,	3,	1,	3,	1,	0,	1,	3,	2,	0,	3},
        {1,	1,	3,	0,	1,	2,	1,	4,	2,	1,	2,	0,	1,	3,	4,	2,	4,	1,	1,	1,	3,	1,	3,	4,	2},
        {2,	0,	3,	0,	2,	2,	1,	2,	4,	0,	0,	2,	4,	3,	0,	3,	4,	4,	3,	3,	1,	3,	2,	1,	1},
        {3,	4,	0,	3,	3,	0,	4,	4,	0,	1,	1,	0,	3,	1,	3,	2,	3,	4,	4,	2,	0,	3,	2,	4,	3},
        {3,	4,	2,	3,	4,	3,	2,	2,	2,	2,	1,	1,	1,	4,	4,	3,	4,	4,	3,	1,	2,	2,	1,	1,	3},
        {0,	4,	2,	1,	3,	0,	0,	3,	4,	2,	3,	3,	3,	0,	1,	1,	2,	3,	3,	1,	0,	0,	2,	3,	0},
        {1,	2,	3,	3,	0,	0,	0,	0,	3,	3,	3,	4,	2,	0,	2,	3,	0,	3,	0,	1,	3,	4,	3,	1,	0},
        {0,	0,	3,	3,	4,	2,	2,	2,	3,	2,	1,	0,	0,	3,	2,	1,	4,	4,	1,	2,	4,	2,	2,	4,	2},
        {4,	0,	3,	2,	2,	0,	4,	0,	1,	2,	4,	2,	4,	2,	1,	4,	1,	1,	0,	1,	4,	0,	4,	2,	3}
    };

    static String[] levels = {" . ","ooo","***","OOO","000"};

    static int xVacuum = 12;
    static int yVacuum = 12;
    static float steps = 0;
    static float superficie = 3125;
    static float percentage;  
    static float bateria = 100;
    static int bolsa;
    static String respuesta;

    public static void main(String[] args){
        
       
        int[][] moves = {
            {-1,-1},
            {-1,0},
            {-1,1},
            {0,-1},
            {0,1},
            {1,-1},
            {1,0},
            {1,1}
        };

        

        while (true){
            int move = (int)(Math.random()*8);
            while (bolsa >= 625) {
                System.out.println("La bolsa de basura esta llena.");
                System.out.println("Desea vaciarla?");
                BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
            
                try {
                    String input = reader.readLine();
                    if(input.equals("si")) {
                        System.out.println("Vaciando...");
                        bolsa = 0;
                    } else if (input.equals("no")){
                        System.exit(0);;
                    } else {
                        System.out.println("Tiene que responder si o no.");
                    };
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
             while (bateria <= 0) {
                System.out.println("La batería se ha agotado. Es hora de recargar.");
                System.out.println("Desea recargar?");
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
                    
                    try {
                        String input = reader.readLine();
                        if(input.equals("si")){
                            bateria = 100;
                        }else if (input.equals("no")){
                            System.exit(0);
                        } else {
                            System.out.println("Tiene que responder si o no.");
                        };
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
            if(xVacuum + moves[move][0] < 0 || xVacuum + moves[move][0] >= map[0].length || yVacuum + moves[move][0] < 0 || yVacuum + moves[move][1] >= map.length) continue;
            xVacuum += moves[move][0];
            yVacuum += moves[move][1];
            steps = steps + 1;
            if (map[yVacuum][xVacuum] > 0) {
                bolsa++;
            }
            map[yVacuum][xVacuum] = Math.max(0,map[yVacuum][xVacuum]-1);
            printMap();
            steps = steps++;
            percentage = (float)((steps / superficie) * 100);
            bateria = 100 - percentage;
            System.out.println("Batería: " + bateria + "%");
            
            BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
            
            // Quit with "q"
            try {
                String input = reader.readLine();
                if(input.equals("q")) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (bolsa >= 40) {
                System.out.println("La bolsa de basura esta llena.");
                System.out.println("Desea vaciarla?");
                BufferedReader readerBolsa = new BufferedReader(
                new InputStreamReader(System.in));
            
                try {
                    String input = readerBolsa.readLine();
                    if(input.equals("si")) {
                        System.out.println("Vaciando...");
                        bolsa = 0;
                    } else if (input.equals("no")){
                        break;
                    } else {
                        System.out.println("Tiene que responder si o no.");
                    };
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void printMap(){
        for(int row = 0; row<map.length;row++){
            for(int col = 0; col<map[row].length;col++){
                if(row == yVacuum && col == xVacuum) {
                  System.out.print("(O)"); 
                }
                else System.out.print(levels[map[row][col]]);
            }
            System.out.println();
        }
        System.out.println();
    }


}