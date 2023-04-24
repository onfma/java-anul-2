package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.ZipEntry;

public class Exploration {
    private final Map map;
    private final SharedMemory memory;
    private final ArrayList<Robot> robots = new ArrayList<>();
    private Timekeeper timekeeper;

    /**
     * Class constructor
     */
    public Exploration(int n, int nTokens, int nRobots, int secondsTimer){
        memory = new SharedMemory(nTokens);
        map = new Map(n, this);
        initRobots(nRobots);
        timekeeper = new Timekeeper(secondsTimer * 1000, this);
    }

    /**
     * Create the robots for the exploration
     */
    private void initRobots(int nRobots){
        for(int i = 0; i < nRobots; i++){
            robots.add(new Robot("Robot_" + (i + 1), this));
        }
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

    public int getRobotsNumber(){
        return robots.size();
    }

    public ArrayList<Robot> getRobots() {
        return robots;
    }

    public Timekeeper getTimekeeper() {
        return timekeeper;
    }



    public boolean isStopped(){
        for(Robot robot : robots){
            if(robot.isRunning())
                return false;
        }
        return true;
    }


}
