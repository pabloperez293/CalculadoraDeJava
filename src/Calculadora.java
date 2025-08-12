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
            "0", ".", "√", "="
    };
    String[] operators = { "+", "-", "×", "÷", "=" };
    String[] topSymbols = { "C", "+/-", "%" };

    JFrame frame = new JFrame("Calculadora Java");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    // Representation  a+b, a-b,etc..
    String A = "0";
    String operator = null;
    String B = null;


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

        for (int i = 0; i < buttonsValues.length; i++) {
            JButton button = new JButton();
            String buttonValue = buttonsValues[i];
            button.setFont(new Font("arial", Font.PLAIN, 30));
            button.setText(buttonValue);
            button.setFocusable(false);
            // button.setBorder(new LineBorder(Color.BLACK, 1));
            if (Arrays.asList(topSymbols).contains(buttonValue)) {
                button.setBackground(customLightGray);
                button.setForeground(customDark);
            } else if (Arrays.asList(operators).contains(buttonValue)) {
                button.setBackground(customGreen);
                button.setForeground(Color.WHITE);

            } else {
                button.setBackground(customDarkGray);
                button.setForeground(Color.WHITE);
            }
            buttonsPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String buttonValue = button.getText();

                    // Si es operador
                    if (Arrays.asList(operators).contains(buttonValue)) {
                        if (operator == null) {
                            operator = buttonValue.equals("=") ? null : buttonValue;
                            A = displayLabel.getText();
                            displayLabel.setText("0");
                        } else {
                            B = displayLabel.getText();
                            double resultado = 0;
                            double a = Double.parseDouble(A);
                            double b = Double.parseDouble(B);

                            switch (operator) {
                                case "+":
                                    resultado = a + b;
                                    break;
                                case "-":
                                    resultado = a - b;
                                    break;
                                case "×":
                                    resultado = a * b;
                                    break;
                                case "÷":
                                    if (b == 0) {
                                        displayLabel.setText("Error");
                                        operator = null;
                                        return;
                                    }
                                    resultado = a / b;
                                    break;
                            }
                            displayLabel.setText(String.valueOf(resultado).replaceAll("\\.0$", ""));
                            operator = buttonValue.equals("=") ? null : buttonValue;
                            A = String.valueOf(resultado);
                            B = null;
                        }
                    }
                    // Funciones especiales
                    else if (Arrays.asList(topSymbols).contains(buttonValue)) {
                        if (buttonValue.equals("C")) {
                            displayLabel.setText("0");
                            A = "0";
                            operator = null;
                            B = null;
                        } else if (buttonValue.equals("+/-")) {
                            String valor = displayLabel.getText();
                            if (!valor.equals("0") && !valor.equals("Error")) {
                                if (valor.startsWith("-")) {
                                    displayLabel.setText(valor.substring(1));
                                } else {
                                    displayLabel.setText("-" + valor);
                                }
                            }
                        } else if (buttonValue.equals("%")) {
                            String valor = displayLabel.getText();
                            try {
                                double num = Double.parseDouble(valor);
                                num = num / 100;
                                displayLabel.setText(String.valueOf(num).replaceAll("\\.0$", ""));
                            } catch (Exception ex) {
                                displayLabel.setText("Error");
                            }
                        }
                    }
                    // Raíz cuadrada
                    else if (buttonValue.equals("√")) {
                        String valor = displayLabel.getText();
                        try {
                            double num = Double.parseDouble(valor);
                            if (num < 0) {
                                displayLabel.setText("Error");
                            } else {
                                double resultado = Math.sqrt(num);
                                displayLabel.setText(String.valueOf(resultado).replaceAll("\\.0$", ""));
                            }
                        } catch (Exception ex) {
                            displayLabel.setText("Error");
                        }
                    }
                    // Números y punto decimal
                    else {
                        if (buttonValue.equals(".")) {
                            if (!displayLabel.getText().contains(".")) {
                                displayLabel.setText(displayLabel.getText() + ".");
                            }
                        } else if ("0123456789".contains(buttonValue)) {
                            if (displayLabel.getText().equals("0") || displayLabel.getText().equals("Error")) {
                                displayLabel.setText(buttonValue);
                            } else {
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }
                        }
                    }
                }
            });
        }
        ;
    }
}
