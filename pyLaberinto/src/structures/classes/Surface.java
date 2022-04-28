package structures.classes;

import structures.enums.SurfaceType;
import structures.interfaces.Drawable;

public  class Surface implements Drawable {
    private final Position position;
    private final String avatar;
    private final SurfaceType type;

    public Surface(SurfaceType type, Position position) {
        this.position = position;
        this.type = type;
        this.avatar = defineAvatar();
    }

    @Override
    public String getAvatar() {
        return avatar;
    }

    private String defineAvatar() {
        switch (this.type) {
            case GROUND:
                return "   ";
            case LOWGRASS:
                return Colors.GREEN + "..." + Colors.RESET;
            case MIDGRASS:
                return Colors.GREEN_BOLD_BRIGHT + ":::" + Colors.RESET;
            case HIGHGRASS:
                return Colors.GREEN_BRIGHT_BG + "|||" + Colors.RESET_BG;
            case SAND:
                return Colors.YELLOW_BG + "---" + Colors.RESET_BG;
            case MOUNTAIN:
                return Colors.GREEN_BG + "/\\\\" + Colors.RESET_BG;
            case WALL:
                return Colors.WHITE_BG + "[ ]" + Colors.RESET_BG;
            case WATER:
                return Colors.BLUE_BG + "~~~" + Colors.RESET_BG;
            case TROUBLEDWATERS:
                return Colors.BLUE_BRIGHT_BG + "%%%" + Colors.RESET_BG;
            default:
                return "";
        }
    }

    public Position getPosition() {
        return position;
    }

    public SurfaceType getType() {
        return type;
    }
}
