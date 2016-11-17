package directions;

import floorPlanManager.Coordinate;
import floorPlanManager.FloorPlanManager;
import sensors.*;

public class MovingDirections {

	public void findObstacles(SensorAPI sensor){
		
	}

	public String getDirections(FloorPlanManager floorPlan, SensorAPI sensor) {

		findObstacles(sensor);
		Coordinate co = new Coordinate();
		co = floorPlan.getCurrentLocation();
		if (!sensor.isFrontSensor() && !sensor.isBottomSensor()) { 
			
			floorPlan.setCurrentLocation(co.getX(),co.getY());
			return "FRONT";
		}
		else {
			if(!sensor.isLeftSensor()) {
				floorPlan.setCurrentLocation(co.getX() - 1, co.getY());
				return "LEFT";
			}
			else if (!sensor.isRightSensor()) {
				floorPlan.setCurrentLocation(co.getX() + 1, co.getY());
				return "RIGHT";
			}
			else if (!sensor.isRearSensor()) {
				floorPlan.setCurrentLocation(co.getX(), co.getY());
				return "BACK";
			}
			if(sensor.isFrontSensor() && sensor.isBottomSensor() && sensor.isLeftSensor() && sensor.isRightSensor() && sensor.isRearSensor()) {
				return "SHUTDOWN";
			}
		}
		return null;

	}
}