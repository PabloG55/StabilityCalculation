/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pg.stabilitycalculation.igu;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author pgarc
 */
public class SwingUtilities {
    public static double parseDoubleFromTextField(JTextField textField) {
        try {
            return Double.parseDouble(textField.getText());
        } catch (NumberFormatException e) {
            // Display an error message to the user
            JOptionPane.showMessageDialog(null, "Please enter a valid number in " + textField.getName(), "Input Error", JOptionPane.ERROR_MESSAGE);
            // Return a special value (e.g., Double.NaN) or let the caller handle the default behavior
            return 0; // Indicates an invalid value
        }
    }
}