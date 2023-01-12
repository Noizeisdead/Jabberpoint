import java.awt.*;

public class StyleFactory {
    //styles[0] = new Style(0,Color.red,   48, 20);	// style item-level 0

    public static Style createStyle(int level){
        switch (level){
            case 1 ->{
                return new Style(0,Color.red,48, 20); // style item-level 0
            }
            case 2 ->{
                return new Style(20, Color.blue,  40, 10);	// style item-level 1
            }
            case 3 ->{
                return new Style(70, Color.black, 30, 10);	// style item-level 3
            }
            case 4 ->{
                return new Style(90, Color.black, 24, 10);	// style item-level 4
            }
        }
        return null;
    }
}
