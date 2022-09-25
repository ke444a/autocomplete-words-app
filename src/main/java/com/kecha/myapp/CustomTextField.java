package com.kecha.myapp;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CustomTextField extends JTextField implements FocusListener {
    /* Append Icon to start of TextField and Demonstrate hint when TextField is Unfocused */

    private static final int ICON_SPACING = 10;
    private Border myBorder;
    private Icon myIcon;
    private String myHint;
    private boolean showingHint;        // identification whether to show the hint

    CustomTextField(Icon iconIn, String hint) {
        super(hint);
        this.myHint = hint;
        this.showingHint = true;

        super.addFocusListener(this);
        this.resetBorder();
        this.setIcon(iconIn);
        this.setPreferredSize(new Dimension(200, 35));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setHintFont();
    }

    public void setIcon(Icon icon) {
        myIcon = icon;
        resetBorder();
    }

    private void resetBorder() {
        setBorder(myBorder);
    }

    @Override
    public void setBorder(Border border) {
        // Allocating extra space for icon placement
        myBorder = border;

        if (myIcon == null) {
            super.setBorder(border);
        } else {
            Border margin = BorderFactory.createEmptyBorder(0, myIcon.getIconWidth() + ICON_SPACING, 0, 0);
            Border compound = BorderFactory.createCompoundBorder(border, margin);
            super.setBorder(compound);
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if (myIcon != null) {
            Insets iconInsets = myBorder.getBorderInsets(this);
            myIcon.paintIcon(this, graphics, iconInsets.left, iconInsets.top);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().isEmpty()) {
            setDefaultFont();
            super.setText("");
            showingHint = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            setHintFont();
            super.setText(myHint);
            showingHint = true;
        }
    }

    @Override
    public String getText() {
        return showingHint ? "" : super.getText();
    }

    public void setDefaultFont() {
        this.setFont(new Font("Courier New", Font.PLAIN, 18));
    }

    public void setHintFont() {
        this.setFont(new Font("Times New Roman", Font.ITALIC, 13));
    }
}
