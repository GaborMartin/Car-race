package com.codecool;
import java.io.*;
import java.util.*;

class Main{
    
    public static void main(String[] args) {
        Simulation sim = new Simulation(Integer.parseInt(args[0]));
        Person[] resultTest = sim.getResult();
        Logger logger = new Logger();
        Simulator simulator = new Simulator(sim, logger);
        simulator.run();
    }
}