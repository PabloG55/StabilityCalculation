package com.pg.stabilitycalculation.logic;

public class Controller {
    private Tank[] ballastTanks;
    private Tank[] freshwaterTanks;
    private Tank[] dieselTanks;
    private Tank[] miscTanks;
    private WeightedEntity crewValue;
    private WeightedEntity luggageValue;
    private WeightedEntity paxValue;

    public double[] getBallastTankValues() {
        double[] values = new double[ballastTanks.length];
        for (int i = 0; i < ballastTanks.length; i++) {
            values[i] = ballastTanks[i].getTankValue();
        }
        return values;
    }

    public double[] getFreshwaterTankValues() {
        double[] values = new double[freshwaterTanks.length];
        for (int i = 0; i < freshwaterTanks.length; i++) {
            values[i] = freshwaterTanks[i].getTankValue();
        }
        return values;
    }

    public double[] getDieselTankValues() {
        double[] values = new double[dieselTanks.length];
        for (int i = 0; i < dieselTanks.length; i++) {
            values[i] = dieselTanks[i].getTankValue();
        }
        return values;
    }

    public double[] getMiscTankValues() {
        double[] values = new double[miscTanks.length];
        for (int i = 0; i < miscTanks.length; i++) {
            values[i] = miscTanks[i].getTankValue();
        }
        return values;
    }

    public WeightedEntity getCrewValue() {
        return crewValue;
    }

    public WeightedEntity getPaxValue() {
        return paxValue;
    }

    public WeightedEntity getLuggageValue() {
        return luggageValue;
    }

    public void setBallastTanks(double[] ballastValues) {
        ballastTanks = new Tank[ballastValues.length];
        for (int i = 0; i < ballastValues.length; i++) {
            ballastTanks[i] = new Tank(ballastValues[i]);
        }
    }

    public void setFreshwaterTanks(double[] freshwaterValues) {
        freshwaterTanks = new Tank[freshwaterValues.length];
        for (int i = 0; i < freshwaterValues.length; i++) {
            freshwaterTanks[i] = new Tank(freshwaterValues[i]);
        }
    }

    public void setDieselTanks(double[] dieselValues) {
        dieselTanks = new Tank[dieselValues.length];
        for (int i = 0; i < dieselValues.length; i++) {
            dieselTanks[i] = new Tank(dieselValues[i]);
        }
    }

    public void setMiscTanks(double[] miscValues) {
        miscTanks = new Tank[miscValues.length];
        for (int i = 0; i < miscValues.length; i++) {
            miscTanks[i] = new Tank(miscValues[i]);
        }
    }

    public void setWeightedEntities(double crewNo, double luggageNo, double paxNo) {
        crewValue = new WeightedEntity(crewNo);
        luggageValue = new WeightedEntity(luggageNo);
        paxValue = new WeightedEntity(paxNo);
    }
}
