// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunIntakeBackwards;
import frc.robot.commands.RunShooter;
import frc.robot.commands.RunTraversal;
import frc.robot.commands.RunTraversalBackwards;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Traversal;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  // Joystick Declaration
  public final Joystick drvJoy = new Joystick(0); 

  // Subsystems:
  private final DriveTrain driveTrain = new DriveTrain();
  private final Intake intake = new Intake();
  private final Traversal traversal = new Traversal();
  private final Shooter shooter = new Shooter();
  
  // Commands:
  private final ArcadeDrive arcadeDrive = new ArcadeDrive(driveTrain, drvJoy);

  private final RunShooter runShooter = new RunShooter(shooter);

  private final RunIntake runIntake = new RunIntake(intake);
  private final RunIntakeBackwards runIntakeBackwards = new RunIntakeBackwards(intake); 

  private final RunTraversal runTraversal = new RunTraversal(traversal);
  private final RunTraversalBackwards runTraversalBackwards = new RunTraversalBackwards(traversal);
  
  public RobotContainer() {
    driveTrain.setDefaultCommand(arcadeDrive);
    this.configureButtonBindings();
  }
  
  // Buttons: 
  private final JoystickButton shooterButton = new JoystickButton(drvJoy, 1);

  private final JoystickButton traversalButton = new JoystickButton(drvJoy, 3);
  private final JoystickButton traversalBackwardsButton = new JoystickButton(drvJoy, 5);

  private final JoystickButton intakeButton = new JoystickButton(drvJoy, 4); 
  private final JoystickButton intakeBackwardsButton = new JoystickButton(drvJoy, 6); 

  private final JoystickButton intakeTraversal = new JoystickButton(drvJoy, 2);

  private void configureButtonBindings() {
    // Button to control the shooter:
    shooterButton.whileHeld(runShooter); 

    // Buttons to control traversal: 
    traversalButton.whileHeld(runTraversal);
    traversalBackwardsButton.whileHeld(runTraversalBackwards);

    // Buttons to control the intake:
    intakeButton.whileHeld(runIntake); 
    intakeBackwardsButton.whileHeld(runIntakeBackwards);

    // Button that controls both the traversal and intake motors at once: 
    intakeTraversal.whileHeld(runTraversal);
    intakeTraversal.whileHeld(runIntake);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null; //m_autoCommand;
  }

  public double getJoyY(){
    return drvJoy.getY();
  }

  public double getJoyX(){
    return drvJoy.getX();
  }
}
