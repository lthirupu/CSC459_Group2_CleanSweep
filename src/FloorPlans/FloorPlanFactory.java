package FloorPlans;

public class FloorPlanFactory {
	//gridSize is length of a square side.
	public static FloorPlan createFloorPlan(){
		
		return new BasicFloorPlanImpl();
		
	}
	public static void main(String args[]){
		FloorPlan flp = FloorPlanFactory.createFloorPlan();
		System.out.println(flp.getFloorType(5, 6));
	}


}
