package floorPlanManager;

import java.util.Hashtable;

public class FloorPlanLoaderImpl implements FloorPlanLoader {
	Hashtable<String,Tile> info = new Hashtable<String,Tile>();
	@Override
	public Hashtable<String, Tile> loadFloorPlan() {
		Tile tile1 = new Tile(1, 0, 1, 1, 0, false, 0);
		Tile tile2 = new Tile(2, 0, 1, 1, 1, false, 0);
		Tile tile3 = new Tile(3, 0, 0, 1, 1, false, 0);
		Tile tile4 = new Tile(1, 1, 1, 1, 0, false, 0);
		Tile tile5 = new Tile(2, 1, 1, 1, 1, false, 0);
		Tile tile6 = new Tile(3, 1, 0, 1, 1, false, 0);
		Tile tile7 = new Tile(1, 1, 1, 0, 0, false, 0);
		Tile tile8 = new Tile(2, 1, 1, 0, 1, false, 0);
		Tile tile9 = new Tile(3, 1, 0, 0, 1, false, 0);
		
		this.info.put("0,2", tile1);
		this.info.put("1,2", tile2);
		this.info.put("2,2", tile3);
		this.info.put("0,1", tile4);
		this.info.put("1,1", tile5);
		this.info.put("2,1", tile6);
		this.info.put("0,0", tile7);
		this.info.put("1,0", tile8);
		this.info.put("2,0", tile9);
		return this.info;
	}


}
