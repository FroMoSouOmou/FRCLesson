/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.JoystickConstants;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Climb.CloseClimb;
import frc.robot.commands.Climb.OpenClimb;
import frc.robot.commands.Climb.ToggleClimb;
import frc.robot.commands.Climb.ToggleCompressor;
import frc.robot.commands.DriveTrain.JoystickDrive;
import frc.robot.commands.Hopper.RunHopper;
import frc.robot.commands.Intake.RunIntake;
import frc.robot.commands.Shooter.RunShooter;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Intake m_intake = new Intake();
  private final Shooter m_shooter = new Shooter();
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final Climb m_climb = new Climb();
  private final Hopper m_hopper = new Hopper();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private Joystick m_driverController = new Joystick(JoystickConstants.kDriverControllerPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_driveTrain.setDefaultCommand(
        new JoystickDrive(m_driveTrain, () -> m_driverController.getRawAxis(1), () -> -m_driverController.getRawAxis(0)));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_driverController, 1).whileHeld(new RunIntake(m_intake, 0.6));
    new JoystickButton(m_driverController, 2).whileHeld(new RunIntake(m_intake, -0.6));
    new JoystickButton(m_driverController, 3).whileHeld(new RunShooter(m_shooter, 1.0));
    new JoystickButton(m_driverController, 4).whenPressed(new OpenClimb(m_climb));
    new JoystickButton(m_driverController, 5).whenPressed(new CloseClimb(m_climb));
    new JoystickButton(m_driverController, 6).whileHeld(new ToggleCompressor(m_climb));
    new JoystickButton(m_driverController, 7).whileHeld(new ToggleClimb(m_climb));
    new JoystickButton(m_driverController, 8).whileHeld(new RunHopper(m_hopper, 1.0));
    new JoystickButton(m_driverController, 9).whileHeld(new RunHopper(m_hopper, -1.0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
