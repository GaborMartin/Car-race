package com.codecool;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) {
        
        if(args.length < 1){
            Logger.log("Error","Type in the number of rounds");
            System.exit(1);
        }
        Simulation sim = new Simulation(Integer.parseInt(args[0]));
        Person[] resultTest = sim.getResult();
        Statistics stat = new Statistics(resultTest);
        stat.handleStatistics();

        //Simulation.load(); 
    }
}