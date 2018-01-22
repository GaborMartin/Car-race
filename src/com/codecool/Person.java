package com.codecool;
import java.util.Random;

class Person {
    private String name;
    private int drivingExeperience;
    Person[] drivers;

    public Person(String name,int drivingExeperience) {
        this.name = name;
        this.drivingExeperience = drivingExeperience;
        drivers = new Person[0];
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

    public Person[] generateRandomDriver(int numOfCars) {
        String[] names = {"Joe", "Jesus", "Robert", "Matt", "Peter", "Aaron", "Paul", "Astrix", "Tristan", "Ekahal"};
        Random random = new Random();

        while (drivers.length < numOfCars) {
            Person driver = new Person(names[random.nextInt(names.length-1)], random.nextInt(10) + 1);
            addToDriverArray(driver, drivers);
            
        }
    }

    public void addToDriverArray(Person driver, Person[] driverArray) {
        Person[] tempArray = new Person[driverArray.length + 1];
        for (int i = 0; i < driverArray.length; i++) {
            tempArray[i] = driverArray[i];
        }
        tempArray[tempArray.length - 1] = driver;
        driverArray = tempArray;
    }
}