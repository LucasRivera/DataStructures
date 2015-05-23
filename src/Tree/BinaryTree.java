package Tree;

import List.LinkedList;

public class BinaryTree<T extends Comparable<T>> {
	private BinaryNode<T> root;
	public static class BinaryNode<T extends Comparable<T>>{
		private BinaryNode<T> leftChild;
		private BinaryNode<T> rightChild;
		private T data;
		public BinaryNode(){}
		public BinaryNode(T data){
			this.data = data;
		}
		public BinaryNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild){
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}
	public void add(T data){//Non-Recursive way
		if(root==null){
			root = new BinaryNode<T>(data);
			return;
		}
		BinaryNode<T> prev = root;
		while(true){
			if(prev.data.compareTo(data)>0){//check left
				if(prev.leftChild==null){//found spot
					prev.leftChild = new BinaryNode<T>(data);
					break;
				}//else continue
				prev = prev.leftChild;
				continue;
			}
			else if(prev.data.compareTo(data)<0){//check right
				if(prev.rightChild==null){//found spot
					prev.rightChild = new BinaryNode<T>(data);
					break;
				}//else continue
				prev = prev.rightChild;
				continue;
			}
			else{
				break;
			}
		}
	}
	public void add(T data, boolean recursive){
		if(!recursive)
			add(data);
		BinaryNode<T> temp = root;
		addRec(temp,data);
	}
	private void addRec(BinaryNode<T> prev, T data){
		if(prev.data.compareTo(data)>0){//check left
			if(prev.leftChild==null){//found spot
				prev.leftChild = new BinaryNode<T>(data);
				return;
			}//else continue
			prev = prev.leftChild;
			addRec(prev,data);
		}
		else if(prev.data.compareTo(data)<0){//check right
			if(prev.rightChild==null){//found spot
				prev.rightChild = new BinaryNode<T>(data);
				return;
			}//else continue
			prev = prev.rightChild;
			addRec(prev,data);
		}
		else{
			return;
		}
	}
	
	public void printTree(){//iterative solution
		
	}
	public void printTreeRec(){
		printTreeRec(0);
	}
	public void printTreeRec(int i){
		BinaryNode<T> temp = root;
		if(i<0){//preorder
			printPreOrder(temp);
		}
		else if(i>0){//post order
			printPostOrder(temp);
		}
		else{//in order
			printInOrder(temp);
		}
	}
	private void printInOrder(BinaryNode<T> temp){
		if(temp==null){
			return;
		}
		printInOrder(temp.leftChild);
		System.out.print(temp.data.toString()+"\t");
		printInOrder(temp.rightChild);
	}
	private void printPostOrder(BinaryNode<T> temp){
		if(temp==null){
			return;
		}
		printInOrder(temp.leftChild);
		printInOrder(temp.rightChild);
		System.out.print(temp.data.toString()+"\t");
	}
	private void printPreOrder(BinaryNode<T> temp){
		if(temp==null){
			return;
		}
		System.out.print(temp.data.toString()+"\t");
		printInOrder(temp.leftChild);
		printInOrder(temp.rightChild);
	}
	public void printLevelOrder(){
		
	}
	private void printLevelOrderRec(BinaryNode<T> temp){
		if(temp==null){
			return;
		}
		
	}
	public LinkedList<T> toLinkedList(){//TODO
		LinkedList<T> list = new LinkedList();
		return list;
	}
	public static void main(String[] args){
		BinaryTree<Integer> ints = new BinaryTree<Integer>();
		ints.add(3);ints.add(5);ints.add(2);ints.add(4);
		ints.printTreeRec(0);
		System.out.println();
		ints.printTreeRec(-1);
	}
}
