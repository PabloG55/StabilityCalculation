package com.pg.stabilitycalculation.logic;

import java.sql.*;

public class VCGCalculation {

        public static double calculateTankLCG(Connection connection, double tankValue, String tankName) throws SQLException {
        double tankValueInMeters = tankValue / 100;
        double soundingLow = CalculationUtils.lowValue(tankValueInMeters);
        double soundingTop = CalculationUtils.topValue(tankValueInMeters);

        double vcgLow = CalculationUtils.getVCG(connection, soundingLow, tankName);
        double vcgTop = CalculationUtils.getVCG(connection, soundingTop, tankName);

        return ((vcgTop - vcgLow) / 5 * (tankValueInMeters - soundingLow) * 100) + vcgLow;
    }
}
