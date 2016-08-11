package utils;

import java.util.ArrayList;


public class Heap<T extends Comparable<T>> {
	private ArrayList<T> inner = new ArrayList<T>();
	protected boolean minHeap = false;//default to MaxHeap
	public Heap(){
		inner.add(null);
	}
	public Heap(T data){
		inner.add(null);
		inner.add(data);
	}
	public Heap(T data, boolean minHeap){
		inner.add(null);
		inner.add(data);
		this.minHeap = minHeap;
	}
	public T get(){
		if(inner.size()==1){
			return null;
		}
		else{
			return inner.get(1);
		}
	}
	public void add(T data){
		put(data);
	}
	public void put(T data){
		inner.add(data);
		int i = inner.size() - 1;
		int parent = 0;

		//compare the parent with the new item

		while(i!=1){
			if(i%2==0){
				parent = i/2;
			}
			else{
				parent = (i-1)/2;
			}
			if( (inner.get(i).compareTo(inner.get(parent))<0 && minHeap) || (inner.get(i).compareTo(inner.get(parent))>0 && !minHeap) ){
				//switch the parent and the child
				T temp;
				temp = inner.get(parent);
				inner.set(parent, inner.get(i));
				inner.set(i, temp);
				i = parent;
			}
			else{
				return;
			}
		}
	}
	public T del(){//doing minHeap only first then will generalize
		T temp = get();
		T t = null;
		if(temp==null){
			return null;
		}
		inner.set(1, inner.get(inner.size() - 1));
		inner.remove(inner.size()-1);
		int i = 1;
		int child = 0;
		while(2*i<inner.size()){
			if((2*i+1) == inner.size()){
				//only compare the last child
				if(inner.get(i).compareTo(inner.get(2*i))<0){
					break;
				}
				//swap
				t = inner.get(i);
				inner.set(i, inner.get(2*i));
				inner.set(2*i, t);
				break;
			}
			else{
				if(inner.get(2*i).compareTo(inner.get(2*i+1))<=0){
					child = 2*i;
				}
				else{
					child = 2*i + 1;
				}
				if(inner.get(i).compareTo(inner.get(child))>0){
					//need to swap
					t = inner.get(i);
					inner.set(i, inner.get(child));
					inner.set(child, t);
					i = child;
				}
				else{
					break;
				}
			}
		}
		return temp;
	}
    public void print(){
    	for(int i=0;i<inner.size();i++){
    		System.out.print(inner.get(i)+"\t");
    	}
    	System.out.println();
    }
	public static void main(String[] args) {
		Heap<Integer> h = new Heap<Integer>(10,true);
		h.add(7);
		h.add(8);
		h.add(30);
		h.add(15);
		h.add(5);
		h.print();
		h.del();
		h.print();
		h.del();
		h.print();
		h.del();
		h.print();
		h.del();
		h.print();
		h.del();
		h.print();
		h.del();
		h.print();
		h.del();
		h.print();
	}

}
