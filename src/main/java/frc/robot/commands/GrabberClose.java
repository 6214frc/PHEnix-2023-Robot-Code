// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.GrabberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A simple command that grabs the game piece with the {@link GrabberSubsystem}. Written explicitly for
 * pedagogical purposes. Actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.InstantCommand}.
 */
public class GrabberClose extends CommandBase {
  // The subsystem the command runs on
  private final GrabberSubsystem m_grabberSubsystem;

  public GrabberClose(GrabberSubsystem subsystem) {
    m_grabberSubsystem = subsystem;
    addRequirements(m_grabberSubsystem);
  }

  @Override
  public void initialize() {
    m_grabberSubsystem.grabGamePiece();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
