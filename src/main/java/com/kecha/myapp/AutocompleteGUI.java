package com.kecha.myapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.List;

public class AutocompleteGUI extends JFrame {
    /* Creating GUI for Application */

    private CustomTextField textField;
    private JPanel mainPanel, labelsPanel, infoPanel, functionalPanel;
    private AutocompleteProgram program;

    AutocompleteGUI() {
        program = new AutocompleteProgram();

        // Default settings for the JFrame
        this.setTitle("Autocomplete Application");
        this.getContentPane().setBackground(new Color(255, 244, 203));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setIconImage(new ImageIcon("src/main/resources/img/text-icon.png").getImage());

        buildInfoPanel();
        buildFunctionalPanel();
        buildLabelsPanel();
        buildMainPanel();

        // Add key components to the JFrame
        this.add(infoPanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
        this.setSize(600, 600);
        this.setVisible(true);
    }

    public void buildInfoPanel() {
        /* Build JPanel with the App's Description */
        infoPanel = new JPanel(new FlowLayout());
        infoPanel.setBackground(null);
        JLabel image = new JLabel(new ImageIcon("src/main/resources/img/big-image.png"));
        image.setPreferredSize(new Dimension(100, 100));
        JPanel textPanel = new JPanel(new GridLayout(0, 1, 0, 0));
        textPanel.setBackground(null);
        JLabel labelIntro = new JLabel("Autocomplete App");
        labelIntro.setFont(new Font("Helvetica", Font.BOLD, 14));
        JLabel labelDetails = new JLabel("Enter the Part & Program finds the Rest");
        labelDetails.setFont(new Font("Helvetica", Font.ITALIC, 12));
        textPanel.add(labelIntro);
        textPanel.add(labelDetails);
        infoPanel.add(image);
        infoPanel.add(textPanel);
    }

    public void buildFunctionalPanel() {
        /* Build JPanel to Enter the Prefix or Clean everything */
        CustomButton buttonClean = new CustomButton("Clean All");
        buttonClean.addActionListener(new CleanFieldListener());
        textField = new CustomTextField(new ImageIcon("src/main/resources/img/search-icon.png"),
                "Press \"Enter\" to Search");
        textField.addActionListener(new AutocompleteGUI.TextInputListener());
        functionalPanel = new JPanel(new FlowLayout());
        functionalPanel.setBackground(null);
        functionalPanel.add(textField);
        functionalPanel.add(buttonClean);
    }

    public void buildLabelsPanel() {
        /* Build JPanel to display Autocomplete results */
        labelsPanel = new JPanel();
        labelsPanel.setBackground(null);
    }

    public void buildMainPanel() {
        /* Build JPanel to arrange components together */
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(null);
        mainPanel.add(functionalPanel, BorderLayout.NORTH);
        mainPanel.add(labelsPanel, BorderLayout.CENTER);
    }

    public class TextInputListener implements ActionListener {
        /* Process the Input from TextField */
        @Override
        public void actionPerformed(ActionEvent e) {
            int suggestionCount = 10, counter = 0;

            labelsPanel.removeAll();
            JPanel lblPanel = new JPanel(new GridLayout(0,1,0, 0));
            lblPanel.setBackground(null);
            List<String> findResult = program.displaySearchResult(textField.getText());
            for (String suggestion : findResult) {
                if (counter >= suggestionCount) {
                    break;
                }

                lblPanel.add(new CustomLabel(suggestion));
                counter++;
            }
            labelsPanel.add(lblPanel);
            labelsPanel.revalidate();
            labelsPanel.repaint();
        }
    }

    public class CleanFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textField.setText("");
            labelsPanel.removeAll();
            labelsPanel.revalidate();
            labelsPanel.repaint();
        }
    }

}