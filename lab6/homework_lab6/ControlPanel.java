package com.example.compulsory_lab6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");

    /**
     * Class constructor
     */
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * Class initiator: loads the buttons
     */
    private void init() {
        JPanel container = new JPanel();
        GridLayout layout = new GridLayout(1, 4);
        layout.setHgap(10);
        container.setLayout(layout);

        container.add(loadBtn);
        container.add(saveBtn);
        container.add(resetBtn);
        container.add(exitBtn);
        add(container);

        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
        exitBtn.addActionListener(this::exitGame);
    }

    /**
     * Action for clicking on the "Reset" button
     */
    private void resetGame(ActionEvent actionEvent) {
        frame.canvas.reset();
    }

    /**
     * Action for clicking on the "Save" button
     */
    private void saveGame(ActionEvent actionEvent) {
        frame.canvas.save();
        frame.canvas.saveAsPNG();
    }

    /**
     * Action for clicking on the "Load" button
     */
    private void loadGame(ActionEvent actionEvent) {
        frame.canvas.load();
    }

    /**
     * Action for clicking on the "Exit" button
     */
    private void exitGame(java.awt.event.ActionEvent actionEvent) {
        frame.dispose();
    }
    

}
