package List;

public class OrderedLinkedList<T extends Comparable<T>> extends LinkedList<T> {
	//private Node<T> head;<-- Inheritied
	private boolean ascending = true;
	public OrderedLinkedList(){}
	public OrderedLinkedList(boolean ascending){
		this.ascending = ascending;
	}
	public void add(T data) {//as of now only sports ascending order
		if(head==null){
			head = new Node<T>(data);
			return;
		}
		Node<T> temp = head;
		while(temp.next!=null){
			if(temp.data.compareTo(data)>=0 && temp.next.data.compareTo(data)<=0){
				temp.next = new Node<T>(data,temp.next);
				return;
			}
			temp = temp.next;
		}
		if(head.data.compareTo(data)<0){
			head = new Node<T>(data,head);
		}
		else{
			this.addToTail(data);
		}
	}
	public boolean remove(T data){
		if(head==null){
			return false;
		}
		Node<T> temp = head;
		while(temp!=null){
			temp = temp.next;
		}
		return false;
	}
	public void Combine(OrderedLinkedList<T> list){
		
	}
	public OrderedLinkedList<T> copy(){
		OrderedLinkedList<T> newList = new OrderedLinkedList<T>();
		Node<T> temp = head;
		while(temp!=null){
			newList.add(temp.data);
			temp = temp.next;
		}
		return newList;
	}
	public static <T extends Comparable<T>> OrderedLinkedList<T> Combine(OrderedLinkedList<T> list1, OrderedLinkedList<T> list2){
		OrderedLinkedList<T> newList = new OrderedLinkedList<T>();
		Node<T> temp = list1.head;
		while(temp!=null){
			newList.add(temp.data);
			temp = temp.next;
		}
		temp = list2.head;
		while(temp!=null){
			newList.add(temp.data);
			temp = temp.next;
		}
		return newList;
	}
	public static void main(String[] args) {
		OrderedLinkedList<Integer> list = new OrderedLinkedList<Integer>();
		list.add(4);list.add(2);list.add(1);list.add(2);list.add(3);list.add(10);list.add(5);
		System.out.println(list.toString());
		System.out.println("Done");
		OrderedLinkedList<Integer> nlist = list.copy();
		System.out.println(nlist.toString());
	}

}
