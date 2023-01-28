package frc.robot.subsytems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ParagonSolenoid extends SubsystemBase {
    private final int m_can_id;
    private final int m_channel_id;
    private final Solenoid m_solenoid;
    private final Pneumatics m_Pneumatics;

    public ParagonSolenoid(int can_id, int channel_id, PneumaticsModuleType module_type, String name,
            Pneumatics pnuematics) {
        m_can_id = can_id;
        m_channel_id = channel_id;
        m_solenoid = new Solenoid(can_id, module_type, channel_id);
        m_Pneumatics = pnuematics;

        populate_shuffleboard(name);
    }

    public boolean is_Open() {
        return m_solenoid.get();
    }

    public void toggle() {
        if (m_Pneumatics.is_On()) {
            m_solenoid.toggle();
        } else {
            m_solenoid.set(false);
        }
    }

    private void populate_shuffleboard(String name) {
        setName(name);
        addChild("solenoid", m_solenoid);
        SmartDashboard.putNumber("CAN ID", m_can_id);
        SmartDashboard.putNumber("Solenoid Channel ID", m_channel_id);
    }
}
