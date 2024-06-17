package com.pg.stabilitycalculation.logic;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;

public class Excel {
    private CalculatorUtils calc = new CalculatorUtils();
    private Calculator calculator = new Calculator();

    public XSSFWorkbook CreateWorkbook() {
        return new XSSFWorkbook();
    }

    public XSSFSheet createSheet(XSSFWorkbook workbook, String name){
        return workbook.createSheet(name);
    }

    public void createBallastTable(XSSFWorkbook workbook, XSSFSheet sheet, Connection connection, double[] ballastTanks, String[] ballastTanksS) throws SQLException {
        String[] columns = {
                "Tanques lastre agua salada", "Capacidad (Ton. M)", "Pesos (Ton. M)", "LCG metros",
                "MOMV 1 (mts - TM)", "VCG metros", "MOMV 2 (mts - TM)", "Superficie Libre mts-TM"
        };

        List<TankData> tankDataList = new ArrayList<>();
        
        tankDataList.add(
            new TankData(
                "Peak de proa", 
                22.06,
                CalculationUtils.calculateTankWeight(connection, ballastTanks[0], ballastTanksS[0]), 
                CalculationUtils.calculateTankLCG(connection, ballastTanks[0], ballastTanksS[0]),
                CalculationUtils.calculateTankMOMV1(connection, ballastTanks[0], ballastTanksS[0]), 
                CalculationUtils.calculateTankVCG(connection, ballastTanks[0], ballastTanksS[0]),
                CalculationUtils.calculateTankMOMV2(connection, ballastTanks[0], ballastTanksS[0]),
                CalculationUtils.calculateTankFS(connection, ballastTanks[0], ballastTanksS[0])
            )
        );

        tankDataList.add(
            new TankData(
                "Nro. 00. C",
                6.75,
                CalculationUtils.calculateTankWeight(connection, ballastTanks[1], ballastTanksS[1]),
                CalculationUtils.calculateTankLCG(connection, ballastTanks[1], ballastTanksS[1]),
                CalculationUtils.calculateTankMOMV1(connection, ballastTanks[1], ballastTanksS[1]),
                CalculationUtils.calculateTankVCG(connection, ballastTanks[1], ballastTanksS[1]),
                CalculationUtils.calculateTankMOMV2(connection, ballastTanks[1], ballastTanksS[1]),
                CalculationUtils.calculateTankFS(connection, ballastTanks[1], ballastTanksS[1])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Nro. 01. C",
                24.53,
                CalculationUtils.calculateTankWeight(connection, ballastTanks[2], ballastTanksS[2]),
                CalculationUtils.calculateTankLCG(connection, ballastTanks[2], ballastTanksS[2]),
                CalculationUtils.calculateTankMOMV1(connection, ballastTanks[2], ballastTanksS[2]),
                CalculationUtils.calculateTankVCG(connection, ballastTanks[2], ballastTanksS[2]),
                CalculationUtils.calculateTankMOMV2(connection, ballastTanks[2], ballastTanksS[2]),
                CalculationUtils.calculateTankFS(connection, ballastTanks[2], ballastTanksS[2])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Nro. 02. C",
                61.85,
                CalculationUtils.calculateTankWeight(connection, ballastTanks[3], ballastTanksS[3]),
                CalculationUtils.calculateTankLCG(connection, ballastTanks[3], ballastTanksS[3]),
                CalculationUtils.calculateTankMOMV1(connection, ballastTanks[3], ballastTanksS[3]),
                CalculationUtils.calculateTankVCG(connection, ballastTanks[3], ballastTanksS[3]),
                CalculationUtils.calculateTankMOMV2(connection, ballastTanks[3], ballastTanksS[3]),
                CalculationUtils.calculateTankFS(connection, ballastTanks[3], ballastTanksS[3])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Nro. 03. C",
                41.54,
                CalculationUtils.calculateTankWeight(connection, ballastTanks[4], ballastTanksS[4]),
                CalculationUtils.calculateTankLCG(connection, ballastTanks[4], ballastTanksS[4]),
                CalculationUtils.calculateTankMOMV1(connection, ballastTanks[4], ballastTanksS[4]),
                CalculationUtils.calculateTankVCG(connection, ballastTanks[4], ballastTanksS[4]),
                CalculationUtils.calculateTankMOMV2(connection, ballastTanks[4], ballastTanksS[4]),
                CalculationUtils.calculateTankFS(connection, ballastTanks[4], ballastTanksS[4])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Nro. 04. C",
                27.36,
                CalculationUtils.calculateTankWeight(connection, ballastTanks[5], ballastTanksS[5]),
                CalculationUtils.calculateTankLCG(connection, ballastTanks[5], ballastTanksS[5]),
                CalculationUtils.calculateTankMOMV1(connection, ballastTanks[5], ballastTanksS[5]),
                CalculationUtils.calculateTankVCG(connection, ballastTanks[5], ballastTanksS[5]),
                CalculationUtils.calculateTankMOMV2(connection, ballastTanks[5], ballastTanksS[5]),
                CalculationUtils.calculateTankFS(connection, ballastTanks[5], ballastTanksS[5])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Nro. 05. C",
                33.44,
                CalculationUtils.calculateTankWeight(connection, ballastTanks[6], ballastTanksS[6]),
                CalculationUtils.calculateTankLCG(connection, ballastTanks[6], ballastTanksS[6]),
                CalculationUtils.calculateTankMOMV1(connection, ballastTanks[6], ballastTanksS[6]),
                CalculationUtils.calculateTankVCG(connection, ballastTanks[6], ballastTanksS[6]),
                CalculationUtils.calculateTankMOMV2(connection, ballastTanks[6], ballastTanksS[6]),
                CalculationUtils.calculateTankFS(connection, ballastTanks[6], ballastTanksS[6])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Nro. 06. C",
                32.49,
                CalculationUtils.calculateTankWeight(connection, ballastTanks[7], ballastTanksS[7]),
                CalculationUtils.calculateTankLCG(connection, ballastTanks[7], ballastTanksS[7]),
                CalculationUtils.calculateTankMOMV1(connection, ballastTanks[7], ballastTanksS[7]),
                CalculationUtils.calculateTankVCG(connection, ballastTanks[7], ballastTanksS[7]),
                CalculationUtils.calculateTankMOMV2(connection, ballastTanks[7], ballastTanksS[7]),
                CalculationUtils.calculateTankFS(connection, ballastTanks[7], ballastTanksS[7])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Total lastre agua salada",
                250.02,
                calc.getTotalTanksWeightBallast(connection, ballastTanks, ballastTanksS),
                calc.getTotalTanksMOMV1Ballast(connection, ballastTanks, ballastTanksS) / calc.getTotalTanksWeightBallast(connection, ballastTanks, ballastTanksS),
                calc.getTotalTanksMOMV1Ballast(connection, ballastTanks, ballastTanksS),
                calc.getTotalTanksMOMV2Ballast(connection, ballastTanks, ballastTanksS) / calc.getTotalTanksWeightBallast(connection, ballastTanks, ballastTanksS),
                calc.getTotalTanksMOMV2Ballast(connection, ballastTanks, ballastTanksS),
                calc.getTotalTanksFSBallast(connection, ballastTanks, ballastTanksS)
            )
        );

        // Create header
        createTableHeader(sheet, columns, 0);

        // Populate data rows
        int rowNum = 1;
        for (TankData tankData : tankDataList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(tankData.getName());
            row.createCell(1).setCellValue(tankData.getCapacidad());
            row.createCell(2).setCellValue(tankData.getPesos());
            row.createCell(3).setCellValue(tankData.getLcg());
            row.createCell(4).setCellValue(tankData.getMomv1());
            row.createCell(5).setCellValue(tankData.getVcg());
            row.createCell(6).setCellValue(tankData.getMomv2());
            row.createCell(7).setCellValue(tankData.getSuperficieLibre());
        }
        
        // Resize columns
        resizeColumns(sheet, columns.length);

        // Create table
        createTable(sheet, workbook, "BallastTable", 1L, 0, rowNum, columns.length);
    }

