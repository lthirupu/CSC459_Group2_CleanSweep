package control;

import java.util.ArrayList;
import java.util.Stack;

import floorPlans.GridCellFloorPlan;
import sensors.SensorAPI;

public class NavigationLogic {
	private GridCellFloorPlan floorPlan;
	private SensorAPI sensor;
	private int[] currentLocation;
	private Stack<int[]> stack;
	private ArrayList<int[]> visited;
	public NavigationLogic(GridCellFloorPlan floorPlan, SensorAPI sensor){
		this.floorPlan = floorPlan;
		this.sensor = sensor;
	}
	
	public void start(){
		
		currentLocation = floorPlan.getCurrentLocation();
		stack.push(currentLocation);
		while(!stack.isEmpty()){
			int []nextStep = stack.pop();
			if(!visited.contains(nextStep)){
				floorPlan.updateCurrentLocation(nextStep[0], nextStep[1]);
				getAvailablePath();
				visited.add(nextStep);
			}
			
		}
		
		
	}

	private void getAvailablePath() {
		if(floorPlan.getFrontPath()==0||floorPlan.getFrontPath()==1){
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
	}

}
