package org.example;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Robot implements Runnable{
    private final String name;
    private Boolean running;
    private Exploration explore;
    private int currentRow;
    private int currentCol;

    /**
     * Class constructor
     */
    public Robot(String name, Exploration explore){
        this.name = name;
        running = true;
        this.explore = explore;

        // se pozitionaza initial robotul pe o casuta libera din map si extrage tokens
        var ok = false;
        do {
            currentRow = new Random().nextInt(explore.getMap().getSize());
            currentCol = new Random().nextInt(explore.getMap().getSize());

            if(explore.getMap().visit(currentRow, currentCol, this)){
                ok = true;
            }
        }while(!ok);
    }

    /**
     * Robot run
     */
    @Override
    public void run() {
        while(running){
            var ok = false;
            var count = 0;
            do {
                count++;
                int nextRow = currentRow + new Random().nextInt(3) - 1; // move randomly in rows (-1, 0 or 1)
                int nextCol = currentCol + new Random().nextInt(3) - 1; // move randomly in columns (-1, 0 or 1)

                if (nextRow >= 0 && nextRow < explore.getMap().getSize() && nextCol >= 0 && nextCol < explore.getMap().getSize()) {
                    if (explore.getMap().visit(nextRow, nextCol, this)) {
                        currentRow = nextRow;
                        currentCol = nextCol;
                        ok = true;
                    }
                }
            }while(!ok && count<9);
            if(count == 9 && !ok) {
                System.out.println(name + " blocked");
                running = false;
            }

            try {
                Thread.sleep(1000);
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
}
