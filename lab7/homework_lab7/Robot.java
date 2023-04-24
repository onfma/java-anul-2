package org.example;

import org.example.Commands.GetTokensByRobot;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Robot implements Runnable{
    private final String name;
    private Boolean running;
    private Exploration explore;
    private int currentRow;
    private int currentCol;
    public int countExtractedTokens = 0;
    private boolean start = true;

    /**
     * Class constructor
     */
    public Robot(String name, Exploration explore){
        this.name = name;
        running = true;
        this.explore = explore;
    }

    /**
     * Robot run
     */
    @Override
    public void run() {
        while(running){
            if(start){ // se pozitionaza initial robotul pe o casuta libera din map si extrage tokens
                var ok = false;
                do {
                    currentRow = new Random().nextInt(explore.getMap().getSize());
                    currentCol = new Random().nextInt(explore.getMap().getSize());

                    if(explore.getMap().visit(currentRow, currentCol, this)){
                        ok = true; start = false;
                    }
                }while(!ok);
            }
            else{
                var accessibleCell = false;
                var count = 0;
                do {
                    count++;
                    int nextRow = currentRow + new Random().nextInt(3) - 1; // move randomly in rows (-1, 0 or 1)
                    int nextCol = currentCol + new Random().nextInt(3) - 1; // move randomly in columns (-1, 0 or 1)

                    if (nextRow >= 0 && nextRow < explore.getMap().getSize() && nextCol >= 0 && nextCol < explore.getMap().getSize()) {
                        if (explore.getMap().visit(nextRow, nextCol, this)) {
                            currentRow = nextRow;
                            currentCol = nextCol;
                            accessibleCell = true;
                        }
                    }
                }while(!accessibleCell && count<9);

                if(count == 9 && !accessibleCell) {
                    System.out.println(name + " blocked");
                    running = false;
                }
            }

            if(explore.isStopped()) {
                new GetTokensByRobot(explore);
                System.exit(1);
            }

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted.");
                running = false;
            }
        }
    }

    /**
     * Getter for the name of the robot
     */
    public String getName() {
        return name;
    }

    /**
     * Stop command for the robot
     */
    public void stop() {
        this.running = false;
    }

    public void start() {
        this.running = true;
    }

    public boolean isRunning(){
        return running;
    }

    public int getCountExtractedTokens() {
        return countExtractedTokens;
    }
}
