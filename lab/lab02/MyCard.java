
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyCard implements Card {
	
	String[] cardsDeck;
	int listsize;
	Random rnd = new Random();
	
	//Constructor
	MyCard(){
		listsize = 52;
		cardsDeck = new String[listsize];
	}
	
	public void initialize(){

		for(int i=0; i<52; i++){
			//spades
			if(i<10){
				cardsDeck[i] = (i+1) + "S"; 
			} 
			if(i==10){
				cardsDeck[i] = "J" + "S";
			}
			if(i==11){
				cardsDeck[i] = "Q" + "S";
			}
			if(i==12){
				cardsDeck[i] = "K" + "S";
			}
			//clubs
			if(12<i&&i<23){
				cardsDeck[i] = (i - 12) + "C"; 
			}
			if(i==23){
				cardsDeck[i] = "J" + "C";
				}
			if(i==24){
				cardsDeck[i] = "Q" + "C";
				}
			if(i==25){
				cardsDeck[i] = "K" + "C";
			}
			//hearts
			if(25<i&&i<36){
				cardsDeck[i] = (i - 25) + "H"; 
			}
			if(i==36){
				cardsDeck[i] = "J" + "H";
				}
			if(i==37){
				cardsDeck[i] = "Q" + "H";
				}
			if(i==38){
				cardsDeck[i] = "K" + "H";
			}
			//diamonds
			if(38<i&&i<49){
				cardsDeck[i] = (i - 38) + "D"; 
			}
			if(i==49){
				cardsDeck[i] = "J" + "D";
				}
			if(i==50){
				cardsDeck[i] = "Q" + "D";
				}
			if(i==51){
				cardsDeck[i] = "K" + "D";
			}
		}
		
	}
	
	public String drawRandomCard(){
		int t = rnd.nextInt(52);
				
		String s = "";
		s = s + cardsDeck[t];
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCard first = new MyCard();
		first.initialize();
		System.out.println(first.drawRandomCard());
	}

}

