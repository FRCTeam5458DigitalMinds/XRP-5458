package frc.robot.commands;

import frc.robot.subsystems.DistanceSensor;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.Constants.Auto5458Constants;

public class Autonomous5458 extends SequentialCommandGroup 
{

    public Autonomous5458(Drivetrain drivetrain, DistanceSensor distanceSensor)
    {

        addCommands(

            // Step 1: Drive Forward 8 Inches
            new DriveDistance(Auto5458Constants.DRIVE_SPEED_FAST,Auto5458Constants.DRIVE_DISTANCE_FAR, drivetrain),

            // Step 2: Check for Something in Front of Robot
            new ConditionalCommand(
                
                //If True
                new TurnDegrees(Auto5458Constants.TURN_SPEED_RIGHT, 90.0, drivetrain),

                //Else
                new DriveDistance(Auto5458Constants.DRIVE_SPEED_FAST,Auto5458Constants.DRIVE_DISTANCE_SHORT, drivetrain),
                
                () -> distanceSensor.getDistanceInches() >= 4.0
                
            ),

            // Step 3: Drive Forward Short Distance
            new DriveDistance(Auto5458Constants.DRIVE_SPEED_FAST,Auto5458Constants.DRIVE_DISTANCE_FAR, drivetrain)
        
        );
    }

}
