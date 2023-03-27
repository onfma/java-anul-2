package com.example.compulsory_lab6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private int currentPlayer;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the imag

    final int FREE_LINE = 1;
    final int PLAYER1_LINE = 2;
    final int PLAYER2_LINE = 3;

    Map<List<Integer>, Integer> areAdjacent = new HashMap<>();


    /**
     * Class constructor
     */
    public DrawingPanel() {
        this.frame = null;
    }

    /**
     * Class constructor
     */
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    /**
     * Class initiator: this holds the action of the players (clicking on a line)
     */
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());

        currentPlayer = 0;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int lineThickness = 10;

                for(int i = 0; i < numVertices; i++) {
                    for(int j = i+1; j < numVertices; j++) {
                        if (areAdjacent.get(Stream.of(i, j).sorted().collect(Collectors.toList())) != null &&
                                areAdjacent.get(Stream.of(i, j).sorted().collect(Collectors.toList()))==1)
                        {
                            double dist = Math.abs((DrawingPanel.this.y[j] -DrawingPanel.this. y[i]) * x -
                                    (DrawingPanel.this.x[j] - DrawingPanel.this.x[i]) * y +
                                    DrawingPanel.this.x[j] * DrawingPanel.this.y[i] -
                                    DrawingPanel.this.y[j] * DrawingPanel.this.x[i]) /
                                    Math.sqrt(Math.pow(DrawingPanel.this.y[j] - DrawingPanel.this.y[i], 2)
                                            + Math.pow(DrawingPanel.this.x[j] - DrawingPanel.this.x[i], 2));

                            if (dist <= lineThickness ) {
                                currentPlayer=(currentPlayer+1)%2;
                                if(currentPlayer==1){
                                    graphics.setColor(Color.RED);
                                    areAdjacent.put(Stream.of(i, j).sorted().collect(Collectors.toList()),
                                            PLAYER1_LINE);
                                    checkWinner(1, i, j);
                                }
                                if(currentPlayer==0){
                                    graphics.setColor(Color.GREEN);
                                    areAdjacent.put(Stream.of(i, j).sorted().collect(Collectors.toList()),
                                            PLAYER2_LINE);
                                    checkWinner(2, i, j);
                                }
                                graphics.drawLine(DrawingPanel.this.x[i], DrawingPanel.this.y[i], DrawingPanel.this.x[j], DrawingPanel.this.y[j]);
                                repaint();
                                return;
                            }
                        }
                    }
                }
            }

        });
    }

    /**
     * Method that verifies if there is a winner
     */
    public void checkWinner(int playerNo, int p1, int p2){
        for(int i=0; i<numVertices;i++){
            Integer val1 = areAdjacent.get(Stream.of(i, p1).sorted().collect(Collectors.toList()));
            Integer val2 = areAdjacent.get(Stream.of(i, p2).sorted().collect(Collectors.toList()));

            if (val1 != null && val2 != null && val1 == playerNo+1 && val2 == playerNo+1) {
                announceWinner(playerNo);
            }
        }
    }

    /**
     * Method for announcing the winner
     */
    public void announceWinner(int playerNo){
        if(playerNo==1){
            graphics.setColor(Color.RED);
            graphics.fillRect(0, 0, 800, 600);
            Font font = new Font("Arial", Font.BOLD, 24);
            graphics.setFont(font);
            FontMetrics fm = graphics.getFontMetrics();
            int textWidth = fm.stringWidth("WINNER PLAYER1");
            int textHeight = fm.getHeight();

            int x = (image.getWidth() - textWidth) / 2;
            int y = (image.getHeight() - textHeight) / 2 + fm.getAscent();

            graphics.setColor(Color.BLACK);
            graphics.drawString("WINNER PLAYER2", x, y);
            graphics.dispose();
        }
        if(playerNo==2){
            graphics.setColor(Color.GREEN);
            graphics.fillRect(0, 0, 800, 600);
            Font font = new Font("Arial", Font.BOLD, 24);
            graphics.setFont(font);
            FontMetrics fm = graphics.getFontMetrics();
            int textWidth = fm.stringWidth("WINNER PLAYER2");
            int textHeight = fm.getHeight();

            int x = (image.getWidth() - textWidth) / 2;
            int y = (image.getHeight() - textHeight) / 2 + fm.getAscent();

            graphics.setColor(Color.BLACK);
            graphics.drawString("WINNER PLAYER1", x, y);
            graphics.dispose();
        }
    }


    /**
     * Sets the background of the Drawing Panel
     */
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    /**
     * Methods that gets the info from the Config Panel and then builds the graph
     */
    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        System.out.println(numVertices);
        System.out.println(edgeProbability);
        createOffscreenImage();
        createVertices();
        graphics.setColor(Color.BLACK);
        drawLines();
        drawVertices();
        repaint();
    }

    /**
     * Creates the vertices of the graph with the info from createBoard()
     */
    private void createVertices() {
        int x0 = W / 2; int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }


    /**
     * Method for drawing the lines between the dots of the graph
     */
    private void drawLines() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (Math.random() < edgeProbability) {
                    areAdjacent.put(Stream.of(i, j).sorted().collect(Collectors.toList()),
                            FREE_LINE);
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                }
                else{
                    areAdjacent.put(Stream.of(i, j).sorted().collect(Collectors.toList()),
                            0);
                }
            }
        }
    }

    /**
     * Method for drawing the dots of the graph
     */
    private void drawVertices() {
        for (int i = 0; i < numVertices; i++) {
            graphics.fillOval(x[i] - 10, y[i] - 10, 10 * 2, 10 * 2);
        }
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }


    /**
     * Method for the "Reset" button - makes all the lines black, game is starting over
     */
    public void reset(){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
        graphics.setColor(Color.BLACK);
        drawVertices();
        for(int i=0; i<numVertices;i++){
            for(int j=i+1;j<numVertices;j++){
                if( areAdjacent.get(Stream.of(i, j).sorted().collect(Collectors.toList()))!=0){
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                    areAdjacent.put(Stream.of(i, j).sorted().collect(Collectors.toList()), 1);
                }
            }
        }
        repaint();
    }

    /**
     * Method for drawing the lines between the dots of the graph
     */
    public void redraw(){
        System.out.println("redoing");
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
        graphics.setColor(Color.BLACK);
        drawVertices();
        for(int i=0; i<numVertices;i++){
            for(int j=i+1;j<numVertices;j++){
                if( areAdjacent.get(Stream.of(i, j).sorted().collect(Collectors.toList()))==1){
                    graphics.setColor(Color.BLACK);
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                }
                if( areAdjacent.get(Stream.of(i, j).sorted().collect(Collectors.toList()))==2){
                    graphics.setColor(Color.RED);
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                }
                if( areAdjacent.get(Stream.of(i, j).sorted().collect(Collectors.toList()))==3){
                    graphics.setColor(Color.GREEN);
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                }
            }
        }
        repaint();
    }

    /**
     * Loads the game from a local source
     */
    public void load(){
        try {
            FileInputStream fileIn = new FileInputStream("C:/Users/Maria/Desktop/game.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            DrawingPanel deserializedPanel = (DrawingPanel) in.readObject();
            this.graphics = deserializedPanel.graphics;
            this.x = deserializedPanel.x;
            this.y = deserializedPanel.y;
            this.areAdjacent = deserializedPanel.areAdjacent;
            this.numVertices = deserializedPanel.numVertices;
            redraw();
        } catch(IOException i) {
            System.out.println("IOException occurred");
        } catch(ClassNotFoundException c) {
            System.out.println("ClassNotFoundException occurred");
        }
    }


    /**
     * Saves the game as a local .ser file
     */
    public void save() {
        try {
            try (FileOutputStream fileOut = new FileOutputStream("C:/Users/Maria/Desktop/game.ser"); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(this);
            }
        } catch(IOException i) {
        }
    }

    /**
     * Saves the game as a local .png file
     */
    public void saveAsPNG() {
        try {
            File file = new File("C:/Users/Maria/Desktop/game.png");
            ImageIO.write(image, "png", file);
        } catch (IOException ex) {
        }
    }
}
