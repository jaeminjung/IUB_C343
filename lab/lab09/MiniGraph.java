public interface MiniGraph {
	  public void init();
      public int length();
      public void setVertex(String[] nodes);
      public void addVertex(String node);
      public void setEdge(int v1, int v2, int weight);
    //  public void setEdge(String v1, String v2, int weight);
      public void display(); // display basic info
      public void displayVE(); // print out array
}
