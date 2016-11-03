package floorPlanManager;
import java.util.*;

public class FloorMap {
	private List<Vertex> nodes = new ArrayList<Vertex>();
	private List<Edge> edges = new ArrayList<Edge>();
	private Graph aGraph;
	public FloorMap(){
	
	}
	public void createFloorMap(){
		Floor fl = Floor.getInstance();
		
		Set<String> tiles = new HashSet<String>();
		tiles = fl.getAllCoordinates();
	//	System.out.println(facilities);
		for(String tile: tiles){
			Vertex node = new Vertex(tile,tile);
			this.nodes.add(node);
		    Coordinate co = new Coordinate();
		    co.setString(tile);
			Set<String> neighbors = fl.getOpenNeighbor(co);
		//	System.out.println(neighbors);
			for(String neighbor: neighbors){
				Coordinate nei = new Coordinate();
				nei.setString(neighbor);
				Vertex neighbornode = new Vertex(neighbor,neighbor);
				Edge edge = new Edge(tile +"to" + neighbor, node, neighbornode, (fl.getSurfaceType(co)+fl.getSurfaceType(nei))/2);
				//System.out.println(edge);
				this.edges.add(edge);
			}
		}
		this.aGraph = new Graph(this.nodes,this.edges);
	}
	public LinkedList<Vertex> getPath(String start, String destination){
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(this.aGraph);
		LinkedList<Vertex> path = new LinkedList();
		for(int i = 0; i< nodes.size();i++){
			
			if(start.equals(nodes.get(i).getName())){
				
				dijkstra.execute(this.nodes.get(i));
				}
			
		}
		for(int j = 0; j< nodes.size();j++){
			
			if(destination.equals(nodes.get(j).getName())){
				
			   path = dijkstra.getPath(nodes.get(j));
				}
			
		}
	
		 return path;
	}
	
}