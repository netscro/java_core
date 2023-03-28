package com.javacore.lesson5.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    final static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static String getString() throws IOException {
        return READER.readLine();
    }

    public static int getInt() throws IOException {

        boolean isInt = false;
        int intValue = 0;

        while (!isInt) {
            String getValueFromUser = READER.readLine();
            try {
                intValue = Integer.parseInt(getValueFromUser);
                isInt = true;
            } catch (NumberFormatException e) {
                System.out.print("Incorrect data type. Please input Integer: \n");
            }
        }

        return intValue;
    }

}
