package FloorPlans;

public class FloorPlanFactory {
	//gridSize is length of a square side.
	public FloorPlan createFloorPlan(String type, int[][] floorPlanInfo){
		if(type == "grid"){
		return new GridCellFloorPlan(floorPlanInfo);
		}
		else return new BasicFloorPlanImpl();
	}
	

}