    public void createFWTable(XSSFWorkbook workbook, XSSFSheet sheet, int startRow, Connection connection, double[] fwTanks, String[] fwTanksS) throws SQLException {
        String[] columns = {
                "Tanques de agua dulce", "Capacidad (Ton. M)", "Pesos (Ton. M)", "LCG metros",
                "MOMV 1 (mts - TM)", "VCG metros", "MOMV 2 (mts - TM)", "Superficie Libre mts-TM"
        };

        List<TankData> tankDataList = new ArrayList<>();
        
        tankDataList.add(
            new TankData(
                "Nro. 05 Babor Manual", 
                0,
                CalculationUtils.calculateTankWeight(connection, fwTanks[0], fwTanksS[0]), 
                CalculationUtils.calculateTankLCG(connection, fwTanks[0], fwTanksS[0]),
                CalculationUtils.calculateTankMOMV1(connection, fwTanks[0], fwTanksS[0]), 
                CalculationUtils.calculateTankVCG(connection, fwTanks[0], fwTanksS[0]),
                CalculationUtils.calculateTankMOMV2(connection, fwTanks[0], fwTanksS[0]),
                CalculationUtils.calculateTankFS(connection, fwTanks[0], fwTanksS[0])
            )
        );

        tankDataList.add(
            new TankData(
                "Nro. 05 Babor Magnetico",
                40.77,
                CalculationUtils.calculateTankWeight(connection, fwTanks[1], fwTanksS[1]),
                CalculationUtils.calculateTankLCG(connection, fwTanks[1], fwTanksS[1]),
                CalculationUtils.calculateTankMOMV1(connection, fwTanks[1], fwTanksS[1]),
                CalculationUtils.calculateTankVCG(connection, fwTanks[1], fwTanksS[1]),
                CalculationUtils.calculateTankMOMV2(connection, fwTanks[1], fwTanksS[1]),
                CalculationUtils.calculateTankFS(connection, fwTanks[1], fwTanksS[1])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Nro. 05 Estribor Manual",
                0,
                CalculationUtils.calculateTankWeight(connection, fwTanks[2], fwTanksS[2]),
                CalculationUtils.calculateTankLCG(connection, fwTanks[2], fwTanksS[2]),
                CalculationUtils.calculateTankMOMV1(connection, fwTanks[2], fwTanksS[2]),
                CalculationUtils.calculateTankVCG(connection, fwTanks[2], fwTanksS[2]),
                CalculationUtils.calculateTankMOMV2(connection, fwTanks[2], fwTanksS[2]),
                CalculationUtils.calculateTankFS(connection, fwTanks[2], fwTanksS[2])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Nro. 05 Estribor Magnetico",
                41.17,
                CalculationUtils.calculateTankWeight(connection, fwTanks[3], fwTanksS[3]),
                CalculationUtils.calculateTankLCG(connection, fwTanks[3], fwTanksS[3]),
                CalculationUtils.calculateTankMOMV1(connection, fwTanks[3], fwTanksS[3]),
                CalculationUtils.calculateTankVCG(connection, fwTanks[3], fwTanksS[3]),
                CalculationUtils.calculateTankMOMV2(connection, fwTanks[3], fwTanksS[3]),
                CalculationUtils.calculateTankFS(connection, fwTanks[3], fwTanksS[3])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Nro. 06 Babor Manual",
                0,
                CalculationUtils.calculateTankWeight(connection, fwTanks[4], fwTanksS[4]),
                CalculationUtils.calculateTankLCG(connection, fwTanks[4], fwTanksS[4]),
                CalculationUtils.calculateTankMOMV1(connection, fwTanks[4], fwTanksS[4]),
                CalculationUtils.calculateTankVCG(connection, fwTanks[4], fwTanksS[4]),
                CalculationUtils.calculateTankMOMV2(connection, fwTanks[4], fwTanksS[4]),
                CalculationUtils.calculateTankFS(connection, fwTanks[4], fwTanksS[4])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Nro. 06 Babor Magnetico",
                42.95,
                CalculationUtils.calculateTankWeight(connection, fwTanks[5], fwTanksS[5]),
                CalculationUtils.calculateTankLCG(connection, fwTanks[5], fwTanksS[5]),
                CalculationUtils.calculateTankMOMV1(connection, fwTanks[5], fwTanksS[5]),
                CalculationUtils.calculateTankVCG(connection, fwTanks[5], fwTanksS[5]),
                CalculationUtils.calculateTankMOMV2(connection, fwTanks[5], fwTanksS[5]),
                CalculationUtils.calculateTankFS(connection, fwTanks[5], fwTanksS[5])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Nro. 06 Estribor Manual",
                0,
                CalculationUtils.calculateTankWeight(connection, fwTanks[6], fwTanksS[6]),
                CalculationUtils.calculateTankLCG(connection, fwTanks[6], fwTanksS[6]),
                CalculationUtils.calculateTankMOMV1(connection, fwTanks[6], fwTanksS[6]),
                CalculationUtils.calculateTankVCG(connection, fwTanks[6], fwTanksS[6]),
                CalculationUtils.calculateTankMOMV2(connection, fwTanks[6], fwTanksS[6]),
                CalculationUtils.calculateTankFS(connection, fwTanks[6], fwTanksS[6])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Nro. 06 Estribor Magnetico",
                42.95,
                CalculationUtils.calculateTankWeight(connection, fwTanks[7], fwTanksS[7]),
                CalculationUtils.calculateTankLCG(connection, fwTanks[7], fwTanksS[7]),
                CalculationUtils.calculateTankMOMV1(connection, fwTanks[7], fwTanksS[7]),
                CalculationUtils.calculateTankVCG(connection, fwTanks[7], fwTanksS[7]),
                CalculationUtils.calculateTankMOMV2(connection, fwTanks[7], fwTanksS[7]),
                CalculationUtils.calculateTankFS(connection, fwTanks[7], fwTanksS[7])
            )
        );
        
        tankDataList.add(
            new TankData(
                "Total agua dulce",
                167.84,
                calc.getTotalTanksWeightFW(connection, fwTanks, fwTanksS),
                calc.getTotalTanksMOMV1FW(connection, fwTanks, fwTanksS) / calc.getTotalTanksWeightFW(connection, fwTanks, fwTanksS),
                calc.getTotalTanksMOMV1FW(connection, fwTanks, fwTanksS),
                calc.getTotalTanksMOMV2FW(connection, fwTanks, fwTanksS) / calc.getTotalTanksWeightFW(connection, fwTanks, fwTanksS),
                calc.getTotalTanksMOMV2FW(connection, fwTanks, fwTanksS),
                calc.getTotalTanksFSFW(connection, fwTanks, fwTanksS)
            )
        );

        // Create header
        createTableHeader(sheet, columns, startRow);

        // Populate data rows
        int rowNum = startRow + 1;
        for (TankData tankData : tankDataList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(tankData.getName());
            row.createCell(1).setCellValue(tankData.getCapacidad());
            row.createCell(2).setCellValue(tankData.getPesos());
            row.createCell(3).setCellValue(tankData.getLcg());
            row.createCell(4).setCellValue(tankData.getMomv1());
            row.createCell(5).setCellValue(tankData.getVcg());
            row.createCell(6).setCellValue(tankData.getMomv2());
            row.createCell(7).setCellValue(tankData.getSuperficieLibre());
        }

        // Resize columns
        resizeColumns(sheet, columns.length);

        // Create table
        createTable(sheet, workbook, "FWTable", 2L, startRow, rowNum, columns.length);
    }

