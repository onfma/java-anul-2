package org.example;

import org.example.Commands.GetTokensByRobot;

public class Map {
    private final Cell[][] matrix;
    private int cellsToVisit;
    private final Exploration explore;
    private final int nTokensToExtract;

    /**
     * Class constructor
     */
    public Map(int size, Exploration explore) {
        this.explore = explore;
        nTokensToExtract = size;
        matrix = new Cell[size][size];
        cellsToVisit = size * size;

        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                matrix[row][col] = new Cell();
                matrix[row][col].setTokens(null);
            }
        }
    }

    /**
     * Visits the cell at the specified row and column with the specified robot
     */
    public synchronized boolean visit(int row, int col, Robot robot){
        if(!matrix[row][col].isVisited()){
            var extractedTokens = explore.geSharedMemory().extractTokens(nTokensToExtract);
            matrix[row][col].setTokens(extractedTokens);
            matrix[row][col].setVisited(true);
            cellsToVisit--;
            robot.countExtractedTokens+=nTokensToExtract;
            System.out.println(robot.getName() + " visited cell [" + row + "," + col + "] and extracted " + nTokensToExtract + " tokens.");

            if(cellsToVisit == 0){
                System.out.println("Exploration completed! \n\n");
                new GetTokensByRobot(explore);
                System.exit(1);
            }
            return true;
        }
        return false;
    }

    /**
     * Getter for the size of the map (matrix)
     */
    public int getSize() {
        return matrix.length;
    }
}
