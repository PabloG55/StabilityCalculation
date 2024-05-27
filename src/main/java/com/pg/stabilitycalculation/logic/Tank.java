package com.pg.stabilitycalculation.logic;
import java.sql.*;

import com.pg.stabilitycalculation.logic.CalculationUtils.TankConstants;

public class Tank {
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/endeavourII_stability",
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            // Establish a connection to your database
            
            // Define the tankValue
            double tankValue = 15;
            double tankValueInMeters = tankValue /100 ;
            String tankName = "FreshWater_ManualPort_No05";        
            // Define an array of tank names
            String[] tankNames = {
                TankConstants.FRESH_WATER_PORT_NO05,
    TankConstants.FRESH_WATER_MAGNETIC_PORT_NO05,
    TankConstants.FRESH_WATER_STARBOARD_NO05,
    TankConstants.FRESH_WATER_MAGNETIC_STARBOARD_NO05,
    TankConstants.FRESH_WATER_PORT_NO06,
    TankConstants.FRESH_WATER_MAGNETIC_PORT_NO06,
    TankConstants.FRESH_WATER_STARBOARD_NO06,
    TankConstants.FRESH_WATER_MAGNETIC_STARBOARD_NO06
            };

            // Call the method
            CalculationUtils.calculateSumOfAllTanks(connection, tankValue, tankNames);
            
            //System.out.println(CalculationUtils.calculateTankFS(connection, tankValue, TankConstants.FRESH_WATER_PORT_NO06));
        
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
