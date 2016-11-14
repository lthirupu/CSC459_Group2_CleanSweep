package powermanagement;

public class VacuumManager {
	private BatteryState batteryState;

public VacuumManager(){
	batteryState = new BatteryState();
}
public BatteryState getBattery(){
	return batteryState;
}
}
