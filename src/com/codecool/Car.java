package com.codecool;

import java.util.Random;
import java.util.ArrayList;

public class Car {
    private String brand;
    private int horsepower;
    private boolean tuning;
    private float failurePercent;
    private int manufacturingDate;
    private float performance;
    private static Car[] cars = new Car[0];

    public Car(String brand, int horsepower, boolean tuning, int manufacturingDate) {
        this.brand = brand;
        this.horsepower = horsepower;
        this.tuning = tuning;
        failurePercent = 0;
        this.manufacturingDate = manufacturingDate;
        performance = 0;
    }

    public String getBrand() {
        return brand;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int value) {
        horsepower = value;
    }

    public boolean getTuning() {
        return tuning;
    }

    public void setTuning() {
        tuning = true;
    }

    public float getFailurePercent() {
        return failurePercent;
    }

    public int manufacturingDate() {
        return manufacturingDate;
    }

    public float getPerformance(){
        return performance;
    }
    public void setPerformance(float performance){
        this.performance = performance;
    }
    public float calculatePerformance(){
        if(horsepower > 0 && horsepower <= 150){
            performance += 5;
        }
        else if(horsepower > 150 && horsepower <= 250){
            performance += 10;
        }
        else if(horsepower > 250 && horsepower <= 450){
            performance += 15;
        }
        else if(horsepower > 450){
            performance += 20;
        }
        if(tuning){
            performance += 8;
        }
        if (manufacturingDate < 2000) {
            performance -= 8;
        }
        return performance;
    }
    public float generateFailure(){
        if(manufacturingDate < 2000){
            failurePercent = 25;
        }
        else{
            failurePercent = 5;
        }
        return failurePercent;
    }
    public static Car generateRandomCar(){
        String[] brands = {"Nissan","BMW","Honda","Subaru","Lamborghini","Mitsubishi"};
        Random random = new Random();
        Car car = new Car(brands[random.nextInt(brands.length)],random.nextInt(600)+100,Math.random() < 0.5, 1970 + (int)(Math.random() * ((2018 - 1970) + 1)));
        car.failurePercent = car.generateFailure();
        car.performance = car.calculatePerformance();
        return car;
    }

    public static void addToCarArray(Car car) {
        Car[] tempArray = new Car[cars.length + 1];
        for (int i = 0; i < cars.length; i++) {
            tempArray[i] = cars[i];
        }
        tempArray[tempArray.length - 1] = car;
        cars = tempArray;
    }
}

/// new car method cuccminden