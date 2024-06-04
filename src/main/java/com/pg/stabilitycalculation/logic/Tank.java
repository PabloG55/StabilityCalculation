package com.pg.stabilitycalculation.logic;

public class Tank {
    private double tankValue;

    public Tank(){
    }

    public Tank(double tankValue){
        this.tankValue = tankValue;
    }

    public double getTankValue(){
        return tankValue;
    }

    public void setTankValue(double tankValue){
        this.tankValue = tankValue;
    }
}
