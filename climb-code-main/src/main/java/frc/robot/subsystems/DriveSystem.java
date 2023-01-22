package frc.robot.subsystems;

import frc.util.OutputSystem;
import frc.util.PID.Gains;

public class DriveSystem extends OutputSystem{

    public static final Gains autoGains = new Gains("autoGains", 0, 0, 0, 0, 0);

    public DriveSystem(String nameSystem) {
        super("DriveSystem");
    }

    @Override
    public void setOutput(double output) {
        // TODO Auto-generated method stub
        
    }

    public Gains getAutoGains() {
        return autoGains;
    }
    
}
