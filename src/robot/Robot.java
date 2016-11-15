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

	public Robot() {

		stack = new Stack<String>();
		visited = new ArrayList<String>();
	}

	public void start() {

		currentLocation = fpm.getCurrentLocation();
		if (fpm.isChargeStation(currentLocation)) {
			fpm.setChargeStationLocation(currentLocation);
		}
		// System.out.println(currentLocation.getStringXY());
		for (String co : fpm.getOpenNeighbor(currentLocation)) {
			stack.push(co);

		}

		while (!stack.isEmpty()) {

			String nextStep = stack.pop();
			String current = currentLocation.getStringXY();
			currentLocation.setString(nextStep);

			fpm.setCurrentLocation(currentLocation.getX(), currentLocation.getY());
			if (!visited.contains(nextStep)) {
				System.out.println("---------------------------");

					//System.out.println(fpm.getCostPath("0,2", "0,0"));
					System.out.println("Battery State: " + pwm.getRemainingBattery());
					System.out.println("Cleaner at: " + current);
					pwm.consumeBattery(fpm.getSurfaceType(currentLocation));
					// System.out.println("going from " + current + " to " +
					// nextStep);
					LinkedList<Vertex> paths = fpm.getPath(current, nextStep);
					if (paths != null) {
						paths.pop();
						for (Vertex ver : paths) {
							nextStep = ver.getName();
							System.out.println("Cleaner moving to: " + ver);
							pwm.consumeBattery((int) fpm.getCostPath(current, nextStep));
							current = ver.getName();

						}
					}
					// System.out.println("im at " +nextStep);
					if (fpm.isDirty(currentLocation)) {
						clm.removeLoad();
						System.out.println("cleaning at " + nextStep);
						fpm.setDirt(currentLocation, 1);
						System.out.println(clm.isAllCleaned());
						System.out.println("---------------------------");
					}
					// System.out.println("I am at " +
					// fpm.getCurrentLocation().getStringXY());
					getAvailablePath();

					visited.add(nextStep);
			

			}

		}

	}

	private boolean enoughPower() {
		HashSet<String> chargeStations = new HashSet<String>();
		chargeStations = fpm.getChargeStaionLocation();
		int powerLevel = pwm.getRemainingBattery();
		int cost = 0;
		for (String charge : chargeStations) {
			// System.out.println("cost to "+ charge
			// +fpm.getCostPath(currentLocation.getStringXY(), charge));
			System.out.println(charge + currentLocation.getStringXY());
			if (cost == 0 && cost < fpm.getCostPath(currentLocation.getStringXY(), charge)) {
				cost = (int) fpm.getCostPath(currentLocation.getStringXY(), charge);
			}

		}
		System.out.println("cost to go back station: " + cost);
		if (powerLevel >= cost) {
			System.out.println("enough power");
			return true;
		}
		return false;
	}

	private void getAvailablePath() {
		HashSet<String> locations = fpm.getOpenNeighbor(currentLocation);
		for (String location : locations) {
			// System.out.println(location);
			stack.push(location);

		}

	}

	public static void main(String[] args) {

		Robot nv = new Robot();
		nv.start();

	}

}
