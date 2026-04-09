package ui;

import javax.swing.*;

public class CalculatorWindow extends JFrame {
    public CalculatorWindow() {
        setTitle("Calculator");
        setSize(720, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
