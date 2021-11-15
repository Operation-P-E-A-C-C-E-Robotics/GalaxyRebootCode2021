package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive  extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveTrain driveTrain;
    private final Joystick driveJoy;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public ArcadeDrive(DriveTrain subsystem, Joystick drvJoy) {
      driveTrain = subsystem;
      driveJoy = drvJoy;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }

    /* private double curve(double input){ // COMMENTED OUT CODE 10/25/21
      boolean neg = input < 0;
      input = Math.abs(input);
      if(input < 0.07) return 0;
      double x_stretch = 0.75;
      double root_mult_a = 100;
      double root_mult_b = 100;
      double root_mult_c = 3.5; 
      double root_div = 22.7;
      double x = input*x_stretch;
      double m1 = Math.pow(x, root_mult_a/root_div);
      double m2 = Math.pow(x, root_mult_b/root_div);
      double m3 = Math.pow(x, root_mult_c/root_div);
      double res = Math.sin(m1+m2+m3);
      return neg ? res : -res;
    } */

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double fwd = -driveJoy.getY();
        double rot = -driveJoy.getX();

        driveTrain.setPercentage(fwd + rot, -(fwd - rot));
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}
