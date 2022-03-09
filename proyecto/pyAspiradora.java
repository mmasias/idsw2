package proyecto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class pyAspiradora {

    static int[][] map = {
            { 3, 4, 1, 3, 4, 1, -1, 4, 3, 2, 2, 2, 1, 1, 4, 4, 4, 2, 0, 0, 2, 1, 3, 0, 1 },
            { 3, 3, 1, 3, 3, 4, 0, 3, 4, 2, 4, 3, 4, 3, 4, 3, 1, 2, 3, 2, 4, 1, 2, 0, 1 },
            { 4, 1, 0, 2, 2, 3, 1, 1, 2, 2, 1, 1, 2, 2, 0, 2, 1, 4, 3, 0, 0, 3, 4, 0, 1 },
            { -1, 2, 2, 3, 3, 0, 1, 2, 0, 3, 0, 1, 0, 1, 0, 0, 0, 4, 4, 1, 2, 1, 4, 4, 0 },
            { -1, 2, 0, 0, 4, 0, 2, 4, 2, 3, 1, 2, 3, 2, 1, 0, 3, 3, 1, 1, 0, 2, 2, 4, 1 },
            { -1, 2, 3, 3, 4, 2, 1, 4, 2, 0, 3, 1, 1, 2, 3, 3, 4, 4, 0, 0, 4, 0, 4, 4, 2 },
            { -1, 0, 0, 0, 4, 0, 4, 4, 0, 4, 3, 3, 0, 0, 3, 1, 3, 1, 2, 4, 2, 4, 1, 1, 3 },
            { -1, 3, 3, 2, 4, 1, 0, 1, 2, 4, 4, 4, 3, 0, 4, 0, 0, 4, 4, 4, 4, 0, 2, 0, 3 },
            { -1, 3, 3, 2, 4, 4, 2, 3, 3, 4, 4, 4, 2, 2, 2, 0, 3, 0, 4, 4, 4, 2, 1, 0, 3 },
            { -1, 2, 1, 1, 4, 2, 1, 3, 2, 0, -1, -1, 1, -1, -1, 1, 3, 3, 3, 3, 1, 2, 1, 0, 0 },
            { 0, 1, 0, 2, 2, 3, 3, 2, 0, 1, -1, 2, 0, 0, 0, 1, 2, 4, 4, 4, 4, 4, 3, 2, 1 },
            { 3, 3, 2, 2, 4, 0, 1, 0, 1, 2, -1, 0, 0, 1, 1, 1, 1, 2, 2, 1, 1, 0, 3, 3, 4 },
            { 3, 0, 3, 0, 2, 4, 1, 3, 3, -1, 0, 0, -1, -1, 3, 1, 4, 0, 3, 3, 0, 2, 0, 2, 4 },
            { 2, 1, 0, 1, 4, 0, 2, 1, 3, -1, 0, 0, -1, 2, 4, 4, -1, 0, 2, 4, 0, 3, 1, 1, 3 },
            { 0, 4, 0, 3, 2, 1, 3, 1, 0, -1, 1, 4, 2, 0, 4, 1, -1, 1, 0, 0, 1, 4, 4, 2, 2 },
            { 4, 0, 4, 4, 2, 4, 4, 4, 0, 1, 2, 3, 1, 4, 3, -1, 3, 3, 1, 1, 4, 3, 2, 1, 4 },
            { 3, 0, 2, 0, 4, 1, 2, 3, 3, 2, -1, -1, -1, -1, 1, 3, 1, 3, 1, 0, 1, 3, 2, 0, 3 },
            { 1, 1, 3, 0, 1, 2, 1, 4, 2, 1, 2, 0, 1, 3, 4, 2, 4, 1, 1, 1, 3, 1, 3, 4, 2 },
            { 2, 0, 3, 0, 2, 2, 1, 2, 4, 0, 0, 2, 4, 3, 0, 3, 4, 4, 3, 3, 1, 3, 2, 1, 1 },
            { 3, 4, 0, 3, 3, 0, 4, 4, 0, 1, 1, 0, 3, 1, 3, 2, 3, 4, 4, 2, 0, 3, 2, 4, 3 },
            { 3, 4, 2, 3, 4, 3, 2, 2, 2, 2, 1, 1, 1, 4, 4, 3, 4, 4, 3, 1, 2, 2, 1, 1, 3 },
            { 0, 4, 2, 1, 3, 0, 0, 3, 4, 2, 3, 3, 3, 0, 1, 1, 2, 3, 3, 1, 0, 0, 2, 3, 0 },
            { 1, 2, 3, 3, 0, 0, 0, 0, 3, 3, 3, 4, 2, 0, 2, 3, 0, 3, 0, 1, 3, 4, 3, 1, 0 },
            { 0, 0, 3, 3, 4, 2, 2, 2, 3, 2, 1, 0, 0, 3, 2, 1, 4, 4, 1, 2, 4, 2, 2, 4, 2 },
            { 4, 0, 3, 2, 2, 0, 4, 0, 1, 2, 4, 2, 4, 2, 1, 4, 1, 1, 0, 1, 4, 0, 4, 2, 3 }
    };

    static String[] levels = { " ⬜ ", " ⬛ ", " \uD83D\uDCA9 ", " \uD83D\uDCA9 ", " \uD83D\uDCA9 " };
    static String[] furniture = { " \uD83E\uDE91 "};
    static String aspiradora = ".\uD83E\uDDBC.";
    static int xVacuum = 12;
    static int yVacuum = 12;
    static float steps = 0;
    static float superficie = 3125;
    static float percentage;
    static float bateria = 100;
    static int bolsa;
    static String respuesta;
    static Gato gato = new Gato(15, 15);

    public static void main(String[] args) {

        int[][] moves = {
                { -1, -1 },
                { -1, 0 },
                { -1, 1 },
                { 0, -1 },
                { 0, 1 },
                { 1, -1 },
                { 1, 0 },
                { 1, 1 }
        };
        gato.setApariciones(15);
        int apariciones = 0;
        int apareceGato = 0;
        while (true) {
            if (apariciones == 0) {
                apareceGato = (int) (Math.random() * 10) + 1;
                apariciones = apareceGato <= 5 ? gato.getApariciones() : 0;
            }

            int move = lookForPath(findDirtiestZone(), moves);

            xVacuum += moves[move][0];
            yVacuum += moves[move][1];
            steps = steps + 1;
            if (map[yVacuum][xVacuum] > 0) {
                bolsa++;
            }

            map[yVacuum][xVacuum] = Math.max(0, map[yVacuum][xVacuum] - 1);
            percentage = (float) ((1 / superficie) * 100);
            bateria = bateria - percentage;
            System.out.println("Batería: " + bateria + "%");
            if (apariciones > 0) {
                gato.moverGato(moves, map);
                apariciones--;
            }

            if (bolsa >= 200) {
                System.out.println("La bolsa de basura esta llena.");
                System.out.println("Desea vaciarla?");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(System.in));

                try {
                    String input = reader.readLine();
                    if (input.equals("si")) {
                        System.out.println("Vaciando...");
                        bolsa = 0;
                    } else if (input.equals("no")) {
                        System.exit(0);
                        ;
                    } else {
                        System.out.println("Tiene que responder si o no.");
                    }
                    ;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (bateria <= 0) {
                System.out.println("La batería se ha agotado. Es hora de recargar.");
                System.out.println("Desea recargar?");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(System.in));

                try {
                    String input = reader.readLine();
                    if (input.equals("si")) {
                        bateria = 100;
                        continue;
                    } else if (input.equals("no")) {
                        System.exit(0);
                    } else {
                        System.out.println("Tiene que responder si o no.");
                    }
                    ;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                printMap(apareceGato);
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Quit with "q"
            try {
                String input = reader.readLine();
                if (input.equals("q"))
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static int lookForPath(int move, int[][] moves) {
        int number = (int) (Math.random() * 8);
        if((xVacuum + moves[move][0]) < 0 || (xVacuum + moves[move][0]) >= map[0].length
                || (yVacuum + moves[move][1]) < 0 || (yVacuum + moves[move][1]) >= map.length){
            return lookForPath(number, moves);
        }
        if(map[yVacuum + moves[move][1]][xVacuum + moves[move][0]] < 0){
            return lookForPath(number, moves);
        }
        return move;
    }

    public static void printMap(int apareceGato) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (row == yVacuum && col == xVacuum) {
                    System.out.print(aspiradora);
                } else if (row == gato.getPosY() && col == gato.getPosX() && apareceGato <= 5) {
                    System.out.print(gato.getSymbol());
                } else if (map[row][col] < 0) {
                    System.out.print(furniture[Math.abs(map[row][col]) - 1]);
                }else {
                    System.out.print(levels[map[row][col]]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int findDirtiestZone() {
        ArrayList<Double> zones = new ArrayList<Double>();
        zones.add(getZoneAvg(new Coord(0, yVacuum), new Coord(xVacuum, yVacuum + 1)));
        zones.add(getZoneAvg(new Coord(0, yVacuum), new Coord(xVacuum, map[0].length)));
        zones.add(getZoneAvg(new Coord(xVacuum, 0), new Coord(xVacuum + 1, yVacuum)));
        zones.add(getZoneAvg(new Coord(xVacuum, yVacuum + 1), new Coord(xVacuum + 1, map[0].length)));
        zones.add(getZoneAvg(new Coord(xVacuum + 1, 0), new Coord(map.length, yVacuum)));
        zones.add(getZoneAvg(new Coord(xVacuum + 1, yVacuum), new Coord(map.length, yVacuum + 1)));
        zones.add(getZoneAvg(new Coord(xVacuum + 1, yVacuum + 1), new Coord(map.length, map[0].length)));
        int zoneMove = 0;

        for (int i = 0; i < zones.size(); i++) {
            if (zones.get(i) > zones.get(zoneMove))
                zoneMove = i;
        }
        if (zones.get(zoneMove) == 0)
            return (int) (Math.random() * 8);
        return zoneMove;
    }

    public static double getZoneAvg(Coord upperLeft, Coord lowerRight) {
        int filthyLvlSum = 0;
        int tiles = 0;
        for (int row = upperLeft.getRow(); row < lowerRight.getRow(); row++) {
            for (int col = upperLeft.getCol(); col < lowerRight.getCol(); col++) {
                if(map[row][col] < 0)
                    continue;

                filthyLvlSum += map[row][col];
                tiles++;
            }
        }
        if (tiles == 0)
            return 0;
        return filthyLvlSum / tiles;
    }
}