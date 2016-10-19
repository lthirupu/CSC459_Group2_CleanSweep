package sensors;

/*
 *  This API will be used by other modules to get sensors’ data
 */

class SensorAPI {
	
	private static Sensor s = Sensor.getInstance();
	
	SensorAPI(){
		s.ManageDirtUnit();
	}
	
	/**
	 * Obstacle(): return true if there is an obstacle in front and false otherwise.
	 * 
	 *
	 */
	public boolean Obstacle(){
		return s.ObstacleFound();
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
