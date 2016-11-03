package floorPlanManager;
/*FloorType:
 * 1 represent bare floor, 2 represent low-pile,
 * 3 represent high-pile
 * path:
 * 0 = unknown
 * 1 = open
 * 2 = obstacle
 * 4 = stairs 
 */

public class Tile {
	private int surfaceType;
	private int frontPath;
	private int backPath;
	private int leftPath;
	private int rightPath;
	private boolean isChargeStation;
	private int dirtAmount;
	
	public Tile(int surfaceType, int frontPath, int backPath,
			int leftPath,int rightPath,boolean isChargeStation,int dirtAmount){
		setSurfaceType(surfaceType);
		setFrontPath(frontPath);
		setBackPath(backPath);
		setLeftPath(leftPath);
		setRightPath(rightPath);
		setChargeStation(isChargeStation);
		setDirtAmount(dirtAmount);	
		
	}
	
	public void setSurfaceType(int type){
		this.surfaceType = type;
	}
	public int getSurfaceType(){
		return surfaceType;
	}
	
	public void setFrontPath(int fp){
		this.frontPath = fp;
	}
	public int getFrontPath(){
		return frontPath;
	}
	
	public void setBackPath(int bp){
		this.backPath = bp;
	}
	public int getBackPath(){
		return backPath;
	}
	
	public void setLeftPath(int lp){
		this.leftPath = lp;
	}
	public int getLeftPath(){
		return leftPath;
	}
	
	public void setRightPath(int rp){
		this.rightPath = rp;
	}
	public int getRightPath(){
		return rightPath;
	}
	
	public void setChargeStation(boolean cs){
		this.isChargeStation = cs;
	}
	public boolean getChargeStation(){
		return isChargeStation;
	}
	
	public void setDirtAmount(int dm){
		this.dirtAmount =  dm;
	}
	public int getDirtAmount(){
		return dirtAmount;
	}
	

}
