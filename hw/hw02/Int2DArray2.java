

import java.util.Random;

public class Int2DArray2 implements Int2DArray {

	int curr_row, curr_col;
	int listsize_row, listsize_col;
	int[][] int2D_Array;
	Random rnd = new Random();
	

	Int2DArray2(int row, int col) {
		listsize_row = row;
		listsize_col = col;
		curr_row = 0;
		curr_col = 0;
		int2D_Array = new int[listsize_row][listsize_col];
	}

	public void initialize() {
		for(int i = 0; i<listsize_row; i++){
			for(int j = 0; j<listsize_col; j++){
				int t = rnd.nextInt(10);
				int2D_Array[i][j] = t;			
			}
		}

	}

	public void clear() {
		curr_row = curr_col = 0;
	}

	public int get() {

		return int2D_Array[curr_row][curr_col];
	}

	public int getPos(int pos_row, int pos_col) {

		return int2D_Array[pos_row][pos_col];
	}

	public void set(int item) {

		int2D_Array[curr_row][curr_col] = item;
	}

	public void setCurr(int i1, int i2) {
		curr_row = i1;
		curr_col = i2;
	}


	public void swap(int item) {

		int2D_Array[curr_row][curr_col] = item;

	}

	public int delete() {
		int2D_Array[curr_row][curr_col] = 0;
		return 0;
	}

	
	public void display() {
	
		System.out.println("list is " + listsize_row +" x " + listsize_col);
		
		for(int i = 0; i < listsize_row; i++){
			for(int j = 0; j < listsize_col; j++){
				System.out.print(int2D_Array[i][j] + " ");	
			}
			System.out.println();
		}
	}

	@Override
	public void goPrev() {
	
		if(curr_col == 0){
			curr_col = listsize_col;
			curr_row = curr_row+1;
		}
		else if( curr_row == 0 && curr_col == 0){
			System.out.println("you are at the begining");
		}
		else {
			curr_col = curr_col -1;
		}

	}

	@Override
	public void goNext() {
	
		if(curr_col == listsize_col){
			curr_col = 0;
			curr_row = curr_row+1;
		}
		else if(curr_row == listsize_row && curr_col==listsize_col) {
			System.out.println("you are at the end");
		}
		else {
			curr_col = curr_col +1;
		}
	}

	@Override
	public void mvToBeg() {
	
		curr_row = 0;
		curr_col = 0;

	}

	@Override
	public void mvToEnd() {
	
		curr_row = listsize_row -1;
		curr_col = listsize_col -1;
	}

	@Override
	public String currPos() {
	
		String s = "";
		s = s +"(" + curr_row + " , " + curr_col + ")";
		return s;
	}

	@Override
	public void mvToPos(int pos1, int pos2) {
	
		curr_row = pos1;
		curr_col = pos2;

	}

	@Override
	public boolean find(int item) {
	
		for(int i =0; i < listsize_row; i++){
			for(int j = 0; j < listsize_col; j++){
				if(int2D_Array[i][j]==item){
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
    //test!
   		Int2DArray2 example = new Int2DArray2(5, 10);
   		//put random integer in array
    		example.initialize();
    		example.display();
    		example.mvToPos(4,4);
    		System.out.println(example.currPos());
    		example.goPrev();
    		System.out.println(example.currPos());
    		System.out.println(example.find(4));
    		System.out.println(example.get());
   	
		Int2DArray2 example2 = new Int2DArray2(4,4);
    		example2.display();
    		example2.set(4);
    		System.out.println(example2.get());
    		example2.display();
    												}
    	}
