

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class AdjGraph implements Graph {
	private boolean digraph;
	private int totalNode;
	private Vector<String> nodeList;
	private int totalEdge;
	private Vector<LinkedList<Integer>> adjList; // Adjacency list
	private Vector<LinkedList<Integer>> adjWeight; // Weight of the edges
	private Vector<Boolean> visited;
	private Vector<Integer> nodeEnum; // list of nodes pre visit

	public AdjGraph() {
		init();
	}

	public AdjGraph(boolean ifdigraph) {
		init();
		digraph = ifdigraph;
	}

	public void init() {
		nodeList = new Vector<String>();
		adjList = new Vector<LinkedList<Integer>>();
		adjWeight = new Vector<LinkedList<Integer>>();
		visited = new Vector<Boolean>();
		nodeEnum = new Vector<Integer>();
		totalNode = totalEdge = 0;
		digraph = false;
	}

	// set vertices
	public void setVertex(String[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			nodeList.add(nodes[i]);
			adjList.add(new LinkedList<Integer>());
			adjWeight.add(new LinkedList<Integer>());
			visited.add(false);
			totalNode++;
		}
	}

	// add a vertex
	public void addVertex(String label) {
		nodeList.add(label);
		visited.add(false);
		adjList.add(new LinkedList<Integer>());
		adjWeight.add(new LinkedList<Integer>());
		totalNode++;
	}

	public int getNode(String node) {
		for (int i = 0; i < nodeList.size(); i++) {
			if (nodeList.elementAt(i).equals(node))
				return i;
		}
		return -1;
	}

	// return the number of vertices
	public int length() {
		return nodeList.size();
	}

	// add edge from v1 to v2
	public void setEdge(int v1, int v2, int weight) {
		LinkedList<Integer> tmp = adjList.elementAt(v1);
		if (adjList.elementAt(v1).contains(v2) == false) {
			tmp.add(v2);
			adjList.set(v1, tmp);
			totalEdge++;
			LinkedList<Integer> tmp2 = adjWeight.elementAt(v1);
			tmp2.add(weight);
			adjWeight.set(v1, tmp2);
		}
	}

	public void setEdge(String v1, String v2, int weight) {
		if ((getNode(v1) != -1) && (getNode(v2) != -1)) {
			// add edge from v1 to v2
			setEdge(getNode(v1), getNode(v2), weight);
			// for digraph, add edge from v2 to v1 as well
			if (digraph == false)
				setEdge(getNode(v2), getNode(v1), weight);
		}
	}

	// it is important to keep track if a vertex is visited or not (for
	// traversal)
	public void setVisited(int v) {
		visited.set(v, true);
		nodeEnum.add(v);
	}

	public boolean ifVisited(int v) {
		return visited.get(v);
	}

	public LinkedList<Integer> getNeighbors(int v) {
		return adjList.get(v);
	}

	public int getWeight(int v, int u) {
		LinkedList<Integer> tmp = getNeighbors(v);
		LinkedList<Integer> weight = adjWeight.get(v);
		if (tmp.contains(u))
			return weight.get(tmp.indexOf(u));
		else
			return Integer.MAX_VALUE;
	}

	public void clearWalk() {
		// clean up before traverse
		nodeEnum.clear();
		for (int i = 0; i < nodeList.size(); i++)
			visited.set(i, false);
	}

	public void walk(String method) {
		clearWalk();
		// traverse the graph
		for (int i = 0; i < nodeList.size(); i++) {
			if (ifVisited(i) == false) {
				if (method.equals("BFS"))
					BFS(i); // i as the start node
				else if (method.equals("DFS"))
					DFS(i); // i as the start node
				else {
					System.out.println("unrecognized traversal order: " + method);
					System.exit(0);
				}
			}
		}
		System.out.println(method + ":");
		displayEnum();
	}

	public void DFS(int v) {
		setVisited(v);
		LinkedList<Integer> neighbors = adjList.elementAt(v);
		for (int i = 0; i < neighbors.size(); i++) {
			int v1 = neighbors.get(i);
			if (ifVisited(v1) == false)
				DFS(v1);
		}
	}

	public void BFS(int s) {
		ArrayList<Integer> toVisit = new ArrayList<Integer>();
		toVisit.add(s);
		while (toVisit.size() > 0) {
			int v = toVisit.remove(0); // first-in, first-visit
			setVisited(v);
			LinkedList<Integer> neighbors = adjList.elementAt(v);
			for (int i = 0; i < neighbors.size(); i++) {
				int v1 = neighbors.get(i);
				if ((ifVisited(v1) == false) && (toVisit.contains(v1) == false)) {
					toVisit.add(v1);
				}
			}
		}
	}

	public void display() {
		System.out.println("total nodes: " + totalNode);
		System.out.println("total edges: " + totalEdge);
	}

	public void displayEnum() {
		for (int i = 0; i < nodeEnum.size(); i++) {
			System.out.print(nodeList.elementAt(nodeEnum.elementAt(i)) + " ");
		}
		System.out.println();
	}

	public int mstPrim() {
		//initialize, set S to include all the nodes
		ArrayList<Integer> S = new ArrayList<Integer>();
		for(int i = 0; i < nodeList.size(); i++){
			S.add(i, i);
		}
		
		//set dist[v] to infinity for all other nodes
		int [] dist = new int[S.size()];
		for(int i = 0; i < dist.length; i ++){
			if(i == 0){
				dist[i] = 0;
			}
			else { dist[i] = 999; }
		}
		
		//set cost (of the MST) to 0 (initial MST is empty)
		int cost = 0;
		
		while ( !S.isEmpty() ){
			//find smallest dist[i]
			int smallest = S.get(0);
			for(int i = 0; i < S.size(); i++){
				if(dist[S.get(i)]<dist[smallest])
				{
					smallest = S.get(i);
				}
			}
			//remove u from S, and update the cost (cost <- cost + dist[u])
			S.remove(S.indexOf(smallest));
			cost = cost + dist[smallest];
			
			//update dist[v] for every neighbor of u:
			LinkedList<Integer> neighbors = getNeighbors(smallest);
			for(int i = 0; i < neighbors.size(); i ++) {
				int v1 = neighbors.get(i);
				if( getWeight(v1, smallest) < dist[v1]){
					dist[v1] = getWeight(v1, smallest);
				}
			}
		}	
		return cost;
	}

	public static void main(String argv[]) {
		// make some graphs to test your implementation of mstPrim()
		// a graph that is undirected, and connected, find the cost(mst)
		AdjGraph g = new AdjGraph();
		String[] s = { "A", "B", "C", "D", "E", "F" };
		g.setVertex(s);
		g.setEdge("A", "B", 1);
		g.setEdge("B", "C", 6);
		g.setEdge("A", "D", 3);
		g.setEdge("B", "D", 5);
		g.setEdge("B", "E", 1);
		g.setEdge("D", "E", 1);
		g.setEdge("E", "F", 4);
		g.setEdge("E", "C", 5);
		g.setEdge("C", "F", 2);
		g.display();
		//System.out.println(g.nodeList.toString());
		System.out.println(g.mstPrim());

	}
}
