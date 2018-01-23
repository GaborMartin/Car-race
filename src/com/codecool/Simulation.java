package com.codecool;
class Simulation{

    static Person[] drivers = Person.generateRandomDriver(10);

    public static Person[] getResult() {
        addGridplace();
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
        return drivers;
    }

    public void generateData(){
        
    }

    public static void addGridplace() {
        for (int i = 0; i < drivers.length; i++) {
            drivers[i].setOutcome(drivers[i].getOutcome() + (drivers.length - i));
        }
    }
}