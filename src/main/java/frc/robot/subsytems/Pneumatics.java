package frc.robot.subsytems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
    private final int m_can_id;
    private final Compressor m_compressor;

    public Pneumatics(int can_id, PneumaticsModuleType module_type) {
        m_can_id = can_id;
        m_compressor = new Compressor(can_id, module_type);
        populate_shuffleboard();
    }
    
    public boolean is_enabled() {
        return m_compressor.isEnabled();

    }
    public void turn_On() {
        m_compressor.enableDigital();
    }

    public void turn_Off() {
        m_compressor.disable();
    }

    private void populate_shuffleboard() {
        setName("Pneumatics");
        addChild("Compressor", m_compressor);
        SmartDashboard.putNumber("CAN ID", m_can_id);
    }
}
