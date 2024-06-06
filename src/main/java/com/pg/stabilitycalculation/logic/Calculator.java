package com.pg.stabilitycalculation.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Calculator {
//         public double getCPort(String[] ballastTanksS, String[] fwTanksS , String[] dieselTanksS, String[] miscTanksS, double[] ballastTanks, double[] fwTanks, double[] dieselTanks, double[] miscTanks) {
//         try (Connection connection = DriverManager.getConnection(System.getenv("DB_URL_ENDEAVOURII"),
//                 System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
//             double totalTanksWeightBallast = 0;
//             double totalTanksWeightDiesel = 0;
//             double totalTanksWeightFW = 0;
//             double totalTanksWeightMisc = 0; 
//             double totalTanksFSBallast = 0;
//             double totalTanksFSDiesel = 0;
//             double totalTanksFSFW = 0;
//             double totalTanksFSMisc = 0;
//             double totalTanksDieselBallast = 0;
//             double totalTanksDieselDiesel = 0;
//             double totalTanksDieselFW = 0;
//             double totalTanksDieselMisc = 0;
//             double totalTanksMiscBallast = 0;
//             double totalTanksMiscDiesel = 0;
//             double totalTanksMiscFW = 0;
//             double totalTanksMiscMisc = 0;

            
//             double totalTanksMOMV2 = 0;
//             double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
//             double totalShipMOMV2 = 0;
//             double totalTanksMOMV1 = 0;
//             double totalDataMOMV1 = CalculationUtils.getTotalShipDataMOMV1(connection);
//             double totalShipMOMV1 = 0;
//             double totalTanksWeight = 0;
//             double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
//             double totalShipWeight = 0;
//             double totalTanksFS = 0;


//             for(double tankValue1:ballastTanks){
//                 totalTanksWeight += CalculationUtils.calculateTotalWeight(connection, tankValue1, ballastTanksS);
//                 totalTanksFS += CalculationUtils.calculateTotalFS(connection, tankValue1, ballastTanksS);
//                 totalTanksMOMV1 += CalculationUtils.calculateTotalMOMV1(connection, tankValue1, ballastTanksS);
//                 totalTanksMOMV2 += CalculationUtils.calculateTotalMOMV2(connection, tankValue1, ballastTanksS);
//             }

//             for(double tankValue:fwTanks){
//                 totalTanksWeight += CalculationUtils.calculateTotalWeight(connection, tankValue, dieselTanksS);
//                 totalTanksFS += CalculationUtils.calculateTotalFS(connection, tankValue, dieselTanksS);
//                 totalTanksMOMV1 += CalculationUtils.calculateTotalMOMV1(connection, tankValue, dieselTanksS);
//                 totalTanksMOMV2 += CalculationUtils.calculateTotalMOMV2(connection, tankValue, dieselTanksS);
//             }

//             for(double tankValue:dieselTanks){
//                 totalTanksWeight += CalculationUtils.calculateTotalWeight(connection, tankValue, dieselTanksS);
//                 totalTanksFS += CalculationUtils.calculateTotalFS(connection, tankValue, dieselTanksS);
//                 totalTanksMOMV1 += CalculationUtils.calculateTotalMOMV1(connection, tankValue, dieselTanksS);
//                 totalTanksMOMV2 += CalculationUtils.calculateTotalMOMV2(connection, tankValue, dieselTanksS);
//             }

//             totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);
//             totalShipMOMV1 = CalculationUtils.calculateTotalShipMOMV1(totalDataMOMV1, totalTanksMOMV1);
//             totalShipMOMV2 = CalculationUtils.calculateTotalShipMOMV2(totalDataMOMV2, totalTanksMOMV2);
            
//             double gg = CalculationUtils.calculateGG(totalShipWeight, totalTanksFS);
//             double dc = CalculationUtils.calculateDC(connection, totalShipWeight);
//             double lcb = CalculationUtils.calculateLCB(connection, totalShipWeight);
//             double lcg = CalculationUtils.calculateTotalShipLCG(totalShipWeight, totalShipMOMV1);
//             double kml = CalculationUtils.calculateKML(connection, totalShipWeight);
//             double kg = CalculationUtils.calculateKG(totalShipWeight, totalShipMOMV2, gg);
//             double tLevel = CalculationUtils.calculateTLevel(lcb, lcg, kml, kg);
            
//             return CalculationUtils.calculateCProa(dc, tLevel);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return 0;
//         }   
//     }

//     public double getCStarboard(String[] ballastTanksS, String[] fwTanksS , String[] dieselTanksS, String[] miscTanksS, double[] ballastTanks, double[] fwTanks, double[] dieselTanks, double[] miscTanks) {
//         try (Connection connection = DriverManager.getConnection("DB_URL_ENDEAVOURII",
//                 System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
//             double totalTanksMOMV2 = 0;
//             double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
//             double totalShipMOMV2 = 0;
//             double totalTanksMOMV1 = 0;
//             double totalDataMOMV1 = CalculationUtils.getTotalShipDataMOMV1(connection);
//             double totalShipMOMV1 = 0;
//             double totalTanksWeight = 0;
//             double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
//             double totalShipWeight = 0;
//             double totalTanksFS = 0;


//             for(double tankValue:tankValues){
//                 totalTanksWeight += CalculationUtils.calculateTotalWeight(connection, tankValue, tanks);
//                 totalTanksFS += CalculationUtils.calculateTotalFS(connection, tankValue, tanks);
//                 totalTanksMOMV1 += CalculationUtils.calculateTotalMOMV1(connection, tankValue, tanks);
//                 totalTanksMOMV2 += CalculationUtils.calculateTotalMOMV2(connection, tankValue, tanks);
//             }

//             totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);
//             totalShipMOMV1 = CalculationUtils.calculateTotalShipMOMV1(totalDataMOMV1, totalTanksMOMV1);
//             totalShipMOMV2 = CalculationUtils.calculateTotalShipMOMV2(totalDataMOMV2, totalTanksMOMV2);
            
//             double gg = CalculationUtils.calculateGG(totalShipWeight, totalTanksFS);
//             double dc = CalculationUtils.calculateDC(connection, totalShipWeight);
//             double lcb = CalculationUtils.calculateLCB(connection, totalShipWeight);
//             double lcg = CalculationUtils.calculateTotalShipLCG(totalShipWeight, totalShipMOMV1);
//             double kml = CalculationUtils.calculateKML(connection, totalShipWeight);
//             double kg = CalculationUtils.calculateKG(totalShipWeight, totalShipMOMV2, gg);
//             double tLevel = CalculationUtils.calculateTLevel(lcb, lcg, kml, kg);
            
//             return CalculationUtils.calculateCPopa(dc, tLevel);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return 0;
//         }   
//     }

    public double getKM(String[] ballastTanksS, String[] fwTanksS , String[] dieselTanksS, String[] miscTanksS, double[] ballastTanks, double[] fwTanks, double[] dieselTanks, double[] miscTanks) {
        try (Connection connection = DriverManager.getConnection(System.getenv("DB_URL_ENDEAVOURII"),
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
        double totalTanksWeightBallast = 0;
        double totalTanksWeightDiesel = 0;
        double totalTanksWeightFW = 0;
        double totalTanksWeightMisc = 0;

        // Calculate the weight for ballast tanks
        for (int i = 0; i < ballastTanks.length; i++) {
            totalTanksWeightBallast += CalculationUtils.calculateTankWeight(connection, ballastTanks[i], ballastTanksS[i]);
        }

        // Calculate the weight for diesel tanks
        for (int i = 0; i < dieselTanks.length; i++) {
            totalTanksWeightDiesel += CalculationUtils.calculateTankWeight(connection, dieselTanks[i], dieselTanksS[i]);
        }

        // Calculate the weight for freshwater tanks
        for (int i = 0; i < fwTanks.length; i++) {
            totalTanksWeightFW += CalculationUtils.calculateTankWeight(connection, fwTanks[i], fwTanksS[i]);
        }

        // Calculate the weight for miscellaneous tanks
        for (int i = 0; i < miscTanks.length; i++) {
            totalTanksWeightMisc += CalculationUtils.calculateTankWeight(connection, miscTanks[i], miscTanksS[i]);
        }

        // Sum the weights of all tanks
        double totalTanksWeight = totalTanksWeightBallast + totalTanksWeightDiesel + totalTanksWeightFW + totalTanksWeightMisc;

        // Get the total ship data weight and calculate the total ship weight
        double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
        double totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);

        // Calculate and return the KM value
        return CalculationUtils.calculateKMT(connection, totalShipWeight);
    } catch (SQLException e) {
        e.printStackTrace();
        return 0;
    }
}

//     public double getKG(String[] ballastTanksS, String[] fwTanksS , String[] dieselTanksS, String[] miscTanksS, double[] ballastTanks, double[] fwTanks, double[] dieselTanks, double[] miscTanks) {
//         try (Connection connection = DriverManager.getConnection("DB_URL_ENDEAVOURII",
//                 System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
//             double totalTanksMOMV2 = 0;
//             double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
//             double totalShipMOMV2 = 0;
//             double totalTanksWeight = 0;
//             double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
//             double totalShipWeight = 0;
//             double totalTanksFS = 0;


//             for(double tankValue:tankValues){
//                 totalTanksWeight += CalculationUtils.calculateTotalWeight(connection, tankValue, tanks);
//                 totalTanksFS += CalculationUtils.calculateTotalFS(connection, tankValue, tanks);
//                 totalTanksMOMV2 += CalculationUtils.calculateTotalMOMV2(connection, tankValue, tanks);
//             }

//             totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);
//             totalShipMOMV2 = CalculationUtils.calculateTotalShipMOMV2(totalDataMOMV2, totalTanksMOMV2);
            
//             double gg = CalculationUtils.calculateGG(totalShipWeight, totalTanksFS);

//             return CalculationUtils.calculateKG(totalShipWeight, totalShipMOMV2, gg);

//         } catch (SQLException e) {
//             e.printStackTrace();
//             return 0;
//         }   
//     }

//     public double getGM(String[] ballastTanksS, String[] fwTanksS , String[] dieselTanksS, String[] miscTanksS, double[] ballastTanks, double[] fwTanks, double[] dieselTanks, double[] miscTanks) {
//         try (Connection connection = DriverManager.getConnection("DB_URL_ENDEAVOURII",
//                 System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
//             double totalTanksMOMV2 = 0;
//             double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
//             double totalShipMOMV2 = 0;
//             double totalTanksWeight = 0;
//             double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
//             double totalShipWeight = 0;
//             double totalTanksFS = 0;


//             for(double tankValue:ballastTanks){
//                 totalTanksWeight += CalculationUtils.calculateTotalWeight(connection, tankValue, tanks);
//                 totalTanksFS += CalculationUtils.calculateTotalFS(connection, tankValue, tanks);
//                 totalTanksMOMV2 += CalculationUtils.calculateTotalMOMV2(connection, tankValue, tanks);
//             }

//             totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);
//             totalShipMOMV2 = CalculationUtils.calculateTotalShipMOMV2(totalDataMOMV2, totalTanksMOMV2);
            
//             double gg = CalculationUtils.calculateGG(totalShipWeight, totalTanksFS);
//             double kg = CalculationUtils.calculateKG(totalShipWeight, totalShipMOMV2, gg);
//             double kmt = CalculationUtils.calculateKMT(connection, totalShipWeight);

//             return CalculationUtils.calculateGM(kmt, kg);            
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return 0;
//         }   
//     }

}
