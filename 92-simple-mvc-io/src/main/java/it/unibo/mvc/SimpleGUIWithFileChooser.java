package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A simple GUI that can choose the file it saves text on.
 */
public final class SimpleGUIWithFileChooser {
    private static final int PROPORTION = 3;
    private final Controller controller = new Controller();
    private final JFrame frame = new JFrame();

    /**
     * Constructor of the class.
     */
    public SimpleGUIWithFileChooser() {
        final JTextField northTextField = new JTextField();
        final JTextArea centralTextArea = new JTextArea();
        final JButton browseButton = new JButton("browse");
        final JButton saveButton = new JButton("save");
        final JPanel mainPanel = new JPanel();
        final JPanel northPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new BorderLayout());
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(centralTextArea, BorderLayout.CENTER);
        mainPanel.add(saveButton, BorderLayout.SOUTH);
        northPanel.add(northTextField, BorderLayout.CENTER);
        northPanel.add(browseButton, BorderLayout.LINE_END);
        northTextField.setEditable(false);
        northTextField.setText(controller.getPath());
        frame.setContentPane(mainPanel);

        browseButton.addActionListener(e -> {
            final JFileChooser selectedJFile = new JFileChooser();
            final int result = selectedJFile.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                final File chosenFile = selectedJFile.getSelectedFile();
                controller.setFile(chosenFile);
                northTextField.setText(controller.getPath());
            } else if (result != selectedJFile.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(frame, "an error occurred while selecting file");
            }
        });
        saveButton.addActionListener(e -> {
            try {
                controller.saveString(centralTextArea.getText());
            } catch (final IOException exception) {
                JOptionPane.showMessageDialog(frame, "an error occurred while saving the file");
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Method to visualize the GUI.
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int myWidth = (int) screen.getWidth();
        final int myHeight = (int) screen.getHeight();
        frame.setSize(myWidth / PROPORTION, myHeight / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        }

    /**
     *  @param args ignored.
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser().display();
    }
}
