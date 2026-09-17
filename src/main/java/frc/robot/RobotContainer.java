// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

import static frc.robot.Constants.DriveConstants.*;

import frc.robot.commands.DriveDistanceCommand;

import frc.robot.commands.TurnCommand;
import frc.robot.subsystems.Drivetrain;


public class RobotContainer {

    private final Drivetrain drivetrain = new Drivetrain();

    public RobotContainer() {
        // No controller or joystick required.
    }

    public Command getAutonomousCommand() {

        return Commands.sequence(

            // Reset sensors before beginning.
            Commands.runOnce(
                drivetrain::resetSensors,
                drivetrain
            ),

            // Drive forward 1 meter.
            new DriveDistanceCommand(
                drivetrain,
                DISTANCE_1_METERS
            ),

            // Turn 90 degrees.
            new TurnCommand(
                drivetrain,
                TURN_ANGLE_DEGREES
            ),

            // Drive forward another 1 meter.
            new DriveDistanceCommand(
                drivetrain,
                DISTANCE_2_METERS
            ),

            // Stop.
            Commands.runOnce(
                drivetrain::stop,
                drivetrain
            )
        );
    }

    private static final double DISTANCE_1_METERS = Constants.DriveConstants.DISTANCE_1_METERS;

    private static final double DISTANCE_2_METERS = Constants.DriveConstants.DISTANCE_2_METERS;
}