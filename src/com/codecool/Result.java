package com.codecool;
class Result{
    Person [] finishingOrder;
    public Result(Person[] finishingOrder){
        this.finishingOrder = finishingOrder;
    }
    public Person[] getFinishingOrder(){
        return finishingOrder;
    }
}