    public void createDieselTable(XSSFWorkbook workbook, XSSFSheet sheet, int startRow, Connection connection, double[] dieselTanks, String[] dieselTanksS) throws SQLException {
        String[] columns = {
                "Tanques Diesel", "Capacidad (Ton. M)", "Pesos (Ton. M)", "LCG metros",
                "MOMV 1 (mts - TM)", "VCG metros", "MOMV 2 (mts - TM)", "Superficie Libre mts-TM"
        };

        List<TankData> tankDataList = new ArrayList<>();
        
        tankDataList.add(
            new TankData(
                "Nro. 03 Diesel Oil  Babor",
                24.65,
                CalculationUtils.calculateTankWeight(connection, dieselTanks[0], dieselTanksS[0]),
                CalculationUtils.calculateTankLCG(connection, dieselTanks[0], dieselTanksS[0]),
                CalculationUtils.calculateTankMOMV1(connection, dieselTanks[0], dieselTanksS[0]),
                CalculationUtils.calculateTankVCG(connection, dieselTanks[0], dieselTanksS[0]),
                CalculationUtils.calculateTankMOMV2(connection, dieselTanks[0], dieselTanksS[0]),
                CalculationUtils.calculateTankFS(connection, dieselTanks[0], dieselTanksS[0])
            )
        );
    
        tankDataList.add(
            new TankData(
                "Nro. 03 Diesel Oil Estribor",
                24.65,
                CalculationUtils.calculateTankWeight(connection, dieselTanks[1], dieselTanksS[1]),
                CalculationUtils.calculateTankLCG(connection, dieselTanks[1], dieselTanksS[1]),
                CalculationUtils.calculateTankMOMV1(connection, dieselTanks[1], dieselTanksS[1]),
                CalculationUtils.calculateTankVCG(connection, dieselTanks[1], dieselTanksS[1]),
                CalculationUtils.calculateTankMOMV2(connection, dieselTanks[1], dieselTanksS[1]),
                CalculationUtils.calculateTankFS(connection, dieselTanks[1], dieselTanksS[1])
            )
        );
    
        tankDataList.add(
            new TankData(
                "Nro. 04 Diesel Oil  Babor",
                25.36,
                CalculationUtils.calculateTankWeight(connection, dieselTanks[2], dieselTanksS[2]),
                CalculationUtils.calculateTankLCG(connection, dieselTanks[2], dieselTanksS[2]),
                CalculationUtils.calculateTankMOMV1(connection, dieselTanks[2], dieselTanksS[2]),
                CalculationUtils.calculateTankVCG(connection, dieselTanks[2], dieselTanksS[2]),
                CalculationUtils.calculateTankMOMV2(connection, dieselTanks[2], dieselTanksS[2]),
                CalculationUtils.calculateTankFS(connection, dieselTanks[2], dieselTanksS[2])
            )
        );
    
        tankDataList.add(
            new TankData(
                "Nro. 04 Diesel Oil  Estribor",
                25.36,
                CalculationUtils.calculateTankWeight(connection, dieselTanks[3], dieselTanksS[3]),
                CalculationUtils.calculateTankLCG(connection, dieselTanks[3], dieselTanksS[3]),
                CalculationUtils.calculateTankMOMV1(connection, dieselTanks[3], dieselTanksS[3]),
                CalculationUtils.calculateTankVCG(connection, dieselTanks[3], dieselTanksS[3]),
                CalculationUtils.calculateTankMOMV2(connection, dieselTanks[3], dieselTanksS[3]),
                CalculationUtils.calculateTankFS(connection, dieselTanks[3], dieselTanksS[3])
            )
        );
    
        tankDataList.add(
            new TankData(
                "Nro. 07 Diesel Oil  Babor",
                5.58,
                CalculationUtils.calculateTankWeight(connection, dieselTanks[4], dieselTanksS[4]),
                CalculationUtils.calculateTankLCG(connection, dieselTanks[4], dieselTanksS[4]),
                CalculationUtils.calculateTankMOMV1(connection, dieselTanks[4], dieselTanksS[4]),
                CalculationUtils.calculateTankVCG(connection, dieselTanks[4], dieselTanksS[4]),
                CalculationUtils.calculateTankMOMV2(connection, dieselTanks[4], dieselTanksS[4]),
                CalculationUtils.calculateTankFS(connection, dieselTanks[4], dieselTanksS[4])
            )
        );
    
        tankDataList.add(
            new TankData(
                "Nro. 07 Diesel Oil  Estribor",
                6.90,
                CalculationUtils.calculateTankWeight(connection, dieselTanks[5], dieselTanksS[5]),
                CalculationUtils.calculateTankLCG(connection, dieselTanks[5], dieselTanksS[5]),
                CalculationUtils.calculateTankMOMV1(connection, dieselTanks[5], dieselTanksS[5]),
                CalculationUtils.calculateTankVCG(connection, dieselTanks[5], dieselTanksS[5]),
                CalculationUtils.calculateTankMOMV2(connection, dieselTanks[5], dieselTanksS[5]),
                CalculationUtils.calculateTankFS(connection, dieselTanks[5], dieselTanksS[5])
            )
        );
    
        tankDataList.add(
            new TankData(
                "Generador Emergencia Babor",
                1.23,
                CalculationUtils.calculateTankWeight(connection, dieselTanks[6], dieselTanksS[6]),
                CalculationUtils.calculateTankLCG(connection, dieselTanks[6], dieselTanksS[6]),
                CalculationUtils.calculateTankMOMV1(connection, dieselTanks[6], dieselTanksS[6]),
                CalculationUtils.calculateTankVCG(connection, dieselTanks[6], dieselTanksS[6]),
                CalculationUtils.calculateTankMOMV2(connection, dieselTanks[6], dieselTanksS[6]),
                CalculationUtils.calculateTankFS(connection, dieselTanks[6], dieselTanksS[6])
            )
        );
    
        tankDataList.add(
            new TankData(
                "Total Diesel",
                113.73,
                calc.getTotalTanksWeightDiesel(connection, dieselTanks, dieselTanksS),
                calc.getTotalTanksMOMV1Diesel(connection, dieselTanks, dieselTanksS) / calc.getTotalTanksWeightDiesel(connection, dieselTanks, dieselTanksS),
                calc.getTotalTanksMOMV1Diesel(connection, dieselTanks, dieselTanksS),
                calc.getTotalTanksMOMV2Diesel(connection, dieselTanks, dieselTanksS) / calc.getTotalTanksWeightDiesel(connection, dieselTanks, dieselTanksS),
                calc.getTotalTanksMOMV2Diesel(connection, dieselTanks, dieselTanksS),
                calc.getTotalTanksFSDiesel(connection, dieselTanks, dieselTanksS)
            )
        );

        // Create header
        createTableHeader(sheet, columns, startRow);

        // Populate data rows
        int rowNum = startRow + 1;
        for (TankData tankData : tankDataList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(tankData.getName());
            row.createCell(1).setCellValue(tankData.getCapacidad());
            row.createCell(2).setCellValue(tankData.getPesos());
            row.createCell(3).setCellValue(tankData.getLcg());
            row.createCell(4).setCellValue(tankData.getMomv1());
            row.createCell(5).setCellValue(tankData.getVcg());
            row.createCell(6).setCellValue(tankData.getMomv2());
            row.createCell(7).setCellValue(tankData.getSuperficieLibre());
        }
        
        // Resize columns
        resizeColumns(sheet, columns.length);

        // Create table
        createTable(sheet, workbook, "DieselTable", 3L, startRow, rowNum, columns.length);
    }

