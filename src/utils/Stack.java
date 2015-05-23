package utils;
import List.LinkedList;

public class Stack<T>{
	private LinkedList<T> buffer = new LinkedList<T>();
	public Stack(){}
	public Stack(T data){
		buffer.add(data);
	}
	public void push(T data){
		buffer.add(data);
	}
	public T pop(){
		return buffer.removeHead();
	}
	public boolean isEmpty(){
		if(buffer.size()==0){
			return true;
		}
		return false;
	}
}
