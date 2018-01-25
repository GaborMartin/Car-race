package com.codecool;

class Simulator{
    Simulation simulation;
    Logger logger;
    public Simulator(Simulation simulation, Logger logger){
        this.simulation = simulation;
        this.logger = logger;
    }
    public Result run(){
        Statistics stat = new Statistics(simulation.getResult());
        Result res = new Result(Statistics.getDrivers());
        stat.handleStatistics();
        return res;
    }
}