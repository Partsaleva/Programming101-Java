package wednesday;
//Create a BST with a Node as nested class.
	//You should be able to add, search and remove an element. 
	//You should also calculate the depth and the height of a given element.
	//Bonus: Try to calculate the depth and height in O(1).
public class BST {

	public static void main(String[] args) {
		BST bst=new BST();
		bst.add(3);bst.add(4);bst.add(1);
		bst.toString();
	}
	
	
	Node root;
	BST(){
		root=null;
	}
	void add(int value){
		insert(root,value);
	}
	boolean search(){
		return false;}
	void remove(){}
	
	
	
	
	private void insert(Node root, int value){
		if (root == null){
			root = new Node(value);
			return ;
		}
		else if (value <= root.value){
			insert(root.left, value);
		}
		else{
			insert(root.right, value);
		}
		
	}
	class Node{
		int value;
		int height, depth;
		Node left;
		Node right;
		Node(int value){
			this.value=value;
			height=0;depth=0;
			left=null;right=null;			
		}
	}
}
