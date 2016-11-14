package control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import floorPlanManager.Coordinate;
import floorPlanManager.FloorPlanManager;

import sensors.SensorAPI;

public class NavigationLogic {
	private FloorPlanManager fpm = FloorPlanManager.getInstance();
	private SensorAPI sensor ;
	private Coordinate currentLocation;
	private Stack<String> stack;
	private ArrayList<String> visited;
	public NavigationLogic(){
		sensor = new SensorAPI();
		stack = new Stack<String>();
		visited = new ArrayList<String>();
	}
	
	public void start(){
		
		
		currentLocation = fpm.getCurrentLocation();
		//System.out.println(currentLocation.getStringXY());
		stack.push(currentLocation.getStringXY());
		while(!stack.isEmpty()){
			
			String nextStep = stack.pop();
			System.out.println("im at" +nextStep);
			if(!visited.contains(nextStep)){
				fpm.setCurrentLocation(currentLocation.getX(),currentLocation.getY());
				//System.out.println("I am at " + fpm.getCurrentLocation().getStringXY());
				updateAvailablePath();
				getAvailablePath();
				visited.add(nextStep);
			}
			
		}
		
		
	}

	private void getAvailablePath() {
		HashSet<String> locations = fpm.getOpenNeighbor(currentLocation);
		for(String location:locations){
			System.out.println(location);
			stack.push(location);
			
		}
		
	}

	private void updateAvailablePath() {
		if(sensor.frontObstacle()){
			System.out.println("front blocked");
			fpm.updatePath(currentLocation.getStringXY(), "front", 2);
		}else{
			fpm.updatePath(currentLocation.getStringXY(), "front", 1);
		}
		if(sensor.rightObstacle()){
			System.out.println("right blocked");
			fpm.updatePath(currentLocation.getStringXY(), "right", 2);
		}else{
			fpm.updatePath(currentLocation.getStringXY(), "right", 1);
		}
		if(sensor.rearObstacle()){
			System.out.println("rear blocked");
			fpm.updatePath(currentLocation.getStringXY(), "back", 2);
		}else{
			fpm.updatePath(currentLocation.getStringXY(), "back", 1);
		}
		if(sensor.leftObstacle()){
			System.out.println("left blocked");
			fpm.updatePath(currentLocation.getStringXY(), "left", 2);
		}else{
			fpm.updatePath(currentLocation.getStringXY(), "left", 1);
		}
		
		
		
	}
	public static void main(String[] args){
		
		NavigationLogic nv = new NavigationLogic();
		nv.start();
		
	}

}

