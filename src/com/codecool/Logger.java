package com.codecool;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void log(String type, String message) {
        if (type == "Timestamp") {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            System.out.println("[" + timestamp + "]" + " " + message);
        }else if (type == "Simple") {
            System.out.println(message);
        }else if (type == "Error") {
            System.out.println(ANSI_RED + message + ANSI_RESET);
        }

    }
}