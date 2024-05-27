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

    public static double calculateTotalWeight(Connection connection, double tankValue, String[] tankNames) throws SQLException {
        double totalWeight = 0;
        for (String tankName : tankNames) {
            double tankWeight = calculateTankWeight(connection, tankValue, tankName);
            totalWeight += tankWeight;
        }
        return totalWeight;
    }

    public static double calculateTotalMOMV1(Connection connection, double tankValue, String[] tankNames) throws SQLException {
        double totalMOMV1 = 0;
        for (String tankName : tankNames) {
            double tankWeight = calculateTankWeight(connection, tankValue, tankName);
            double tankLCG = calculateTankLCG(connection, tankValue, tankName);
            totalMOMV1 += calculateMOMV1(tankWeight, tankLCG);
        }
        return totalMOMV1;
    }

    public static double calculateTotalMOMV2(Connection connection, double tankValue, String[] tankNames) throws SQLException {
        double totalMOMV2 = 0;
        for (String tankName : tankNames) {
            double tankWeight = calculateTankWeight(connection, tankValue, tankName);
            double tankVCG = calculateTankVCG(connection, tankValue, tankName);
            totalMOMV2 += calculateMOMV2(tankWeight, tankVCG);
        }
        return totalMOMV2;
    }

    public static double calculateTotalFS(Connection connection, double tankValue, String[] tankNames) throws SQLException {
        double totalFS = 0;
        for (String tankName : tankNames) {
            double tankFS = calculateTankFS(connection, tankValue, tankName);
            totalFS += tankFS;
        }
        return totalFS;
    }
 
    public static double calculateTotalLCG(Connection connection, double tankValue, String[] tankNames) throws SQLException {
        return calculateTotalMOMV1(connection, tankValue, tankNames) / calculateTotalWeight(connection, tankValue, tankNames);
    }

    public static double calculateTotalVCG(Connection connection, double tankValue, String[] tankNames) throws SQLException {
        return calculateTotalMOMV2(connection, tankValue, tankNames) / calculateTotalWeight(connection, tankValue, tankNames);
    }


}
