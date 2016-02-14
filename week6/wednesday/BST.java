package wednesday;

public class BST {

	public static void main(String[] args) {
		BST bst=new BST();
		bst.add(3);bst.add(4);bst.add(1);
		bst.toString();
	}
	//Create a BST with a Node as nested class.
	//You should be able to add, search and remove an element. 
	//You should also calculate the depth and the height of a given element.
	//Bonus: Try to calculate the depth and height in O(1).
	
	class Node{
		int value;
		Node right,left;
		int height, depth;
		Node(int value){
			setValue(value);
			setRight(null);setLeft(null);
			setHeight(0); setDepth(0);
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getDepth() {
			return depth;
		}
		public void setDepth(int depth) {
			this.depth = depth;
		}
		
	}
	private Node root=null;
	
	public void add(int value){
		insert(this.root,value);
	}
	public void search(){}
	public void remove(){}
	
	private void insert(Node node, int value){
		if(this.root==null){
			this.root=new Node(value);
		}
		else if(value<=node.getValue()){
			insert(node.getLeft(),value);
		}
		else{
			insert(node.getRight(),value);
		}
	}
}
