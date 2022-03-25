/**
 * This class simulate the functionality of a stack, but in a kind of linkedList.
 * 
 * @author moises.alonso
 *
 */
public class Node<T> {
	
	private T value;
	private Node<T> next;
	
	/**
	 *This is the constructor from the "linkedList" that inicialize the same with a null value.
	 *
	 *@author moises.alonso
	 */
	public Node() {
		next = null;
	}
	
	/**
	 * This is another constructor from the another kind of implementation of a Stack.
	 * Initialize the Stack with a value that it takes the constructor and make another
	 * Node for the stack.
	 * 
	 * @author moises.alonso
	 * @param Value, it's the firt value of the stack.
	 */
	public Node(T Value) {
		this.value = Value;
		this.next = null;
	}
	
	/**
	 *This getter return the current value.
	 *
	 * @author moises.alonso
	 *@return return the current value.
	 */
	public T getValue() {
		return this.value;
	}
	
	/**
	 * This setter modify the value of the stack.
	 * 
	 * @author moises.alonso
	 * @param value: T, this is the new value for the stack.
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
	/**
	 *This method it takes the next value from de current of the stack.
	 *
	 *@author moises.alonso
	 *@return return the next value of the stack.
	 */
	public Node<T> getNext() {
		return this.next;
	}
	
	/**
	 * This method set the next value of the stack to a new empty.
	 * 
	 * @author moises.alonso
	 * @param next: Node<T>, this is the new value.
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

}
