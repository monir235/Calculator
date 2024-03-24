import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[5];
    private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton, dotButton;
    private double num1, num2, result;
    private char operator;

    public Calculator() {
        setTitle("Calculator by Monir");
        setSize(500, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textField = new JTextField(75);
        textField.setFont(new Font("Arial", Font.PLAIN, 75));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setSize(100, 100);
        textField.setBackground(Color.YELLOW);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 60));
            numberButtons[i].addActionListener(new NumberButtonListener());
            numberButtons[i].setBackground(Color.pink);
            numberButtons[i].setForeground(Color.BLACK);
        }

        addButton = createFunctionButton("+");
        subButton = createFunctionButton("-");
        mulButton = createFunctionButton("*");
        divButton = createFunctionButton("/");
        eqButton = createFunctionButton("=");
        clrButton = createFunctionButton("AC");
        dotButton = createFunctionButton(".");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 4, 4));

        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(addButton);

        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(subButton);

        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(mulButton);

        buttonPanel.add(clrButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(eqButton);
        buttonPanel.add(divButton);

        add(textField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JButton createFunctionButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 60));
        button.addActionListener(new FunctionButtonListener());
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        return button;
    }

    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            textField.setText(textField.getText() + button.getText());
        }
    }

    private class FunctionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();

            switch (buttonText) {
                case "+":
                case "-":
                case "*":
                case "/":
                    operator = buttonText.charAt(0);
                    num1 = Double.parseDouble(textField.getText());
                    textField.setText("");
                    break;
                case "=":
                    num2 = Double.parseDouble(textField.getText());
                    switch (operator) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                textField.setText("Error");
                                return;
                            }
                            break;
                    }
                    textField.setText(String.valueOf(result));
                    break;
                case "C":
                    textField.setText("");
                    break;
                case ".":
                    if (!textField.getText().contains(".")) {
                        textField.setText(textField.getText() + buttonText);
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}
