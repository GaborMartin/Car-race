package com.codecool;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;

class Simulation{
    
    private static Person[] drivers = Person.generateRandomDriver(20);
    private int rounds;
    private Person[] winners = new Person[0];
    private static final String CSVPATH = "../Datas/Result.csv";
    private final File file = new File(CSVPATH);

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
            handleResult(file, drivers);
            addToWinnersArray(drivers[drivers.length-1]);
            //handleResult();
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

    public void addToWinnersArray(Person driver) {
        Person[] tempArray = new Person[winners.length + 1];
        for (int i = 0; i < winners.length; i++) {
            tempArray[i] = winners[i];
        }
        tempArray[tempArray.length - 1] = driver;
        winners = tempArray;
    }

    public static void handleResult(File file, Person[] drivers) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(new File(CSVPATH), true));
            for(int i = drivers.length - 1; i > 0; i--) {
                pw.append((drivers.length - i) + "," + drivers[i].getName() + "," + drivers[i].getCar().getBrand() + "," + drivers[i].getCar().manufacturingDate() + "," + drivers[i].getCar().getHorsepower() + "\n");
            }
            pw.append((drivers.length + "," + drivers[0].getName() + "," + drivers[0].getCar().getBrand() + "," + drivers[0].getCar().manufacturingDate() + "," + drivers[0].getCar().getHorsepower()) + "\n");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}