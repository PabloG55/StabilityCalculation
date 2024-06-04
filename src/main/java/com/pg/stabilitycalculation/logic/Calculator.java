package com.pg.stabilitycalculation.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Calculator {
        public double getCPort(double[] tankValues, String[] tanks) {
        try (Connection connection = DriverManager.getConnection("DB_URL_ENDEAVOURII",
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
            double totalTanksMOMV2 = 0;
            double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
            double totalShipMOMV2 = 0;
            double totalTanksMOMV1 = 0;
            double totalDataMOMV1 = CalculationUtils.getTotalShipDataMOMV1(connection);
            double totalShipMOMV1 = 0;
            double totalTanksWeight = 0;
            double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
            double totalShipWeight = 0;
            double totalTanksFS = 0;


            for(double tankValue:tankValues){
                totalTanksWeight += CalculationUtils.calculateTotalWeight(connection, tankValue, tanks);
                totalTanksFS += CalculationUtils.calculateTotalFS(connection, tankValue, tanks);
                totalTanksMOMV1 += CalculationUtils.calculateTotalMOMV1(connection, tankValue, tanks);
                totalTanksMOMV2 += CalculationUtils.calculateTotalMOMV2(connection, tankValue, tanks);
            }

            totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);
            totalShipMOMV1 = CalculationUtils.calculateTotalShipMOMV1(totalDataMOMV1, totalTanksMOMV1);
            totalShipMOMV2 = CalculationUtils.calculateTotalShipMOMV2(totalDataMOMV2, totalTanksMOMV2);
            
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

    public double getCStarboard(double[] tankValues, String[] tanks) {
        try (Connection connection = DriverManager.getConnection("DB_URL_ENDEAVOURII",
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
            double totalTanksMOMV2 = 0;
            double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
            double totalShipMOMV2 = 0;
            double totalTanksMOMV1 = 0;
            double totalDataMOMV1 = CalculationUtils.getTotalShipDataMOMV1(connection);
            double totalShipMOMV1 = 0;
            double totalTanksWeight = 0;
            double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
            double totalShipWeight = 0;
            double totalTanksFS = 0;


            for(double tankValue:tankValues){
                totalTanksWeight += CalculationUtils.calculateTotalWeight(connection, tankValue, tanks);
                totalTanksFS += CalculationUtils.calculateTotalFS(connection, tankValue, tanks);
                totalTanksMOMV1 += CalculationUtils.calculateTotalMOMV1(connection, tankValue, tanks);
                totalTanksMOMV2 += CalculationUtils.calculateTotalMOMV2(connection, tankValue, tanks);
            }

            totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);
            totalShipMOMV1 = CalculationUtils.calculateTotalShipMOMV1(totalDataMOMV1, totalTanksMOMV1);
            totalShipMOMV2 = CalculationUtils.calculateTotalShipMOMV2(totalDataMOMV2, totalTanksMOMV2);
            
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

    public double getKM(double[] tankValues, String[] tanks) {
        try (Connection connection = DriverManager.getConnection("DB_URL_ENDEAVOURII",
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
            double totalTanksWeight = 0;
            double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
            double totalShipWeight = 0;



            for(double tankValue:tankValues){
                totalTanksWeight += CalculationUtils.calculateTotalWeight(connection, tankValue, tanks);
            }
            totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);

            
            return CalculationUtils.calculateKMT(connection, totalShipWeight);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }   
    }

    public double getKG(double[] tankValues, String[] tanks) {
        try (Connection connection = DriverManager.getConnection("DB_URL_ENDEAVOURII",
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
            double totalTanksMOMV2 = 0;
            double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
            double totalShipMOMV2 = 0;
            double totalTanksWeight = 0;
            double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
            double totalShipWeight = 0;
            double totalTanksFS = 0;


            for(double tankValue:tankValues){
                totalTanksWeight += CalculationUtils.calculateTotalWeight(connection, tankValue, tanks);
                totalTanksFS += CalculationUtils.calculateTotalFS(connection, tankValue, tanks);
                totalTanksMOMV2 += CalculationUtils.calculateTotalMOMV2(connection, tankValue, tanks);
            }

            totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);
            totalShipMOMV2 = CalculationUtils.calculateTotalShipMOMV2(totalDataMOMV2, totalTanksMOMV2);
            
            double gg = CalculationUtils.calculateGG(totalShipWeight, totalTanksFS);

            return CalculationUtils.calculateKG(totalShipWeight, totalShipMOMV2, gg);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }   
    }

    public double getGM(double[] tankValues, String[] tanks) {
        try (Connection connection = DriverManager.getConnection("DB_URL_ENDEAVOURII",
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            
            double totalTanksMOMV2 = 0;
            double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
            double totalShipMOMV2 = 0;
            double totalTanksWeight = 0;
            double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
            double totalShipWeight = 0;
            double totalTanksFS = 0;


            for(double tankValue:tankValues){
                totalTanksWeight += CalculationUtils.calculateTotalWeight(connection, tankValue, tanks);
                totalTanksFS += CalculationUtils.calculateTotalFS(connection, tankValue, tanks);
                totalTanksMOMV2 += CalculationUtils.calculateTotalMOMV2(connection, tankValue, tanks);
            }

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
