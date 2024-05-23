package com.pg.stabilitycalculation.logic;
import java.sql.*;

/**
 *
 * @author pgarc
 */

public class LCGCalculation {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/endeavourII_stability",
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            // Example tank values
            double tankValue1 = 10;
            double tankValue2 = 10;
            
            final String TANK1 = "Ballast_ForePeak";
            final String TANK2 = "Ballast_no00_c";
            final String TANK3 = "";
            final String TANK4 = "";
            final String TANK5 = "";
            final String TANK6 = "";
            final String TANK7 = "";

            double weight1 = calculateTankLCG(connection, tankValue1, TANK1);
            System.out.printf("LCG for %s: %.2f mts%n", TANK1, weight1);
            
            double weight2 = calculateTankLCG(connection, tankValue2, TANK2);
            System.out.printf("LCG for %s: %.2f mts%n", TANK2, weight2);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static double calculateTankLCG(Connection connection, double tankValue, String tankName) throws SQLException {
        double tankValueInMeters = tankValue / 100;
        double soundingLow = lowValue(tankValueInMeters);
        double soundingTop = topValue(tankValueInMeters);

        double lcgLow = getLCG(connection, soundingLow, tankName);
        double lcgTop = getLCG(connection, soundingTop, tankName);

        return ((lcgTop - lcgLow) / 5 * (tankValueInMeters - soundingLow) * 100) + lcgLow;
    }

    public static double lowValue(double tankValueInMeters) {
        if (tankValueInMeters % 5 == 0) {
            return tankValueInMeters;
        } else {
            return Math.floor(tankValueInMeters * 20) / 20;
        }
    }

    public static double topValue(double tankValueInMeters) {
        if (tankValueInMeters % 5 == 0) {
            return Math.round((tankValueInMeters + 0.05) * 100.0) / 100.0;
        } else {
            return Math.floor((tankValueInMeters + 0.05) * 20) / 20;
        }
    }

    public static double getLCG(Connection connection, double soundingMeters, String tankName) throws SQLException {
        String query = "SELECT LCG FROM " + tankName + " WHERE sounding_meters = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, soundingMeters);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("LCG");
                } else {
                    System.out.println("No data found for sounding_meters = " + soundingMeters);
                    return 0;
                }
            }
        }
    }

    

}


