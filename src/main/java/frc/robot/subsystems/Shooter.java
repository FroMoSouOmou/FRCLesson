/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */

  private final WPI_VictorSPX m_shooterFirstMotor;
  private final WPI_VictorSPX m_shooterSecondMotor;

  public Shooter() {
    m_shooterFirstMotor = new WPI_VictorSPX(ShooterConstants.kShooterFirstMotorPort);
    m_shooterSecondMotor = new WPI_VictorSPX(ShooterConstants.kShooterSecondMotorPort);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void RunShooter(double speed) {
    m_shooterFirstMotor.set(speed);
    m_shooterSecondMotor.set(speed);
  }

  public void StopShooter() {
    m_shooterFirstMotor.set(0);
    m_shooterSecondMotor.set(0);
  }
}
