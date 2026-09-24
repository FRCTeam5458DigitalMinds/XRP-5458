package frc.robot.commands;

import frc.robot.Constants.Auto5458Constants;
import frc.robot.subsystems.DistanceSensor;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectanceSensor;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// import frc.robot.Constants.Auto5458Constants;

public class Autonomous5458 extends SequentialCommandGroup 
{

    public Autonomous5458(Drivetrain drivetrain, DistanceSensor distanceSensor, ReflectanceSensor reflectanceSensor)
    {

        addCommands(

            //Step 1: Display the Start of 5458 Autos
            Commands.runOnce(() -> System.out.println("Starting 5458 Autos")),

            //Step 2: Drive Forward Till Within 7 Inches of First Block
            drivetrain.runEnd(() -> drivetrain.arcadeDrive(Auto5458Constants.DRIVE_SPEED_SLOW,0),
                                    () -> drivetrain.stop())
                                    .until(() -> distanceSensor.getDistanceInches() <= 7.0),

            //Step 3: Turn Right
            new TurnDegrees(Auto5458Constants.TURN_SPEED_RIGHT, 75.0, drivetrain),

            //Step 4: One Time Drive Conditional Distance to Second Block
            new ConditionalCommand(
                
                //If True
                new DriveDistance(Auto5458Constants.DRIVE_SPEED_SLOW,Auto5458Constants.DRIVE_DISTANCE_JOURNEY, drivetrain),

                //Else
                new DriveDistance(Auto5458Constants.DRIVE_SPEED_SLOW,Auto5458Constants.DRIVE_DISTANCE_MEDIUM, drivetrain),
                
                //Checking Distance Value for Conditional
                () -> distanceSensor.getDistanceInches() >= 14.00
                
            ),

            //Step 5: One Time Display Distance to Console
            new InstantCommand(() -> {System.out.println( "Distance: " + distanceSensor.getDistanceInches() + " inches");}, distanceSensor),
            
            //Step 6: Go Forward till Line Detected
            Commands.runEnd(() -> {drivetrain.arcadeDrive(Auto5458Constants.DRIVE_SPEED_SLOW,0);
                                   System.out.println("Distance: " + distanceSensor.getDistanceInches()
                                                      + " Left Voltage: " + reflectanceSensor.getLeftVoltage());
                                  },
                            () -> drivetrain.stop(),drivetrain)
                            .until(() -> reflectanceSensor.lineDetected())
            
        );
    }

}


//########################################################################
// InstantCommand  -> do something once
// RunCommand      -> keep doing something until interrupted/finished
// StartEndCommand -> start once, end with another action
// WaitCommand     -> wait for a period
//########################################################################

//################################
// //Example 1: Display the Start of 5458 Autos
// Commands.runOnce(() -> System.out.println("Starting 5458 Autos")),
//################################

//################################
// //Example 2: Drive Forward Till Within 7 Inches of First Block
// drivetrain.runEnd(() -> drivetrain.arcadeDrive(Auto5458Constants.DRIVE_SPEED_SLOW,0),
//                         () -> drivetrain.stop())
//                         .until(() -> distanceSensor.getDistanceInches() <= 7.0),
//################################

//################################
// //Example 3: Turn Right
// new TurnDegrees(Auto5458Constants.TURN_SPEED_RIGHT, 75.0, drivetrain),
//################################

//################################
// //Example 4: One Time Drive Conditional Distance to Second Block
// new ConditionalCommand(
    
//     //If True
//     new DriveDistance(Auto5458Constants.DRIVE_SPEED_SLOW,Auto5458Constants.DRIVE_DISTANCE_JOURNEY, drivetrain),

//     //Else
//     new DriveDistance(Auto5458Constants.DRIVE_SPEED_SLOW,Auto5458Constants.DRIVE_DISTANCE_MEDIUM, drivetrain),
    
//     //Checking Distance Value for Conditional
//     () -> distanceSensor.getDistanceInches() >= 14.00
    
// ),
//##################################

//##################################
// //Example 5: One Time Display Distance to Console
// new InstantCommand(() -> {System.out.println( "Distance: " + distanceSensor.getDistanceInches() + " inches");}, distanceSensor)
//##################################

//##################################
// //Example 6: Run Command for Two Seconds
// new RunCommand(
//                 () -> { System.out.println("Distance: " + distanceSensor.getDistanceInches() 
//                                             + " Line Detected: " + reflectanceSensor.lineDetected());

//                         drivetrain.arcadeDrive(Auto5458Constants.DRIVE_SPEED_SLOW,0);

//                         }, drivetrain
                        
//                 ).withTimeout(2.0)
//###################################

//##################################
// //Example 7: Go Forward and Stop When Line Detected
// Commands.runEnd(() -> {drivetrain.arcadeDrive(Auto5458Constants.DRIVE_SPEED_SLOW,0);
//                                    System.out.println("Distance: " + distanceSensor.getDistanceInches()
//                                                       + " Left Voltage: " + reflectanceSensor.getLeftVoltage());
//                                   },
//                             () -> drivetrain.stop(),drivetrain)
//                             .until(() -> reflectanceSensor.lineDetected())
//##################################