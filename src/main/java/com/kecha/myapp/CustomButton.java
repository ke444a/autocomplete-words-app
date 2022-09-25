package com.kecha.myapp;
import javax.swing.JButton;
import java.awt.*;

public class CustomButton extends JButton {
    CustomButton(String buttonLabel) {
        this.setText(buttonLabel);
        this.setFont(new Font("Helvetica", Font.PLAIN, 15));
        this.setBackground(Color.white);
        this.setFocusable(false);
    }
}
