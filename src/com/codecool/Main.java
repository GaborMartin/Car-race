package com.codecool;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) {
        //Person[] drivers = Person.generateRandomDriver(10);
        
        Simulation sim = new Simulation(50);
        //Statistics stat2 = new Statistics(resultTest);
        //stat.handleStatistics();
        Person[] resultTest = sim.getResult();
        Statistics stat = new Statistics(resultTest);
        stat.handleStatistics();
        /*Person[] winners = sim.getWinners();
        for(int i = 0; i < resultTest.length; i++){
            boolean tuned = resultTest[i].getCar().getTuning();
            System.out.println(resultTest[i].getName()+ ": " + resultTest[i].getCar().getBrand() + " " + resultTest[i].getCar().getHorsepower() + " " + (tuned ? ANSI_GREEN+"Tuned"+ANSI_RESET:"Not tuned" )+ " " + resultTest[i].getCar().getFailurePercent() + " " +resultTest[i].getCar().manufacturingDate()+ " "+ANSI_RED+ resultTest[i].getCar().getPerformance()+ANSI_RESET+" "+ANSI_GREEN+resultTest[i].getOutcome()+ANSI_RESET + resultTest[i].getDrivingExperience());
        }
        System.out.println("----------------------------------------");
        for(int y = 0; y < winners.length; y++){
            System.out.println(winners[y].getName()+ ": " + winners[y].getCar().getBrand() + " " + ANSI_GREEN + winners[y].getCar().getHorsepower()+ANSI_RESET);
            
        }
        System.out.println("----------------------------------------");
        Simulation.load(); */
    }
}