    public void createMiscTable(XSSFWorkbook workbook, XSSFSheet sheet, int startRow, Connection connection, double[] miscTanks, String[] miscTanksS) throws SQLException {
        String[] columns = {
                "Líquidos misceláneos", "Capacidad (Ton. M)", "Pesos (Ton. M)", "LCG metros",
                "MOMV 1 (mts - TM)", "VCG metros", "MOMV 2 (mts - TM)", "Superficie Libre mts-TM"
        };

        List<TankData> tankDataList = new ArrayList<>();
        
        tankDataList.add(
            new TankData(
                "Nro. 07 C. Oily Water",
                18.40,
                CalculationUtils.calculateTankWeight(connection, miscTanks[0], miscTanksS[0]),
                CalculationUtils.calculateTankLCG(connection, miscTanks[0], miscTanksS[0]),
                CalculationUtils.calculateTankMOMV1(connection, miscTanks[0], miscTanksS[0]),
                CalculationUtils.calculateTankVCG(connection, miscTanks[0], miscTanksS[0]),
                CalculationUtils.calculateTankMOMV2(connection, miscTanks[0], miscTanksS[0]),
                CalculationUtils.calculateTankFS(connection, miscTanks[0], miscTanksS[0])
            )
        );
    
        tankDataList.add(
            new TankData(
                "Nro. 08 C. Grey Water",
                7.78,
                CalculationUtils.calculateTankWeight(connection, miscTanks[1], miscTanksS[1]),
                CalculationUtils.calculateTankLCG(connection, miscTanks[1], miscTanksS[1]),
                CalculationUtils.calculateTankMOMV1(connection, miscTanks[1], miscTanksS[1]),
                CalculationUtils.calculateTankVCG(connection, miscTanks[1], miscTanksS[1]),
                CalculationUtils.calculateTankMOMV2(connection, miscTanks[1], miscTanksS[1]),
                CalculationUtils.calculateTankFS(connection, miscTanks[1], miscTanksS[1])
            )
        );
    
        tankDataList.add(
            new TankData(
                "Nro. 09 Sludge Estribor",
                4.28,
                CalculationUtils.calculateTankWeight(connection, miscTanks[2], miscTanksS[2]),
                CalculationUtils.calculateTankLCG(connection, miscTanks[2], miscTanksS[2]),
                CalculationUtils.calculateTankMOMV1(connection, miscTanks[2], miscTanksS[2]),
                CalculationUtils.calculateTankVCG(connection, miscTanks[2], miscTanksS[2]),
                CalculationUtils.calculateTankMOMV2(connection, miscTanks[2], miscTanksS[2]),
                CalculationUtils.calculateTankFS(connection, miscTanks[2], miscTanksS[2])
            )
        );
    
        tankDataList.add(
            new TankData(
                "Total líquidos misceláneos",
                30.44,
                calc.getTotalTanksWeightMisc(connection, miscTanks, miscTanksS),
                calc.getTotalTanksMOMV1Misc(connection, miscTanks, miscTanksS) / calc.getTotalTanksWeightMisc(connection, miscTanks, miscTanksS),
                calc.getTotalTanksMOMV1Misc(connection, miscTanks, miscTanksS),
                calc.getTotalTanksMOMV2Misc(connection, miscTanks, miscTanksS) / calc.getTotalTanksWeightMisc(connection, miscTanks, miscTanksS),
                calc.getTotalTanksMOMV2Misc(connection, miscTanks, miscTanksS),
                calc.getTotalTanksFSMisc(connection, miscTanks, miscTanksS)
            )
        );

        // Create header
        createTableHeader(sheet, columns, startRow);

        // Populate data rows
        int rowNum = startRow + 1;
        for (TankData tankData : tankDataList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(tankData.getName());
            row.createCell(1).setCellValue(tankData.getCapacidad());
            row.createCell(2).setCellValue(tankData.getPesos());
            row.createCell(3).setCellValue(tankData.getLcg());
            row.createCell(4).setCellValue(tankData.getMomv1());
            row.createCell(5).setCellValue(tankData.getVcg());
            row.createCell(6).setCellValue(tankData.getMomv2());
            row.createCell(7).setCellValue(tankData.getSuperficieLibre());
        }
        
        // Resize columns
        resizeColumns(sheet, columns.length);

        // Create table
        createTable(sheet, workbook, "MiscTable", 4L, startRow, rowNum, columns.length);
    }

