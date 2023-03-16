// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants.GrabberConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** A grabber mechanism actuated by a single {@link DoubleSolenoid}. */
public class GrabberSubsystem extends SubsystemBase {
  private final DoubleSolenoid m_GrabberSolenoid =
      new DoubleSolenoid(
          PneumaticsModuleType.CTREPCM,
          GrabberConstants.kGrabberSolenoidPorts[0],
          GrabberConstants.kGrabberSolenoidPorts[1]);

  /** Grabs the game piece. */
  public void grabGamePiece() {
    m_GrabberSolenoid.set(kForward);
  }

  /** Releases the game piece. */
  public void releaseGamePiece() {
    m_GrabberSolenoid.set(kReverse);
  }

  @Override
  public void initSendable(SendableBuilder builder) {
    super.initSendable(builder);
    // Publish the solenoid state to telemetry.
    builder.addBooleanProperty("extended", () -> m_GrabberSolenoid.get() == kForward, null);
  }
}
