package com.codecool;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) {
        Car[] cars = Car.generateRandomCars(50);
        for(int i = 0; i < cars.length; i++){
            System.out.println(cars[i].getBrand() + " " + cars[i].getHorsepower() + " " + cars[i].getTuning() + " " + cars[i].getFailurePercent() + " " + cars[i].manufacturingDate());
        }
    }
}