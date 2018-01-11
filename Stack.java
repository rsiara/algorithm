public class Stack<T>{

	private Node head;

	public void push(T data){
		

		if(head == null){
			head = new Node<T>(data);
		}else{
			Node<T> newNode = new Node<T>(data);
			newNode.next = head;
			head = newNode;
		}
		

	}

	public Node<T> pop(){
		Node nodeToReturn = head;

		head = head.next;
		return nodeToReturn;
	}

	public void iterate(){
		Node<T> currentNode = head;
		do{	
			System.out.println(currentNode.data);
			currentNode = currentNode.next;	
		}while(currentNode != null);

	}

	public static void main(String[] args){
		System.out.println("Hello world");
		Stack<String> stack = new Stack<String>();
		stack.push("Dom");
		stack.push("Kot");
		stack.push("Marcepan");
		stack.push("Mleczko");

		System.out.println("--- ITERATTE ---");
		stack.iterate();

		System.out.println("--- POPS ---");
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());


	}

	private static class Node<T>{
		private Node next = null;
		private T data;

		public Node(T data){
			this.data = data;
		}

		@Override
		public String toString(){
			return data.toString();
		}
	}

	

	
}