/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  private final WPI_VictorSPX m_intakeMotor;
  public Intake() {
    m_intakeMotor = new WPI_VictorSPX(IntakeConstants.kIntakeMotorPort);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void RunIntake(double speed) {
    m_intakeMotor.set(speed);
  }

  public void StopIntake() {
    m_intakeMotor.set(0);
  }
}
