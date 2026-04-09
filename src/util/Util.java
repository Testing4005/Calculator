package util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Util {
    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 50));
        label.setBackground(new Color(228,228,228));
        label.setForeground(new Color(20,20,20));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        return label;
    }

    public static JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        button.setBackground(new Color(228,228,228));
        button.setForeground(new Color(20,20,20));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.addActionListener(action);
        return button;
    }
}