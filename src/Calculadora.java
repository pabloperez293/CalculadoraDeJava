import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
import javax.swing.border.LineBorder;


public class Calculadora {
    int boardWidth = 400;
    int boardHeight = 640;

    Color customLightGray = new Color(212, 212, 210);
    Color customDarkGray = new Color(28, 28, 28);
    Color customDark = new Color(18, 18, 18);
    Color customGreen = new Color(255, 188, 0);

    JFrame frame = new JFrame("Calculadora");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();


    Calculadora() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayLabel.setBackground(customDark);
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel);
    }
}
