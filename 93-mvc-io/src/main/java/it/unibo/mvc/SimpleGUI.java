package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Class to set the GUI.
 */
public final class SimpleGUI {
    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame();
    private final JTextField northTextField = new JTextField();
    private final JTextArea centerTextArea = new JTextArea();
    private final JButton printButton = new JButton("Print");
    private final JButton historyButton = new JButton("Show history");
    private final Controller controller = new SimpleController();

    /**
     * Simple GUI for printing strings and show history.
     */
    public SimpleGUI() {
        final JPanel mainPanel = new JPanel(new BorderLayout());
        frame.setContentPane(mainPanel);
        mainPanel.add(northTextField, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(centerTextArea), BorderLayout.CENTER);
        final JPanel bottomPanel = new JPanel();
        bottomPanel.add(printButton);
        bottomPanel.add(historyButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        printButton.addActionListener(e -> {
            try {
                controller.setPrintableString(northTextField.getText());
                controller.printCurrentString();
            } catch (final IllegalArgumentException | IllegalStateException exception) {
                JOptionPane.showMessageDialog(frame, exception.getMessage());
            }
        });
        historyButton.addActionListener(e -> {
            centerTextArea.setText("");
            for (final String s : controller.getPrintHistory()) {
            centerTextArea.append(s + "\n");
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Show GUI on screen.
     */
    public void display() {
    final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final int width = (int) screen.getWidth();
    final int height = (int) screen.getHeight();
    frame.setSize(width / PROPORTION, height / PROPORTION);
    frame.setVisible(true);
    frame.setLocationByPlatform(true);
    }

    /**
     * Main method to start GUI.
     * 
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
