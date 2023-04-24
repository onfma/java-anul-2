package org.example.Commands;

import org.example.Exploration;
import org.example.Robot;

public class Stop {

    /**
     * Stop the exploration
     */
    public Stop(Exploration explore){
        for(Robot robot : explore.getRobots()){
            robot.stop();
        }
        System.out.println("All robots stopped.");
    }
}
