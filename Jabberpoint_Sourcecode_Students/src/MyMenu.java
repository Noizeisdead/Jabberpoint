import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyMenu {
    private Frame frame;
    protected static final String TESTFILE = "testPresentation.xml";
    protected static final String SAVEFILE = "savedPresentation.xml";

    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String SAVEERR = "Save Error";


    public void openFile(MenuItem menuItem, Presentation presentation, Frame frame) {
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.clear();
                Accessor accessor = new XMLAccessor();
                try {
                    accessor.loadFile(presentation, TESTFILE);
                    presentation.setSlideNumber(0);
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(frame, IOEX + exc,
                            LOADERR, JOptionPane.ERROR_MESSAGE);
                }
                frame.repaint();
            }
        } );
    }

    public void addFile(MenuItem menuItem, Presentation presentation, Frame frame){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.clear();
                frame.repaint();
            }
        });
    }

    public void saveFile(MenuItem menuItem, Presentation presentation, Frame frame){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                XMLAccessor xmlAccessor = new XMLAccessor();
                try {
                    xmlAccessor.saveFile(presentation, SAVEFILE);
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(frame, IOEX + exc,
                            SAVEERR, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void exitJabberpoint(MenuItem menuItem, Presentation presentation, Frame frame){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.exit(0);
            }
        });
    }

    public void nextPage(MenuItem menuItem, Presentation presentation){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.nextSlide();
            }
        });
    }

    public void prevSlide(MenuItem menuItem, Presentation presentation){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.prevSlide();
            }
        });
    }

    public void goToSlide(MenuItem menuItem, Presentation presentation){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String pageNumberStr = JOptionPane.showInputDialog((Object)"Page number?");
                int pageNumber = Integer.parseInt(pageNumberStr);
                presentation.setSlideNumber(pageNumber - 1);
            }
        });
    }

    public void aboutBox(MenuItem menuItem, Presentation presentation){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                AboutBox.show(frame);
            }
        });
    }
}