    public void createShipTable(XSSFWorkbook workbook, XSSFSheet sheet, Connection connection, double[] ballastTanks, String[] ballastTanksS, double[] fwTanks, String[] fwTanksS, double[] dieselTanks, String[] dieselTanksS, double[] miscTanks, String[] miscTanksS) throws SQLException {
        String[] columns = {
                "Descripción", "Pesos (Ton. M)", "LCG metros",
                "MOMV 1 (mts - TM)", "VCG metros", "MOMV 2 (mts - TM)", "Superficie Libre mts-TM"
        };

        List<ShipData> shipDataList = new ArrayList<>();
        
        shipDataList.add(
            new ShipData(
                "Buque Ligero",
                CalculationUtils.getDataFromDB("Weight", "Light_Ship"),
                CalculationUtils.getDataFromDB("LCG", "Light_Ship"),
                CalculationUtils.getDataFromDB("MOMV1", "Light_Ship"),
                CalculationUtils.getDataFromDB("VCG", "Light_Ship"),
                CalculationUtils.getDataFromDB("MOMV2", "Light_Ship"),
                0
            )
        );
        
        shipDataList.add(
            new ShipData(
                "Tripulación - Efectos",
                CalculationUtils.getDataFromDB("Weight", "Crew_PersonalEffects"),
                CalculationUtils.getDataFromDB("LCG", "Crew_PersonalEffects"),
                CalculationUtils.getDataFromDB("MOMV1", "Crew_PersonalEffects"),
                CalculationUtils.getDataFromDB("VCG", "Crew_PersonalEffects"),
                CalculationUtils.getDataFromDB("MOMV2", "Crew_PersonalEffects"),
                0
            )
        );

        shipDataList.add(
            new ShipData(
                "Total pañoles",
                CalculationUtils.getDataFromDB("Weight", "Total_Store"),
                CalculationUtils.getDataFromDB("LCG", "Total_Store"),
                CalculationUtils.getDataFromDB("MOMV1", "Total_Store"),
                CalculationUtils.getDataFromDB("VCG", "Total_Store"),
                CalculationUtils.getDataFromDB("MOMV2", "Total_Store"),
                0
            )
        );

        shipDataList.add(
            new ShipData(
                "Pasajeros",
                CalculationUtils.getDataFromDB("Weight", "Passengers"),
                CalculationUtils.getDataFromDB("LCG", "Passengers"),
                CalculationUtils.getDataFromDB("MOMV1", "Passengers"),
                CalculationUtils.getDataFromDB("VCG", "Passengers"),
                CalculationUtils.getDataFromDB("MOMV2", "Passengers"),
                0
            )
        );

        shipDataList.add(
            new ShipData(
                "Equipaje",
                CalculationUtils.getDataFromDB("Weight", "Luggage"),
                CalculationUtils.getDataFromDB("LCG", "Luggage"),
                CalculationUtils.getDataFromDB("MOMV1", "Luggage"),
                CalculationUtils.getDataFromDB("VCG", "Luggage"),
                CalculationUtils.getDataFromDB("MOMV2", "Luggage"),
                0
            )
        );

        shipDataList.add(
            new ShipData(
                "Equipo Exp.",
                CalculationUtils.getDataFromDB("Weight", "Expedition_Gear"),
                CalculationUtils.getDataFromDB("LCG", "Expedition_Gear"),
                CalculationUtils.getDataFromDB("MOMV1", "Expedition_Gear"),
                CalculationUtils.getDataFromDB("VCG", "Expedition_Gear"),
                CalculationUtils.getDataFromDB("MOMV2", "Expedition_Gear"),
                0
            )
        );

        shipDataList.add(
            new ShipData(
                "Total Agua de Lastre",
                calc.getTotalTanksWeightBallast(connection, ballastTanks, ballastTanksS),
                calc.getTotalTanksMOMV1Ballast(connection, ballastTanks, ballastTanksS) / calc.getTotalTanksWeightBallast(connection, ballastTanks, ballastTanksS),
                calc.getTotalTanksMOMV1Ballast(connection, ballastTanks, ballastTanksS),
                calc.getTotalTanksMOMV2Ballast(connection, ballastTanks, ballastTanksS) / calc.getTotalTanksWeightBallast(connection, ballastTanks, ballastTanksS),
                calc.getTotalTanksMOMV2Ballast(connection, ballastTanks, ballastTanksS),
                calc.getTotalTanksFSBallast(connection, ballastTanks, ballastTanksS)
            )
        );

        shipDataList.add(
            new ShipData(
                "Total Agua Dulce",
                calc.getTotalTanksWeightFW(connection, fwTanks, fwTanksS),
                calc.getTotalTanksMOMV1FW(connection, fwTanks, fwTanksS) / calc.getTotalTanksWeightFW(connection, fwTanks, fwTanksS),
                calc.getTotalTanksMOMV1FW(connection, fwTanks, fwTanksS),
                calc.getTotalTanksMOMV2FW(connection, fwTanks, fwTanksS) / calc.getTotalTanksWeightFW(connection, fwTanks, fwTanksS),
                calc.getTotalTanksMOMV2FW(connection, fwTanks, fwTanksS),
                calc.getTotalTanksFSFW(connection, fwTanks, fwTanksS)
            )
        );

        shipDataList.add(
            new ShipData(
                "Total Diesel Oil",
                calc.getTotalTanksWeightDiesel(connection, dieselTanks, dieselTanksS),
                calc.getTotalTanksMOMV1Diesel(connection, dieselTanks, dieselTanksS) / calc.getTotalTanksWeightDiesel(connection, dieselTanks, dieselTanksS),
                calc.getTotalTanksMOMV1Diesel(connection, dieselTanks, dieselTanksS),
                calc.getTotalTanksMOMV2Diesel(connection, dieselTanks, dieselTanksS) / calc.getTotalTanksWeightDiesel(connection, dieselTanks, dieselTanksS),
                calc.getTotalTanksMOMV2Diesel(connection, dieselTanks, dieselTanksS),
                calc.getTotalTanksFSDiesel(connection, dieselTanks, dieselTanksS)
            )
        );

        shipDataList.add(
            new ShipData(
                "Total Líquidos Misceláneos",
                calc.getTotalTanksWeightMisc(connection, miscTanks, miscTanksS),
                calc.getTotalTanksMOMV1Misc(connection, miscTanks, miscTanksS) / calc.getTotalTanksWeightMisc(connection, miscTanks, miscTanksS),
                calc.getTotalTanksMOMV1Misc(connection, miscTanks, miscTanksS),
                calc.getTotalTanksMOMV2Misc(connection, miscTanks, miscTanksS) / calc.getTotalTanksWeightMisc(connection, miscTanks, miscTanksS),
                calc.getTotalTanksMOMV2Misc(connection, miscTanks, miscTanksS),
                calc.getTotalTanksFSMisc(connection, miscTanks, miscTanksS)
            )
        );

        double totalTanksWeightBallast = calc.getTotalTanksWeightBallast(connection, ballastTanks, ballastTanksS);
            double totalTanksWeightDiesel = calc.getTotalTanksWeightDiesel(connection, dieselTanks, dieselTanksS);
            double totalTanksWeightFW = calc.getTotalTanksWeightFW(connection, fwTanks, fwTanksS);
            double totalTanksWeightMisc = calc.getTotalTanksWeightMisc(connection, miscTanks, miscTanksS);

            double totalTanksFSBallast = calc.getTotalTanksFSBallast(connection, ballastTanks, ballastTanksS);
            double totalTanksFSDiesel = calc.getTotalTanksFSDiesel(connection, dieselTanks, dieselTanksS);
            double totalTanksFSFW = calc.getTotalTanksFSFW(connection, fwTanks, fwTanksS);
            double totalTanksFSMisc = calc.getTotalTanksFSMisc(connection, miscTanks, miscTanksS);

            double totalTanksMOMV1Ballast = calc.getTotalTanksMOMV1Ballast(connection, ballastTanks, ballastTanksS);
            double totalTanksMOMV1Diesel = calc.getTotalTanksMOMV1Diesel(connection, dieselTanks, dieselTanksS);
            double totalTanksMOMV1FW = calc.getTotalTanksMOMV1FW(connection, fwTanks, fwTanksS);
            double totalTanksMOMV1Misc = calc.getTotalTanksMOMV1Misc(connection, miscTanks, miscTanksS);

            double totalTanksMOMV2Ballast = calc.getTotalTanksMOMV2Ballast(connection, ballastTanks, ballastTanksS);
            double totalTanksMOMV2Diesel = calc.getTotalTanksMOMV2Diesel(connection, dieselTanks, dieselTanksS);
            double totalTanksMOMV2FW = calc.getTotalTanksMOMV2FW(connection, fwTanks, fwTanksS);
            double totalTanksMOMV2Misc = calc.getTotalTanksMOMV2Misc(connection, miscTanks, miscTanksS);

            double totalTanksWeight = calc.sum4Values(totalTanksWeightBallast, totalTanksWeightDiesel, totalTanksWeightFW, totalTanksWeightMisc);
            double totalTanksFS = calc.sum4Values(totalTanksFSBallast, totalTanksFSDiesel, totalTanksFSFW, totalTanksFSMisc);
            double totalTanksMOMV1 = calc.sum4Values(totalTanksMOMV1Ballast, totalTanksMOMV1Diesel, totalTanksMOMV1FW, totalTanksMOMV1Misc);
            double totalTanksMOMV2 = calc.sum4Values(totalTanksMOMV2Ballast, totalTanksMOMV2Diesel, totalTanksMOMV2FW, totalTanksMOMV2Misc);

            double totalShipWeight;
            double totalShipMOMV2;
            double totalDataMOMV2 = CalculationUtils.getTotalShipDataMOMV2(connection);
            double totalShipMOMV1;
            double totalDataMOMV1 = CalculationUtils.getTotalShipDataMOMV1(connection);
            double totalDataWeight = CalculationUtils.getTotalShipDataWeight(connection);
            totalShipWeight = CalculationUtils.calculateTotalShipWeight(totalDataWeight, totalTanksWeight);
            totalShipMOMV2 = CalculationUtils.calculateTotalShipMOMV2(totalDataMOMV2, totalTanksMOMV2);
            totalShipMOMV1 = CalculationUtils.calculateTotalShipMOMV1(totalDataMOMV1, totalTanksMOMV1);

        shipDataList.add(
            new ShipData(
                "Peso Total Buque",
                totalShipWeight,
                totalShipMOMV1 / totalShipWeight,
                totalShipMOMV1,
                totalShipMOMV2 / totalShipWeight,
                totalShipMOMV2,
                totalTanksFS
            )
        );
    
        // Create header
        createTableHeader(sheet, columns, 0);

        // Populate data rows
        int rowNum = 1;
        for (ShipData shipData : shipDataList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(shipData.getName());
            row.createCell(1).setCellValue(shipData.getPesos());
            row.createCell(2).setCellValue(shipData.getLcg());
            row.createCell(3).setCellValue(shipData.getMomv1());
            row.createCell(4).setCellValue(shipData.getVcg());
            row.createCell(5).setCellValue(shipData.getMomv2());
            row.createCell(6).setCellValue(shipData.getSuperficieLibre());
        }
        
        // Resize columns
        resizeColumns(sheet, columns.length);

        // Create table
        createTable(sheet, workbook, "Ship", 5L, 0, rowNum, columns.length);
    }

