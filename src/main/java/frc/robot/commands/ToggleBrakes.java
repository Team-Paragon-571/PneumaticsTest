package frc.robot.commands;

import java.util.HashSet;
import java.util.Set;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsytems.ParagonSolenoid;

public class ToggleBrakes extends CommandBase {
    public final ParagonSolenoid m_brakes;

    public ToggleBrakes(ParagonSolenoid brakes) {
        m_brakes = brakes;
    }

    @Override
    public void execute() {
        m_brakes.toggle();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public Set<Subsystem> getRequirements() {
        HashSet<Subsystem> requirements = new HashSet<>();

        requirements.add(m_brakes);

        return requirements;
    }

}
