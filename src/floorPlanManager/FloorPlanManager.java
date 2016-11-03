package floorPlanManager;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;

public class FloorPlanManager {
	private static FloorPlanManager fpm = null;
	private Floor fl;
	private FloorPlanManager(){	
		FloorPlanLoader fpl = new FloorPlanLoaderImpl();
		fl.getInstance();
		fl.loadFloorPlan(fpl.loadFloorPlan());
		
	}
	public static synchronized FloorPlanManager getInstance(){
		if(fpm==null){
			fpm = new FloorPlanManager();
		}
		return fpm;
	}
	
	public LinkedList<Vertex> getPath(String start,String destination){
		FloorMap flm = new FloorMap();
		LinkedList<Vertex> result = new LinkedList<Vertex>();
		flm.createFloorMap();
		result = flm.getPath(start, destination);
		return result;
	}
	public HashSet<String> getAllCoordinates(){
		return fl.getAllCoordinates();
	}
	public void setChargeStationLocation(Coordinate co){
		fl.setChargeStationLocation(co);
		
	}
	public HashSet<String> getChargeStaionLocation(){
		return fl.getChargeStaionLocation();
	}

	public void setCurrentLocation(int x, int y){
		fl.setCurrentLocation(x, y);
	}
	public Coordinate getCurrentLocation(){
		return fl.getCurrentLocation();
	}
	
	public int getSurfaceType(Coordinate co){
	
		return fl.getSurfaceType(co);
	}
	
	public HashSet<String> getOpenNeighbor(Coordinate co){
		
		return fl.getOpenNeighbor(co);
	}
	public HashSet<String> getUnkownNeighbor(Coordinate co){
		
		return fl.getUnkownNeighbor(co);
	}
	public HashSet<String> getObstacleNeighbor(Coordinate co){
		
		return fl.getObstacleNeighbor(co);
	}
}
