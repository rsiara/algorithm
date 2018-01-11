public class DoubleLinkedList<T>{

	private Node<T> head;
	private Node<T> tail;

	public void addLast(T data){
	
		Node<T> newNode = new Node<T>(data);


		if(head != n){
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		else{
			head = newNode;
			tail = newNode;
		}
		

	}

	public void addFirst(T data){
	
		Node<T> newNode = new Node<T>(data);


		if(head != null){
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		else{
			head = newNode;
			tail = newNode;
		}
		

	}



	public void iterateForward(){
		Node<T> node = head;
		do{	
			System.out.println(node.data);
			node = node.next;	
		}while(node != null);

	}

	public void iterateBackward(){
		Node<T> node = tail;
		do{	
			System.out.println(node.data);
			node = node.prev;	
		}while(node != null);
	}

	public static void main(String[] args){
		System.out.println("Hello world");

		DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList<String>();

		System.out.println("A D D  L A S T - - - - - - - - - - - - - - - - ");
		doubleLinkedList.addLast("Dom");
		doubleLinkedList.addLast("Mama");
		doubleLinkedList.addLast("Kot");
		doubleLinkedList.addLast("Pies");

		doubleLinkedList.iterateForward();

		System.out.println("r e v e r s e - - - - - - - - - - - - - - - - - - ");

		doubleLinkedList.iterateBackward();

		System.out.println("A D D  F I R S T - - - - - - - - - - - - - - - - ");

		doubleLinkedList.addFirst("Motocykl");
		doubleLinkedList.addFirst("Karabin");
		doubleLinkedList.addFirst("Ameryka");

		doubleLinkedList.iterateForward();

		System.out.println("r e v e r s e - - - - - - - - - - - - - - - - ");

		doubleLinkedList.iterateBackward();
	
	}

	private static class Node<T>{
		private Node next = null;
		private Node prev = null;
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