// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveTrain extends SubsystemBase {
    WPI_TalonSRX leftController = new WPI_TalonSRX(Constants.leftControllerPort);
    WPI_TalonSRX rightController = new WPI_TalonSRX(Constants.rightControllerPort);
  /** Creates a new DriveTrain. */
  public DriveTrain() {
      
  }

  public void setPercentage (double left, double right) {
      leftController.set(-1 * left);
      rightController.set(-1 * right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
