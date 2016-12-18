
import java.util.List;
import java.net.URL;
import java.util.*;

import java.util.Scanner;
import java.io.IOException;

public class Tweet implements Tweet2 {
	
	String content;
	String author;
	List<String> listContent = new ArrayList<String>();;
	List<String> listAuthor = new ArrayList<String>();
	
	public Tweet() {
		this.content = content;
		this.author = author;
	}
	
	public void readFromURL() throws Exception {
		URL url = new URL(
				"http://homes.soic.indiana.edu/classes/summer2016/csci/c343-mitja/2016/homework/tweet-data-June29.txt");
		Scanner in = new Scanner(url.openStream());

		while (in.hasNext()) {
			// nextLine() reads a line;
			// Scanner class has other methods to allow the user to read values
			// of various types, eg.., nextInt()
			String author = in.next();
			storeAuthor(author);
			
			String content = in.nextLine();
			storeContent(content);	
		}
		
		in.close();
	}
	
	public void storeContent(String a){
		listContent.add(a);
	}
	public void storeAuthor(String a){ 
		listAuthor.add(a);
	}
	
	public void makeTweet(){
		System.out.println("Make a Tweet : ");
		Scanner scan = new Scanner(System.in);
		content = scan.nextLine();
		storeContent(content);
		
		System.out.println("Author is : ");
		author = scan.nextLine();
		storeAuthor(content);
	}
	
	public void display(){
		System.out.println("your all tweets are : ");
		for(int i = 0; i < listContent.size(); i++){
			System.out.println("tweet is : " + listContent.get(i) + 
					"\nAnd the author is : " + listAuthor.get(i));
			System.out.println();
		}
		
	}

	public static void main(String[] args) throws Exception{
		/*
		List<String> shoplist = new ArrayList<String>();
		shoplist.add("milk jiwefji");
		shoplist.add("bacon");
		shoplist.add("bread");
        shoplist.contains("bred");
        System.out.println("size of the shopping list: " + shoplist.size());
        System.out.println("first one is " +shoplist.get(0));
        */
		
        /*
        Tweet example = new Tweet();
        example.makeTweet();
        example.makeTweet();
        example.makeTweet();
        example.display();
        
        Tweet example1 = new Tweet();
        example1.readFromURL();
        example1.display();
        */
        
	}
}
