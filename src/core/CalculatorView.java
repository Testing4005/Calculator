package core;

import operation.*;
import util.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class CalculatorView extends JFrame {
    private final ImageIcon icon;

    private final CalculatorController calculatorController;
    private final CalculatorModel calculatorModel;

    private final Operation add = new Addition();
    private final Operation sub = new Subtraction();
    private final Operation mul = new Multiplication();
    private final Operation div = new Division();

    private JLabel label;

    public CalculatorView() {
        icon = new ImageIcon("res/calculator.png");

        calculatorModel = new CalculatorModel();
        calculatorController = new CalculatorController(this, calculatorModel);

        createWindow();
        createUI();

        setVisible(true);
    }

    private void createWindow() {
        setTitle("Calculator");
        setIconImage(icon.getImage());
        setSize(320, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUI() {
        label = Util.createLabel("0");
        add(label, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.fill = GridBagConstraints.BOTH;

        // Row 1
        addButton(panel, gbc, 0, 0, 1, 1, Util.createButton("C", e -> calculatorController.handleClear()));
        addButton(panel, gbc, 1, 0, 1, 1, Util.createButton("/", e -> calculatorController.handleOperation(div)));
        addButton(panel, gbc, 2, 0, 1, 1, Util.createButton("*", e -> calculatorController.handleOperation(mul)));
        addButton(panel, gbc, 3, 0, 1, 1, Util.createButton("-", e -> calculatorController.handleOperation(sub)));

        // Row 2
        addButton(panel, gbc, 0, 1, 1, 1, Util.createButton("7", e -> calculatorController.handleNumber("7")));
        addButton(panel, gbc, 1, 1, 1, 1, Util.createButton("8", e -> calculatorController.handleNumber("8")));
        addButton(panel, gbc, 2, 1, 1, 1, Util.createButton("9", e -> calculatorController.handleNumber("9")));
        addButton(panel, gbc, 3, 1, 1, 2, Util.createButton("+", e -> calculatorController.handleOperation(add)));

        // Row 3
        addButton(panel, gbc, 0, 2, 1, 1, Util.createButton("4", e -> calculatorController.handleNumber("4")));
        addButton(panel, gbc, 1, 2, 1, 1, Util.createButton("5", e -> calculatorController.handleNumber("5")));
        addButton(panel, gbc, 2, 2, 1, 1, Util.createButton("6", e -> calculatorController.handleNumber("6")));

        // Row 4
        addButton(panel, gbc, 0, 3, 1, 1, Util.createButton("1", e -> calculatorController.handleNumber("1")));
        addButton(panel, gbc, 1, 3, 1, 1, Util.createButton("2", e -> calculatorController.handleNumber("2")));
        addButton(panel, gbc, 2, 3, 1, 1, Util.createButton("3", e -> calculatorController.handleNumber("3")));
        addButton(panel, gbc, 3, 3, 1, 2, Util.createButton("=", e -> calculatorController.handleEquals()));

        // Row 5
        addButton(panel, gbc, 0, 4, 2, 1, Util.createButton("0", e -> calculatorController.handleNumber("0")));
        addButton(panel, gbc, 2, 4, 1, 1, Util.createButton(".", e -> calculatorController.handleNumber(".")));

        add(panel, BorderLayout.CENTER);

        addKeyBinds();
    }

    public void setText(String text) {
        label.setText(text);
    }

    private void addButton(JPanel panel, GridBagConstraints gbc, int x, int y, int w, int h, JButton button) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        panel.add(button, gbc);
    }

    private void addKeyBinds() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(c >= '0' && c <= '9') {
                    calculatorController.handleNumber(String.valueOf(c));
                } else if(c == '.') {
                    calculatorController.handleNumber(".");
                } else if(c == '+') {
                    calculatorController.handleOperation(add);
                } else if(c == '-') {
                    calculatorController.handleOperation(sub);
                } else if(c == '*') {
                    calculatorController.handleOperation(mul);
                } else if(c == '/') {
                    calculatorController.handleOperation(div);
                } else if(c == '\n' || c == '=') {
                    calculatorController.handleEquals();
                } else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    calculatorController.handleBackspace();
                } else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    calculatorController.handleClear();
                }
            }
        });
    }
}
