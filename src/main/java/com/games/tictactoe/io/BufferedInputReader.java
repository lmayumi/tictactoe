package com.games.tictactoe.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedInputReader {
    private static BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    public static String getInputFor(String message) {
        System.out.println(message);
        return getUserInput();
    }

    private static String getUserInput() {
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return input;
    }
}
