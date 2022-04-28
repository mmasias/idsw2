
public class Surface {

    public static final int ID_WALL = 1;
    public static final String WALL = Colors.START + Colors.GREY_BACKGROUND + "   " + Colors.RESET;

    public static final int ID_GRASS = 2;
    public static final String GRASS = Colors.START + Colors.BLUE + Colors.GREEN_BOLD_BRIGHT + ". '" + Colors.RESET;

    public static final int ID_WATER = 3;
    public static final String WATER = Colors.START + Colors.BLUE + Colors.BLUE_BACKGROUND_BRIGHT + " ~ " + Colors.RESET;

    public static final int ID_MEDIUM_GRASS = 4;
    public static final String MEDIUM_GRASS = Colors.START + Colors.GREEN_BOLD + Colors.GREEN_BOLD_BRIGHT + ".:'" + Colors.RESET;

    public static final int ID_SAND = 5;
    public static final String SAND = Colors.START + Colors.BROWN_BOLD + Colors.BROWN_BACKGROUND + "   " + Colors.RESET;

    public static final int ID_FLOOR = 6;
    public static final String FLOOR = Colors.START + Colors.LIGHT_YELLOW_BACKGROUND + "   " + Colors.RESET;

    public static final int ID_TALL_GRASS = 7;
    public static final String TALL_GRASS = Colors.START + Colors.RED + Colors.GREEN_BACKGROUND + "*" + Colors.RESET +
                                            Colors.START + Colors.BLACK_BOLD + Colors.GREEN_BACKGROUND + "Y" + Colors.RESET +
                                            Colors.START + Colors.RED + Colors.GREEN_BACKGROUND + "*" + Colors.RESET;

    public static final int ID_HEAVY_WATER = 11;
    public static final String HEAVY_WATER = Colors.START + Colors.BLUE_BACKGROUND + "'~'" + Colors.RESET;

    public static final int ID_MOUNTAIN = 9;
    public static final String MOUNTAIN = Colors.START + Colors.WHITE_BOLD + Colors.DARK_GREEN_BACKGROUND + "/" + Colors.RESET +
                                        Colors.START + Colors.WHITE_BOLD + Colors.DARK_GREEN_BACKGROUND + "^" + Colors.RESET +
                                        Colors.START + Colors.WHITE_BOLD + Colors.DARK_GREEN_BACKGROUND + "\\" + Colors.RESET;

    public static final String SUN = Colors.START + Colors.YELLOW_BOLD + Colors.BLUE_BACKGROUND + "(O)" + Colors.RESET;
    public static final String SKY = Colors.START + Colors.BLUE_BOLD + Colors.CYAN_BACKGROUND_BRIGHT + "   " + Colors.RESET;
  
}
