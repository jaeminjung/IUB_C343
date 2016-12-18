import java.lang.Math;

//KDtree - C343 Summer 2016
//original code by Yuzhen Ye, CSCI, SoIC, IU
//
//KD tree with insert and exact match methods
//
//TODO for HW10: implement getNeighbors(Key[] key, int r)

public class KDtree<Key extends Comparable<? super Key>, E> {
	private BinNode<Key, E> root;
	private int totalNode;
	private BinNode<Key, E> curr; // works with find()
	private String enumStr; // for enumeration
	private int dim; // dimension of the key
	private int level; // which level; important for insertion & search

	public KDtree(int d) {
		root = curr = null;
		totalNode = 0;
		dim = d;
		level = 0;
	}

	public BinNode<Key, E> find(Key[] k) {
		if (root == null)
			return null;
		else {
			return find(root, 0, k);
		}
	}

	public BinNode<Key, E> find(BinNode<Key, E> entry, int thislevel, Key[] k) {
		if (entry == null)
			return null;
		curr = entry;
		level = thislevel; // update level
		if (entry.getKey() == k) {
			return curr;
		} else {
			if (entry.isLeaf())
				return null;
			Key[] key2 = entry.getKey();
			if (k[level % dim].compareTo(key2[level % dim]) >= 0) { // make sure
																	// the
																	// "right"
																	// key is
																	// used
				return find(entry.getRight(), thislevel + 1, k); // note
																	// thislevel
																	// + 1
			} else {
				return find(entry.getLeft(), thislevel + 1, k);
			}
		}
	}

	public void insert(Key[] k, E v) {
		BinNode<Key, E> node = new BinNode<Key, E>(k, v);
		insert(node);
		// insert(root, node);
	}

	public void insert(BinNode<Key, E> node) {
		find(node.getKey());
		if (curr == null) {
			root = node;
		} else {
			Key[] key1 = node.getKey();
			Key[] key2 = curr.getKey();
			if (key1[level % dim].compareTo(key2[level % dim]) >= 0) {
				if (curr.getRight() != null)
					node.setRight(curr.getRight());
				curr.setRight(node);
			} else {
				if (curr.getLeft() != null)
					node.setLeft(curr.getLeft());
				curr.setLeft(node);
			}
		}
		totalNode++;
	}

	public void preorder() {
		enumStr = "";
		System.out.println("Total node = " + totalNode);
		if (root != null)
			preorder(root);
		System.out.println("Preorder enumeration: " + enumStr);
	}

	private void preorder(BinNode<Key, E> node) {
		if (node != null)
			System.out.println("root " + node.toString());
		if (node.getLeft() != null)
			System.out.println("   left " + node.getLeft().toString());
		if (node.getRight() != null)
			System.out.println("   right " + node.getRight().toString());

		if (node != null) {
			enumStr += node.toString();
		}
		if (node.getLeft() != null)
			preorder(node.getLeft());
		if (node.getRight() != null)
			preorder(node.getRight());
	}

	// TODO for HW10 - implement the following method:
	 public void getNeighbors(BinNode<Key, E> node, Key[] key, int r) {
		 //System.out.println(node.getValue());
		 
		 if(calculateD(node,key,r)){
			 System.out.println(node.getValue());
		 }
		 
		 if(node.getLeft()!=null){
			 getNeighbors(node.getLeft(),key,r);
		 }
		 if(node.getRight()!=null){
			 getNeighbors(node.getRight(),key,r);
		 }
		 
		 /*
		 //calculateD(root, key);
		 String str = "";
		 if(calculateD(node, key, r)) {
			 str = str + node.getValue();
		 }
		 if(!node.getLeft().isLeaf()){
			 getNeighbors(root.getLeft(),key,r);
		 }
		 if(!!root.getRight().isLeaf()){
			 getNeighbors(node.getRight(),key,r);
		 }
		 */	 
	 }
	 
	 public boolean calculateD(BinNode<Key, E> node, Key[] key, int r){
		/* System.out.println(node);
		 System.out.println(node.getKey()[1]);
		 System.out.println(node.getKey().length);
		 System.out.println(key[1]);
		 */
		 double distance = 0;
		 for(int i = 0; i < node.getKey().length; i++){
			 int a = (int)node.getKey()[i] - (int)key[i];
			 //System.out.println(a);
			 int b = a * a;
			 distance = distance + b;
		 }
		 distance = Math.sqrt(distance);
		 //System.out.println(distance);
		 //int c = 65;
		 //System.out.println(distance < c);
		 
		 if(distance <= r)
			 return true;
		 else return false;
	 }

	// design your own examples to test the program!!
	public static void main(String[] args) {

		KDtree<Integer, String> kdt = new KDtree<Integer, String>(2);
		Integer[] dataA = { 40, 45 };
		kdt.insert(dataA, "A");
		Integer[] dataB = { 15, 70 };
		kdt.insert(dataB, "B");
		Integer[] dataC = { 70, 10 };
		kdt.insert(dataC, "C");
		Integer[] dataD = { 69, 50 };
		kdt.insert(dataD, "D");
		Integer[] dataE = { 66, 85 };
		kdt.insert(dataE, "E");
		Integer[] dataF = { 85, 95 };
		kdt.insert(dataF, "F");

		kdt.preorder();

		Integer[] dataG = { 85, 93 }; // G, close to F
		System.out.println("Query location: " + dataG[0] + " " + dataG[1]);
		BinNode<Integer, String> node = kdt.find(dataG); // exact match
		if (node == null) {
			System.out.println("point not found");
		} else {
			System.out.println("point found: " + node.toString());
		}
		
		//kdt.calculateD(kdt.root, dataG);
		
		int r = 3;
		kdt.getNeighbors(kdt.root, dataG, r); // get close neighbors
		
		//three dimensional test
		KDtree<Integer, String> kdt2 = new KDtree<Integer, String>(2);
		Integer[] dataA1 = { 40, 45, 35 };
		kdt2.insert(dataA1, "A");
		Integer[] dataB1 = { 15, 70, 56 };
		kdt2.insert(dataB1, "B");
		Integer[] dataC1 = { 70, 10, 15 };
		kdt2.insert(dataC1, "C");
		Integer[] dataD1 = { 69, 50, 49 };
		kdt2.insert(dataD1, "D");
		Integer[] dataE1 = { 66, 85, 26 };
		kdt2.insert(dataE1, "E");
		Integer[] dataF1 = { 85, 95, 200 };
		kdt2.insert(dataF1, "F");
		
		int r1 = 50;
		Integer[] dataG1 = { 85, 93, 201 }; //close to F1
		kdt.getNeighbors(kdt2.root, dataG1, r1);
	}
}
