import java.awt.*;
import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class MenuFactory {


    public static MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }


    public static Menu mkFileMenu(Presentation presentation){
        MenuItem menuItem;
        MyMenu myMenu = new MyMenu();
        Menu fileMenu = new Menu("File"); //make menu

        fileMenu.add(menuItem = MenuFactory.mkMenuItem("Open")); //add menuItem To menu


        myMenu.openFile(menuItem, presentation);

        fileMenu.add(menuItem = MenuFactory.mkMenuItem("New"));
        myMenu.addFile(menuItem, presentation);

        fileMenu.add(menuItem = MenuFactory.mkMenuItem("Save"));

        myMenu.saveFile(menuItem, presentation);

        fileMenu.addSeparator();
        fileMenu.add(menuItem = MenuFactory.mkMenuItem("Exit"));
        myMenu.exitJabberpoint(menuItem, presentation);
        return fileMenu;
    }

    public static Menu mkViewMenu(Presentation presentation){
        MenuItem menuItem;
        MyMenu myMenu = new MyMenu();

        Menu viewMenu = new Menu("View");
        viewMenu.add(menuItem = MenuFactory.mkMenuItem("Next"));
        myMenu.nextPage(menuItem, presentation);

        viewMenu.add(menuItem = MenuFactory.mkMenuItem("Prev"));
        myMenu.prevSlide(menuItem, presentation);

        viewMenu.add(menuItem = MenuFactory.mkMenuItem("Go to"));
        myMenu.goToSlide(menuItem, presentation);
        return viewMenu;
    }

    public static Menu mkHelpMenu(Presentation presentation){
        MenuItem menuItem;
        MyMenu myMenu = new MyMenu();

        Menu helpMenu = new Menu("Help");
        helpMenu.add(menuItem = MenuFactory.mkMenuItem("About"));
        myMenu.aboutBox(menuItem, presentation);
        return helpMenu;
    }
}
