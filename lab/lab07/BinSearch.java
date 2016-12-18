public class BinSearch<E extends Comparable<?super E>>{

	
	public int search(E[] anArray, E value){
		int low = 0;
		int high = anArray.length-1;
		while(low!=high){
			if(high<low){
				break;
			}
			int mid = (low + high)/2;
			if(anArray[mid].compareTo(value) < 0){
				low = mid +1;
			}
			
			if(anArray[mid].compareTo(value) > 0){
				high = mid -1;
			}
			if(anArray[mid].compareTo(value) ==0){
				return mid;
			}
		}
		return anArray.length;
	}

	
	/*public int IntSearch(int a){
		int low = 0;
		int high = IntArray.length-1;
		
		while(low!=high){
			if(high < low){
				break;
			}
			int mid = (low + high)/2;
			
			if(IntArray[mid] < a){
				low = mid+1;
			}
			if(IntArray[mid] > a){
				high = mid-1;
			}
			if(IntArray[mid] == a){
				return mid;
			}
		}
		return IntArray.length;
	}
	public int StrSearch(String a){
		int low = 0;
		int high = StrArray.length-1;
		
		while(low!=high){
			if(high < low){
				break;
			}
			int mid = (low + high)/2;
			
			if(StrArray[mid].compareTo(a) < 0){
				low = mid+1;
			}
			if(StrArray[mid].compareTo(a) > 0){
				high = mid-1;
			}
			if(StrArray[mid].compareTo(a)==0){
				return mid;
			}
		}
		return StrArray.length;
	}*/

	

	public static void main(String[] args){
		
		Integer[] IntArray = {10, 14, 19, 26, 27, 31, 33, 35, 42, 44};
		String[] StrArray = {"a","b", "c", "d", "e"};
		BinSearch<Integer> ex = new BinSearch<Integer>();
		BinSearch<String> es = new BinSearch<String>();
		Integer q = 31;
		System.out.println(ex.search(IntArray, q ));
		String d= "d";
		System.out.println(es.search(StrArray, d));
		
		//ex.search(2);
		
	}
}
