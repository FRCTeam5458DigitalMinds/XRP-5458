package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.Constants.Auto5458Constants;

public class Autonomous5458 extends SequentialCommandGroup 
{

    public Autonomous5458(Drivetrain drivetrain)
    {
        addCommands(
        new DriveDistance(Auto5458Constants.DRIVE_SPEED_FAST,Auto5458Constants.DRIVE_DISTANCE_FAR, drivetrain),
        new TurnDegrees(Auto5458Constants.TURN_SPEED_RIGHT, 90.0, drivetrain));
    }

}
