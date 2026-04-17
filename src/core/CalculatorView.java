package core;

import javax.swing.*;

public class CalculatorView extends JFrame {
    public CalculatorView() {
        createWindow();
        setVisible(true);
    }

    private void createWindow() {
        setTitle("Calculator");
        setSize(320, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
