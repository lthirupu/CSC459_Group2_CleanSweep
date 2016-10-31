/*This floorplan uses a two dimentional array to represent the floorplan.
 * each cell consist an tile object.
 * a tile object contains information on floortype, north,south,east,west obstacles.
 * 
 */

package floorPlans;

import java.util.ArrayList;
import java.util.Arrays;


public class GridCellFloorPlan implements FloorPlan {

	private Tile [][] grid;
	private int currentX;
	private int currentY;
	
	
	private static GridCellFloorPlan instance = null;
	public static synchronized GridCellFloorPlan getInstance(Tile[][] floorPlanInfo){
		if(instance == null) instance = new GridCellFloorPlan();
		return instance;
	}
	private GridCellFloorPlan(){
	}
	

	
	

	@Override
	public int getFloorType(int x, int y) {
		return this.grid[x][y].getSurfaceType();
	}

	@Override
	public int[] getCurrentLocation() {
		int[] temp = new int[2];
		temp[0]= this.currentX;
		temp[1] = this.currentY;
		return temp;
		
	}

	@Override
	public void updateCurrentLocation(int x, int y) {
		this.currentX = x;
		this.currentY = y;
		
	}

	
	
	/*
	 * return an array list of charge station locations,
	 * the string format is "x,y".
	 */
	@Override
	public ArrayList<String> getChargeStations() {
	    ArrayList<String> chargeStations = new ArrayList<String>();
		for(int i = 0; i< this.grid.length;i++){
			for(int j = 0; j<this.grid[0].length;j++){
				if(this.grid[i][j].getChargeStation()== true) chargeStations.add(i+","+j); 
			}
		}
		
		return chargeStations;
	}
	@Override
	public int getFrontPath() {
		return this.grid[currentX][currentY].getFrontPath();
	}
	@Override
	public int getBackPath() {
		return this.grid[currentX][currentY].getBackPath();
	}
	@Override
	public int getLeftPath() {
		return this.grid[currentX][currentY].getLeftPath();
	}
	@Override
	public int getRightPath() {
		return this.grid[currentX][currentY].getRightPath();
	}
	@Override
	public void registerTile(int x, int y, Tile tile) {
		this.grid[x][y]= tile;
		
	}
	@Override
	public int getDirtAmount(int x, int y) {
		return this.grid[x][y].getDirtAmount();
	}
	

	

}
