package com.pg.stabilitycalculation.logic;

import java.sql.*;

public class CalculationUtils {

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

    public static double getMetricTonWeight(Connection connection, double soundingMeters, String tankName) throws SQLException {
        String query = "SELECT metric_ton_weight FROM " + tankName + " WHERE sounding_meters = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, soundingMeters);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("metric_ton_weight");
                } else {
                    System.out.println("No data found for sounding_meters = " + soundingMeters);
                    return 0;
                }
            }
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

    public static double getVCG(Connection connection, double soundingMeters, String tankName) throws SQLException {
        String query = "SELECT VCG FROM " + tankName + " WHERE sounding_meters = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, soundingMeters);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("VCG");
                } else {
                    System.out.println("No data found for sounding_meters = " + soundingMeters);
                    return 0;
                }
            }
        }
    }

    public static double getFS(Connection connection, double soundingMeters, String tankName) throws SQLException {
        String query = "SELECT FSM FROM " + tankName + " WHERE sounding_meters = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, soundingMeters);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("FSM");
                } else {
                    System.out.println("No data found for sounding_meters = " + soundingMeters);
                    return 0;
                }
            }
        }
    }

    public interface TankConstants {
        // Ballast tables
        String BALLAST_FOREPEAK = "Ballast_ForePeak";
        String BALLAST_NO_00_C = "Ballast_No00_C";
        String BALLAST_NO_01_C = "Ballast_No01_C";
        String BALLAST_NO_02_C = "Ballast_No02_C";
        String BALLAST_NO_03_C = "Ballast_No03_C";
        String BALLAST_NO_04_C = "Ballast_No04_C";
        String BALLAST_NO_05_C = "Ballast_No05_C";
        String BALLAST_NO_06_C = "Ballast_No06_C";


        // Fresh water tables
        String FRESH_WATER_PORT_NO05 = "FreshWater_ManualPort_No05";
        String FRESH_WATER_MAGNETIC_PORT_NO05 = "FreshWater_MagneticPort_No05";
        String FRESH_WATER_PORT_NO06 = "FreshWater_ManualPort_No06";
        String FRESH_WATER_MAGNETIC_PORT_NO06 = "FreshWater_MagneticPort_No06";
        // Add more fresh water tanks as needed

        // Diesel oil tables
        String DIESEL_OIL_PORT_NO03 = "DieselOilPort_No03";
        String DIESEL_OIL_STARBOARD_NO03 = "DieselOilStarboard_No03";
        String DIESEL_OIL_PORT_NO04 = "DieselOilPort_No04";
        String DIESEL_OIL_STARBOARD_NO04 = "DieselOilStarboard_No04";
        String DIESEL_OIL_PORT_NO07 = "DieselOilPort_No07";
        String DIESEL_OIL_STARBOARD_NO07 = "DieselOilStarboard_No07";

        // Miscellaneous tables
        String EMERGENCY_GENERATOR_PORT = "EmergencyGenerator_Port";
        String MISCELLANEOUS_OILY_WATER_NO07_C = "Miscellaneous_OilyWater_No07_C";
        String MISCELLANEOUS_GRAY_WATER_NO08_C = "Miscellaneous_GrayWater_No08_C";
        String MISCELLANEOUS_SLUDGE_STARBOARD_NO09 = "Miscellaneous_SludgeStarboard_No09";
    }

    public static double calculateTankFS(Connection connection, double tankValue, String tankName) throws SQLException {
        double tankValueInMeters = tankValue / 100;
        double soundingLow = CalculationUtils.lowValue(tankValueInMeters);
        double soundingTop = CalculationUtils.topValue(tankValueInMeters);

        double fsLow = CalculationUtils.getFS(connection, soundingLow, tankName);
        double fsTop = CalculationUtils.getFS(connection, soundingTop, tankName);

        return ((fsTop - fsLow) / 5 * (tankValueInMeters - soundingLow) * 100) + fsLow;
    }

    public static double calculateTankLCG(Connection connection, double tankValue, String tankName) throws SQLException {
        double tankValueInMeters = tankValue / 100;
        double soundingLow = CalculationUtils.lowValue(tankValueInMeters);
        double soundingTop = CalculationUtils.topValue(tankValueInMeters);

        double lcgLow = CalculationUtils.getLCG(connection, soundingLow, tankName);
        double lcgTop = CalculationUtils.getLCG(connection, soundingTop, tankName);

        return ((lcgTop - lcgLow) / 5 * (tankValueInMeters - soundingLow) * 100) + lcgLow;
    }

    

}
