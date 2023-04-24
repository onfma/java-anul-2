package org.example;

public class Token {
    private final int value;

    /**
     * Class constructor
     */
    public Token(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token: " + value;
    }
}
