package cleanManager;

import java.util.HashSet;

import floorPlanManager.Coordinate;
import floorPlanManager.FloorPlanManager;

public class CleanManager {
	private static CleanManager clm = null;
	private int loadlvl;
	private CleanManager(){	
		this.loadlvl = 50;
	}
	public static synchronized CleanManager getInstance(){
		if(clm==null){
			clm = new CleanManager();
		}
		return clm;
	}
	public int getLoad(){
		return this.loadlvl;
		
	}
	public void removeLoad(){
		this.loadlvl --;
	}
	public void dumpLoad(){
		this.loadlvl = 50;
	}
	public boolean isFull(){
		if(this.loadlvl==50){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isAllCleaned(){
		FloorPlanManager fpm = FloorPlanManager.getInstance();
		HashSet<String> allLocation = (HashSet<String>) fpm.getAllCoordinates();
		allLocation.remove(fpm.getCurrentLocation().getStringXY());
		for(String location: allLocation){
			Coordinate co = new Coordinate();
			co.setString(location);
			if(fpm.getPath(fpm.getCurrentLocation().getStringXY(), location)!=null&&fpm.isDirty(co)){
				return false;
			}
			
		}
		return true;
	}
}
