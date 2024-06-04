package com.pg.stabilitycalculation.logic;
import java.sql.*;
;
public class Tanks {
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(System.getenv("DB_URL_ENDEAVOURII"),
                System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"))) {
            // Establish a connection to your database
            
            // Define the tankValue
            double tankValue = 10;
            double totalTanksMOMV2 = CalculationUtils.calculateTotalMOMV2(connection, tankValue, TankConstants.ALL_TANKS);
            double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
            double totalShipMOMV2 = CalculationUtils.calculateTotalShipMOMV2(totalDataMOMV2, totalTanksMOMV2);

            double totalTanksMOMV1 = CalculationUtils.calculateTotalMOMV1(connection, tankValue, TankConstants.ALL_TANKS);
            double totalDataMOMV1 = CalculationUtils.getTotalShipDataMOMV1(connection);
            double totalShipMOMV1 = CalculationUtils.calculateTotalShipMOMV1(totalDataMOMV1, totalTanksMOMV1);

            double totalTanksWeight = CalculationUtils.calculateTotalWeight(connection, tankValue, TankConstants.ALL_TANKS);
            double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
            double totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);
            double totalFS = CalculationUtils.calculateTotalFS(connection, tankValue, TankConstants.ALL_TANKS);
            double gg = CalculationUtils.calculateGG(totalShipWeight, totalFS);
            double kg = CalculationUtils.calculateKG(totalShipWeight, totalShipMOMV2, gg);
            double lcg = CalculationUtils.calculateTotalShipLCG(totalShipWeight, totalShipMOMV1);
            double lcb = CalculationUtils.calculateLCB(connection, totalShipWeight);
            double kml = CalculationUtils.calculateKML(connection, totalShipWeight);
            double lcf = CalculationUtils.calculateLCF(connection, totalShipWeight);
            double tLevel = CalculationUtils.calculateTLevel(lcb, lcg, kml, kg);
            double dc = CalculationUtils.calculateDC(connection, totalShipWeight);
            double ta = CalculationUtils.calculateTa(dc, tLevel, lcf);
            double kmt = CalculationUtils.calculateKMT(connection, totalShipWeight);

            
            
            System.out.println(CalculationUtils.calculateGM(kmt, kg));

            

        
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
