package frc.robot.commands;

import java.util.Set;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsytems.ParagonSolenoid;

public class ToggleBrakes implements Command {
    private final ParagonSolenoid m_brakes;

    public ToggleBrakes (ParagonSolenoid brakes) {
        m_brakes = brakes;
    }

    @Override
    public Set<Subsystem> getRequirements() {
        
        return null;
    }
    
}   
