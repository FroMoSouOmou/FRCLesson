/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.DriveTrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class JoystickDrive extends CommandBase {
  /**
   * Creates a new JoystickDrive.
   */

  private DoubleSupplier m_linearSpeed;
  private DoubleSupplier m_angularSpeed;
  private DriveTrain m_driveTrain;

  public JoystickDrive(DriveTrain driverTrain, DoubleSupplier linearSpeed, DoubleSupplier angularSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_angularSpeed = angularSpeed;
    m_linearSpeed = linearSpeed;
    m_driveTrain = driverTrain;
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrain.joystickDrive(m_linearSpeed, m_angularSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