    public void createResultTable(XSSFWorkbook workbook, XSSFSheet sheet, int startRow, Connection connection, double[] ballastTanks, String[] ballastTanksS, double[] fwTanks, String[] fwTanksS, double[] dieselTanks, String[] dieselTanksS, double[] miscTanks, String[] miscTanksS) throws SQLException {
        String[] columns = {
            "Descripción", "Valores"
    };
        
        double cPort = Math.round(calculator.getCPort(
            ballastTanksS, 
            fwTanksS, 
            dieselTanksS, 
            miscTanksS, 
            ballastTanks, 
            fwTanks, 
            dieselTanks, 
            miscTanks
        ) * 1000.0) / 1000.0;

        double cStarboard = Math.round(calculator.getCStarboard(
            ballastTanksS, 
            fwTanksS, 
            dieselTanksS, 
            miscTanksS, 
            ballastTanks, 
            fwTanks, 
            dieselTanks, 
            miscTanks
        ) * 1000.0) / 1000.0;

        double km = Math.round(calculator.getKM(
            ballastTanksS, 
            fwTanksS, 
            dieselTanksS, 
            miscTanksS, 
            ballastTanks, 
            fwTanks, 
            dieselTanks, 
            miscTanks
        ) * 1000.0) / 1000.0;
        
        double kg = Math.round(calculator.getKG(
            ballastTanksS, 
            fwTanksS, 
            dieselTanksS, 
            miscTanksS, 
            ballastTanks, 
            fwTanks, 
            dieselTanks, 
            miscTanks
        ) * 1000.0) / 1000.0;

        double gm = Math.round(calculator.getGM(
            ballastTanksS, 
            fwTanksS, 
            dieselTanksS, 
            miscTanksS, 
            ballastTanks, 
            fwTanks, 
            dieselTanks, 
            miscTanks
        ) * 1000.0) / 1000.0;

        // Create header
        createTableHeader(sheet, columns, startRow + 1);

        // Populate data rows
        int rowNum = startRow + 2;
        

            Row row1 = sheet.createRow(rowNum++);
            row1.createCell(0).setCellValue("C. Proa");
            row1.createCell(1).setCellValue(cPort);
            Row row2 = sheet.createRow(rowNum++);
            row2.createCell(0).setCellValue("C. Popa");
            row2.createCell(1).setCellValue(cStarboard);
            Row row3 = sheet.createRow(rowNum++);
            row3.createCell(0).setCellValue("KM");
            row3.createCell(1).setCellValue(km);
            Row row4 = sheet.createRow(rowNum++);
            row4.createCell(0).setCellValue("KG");
            row4.createCell(1).setCellValue(kg);
            Row row5 = sheet.createRow(rowNum++);
            row5.createCell(0).setCellValue("GM");
            row5.createCell(1).setCellValue(gm);


        
        // Resize columns
        resizeColumns(sheet, columns.length);

        // Create table
        createTable(sheet, workbook, "Results", 6L, startRow + 1, rowNum, columns.length);
        
    }

