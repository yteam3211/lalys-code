public class ClimbSysem {
    
    private DigitalInput magnetSensorUp = new DigitalInput(Constants.MAGNET_SENSOR_UP);
    private DigitalInput magnetSensorDown = new DigitalInput(Constants.MAGNET_SENSOR_DOWN);
    private VictorSPX climbMotor;

    public ClimbSystem() {
        super("climb");
        climbMotor = new VictorSPX(Constants.CAN_CLIMB_MOTOR);
        climbMotor.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void periodic() {
      getTab().putInDashboard("upSensor", getMagnetModeUp(), false);
      getTab().putInDashboard("downSensor", getMagnetModeDown(), false);
    }

    @Override
    public void setOutput(double output) {
      if(getMagnetModeUp() && output < 0) output = 0;
      if(getSwichModeDown() && output > 0) output = 0;
      climbMotor.set(ControlMode.PercentOutput, output); 
    }

    public boolean getMagnetModeUp(){
        return !magnetSensorUp.get();
    }
    public boolean getMagnetModeDown(){
        return !magnetSensorDown.get();
    }
}
