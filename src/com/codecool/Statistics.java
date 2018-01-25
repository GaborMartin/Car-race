package com.codecool;

public class Statistics {
    private static Person[] drivers;
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public Statistics(Person[] drivers) {
        this.drivers = drivers;
    }

    public void handleStatistics() {
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i].getRacePoints() > 0) {
                Logger.log("Simple" ,"[" + ANSI_YELLOW + drivers[i].getName() + ANSI_RESET + "]  " + "Exp. point: " + ANSI_YELLOW + drivers[i].getDrivingExperience() + ANSI_RESET);
                for(int j = 0; j < drivers[i].getPositions().length; j++) {
                    Logger.log("Simple", (j + 1) + ". places: " + drivers[i].getPositions()[j] + "/" + ANSI_RED + Simulation.getSimulationRounds()+ANSI_RESET);  
                }
                Logger.log("Simple", "Points: " + ANSI_BLUE+drivers[i].getRacePoints()+ANSI_RESET);
                Logger.log("Simple", "\nCar: " + "Brand: " + drivers[i].getCar().getBrand() + " (" + drivers[i].getCar().manufacturingDate() + ") Horsepower: " + drivers[i].getCar().getHorsepower() + "\n");
            }
        }
        Logger.log("Simple", "---------------------------");
        Logger.log("Simple","Best driver to vote on: ");
        Person bestDriver = bestDrivers(drivers);
        float bestDriverPercent = (float)bestDriver.getPositions()[0] / Simulation.getSimulationRounds() * 100;
        Logger.log("Simple",ANSI_GREEN + bestDriver.getName() + ANSI_RESET + " with " + ANSI_RED + bestDriver.getRacePoints() + ANSI_RESET + " points" + " " + bestDriverPercent);
        Result result = new Result(drivers);
    }
    public static Person bestDrivers(Person[] drivers){
        int currentPoints = 0;
        Person bestDriver = null;
        for(int i = 0; i < drivers.length; i++){
            if(drivers[i].getRacePoints()>currentPoints){
                bestDriver = drivers[i];
            }
        }
        return bestDriver;
    }

    public static Person[] getDrivers() {
        return drivers;
    }
}