    private static void createTableHeader(XSSFSheet sheet, String[] columns, int rowIndex) {
        XSSFWorkbook workbook = sheet.getWorkbook();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(rowIndex);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
    }

    private static void resizeColumns(XSSFSheet sheet, int numColumns) {
        for (int i = 0; i < numColumns; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private static void createTable(XSSFSheet sheet, XSSFWorkbook workbook, String displayName, long tableId, int startRow, int endRow, int numColumns) {
        XSSFTable table = sheet.createTable(null);
        CTTable cttable = table.getCTTable();

        AreaReference reference = new AreaReference(
                new CellReference(startRow, 0),
                new CellReference(endRow - 1, numColumns - 1),
                workbook.getSpreadsheetVersion()
        );
        cttable.setRef(reference.formatAsString());

        cttable.setDisplayName(displayName);
        cttable.setName(displayName);
        cttable.setId(tableId);

        CTTableColumns columns = cttable.addNewTableColumns();
        columns.setCount(numColumns);
        for (int i = 0; i < numColumns; i++) {
            CTTableColumn column = columns.addNewTableColumn();
            column.setId(i + 1);
            column.setName(sheet.getRow(startRow).getCell(i).getStringCellValue());
        }

        CTTableStyleInfo styleInfo = cttable.addNewTableStyleInfo();
        styleInfo.setName("TableStyleMedium1");
        styleInfo.setShowColumnStripes(false);
        styleInfo.setShowRowStripes(true);
    }
}