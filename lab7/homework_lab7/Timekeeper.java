package org.example;

import org.example.Commands.GetTokensByRobot;
import org.example.Commands.Stop;

public class Timekeeper implements Runnable {
    private final int timeLimit;
    private final long startTime;
    private boolean running;
    private final Exploration explore;

    public Timekeeper(int timeLimit, Exploration explore) {
        this.timeLimit = timeLimit;
        this.startTime = System.currentTimeMillis();
        this.running = true;
        this.explore = explore;
    }

    public void stop() {
        this.running = false;
    }

    @Override
    public void run() {
        while (running) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            System.out.println("Elapsed time: " + elapsedTime + " ms");

            if (elapsedTime >= timeLimit) {
                stop();
                System.out.println("Time limit exceeded. Stopping exploration.");
                new Stop(explore);
                new GetTokensByRobot(explore);
            }

            try {
                Thread.sleep(2500); // Sleep for 2.5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
