package List;

public class LinkedList<T> implements List<T> {
	protected Node<T> head = null;
	public static class Node<T>{
		T data = null;
		Node<T> next = null;
		public Node(){}
		public Node(T data){
			this.data = data;
		}
		public Node(T data, Node<T> next){
			this.data = data;
			this.next = next;
		}
		public String toString(){
			if(next==null){
				return "["+data.toString()+"]";
			}
			else{
				return "["+data.toString()+"]"+"->";
			}
		}
	}
	
	/**
	 * Default is add to front
	 * */
	public void add(T data) {
		if(head == null){
			head = new Node<T>(data);
			return;
		}
		Node<T> newHead = new Node<T>(data,head);
		head = newHead;
	}
	/**Not Recommended for general use (Can not use it with Polymorphic design)
	 * 
	 * */
	public void addToTail(T data){
		Node<T> temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = new Node<T>(data);
	}
	public T removeHead(){
		if(head==null){
			return null;
		}
		T toRet = head.data;
		head = head.next;
		return toRet;
	}
	public boolean remove(T data) {
		// TODO Auto-generated method stub
		return false;
	}
	public void reverse(){
		LinkedList<T> newlist = new LinkedList<T>();
		int size = this.size();
		for(int i=0;i<size;i++){
			newlist.add(this.removeHead());
		}
		this.head = newlist.head;
	}
	public void rotateLeft(){
		
	}
	public void rotateLeftn(int n){
		for(int i=0;i<n;i++)
			rotateLeft();
	}
	public void rotateRight(){
	
	}
	public void rotateRightn(int n){
		for(int i=0;i<n;i++)
			rotateRight();
	}
	public int size(){
		int i=0;
		for(Node<T> temp=head;temp!=null;temp=temp.next)
			i++;
		return i;
	}
	public String toString(){
		String toRet = "";
		for(Node<T> temp=head;temp!=null;temp=temp.next)
			toRet=(temp.data.toString()+'\t')+toRet;
		return toRet;
	}
	public static void main(String[] args) {
		LinkedList<Integer> ints = new LinkedList<Integer>();
		ints.add(3);ints.add(5);ints.add(2);ints.add(4);ints.addToTail(6);
		//ints.reverse();
		System.out.println(ints.toString());
		System.out.println(ints.size());

	}
}
