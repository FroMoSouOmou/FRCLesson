/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

//import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */

  private final WPI_VictorSPX m_leftRearMotor;
  private final WPI_TalonSRX m_leftFrontMotor;
  private final WPI_VictorSPX m_rightRearMotor;
  private final WPI_TalonSRX m_rightFrontMotor;

  private final DifferentialDrive m_drive;

  //private final SpeedControllerGroup m_leftMotors;
  //private final SpeedControllerGroup m_rightMotors;

  public DriveTrain() {
    m_leftRearMotor = new WPI_VictorSPX(DriveTrainConstants.kLeftRearMotorPort);
    m_leftFrontMotor = new WPI_TalonSRX(DriveTrainConstants.kLeftFrontMotorPort);
    m_rightRearMotor = new WPI_VictorSPX(DriveTrainConstants.kRightRearMotorPort);
    m_rightFrontMotor = new WPI_TalonSRX(DriveTrainConstants.kRightFrontMotorPort);
    m_drive = new DifferentialDrive(m_leftRearMotor, m_rightRearMotor);

    //m_leftMotors = new SpeedControllerGroup(m_leftRearMotor, m_leftFrontMotor); //follow ama farklı hali
    //m_rightMotors = new SpeedControllerGroup(m_rightRearMotor, m_rightFrontMotor); //follow ama farklı hali
    //simülasyonda follow çalışmıyor ondan yukarıdaki gibi olmalı, bunlar tanımlanınca differentiabledrive a yazılmalı

    //m_leftRearMotor.setInverted(true); //motor ters bağlıysa böyle yapıp düzeltilebilir
    //m_leftFrontMotor.setInverted(true);

    m_leftFrontMotor.follow(m_leftRearMotor);
    m_rightFrontMotor.follow(m_rightRearMotor);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void joystickDrive(DoubleSupplier linearSpeed, DoubleSupplier angularSpeed) {
    m_drive.arcadeDrive(linearSpeed.getAsDouble(), angularSpeed.getAsDouble());
  }
}
