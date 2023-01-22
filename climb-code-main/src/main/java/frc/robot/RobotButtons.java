package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ExampleCommand;
import ffrc.robot.command.ClimbCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ClimbSysem;


// Yteam loadButtons
public class RobotButtons {

    // Joysticks:
    public static Joystick driverJoystick = new Joystick(0);

    // Triggers:
    public Trigger climbOpen_X = new Trigger(() -> driverJoystick.getRawButton(1));
    public Trigger climbClose_A = new Trigger(() -> driverJoystick.getRawButton(2));


    public void loadButtons(ClimbSysem climbSysem) {
        // Triggers active
        // ExampleButton.whileActiveOnce(new ExampleCommand(exampleSubsystem));
        climbOpen_X.whileActiveOnce(new ClimbCommand(climbSysem));
        climbClose_A.whileActiveOnce(new ClimbCommand(climbSysem));


    }
}