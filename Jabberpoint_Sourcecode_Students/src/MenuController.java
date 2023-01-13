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



	public MenuController(Frame parent, Presentation presentation) {
		MenuItem menuItem;  //inisciate menuItem
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

		add(fileMenu);
//////////VIEWMENU
		Menu viewMenu = new Menu("View");
		viewMenu.add(menuItem = MenuFactory.mkMenuItem("Next"));
		myMenu.nextPage(menuItem, presentation);

		viewMenu.add(menuItem = MenuFactory.mkMenuItem("Prev"));
		myMenu.prevSlide(menuItem, presentation);

		viewMenu.add(menuItem = MenuFactory.mkMenuItem("Go to"));
		myMenu.goToSlide(menuItem, presentation);

		add(viewMenu);
//////////HELPMENU
		Menu helpMenu = new Menu("Help");
		helpMenu.add(menuItem = MenuFactory.mkMenuItem("About"));
		myMenu.aboutBox(menuItem, presentation);

		setHelpMenu(helpMenu);		//Needed for portability (Motif, etc.).
	}
}