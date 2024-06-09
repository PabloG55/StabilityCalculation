package com.pg.stabilitycalculation;
import com.pg.stabilitycalculation.igu.Main;


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