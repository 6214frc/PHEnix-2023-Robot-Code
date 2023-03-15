// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ElevatorRotateSubsystem;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/** Opens the claw for one second. Real robots should use sensors, stalling motors is BAD! */
public class ElevatorRotateBackward extends WaitCommand {
  private final ElevatorRotateSubsystem m_elevatorRotateSubsystem;

  /**
   * Creates a new OpenClaw command.
   *
   * @param claw The claw to use
   */
  public ElevatorRotateBackward(ElevatorRotateSubsystem elevatorRotateSubsystem) {
    super(1);
    m_elevatorRotateSubsystem = elevatorRotateSubsystem;
    addRequirements(m_elevatorRotateSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_elevatorRotateSubsystem.rotateBackward();
    super.initialize();
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    m_elevatorRotateSubsystem.stop();
  }
}
