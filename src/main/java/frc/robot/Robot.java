package frc.robot;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot {
  private Joystick joystick;
  private Spark compressor;
  private DigitalOutput valve;
  private Timer timer;

  @Override
  public void robotInit() {
    joystick = new Joystick(0);
    compressor = new Spark(0);
    valve = new DigitalOutput(1);
		timer = new Timer();
  }

  @Override
  public void teleopPeriodic() {
    if (timer.get() < 0.5) {
      compressor.set(1);
    } else {
      compressor.set(0);
    }
    if (joystick.getRawButtonPressed(1)) {
      timer.reset();
      timer.start();
    }
    if (joystick.getRawButton(0)) {
      valve.set(true);
    } else {
      valve.set(false);
    }
  }
}
