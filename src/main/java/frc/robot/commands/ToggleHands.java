package frc.robot.commands;

import java.util.HashSet;
import java.util.Set;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsytems.ParagonSolenoid;

public class ToggleHands implements Command {
    private final ParagonSolenoid m_hands;
    private final int m_channel;
    
    public ToggleHands(ParagonSolenoid solenoid, int channel)
    {
        m_hands = solenoid;
        m_channel = channel;
    }

    @Override
    public Set<Subsystem> getRequirements() {
        Set<Subsystem> set = new HashSet<Subsystem>(1);
        set.add(m_hands);
        return set;
    }
}