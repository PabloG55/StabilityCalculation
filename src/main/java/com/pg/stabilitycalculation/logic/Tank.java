package com.pg.stabilitycalculation.logic;
import java.sql.*;

public class Tank {
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/endeavourII_stability",
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            // Establish a connection to your database
            
            // Define the tankValue
            double tankValue = 10;

            // Call the method
            // System.out.println(CalculationUtils.calculateTotalWeight(connection, tankValue, TankConstants.MISCELLANEOUS_TANKS));
            // System.out.println(CalculationUtils.calculateTotalLCG(connection, tankValue, TankConstants.MISCELLANEOUS_TANKS));
            // System.out.println(CalculationUtils.calculateTotalMOMV1(connection, tankValue, TankConstants.MISCELLANEOUS_TANKS));
            // System.out.println(CalculationUtils.calculateTotalVCG(connection, tankValue, TankConstants.MISCELLANEOUS_TANKS));
            // System.out.println(CalculationUtils.calculateTotalMOMV2(connection, tankValue, TankConstants.MISCELLANEOUS_TANKS));
            // System.out.println(CalculationUtils.calculateTotalFS(connection, tankValue, TankConstants.MISCELLANEOUS_TANKS));
            
            //System.out.println(CalculationUtils.calculateTankWeight(connection, tankValue, TankConstants.EMERGENCY_GENERATOR_PORT));
        
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
