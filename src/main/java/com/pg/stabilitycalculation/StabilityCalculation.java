package com.pg.stabilitycalculation;
import com.pg.stabilitycalculation.igu.Lander;


/**
 *
 * @author pgarc
 */

public class StabilityCalculation {

    public void initializeGUI() {
        Lander main = new Lander();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        StabilityCalculation stabilityCalc = new StabilityCalculation();
        stabilityCalc.initializeGUI();
    }
}