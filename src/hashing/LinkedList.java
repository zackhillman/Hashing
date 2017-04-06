package hashing;

public class LinkedList <T extends Comparable<T>>{
	//Instance Variables
	private ListNode<T> head; //Singular instance variable, holds reference to first node
	
	/**
	 * Constructor method, instantiates all instance variables to null
	 */
	public LinkedList(){
		head = null;
	}
	/**
	 * Adds element to beginning of list
	 * @param element- the T element to add to the list
	 */
	public void addBeg(T element){
		ListNode<T> n = new ListNode<T>(element,head);
		head = n;			
	}
	/**
	 * This method adds element to end of list
	 * @param element- the T element to add to the list
	 */
	public void addEnd(T element){
		if(head!=null){
			ListNode<T> currentNode = head;
			while(currentNode.getNext()!=null)
				currentNode = currentNode.getNext();
			
			currentNode.setNext(new ListNode<T>(element,null));
		}else{
			head = new ListNode<T>(element,null);
		}
	}
	/**
	 * This method gets the first node's value
	 * @return- the T value of the first node
	 */
	public T getFirst(){
		if(head == null)
			throw new IllegalArgumentException("No Students");
		else
			return (T) head.getValue();
	}
	/**
	 * This method gets the last node's value
	 * @return- the T value of the node
	 */
	public T getLast(){
		if(head!=null){
			ListNode<T> currentNode = head;
			while(currentNode.getNext()!=null)
				currentNode = currentNode.getNext();
			
			return currentNode.getValue();
		}else{
			throw new IllegalArgumentException("No Students");
		}
	}
	/**
	 * This method removes the first node in the list
	 */
	public void remFirst(){
		if(head == null)
			throw new IllegalArgumentException("No Students");
		head = head.getNext();
	}
	/**
	 * This method removes the last node in the list
	 */
	public void remLast(){
		if(head == null)
			throw new IllegalArgumentException("No Students");
		if(head.getNext() == null){
			head = null;
			return;
		}
		ListNode<T> currentNode = head;
		ListNode<T> lastNode = currentNode;
		
		while(currentNode.getNext()!=null){
			lastNode = currentNode;
			currentNode = currentNode.getNext();
		}
		
		lastNode.setNext(null);
		
	}
	/**
	 * This method deletes all of the nodes in the list
	 */
	public void deleteAll(){
		head = null;
	}
	/**
	 * Gets string representation of all of the nodes in the list
	 */
	public String toString(){
		if(head == null){
			return "No Students";
		}else{
		ListNode<T> currentNode = head;
		String output = currentNode.getValue().toString()+"\n";
		
		while(currentNode.getNext()!=null){
			currentNode = currentNode.getNext();
			output += currentNode.getValue().toString()+"\n";
		}
		return output;
		}
	}
	
	public int find(T Element){
		int locations = 0;
		ListNode <T> Temp = head;
		while(Temp != null){
			Temp = Temp.getNext();
			locations++;
			if(Temp.getValue().compareTo(Element) == 0)
				return locations;
		}
		throw new IllegalArgumentException("Not Found Locations searched: " + locations);
	}
	
	
	
}
