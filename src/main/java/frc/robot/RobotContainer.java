// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.InputSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SwerveDriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private InputSubsystem inputSubsystem = null;
  private SwerveDriveSubsystem swerveDriveSubsystem = null;
  private ShooterSubsystem shooterSubsystem = null;

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    inputSubsystem = new InputSubsystem();
    this.swerveDriveSubsystem = new SwerveDriveSubsystem(inputSubsystem);
    shooterSubsystem = new ShooterSubsystem();

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Button hoodUpButton = inputSubsystem.hoodUpButton();
    if (hoodUpButton != null) {
      hoodUpButton.whenHeld(new InstantCommand(() -> {
        shooterSubsystem.raiseHood();
      }));
      hoodUpButton.whenReleased(new InstantCommand(() -> {
        shooterSubsystem.stopHood();
      }));
    }

    Button hoodDownButton = inputSubsystem.hoodDownButton();
    if (hoodDownButton != null) {
      hoodDownButton.whenHeld(new InstantCommand(() -> {
        shooterSubsystem.lowerHood();
      }));
      hoodDownButton.whenReleased(new InstantCommand(() -> {
        shooterSubsystem.stopHood();
      }));
    }
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
