import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyMenu {
    private Presentation presentation;
    private Frame frame;
    protected static final String TESTFILE = "testPresentation.xml";
    protected static final String SAVEFILE = "savedPresentation.xml";

    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String SAVEERR = "Save Error";


    public void openFile(MenuItem menuItem) {
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.clear();
                Accessor xmlAccessor = new XMLAccessor();
                try {
                    xmlAccessor.loadFile(presentation, TESTFILE);
                    presentation.setSlideNumber(0);
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(frame, IOEX + exc,
                            LOADERR, JOptionPane.ERROR_MESSAGE);
                }
                frame.repaint();
            }
        } );
    }

    public void addFile(MenuItem menuItem){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.clear();
                frame.repaint();
            }
        });
    }

    public void saveFile(MenuItem menuItem){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Accessor xmlAccessor = new XMLAccessor();
                try {
                    xmlAccessor.saveFile(presentation, SAVEFILE);
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(frame, IOEX + exc,
                            SAVEERR, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void exitJabberpoint(MenuItem menuItem){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.exit(0);
            }
        });
    }

    public void nextPage(MenuItem menuItem){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.nextSlide();
            }
        });
    }

    public void prevSlide(MenuItem menuItem){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.prevSlide();
            }
        });
    }

    public void goToSlide(MenuItem menuItem){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String pageNumberStr = JOptionPane.showInputDialog((Object)"Page number?");
                int pageNumber = Integer.parseInt(pageNumberStr);
                presentation.setSlideNumber(pageNumber - 1);
            }
        });
    }

    public void aboutBox(MenuItem menuItem){
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                AboutBox.show(frame);
            }
        });
    }
}
