package FloorPlans;

import java.util.List;

public interface FloorPlan {
	 void registerFloorType(int x, int y, int type);
	 int getFloorType(int x, int y);
	 int[] getCurrentLocation(); //int[0] is x, int[1] is y
	 void updateCurrentLocation(int x, int y);
	 String[] getSurroundingUnknown();
	 String[] getNextAvailableStep();
}
