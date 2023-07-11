package assignment2;

public class MyQueue<E> {  //<E> indicates that the queue can hold elements of any specific type
	private Node front; //Store the front,head of the queue
	private Node rear; //Store the rear,tail of the queue
	private int size = 0; //Store the size of the queue and begin with 0
	
	//Create a node class to store the data and the previous and next pointers
	private class Node{
	    E data;
	    Node next;
	    Node prev;

	    private Node(E data) { //a new node that created gets data with arguments passed in and node.next == null, node.prev == null
	        this.data = data;
	        this.next = null;
	        this.prev = null;
	    }
	}
	
	//Function to get the size of queue
	public int size() {
		return size;
	}
	
	//function to check queue is empty or not
	public boolean isEmpty()
	{
		if(size == 0) //if size == 0, return true -> queue is empty
			return true;
		else // else return false -> queue is not empty
			return false;
	}
	
	//function to add an element to the rear of queue
	public void enQueue(E data){
		Node aNode = new Node(data); // create a new node
		if(isEmpty()) //if queue is empty
		{
			front = rear = aNode; //assign new node become front and rear
			size++; //increase size by 1 unit
		}
		else //if queue is not empty
		{
			rear.next = aNode; //link the rear.next of the queue to new node
			aNode.prev = rear;  //link previous of new node to the rear
			rear = aNode; //assign new node become rear
			size++; //increase size by 1 unit
		}
	}
	
	//function to remove the front of queue and return that element
	public E deQueue()
	{
		Node current = front; //create node current pointer to the front
		if(isEmpty()) //if queue is empty return null
		{
			return null;
		}
		else if(current.next == null) { //if queue has only 1 node
			front = null; //assign front become null
			rear = null; //assign rear become null
			size--; //decrease size by 1 unit
			return current.data; //return data of element that removed
		}
		else //other cases
		{
			Node temp = current.next; //create node temp to storage node after front
			current.next = null; // unlink front.next and node after front
			temp.prev = null; //unlink the previous node after front and front
			front = temp; ////assign node after front become new front
			size--; //decrease size by 1 unit
			return current.data; //return data of element that removed
		}
	}
	
	//function to print data of queue
	public String toString() {
		String str = "["; //create str with String data type with data: [ 
		Node current = front; // create Node current pointer to the front
		while(current!= null) { //check if current pointer is null or not
			str += current.data; //plus String with data of current pointer
			current = current.next; // point current to next Node
			if(current!= null) //check if current!= null to print the comma after per data and last data will not print the comma e.g. [ a, b, c
			str += ", ";
		}
		return str + "]"; //return all data of the queue from top plus ]
	}
	
	//function to search position of element in the queue... 1-based
	public int search(E data) { 
		int count = 1; //create count with integer data type with data =1
		Node current = front; //create Node current pointer to the front 
		while(current!= null) //check node current is null or not, if null return -1 ->no key search in the queue
		{			
			if(current.data == data) //check arguments == data in the node current
			{
				return count; //return position of element in the queue and end the function
			}
			else // if arguments != data in the node current, increase count by 1 unit and update current= the next node
			{
			count++;
			current = current.next;
			}
		}
		return -1;
	}

	//function to get data of the front of queue and without change the queue
	public E getFront()
	{
		if(isEmpty()) //if queue is empty return null
			return null;
		else  //else return data of the front of queue
			return front.data;
	}
	
	//function to get data of the top of queue and without change the queue
	public E getRear()
	{
		if(isEmpty()) //if queue is empty return null
			return null;
		else //else return data of the rear of queue
			return rear.data;
	}
	
	//function to get data of index of the queue
	public E getDataOfIndex(int index) {
		Node current = front; //create Node current pointer to the front 
		if(index <0 || index > size - 1) //if argument passed in < 0 or >= size of queue; return null
		{
			return null;
		}
		else { //other cases
			int i = 0; //create i with integer data type and data = 0
			while(i< index) {	//increase i and node current until i = index;
				current = current.next;
				i++;
			}
		return current.data; //return data of node current of queue
		}
		 
	}
	
}
