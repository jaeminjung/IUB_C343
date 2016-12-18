
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class MyMiniGraph implements MiniGraph {
	private int totalNodes;
	private Vector<String> nodeList;
	private int totalEdges;
	private Vector<LinkedList<Integer>> adjList; // Adjacency list
	//private Vector<LinkedList<String>> adjListStr;
	
	public MyMiniGraph() {
		init();

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.nodeList = new Vector<String>();
		this.adjList = new Vector<LinkedList<Integer>>();
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setVertex(String [] nodes) {
		// TODO Auto-generated method stub
		for(int i = 0; i < nodes.length; i++){
			nodeList.add(nodes[i]);
			adjList.add(new LinkedList<Integer>());
			totalNodes++;
		}
	}

	@Override
	public void addVertex(String node) {
		// TODO Auto-generated method stub
		nodeList.add(node);
		adjList.add(new LinkedList<Integer>());
		totalNodes++;
	}

	@Override
	public void setEdge(int v1, int v2, int weight) {
		// TODO Auto-generated method stub
		LinkedList<Integer> temp = adjList.elementAt(v1);
		if(adjList.contains(v2)==false){
			temp.add(v2);
			adjList.set(v1, temp);
			totalEdges++;
		}
	}
/*
	public int findInd(String s){
		int a = 0;
		for(int i = 0; i<nodeList.size();i++){			
			
		}	
		return a;
	}
	
	@Override
	public void setEdge(String v1, String v2, int weight) {
		// TODO Auto-generated method stub
		LinkedList<Integer> temp = adjList.
		if(adjList.contains(v2)==false){
			temp.add(v2);
			adjList.set(v1, temp);
			totalEdges++;
		}
	}
*/
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("\tMiniGraph");
		System.out.println("total nodes : " + totalNodes);
		System.out.println("total edges : " + totalEdges);
	}

	@Override
	public void displayVE() {
		// TODO Auto-generated method stub
		for(int i = 0; i < nodeList.size(); i++){
			System.out.println(nodeList.get(i) +"   "+ adjList.get(i) );
		}
	}
	
	public static void main(String[] args){
		//
        // test your implementation:
        //
        MyMiniGraph g = new MyMiniGraph();
        String[] s = {"1","2", "3", "4", "5"};
        g.setVertex(s);
        g.setEdge(1,  2,  10);
        g.setEdge(2,  3,  7);
        g.display();
         
        // where a printout from the g.display() method should produce:
        //
        //  % java MyMiniGraph
        //  total nodes: 5
        //  total edges: 2
 
        g.displayVE();
	}
}
