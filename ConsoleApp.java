public class ConsoleApp{


	private int[] array;

	private int[] mergeSortTmpArray;

	private Node root;

	public static void main(String[] args){
		System.out.println("ConsoleApp");
		//int [] arrayToSort = new int[]{1,5,10,2,5,2,3,11,8};

		ConsoleApp consoleApp = new ConsoleApp();

		consoleApp.insert(2);
		consoleApp.insert(5);
		consoleApp.insert(3);

		System.out.println(consoleApp.lookup(4));



		/*consoleApp.sort(arrayToSort);

		for(int a : arrayToSort){
			System.out.print( a + " ");
		}*/
	}

	public void sort(int[] array){
		this.array = array;
		int lowerIndex = 0;
		int higherIndex = array.length - 1;

		//mergeSort(lowerIndex,higherIndex);
		//quickSort(lowerIndex,higherIndex);


	}

	public void insert(int data){
		root = insert(root, data);

	}

	public Node insert(Node node, int data){
		if(node == null){
			node = new Node(data);
		}
		else{
			if(data <= node.data){ 
				node.left = insert(node.left, data);
			}else{
				node.right = insert(node.right, data);
			}
		}
		return node;
	}

	public boolean lookup(int data){
		return lookup(root, data);
	}

	public boolean lookup(Node node, int data){
		if(node == null){
			return false;
		}
		else{
			if(node.data == data){
				return true;
			}else{
				if(data <= node.data){
					return lookup(node.left, data);
				}else{
					return lookup(node.right, data);
				}
			}

		}
	}

	public static class Node{
		Node left = null;
		Node right = null;

		int data;

		public Node(int data){
			this.data = data;
		}
	}

}