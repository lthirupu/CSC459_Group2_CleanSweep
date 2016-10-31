package floorPlans;

public class FloorPlanFactory {
	//gridSize is length of a square side.
	public static FloorPlan createFloorPlan(String type, Tile[][] floorPlanInfo){
		if(type == "grid"){
		return GridCellFloorPlan.getInstance(floorPlanInfo);
		}
		else return new BasicFloorPlanImpl();
	}
	

}
