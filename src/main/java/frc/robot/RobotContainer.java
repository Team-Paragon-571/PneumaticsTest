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
  private final Pneumatics m_pneumatic;
  private final ParagonSolenoid m_hands;
  private final ParagonSolenoid m_brakes;

  public RobotContainer() {
    int can_id = 8;
    int channel_id_hands = 0;
    int channel_id_brakes = 1;
    PneumaticsModuleType type = PneumaticsModuleType.CTREPCM;
    m_pneumatic = new Pneumatics(can_id, type);
    m_hands = new ParagonSolenoid(can_id, channel_id_hands, type, "hands", m_pneumatic);
    m_brakes = new ParagonSolenoid(can_id, channel_id_brakes, type, "brakes", m_pneumatic);

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
