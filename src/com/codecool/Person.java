package com.codecool;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Person {
    private String name;
    private int drivingExeperience;
    private static Person[] drivers = new Person[0];
    private Car car;
    private float outcome;
    

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
    public static Person[] generateRandomDriver(int numOfCars) {
        String[] names = {"Joe", "Jesus", "Robert", "Matt", "Peter", "Aaron", "Paul", "Astrix", "Tristan", "Ekahal"};
        Random random = new Random();

        while (drivers.length < numOfCars) {
            Person driver = new Person(names[random.nextInt(names.length-1)], random.nextInt(10) + 1);
            driver.car = Car.generateRandomCar();
            driver.outcome = driver.getCar().getPerformance()+driver.drivingExeperience;
            addToDriverArray(driver);
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
