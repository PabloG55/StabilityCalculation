package com.pg.stabilitycalculation.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Calculator extends CalculatorUtils{
        public double getCPort(String[] ballastTanksS, String[] fwTanksS , String[] dieselTanksS, String[] miscTanksS, double[] ballastTanks, double[] fwTanks, double[] dieselTanks, double[] miscTanks) {
        try (Connection connection = DriverManager.getConnection(System.getenv("DB_URL_ENDEAVOURII"),
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
            double totalTanksWeightBallast = getTotalTanksWeightBallast(connection, ballastTanks, ballastTanksS);
            double totalTanksWeightDiesel = getTotalTanksWeightDiesel(connection, dieselTanks, dieselTanksS);
            double totalTanksWeightFW = getTotalTanksWeightFW(connection, fwTanks, fwTanksS);
            double totalTanksWeightMisc = getTotalTanksWeightMisc(connection, miscTanks, miscTanksS);

            double totalTanksFSBallast = getTotalTanksFSBallast(connection, ballastTanks, ballastTanksS);
            double totalTanksFSDiesel = getTotalTanksFSDiesel(connection, dieselTanks, dieselTanksS);
            double totalTanksFSFW = getTotalTanksFSFW(connection, fwTanks, fwTanksS);
            double totalTanksFSMisc = getTotalTanksFSMisc(connection, miscTanks, miscTanksS);

            double totalTanksMOMV1Ballast = getTotalTanksMOMV1Ballast(connection, ballastTanks, ballastTanksS);
            double totalTanksMOMV1Diesel = getTotalTanksMOMV1Diesel(connection, dieselTanks, dieselTanksS);
            double totalTanksMOMV1FW = getTotalTanksMOMV1FW(connection, fwTanks, fwTanksS);
            double totalTanksMOMV1Misc = getTotalTanksMOMV1Misc(connection, miscTanks, miscTanksS);

            double totalTanksMOMV2Ballast = getTotalTanksMOMV2Ballast(connection, ballastTanks, ballastTanksS);
            double totalTanksMOMV2Diesel = getTotalTanksMOMV2Diesel(connection, dieselTanks, dieselTanksS);
            double totalTanksMOMV2FW = getTotalTanksMOMV2FW(connection, fwTanks, fwTanksS);
            double totalTanksMOMV2Misc = getTotalTanksMOMV2Misc(connection, miscTanks, miscTanksS);

            double totalTanksWeight = sum4Values(totalTanksWeightBallast, totalTanksWeightDiesel, totalTanksWeightFW, totalTanksWeightMisc);
            double totalTanksFS = sum4Values(totalTanksFSBallast, totalTanksFSDiesel, totalTanksFSFW, totalTanksFSMisc);
            double totalTanksMOMV1 = sum4Values(totalTanksMOMV1Ballast, totalTanksMOMV1Diesel, totalTanksMOMV1FW, totalTanksMOMV1Misc);
            double totalTanksMOMV2 = sum4Values(totalTanksMOMV2Ballast, totalTanksMOMV2Diesel, totalTanksMOMV2FW, totalTanksMOMV2Misc);

            double totalShipWeight;
            double totalShipMOMV2;
            double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
            double totalShipMOMV1;
            double totalDataMOMV1 = CalculationUtils.getTotalShipDataMOMV1(connection);
            double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
            totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);
            totalShipMOMV2 = CalculationUtils.calculateTotalShipMOMV2(totalDataMOMV2, totalTanksMOMV2);
            totalShipMOMV1 = CalculationUtils.calculateTotalShipMOMV1(totalDataMOMV1, totalTanksMOMV1);
             
            double gg = CalculationUtils.calculateGG(totalShipWeight, totalTanksFS);
            double dc = CalculationUtils.calculateDC(connection, totalShipWeight);
            double lcb = CalculationUtils.calculateLCB(connection, totalShipWeight);
            double lcg = CalculationUtils.calculateTotalShipLCG(totalShipWeight, totalShipMOMV1);
            double kml = CalculationUtils.calculateKML(connection, totalShipWeight);
            double kg = CalculationUtils.calculateKG(totalShipWeight, totalShipMOMV2, gg);
            double tLevel = CalculationUtils.calculateTLevel(lcb, lcg, kml, kg);
            
                return CalculationUtils.calculateCProa(dc, tLevel);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }   
    }

    public double getCStarboard(String[] ballastTanksS, String[] fwTanksS , String[] dieselTanksS, String[] miscTanksS, double[] ballastTanks, double[] fwTanks, double[] dieselTanks, double[] miscTanks) {
        try (Connection connection = DriverManager.getConnection(System.getenv("DB_URL_ENDEAVOURII"),
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
            double totalTanksWeightBallast = getTotalTanksWeightBallast(connection, ballastTanks, ballastTanksS);
            double totalTanksWeightDiesel = getTotalTanksWeightDiesel(connection, dieselTanks, dieselTanksS);
            double totalTanksWeightFW = getTotalTanksWeightFW(connection, fwTanks, fwTanksS);
            double totalTanksWeightMisc = getTotalTanksWeightMisc(connection, miscTanks, miscTanksS);

            double totalTanksFSBallast = getTotalTanksFSBallast(connection, ballastTanks, ballastTanksS);
            double totalTanksFSDiesel = getTotalTanksFSDiesel(connection, dieselTanks, dieselTanksS);
            double totalTanksFSFW = getTotalTanksFSFW(connection, fwTanks, fwTanksS);
            double totalTanksFSMisc = getTotalTanksFSMisc(connection, miscTanks, miscTanksS);

            double totalTanksMOMV1Ballast = getTotalTanksMOMV1Ballast(connection, ballastTanks, ballastTanksS);
            double totalTanksMOMV1Diesel = getTotalTanksMOMV1Diesel(connection, dieselTanks, dieselTanksS);
            double totalTanksMOMV1FW = getTotalTanksMOMV1FW(connection, fwTanks, fwTanksS);
            double totalTanksMOMV1Misc = getTotalTanksMOMV1Misc(connection, miscTanks, miscTanksS);

            double totalTanksMOMV2Ballast = getTotalTanksMOMV2Ballast(connection, ballastTanks, ballastTanksS);
            double totalTanksMOMV2Diesel = getTotalTanksMOMV2Diesel(connection, dieselTanks, dieselTanksS);
            double totalTanksMOMV2FW = getTotalTanksMOMV2FW(connection, fwTanks, fwTanksS);
            double totalTanksMOMV2Misc = getTotalTanksMOMV2Misc(connection, miscTanks, miscTanksS);

            double totalTanksWeight = sum4Values(totalTanksWeightBallast, totalTanksWeightDiesel, totalTanksWeightFW, totalTanksWeightMisc);
            double totalTanksFS = sum4Values(totalTanksFSBallast, totalTanksFSDiesel, totalTanksFSFW, totalTanksFSMisc);
            double totalTanksMOMV1 = sum4Values(totalTanksMOMV1Ballast, totalTanksMOMV1Diesel, totalTanksMOMV1FW, totalTanksMOMV1Misc);
            double totalTanksMOMV2 = sum4Values(totalTanksMOMV2Ballast, totalTanksMOMV2Diesel, totalTanksMOMV2FW, totalTanksMOMV2Misc);

            double totalShipWeight;
            double totalShipMOMV2;
            double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
            double totalShipMOMV1;
            double totalDataMOMV1 = CalculationUtils.getTotalShipDataMOMV1(connection);
            double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
            totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);
            totalShipMOMV2 = CalculationUtils.calculateTotalShipMOMV2(totalDataMOMV2, totalTanksMOMV2);
            totalShipMOMV1 = CalculationUtils.calculateTotalShipMOMV1(totalDataMOMV1, totalTanksMOMV1);
             
            double gg = CalculationUtils.calculateGG(totalShipWeight, totalTanksFS);
            double dc = CalculationUtils.calculateDC(connection, totalShipWeight);
            double lcb = CalculationUtils.calculateLCB(connection, totalShipWeight);
            double lcg = CalculationUtils.calculateTotalShipLCG(totalShipWeight, totalShipMOMV1);
            double kml = CalculationUtils.calculateKML(connection, totalShipWeight);
            double kg = CalculationUtils.calculateKG(totalShipWeight, totalShipMOMV2, gg);
            double tLevel = CalculationUtils.calculateTLevel(lcb, lcg, kml, kg);
            
            return CalculationUtils.calculateCPopa(dc, tLevel);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }   
    }

    public double getKM(String[] ballastTanksS, String[] fwTanksS , String[] dieselTanksS, String[] miscTanksS, double[] ballastTanks, double[] fwTanks, double[] dieselTanks, double[] miscTanks) {
        try (Connection connection = DriverManager.getConnection(System.getenv("DB_URL_ENDEAVOURII"),
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
        double totalTanksWeightBallast = getTotalTanksWeightBallast(connection, ballastTanks, ballastTanksS);
        double totalTanksWeightDiesel = getTotalTanksWeightDiesel(connection, dieselTanks, dieselTanksS);
        double totalTanksWeightFW = getTotalTanksWeightFW(connection, fwTanks, fwTanksS);
        double totalTanksWeightMisc = getTotalTanksWeightMisc(connection, miscTanks, miscTanksS);


        double totalTanksWeight = sum4Values(totalTanksWeightBallast, totalTanksWeightDiesel, totalTanksWeightFW, totalTanksWeightMisc);

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

    public double getKG(String[] ballastTanksS, String[] fwTanksS , String[] dieselTanksS, String[] miscTanksS, double[] ballastTanks, double[] fwTanks, double[] dieselTanks, double[] miscTanks) {
        try (Connection connection = DriverManager.getConnection(System.getenv("DB_URL_ENDEAVOURII"),
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
            double totalTanksWeightBallast = getTotalTanksWeightBallast(connection, ballastTanks, ballastTanksS);
            double totalTanksWeightDiesel = getTotalTanksWeightDiesel(connection, dieselTanks, dieselTanksS);
            double totalTanksWeightFW = getTotalTanksWeightFW(connection, fwTanks, fwTanksS);
            double totalTanksWeightMisc = getTotalTanksWeightMisc(connection, miscTanks, miscTanksS);

            double totalTanksFSBallast = getTotalTanksFSBallast(connection, ballastTanks, ballastTanksS);
            double totalTanksFSDiesel = getTotalTanksFSDiesel(connection, dieselTanks, dieselTanksS);
            double totalTanksFSFW = getTotalTanksFSFW(connection, fwTanks, fwTanksS);
            double totalTanksFSMisc = getTotalTanksFSMisc(connection, miscTanks, miscTanksS);

            double totalTanksMOMV2Ballast = getTotalTanksMOMV2Ballast(connection, ballastTanks, ballastTanksS);
            double totalTanksMOMV2Diesel = getTotalTanksMOMV2Diesel(connection, dieselTanks, dieselTanksS);
            double totalTanksMOMV2FW = getTotalTanksMOMV2FW(connection, fwTanks, fwTanksS);
            double totalTanksMOMV2Misc = getTotalTanksMOMV2Misc(connection, miscTanks, miscTanksS);

            double totalTanksWeight = sum4Values(totalTanksWeightBallast, totalTanksWeightDiesel, totalTanksWeightFW, totalTanksWeightMisc);
            double totalTanksFS = sum4Values(totalTanksFSBallast, totalTanksFSDiesel, totalTanksFSFW, totalTanksFSMisc);
            double totalTanksMOMV2 = sum4Values(totalTanksMOMV2Ballast, totalTanksMOMV2Diesel, totalTanksMOMV2FW, totalTanksMOMV2Misc);

            double totalShipWeight;
            double totalShipMOMV2;
            double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
            double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
            totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);
            totalShipMOMV2 = CalculationUtils.calculateTotalShipMOMV2(totalDataMOMV2, totalTanksMOMV2);
            
            double gg = CalculationUtils.calculateGG(totalShipWeight, totalTanksFS);

            return CalculationUtils.calculateKG(totalShipWeight, totalShipMOMV2, gg);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }   
    }

    public double getGM(String[] ballastTanksS, String[] fwTanksS , String[] dieselTanksS, String[] miscTanksS, double[] ballastTanks, double[] fwTanks, double[] dieselTanks, double[] miscTanks) {
        try (Connection connection = DriverManager.getConnection(System.getenv("DB_URL_ENDEAVOURII"),
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
            double totalTanksWeightBallast = getTotalTanksWeightBallast(connection, ballastTanks, ballastTanksS);
            double totalTanksWeightDiesel = getTotalTanksWeightDiesel(connection, dieselTanks, dieselTanksS);
            double totalTanksWeightFW = getTotalTanksWeightFW(connection, fwTanks, fwTanksS);
            double totalTanksWeightMisc = getTotalTanksWeightMisc(connection, miscTanks, miscTanksS);

            double totalTanksFSBallast = getTotalTanksFSBallast(connection, ballastTanks, ballastTanksS);
            double totalTanksFSDiesel = getTotalTanksFSDiesel(connection, dieselTanks, dieselTanksS);
            double totalTanksFSFW = getTotalTanksFSFW(connection, fwTanks, fwTanksS);
            double totalTanksFSMisc = getTotalTanksFSMisc(connection, miscTanks, miscTanksS);

            double totalTanksMOMV2Ballast = getTotalTanksMOMV2Ballast(connection, ballastTanks, ballastTanksS);
            double totalTanksMOMV2Diesel = getTotalTanksMOMV2Diesel(connection, dieselTanks, dieselTanksS);
            double totalTanksMOMV2FW = getTotalTanksMOMV2FW(connection, fwTanks, fwTanksS);
            double totalTanksMOMV2Misc = getTotalTanksMOMV2Misc(connection, miscTanks, miscTanksS);

            double totalTanksWeight = sum4Values(totalTanksWeightBallast, totalTanksWeightDiesel, totalTanksWeightFW, totalTanksWeightMisc);
            double totalTanksFS = sum4Values(totalTanksFSBallast, totalTanksFSDiesel, totalTanksFSFW, totalTanksFSMisc);
            double totalTanksMOMV2 = sum4Values(totalTanksMOMV2Ballast, totalTanksMOMV2Diesel, totalTanksMOMV2FW, totalTanksMOMV2Misc);

            double totalShipWeight;
            double totalShipMOMV2;
            double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
            double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
            totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);
            totalShipMOMV2 = CalculationUtils.calculateTotalShipMOMV2(totalDataMOMV2, totalTanksMOMV2);
            
            double gg = CalculationUtils.calculateGG(totalShipWeight, totalTanksFS);
            double kg = CalculationUtils.calculateKG(totalShipWeight, totalShipMOMV2, gg);
            double kmt = CalculationUtils.calculateKMT(connection, totalShipWeight);

            return CalculationUtils.calculateGM(kmt, kg);            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }   
    }

}
