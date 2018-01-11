public class RedBlackTree{

	public Node root;

	private static final boolean RED   = true;
    private static final boolean BLACK = false;

	public void RedBlackTree(){
		root = null;
	}

	public void insert(int data){
		root = insert(root, data);
	}

	private Node insert(Node node, int data){
		if(node == null){
			node = new Node(data, RED);
		}else{
			if(data <= node.data){
				node.left = insert(node.left, data);
			}else{
				node.right = insert(node.right, data);
			}
		}

		//Balancing

		if (isRed(node.right) && !isRed(node.left))      node = rotateLeft(node);
        if (isRed(node.left)  &&  isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left)  &&  isRed(node.right))     flipColors(node);


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

		RedBlackTree redBlackTree = new RedBlackTree();

		redBlackTree.insert(5);
		redBlackTree.insert(3);
		redBlackTree.insert(2);
		redBlackTree.insert(9);
		redBlackTree.insert(8);

		System.out.println( redBlackTree.lookup(6) );

		System.out.println("Root: " + redBlackTree.root);

		redBlackTree.printTree();
	
	}

	private static class Node{
		private Node left = null;
		private Node right = null;
		private boolean color;
		private int data;

		public Node(int data, boolean color){
			this.data = data;
			this.color = color;
		}

		@Override
		public String toString(){
			return " " + data;
		}
	}

	 // make a left-leaning link lean to the right
    private Node rotateRight(Node h) {
        // assert (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;

        x.color = x.right.color;
        x.right.color = RED;
     
        return x;
    }

    // make a right-leaning link lean to the left
    private Node rotateLeft(Node h) {
        // assert (h != null) && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        
        x.color = x.left.color;
        x.left.color = RED;
   
        return x;
    }

    // flip the colors of a node and its two children
    private void flipColors(Node h) {
        // h must have opposite color of its two children
        // assert (h != null) && (h.left != null) && (h.right != null);
        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    public void printTree() {
		 printTree(root);
		 System.out.println();
	}

	private void printTree(Node node) {
 		if (node == null) return;

		 // left, node itself, right
	 	printTree(node.left);
	 	System.out.print(node.data + "(" + node.color + ")" +" ");
	 	printTree(node.right);
	}

	
}