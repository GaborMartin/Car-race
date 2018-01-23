package com.codecool;
import java.io.*;
import java.util.*;

class Main{
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args) {
        Person[] drivers = Person.generateRandomDriver(500);
        for(int i = 0; i < drivers.length; i++){
            boolean tuned = drivers[i].getCar().getTuning();
            System.out.println(drivers[i].getName()+ ": " + drivers[i].getCar().getBrand() + " " + drivers[i].getCar().getHorsepower() + " " + (tuned ? ANSI_GREEN+"Tuned"+ANSI_RESET:"Not tuned" )+ " " + drivers[i].getCar().getFailurePercent() + " " +drivers[i].getCar().manufacturingDate()+ " "+ANSI_RED+ drivers[i].getCar().getPerformance()+ANSI_RESET+" "+ANSI_GREEN+drivers[i].getOutcome()+ANSI_RESET);
        }
    }
}