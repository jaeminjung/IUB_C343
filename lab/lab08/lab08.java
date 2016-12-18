
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class lab08 {
	
	

	
	public void initial(String query) throws IOException{
		
		Hashtable<String, ArrayList<Integer>> ht = new Hashtable<String, ArrayList<Integer>>();

		int line = 1;

		URL url = new URL("http://homes.soic.indiana.edu/classes/summer2016/csci/c343-mitja/2016/labs/lab08.txt");
		Scanner in = new Scanner(url.openStream());

		while (in.hasNext()) {
			// nextLine() reads a line;
			// Scanner class has other methods to allow the user to read values
			// of various types, eg.., nextInt()
			String str = in.nextLine();
			String[] words = str.split("\\W+");

			
			for(int i = 0; i < words.length; i++){
				if(ht.containsKey(words[i])) {
					ArrayList<Integer> ls2 = ht.get(words[i]);
					//System.out.println(words[i]);
					ls2.add(line);
				}
				else{
					ArrayList<Integer> ls = new ArrayList<Integer>();
					ls.add(line);
					ht.put(words[i], ls);					
				}
			}
			
			line++;

		}
		if(ht.containsKey(query)){
			System.out.println(ht.get(query));
			
		}
		else{
			System.out.println("it is not found");
		}
		in.close();

	}
	
	public static void main(String[] args) throws IOException{
		lab08 ex = new lab08();
		String query = "data";
		String query2 = "algorithm";
		ex.initial(query);
		ex.initial(query2);
		
	}

}
