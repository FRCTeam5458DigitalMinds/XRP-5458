// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

    private RobotContainer robotContainer;
    private Command autonomousCommand;

    @Override
    public void robotInit() {
        robotContainer = new RobotContainer();
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {

        autonomousCommand =
                robotContainer.getAutonomousCommand();

        if (autonomousCommand != null) {
            //autonomousCommand.schedule();
        }
    }

    @Override
    public void teleopInit() {

        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
    }

    @Override
    public void disabledInit() {
        // Nothing required.
    }

    @Override
    public void disabledPeriodic() {
        // Nothing required.
    }

    @Override
    public void autonomousPeriodic() {
        // CommandScheduler handles the autonomous commands.
    }

    @Override
    public void teleopPeriodic() {
        // No teleop controller is being used.
    }

    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic() {
        // Nothing required.
    }
}