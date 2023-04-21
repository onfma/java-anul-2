package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SharedMemory {
    private final int nTokens;
    public ArrayList<Token> tokens = new ArrayList<>();

    /**
     * Class constructor
     */
    public SharedMemory(int nTokens){
        this.nTokens = nTokens;
        for(int i = 1; i <= nTokens; i++)
            tokens.add(new Token(i));

        Collections.shuffle(tokens);
    }

    /**
     * Extract n tokens for each robot
     */
    public synchronized ArrayList<Token> extractTokens(int howMany) {
        ArrayList<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty())
                break;
            else{
                int index = new Random().nextInt(tokens.size());
                extracted.add(tokens.get(index));
                tokens.remove(index);
            }
        }
        return extracted;
    }
}
