package org.example;

public class Main {
    public static void main(String[] args) {
        var n = 4;
        var explore = new Exploration(n, (int)Math.pow(n,3), 3);
        explore.start();
    }
}