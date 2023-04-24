package org.example.Commands;

import org.example.Exploration;
import org.example.Robot;
import java.util.Objects;

public class Pause {

    /**
     * Pause the exploration for all the robots
     */
    public Pause(Exploration explore){
        for(Robot robot : explore.getRobots()){
            robot.stop();
        }
        System.out.println("All robots paused");
    }

    /**
     * Pause the exploration for a specific robot
     */
    public Pause(Exploration explore, String robotName){
        for(Robot robot : explore.getRobots()){
            if(Objects.equals(robot.getName(), robotName))
                robot.stop();
        }
        System.out.println(robotName + " paused");
    }
}
