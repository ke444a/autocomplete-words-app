package com.kecha.myapp;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CustomLabel extends JLabel {
    private Border myBorder;

    CustomLabel(String lblText) {
        this.setText(lblText);
        this.setFont(new Font("Arial", Font.PLAIN, 18));
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setOpaque(true);
        this.setVerticalAlignment(CENTER);
        this.setPreferredSize(new Dimension(200, 35));
    }

    @Override
    public void setBorder(Border border) {
        myBorder = border;

        Border margin = BorderFactory.createEmptyBorder(0, 15, 0, 0);
        Border compound = BorderFactory.createCompoundBorder(border, margin);
        super.setBorder(compound);
    }
}
