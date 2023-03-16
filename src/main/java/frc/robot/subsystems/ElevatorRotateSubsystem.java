// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.ElevatorRotateConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The elevator rotate subsystem is a simple system with two 
 * motors for rotatingthe elevator forward and backward.
 */
public class ElevatorRotateSubsystem extends SubsystemBase {
  private final CANSparkMax m_leftMotor = new CANSparkMax(ElevatorRotateConstants.kLeftRotateCanId, MotorType.kBrushless);
  private final CANSparkMax m_rightMotor = new CANSparkMax(ElevatorRotateConstants.kRightRotateCanId, MotorType.kBrushless);

  /** Create a new elevator rotate subsystem. */
  public ElevatorRotateSubsystem() {


  }

  /** Set the claw motor to move in the open direction. */
  public void rotateBackward() {
    m_leftMotor.set(-1);
    m_rightMotor.set(-1);
  }

  /** Set the claw motor to move in the close direction. */
  public void rotateForward() {
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
