public class BinaryTree{

	public Node root;

	public void BinaryTree(){
		root = null;
	}

	public void insert(int data){
		root = insert(root, data);
	}

	private Node insert(Node node, int data){
		if(node == null){
			node = new Node(data);
		}else{
			if(data <= node.data){
				node.left = insert(node.left, data);
			}else{
				node.right = insert(node.right, data);
			}
		}
		return node;
	}

	public boolean lookup(int data){
		return(lookup(root, data));
	}

	public boolean lookup(Node node, int data){
		if(node == null){
			return false;
		}

		if(data == node.data){
			return true;
		}
		else if(data < node.data){
			return( lookup(node.left, data) );
		}
		else{
			return( lookup(node.right, data) );
		}
	}


	public static void main(String[] args){
		System.out.println("Hello world");

		BinaryTree binaryTree = new BinaryTree();

		binaryTree.insert(3);
		binaryTree.insert(5);
		binaryTree.insert(1);

		System.out.println( binaryTree.lookup(1) );

		System.out.println("Root: " + binaryTree.root);
	
	}

	private static class Node{
		private Node left = null;
		private Node right = null;
		private int data;

		public Node(int data){
			this.data = data;
		}

		@Override
		public String toString(){
			return " " + data;
		}
	}

	
}