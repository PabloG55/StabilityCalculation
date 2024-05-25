package com.pg.stabilitycalculation.logic;

import java.sql.*;

public class WeightCalculation {
    
    public static double calculateTankWeight(Connection connection, double tankValue, String tankName) throws SQLException {
        double tankValueInMeters = tankValue / 100;
        double soundingLow = CalculationUtils.lowValue(tankValueInMeters);
        double soundingTop = CalculationUtils.topValue(tankValueInMeters);

        double tonMetricLow = CalculationUtils.getMetricTonWeight(connection, soundingLow, tankName);
        double tonMetricTop = CalculationUtils.getMetricTonWeight(connection, soundingTop, tankName);

        return ((tonMetricTop - tonMetricLow) / 5 * (tankValueInMeters - soundingLow) * 100) + tonMetricLow;
    }
}
