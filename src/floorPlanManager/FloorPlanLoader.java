package floorPlanManager;

import java.util.Hashtable;

public interface FloorPlanLoader {
	Hashtable<String,Tile> loadFloorPlan();
}
