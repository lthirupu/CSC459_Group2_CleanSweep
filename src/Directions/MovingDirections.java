package Directions;

import FloorPlans.*;
import sensors.*;

public class MovingDirections {

	public void findObstacles(SensorAPI sensor){
		sensor.stairsObstacle();
		sensor.frontObstacle();
		sensor.rearObstacle();
		sensor.leftObstacle();
		sensor.rightObstacle();
	}

	public String getDirections(FloorPlan floorPlan, SensorAPI sensor) {

		findObstacles(sensor);
		int floorArray[] =  new int[2];
		floorArray = floorPlan.getCurrentLocation();
		if (!sensor.isFrontSensor() && !sensor.isBottomSensor()) { 
			floorPlan.updateCurrentLocation(floorArray[0], floorArray[1] + 1);
			return "FRONT";
		}
		else {
			if(!sensor.isLeftSensor()) {
				floorPlan.updateCurrentLocation(floorArray[0] - 1, floorArray[1]);
				return "LEFT";
			}
			else if (!sensor.isRightSensor()) {
				floorPlan.updateCurrentLocation(floorArray[0] + 1, floorArray[1]);
				return "RIGHT";
			}
			else if (!sensor.isRearSensor()) {
				floorPlan.updateCurrentLocation(floorArray[0], floorArray[1] - 1);
				return "BACK";
			}
			if(sensor.isFrontSensor() && sensor.isBottomSensor() && sensor.isLeftSensor() && sensor.isRightSensor() && sensor.isRearSensor()) {
				return "SHUTDOWN";
			}
		}
		return null;

	}
}