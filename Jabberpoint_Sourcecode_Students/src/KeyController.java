import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/** <p>This is the KeyController (KeyListener)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class KeyController extends KeyAdapter {
	private final Presentation presentation; //Commands are given to the presentation

	public KeyController(Presentation presentation) {
		this.presentation = presentation;
	}

	public void keyPressed(KeyEvent keyEvent) {
		switch (keyEvent.getKeyCode()) {
			case KeyEvent.VK_PAGE_DOWN, KeyEvent.VK_DOWN, KeyEvent.VK_ENTER, KeyEvent.VK_EQUALS, KeyEvent.CTRL_DOWN_MASK ->
					this.presentation.nextSlide();
			case KeyEvent.VK_PAGE_UP, KeyEvent.VK_UP, KeyEvent.VK_MINUS -> this.presentation.prevSlide();
			case KeyEvent.VK_Q -> System.exit(0);
			//Should not be reached
			default -> {
			}
		}
	}
}
