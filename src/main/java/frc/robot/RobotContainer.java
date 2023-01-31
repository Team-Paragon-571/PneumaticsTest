// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsytems.ParagonSolenoid;
import frc.robot.subsytems.Pneumatics;

public class RobotContainer {

  private final Pneumatics m_compressor;
  private final ParagonSolenoid m_hands;
  private final ParagonSolenoid m_brakes;

  public RobotContainer() {
    configureBindings();
    int can_id = 8;
    int brake_channel_id = 1;
    int hand_channel_id = 0;
    PneumaticsModuleType type = PneumaticsModuleType.CTREPCM;

    m_compressor = new Pneumatics(can_id, type);
    m_hands = new ParagonSolenoid(can_id, hand_channel_id, type, "Hands", m_compressor);
    m_brakes = new ParagonSolenoid(can_id, brake_channel_id, type, "Brakes", m_compressor);
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}