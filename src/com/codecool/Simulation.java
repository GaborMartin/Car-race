package com.codecool;
class Simulation{

    private static Person[] drivers = Person.generateRandomDriver(20);
    private int rounds;
    private Person[] winners = new Person[0];
    public Simulation(int rounds){
        this.rounds = rounds;

    }
    public int getRounds(){
        return rounds;
    }
    public Person[] getResult() {
        for (int x = 0 ; x < getRounds() ; x++){
            resetOutcome();
            addGridplace();
            Person.shuffleDriverArray(drivers);
            Person temp = null;
            for (int i = 0; i < drivers.length + 1; i++) {
                for (int j = 1; j < (drivers.length - i); j++) {
                    if (drivers[j-1].getOutcome() > drivers[j].getOutcome()) {
                        temp = drivers[j-1];
                        drivers[j-1] = drivers[j];
                        drivers[j] = temp;
                    }
                }
            }
            addToArray(drivers[drivers.length-1]);
        }
        return drivers;
    }

    public Person[] getWinners(){
        return winners;
    }

    public void generateData(){
        
    }

    public void resetOutcome(){
        for(int i = 0; i < drivers.length; i++){
            drivers[i].setOutcome(drivers[i].getDefaultOutcome());
        }
    }

    public static void addGridplace() {
        for (int i = 0; i < drivers.length; i++) {
            drivers[i].setOutcome(drivers[i].getOutcome() + (drivers.length - i));
        }
    }

    public void addToArray(Person driver) {
        Person[] tempArray = new Person[winners.length + 1];
        for (int i = 0; i < winners.length; i++) {
            tempArray[i] = winners[i];
        }
        tempArray[tempArray.length - 1] = driver;
        winners = tempArray;
    }
}