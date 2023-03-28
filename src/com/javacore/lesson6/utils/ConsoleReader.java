package com.javacore.lesson6.utils;

import com.javacore.lesson6.exceptions.OutOfRangeException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleReader {

    final static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static String getString() throws IOException {
        return READER.readLine();
    }

    public static int getInt(int min, int max) throws IOException, OutOfRangeException {
        try {
            int intValue = Integer.parseInt(READER.readLine());
            if (intValue < min || intValue > max) {
                throw new OutOfRangeException("Wrong choice. Please choose exist option: \n");
            }
            return intValue;
        } catch (NumberFormatException e) {
            System.out.print("Incorrect data type. Please input Integer: \n");
            return getInt(min, max);
        }
    }

    public static int getInt() throws IOException {
        try {
            return Integer.parseInt(READER.readLine());
        } catch (NumberFormatException e) {
            System.out.print("Incorrect data type. Please input Integer: \n");
            return getInt();
        }
    }


}