package com.codecool;

public class Statistics {
    int roundsSimulated;
    Person [] drivers;
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";

    public Statistics(Person[] drivers) {
        this.drivers = drivers;
    }

    public void handleStatistics() {
        for (int i = 0; i < drivers.length; i++) {
            Logger.log("Simple", ANSI_GREEN + drivers[i].getName()+ANSI_RESET + "'s won rounds: " + drivers[i].getWonRounds() + " / " + ANSI_RED + Simulation.getSimulationRounds() + ANSI_RESET + "\n" + ANSI_GREEN + drivers[i].getName()+ANSI_RESET + "'s lost rounds: " + drivers[i].getLostRounds() + " / " + ANSI_RED + Simulation.getSimulationRounds() + ANSI_RESET);
            Logger.log("Simple" ,"--------------------------------------");
        }
    }
}