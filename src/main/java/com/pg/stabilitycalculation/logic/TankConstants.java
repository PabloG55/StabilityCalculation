package com.pg.stabilitycalculation.logic;

public class TankConstants {
    // Ballast tables
    public static final String BALLAST_FOREPEAK = "Ballast_ForePeak";
    public static final String BALLAST_NO_00_C = "Ballast_No00_C";
    public static final String BALLAST_NO_01_C = "Ballast_No01_C";
    public static final String BALLAST_NO_02_C = "Ballast_No02_C";
    public static final String BALLAST_NO_03_C = "Ballast_No03_C";
    public static final String BALLAST_NO_04_C = "Ballast_No04_C";
    public static final String BALLAST_NO_05_C = "Ballast_No05_C";
    public static final String BALLAST_NO_06_C = "Ballast_No06_C";


    // Fresh water tables
    public static final String FRESH_WATER_PORT_NO05 = "FreshWater_ManualPort_No05";
    public static final String FRESH_WATER_MAGNETIC_PORT_NO05 = "FreshWater_MagneticPort_No05";
    public static final String FRESH_WATER_STARBOARD_NO05 = "FreshWater_ManualStarboard_No05";
    public static final String FRESH_WATER_MAGNETIC_STARBOARD_NO05 = "FreshWater_MagneticStarboard_No05";
    public static final String FRESH_WATER_PORT_NO06 = "FreshWater_ManualPort_No06";
    public static final String FRESH_WATER_MAGNETIC_PORT_NO06 = "FreshWater_MagneticPort_No06";
    public static final String FRESH_WATER_STARBOARD_NO06 = "FreshWater_ManualStarboard_No06";
    public static final String FRESH_WATER_MAGNETIC_STARBOARD_NO06 = "FreshWater_MagneticStarboard_No06";

    // Diesel oil tables
    public static final String DIESEL_OIL_PORT_NO03 = "DieselOilPort_No03";
    public static final String DIESEL_OIL_STARBOARD_NO03 = "DieselOilStarboard_No03";
    public static final String DIESEL_OIL_PORT_NO04 = "DieselOilPort_No04";
    public static final String DIESEL_OIL_STARBOARD_NO04 = "DieselOilStarboard_No04";
    public static final String DIESEL_OIL_PORT_NO07 = "DieselOilPort_No07";
    public static final String DIESEL_OIL_STARBOARD_NO07 = "DieselOilStarboard_No07";
    public static final String DIESEL_OIL_EMERGENCY_GENERATOR_PORT = "EmergencyGenerator_Port";

    // Miscellaneous tables
    public static final String MISCELLANEOUS_OILY_WATER_NO07_C = "Miscellaneous_OilyWater_No07_C";
    public static final String MISCELLANEOUS_GRAY_WATER_NO08_C = "Miscellaneous_GrayWater_No08_C";
    public static final String MISCELLANEOUS_SLUDGE_STARBOARD_NO09 = "Miscellaneous_SludgeStarboard_No09";

    //Displacement Rows
    public static final String DC = "DC";
    public static final String DISPS = "DispS"; 
    public static final String TPC = "TPC";
    public static final String MCT = "MCT";
    public static final String LCF = "LCF";
    public static final String LCB = "LCB";
    public static final String KMT = "KMT";
    public static final String KML = "KML";


    public static final String[] BALLAST_TANKS = {
        BALLAST_FOREPEAK,
        BALLAST_NO_00_C,
        BALLAST_NO_01_C,
        BALLAST_NO_02_C,
        BALLAST_NO_03_C,
        BALLAST_NO_04_C,
        BALLAST_NO_05_C,
        BALLAST_NO_06_C,
    };

    public static final String[] FRESH_WATER_TANKS = {
        FRESH_WATER_PORT_NO05,
        FRESH_WATER_MAGNETIC_PORT_NO05,
        FRESH_WATER_STARBOARD_NO05,
        FRESH_WATER_MAGNETIC_STARBOARD_NO05,
        FRESH_WATER_PORT_NO06,
        FRESH_WATER_MAGNETIC_PORT_NO06,
        FRESH_WATER_STARBOARD_NO06,
        FRESH_WATER_MAGNETIC_STARBOARD_NO06,
    };

    public static final String[] DIESEL_TANKS = {
        DIESEL_OIL_PORT_NO03,
        DIESEL_OIL_STARBOARD_NO03,
        DIESEL_OIL_PORT_NO04,
        DIESEL_OIL_STARBOARD_NO04,
        DIESEL_OIL_PORT_NO07,
        DIESEL_OIL_STARBOARD_NO07,
        DIESEL_OIL_EMERGENCY_GENERATOR_PORT,
    };

    public static final String[] MISCELLANEOUS_TANKS = {
        MISCELLANEOUS_GRAY_WATER_NO08_C,
        MISCELLANEOUS_OILY_WATER_NO07_C,
        MISCELLANEOUS_SLUDGE_STARBOARD_NO09,
    };

    public static final String[] ALL_TANKS = {
        BALLAST_FOREPEAK,
        BALLAST_NO_00_C,
        BALLAST_NO_01_C,
        BALLAST_NO_02_C,
        BALLAST_NO_03_C,
        BALLAST_NO_04_C,
        BALLAST_NO_05_C,
        BALLAST_NO_06_C,
        FRESH_WATER_MAGNETIC_PORT_NO05,
        FRESH_WATER_MAGNETIC_PORT_NO06,
        FRESH_WATER_MAGNETIC_STARBOARD_NO05,
        FRESH_WATER_MAGNETIC_STARBOARD_NO06,
        FRESH_WATER_PORT_NO05,
        FRESH_WATER_PORT_NO06,
        FRESH_WATER_STARBOARD_NO05,
        FRESH_WATER_STARBOARD_NO06,
        DIESEL_OIL_PORT_NO03,
        DIESEL_OIL_PORT_NO04,
        DIESEL_OIL_PORT_NO07,
        DIESEL_OIL_STARBOARD_NO03,
        DIESEL_OIL_STARBOARD_NO04,
        DIESEL_OIL_STARBOARD_NO07,
        DIESEL_OIL_EMERGENCY_GENERATOR_PORT,
        MISCELLANEOUS_GRAY_WATER_NO08_C,
        MISCELLANEOUS_OILY_WATER_NO07_C,
        MISCELLANEOUS_SLUDGE_STARBOARD_NO09,
    };
}
