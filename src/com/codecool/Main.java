package com.codecool;
import java.io.*;
import java.util.*;

class Main{
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args) {
        Car[] cars = Car.generateRandomCars(6);
        Person[] drivers = Person.generateRandomDriver(6);
        for(int i = 0; i < cars.length; i++){
            boolean tuned = cars[i].getTuning();
            System.out.println(cars[i].getBrand() + " " + cars[i].getHorsepower() + " " + (tuned ? ANSI_GREEN+"Tuned"+ANSI_RESET:"Not tuned" )+ " " + cars[i].getFailurePercent() + " " + cars[i].manufacturingDate()+ " "+ANSI_RED+ cars[i].getPerformance()+ANSI_RESET);
        }
    }
}