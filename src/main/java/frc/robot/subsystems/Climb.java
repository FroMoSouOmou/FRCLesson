/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class Climb extends SubsystemBase {
  /**
   * Creates a new Climb.
   */

  private final DoubleSolenoid m_doubleSolenoid;

  private final Compressor m_compressor;

  public boolean compressorState = false;
  public boolean climbState = false;

  public Climb() {
    m_doubleSolenoid = new DoubleSolenoid(ClimbConstants.kDoubleSolenoidForwardPort,
        ClimbConstants.kDoubleSolenoidReversePort);
    m_compressor = new Compressor(ClimbConstants.kCompressorPort);

    m_compressor.setClosedLoopControl(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void openClimber() {
    m_doubleSolenoid.set(Value.kForward);
  }

  public void closeClimber() {
    m_doubleSolenoid.set(Value.kReverse);
  }

  public void stopClimber() {
    m_doubleSolenoid.set(Value.kOff);
  }

  public void openCompressor() {
    m_compressor.setClosedLoopControl(true);
  }

  public void closeCompressor() {
    m_compressor.setClosedLoopControl(false);
  }
 }
