package com.pg.stabilitycalculation.logic;
import java.sql.Connection;
import java.sql.SQLException;


public class CalculatorUtils {
    
    public double getTotalTanksWeightBallast(Connection connection, double[] ballastTanks, String[] ballastTanksS) throws SQLException{
        double totalTanksWeightBallast = 0;
        for (int i = 0; i < ballastTanks.length; i++) {
            totalTanksWeightBallast += CalculationUtils.calculateTankWeight(connection, ballastTanks[i], ballastTanksS[i]);
        }
        return totalTanksWeightBallast;
    }

    public double getTotalTanksWeightDiesel(Connection connection, double[] dieselTanks, String[] dieselTanksS) throws SQLException{
        double totalTanksWeightDiesel = 0;
        for (int i = 0; i < dieselTanks.length; i++) {
            totalTanksWeightDiesel += CalculationUtils.calculateTankWeight(connection, dieselTanks[i], dieselTanksS[i]);
        }
        return totalTanksWeightDiesel;
    }

    public double getTotalTanksWeightFW(Connection connection, double[] fwTanks, String[] fwTanksS) throws SQLException{
        double totalTanksWeightFW = 0;
        for (int i = 0; i < fwTanks.length; i++) {
            totalTanksWeightFW += CalculationUtils.calculateTankWeight(connection, fwTanks[i], fwTanksS[i]);
        }
        return totalTanksWeightFW;
    }

    public double getTotalTanksWeightMisc(Connection connection, double[] miscTanks, String[] miscTanksS) throws SQLException{
        double totalTanksWeightMisc = 0;
        for (int i = 0; i < miscTanks.length; i++) {
            totalTanksWeightMisc += CalculationUtils.calculateTankWeight(connection, miscTanks[i], miscTanksS[i]);
        }
        return totalTanksWeightMisc;
    }

    public double getTotalTanksFSBallast(Connection connection, double[] ballastTanks, String[] ballastTanksS) throws SQLException{
        double totalTanksFSBallast = 0;
        for (int i = 0; i < ballastTanks.length; i++) {
            totalTanksFSBallast += CalculationUtils.calculateTankFS(connection, ballastTanks[i], ballastTanksS[i]);
        }
        return totalTanksFSBallast;
    }

    public double getTotalTanksFSDiesel(Connection connection, double[] dieselTanks, String[] dieselTanksS) throws SQLException{
        double totalTanksFSDiesel = 0;
        for (int i = 0; i < dieselTanks.length; i++) {
            totalTanksFSDiesel += CalculationUtils.calculateTankFS(connection, dieselTanks[i], dieselTanksS[i]);
        }
        return totalTanksFSDiesel;
    }

    public double getTotalTanksFSFW(Connection connection, double[] fwTanks, String[] fwTanksS) throws SQLException{
        double totalTanksFSFW = 0;
        for (int i = 0; i < fwTanks.length; i++) {
            totalTanksFSFW += CalculationUtils.calculateTankFS(connection, fwTanks[i], fwTanksS[i]);
        }
        return totalTanksFSFW;
    }

    public double getTotalTanksFSMisc(Connection connection, double[] miscTanks, String[] miscTanksS) throws SQLException{
        double totalTanksFSMisc = 0;
        for (int i = 0; i < miscTanks.length; i++) {
            totalTanksFSMisc += CalculationUtils.calculateTankFS(connection, miscTanks[i], miscTanksS[i]);
        }
        return totalTanksFSMisc;
    }

    
    public double getTotalTanksMOMV2Ballast(Connection connection, double[] ballastTanks, String[] ballastTanksS) throws SQLException{
        double totalTanksMOMV2Ballast = 0;
        for (int i = 0; i < ballastTanks.length; i++) {
            totalTanksMOMV2Ballast += CalculationUtils.calculateTankMOMV2(connection, ballastTanks[i], ballastTanksS[i]);
        }
        return totalTanksMOMV2Ballast;
    }

    public double getTotalTanksMOMV2Diesel(Connection connection, double[] dieselTanks, String[] dieselTanksS) throws SQLException{
        double totalTanksMOMV2Diesel = 0;
        for (int i = 0; i < dieselTanks.length; i++) {
            totalTanksMOMV2Diesel += CalculationUtils.calculateTankMOMV2(connection, dieselTanks[i], dieselTanksS[i]);
        }
        return totalTanksMOMV2Diesel;
    }

    public double getTotalTanksMOMV2FW(Connection connection, double[] fwTanks, String[] fwTanksS) throws SQLException{
        double totalTanksMOMV2FW = 0;
        for (int i = 0; i < fwTanks.length; i++) {
            totalTanksMOMV2FW += CalculationUtils.calculateTankMOMV2(connection, fwTanks[i], fwTanksS[i]);
        }
        return totalTanksMOMV2FW;
    }

    public double getTotalTanksMOMV2Misc(Connection connection, double[] miscTanks, String[] miscTanksS) throws SQLException{
        double totalTanksMOMV2Misc = 0;
        for (int i = 0; i < miscTanks.length; i++) {
            totalTanksMOMV2Misc += CalculationUtils.calculateTankMOMV2(connection, miscTanks[i], miscTanksS[i]);
        }
        return totalTanksMOMV2Misc;
    }

    public double getTotalTanksMOMV1Ballast(Connection connection, double[] ballastTanks, String[] ballastTanksS) throws SQLException{
        double totalTanksMOMV1Ballast = 0;
        for (int i = 0; i < ballastTanks.length; i++) {
            totalTanksMOMV1Ballast += CalculationUtils.calculateTankMOMV1(connection, ballastTanks[i], ballastTanksS[i]);
        }
        return totalTanksMOMV1Ballast;
    }

    public double getTotalTanksMOMV1Diesel(Connection connection, double[] dieselTanks, String[] dieselTanksS) throws SQLException{
        double totalTanksMOMV1Diesel = 0;
        for (int i = 0; i < dieselTanks.length; i++) {
            totalTanksMOMV1Diesel += CalculationUtils.calculateTankMOMV1(connection, dieselTanks[i], dieselTanksS[i]);
        }
        return totalTanksMOMV1Diesel;
    }

    public double getTotalTanksMOMV1FW(Connection connection, double[] fwTanks, String[] fwTanksS) throws SQLException{
        double totalTanksMOMV1FW = 0;
        for (int i = 0; i < fwTanks.length; i++) {
            totalTanksMOMV1FW += CalculationUtils.calculateTankMOMV1(connection, fwTanks[i], fwTanksS[i]);
        }
        return totalTanksMOMV1FW;
    }

    public double getTotalTanksMOMV1Misc(Connection connection, double[] miscTanks, String[] miscTanksS) throws SQLException{
        double totalTanksMOMV1Misc = 0;
        for (int i = 0; i < miscTanks.length; i++) {
            totalTanksMOMV1Misc += CalculationUtils.calculateTankFS(connection, miscTanks[i], miscTanksS[i]);
        }
        return totalTanksMOMV1Misc;
    }


    public double sum4Values(double value1, double value2, double value3, double value4){
        return value1 + value2 + value3 + value4;
    }
}
