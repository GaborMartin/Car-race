package com.codecool;

public class Statistics {
    private int roundsSimulated;
    private Person[] drivers;
    private static Person[] bestDrivers = new Person[1];
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
                    Logger.log("Simple", (j + 1) + ". places: " + drivers[i].getPositions()[j] + "/" + ANSI_RED + Simulation.getSimulationRounds() + ANSI_RESET);  
                }
                Logger.log("Simple", "\nCar: " + "Brand: " + drivers[i].getCar().getBrand() + " (" + drivers[i].getCar().manufacturingDate() + ") Horsepower: " + drivers[i].getCar().getHorsepower() + "\n");
                
            }
        }
        Logger.log("Simple", "---------------------------");
        Logger.log("Simple","Best driver to vote on: ");
        Person bestDriver = bestDrivers(drivers);
        Logger.log("Simple",ANSI_GREEN+bestDriver.getName()+ANSI_RESET+" with "+ANSI_RED+bestDriver.getRacePoints()+ANSI_RESET+" points");
    }
   /* public void printBestDrivers(){
        Logger.log("Simple","Best driver(s): ");
        for(int i = 0; i < bestDrivers.length ; i++){
            Logger.log("Simple",ANSI_GREEN +drivers[i].getName()+ANSI_RESET);
        }
    }*/
     /*public boolean checkWinnner(Person driver){
        if(driver.getWonRounds()>0){
            return true;
        }
        return false;
    }
    */
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
}