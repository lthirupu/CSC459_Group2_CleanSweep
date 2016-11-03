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
	
		/*
	 * getNearestChargeStation(double MaxDis): 
	 * Return the nearest charge station locations,the string format is "x,y".
	 * 
	 * MaxDis: The maximum range ; "look for station in this range"
	 */
	
	public String getNearestChargeStation(double MaxDis){
		
	   	ArrayList<String> cs = getChargeStations();
        List<Point2D> points = new ArrayList<Point2D>();
        
        for(String s : cs){
        	points.add(new Point2D.Double( Integer.parseInt(s.substring(0, s.indexOf(','))), Integer.parseInt(s.substring(s.indexOf(',')+1, s.length()))) );
    		 
    	  }

        Point2D myPoint = new Point2D.Double(getCurrentLocation()[0],getCurrentLocation()[1]);
        
        Collections.sort(points, createComparator(myPoint));

        double maxDistance = MaxDis;
        
        int index = 0;
        for (Point2D p : points)
        {
            if (p.distanceSq(myPoint) > maxDistance * maxDistance)
            {
                break;
            }
            index++;
        }
        List<Point2D> result = points.subList(0, index);
        System.out.println(
            "The closest points with distance <="+maxDistance+" are "+result);
        System.out.println(result.toString());
        
		return String.valueOf(result.get(0).getX()) +","+String.valueOf(result.get(0).getY()) ;
    }
	// Do Not Worry About It
    private static Comparator<Point2D> createComparator(Point2D p)
    {
        final Point2D finalP = new Point2D.Double(p.getX(), p.getY());
        return new Comparator<Point2D>()
        {
            @Override
            public int compare(Point2D p0, Point2D p1)
            {
                double ds0 = p0.distanceSq(finalP);
                double ds1 = p1.distanceSq(finalP);
                return Double.compare(ds0, ds1);
            }

        };
	}


	

}
