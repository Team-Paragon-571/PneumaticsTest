package frc.robot.subsytems;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.IntegerPublisher;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NetworkTableSubsystem extends SubsystemBase {
    private final NetworkTableInstance networkTableInstance;
    public NetworkTableSubsystem(NetworkTableInstance networkTableInstance){
        this.networkTableInstance = networkTableInstance;
    }

    public DoublePublisher creatDoublePublisher(String tableKey, String topicName){
        return networkTableInstance.getTable(tableKey).getDoubleTopic(topicName).publish();
    }

    public IntegerPublisher createIntegerPublisher(String tableKey, String topicName){
        return networkTableInstance.getTable(tableKey).getIntegerTopic(topicName).publish();
    }

}
