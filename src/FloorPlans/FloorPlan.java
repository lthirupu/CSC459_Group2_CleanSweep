package FloorPlans;

import java.util.List;

public interface FloorPlan {
	 void registerFloorType(int x, int y, int type);
	 int getFloorType(int x, int y);
	 int[] getCurrentLocation();
	 void updateCurrentLocation(int x, int y);
}
