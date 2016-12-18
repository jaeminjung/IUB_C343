import java.util.Random;

public class DNADist {
	
	public static String RandomDNA(){
		String s = "";
		int lengthOfDNA = 20;
		Random rnd = new Random();
		
		
		for(int i = 1; i <= lengthOfDNA; i++){
			int t = rnd.nextInt(4);
			
			if(t == 0){
				s = s + "A";
			}
			if(t == 1){
				s = s + "T";
			}
			if(t == 2){
				s = s + "C";
			}
			if(t == 3){
				s = s + "G";
			}
			
		}
		return s;
	}
	
	public static int CountDist(String a, String b){
		int count = 0;
		for(int i = 0; i < a.length(); i++){
			if(!(a.substring(i,i+1).equals(b.substring(i,i+1)))){
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args){
		String s;
		s = RandomDNA();
		String t;
		t = RandomDNA();
		
		System.out.println("First Randomly generated DNA is  : " + s);
		System.out.println("Second Randomly generated DNA is : " + t);
		System.out.println(CountDist(s,t));		
	}
}
