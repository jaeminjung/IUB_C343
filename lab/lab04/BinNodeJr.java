

public class BinNodeJr<E> {
	public E value;
	public BinNodeJr<E> left;
	public BinNodeJr<E> right;

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

	public boolean isLeaf() {
		if (left == null && right == null) {
			return true;
		} else
			return false;
	}
	public boolean isLeftLeaf() {
		if(left == null){
			return true;
		}
		else
			return false;
	}
	public boolean isRightLeaf(){
		if(right == null){
			return true;
		}
		else 
			return false;
	}

	public static boolean find(BinNodeJr<Character> node, char q) {
		// this needs to be fixed so that it's not a random answer!
		
		if (node.getvalue() == q) {
			return true;
		}
		if (node.isLeaf()) {
			return false;
		} else {
			if(node.isLeftLeaf()) {
				find(node.right , q);
			}
			else {
				find(node.left, q);
			}
		}
		/*
		 * if (q == node.getvalue()) { return true; } else { if(node.isLeaf()) {
		 * return false; } if(node.left.getvalue()!=null) { return
		 * find(node.left, q); } else { if(node.right.getvalue()!= null) {
		 * return find(node.right, q); } else return false; } }
		 */
		return false;
	}

	public E getvalue() {
		return value;
	}

	public static void main(String[] argv) {
		/*
		 * System.out.println("BinNodeJr test running..."); // build a simple
		 * example tree: BinNodeJr<Integer> root = new BinNodeJr<Integer>(10);
		 * BinNodeJr<Integer> node1 = new BinNodeJr<Integer>(30);
		 * BinNodeJr<Integer> node2 = new BinNodeJr<Integer>(40);
		 * BinNodeJr<Integer> node3 = new BinNodeJr<Integer>(50);
		 * root.setLeft(node1); root.setRight(node2); node1.setLeft(node3); //
		 * find() needs to be implemented System.out.println(
		 * "is 40 in the tree? " + root.find(40)); // find (40) should return
		 * true System.out.println("is 100 in the tree? " + root.find(100)); //
		 * find (100) should return false System.out.println(node1.isLeaf());
		 * System.out.println(node1.getvalue());
		 */
		BinNodeJr<Character> root = new BinNodeJr<Character>('A');
		BinNodeJr<Character> node1 = new BinNodeJr<Character>('B');
		BinNodeJr<Character> node2 = new BinNodeJr<Character>('C');
		root.setLeft(node1);
		root.setRight(node2);

		BinNodeJr<Character> node3 = new BinNodeJr<Character>('D');
		BinNodeJr<Character> node4 = new BinNodeJr<Character>('E');
		node1.setLeft(node3);
		node1.setRight(node4);

		BinNodeJr<Character> node5 = new BinNodeJr<Character>('F');
		BinNodeJr<Character> node6 = new BinNodeJr<Character>('G');
		node2.setLeft(node5);
		node2.setRight(node6);

		BinNodeJr<Character> node7 = new BinNodeJr<Character>('H');
		node3.setLeft(node7);

		BinNodeJr<Character> node8 = new BinNodeJr<Character>('I');
		BinNodeJr<Character> node9 = new BinNodeJr<Character>('J');
		node4.setLeft(node8);
		node4.setRight(node9);

		BinNodeJr<Character> node10 = new BinNodeJr<Character>('K');
		node5.setLeft(node10);

		BinNodeJr<Character> node11 = new BinNodeJr<Character>('L');
		BinNodeJr<Character> node12 = new BinNodeJr<Character>('M');
		node6.setLeft(node11);
		node6.setRight(node12);

		// System.out.println(find(root, 'A'));
		//System.out.println(find(root, 'C'));

	}
}
