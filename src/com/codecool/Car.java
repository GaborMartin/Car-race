package com.codecool;

public class Car {
    private String brand;
    private int horsepower;
    private boolean tuning;
    private float failurePercent;
    private int manufacturingDate;

    public Car(String brand, int horsepower, boolean tuning, float failurePercent, int manufacturingDate) {
        this.brand = brand;
        this.horsepower = horsepower;
        this.tuning = tuning;
        this.failurePercent = failurePercent;
        this.manufacturingDate = manufacturingDate;
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
}