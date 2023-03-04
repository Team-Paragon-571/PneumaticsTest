package frc.robot.commands;

import java.util.HashSet;
import java.util.Set;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsytems.ParagonSolenoid;

public class ToggleHands extends CommandBase {
    public final ParagonSolenoid m_hands;
    private final 

    public ToggleHands(ParagonSolenoid hands) {
        m_hands = hands;
    }

    @Override
    public void execute() {
        m_hands.toggle();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public Set<Subsystem> getRequirements() {
        HashSet<Subsystem> requirements = new HashSet<>();

        requirements.add(m_hands);

        return requirements;
    }
}
