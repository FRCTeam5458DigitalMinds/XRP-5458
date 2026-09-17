package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Drivetrain;

import static frc.robot.Constants.DriveConstants.TURN_SPEED;

public class TurnCommand extends Command {

    private final Drivetrain drivetrain;
    private final double targetAngle;

    public TurnCommand(
            Drivetrain drivetrain,
            double targetAngle) {

        this.drivetrain = drivetrain;
        this.targetAngle = targetAngle;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.resetGyro();
    }

    @Override
    public void execute() {

        double angle = drivetrain.getGyroAngle();

        if (targetAngle > 0) {

            // Turn clockwise.
            drivetrain.setMotors(
                TURN_SPEED,
                -TURN_SPEED
            );

        } else {

            // Turn counter-clockwise.
            drivetrain.setMotors(
                -TURN_SPEED,
                TURN_SPEED
            );
        }
    }

    @Override
    public boolean isFinished() {

        double angle =
                Math.abs(drivetrain.getGyroAngle());

        return angle >= Math.abs(targetAngle);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}