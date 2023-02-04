package frc.robot.input;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ToggleBrakes;
import frc.robot.commands.ToggleHands;


public class Joystick {
    public static final XboxController.Button ButtonY = XboxController.Button.kY;
    public static final XboxController.Button ButtonX = XboxController.Button.kX;
    public static final XboxController.Button buttonA = XboxController.Button.kA;
    public static final XboxController.Button buttonB = XboxController.Button.kB;

    public Trigger a(ToggleBrakes m_Brakes) {
        return null;
    }

    public Trigger b(ToggleHands m_Hands) {
        return null;
    }


}
