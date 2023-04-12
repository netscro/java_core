package com.javacore.lesson9.models;

public enum RegexPattern {

    NAME("^[a-zA-Z]{3,256}$"),
    EMAIL("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$"),
    PHONE("^\\d{9,11}$"),
    PASSWORD("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*#\\?&\\.\\/-])[A-Za-z\\d@$!%*#\\?&\\.\\/-]{8,}$");

    private String text;

    RegexPattern(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

}
