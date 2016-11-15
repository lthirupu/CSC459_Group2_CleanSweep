package floorPlanManager;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

public class FloorPlanManager {
	private static FloorPlanManager fpm = null;
	private Floor fl =  Floor.getInstance();
	private FloorPlanManager(){	
		FloorPlanLoader fpl = new FloorPlanLoaderImpl();
		
		fl.loadFloorPlan(fpl.loadFloorPlan("testplan.xml"));
		
	}
	public static synchronized FloorPlanManager getInstance(){
		if(fpm==null){
			fpm = new FloorPlanManager();
		}
		return fpm;
	}
	public void setDirt(Coordinate co, int dm){
		fl.setDirt(co, dm);
	}
	public boolean isDirty(Coordinate co){
		return fl.isDirty(co);
		
	}
	
	public LinkedList<Vertex> getPath(String start,String destination){
		FloorMap flm = new FloorMap();
		LinkedList<Vertex> result = new LinkedList<Vertex>();
		flm.createFloorMap();
		result = flm.getPath(start, destination);
		return result;
	}
	public void updateTile(String location, Tile tile){
		this.fl.updateTile(location, tile);
	}
	public Set<String> getAllCoordinates(){
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
	
	public void updatePath(String coor,String orientation, int update){
		this.fl.updatePath(coor, orientation, update);
	}
	public static void main(String args[]){
		FloorPlanManager fpm = FloorPlanManager.getInstance();
		Coordinate co = new Coordinate();
		co.setString("0,0");
		Tile tile1 = new Tile(1, 2, 1, 1, 2, false, 0);
		Tile tile2 = new Tile(2, 2, 1, 1, 1, false, 0);
		Tile tile3 = new Tile(3, 2, 2, 1, 1, false, 0);
		Tile tile4 = new Tile(1, 1, 1, 1, 2, false, 0);
		Tile tile5 = new Tile(2, 1, 1, 1, 1, false, 0);
		Tile tile6 = new Tile(3, 1, 2, 1, 1, false, 0);
		Tile tile7 = new Tile(1, 1, 1, 2, 2, false, 0);
		Tile tile8 = new Tile(2, 1, 1, 2, 1, false, 0);
		Tile tile9 = new Tile(3, 1, 2, 2, 1, false, 0);
		//System.out.println(fpm.getUnkownNeighbor(co));;
		
		//System.out.println(fpm.getAllCoordinates());
		System.out.println(fpm.getPath("0,0", "2,2"));
	
		fpm.updateTile("0,2", tile1);
		fpm.updateTile("1,2", tile2);
		fpm.updateTile("2,2", tile3);
		fpm.updateTile("0,1", tile4);
		fpm.updateTile("1,1", tile5);
		fpm.updateTile("2,1", tile6);
		fpm.updateTile("0,0", tile7);
		fpm.updateTile("1,0", tile8);
		fpm.updateTile("2,0", tile9);
		System.out.println(fpm.getPath("0,0", "2,2"));
		
	}
}
