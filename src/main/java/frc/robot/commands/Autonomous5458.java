package frc.robot.commands;

import frc.robot.subsystems.DistanceSensor;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
//import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.Constants.Auto5458Constants;

public class Autonomous5458 extends SequentialCommandGroup 
{

    public Autonomous5458(Drivetrain drivetrain, DistanceSensor distanceSensor)
    {

        addCommands(

            //Step 1: Drive Forward Till Within 7 Inches of First Block
            drivetrain.runEnd(() -> drivetrain.arcadeDrive(Auto5458Constants.DRIVE_SPEED_SLOW,0),
                                    () -> drivetrain.stop())
                                    .until(() -> distanceSensor.getDistanceInches() <= 7.0),

            //Step 2: Turn Right
            new TurnDegrees(Auto5458Constants.TURN_SPEED_RIGHT, 75.0, drivetrain),

            //Step 3: One Time Drive Conditional Distance to Second Block
            new ConditionalCommand(
                
                //If True
                new DriveDistance(Auto5458Constants.DRIVE_SPEED_FAST,Auto5458Constants.DRIVE_DISTANCE_FAR, drivetrain),

                //Else
                new DriveDistance(Auto5458Constants.DRIVE_SPEED_FAST,Auto5458Constants.DRIVE_DISTANCE_SHORT, drivetrain),
                
                //Checking Distance Value for Conditional
                () -> distanceSensor.getDistanceInches() >= 12.00
                
            ),

            //Step 4: One Time Display Distance to Console
            new InstantCommand(() -> {System.out.println( "Distance: " + distanceSensor.getDistanceInches() + " inches");}, distanceSensor)
            
            
            
            
        
        );
    }

}

// InstantCommand  -> do something once
// RunCommand      -> keep doing something until interrupted/finished
// StartEndCommand -> start once, end with another action
// WaitCommand     -> wait for a period