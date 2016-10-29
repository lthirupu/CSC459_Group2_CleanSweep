package FloorPlanTest;

import org.junit.Assert;
import org.junit.Test;

import FloorPlans.FloorPlan;
import FloorPlans.FloorPlanFactory;
import FloorPlans.TextFileReader;

public class FloorPlanObjectTest {
	@Test
	public void shouldCreateFloorPlanObject(){
		TextFileReader tfr = new TextFileReader();
		int[][] floorplan;
		floorplan= tfr.readFile("x");
		FloorPlanFactory flf = new FloorPlanFactory();
		
		FloorPlan flp = flf.createFloorPlan("grid", floorplan);
		Assert.assertTrue(floorplan[0].length== 16);
		Assert.assertTrue(floorplan[0][3]== 0);
		//Assert.assertTrue(flp.getFloorType(0, 3)==0);
	}
	

}
