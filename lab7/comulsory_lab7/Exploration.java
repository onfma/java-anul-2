package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.ZipEntry;

public class Exploration {
    private final Map map;
    private final SharedMemory memory;
    private final ArrayList<Robot> robots = new ArrayList<>();

    /**
     * Class constructor
     */
    public Exploration(int n, int nTokens, int nRobots){
        memory = new SharedMemory(nTokens);
        map = new Map(n, this);
        initRobots(nRobots);
    }

    /**
     * Create the robots for the exploration
     */
    private void initRobots(int nRobots){
        for(int i = 0; i < nRobots; i++){
            robots.add(new Robot("Robot " + (i + 1), this));
        }
    }

    /**
     * Start the exploration
     */
    public void start(){
        for(Robot robot : robots)
            new Thread(robot).start();
    }

    /**
     * Add a robot to the exploration
     */
    public void addRobot(Robot robot){
        robots.add(robot);
    }

    /**
     * Get the exploration map
     */
    public Map getMap() {
        return map;
    }

    /**
     * Get the exploration shared memory
     */
    public SharedMemory geSharedMemory() {
        return memory;
    }
}
