package com.example.compulsory_lab6;
import javax.swing.JFrame;
import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame{
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    /**
     * Class constructor
     */
    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    /**
     * Class initiator: adds the 3 panels (Configuration, Control, Draw)
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);

        add(canvas, CENTER);
        add(configPanel, NORTH);
        add(controlPanel, SOUTH);

        pack();
    }

}
