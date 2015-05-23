package List;

import List.LinkedList.Node;

public class CircleyLinkedList<T> extends LinkedList<T>{
	//head is inherited
	private Node<T> tail = null;
	private int Size = 0;
	public CircleyLinkedList(){super();}
	public CircleyLinkedList(T data){
		head = new Node<T>(data);
		tail = head;
		head.next = tail;
		tail.next = head;
		Size++;
	}
	public void add(T data){
		if(head==null){
			head = new Node<T>(data);
			tail = head;
			head.next = tail;
			tail.next = head;
			Size++;
			return;
		}
		super.add(data);
		tail.next = head;
		Size++;
	}
	public String toString(){
		String toRet = "";
		int c = 0;
		for(Node<T> temp=head;c<Size;temp=temp.next){
			toRet=(temp.data.toString()+'\t')+toRet;
			c++;
		}
		return toRet;
	}
	public static void main(String[] args){
		CircleyLinkedList<Integer> list = new CircleyLinkedList<Integer>();
		list.add(3);list.add(4);list.add(5);
		System.out.println(list.toString()+"Done");
	}
}
