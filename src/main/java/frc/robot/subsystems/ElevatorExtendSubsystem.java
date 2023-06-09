// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.ElevatorExtendConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The claw subsystem is a simple system with a motor for opening and closing. If using stronger
 * motors, you should probably use a sensor so that the motors don't stall.
 */
public class ElevatorExtendSubsystem extends SubsystemBase {
  private final CANSparkMax m_leftMotor = new CANSparkMax(ElevatorExtendConstants.kLeftExtendCanId, MotorType.kBrushless);
  private final CANSparkMax m_rightMotor = new CANSparkMax(ElevatorExtendConstants.kRightExtendCanId, MotorType.kBrushless);

  /** Create a new elevator subsystem. */
  public ElevatorExtendSubsystem() {
    // Factory reset, so we get the SPARKS MAX to a known state before configuring
    // them. This is useful in case a SPARK MAX is swapped out.
    m_leftMotor.restoreFactoryDefaults();
    m_rightMotor.restoreFactoryDefaults();

    // Set whether the elevator motor is inverted.
    m_leftMotor.setInverted(ElevatorExtendConstants.kElevatorExtendLeftMotorInverted);
    m_rightMotor.setInverted(ElevatorExtendConstants.kElevatorExtendRightMotorInverted);
  
    // Save the SPARK MAX configurations. If a SPARK MAX browns out during
    // operation, it will maintain the above configurations.
    m_leftMotor.burnFlash();
    m_rightMotor.burnFlash();
  }

  /** Retract the elevator. */
  public void retract() {
    m_leftMotor.set(-ElevatorExtendConstants.kLeftElevatorRetractMotorSpeed);
    m_rightMotor.set(-ElevatorExtendConstants.kRightElevatorRetractMotorSpeed);
  }

  /** Extend the elevator. */
  public void extend() {
    m_leftMotor.set(ElevatorExtendConstants.kLeftElevatorExtendMotorSpeed);
    m_rightMotor.set(ElevatorExtendConstants.kRightElevatorExtendMotorSpeed);
  }

  /** Stops the elevator extend motor from moving. */
  public void stop() {
    m_leftMotor.set(0);
    m_rightMotor.set(0);
  }

  @Override
  public void periodic() {
  }
}
