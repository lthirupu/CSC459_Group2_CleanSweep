package floorPlanManager;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class Floor {
	private Hashtable<String,Tile> floorPlan;
	private Coordinate currentLocation;
	private HashSet<String> chargeStations;
	private static Floor fl = null;
	public static synchronized Floor getInstance(){
		if(fl==null){
			fl = new Floor();
		}
		return fl;
	}
	private Floor(){
		floorPlan = new Hashtable<String,Tile>();
		currentLocation = new Coordinate();
		chargeStations = new HashSet<String>();
		
	}
	public HashSet<String> getAllCoordinates(){
		return (HashSet<String>) this.floorPlan.keySet();
	}
	public void setChargeStationLocation(Coordinate co){
		this.chargeStations.add(co.getStringXY());
		
	}
	public HashSet<String> getChargeStaionLocation(){
		return this.chargeStations;
	}
	public void loadFloorPlan(Hashtable<String,Tile> flp){
		this.floorPlan = flp;
	}
	
	public void setCurrentLocation(int x, int y){
		this.currentLocation.setX(x);
		this.currentLocation.setY(y);
	}
	public Coordinate getCurrentLocation(){
		return this.currentLocation;
	}
	
	public int getSurfaceType(Coordinate co){
		return this.floorPlan.get(co.getStringXY()).getSurfaceType();
		
	}
	
	public HashSet<String> getOpenNeighbor(Coordinate co){
		HashSet<String> temp = new HashSet<String>();
		if(this.floorPlan.get(co.getStringXY()).getFrontPath()==1){
			String up = co.getX()+"," + (co.getY()+1);
			temp.add(up);
		}
		else if(this.floorPlan.get(co.getStringXY()).getRightPath()==1){
			String right = (co.getX()+1) +"," + co.getY();
			temp.add(right);
		}
		else if(this.floorPlan.get(co.getStringXY()).getFrontPath()==1){
			String down = co.getX()+"," +(co.getY()-1);
			temp.add(down);
		}
		else if(this.floorPlan.get(co.getStringXY()).getFrontPath()==1){
			String left = (co.getX()-1)+"," + co.getY();
			temp.add(left);
		}
		return temp;
		
	}
	public HashSet<String> getUnkownNeighbor(Coordinate co){
		HashSet<String> temp = new HashSet<String>();
		if(this.floorPlan.get(co.getStringXY()).getFrontPath()==0){
			String up = co.getX()+"," + (co.getY()+1);
			temp.add(up);
		}
		else if(this.floorPlan.get(co.getStringXY()).getRightPath()==0){
			String right = (co.getX()+1) +"," + co.getY();
			temp.add(right);
		}
		else if(this.floorPlan.get(co.getStringXY()).getFrontPath()==0){
			String down = co.getX()+"," +(co.getY()-1);
			temp.add(down);
		}
		else if(this.floorPlan.get(co.getStringXY()).getFrontPath()==0){
			String left = (co.getX()-1)+"," + co.getY();
			temp.add(left);
		}
		return temp;
		
	}
	public HashSet<String> getObstacleNeighbor(Coordinate co){
		HashSet<String> temp = new HashSet<String>();
		if(this.floorPlan.get(co.getStringXY()).getFrontPath()==2){
			String up = co.getX()+"," + (co.getY()+1);
			temp.add(up);
		}
		else if(this.floorPlan.get(co.getStringXY()).getRightPath()==2){
			String right = (co.getX()+1) +"," + co.getY();
			temp.add(right);
		}
		else if(this.floorPlan.get(co.getStringXY()).getFrontPath()==2){
			String down = co.getX()+"," +(co.getY()-1);
			temp.add(down);
		}
		else if(this.floorPlan.get(co.getStringXY()).getFrontPath()==2){
			String left = (co.getX()-1)+"," + co.getY();
			temp.add(left);
		}
		return temp;
		
	}
	public static void main(String args[]){
		Hashtable<String,Integer> test = new Hashtable<String,Integer>();
		String a = "hi";
		String b = "hi";
		test.put(a, 2);
		System.out.println(test.get(b));
		String c = "3,4";
		String[] d = c.split(",");
		System.out.println(d[0]+d[1]);
	}

}