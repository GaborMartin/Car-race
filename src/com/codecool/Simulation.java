package com.codecool;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

class Simulation{
    private static Person[] drivers = Person.generateRandomDriver(20);
    private int rounds;
    private Person[] winners = new Person[0];
    private static final String CSVPATH = "../Datas/Result.csv";
    private final File file = new File(CSVPATH);
    private static String[] result = new String[0];
    private static int simulationRounds;

    public Simulation(int rounds){
        this.rounds = rounds;
        simulationRounds = rounds;

    }
    public int getRounds(){
        return rounds;
    }

    public static int getSimulationRounds() {
        return simulationRounds;
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
            generateData();
            drivers[drivers.length - 1].addPoint(0, 5);
            drivers[drivers.length - 2].addPoint(1, 4);
            drivers[drivers.length - 3].addPoint(2, 3);
            drivers[drivers.length - 4].addPoint(3, 2);
            drivers[drivers.length - 5].addPoint(4, 1);
            for (int l = 0; l < drivers.length -1;l++){
                if(x % (Simulation.getSimulationRounds()*0.25f) == 0){
                    Random rn = new Random();
                    int chance = rn.nextInt(101);
                    if(chance <= drivers[l].getCar().getFailurePercent()){
                        drivers[l].setOutcome(0);
                    }    
                }
            }
            addToWinnersArray(drivers[drivers.length-1]);
        }
        drivers = sortByRacePoints(drivers);
        return drivers;
    }

    public Person[] getWinners(){
        return winners;
    }

    public void generateData(){
        writeResultToFile(file, drivers);
    }

    public static void load(){
        try{
            BufferedReader in = new BufferedReader(new FileReader(CSVPATH));
            String line = "";
            while((line = in.readLine()) != null){
                addToResultArray(line);
            }
            in.close();
        }
        catch (Exception ex){

        }
    }

    public void resetOutcome(){
        for(int i = 0; i < drivers.length; i++){
            drivers[i].setOutcome(drivers[i].getDefaultOutcome());
        }
    }

    public static void addGridplace() {
        for (int i = 0; i < drivers.length; i++) {
            drivers[i].setOutcome(drivers[i].getOutcome() + ((drivers.length - i)));
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

    public static void addToResultArray(String driver) {
        String[] tempArray = new String[result.length + 1];
        for (int i = 0; i < result.length; i++) {
            tempArray[i] = result[i];
        }
        tempArray[tempArray.length - 1] = driver;
        result = tempArray;
    }
    public static void writeResultToFile(File file, Person[] drivers) {
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
    public static Person[] sortByRacePoints(Person[] drivers) {
        Person temp = null;
        for (int i = 0; i < drivers.length + 1; i++) {
                for (int j = 1; j < (drivers.length - i); j++) {
                    if (drivers[j-1].getRacePoints() > drivers[j].getRacePoints()) {
                        temp = drivers[j-1];
                        drivers[j-1] = drivers[j];
                        drivers[j] = temp;
                    }
                }
        }
        return drivers;
    }
}