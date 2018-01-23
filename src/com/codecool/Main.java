package com.codecool;
import java.io.*;
import java.util.*;

class Main{
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args) {
        //Person[] drivers = Person.generateRandomDriver(10);
        Person[] resultTest = Simulation.getResult();
        for(int i = 0; i < resultTest.length; i++){
            boolean tuned = resultTest[i].getCar().getTuning();
            System.out.println(resultTest[i].getName()+ ": " + resultTest[i].getCar().getBrand() + " " + resultTest[i].getCar().getHorsepower() + " " + (tuned ? ANSI_GREEN+"Tuned"+ANSI_RESET:"Not tuned" )+ " " + resultTest[i].getCar().getFailurePercent() + " " +resultTest[i].getCar().manufacturingDate()+ " "+ANSI_RED+ resultTest[i].getCar().getPerformance()+ANSI_RESET+" "+ANSI_GREEN+resultTest[i].getOutcome()+ANSI_RESET + resultTest[i].getDrivingExperience());


        }
    }
}