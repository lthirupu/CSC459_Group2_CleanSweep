package floorPlans;

import java.util.ArrayList;
import java.util.List;

public interface FloorPlan {
	 void registerTile(int x, int y, Tile tile);
	 int getFloorType(int x, int y);
	 int[] getCurrentLocation(); //int[0] is x, int[1] is y
	 void updateCurrentLocation(int x, int y);
	 ArrayList<String> getChargeStations();
	 int getFrontPath();
	 int getBackPath();
	 int getLeftPath();
	 int getRightPath();
	 int getDirtAmount(int x, int y);
	 
	 
}
