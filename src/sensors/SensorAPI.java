package sensors;

/*
 *  This API will be used by other modules to get sensors� data
 */

public class SensorAPI {
	
	private static Sensor s = Sensor.getInstance();
	
	public SensorAPI(){
		s.ManageDirtUnit();
	}
	
	/**
	 * Return true if there is an obstacle in front and false otherwise.
	 * 
	 *
	 */
	public boolean frontObstacle(String co){
		return s.frontObstacle(co);
	}
	/**
	 * Return true if there is an obstacle in rear and false otherwise.
	 * 
	 *
	 */
	public boolean rearObstacle(String co){
		return s.rearObstacle(co);
	}
	/**
	 * Return true if there is an obstacle in right and false otherwise.
	 * 
	 *
	 */
	
	public boolean rightObstacle(String co){
		return s.rightObstacle(co);
	}
	/**
	 * Return true if there is an obstacle in left and false otherwise.
	 * 
	 *
	 */
	public boolean leftObstacle(String co){
		return s.leftObstacle(co);
	}
	/**
	 * Return true if there is an obstacle in stairs and false otherwise.
	 * 
	 *
	 */
	public boolean stairsObstacle(){
		return s.stairsObstacle();
	}
	/**
	 * Return true if the front sensor is on, and false otherwise.
	 * 
	 *
	 */
	public boolean isFrontSensor() {
		return s.isFrontSensor();
	}
	/**
	 * Return true if the back sensor is on, and false otherwise.
	 * 
	 *
	 */
	public boolean isRearSensor() {
		return s.isRearSensor();
	}
	/**
	 * Return true if the left sensor is on, and false otherwise.
	 * 
	 *
	 */
	public boolean isLeftSensor() {
		return s.isLeftSensor();
	}
	/**
	 * Return true if the bottom sensor is on, and false otherwise.
	 * 
	 *
	 */
	public boolean isBottomSensor() {
		return s.isBottomSensor();
	}
	/**
	 * Return true if the right sensor is on, and false otherwise.
	 * 
	 *
	 */
	public boolean isRightSensor() {
		return s.isRightSensor();
	}

	
	/**
	 * isClean(): return true if the floor ( in current position) is clean and false otherwise.
	 * 
	 *
	 */
	public boolean isClean(){
		 return s.isClean();
	   }
	
	/**
	 * getFloorType(): return floor type as a String object.
	 * 
	 *
	 */
	public String getFloorType(){
		return s.floorType();
	}
	 
	/**
	 * isFull(): return true if the cleaner carry 50 units of dirts and false otherwise.
	 * 
	 *
	 */
	public boolean isFull(){
		return s.isFull();
	}
	
	/**
	 * getPowerLevel()(): return the current battery level as an int.
	 * 
	 *
	 */
	  public int getPowerLevel(){
		  return s.power();
	  }

}
