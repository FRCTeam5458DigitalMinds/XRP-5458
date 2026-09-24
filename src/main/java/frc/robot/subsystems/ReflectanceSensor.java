package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ReflectanceSensor extends SubsystemBase
{

    // XRP reflectance sensor connections
    private final AnalogInput leftSensor = new AnalogInput(0);
    private final AnalogInput rightSensor = new AnalogInput(1);

    // Starting threshold.
    // Adjust this after looking at the sensor voltages.
    private static final double LINE_THRESHOLD = 2.0;

    public double getLeftVoltage() {
        return leftSensor.getVoltage();
    }

    public double getRightVoltage() {
        return rightSensor.getVoltage();
    }

    public boolean leftSeesLine() {
        return getLeftVoltage() > LINE_THRESHOLD;
    }

    public boolean rightSeesLine() {
        return getRightVoltage() > LINE_THRESHOLD;
    }

    public boolean lineDetected() {
        return leftSeesLine() || rightSeesLine();
    }

    public boolean lineLost() {
        return !lineDetected();
    }


    @Override
    public void periodic() {

    }

}
