package com.codecool;

class Person{
    private String name;
    private int drivingExeperience;

    public Person(String name,int drivingExeperience){
        this.name = name;
        this.drivingExeperience = drivingExeperience;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getDrivingExperience(){
        return drivingExeperience;
    }
    public void setDrivingExperience(int drivingExeperience){
        this.drivingExeperience = drivingExeperience;
    }
}