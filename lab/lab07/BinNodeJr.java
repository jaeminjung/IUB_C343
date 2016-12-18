
public class BinNodeJr <E extends Comparable<?super E>>{ 
	private E value;
	private BinNodeJr<E> left;
	private BinNodeJr<E> right;
	
	
	public BinNodeJr(E e) {
		value = e;
		left = right = null;
	}
	public void setLeft(BinNodeJr<E> node) {
		left = node;
	}
	public void setRight(BinNodeJr<E> node) {
		right = node;
	}
	public E getValue(){
		return value;
	}
	
	
	
	public boolean find(E q) {
		
	    return (Math.random() < 0.5);
	}
	public static void main(String[] argv) {
	    System.out.println("BinNodeJr test running...");
	    // build a simple example tree:
		
	    
	    BinNodeJr<Integer> root = new BinNodeJr<Integer>(10);
		BinNodeJr<Integer> node1 = new BinNodeJr<Integer>(20);
		BinNodeJr<Integer> node2 = new BinNodeJr<Integer>(30);
		root.setLeft(node1);
		root.setRight(node2);
		BinNodeJr<Integer> node3 = new BinNodeJr<Integer>(40);
		BinNodeJr<Integer> node4 = new BinNodeJr<Integer>(50);
		node1.setLeft(node3);
		node1.setRight(node4);
		BinNodeJr<Integer> node5 = new BinNodeJr<Integer>(60);
		BinNodeJr<Integer> node6 = new BinNodeJr<Integer>(70);
		node2.setLeft(node5);
		node2.setRight(node6);
		/*
		// find() needs to be implemented
		System.out.println("is 40 in the tree? " + root.find(40));
		// find (40) should return true
		System.out.println("is 100 in the tree? " + root.find(100));
		// find (100) should return false
		 */
		 
	}
}
