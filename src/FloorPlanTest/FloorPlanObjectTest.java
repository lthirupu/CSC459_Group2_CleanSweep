package FloorPlanTest;

import org.junit.Assert;
import org.junit.Test;

import FloorPlans.FloorPlan;
import FloorPlans.FloorPlanFactory;

public class FloorPlanObjectTest {
	@Test
	public void shouldCreateFloorPlanObject(){
		int[] cl = new int[2];
		cl[0]=0;
		cl[1]=0;
		
		FloorPlan flp = FloorPlanFactory.createFloorPlan();
		int x= flp.getFloorType(4, 5);
		Assert.assertTrue(flp.getFloorType(5, 5)==5);
		
		
	}
	

}
