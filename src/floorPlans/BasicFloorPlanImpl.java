package floorPlans;

import java.util.ArrayList;
import java.util.HashMap;

public class BasicFloorPlanImpl implements FloorPlan {
	private HashMap<String,Integer> grid;
	private int currentX;
	private int currentY;
	
	public BasicFloorPlanImpl(){
		this.currentX = 0;
		this.currentY = 0;
		this.grid = new HashMap<String,Integer>();
		
	}
	
	private String toString(int x,int y){
		return x+ ","+ y;
	}

	
		
		
	
	
	@Override
	public int getFloorType(int x, int y) {
		if(this.grid.containsKey(toString(x,y))){
			return this.grid.get(toString(x,y));
		}
		return 5;

	}

	@Override
	public int[] getCurrentLocation() {
		 int[] temp = new int[2];
		 temp[0] = this.currentX;
		 temp[1] = this.currentY;
		 return temp;
	}

	@Override
	public void updateCurrentLocation(int x, int y) {
		this.currentX = x;
		this.currentY = y;
	}

	
	@Override
	public ArrayList<String> getChargeStations() {
		return null;
		
	}

	@Override
	public int getFrontPath() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBackPath() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeftPath() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRightPath() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registerTile(int x, int y, Tile tile) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getDirtAmount(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	


}
