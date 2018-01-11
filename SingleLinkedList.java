public class SingleLinkedList<T>{

	private Node head;

	public void append(T data){
		
		if(head == null){
			head = new Node<T>(data);
		}else{
			Node<T> newNode = new Node<T>(data);
			newNode.next = head;
			head = newNode;
		}

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
		SingleLinkedList<String> singleLinkedList = new SingleLinkedList<String>();
		singleLinkedList.append("Dom");
		singleLinkedList.append("Kot");
		singleLinkedList.append("Marcepan");
		singleLinkedList.append("Mleczko");
		singleLinkedList.iterate();                              
	
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