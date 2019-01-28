/*
 * Homework Assignment 1 - Burger Baron
 */
public class MyStack<Type> {
	private Node<Type> myNode; 
	private int mySize;
	
	/**
	 * Constructor for the MyStack Class.
	 */
	public MyStack () {
		myNode = null; 
		mySize = 0;
	}
	
	/*
	 * Checks if the stack is empty. 
	 */
	public boolean isEmpty() {
		boolean empty; 
		if(size() == 0) {
			empty = true; 
		} else {
			empty = false;
		}
		return empty;
	}
	
	/*
	 * pushes an item onto the stack. 
	 */
	public void push(Type item) {
		if(isEmpty()) {
			//if the stack is empty, then the previous and next node are null
			// and you'd just pass in the item. 
			myNode = new Node<Type>(item, null, null);
		} else {
			//if it's not empty, the current node is now the previous node. 
			Node<Type> tempNode = new Node<Type>(item, myNode, null);
			//current node is what's being added in now. 
			myNode = tempNode;
		}
		//if you push, the size increases. 
		mySize++;
	}
	
	/*
	 * removes top of the stack and returns it. 
	 */
	public Type pop() {
		//make a temporary node and set it to my current node. 
		Node<Type> tempNode = myNode;
		//move the current node to the next node
		myNode = myNode.myPrev;
		//decrease the size.
		mySize--; 
		//since you have the current node, just return that. 
		return tempNode.myItem;
	}
	
	/*
	 * looks at the top of the stack. 
	 */
	public Type peek() {
		return myNode.myItem;
	}
	
	private int size() {
		return mySize;
	}
	
	@Override
	public String toString() {
		String s = "";
		if(!isEmpty()) {
			Node<Type> tempNode = myNode;
		
			while(tempNode != null) {
				s += tempNode.toString();
				myNode = myNode.myPrev;
			}
		}
		
		return s;
	}
	
	public class Node<T> {
		public T myItem; 
		public Node<T> myNext; 
		//previous node (going down node)
		public Node<T> myPrev;
		//passing in the item of the stack, the previous node, and the next node(usually null)
		public Node(T item, Node<T> thePrevious, Node<T> theNext) {
			myItem = item; 
			myNext = theNext; 
			myPrev = thePrevious;
		}
	}
	
	
	
}
