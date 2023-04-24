package org.example.Commands;
import org.example.Exploration;
import org.example.Robot;

import java.util.Objects;

public class Start {

    /**
     * Start the exploration
     */
    public Start(Exploration explore){
        for(Robot robot : explore.getRobots()){
            robot.start();
            new Thread(robot).start();
        }

        Thread timekeeperThread = new Thread(explore.getTimekeeper());
        timekeeperThread.setDaemon(true); // Set as daemon thread
        timekeeperThread.start();
    }

    public Start(Exploration explore, String robotName) {
        for (Robot robot : explore.getRobots()) {
            if (Objects.equals(robot.getName(), robotName)) {
                robot.start();
                new Thread(robot).start();
            }
        }
        System.out.println(robotName + " started");
    }
}
