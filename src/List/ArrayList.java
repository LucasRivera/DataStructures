package List;
/**ArrayList 
 * 
 * Default Type : Maintain Sequence
 * 
 * Type: Maintain Sequence
 * Maintains the sequence of adds and deletes
 * add: O(1)
 * delete: O(n)
 * get: O(1)
 * 
 * Type: Maintain Order(Sorted)
 * add: O(log(n))
 * delete: O(log(n))
 * get: O(1)
 * getIndex: O(log(n))
 * 
 * Type: Maintain Objects
 * add: O(1)
 * delete: O(n)
 * get: O(1)
 * */
public class ArrayList<T> implements List<T> {
	private Object[] buffer;
	private int spot = 0;
	private int size = 128;
	private int cap  = -1;
	private enum Type {Sequence,Order,Object};
	private Type type = Type.Sequence;
	public ArrayList(){
		buffer = new Object[size];
	}
	public ArrayList(int capSize){
		buffer = new Object[size];
		cap = capSize;
	}
	public void add(T data){
		if((spot+1)==cap){
			return;
		}
		if(spot==size){//need to expand
			size*=2;
			Object[] newBuffer = new Object[size];
			for(int i=0;i<buffer.length;i++){
				newBuffer[i] = buffer[i];
			}
			buffer = newBuffer;
		}
		buffer[spot] = data;
		spot++;
	}
	public boolean isFull(){
		if((spot+1)==cap){
			return true;
		}
		return false;
	}
	/**
	 * Follows the Pass-The-Buck Algorithm
	 * */
	public boolean remove(T data){
		//First the Algoritthm needs to find the data
		int index = getIndex(data);
		if(index==-1){
			return false;
		}
		T temp;
		for(;index<spot;index++){
			temp = (T)buffer[index];
			buffer[index] = buffer[index+1];
			buffer[index+1]=temp;
		}
		spot--;
		return true;
	}
	public boolean remove(){
		if(spot==0){
			return false;
		}
		spot--;
		return true;
	}
	public int getIndex(T data){
		if(type==Type.Sequence){//Just uses a basic iterator
			for(int i=0;i<buffer.length;i++){
				if(buffer[i].equals(data)){
					return i;
				}
			}
		}
		else if(type==Type.Order){//does a binary search
			
		}
		return -1;
	}
	public String toString(){
		String toRet = "";
		for(int i=0;i<spot;i++){
			toRet+=(buffer[i].toString()+"\t");
		}
		return toRet;
	}
	/**
	 * Driver/Unit Testing Proof
	 * */
	public static void main(String[] args){
			ArrayList<Integer> ints = new ArrayList<Integer>();
			System.out.println(ints.toString());
			ints.add(3);ints.add(4);ints.add(5);ints.remove(4);ints.add(6);
			System.out.println(ints.toString());
	}
	public int size() {
		return spot;
	}
}