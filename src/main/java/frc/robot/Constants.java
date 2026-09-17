// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
// constants. This class should not be used for any other purpose. All constants should be declared
// globally (i.e. public static). Do not put anything functional in this class.
// <p>It is advised to statically import this class (or one of its inner classes) wherever the
// constants are needed, to reduce verbosity.
 

package frc.robot;

public final class Constants {

    private Constants() {}

    public static final class DriveConstants {

        // XRP motor channels
        public static final int LEFT_MOTOR = 0;
        public static final int RIGHT_MOTOR = 1;

        // XRP encoder DIO channels
        public static final int LEFT_ENCODER_A = 4;
        public static final int LEFT_ENCODER_B = 5;

        public static final int RIGHT_ENCODER_A = 6;
        public static final int RIGHT_ENCODER_B = 7;

        // XRP hardware specifications
        public static final double WHEEL_DIAMETER_METERS = 0.060;
        public static final double TRACK_WIDTH_METERS = 0.155;

        // 585 counts per wheel revolution
        public static final double ENCODER_COUNTS_PER_REVOLUTION = 585.0;

        // Autonomous parameters
        public static final double DRIVE_SPEED = 0.50;
        public static final double TURN_SPEED = 0.35;

        public static final double DISTANCE_1_METERS = 0.5;
        public static final double TURN_ANGLE_DEGREES = 90.0;
        public static final double DISTANCE_2_METERS = 0.5;

        private DriveConstants() {}
    }
}
