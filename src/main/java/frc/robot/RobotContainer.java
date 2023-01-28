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
  private final ParagonSolenoid m_solenoidhands;
  private final ParagonSolenoid m_solenoidbrake;

  public RobotContainer() {
    int can_id = 8;
    PneumaticsModuleType module_type = PneumaticsModuleType.CTREPCM;
    int channel_id_hands = 0;
    int channel_id_brake = 1;
    String name_hands = "Hands";
    String name_brake = "Brake";
    m_pneumatic = new Pneumatics(can_id, module_type);
    m_solenoidhands = new ParagonSolenoid(can_id, channel_id_hands, module_type, name_hands, m_pneumatic);
    m_solenoidbrake = new ParagonSolenoid(can_id, channel_id_brake, module_type, name_brake, m_pneumatic);

    configureBindings();
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
