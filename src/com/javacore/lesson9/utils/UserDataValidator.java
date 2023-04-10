package com.javacore.lesson9.utils;

import com.javacore.lesson9.models.RegexPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class UserDataValidator {

    final static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static String validateName(String errorMsg) throws IOException {

        String userName = READER.readLine();
        if (!Pattern.matches(RegexPattern.NAME.getText(), userName)) {
            System.out.println(errorMsg);
            return validateName(errorMsg);
        }

        return userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();

    }

    public static String validateEmail(String errorMsg) throws IOException {

        String email = READER.readLine();
        if (!Pattern.matches(RegexPattern.EMAIL.getText(), email)) {
            System.out.println(errorMsg);
            return validateEmail(errorMsg);
        }

        return email;

    }

    public static String validatePhone(String errorMsg) throws IOException {

        String phoneNumber = READER.readLine();
        if (!Pattern.matches(RegexPattern.PHONE.getText(), phoneNumber)) {
            System.out.println(errorMsg);
            return validatePhone(errorMsg);
        }

        return phoneNumber;

    }

    public static String validatePassword(String errorMsg) throws IOException {

        String password = READER.readLine();
        if (!Pattern.matches(RegexPattern.PASSWORD.getText(), password)) {
            System.out.println(errorMsg);
            return validatePassword(errorMsg);
        }

        return password;

    }

    public static void confirmPassword(String password, String errorMsg) throws IOException {

        String confirmPassword = READER.readLine();
        if (!Pattern.matches(RegexPattern.PASSWORD.getText(), password) || (!confirmPassword.equals(password))) {
            System.out.println(errorMsg);
            confirmPassword(password, errorMsg);
        }

    }


}
