package com.codecool;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Person {
    private String name;
    private int drivingExeperience;
    private static Person[] drivers = new Person[0];
    private Car car;
    private float outcome;
    private int gridPlace;
    private float defaultOutcome;
    

    public Person(String name,int drivingExeperience) {
        this.name = name;
        this.drivingExeperience = drivingExeperience;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGridPlace(){
        return gridPlace;
    }
    public void setGridPlace(int gridPlace){
        this.gridPlace = gridPlace;
    }
    public int getDrivingExperience() {
        return drivingExeperience;
    }

    public void setDrivingExperience(int drivingExeperience) {
        this.drivingExeperience = drivingExeperience;
    }

    public Car getCar(){
        return car;
    }
    
    public float getOutcome(){
        return outcome;
    }
    public void setOutcome(float outcome){
        this.outcome = outcome;
    }
    public float getDefaultOutcome(){
        return defaultOutcome;
    }
    public static Person[] generateRandomDriver(int numOfCars) {
        String[] names = {
            "Joe",
            "Jesus",
            "Robert",
            "Matt",
            "Peter",
            "Aaron",
            "Paul",
            "Astrix",
            "Tristan",
            "Ekahal",
            "Eric",
            "Thomas",
            "Mia",
            "Jhonny",
            "Dick",
            "Steven",
            "James",
            "Matthew",
            "Jordan",
            "Chuck"};
        Random random = new Random();
        int nameIndex = 0;
        while (drivers.length < numOfCars) {
            Person driver = new Person(names[nameIndex], random.nextInt(5) + 1);
            driver.car = Car.generateRandomCar();
            driver.outcome = driver.getCar().getPerformance()+driver.drivingExeperience;
            driver.defaultOutcome = driver.outcome;
            addToDriverArray(driver);
            nameIndex ++;
        }
        shuffleDriverArray(drivers);
        return drivers;
    }

    public static void addToDriverArray(Person driver) {
        Person[] tempArray = new Person[drivers.length + 1];
        for (int i = 0; i < drivers.length; i++) {
            tempArray[i] = drivers[i];
        }
        tempArray[tempArray.length - 1] = driver;
        drivers = tempArray;
    }

    public static void shuffleDriverArray(Person[] drivers) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = drivers.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Person p = drivers[index];
            drivers[index] = drivers[i];
            drivers[i] = p;
        }
    }
}
