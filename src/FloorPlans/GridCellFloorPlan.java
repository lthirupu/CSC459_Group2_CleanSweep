/*This floorplan uses a two dimentional array to represent the floorplan.
 * Index 0 represent obstacles, 1 represent bare floor, 2 represent low-pile,
 *  3 represent high-pile, index 4 represent stair. 5 represent unknown, 
 *  6 represent charge station.
 */

package FloorPlans;

import java.util.Arrays;

public class GridCellFloorPlan implements FloorPlan {
	
	private int [][] grid;
	private int currentX;
	private int currentY;
	
	
	public GridCellFloorPlan(int[][] floorPlanInfo){
		int length = floorPlanInfo.length;
		int width = floorPlanInfo[0].length;
		this.grid = new int[length][width];
		for(int i = 0; i< length; i ++){
			for(int j = 0 ; j < width; j++){
				this.grid[i][j] = floorPlanInfo[i][j]; 
			}
		}
	}

	@Override
	public void registerFloorType(int x, int y, int type) {
		if(this.grid[x][y]== 5){
		this.grid[x][y] = type;
		}
		else{
			this.grid[x][y] = type;
		}
		
	}

	@Override
	public int getFloorType(int x, int y) {
		return this.grid[x][y];
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

	@Override
	public String[] getNextAvailableStep() {
		int  x= 0;
		String[] temp = new String[4];
		if(isOpen(this.currentX,this.currentY+1)){
			temp[x] = "up";
					x++;
		}else if(isOpen(this.currentX+1,this.currentY)){
			temp[x] = "right";
			x++;
		}
		else if(isOpen(this.currentX,this.currentY-1)){
			temp[x] = "down";
			x++;
		}
		else if(isOpen(this.currentX-1,this.currentY)){
			temp[x] = "left";
			
		}
		return temp;
				
		
	}
	@Override
	public String[] getSurroundingUnknown() {
		int  x= 0;
		String[] temp = new String[4];
		if(isUnknown(this.currentX,this.currentY+1)){
			temp[x] = "up";
					x++;
		}else if(isUnknown(this.currentX+1,this.currentY)){
			temp[x] = "right";
			x++;
		}
		else if(isUnknown(this.currentX,this.currentY-1)){
			temp[x] = "down";
			x++;
		}
		else if(isUnknown(this.currentX-1,this.currentY)){
			temp[x] = "left";
			
		}
		return temp;
				
	}
	
	
	private boolean isUnknown(int x, int y){
		
		if(this.grid[x][y] == 5){
			return true;
			
		}
		return false;
		
	}
	
	private boolean isOpen(int x, int y){
		if(this.grid[x][y]==0 || this.grid[x][y] == 4){
			return false;
		}
		else{
			return true;
		}
	}

	

}
