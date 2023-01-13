import java.awt.*;

public class MenuFactory {

    public static MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
