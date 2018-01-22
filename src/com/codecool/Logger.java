package com.codecool;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    public static void log(String type, String message) {
        if (type == "Timestamp") {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            System.out.println("[" + timestamp + "]" + " " +message);
        }

    }
}