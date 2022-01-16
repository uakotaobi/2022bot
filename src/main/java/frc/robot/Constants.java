// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    /**
     * We need to make an assumption on where the Xbox controllers are plugged in.
     * This value may change if you plug other human input devices into the driver
     * station first.
     */
    public static int XBOX_CONTROLLER_PORT = 0;    
    
    /**
     * Conversion factor for Feet to Meters
     */
    public static double FEET_TO_METERS = 0.3048;
    
    /** 
     * This value is an assumed maximum speed of the robot in meters per second, which we will use for calculations
     * Once the robot is built we will measure and update said speed so that it is more accurate
     */
    public static double ROBOT_MAXIMUM_SPEED_METERS_PER_SECOND = 13 * FEET_TO_METERS;


    
    /**
     * Width of the wheel base in meters from the center of one wheel on the left to the center of one wheel on the right
     */
    public static double WHEEL_BASE_WIDTH_METERS = 22.5/12 * FEET_TO_METERS;

    /**
     * Length of the wheel base in meters from the center of one wheel on the back to the center of one wheel on the front
     */
    public static double WHEEL_BASE_LENGTH_METERS = 22.5/12 * FEET_TO_METERS;

    private static double WHEEL_BASE_DIAGONAL_METERS = 
        Math.sqrt(WHEEL_BASE_WIDTH_METERS * WHEEL_BASE_WIDTH_METERS +
                  WHEEL_BASE_LENGTH_METERS * WHEEL_BASE_LENGTH_METERS);

    /**
     * Robot's maximum rotational velocity in radians per second
     * Value is guessed and needs to be measured
     * 
     * Formula is derived from the robots linear speed divided by the circumference of the circumscribed circle created by the wheel base rectangle
     */
    public static double ROBOT_MAXIMUM_ANGULAR_VELOCITY_RADIANS_PER_SECOND = 
        (2 * Math.PI) * (ROBOT_MAXIMUM_SPEED_METERS_PER_SECOND/(Math.PI * WHEEL_BASE_DIAGONAL_METERS));
}
