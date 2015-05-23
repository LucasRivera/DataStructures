package List;

public class DoubleyLinkedList<T> extends LinkedList<T>{
	public static class DoubleyNode<T> extends Node<T>{
		//data is inherited
		//next is inherited
		Node<T> prev = null;
		public DoubleyNode(T data){
			super(data);
		}
		public DoubleyNode(T data, Node<T> next){
			super(data, next);
		}
		public DoubleyNode(T data, Node<T> next, Node<T> prev){
			super(data, next);
			this.prev = prev;
		}
		
	}
}
