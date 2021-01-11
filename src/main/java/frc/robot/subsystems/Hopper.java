/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.HopperConstants;

public class Hopper extends SubsystemBase {
  /**
   * Creates a new Hopper.
   */

  private final WPI_VictorSPX m_hopperLowerMotor;
  private final WPI_VictorSPX m_hopperUpperMotor;
  
  public Hopper() {
    m_hopperLowerMotor = new WPI_VictorSPX(HopperConstants.kHopperLowerMotorPort);
    m_hopperUpperMotor = new WPI_VictorSPX(HopperConstants.kHopperUpperMotorPort);

    m_hopperLowerMotor.follow(m_hopperUpperMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runHopper(double speed) {
    m_hopperUpperMotor.set(speed);
  }

  public void stopHopper() {
    m_hopperUpperMotor.set(0);
  }
}
