public interface Int2DArray {
	
	public void clear();
	
	public int get();
	
	public int getPos(int pos_row, int pos_col);
	
	public void set(int item1);
	
	public void setCurr(int item1_row, int item2_col);
	
	public void swap(int item);
		
	public int delete();
	
	public void display();
	
	public void goPrev();
	
	public void goNext();
	
	public void mvToBeg();
	
	public void mvToEnd();
	
	public String currPos();
	
	public void mvToPos(int pos1, int pos2);
	
	public boolean find(int item);

}
