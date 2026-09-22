package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.xrp.XRPRangefinder;

public class DistanceSensor extends SubsystemBase 
{

    private final XRPRangefinder rangefinder = new XRPRangefinder();

    public double getDistanceMeters() 
    {
        return rangefinder.getDistanceMeters();
    }

    public double getDistanceInches() 
    {
        return rangefinder.getDistanceInches();
    }
    
}
