package org.example;

import java.util.ArrayList;

public class Cell {
    private ArrayList<Token> tokens;
    private boolean visited;

    /**
     * Class constructor
     */
    public Cell() {
        tokens = new ArrayList<>();
        visited = false;
    }

    public synchronized ArrayList<Token> getTokens() {
        return tokens;
    }

    /**
     * Add the tokens to the cell
     */
    public synchronized void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    /**
     * Returns the accessibility of the cell (visited or not visited)
     */
    public synchronized boolean isVisited() {
        return visited;
    }

    /**
     * Setter for visited
     */
    public synchronized void setVisited(boolean visited) {
        this.visited = visited;
    }
}
