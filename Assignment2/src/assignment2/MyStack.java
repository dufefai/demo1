package assignment2;


public class MyStack<E> { //<E> indicates that the stack can hold elements of any specific type
	private Node top; //Store the top pointer
	private int size= 0; //Store the size of the stack and begin with 0
	
	//Create a node class to store the data and the next pointer.
	private class Node{
		E data;
		Node next;
		
		private Node(E data){
			this.data = data; //a new node that created gets data with arguments passed in and node.next == null
			this.next = null;
		}
	}
	//Function to get the size of Stack
	public int size() {
		return size;
	}
	
	//function to print data of stack
	public String toString() {
		String str = "["; //create str with String data type with data: [ 
		Node current = top; // create Node current pointer to the top
		while(current!= null) { //check if current pointer is null or not
			str += current.data; //plus String with data of current pointer
			current = current.next;// point current to next Node
			if(current!= null) // check if current!= null to print the comma after per data and last data will not print the comma e.g. [ a, b, c
			str += ", ";
		}
		return str + "]"; //return all data of the stack from top plus ]
	}
	
	//function to check stack is empty or not
	public boolean isEmpty() {
		if(size == 0) //if size == 0, return true -> stack is empty
			return true;
		else
			return false;// else return false -> stack is not empty
	}
	
	//function to add an element to the top of stack
	public void push(E data) { 
		Node newNode = new Node(data); // create a new node
			newNode.next = top; //link new node to the top, if the stack null =>top null => nothing changes
			top = newNode; //point top to the new node
			size ++; // increase size by 1 unit
	}
	
	//function to remove the top of stack and return that element
	public E pop() { 
		if(isEmpty()) { //if stack is empty return null
			return null;
		}
		else { //if stack is not empty
			Node current = top; //create Node current pointer to the top
			top = top.next; //assign the node after top become top
			current.next = null; //cut link between old top and new top
			size --; //// decrease size by 1 unit
			return current.data; //return the data of element that removed
		}
	}
	
	//function to get data of the top of stack and without change the stack
	public E peek() {
		if(isEmpty()) { //if stack is empty return null
			return null;
		}
		else //else return data of the top of stack
			return top.data;
	}
	
	//function to search position of element in the stack... 1-based
	public int search(E data) {
		int count = 1; //create count with integer data type with data =1
		Node current = top; //create Node current pointer to the top
		while(current!= null) //check node current is null or not, if null return -1 ->no key search in the stack
		{			
			if(current.data == data) //check arguments == data in the node current
			{
				return count; //return position of element in the stack and end the function
			}
			else // if arguments != data in the node current, increase count by 1 unit and update current= the next node
			{
			count++;
			current = current.next;
			}
		}
		return -1;
	}
	

}
