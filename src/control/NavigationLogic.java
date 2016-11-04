package control;

import java.util.ArrayList;
import java.util.Stack;

import floorPlanManager.Coordinate;
import floorPlanManager.FloorPlanManager;

import sensors.SensorAPI;

public class NavigationLogic {
	private FloorPlanManager fpm = FloorPlanManager.getInstance();
	private SensorAPI sensor;
	private Coordinate currentLocation;
	private Stack<Coordinate> stack;
	private ArrayList<Coordinate> visited;
	public NavigationLogic(SensorAPI sensor){
	
		this.sensor = sensor;
	}
	
	public void start(){
		
		currentLocation = fpm.getCurrentLocation();
		stack.push(currentLocation);
		while(!stack.isEmpty()){
			Coordinate nextStep = stack.pop();
			if(!visited.contains(nextStep)){
				fpm.setCurrentLocation(nextStep.getX(), nextStep.getY());
				fpm.getOpenNeighbor(nextStep);
				visited.add(nextStep);
			}
			
		}
		
		
	}

	private void getAvailablePath() {
		/*if(fpm.getOpenNeighbor(co)==0||fpm.getFrontPath()==1){
			int[] temp = new int[2];
			temp[0] = currentLocation[0];
			temp[1] = currentLocation[1]+1;
			stack.push(temp);
			}
		else if(floorPlan.getRightPath()==0||floorPlan.getRightPath()==1){
			int[] temp = new int[2];
			temp[0] = currentLocation[0]+1;
			temp[1] = currentLocation[1];
			stack.push(temp);
			}
		else if(floorPlan.getBackPath()==0||floorPlan.getBackPath()==1){
				int[] temp = new int[2];
				temp[0] = currentLocation[0];
				temp[1] = currentLocation[1]-1;
				stack.push(temp);
				}
		else if(floorPlan.getLeftPath()==0||floorPlan.getLeftPath()==1){
					int[] temp = new int[2];
					temp[0] = currentLocation[0]-1;
					temp[1] = currentLocation[1];
					stack.push(temp);
					}
					*/
	}

}
