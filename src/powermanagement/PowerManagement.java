package powermanagement;

public class PowerManagement {
	private int remainingBattery;
	private int maxBattery;
	
	public PowerManagement(VacuumManager manager){
		maxBattery = 100;
		remainingBattery = maxBattery;
	}
public void setRemainingBattery(int remainingBattery){
	if(remainingBattery>= 0 && remainingBattery <=100)
		this.remainingBattery = remainingBattery;
}
public int getRemainingBattery(){
	return remainingBattery;
}

public int getBattery(){
	return BatteryState.getInstance().getBattery();
}
public void setBattery(int battery){
	BatteryState.getInstance().setBattery(battery);	
}
}
