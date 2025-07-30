import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
import javax.swing.border.LineBorder;


public class Calculadora {
    int boardWidth = 440;
    int boardHeight = 540;

    Color customLightGray = new Color(212, 212, 210);
    Color customDarkGray = new Color(28, 28, 28);
    Color customDark = new Color(18, 18, 18);
    Color customGreen = new Color(255, 188, 0);

    String[] buttonsValues = {
        "C", "+/-", "%", "÷",
        "7", "8", "9", "×",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√","="
    };
    String[] operators = {"+", "-", "×", "÷", "="};
    String[] topSymbols = {"C", "+/-", "%"};

    JFrame frame = new JFrame("Calculadora Java");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();


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
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5, 4));
        buttonsPanel.setBackground(customDark);
        frame.add(buttonsPanel);

        for(int i = 0; i < buttonsValues.length; i++) {
            JButton button = new JButton();
            String buttonValue = buttonsValues[i];
            button.setFont(new Font("arial", Font.PLAIN, 30));
            button.setText(buttonValue);
            button.setFocusable(false);
            if (Arrays.asList(topSymbols).contains(buttonValue)) {
                button.setBackground(customLightGray);
                button.setForeground(customDark);
            } else if (Arrays.asList(operators).contains(buttonValue)) {
                button.setBackground(customGreen);
                button.setForeground(Color.WHITE);
                
            }else {
                button.setBackground(customDarkGray);
                button.setForeground(Color.WHITE);
            }
            buttonsPanel.add(button);
                }
          

    }
}
