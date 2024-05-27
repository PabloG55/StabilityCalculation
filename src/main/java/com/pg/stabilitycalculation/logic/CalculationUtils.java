package com.pg.stabilitycalculation.logic;

import java.sql.*;

public class CalculationUtils {

    public static double lowValue(double tankValue, String tankName) {
        double tankValueInMeters = tankValue / 100;
        
        if (tankName.startsWith("Ballast")){
            if (tankValue % 5 == 0) {
                return tankValueInMeters;
            } else {
                return Math.floor(tankValueInMeters * 20) / 20;
            }
        } else {
            if (tankValue % 2 == 0) {
                return tankValueInMeters;
            } else {
                return Math.floor(tankValueInMeters * 50) / 50;
            }    
        }
    }

    public static double topValue(double tankValue, String tankName) {
        double tankValueInMeters = tankValue / 100;
                
        if  (tankName.startsWith("Ballast")){
            if (tankValue % 5 == 0) {
                return Math.round((tankValueInMeters + 0.05) * 100.0) / 100.0;
            } else {
                return Math.floor((tankValueInMeters + 0.05) * 20) / 20;
            }
        } else {
            if (tankValue % 2 == 0) {
                return Math.round((tankValueInMeters + 0.02) * 100.0) / 100.0;
            } else {
                return Math.floor((tankValueInMeters + 0.02) * 50) / 50;
            }           
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
        String FRESH_WATER_STARBOARD_NO05 = "FreshWater_ManualStarboard_No05";
        String FRESH_WATER_MAGNETIC_STARBOARD_NO05 = "FreshWater_MagneticStarboard_No05";
        String FRESH_WATER_PORT_NO06 = "FreshWater_ManualPort_No06";
        String FRESH_WATER_MAGNETIC_PORT_NO06 = "FreshWater_MagneticPort_No06";
        String FRESH_WATER_STARBOARD_NO06 = "FreshWater_ManualStarboard_No06";
        String FRESH_WATER_MAGNETIC_STARBOARD_NO06 = "FreshWater_MagneticStarboard_No06";

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
        double soundingTop = CalculationUtils.topValue(tankValue, tankName);
        double soundingLow = CalculationUtils.lowValue(tankValue, tankName);

        double fsLow = CalculationUtils.getFS(connection, soundingLow, tankName);
        double fsTop = CalculationUtils.getFS(connection, soundingTop, tankName);

        if (tankName.startsWith("Ballast")){
            return ((fsTop - fsLow) / 5 * (tankValueInMeters - soundingLow) * 100) + fsLow;
        } else {
            return ((fsTop - fsLow) / 2 * (tankValueInMeters - soundingLow) * 100) + fsLow;
        }
    }

    public static double calculateTankLCG(Connection connection, double tankValue, String tankName) throws SQLException {
        double tankValueInMeters = tankValue / 100;
        double soundingLow = CalculationUtils.lowValue(tankValue, tankName);
        double soundingTop = CalculationUtils.topValue(tankValue, tankName);

        double lcgLow = CalculationUtils.getLCG(connection, soundingLow, tankName);
        double lcgTop = CalculationUtils.getLCG(connection, soundingTop, tankName);

        if (tankName.startsWith("Ballast")){
            return ((lcgTop - lcgLow) / 5 * (tankValueInMeters - soundingLow) * 100) + lcgLow;  
        } else {
            return ((lcgTop - lcgLow) / 2 * (tankValueInMeters - soundingLow) * 100) + lcgLow;
        }
    }

    public static double calculateTankVCG(Connection connection, double tankValue, String tankName) throws SQLException {
        double tankValueInMeters = tankValue / 100;
        double soundingLow = CalculationUtils.lowValue(tankValue, tankName);
        double soundingTop = CalculationUtils.topValue(tankValue, tankName);

        double vcgLow = CalculationUtils.getVCG(connection, soundingLow, tankName);
        double vcgTop = CalculationUtils.getVCG(connection, soundingTop, tankName);

        if (tankName.startsWith("Ballast")){
            return ((vcgTop - vcgLow) / 5 * (tankValueInMeters - soundingLow) * 100) + vcgLow;
        } else {
            return ((vcgTop - vcgLow) / 2 * (tankValueInMeters - soundingLow) * 100) + vcgLow;
        }
    }

    public static double calculateMOMV1(double weight, double lcg) {
        return weight * lcg;
    }

    public static double calculateMOMV2(double weight, double vcg) {
        return weight * vcg;
    }  

    public static double calculateTankWeight(Connection connection, double tankValue, String tankName) throws SQLException {
        double tankValueInMeters = tankValue / 100;
        double soundingLow = CalculationUtils.lowValue(tankValue, tankName);
        double soundingTop = CalculationUtils.topValue(tankValue, tankName);

        double tonMetricLow = CalculationUtils.getMetricTonWeight(connection, soundingLow, tankName);
        double tonMetricTop = CalculationUtils.getMetricTonWeight(connection, soundingTop, tankName);
        
        if (tankName.startsWith("Ballast")){
            return ((tonMetricTop - tonMetricLow) / 5 * (tankValueInMeters - soundingLow) * 100) + tonMetricLow;
        } else {
            return ((tonMetricTop - tonMetricLow) / 2 * (tankValueInMeters - soundingLow) * 100) + tonMetricLow;
        }
    }

    public static void calculateSumOfAllTanks(Connection connection, double tankValue, String[] tankNames) throws SQLException {
        double totalWeight = 0;
        double totalMOMV1 = 0;
        double totalMOMV2 = 0;
        double totalFS = 0;
    
        for (String tankName : tankNames) {
            double tankWeight = calculateTankWeight(connection, tankValue, tankName);
            double tankLCG = calculateTankLCG(connection, tankValue, tankName);
            double tankVCG = calculateTankVCG(connection, tankValue, tankName);
            double tankFS = calculateTankFS(connection, tankValue, tankName);
            System.out.println(tankFS);
    
            totalWeight += tankWeight;
            totalMOMV1 += calculateMOMV1(tankWeight, tankLCG);
            totalMOMV2 += calculateMOMV2(tankWeight, tankVCG);
            totalFS += tankFS;
        }
    
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Total MOMV1: " + totalMOMV1);
        System.out.println("Total MOMV2: " + totalMOMV2);
        System.out.println("Total FS: " + totalFS);
    }
 

}
