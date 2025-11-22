package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final Controller controller = new Controller();
    private final JFrame frame = new JFrame();
    private final JTextArea textArea = new JTextArea();

    /**
     * Constructor of the class.
     */
    public SimpleGUI() {
        final JPanel myPanel = new JPanel();
        myPanel.setLayout(new BorderLayout());
        final JButton save = new JButton("Save");
        myPanel.add(save, BorderLayout.SOUTH);
        myPanel.add(textArea, BorderLayout.CENTER);
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        save.addActionListener(e -> {
            try {
                controller.saveString(textArea.getText());
            } catch (final IOException exception) {
                throw new IllegalStateException("an error occurred", exception);
            }
        });
    }

    /**
     * method to set and show the GUI.
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int myWidth = (int) screen.getWidth();
        final int myHeight = (int) screen.getHeight();
        frame.setSize(myWidth / PROPORTION, myHeight / PROPORTION);
        //frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        }

    /**
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
