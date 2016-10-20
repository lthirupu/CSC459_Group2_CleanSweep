package sensors;

/*
 * This module is created to read data from sensors.
 */

import java.util.Random;

  class Sensor {

	private static Sensor sensor = new Sensor( );
	private static int powerLevel = 100 ;
	static boolean fullFlag = false;
	
	private boolean frontSensor;
	private boolean rearSensor;
	private boolean leftSensor;
	private boolean rightSensor;
	private boolean bottomSensor;

	
	public boolean isFrontSensor() {
		return frontSensor;
	}


	public void setFrontSensor(boolean frontSensor) {
		this.frontSensor = frontSensor;
	}


	public boolean isRearSensor() {
		return rearSensor;
	}


	public void setRearSensor(boolean rearSensor) {
		this.rearSensor = rearSensor;
	}


	public boolean isLeftSensor() {
		return leftSensor;
	}


	public void setLeftSensor(boolean leftSensor) {
		this.leftSensor = leftSensor;
	}


	public boolean isRightSensor() {
		return rightSensor;
	}


	public void setRightSensor(boolean rightSensor) {
		this.rightSensor = rightSensor;
	}


	public boolean isBottomSensor() {
		return bottomSensor;
	}


	public void setBottomSensor(boolean bottomSensor) {
		this.bottomSensor = bottomSensor;
	}

	
	private Sensor() { }


	public static Sensor getInstance( ) {
		return sensor;
	}
	
	public boolean frontObstacle() {
		if (obstacleFound()) {
			setFrontSensor(true);
			return true;
		}
		else 
			return false;
	}
	
	public boolean rearObstacle() {
		if (obstacleFound()) {
			setRearSensor(true);
			return true;
		}
		else 
			return false;

	}
	
	public boolean leftObstacle() {
		if (obstacleFound()) {
			setLeftSensor(true);
			return true;
		}
		else 
			return false;

	}

	public boolean rightObstacle() {
		if (obstacleFound()) {
			setRightSensor(true);
			return true;
		}
			
		else 
			return false;

	}

	public boolean stairsObstacle() {
		if (obstacleFound()) {
			setBottomSensor(true);
			return true;
		}
		else 
			return false;

	}


	public boolean obstacleFound(){
		Random random = new Random();
		int randomNum = random.nextInt((100 - 1) + 1) + 1;

		if(randomNum <= 20){
			return true;
		}else{
			return false;
		}
	}

	public boolean isClean(){
		Random random = new Random();
		int randomNum = random.nextInt((100 - 1) + 1) + 1;

		if(randomNum <= 20){
			return true;
		}else{
			return false;
		}

	}

	public String floorType(){
		Random random = new Random();
		int randomNum = random.nextInt((90 - 1) + 1) + 1;

		if(randomNum <= 30){
			return "bare floor";
		}else if(randomNum > 30 && randomNum <= 60 ){
			return "low-pile carpet" ;
		}else{
			return "high-pile carpet";
		}
	}

	public boolean isFull(){


		if(fullFlag){
			return true;
		}else{
			return false;
		} 
	}

	public int power(){
		return(powerLevel--);

	}

	public void ManageDirtUnit(){

		new Thread(){
			int max = 50;
			int count = max;
			private Sensor s = Sensor.getInstance();

			public void run() {
				while(count > 0){
					if(!s.isClean()){
						count--;
					}
				}
				s.fullFlag = true;

			}}.start();
	}



}
