package org.example;
import org.example.Commands.Pause;
import org.example.Commands.Start;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var n = 6;
        var explore = new Exploration(n, (int)Math.pow(n,3), 3, 20);
        new Start(explore);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a command (start/pause <name>):");
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("start")) {
                System.out.println("starting robot" + Arrays.toString(command));
                if(command.length == 1){
                    new Start(explore);
                }
                else if(command.length == 2){
                    String name = command[1];
                    new Start(explore, name);
                }
            }
            else if(command[0].equals("pause")) {
                System.out.println("pause robot" + Arrays.toString(command));
                if(command.length == 2) {
                    String name = command[1];
                    new Pause(explore, name);
                }
                else if(command.length == 1){
                    new Pause(explore);
                }
            }
            else {
                System.out.println("Invalid command" + Arrays.toString(command));
            }
        }
    }
}