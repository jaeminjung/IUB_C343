




import java.util.Arrays;
import java.util.Random;

public class CountingSort {

	int[] aArray;
	int[] bArray;
	int[] cArray;
	Random rnd = new Random();
	
	public CountingSort(int a){
		this.aArray = new int[a];
	}
	public void initial(){
		for(int i =0; i < aArray.length; i++){
			int t = rnd.nextInt(30);
			aArray[i] = t;
		}
	}
	
	public void initialB(int a){
		this.bArray = new int[a+1];
		int atmp;
		for(int i=0; i<aArray.length; i++){
			atmp = aArray[i];
			bArray[atmp] += 1;
		}
		System.out.println(Arrays.toString(bArray));
	}
	
	public void secondStage(){
		int totalSoFar = 0;
		for(int i=1; i < bArray.length; i++){
			int tmpCount = bArray[i];
			bArray[i] = totalSoFar;
			totalSoFar += tmpCount;
		}
		System.out.println(Arrays.toString(bArray));
	}
	
	public void thirdStage(){
		this.cArray = new int[aArray.length];
		int atmp;
		int outindex;
		for(int i = 0; i < aArray.length; i++){
			atmp = aArray[i];
			outindex = bArray[atmp];
			cArray[outindex] = aArray[i];
			bArray[atmp] += 1;
		}
		System.out.println(Arrays.toString(cArray));
	}
	
	public void display(){
		for(int i = 0; i<aArray.length; i++){
			if(i == aArray.length-1){
				System.out.print(aArray[i]);
			}
			else{
			System.out.print(aArray[i] + ", ");
			}
		}
	}
	
	public void display1(){
		for(int i =0; i<bArray.length; i++){
			if(i == bArray.length-1){
				System.out.print(bArray[i]);
			}
			else{
			System.out.print(bArray[i] + ", ");
			}
		}
	}
	
	public void display2(){
		for(int i =0; i<cArray.length; i++){
			if(i == cArray.length-1){
				System.out.print(cArray[i]);
			}
			else{
			System.out.print(cArray[i] + ", ");
			}
		}
	}
	
	public int findMax(){	
		int a = aArray[0];
		for(int i=1; i<aArray.length; i++){
			if(a < aArray[i]){
				a = aArray[i];
			}
		}
		return a;
	}
	
	public static void main(String[] args){
		CountingSort ex = new CountingSort(10);
		ex.initial();
		ex.display();
		System.out.println();
		System.out.println("max value in A array is : " + ex.findMax());
		ex.initialB(ex.findMax());
		System.out.println("b array is ..");
		//ex.display1();
		System.out.println();
		ex.secondStage();
		System.out.println("after second stage b array is ...");
		//ex.display1();
		
		System.out.println();
		System.out.println("after third stage c array is ...");
		ex.thirdStage();
		//ex.display2();
		
		
				
		}
}
