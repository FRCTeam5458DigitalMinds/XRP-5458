package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

public class Autonomous5458 extends Command {

    private final Drivetrain m_drive;

    public Autonomous5458(Drivetrain drive)
    {
        m_drive = drive;
        addRequirements(drive);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_drive.arcadeDrive(0, 0);
        m_drive.resetEncoders();
    } 

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        //m_drive.arcadeDrive(m_speed, 0);

        //
        //Do stuff here
        //
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        //m_drive.arcadeDrive(0, 0);
        m_drive.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }

}
