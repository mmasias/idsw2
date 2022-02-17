package structures.classes.surfaces;

import structures.classes.Player;
import structures.interfaces.Drawable;

public abstract class Surface implements Drawable {
    private String avatar;

    public Surface(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public abstract boolean canAdvance(Player player);
}
