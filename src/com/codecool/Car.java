package com.codecool;

import java.util.Random;
import java.util.ArrayList;

public class Car {
    private String brand;
    private int horsepower;
    private boolean tuning;
    private int failurePercent;
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

    public int getFailurePercent() {
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
        if(horsepower > 99 && horsepower <= 110){
            performance += 2;
        }
        else if(horsepower > 110 && horsepower <= 130){
            performance += 5;
        }
        else if(horsepower > 130 && horsepower <= 150){
            performance += 7;
        }
        else if(horsepower > 150 && horsepower <= 170){
            performance += 9;
        }
        else if(horsepower > 170 && horsepower <= 190){
            performance += 11;
        }
        else if(horsepower > 190 && horsepower <= 210){
            performance += 14;
        }
        else if(horsepower > 210){
            performance += 17;
        }
        if(tuning){
            if(manufacturingDate <= 2000){
                performance += 10;
            }else{
                performance += 6;
            }
        }
        if (manufacturingDate < 2000) {
            performance -= 4.3;
        }
        return performance;
    }
    public int generateFailure(){
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
        Car car = new Car(brands[random.nextInt(brands.length)],random.nextInt(150)+100,Math.random() < 0.5, 1970 + (int)(Math.random() * ((2018 - 1970) + 1)));
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
