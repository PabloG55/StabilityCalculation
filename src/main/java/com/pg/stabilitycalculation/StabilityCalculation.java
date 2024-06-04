package com.pg.stabilitycalculation;

import java.sql.*;

import com.pg.stabilitycalculation.igu.Main;
import com.pg.stabilitycalculation.logic.CalculationUtils;
import com.pg.stabilitycalculation.logic.Controller;
import com.pg.stabilitycalculation.logic.TankConstants;

/**
 *
 * @author pgarc
 */

public class StabilityCalculation {

    public void initializeGUI() {
        Main main = new Main();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        StabilityCalculation stabilityCalc = new StabilityCalculation();
        stabilityCalc.initializeGUI();
    }


}