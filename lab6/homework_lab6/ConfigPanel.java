package com.example.compulsory_lab6;
import javax.swing.*;
import java.awt.event.ActionEvent;

import static java.awt.BorderLayout.CENTER;

public class ConfigPanel extends JPanel{
    final MainFrame frame;
    JLabel dotsLabel = new JLabel("Number of dots:"),
            linesLabel = new JLabel("Line probability: ");
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton = new JButton("Create New Game");;

    /**
     * Class constructor
     */
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * Class initiator: adds the dot spinner, the lines combo and the "Create" button
     */
    private void init() {
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        linesCombo = new JComboBox<Double>();
        linesCombo.addItem(1.0);
        linesCombo.addItem(0.75);
        linesCombo.addItem(0.5);
        linesCombo.addItem(0.25);

        createButton.addActionListener((ActionEvent e) -> {
            frame.canvas.createBoard();
        });

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }
}
