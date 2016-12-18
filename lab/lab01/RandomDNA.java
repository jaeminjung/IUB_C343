import java.util.Random;

public class RandomDNA {

    public static void main(String[] args) {
    	//declare some variables
	String s = "";
	int lengthOfDNA = 20;
	Random rnd = new Random();

	for(int i = 1; i <= lengthOfDNA; i++) {
	    int t = rnd.nextInt(4);

	//according to result of random integer, add a character to string
	    if(t==0) {
		s = s + "A";
	    }


	    if(t==1) {
		s = s + "T";
	    }
	   
	    if(t==2) {
		s = s + "C";
	    }

	    if(t==3) {
		s = s + "G";
	    }
	}
	//print out randomly generated dna 
	System.out.println("Randomly generated DNA is : " + s);
    }
}
