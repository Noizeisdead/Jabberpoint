import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

/** <p>The controller for the menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {

	private MyMenu myMenu;
	private Frame parent; //The frame, only used as parent for the Dialogs
	protected static final String TESTFILE = "testPresentation.xml";
	protected static final String SAVEFILE = "savedPresentation.xml";
	
	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";
	protected static final String SAVEERR = "Save Error";

	//Creating a menu-item
	public MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}


	public MenuController(Frame parent, Presentation presentation) {
		MenuItem menuItem;  //inisciate menuItem
		Menu fileMenu = new Menu("File"); //make menu

		fileMenu.add(menuItem = mkMenuItem("Open")); //add menuItem To menu

		myMenu.openFile(menuItem);

		fileMenu.add(menuItem = mkMenuItem("New"));
		myMenu.addFile(menuItem);

		fileMenu.add(menuItem = mkMenuItem("Save"));

		myMenu.saveFile(menuItem);

		fileMenu.addSeparator();
		fileMenu.add(menuItem = mkMenuItem("Exit"));
		myMenu.exitJabberpoint(menuItem);

		add(fileMenu);
//////////VIEWMENU
		Menu viewMenu = new Menu("View");
		viewMenu.add(menuItem = mkMenuItem("Next"));
		myMenu.nextPage(menuItem);

		viewMenu.add(menuItem = mkMenuItem("Prev"));
		myMenu.prevSlide(menuItem);

		viewMenu.add(menuItem = mkMenuItem("Go to"));
		myMenu.goToSlide(menuItem);

		add(viewMenu);
//////////HELPMENU
		Menu helpMenu = new Menu("Help");
		helpMenu.add(menuItem = mkMenuItem("About"));
		myMenu.aboutBox(menuItem);

		setHelpMenu(helpMenu);		//Needed for portability (Motif, etc.).
	}
}