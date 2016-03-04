
//Create a BST with a Node as nested class.
	//You should be able to add, search and remove an element. 
	//You should also calculate the depth and the height of a given element.
	//Bonus: Try to calculate the depth and height in O(1).
public class BST {

	public static void main(String[] args) {
		BST bst=new BST();
		bst.add(3);bst.add(4);bst.add(1);
		System.out.println(bst.toString());
		bst.search(3); 
		bst.search(5);
		bst.remove(3);
		bst.search(3);
	}
	
	class Node{
		int value;
		int height, depth;
		Node left;
		Node right;
		Node(int value){
			this.value=value;
			left=null; right=null;	
			height=0; depth=0;
		}
	}
	
	Node root;
	BST(){
		root=null;
	}
	
	public void add(int value) {
	    root = insertNode(root, new Node(value));
	}

	public void search(int value){
		if (searchNode(root, value) == true){
			System.out.println(String.format("%s is found.", value));
		}
		else{
			System.out.println(String.format("%s not found.", value));
		}
	}
	
	public void remove(int value){
		remNode(root, value);
	}
	
	private boolean searchNode(Node root, int value){
		if (root == null){
			return false;
		}
		else if (value == root.value){
			return true;
		}
		else if (value <= root.value){
			return searchNode(root.left, value);
		}
		else{
			return searchNode(root.right, value);
		}
	}

	private Node insertNode(Node currentParent, Node newNode) {

	    if (currentParent == null) {
	        return newNode;
	    } 
	    else if (newNode.value > currentParent.value) {
	        currentParent.right = insertNode(currentParent.right, newNode);
	        currentParent.right.depth++;
	    } 
	    else if (newNode.value <= currentParent.value) {
	        currentParent.left = insertNode(currentParent.left, newNode);
	        currentParent.left.depth++;
	    }

	    return currentParent;
	}
	
	
	//remove Node
	private	void remNode(Node root,int value){
			if (root == null){
				return;
			}
			else if (value < root.value){
				remNode(root.left, value);
			}
			else if (value > root.value){
				remNode(root.right, value);
			}
			else{
				//1. no child
				if (root.left == null && root.right == null){				
					root = null;
				}
				//case 2: has right child
				else if (root.left == null){
					root = root.right;
				}
				//case 3 : has left child
				else if (root.right == null){
					root = root.left;			
				}
				//case 4: has 2 children
				else{
					Node temp = findMax(root.left); //maximum in right subtree
					root.value = temp.value; //swap values
					remNode(root.right, temp.value);//remove like in case 2
				}
			}
		}

		// find maximum in tree- function used in remNode
		private Node findMax(Node root){
			if (root == null){
				return root;
			}
			else if (root.right == null){
				return root;
			}
			return findMax(root.right);
		}
	
	
	
	
	
}
