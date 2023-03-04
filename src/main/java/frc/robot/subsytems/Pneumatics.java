package frc.robot.subsytems;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.IntegerPublisher;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
    private final int m_can_id;
    private final Compressor m_compressor;
    private final NetworkTableSubsystem networkTableSubsystem;
    private final IntegerPublisher canPublisher;
    private final DoublePublisher currentPublisher;
    private final DoublePublisher pressurePublisher;
    private final DoublePublisher voltagePublisher;

    public Pneumatics(int can_id, PneumaticsModuleType module_type, NetworkTableSubsystem networkTableSubsystem) {
        m_can_id = can_id;
        m_compressor = new Compressor(can_id, module_type);
        this.networkTableSubsystem = networkTableSubsystem;
        canPublisher = networkTableSubsystem.createIntegerPublisher(getName(), "CAN ID");
        currentPublisher = networkTableSubsystem.creatDoublePublisher(getName(), "current");
        pressurePublisher = networkTableSubsystem.creatDoublePublisher(getName(), "pressure");
        voltagePublisher = networkTableSubsystem.creatDoublePublisher(getName(), "voltage");

        //can_id is not going to change, so let's publish it in the constructor.
        canPublisher.set(can_id);
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

    @Override
    public void periodic() {
        currentPublisher.set(m_compressor.getCurrent());
        voltagePublisher.set(m_compressor.getAnalogVoltage());
        pressurePublisher.set(m_compressor.getPressure());
    }

}
