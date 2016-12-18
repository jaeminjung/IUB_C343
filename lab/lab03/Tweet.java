
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Tweet implements Tweet2 {
	
	String content;
	String author;
	List<String> listContent = new ArrayList<String>();;
	List<String> listAuthor = new ArrayList<String>();
	
	public Tweet() {
		this.content = content;
		this.author = author;
	}
	
	public void storeContent(String a){
		listContent.add(a);
	}
	public void storeAuthor(String a){ 
		listAuthor.add(author);
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
					"\n And the author is : " + listAuthor.get(i));
		}
		
	}

	public static void main(String[] args){
		/*
		List<String> shoplist = new ArrayList<String>();
		shoplist.add("milk jiwefji");
		shoplist.add("bacon");
		shoplist.add("bread");
        shoplist.contains("bred");
        System.out.println("size of the shopping list: " + shoplist.size());
        System.out.println("first one is " +shoplist.get(0));
        */
		
        System.out.println("Tweet");
        Tweet example = new Tweet();
        example.makeTweet();
        example.makeTweet();
        example.makeTweet();
        example.display();
        
        
	}
}
