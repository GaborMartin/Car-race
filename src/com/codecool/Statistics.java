package com.codecool;

public class Statistics {
    private int roundsSimulated;
    private Person[] drivers;
    private static Person[] bestDrivers = new Person[1];
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";

    public Statistics(Person[] drivers) {
        this.drivers = drivers;
    }

    public void handleStatistics() {
        for (int i = 0; i < drivers.length; i++) {
            if(drivers[i].getWonRounds() > 0 || drivers[i].getSeconPlace() > 0 || drivers[i].getThirdPlace() > 0){
                Logger.log("Simple", ANSI_GREEN + drivers[i].getName()+ANSI_RESET + "'s 1st places: " + drivers[i].getWonRounds() + " / " + ANSI_RED + Simulation.getSimulationRounds() + ANSI_RESET + "\n" + /*ANSI_GREEN + drivers[i].getName()+ANSI_RESET + "'s lost rounds: " + drivers[i].getLostRounds() + " / " + ANSI_RED + Simulation.getSimulationRounds() + ANSI_RESET* +"\n"*/ ANSI_GREEN + drivers[i].getName()+ANSI_RESET+ "'s 2nd places: "+drivers[i].getSeconPlace()+" / "+ ANSI_RED + Simulation.getSimulationRounds()+ANSI_RESET+"\n"+ANSI_GREEN+drivers[i].getName()+ANSI_RESET+ "'s 3rd places: "+drivers[i].getThirdPlace()+" / "+ANSI_RED+Simulation.getSimulationRounds()+ANSI_RESET);
                Logger.log("Simple" ,"--------------------------------------");
            }
        }
        Logger.log("Simple","Best driver to vote on: ");
        Logger.log("Simple",ANSI_GREEN+bestDrivers(drivers).getName()+ANSI_RESET+" with "+ANSI_RED+bestDrivers(drivers).getRacePoints()+ANSI_RESET+" points");
    }
   /* public void printBestDrivers(){
        Logger.log("Simple","Best driver(s): ");
        for(int i = 0; i < bestDrivers.length ; i++){
            Logger.log("Simple",ANSI_GREEN +drivers[i].getName()+ANSI_RESET);
        }
    }*/
    public boolean checkWinnner(Person driver){
        if(driver.getWonRounds()>0){
            return true;
        }
        return false;
    }
    public static Person bestDrivers(Person[] drivers){
        int currentPoints = 0;
        Person bestDriver = null;
        for(int i = 0; i < drivers.length; i++){
            if(drivers[i].getRacePoints()>currentPoints){
                bestDriver = drivers[i];
            }
            /*if(drivers[i].getRacePoints() > bestDrivers[0].getRacePoints() && bestDrivers[0].getRacePoints() > 0){
                bestDrivers[0] = drivers[i];
                if(bestDrivers[0].getRacePoints() == drivers[i].getRacePoints()){
                    addBestDriversArray(drivers[i]);
                }
            }*/
        }
        return bestDriver;
    }

    public static void addBestDriversArray(Person driver) {
        Person[] tempArray = new Person[bestDrivers.length + 1];
        for (int i = 0; i < bestDrivers.length; i++) {
            tempArray[i] = bestDrivers[i];
        }
        tempArray[tempArray.length - 1] = driver;
        bestDrivers = tempArray;
    }
}