package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
  private final DifferentialDrive m_robotDrive
      = new DifferentialDrive(new PWMVictorSPX(0), new PWMVictorSPX(1));
  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();

  @Override
  public void robotInit() { // run at start 
  }

  @Override
  public void autonomousInit() { // run on the initilization of autonomous
    m_timer.reset();
    m_timer.start();
  }

  @Override
  public void autonomousPeriodic() { // this is called periodically during autonomous 
    // Drive for 2 seconds
    if (m_timer.get() < 2.0) {
      m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards half speed
    } else {
      m_robotDrive.stopMotor(); // stop robot
    }
  }

  @Override
  public void teleopInit() { // this is called once when the robot enters teleoperated mode 
  }

  @Override
  public void teleopPeriodic() { // this is called periodically 
    m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
  }

  @Override
  public void testPeriodic() { // this is called periodically in test mode 
  }
}
