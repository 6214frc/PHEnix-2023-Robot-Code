// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.ElevatorExtendSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** Closes the claw until the limit switch is tripped. */
public class ElevatorExtend extends CommandBase {
  private final ElevatorExtendSubsystem m_elevatorExtendSubsystem;

  public ElevatorExtend(ElevatorExtendSubsystem elevatorRotateSubsystem) {
    m_elevatorExtendSubsystem = elevatorRotateSubsystem;
    addRequirements(m_elevatorExtendSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_elevatorExtendSubsystem.extend();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    // NOTE: Doesn't stop in simulation due to lower friction causing the
    // can to fall out
    // + there is no need to worry about stalling the motor or crushing the
    // can.
    if (!Robot.isSimulation()) {
      m_elevatorExtendSubsystem.stop();
    }
  }
}
