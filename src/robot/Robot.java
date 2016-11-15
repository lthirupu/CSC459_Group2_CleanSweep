package robot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

import cleanManager.CleanManager;
import floorPlanManager.Coordinate;
import floorPlanManager.FloorPlanManager;
import floorPlanManager.Vertex;
import powermanagement.PowerManagement;
import powermanagement.VacuumManager;
import sensors.SensorAPI;

public class Robot {
	private FloorPlanManager fpm = FloorPlanManager.getInstance();
	private Coordinate currentLocation;
	private Stack<String> stack;
	private ArrayList<String> visited;
	private CleanManager clm = CleanManager.getInstance();
	private VacuumManager vac = new VacuumManager();
	private PowerManagement pwm = new PowerManagement(vac);
	public Robot(){

		stack = new Stack<String>();
		visited = new ArrayList<String>();
	}
	
	public void start(){
		
		
		currentLocation = fpm.getCurrentLocation();
		//System.out.println(currentLocation.getStringXY());
		stack.push(currentLocation.getStringXY());
		while(!stack.isEmpty()){
			String nextStep = stack.pop();
			String current = currentLocation.getStringXY();
			currentLocation.setString(nextStep);
			
			
			fpm.setCurrentLocation(currentLocation.getX(),currentLocation.getY());
			if(!visited.contains(nextStep)){
				System.out.println("---------------------------");
				System.out.println("Cleaner at: " + current);
				//System.out.println("going from " + current + " to " + nextStep);
				LinkedList<Vertex> paths = fpm.getPath(current, nextStep);
				if(paths != null){
					paths.pop();
				for(Vertex ver: paths){
					System.out.println("Cleaner moving to: " +ver);
					
				}}
				//System.out.println("im at " +nextStep);
				if(fpm.isDirty(currentLocation)){
				clm.removeLoad();
				System.out.println("cleaning at " + nextStep);
				fpm.setDirt(currentLocation, 1);
				System.out.println(clm.isAllCleaned());
				System.out.println("---------------------------");
				}
				//System.out.println("I am at " + fpm.getCurrentLocation().getStringXY());
				getAvailablePath();
				
				visited.add(nextStep);
				
				
				
			}
		
		}
		
		
	}

	private void getAvailablePath() {
		HashSet<String> locations = fpm.getOpenNeighbor(currentLocation);
		for(String location:locations){
			//System.out.println(location);
			stack.push(location);
			
		}
		
	}

	
	public static void main(String[] args){
		
		Robot nv = new Robot();
		nv.start();
		
	}

}

