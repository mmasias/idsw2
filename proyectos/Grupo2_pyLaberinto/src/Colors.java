package src;

public class Colors {

    // Zona de constantes ANSI para mejorar la visualización de gráficos ASCII

    public static final String RESET = "\033[0m"; // Text Reset
    public static final String START = "\033["; // START de la cadena de color

    // LETRA

    // Regular
    public static final String BLACK = "0;30"; // BLACK
    public static final String RED = "0;31"; // RED
    public static final String GREEN = "0;32"; // GREEN
    public static final String BLUE = "3;34"; // BLUE

    // Negrita
    public static final String BLACK_BOLD = "1;30"; // BLACK
    public static final String GREEN_BOLD = "1;32"; // GREEN
    public static final String YELLOW_BOLD = "1;33"; // YELLOW
    public static final String BLUE_BOLD = "1;34"; // BLUE
    public static final String BROWN_BOLD = "48;2;"; //BROWN
    public static final String WHITE_BOLD = "38;5;15;"; //WHITE

    // FONDOS
    // Normales
    public static final String BLACK_BACKGROUND = ";40m"; // BLACK
    public static final String GREEN_BACKGROUND = ";42m"; // GREEN
    public static final String BLUE_BACKGROUND = ";44m"; // BLUE
    public static final String BROWN_BACKGROUND = "101;67;33m"; //BROWN
    public static final String DARK_GREEN_BACKGROUND = "48;5;22m"; //DARK GREEN
    public static final String LIGHT_YELLOW_BACKGROUND = "48;5;247m"; // LIGHT YELLOW
    public static final String GREY_BACKGROUND = "48;5;239m"; // GREY

    // Negrita & Alta intensidad
    public static final String GREEN_BOLD_BRIGHT = ";1;92m"; // GREEN

    // Alta intensidad
    public static final String BLUE_BACKGROUND_BRIGHT = ";0;104m"; // BLUE
    public static final String CYAN_BACKGROUND_BRIGHT = ";0;106m"; // CYAN

    // Mosaicos
    public static final String DARKNESS = START + BLACK + BLACK_BACKGROUND + " . " + RESET;

    public static final String BLOCK = START + BLACK + BLUE_BACKGROUND + "   " + RESET;

    public static final int ID_WALL = 1;
    public static final String WALL = START + GREY_BACKGROUND + "   " + RESET;

    public static final int ID_GRASS = 2;
    public static final String GRASS = START + BLUE + GREEN_BOLD_BRIGHT + ". '" + RESET;

    public static final int ID_WATER = 3;
    public static final String WATER = START + BLUE + BLUE_BACKGROUND_BRIGHT + " ~ " + RESET;

    public static final int ID_MEDIUM_GRASS = 4;
    public static final String MEDIUM_GRASS = START + GREEN_BOLD + GREEN_BOLD_BRIGHT + ".:'" + RESET;

    public static final int ID_SAND = 5;
    public static final String SAND = START + BROWN_BOLD + BROWN_BACKGROUND + "   " + RESET;

    public static final int ID_FLOOR = 6;
    public static final String FLOOR = START + LIGHT_YELLOW_BACKGROUND + "   " + RESET;

    public static final int ID_TALL_GRASS = 7;
    public static final String TALL_GRASS = START + RED + GREEN_BACKGROUND + "*" + RESET +
            START + BLACK_BOLD + GREEN_BACKGROUND + "Y" + RESET +
            START + RED + GREEN_BACKGROUND + "*" + RESET;

    public static final int ID_HEAVY_WATER =11;
    public static final String HEAVY_WATER = START + BLUE_BACKGROUND + "'~'" + RESET;

    public static final int ID_MOUNTAIN = 9;
    public static final String MOUNTAIN = START + WHITE_BOLD + DARK_GREEN_BACKGROUND + "/" + RESET +
            START + WHITE_BOLD + DARK_GREEN_BACKGROUND + "^" + RESET +
            START + WHITE_BOLD + DARK_GREEN_BACKGROUND + "\\" + RESET;

    public static final String SUN = START + YELLOW_BOLD + BLUE_BACKGROUND + "(O)" + RESET;
    public static final String SKY = START + BLUE_BOLD + CYAN_BACKGROUND_BRIGHT + "   " + RESET;

}