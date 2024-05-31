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

    public static double calculateTotalPax(double crew, double pax) {
        return crew + pax;
    }

    public static double calculatePaxWeight(double totalPax) {
        final double PAX_TO_WEIGHT = 0.075;
        return totalPax * PAX_TO_WEIGHT;
    }

    public static double calculateLuggageWeight(double luggage) {
        final double LUGGAGE_TO_WEIGHT = 0.03;
        return luggage * LUGGAGE_TO_WEIGHT;
    }

    public static void updatePax(Connection connection, double paxWeight) throws SQLException {
        String query = "UPDATE Ship_Data SET Weight = ? WHERE Description LIKE 'Passengers';";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, paxWeight);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Update successful. Rows affected: " + rowsAffected);
            } else {
                System.out.println("No rows updated for Description = 'Passengers'");
            }
        }
    }

    public static void updateLuggage(Connection connection, double luggageWeight) throws SQLException {
        String query = "UPDATE Ship_Data SET Weight = ? WHERE Description LIKE 'Luggage';";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, luggageWeight);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Update successful. Rows affected: " + rowsAffected);
            } else {
                System.out.println("No rows updated for Description = 'Passengers'");
            }
        }
    }

    public static double getTotalShipDataWeight(Connection connection) throws SQLException {
        String query = "SELECT sum(Weight) AS TotalWeight FROM ship_data;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("TotalWeight");
                } else {
                    System.out.println("No data found");
                    return 0;
                }
            }
        }
    }

    public static double getTotalShipDataMOMV1(Connection connection) throws SQLException {
        String query = "SELECT sum(MOMV1) AS TotalMOMV1 FROM ship_data;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("TotalMOMV1");
                } else {
                    System.out.println("No data found");
                    return 0;
                }
            }
        }
    }

    public static double getTotalShipDataMOMV2(Connection connection) throws SQLException {
        String query = "SELECT sum(MOMV2) AS TotalMOMV2 FROM ship_data;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("TotalMOMV2");
                } else {
                    System.out.println("No data found");
                    return 0;
                }
            }
        }
    }

    public static double calculateTotalShipWeight(double totalDataWeight, double totalTanksWeight){
       return totalDataWeight + totalTanksWeight;
    }

    public static double calculateTotalShipMOMV1(double totalDataMOMV1, double totalTanksMOMV1){
        return totalDataMOMV1 + totalTanksMOMV1;
    }

    public static double calculateTotalShipMOMV2(double totalDataMOMV2, double totalTanksMOMV2){
        return totalDataMOMV2 + totalTanksMOMV2;
    }

    public static double calculateTotalShipLCG(double totalShipWeight, double totalShipMOMV1){
        return totalShipMOMV1 / totalShipWeight;
    }

    public static double calculateTotalShipVCG(double totalShipWeight, double totalDataMOMV2){
        return totalDataMOMV2 / totalShipWeight;
    }

    public static double getLowValueDisplacement(Connection connection, double totalShipWeight, String tableRow) throws SQLException {
        String query = "SELECT * FROM Displacement WHERE DispS <= (?) ORDER BY ABS(DispS - (?)) ASC LIMIT 1;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, totalShipWeight);
            preparedStatement.setDouble(2, totalShipWeight);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble(tableRow);
                } else {
                    System.out.println("No data found for totalshipweight = " + totalShipWeight);
                    return 0;
                }
            }
        }
    } 

    public static double getTopValueDisplacement(Connection connection, double totalShipWeight, String tableRow) throws SQLException {
        double extraValue = 40;
        String query = "SELECT * FROM Displacement WHERE DispS <= (? + ?) ORDER BY ABS(DispS - (? + ?)) ASC LIMIT 1;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, totalShipWeight);
            preparedStatement.setDouble(3, totalShipWeight);
            if (tableRow.equals(TankConstants.LCB) || tableRow.equals(TankConstants.KML)){
                extraValue = 30;
            }
            preparedStatement.setDouble(2, extraValue);
            preparedStatement.setDouble(4, extraValue);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble(tableRow);
                } else {
                    System.out.println("No data found for totalshipweight = " + totalShipWeight + extraValue);
                    return 0;
                }
            }
        }    
    }

    public static double calculateLCB(Connection connection, double totalShipWeight) throws SQLException {
        double lcbLow = getLowValueDisplacement(connection, totalShipWeight, TankConstants.LCB);
        double lcbTop = getTopValueDisplacement(connection, totalShipWeight, TankConstants.LCB);
        double dispsLow = getLowValueDisplacement(connection, totalShipWeight, TankConstants.DISPS);
        double dispsTop = getTopValueDisplacement(connection, totalShipWeight, TankConstants.DISPS);

        return (lcbTop - lcbLow) * (totalShipWeight - dispsLow) / (dispsTop - dispsLow) + lcbLow; 
    }

    public static double calculateMTC(Connection connection, double totalShipWeight) throws SQLException {
        double mctLow = getLowValueDisplacement(connection, totalShipWeight, TankConstants.MCT);
        double mctTop = getTopValueDisplacement(connection, totalShipWeight, TankConstants.MCT);
        double dispsLow = getLowValueDisplacement(connection, totalShipWeight, TankConstants.DISPS);
        double dispsTop = getTopValueDisplacement(connection, totalShipWeight, TankConstants.DISPS);

        return (mctTop - mctLow) * (totalShipWeight - dispsLow) / (dispsTop - dispsLow) + mctLow; 
    }

    public static double calculateLCF(Connection connection, double totalShipWeight) throws SQLException {
        double lcfLow = getLowValueDisplacement(connection, totalShipWeight, TankConstants.LCF);
        double lcfTop = getTopValueDisplacement(connection, totalShipWeight, TankConstants.LCF);
        double dispsLow = getLowValueDisplacement(connection, totalShipWeight, TankConstants.DISPS);
        double dispsTop = getTopValueDisplacement(connection, totalShipWeight, TankConstants.DISPS);

        return (lcfLow - lcfTop) * (totalShipWeight - dispsLow) / (dispsTop - dispsLow) + lcfLow; 
    }

    public static double calculateKMT(Connection connection, double totalShipWeight) throws SQLException {
        double kmtLow = getLowValueDisplacement(connection, totalShipWeight, TankConstants.KMT);
        double kmtTop = getTopValueDisplacement(connection, totalShipWeight, TankConstants.KMT);
        double dispsLow = getLowValueDisplacement(connection, totalShipWeight, TankConstants.DISPS);
        double dispsTop = getTopValueDisplacement(connection, totalShipWeight, TankConstants.DISPS);

        return (kmtLow - kmtTop) * (totalShipWeight - dispsLow) / (dispsTop - dispsLow) + kmtTop; 
    }

    public static double calculateKML(Connection connection, double totalShipWeight) throws SQLException {
        double kmlLow = getLowValueDisplacement(connection, totalShipWeight, TankConstants.KML);
        double kmlTop = getTopValueDisplacement(connection, totalShipWeight, TankConstants.KML);
        double dispsLow = getLowValueDisplacement(connection, totalShipWeight, TankConstants.DISPS);
        double dispsTop = getTopValueDisplacement(connection, totalShipWeight, TankConstants.DISPS);

        return (kmlLow - kmlTop) * (totalShipWeight - dispsLow) / (dispsTop - dispsLow) + kmlTop; 
    }

    public static double calculateDC(Connection connection, double totalShipWeight) throws SQLException {
        double dcLow = getLowValueDisplacement(connection, totalShipWeight, TankConstants.DC);
        double dcTop = getTopValueDisplacement(connection, totalShipWeight, TankConstants.DC);
        double dispsLow = getLowValueDisplacement(connection, totalShipWeight, TankConstants.DISPS);
        double dispsTop = getTopValueDisplacement(connection, totalShipWeight, TankConstants.DISPS);

        return (dcTop - dcLow) * (totalShipWeight - dispsLow) / (dispsTop - dispsLow) + dcLow; 
    }

    public static double calculateGG(double totalShipWeight, double totalFS){
        return totalFS / totalShipWeight;
    }

    public static double calculateKG(double totalShipWeight, double totalShipMOMV2, double gg){
        return (totalShipMOMV2 / totalShipWeight) + gg;
    }

    public static double calculateGM(double kmt, double kg){
        return kmt - kg;
    }

    public static double calculateTLevel(double lcb, double lcg, double kml, double kg){
        return (56.4 * (lcg - lcb) / (kml - kg));
    }  

    public static double calculateTa(double dc, double tLevel, double lcf){
        final double LBP = 61.57;
        return dc + ((0.5 * tLevel) + (lcf * tLevel)) / LBP;
    }

    public static double calculateTf(double ta, double tLevel){
        return ta - tLevel;
    }

    public static double calculateCProa(double dc, double tLevel){
        return (dc - tLevel / 2) + 0.014;
    }

    public static double calculateCPopa(double dc, double tLevel){
        return (dc + tLevel / 2) + 0.014;
    }
    
    
}
