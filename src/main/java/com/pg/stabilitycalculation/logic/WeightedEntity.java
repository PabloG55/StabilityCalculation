package com.pg.stabilitycalculation.logic;

public class WeightedEntity {
    private double entityValue;

    public WeightedEntity(){
    }

    public WeightedEntity(double entityValue){
        this.entityValue = entityValue;
    }

    public double getEntityValue(){
        return entityValue;
    }

    public void setEntityValue(double entityValue){
        this.entityValue = entityValue;
    }    
}
