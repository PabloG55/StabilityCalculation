package com.pg.stabilitycalculation.logic;

import java.sql.*;


public class LCGCalculation{

    public static double calculateTankLCG(Connection connection, double tankValue, String tankName) throws SQLException {
        double tankValueInMeters = tankValue / 100;
        double soundingLow = CalculationUtils.lowValue(tankValueInMeters);
        double soundingTop = CalculationUtils.topValue(tankValueInMeters);

        double lcgLow = CalculationUtils.getLCG(connection, soundingLow, tankName);
        double lcgTop = CalculationUtils.getLCG(connection, soundingTop, tankName);

        return ((lcgTop - lcgLow) / 5 * (tankValueInMeters - soundingLow) * 100) + lcgLow;
    }
}
