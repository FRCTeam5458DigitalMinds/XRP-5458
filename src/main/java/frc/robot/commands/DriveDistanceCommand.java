package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Drivetrain;

import static frc.robot.Constants.DriveConstants.DRIVE_SPEED;

public class DriveDistanceCommand extends Command {

    private final Drivetrain drivetrain;
    private final double targetDistance;

    public DriveDistanceCommand(
            Drivetrain drivetrain,
            double targetDistance) {

        this.drivetrain = drivetrain;
        this.targetDistance = targetDistance;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.resetEncoders();
    }

    @Override
    public void execute() {

        double distance =
                drivetrain.getAverageDistanceMeters();

        if (distance < targetDistance) {
            drivetrain.setMotors(
                DRIVE_SPEED,
                DRIVE_SPEED
            );
        } else {
            drivetrain.stop();
        }
    }

    @Override
    public boolean isFinished() {
        return drivetrain.getAverageDistanceMeters()
                >= targetDistance;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
