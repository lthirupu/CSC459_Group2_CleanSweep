package robot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.logging.Logger;

import cleanManager.CleanManager;
import floorPlanManager.Coordinate;
import floorPlanManager.FloorPlanManager;
import floorPlanManager.Vertex;
import powermanagement.PowerManagement;
import powermanagement.VacuumManager;
import sensors.SensorAPI;

public class Robot {
	private static final Logger LOGGER = Logger.getLogger(Robot.class.getName());

	private FloorPlanManager fpm = FloorPlanManager.getInstance();
	private Coordinate currentLocation;
	private String chargeStation = "0,0";
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
			// currentLocation.setString(nextStep);

			fpm.setCurrentLocation(currentLocation.getX(), currentLocation.getY());
			if (!visited.contains(nextStep)) {
				LOGGER.info("---------------------------");
				System.out.println("---------------------------");
				if (!enoughPower()) {
					LOGGER.info("not enough Power going back to station" + "----remaining power: " + pwm.getRemainingBattery());
					System.out.println("not enough Power going back to station" + "----remaining power: " + pwm.getRemainingBattery());

					LinkedList<Vertex> path = fpm.getPath(currentLocation.getStringXY(), chargeStation);
					String tempNext;
					for (Vertex ver : path) {
						
						tempNext = ver.getName();
						LOGGER.info("Cleaner moving to: " + ver);
						System.out.println("Cleaner moving to: " + ver);
						pwm.consumeBattery((int) fpm.getCostPath(current, tempNext));
						current = ver.getName();
						currentLocation.setString(current);
						LOGGER.info("Cleaner now at: " + currentLocation.getStringXY());
						System.out.println("Cleaner now at: " + currentLocation.getStringXY());

					}
					pwm.setRemainingBattery(100);

				}

				// System.out.println(fpm.getCostPath(current, nextStep));;
				
				System.out.println("Battery State: " + pwm.getRemainingBattery());
				LOGGER.info("Battery State: " + pwm.getRemainingBattery());
				System.out.println("Cleaner now at: " + current);
				LOGGER.info("Cleaner now at: " + current);
				// System.out.println("going from " + current + " to " +
				// nextStep);
				LinkedList<Vertex> paths = fpm.getPath(current, nextStep);
				if (paths != null) {
					paths.pop();
					String tempNext;
					for (Vertex ver : paths) {
						tempNext = ver.getName();
						System.out.println("Cleaner moving to: " + ver);
						LOGGER.info("Cleaner moving to: " + ver);
						pwm.consumeBattery((int) fpm.getCostPath(current, tempNext));
						current = ver.getName();
						currentLocation.setString(current);
						System.out.println("Cleaner now at: " + currentLocation.getStringXY());
						LOGGER.info("Cleaner now at: " + currentLocation.getStringXY());

					}
				}
				// System.out.println("im at " +nextStep);
				if (fpm.isDirty(currentLocation)) {
					clm.removeLoad();
					pwm.consumeBattery(fpm.getSurfaceType(currentLocation));
					System.out.println("cleaning at " + nextStep);
					LOGGER.info("cleaning at " + nextStep);
					fpm.setDirt(currentLocation, 1);
					System.out.println("All Cleaned: " + clm.isAllCleaned());
					LOGGER.info("All Cleaned: " + clm.isAllCleaned());
					System.out.println("---------------------------");
					LOGGER.info("---------------------------");
				}
				// System.out.println("I am at " +
				// fpm.getCurrentLocation().getStringXY());
				getAvailablePath();

				visited.add(nextStep);

			}

		}

	}

	private boolean enoughPower() {
		int powerLevel = pwm.getRemainingBattery();

		if (powerLevel >= fpm.getCostPath(currentLocation.getStringXY(), chargeStation)) {
			System.out.println("enough power");
			LOGGER.info("enough power");
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
