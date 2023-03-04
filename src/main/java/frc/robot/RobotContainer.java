// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ToggleBrakes;
import frc.robot.commands.ToggleHands;
import frc.robot.subsytems.ParagonSolenoid;
import frc.robot.subsytems.Pneumatics;

public class RobotContainer {

  private final Pneumatics m_compressor;
  private final ParagonSolenoid m_hands;
  private final ParagonSolenoid m_brakes;
  private XboxController driveStick;

  public RobotContainer() {
    int can_id = 20;
    int brake_channel_id = 1;
    int hand_channel_id = 0;
    PneumaticsModuleType type = PneumaticsModuleType.CTREPCM;

    m_compressor = new Pneumatics(can_id, type);
    m_hands = new ParagonSolenoid(can_id, hand_channel_id, type, "Hands", m_compressor);
    m_brakes = new ParagonSolenoid(can_id, brake_channel_id, type, "Brakes", m_compressor);
    driveStick = new XboxController(0);
    
    configureBindings();
    configureSmartDashboard();
  }

  private void configureBindings() {
    Trigger aButton = new JoystickButton(driveStick, XboxController.Button.kA.value);
    aButton.onTrue(new ToggleHands(m_hands));
    Trigger bButton = new JoystickButton(driveStick, XboxController.Button.kB.value);
    bButton.onTrue(new ToggleBrakes(m_brakes)); 
  }

  public void configureSmartDashboard() {
    SmartDashboard.putData("Toggle Brakes", new ToggleBrakes(m_brakes));
    SmartDashboard.putData("Toggle Hands", new ToggleHands(m_hands));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}