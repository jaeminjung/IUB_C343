
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class AdjGraph implements Graph {
    private boolean digraph; // directed or undirected graph?
    private int totalNodes;
    private Vector<String> nodeList;
    private int totalEdges;
    private Vector<LinkedList<Integer>>  adjList; // adjacency list
    private Vector<Boolean> visited;
    private Vector<Integer> nodeEnum; // list of nodes pre visit
    int[][] temp;
    
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
        visited = new Vector<Boolean>();
        nodeEnum = new Vector<Integer>();
        totalNodes = totalEdges = 0;
        digraph = false;
        temp = new int[6][6];
    }
    // add multiple vertices to the graph:
    public void setVertices(String[] nodes) {
        for (int i = 0; i < nodes.length; i ++) {
            nodeList.add(nodes[i]);
            adjList.add(new LinkedList<Integer>());
            visited.add(false);
            totalNodes ++;
        }
    }
    // add one vertex to the graph:
    public void addVertex(String label) {
        nodeList.add(label);
        visited.add(false);
        adjList.add(new LinkedList<Integer>());
        totalNodes ++;
    }
    // add one vertex to the graph:
    public int getNode(String node) {
        for (int i = 0; i < nodeList.size(); i ++) {
            if (nodeList.elementAt(i).equals(node)) return i;
        }
        return -1;
    }
    // return the number of vertices :
    public int length() {
        return nodeList.size();
    }
    // add edge from v1 to v2 :
    public void setEdge(int v1, int v2, int weight) {
        LinkedList<Integer> tmp = adjList.elementAt(v1);
        if (adjList.elementAt(v1).contains(v2) == false) {
            tmp.add(v2);
            adjList.set(v1,  tmp);
            totalEdges ++;
        }
    }
    // add edge from v1 to v2 :
    public void setEdge(String v1, String v2, int weight) {
        if ((getNode(v1) != -1) && (getNode(v2) != -1)) {
            // add edge from v1 to v2 :
            setEdge(getNode(v1), getNode(v2), weight);
            // for digraph, add edge from v2 to v1 as well :
            if (digraph == false) setEdge(getNode(v2), getNode(v1), weight);
        }
    }
    
    public void setEdge1(int v1, int v2, int weight) {
    	//temp = new int[totalNodes][totalNodes];
    	this.temp[v1][v2] = weight;
        LinkedList<Integer> tmp = adjList.elementAt(v1);
        if (adjList.elementAt(v1).contains(v2) == false) {
            tmp.add(v2);
            adjList.set(v1,  tmp);
            totalEdges ++;
        }
        
       // System.out.println(temp[v1][v2]);
    }
    public void setEdge1(String v1, String v2, int weight) {
        if ((getNode(v1) != -1) && (getNode(v2) != -1)) {
            // add edge from v1 to v2 :
            setEdge1(getNode(v1), getNode(v2), weight);
            // for digraph, add edge from v2 to v1 as well :
            if (digraph == false) setEdge1(getNode(v2), getNode(v1), weight);
        }
    }
    /*
    public int getWeight(int v1, int v2){
    	int a = 0;
    	if(adjList.elementAt(v1).contains(v2))
    	
    	return a;
    }
    */

    // for traversal purposes, it is important to keep track if a vertex has been visited or not:
    public void setVisited(int v) {
        visited.set(v, true);
        nodeEnum.add(v);
    }
    public boolean ifVisited(int v) {
        return visited.get(v);
    }
    public void clearWalk() {
        // clean up before traversing:
        nodeEnum.clear();
        for (int i = 0; i < nodeList.size(); i ++) visited.set(i, false);
    }
    public void walk(String method) {
        clearWalk();
        // traverse the graph:
        for (int i = 0; i < nodeList.size(); i ++) {
            if (ifVisited(i) == false) {
                if (method.equals("BFS")) BFS(i); // i as the start node
                else if (method.equals("DFS")) DFS(i); // i as the start node
                else {
                    System.out.println("unrecognized traversal order: " + method);
                    System.exit(0);
                }
            }
        }
        System.out.println(method + ":");
        displayEnum();
    }


    // modify walk() ...
    public void walk2(String method) {
        //
        //     TODO:
        //
        // ... your test code here ...
        //
    }


    public void DFS(int v) {
        setVisited(v);
        LinkedList<Integer> neighbors = adjList.elementAt(v);
        for (int i = 0; i < neighbors.size(); i ++) {
            int v1 = neighbors.get(i);
            if (ifVisited(v1) == false) DFS(v1); 
        }
    }
    public void BFS(int s) {
        ArrayList<Integer> toVisit = new ArrayList<Integer>();
        toVisit.add(s);
        while(toVisit.size() > 0) {
            int v = toVisit.remove(0); // first-in, first-visit
            setVisited(v);
            LinkedList<Integer> neighbors = adjList.elementAt(v);
            for (int i = 0; i < neighbors.size(); i ++) {
                int v1 = neighbors.get(i);
                if ((ifVisited(v1) == false) && (toVisit.contains(v1) == false)) {
                    toVisit.add(v1);
                }
            }
        }
    }
    public void display() {
        System.out.println("total nodes: " + totalNodes);
        System.out.println("total edges: " + totalEdges);
    }
    public void displayEnum() {
        for (int i = 0; i < nodeEnum.size(); i ++) {
            System.out.print(nodeList.elementAt(nodeEnum.elementAt(i)) + " ");
        }
        System.out.println();
    }
    
    public int getWeight(int a, int b){
    	return temp[a][b];
    }
    
    public void myFloyd(){
    	//initial
    	int[][] d = new int[totalNodes][totalNodes];
    	for(int i = 0; i < totalNodes; i++){
    		d[i][i] = 0;
    		for (int j = i+1; j < totalNodes; j++){
    			d[i][j] = d[j][i]= 1000;
    		}
			//System.out.println(neighbors.toString());
    	}
    	
    	for(int i = 0; i < totalNodes; i++){
    		LinkedList<Integer> neighbors = adjList.elementAt(i);
            for (int j = 0; j < neighbors.size(); j ++) {
                int v1 = neighbors.get(j);
                d[i][v1] = 1;
            }
    	}
    	/*System.out.println("After initialize, the d array is : ");
    	for(int i = 0; i < totalNodes; i++){
    		for(int j = 0; j < totalNodes; j++){
    			System.out.print(d[i][j] + "   ");
    		}
    		System.out.println();
    	}*/
    	
    	
    	//update d(i,j)
    	for(int k = 0; k < totalNodes; k++){
    		for(int x = 0; x <totalNodes; x++){
    			for(int j = 0; j < totalNodes; j++){
    				if(d[x][j]> d[x][k] + d[k][j]){
    					d[x][j]= d[x][k] + d[k][j];
    				}
    			}
    		}
    	}
    	
    	System.out.println("after using Floyd's Algorithm :" );
    	for(int i = 0; i < totalNodes; i++){
    		//System.out.print(nodeList.get(i));
    		for(int j = 0; j < totalNodes; j++){
    			System.out.print(" "+d[i][j] + "   ");
    		}
    		System.out.println();
    	}
    	
    }
    
    public static void main(String argv[]) {
        
    	AdjGraph g = new AdjGraph();
		String[] s = { "1", "2", "3", "4", "5", "6" };
		g.setVertices(s);
		
		g.setEdge("1", "2", 10);
		g.setEdge("2", "4",5 );
		g.setEdge("1", "4", 20);
		g.setEdge("2", "3", 3);
		g.setEdge("1", "6", 2);
		g.setEdge("4", "6", 10);
		g.setEdge("3", "5", 15);
		g.setEdge("4", "5", 11);
		g.setEdge("6", "5", 5);
		
		g.display();
		//System.out.println(g.nodeList.);
		//g.myFloyd();

		/*g.setEdge1("1", "2", 10);
		g.setEdge1("2", "4", 5);
		g.setEdge1("1", "4", 20);
		g.setEdge1("2", "3", 3);
		g.setEdge1("1", "6", 2);
		g.setEdge1("4", "6", 10);
		g.setEdge1("3", "5", 15);
		g.setEdge1("4", "5", 11);
		g.setEdge1("6", "5", 3);*/
		
		g.myFloyd();
    }
}
