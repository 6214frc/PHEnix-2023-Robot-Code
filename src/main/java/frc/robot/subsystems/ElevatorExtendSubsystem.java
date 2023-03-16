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

  /** Create a new claw subsystem. */
  public ElevatorExtendSubsystem() {

  }

  /** Set the claw motor to move in the open direction. */
  public void retract() {
    m_leftMotor.set(-1);
    m_rightMotor.set(-1);
  }

  /** Set the claw motor to move in the close direction. */
  public void extend() {
    m_leftMotor.set(1);
    m_rightMotor.set(1);
  }

  /** Stops the claw motor from moving. */
  public void stop() {
    m_leftMotor.set(0);
    m_rightMotor.set(0);
  }

  /** Call log method every loop. */
  @Override
  public void periodic() {

  }
}
