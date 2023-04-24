package org.example.Commands;

import org.example.Exploration;
import org.example.Robot;

public class GetTokensByRobot {

    public GetTokensByRobot(Exploration explore){
        System.out.println("\nTokens extracted by each robot:\n");
        for(Robot robot : explore.getRobots()){
            System.out.println(robot.getName() + " extracted " + robot.getCountExtractedTokens() + " tokens.");
        }
    }
}
