package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.xrp.XRPGyro;
import edu.wpi.first.wpilibj.xrp.XRPMotor;

import static frc.robot.Constants.DriveConstants.*;

public class Drivetrain extends SubsystemBase {

    private final XRPMotor leftMotor = new XRPMotor(LEFT_MOTOR);
    private final XRPMotor rightMotor = new XRPMotor(RIGHT_MOTOR);

    private final Encoder leftEncoder =
            new Encoder(LEFT_ENCODER_A, LEFT_ENCODER_B);

    private final Encoder rightEncoder =
            new Encoder(RIGHT_ENCODER_A, RIGHT_ENCODER_B);

    private final XRPGyro gyro = new XRPGyro();

    public Drivetrain() {

        // XRP's right motor runs in the opposite physical direction.
        rightMotor.setInverted(true);

        // Configure encoder distance in meters.
        double distancePerPulse =
                (Math.PI * WHEEL_DIAMETER_METERS)
                / ENCODER_COUNTS_PER_REVOLUTION;

        leftEncoder.setDistancePerPulse(distancePerPulse);
        rightEncoder.setDistancePerPulse(distancePerPulse);

        resetEncoders();
        resetGyro();
    }

    public void setMotors(double leftSpeed, double rightSpeed) {
        leftMotor.set(leftSpeed);
        rightMotor.set(rightSpeed);
    }

    public void stop() {
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }

    public double getLeftDistanceMeters() {
        return leftEncoder.getDistance();
    }

    public double getRightDistanceMeters() {
        return rightEncoder.getDistance();
    }

    public double getAverageDistanceMeters() {
        return (Math.abs(getLeftDistanceMeters())
                + Math.abs(getRightDistanceMeters())) / 2.0;
    }

    public double getGyroAngle() {
        return gyro.getAngle();
    }

    public void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    public void resetGyro() {
        gyro.reset();
    }

    public void resetSensors() {
        resetEncoders();
        resetGyro();
    }

    @Override
    public void periodic() {
        // Optional telemetry for debugging.
    }
}