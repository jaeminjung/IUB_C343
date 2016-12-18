
import java.io.File;
import java.util.Scanner;

public class EditDistanceDNA {
	
	int[][] d;
	String a;
	String b;
	char[] a1;
	char[] b1;
	
	public EditDistanceDNA(String a, String b){
		this.a = a;
		this.b = b;
		this.d = new int[a.length()+1][b.length()+1];
		this.a1 = a.toCharArray();
		this.b1 = b.toCharArray();
	}
	
	public void initial(){
		for(int i=0; i<= a.length(); i++) {
			d[i][0] = i;
		}
		for(int j=0; j<= b.length(); j++) {
			d[0][j] = j;
		}
		
	}
	public void fillTable(){
		int c;
		for(int i = 1; i<=a.length(); i++){
			for(int j = 1; j<=b.length(); j++){
				if(a1[i-1] == b1[j-1]){
					c=0;
				} else c = 1;
				d[i][j] = min(d[i-1][j] +1 , d[i][j-1]+1, d[i-1][j-1] + c);
			}
		}
	}
	
	private int min(int i, int j, int k) {
		// TODO Auto-generated method stub
		if(i<=j && i<=k){
			return i;
		}
		else if(j <= i && j <= k){
			return j;
		}
		else return k;
	}

	public int getEditD(){
		System.out.println(d[a.length()][b.length()]);		
		return d[a.length()][b.length()];
	}
	
	public void display(){
		//System.out.println("  " +b);
		for(int i = 0; i <= a.length();i++){
			//System.out.print(a1[i]);
			for(int j=0; j<=b.length();j++){
				
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		
		File file =new File("text.txt");
		Scanner in = new Scanner(System.in);
		
		String[] temp = new String[1];
		while(in.hasNext()){
			int i =0;
			String line = in.nextLine();
			temp[i] = line;
			i++;
		}
		
		
		/*
		System.out.println("Enter a String :");
		String a1 = in.nextLine();
		
		
		System.out.println("Enter a String :");
		String a2 = in.nextLine();
		
		//System.out.println(a1 + a2);
		*/
		
		EditDistanceDNA ex = new EditDistanceDNA(temp[0], temp[1]);
		ex.initial();
		ex.fillTable();
		ex.getEditD();
		ex.display();
	}

}
