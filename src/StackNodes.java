/**
 * This class simulate ther functionlaity of a stack, beeing more
 * dinamic in all the posible ways (it has the functions of a stack).
 * @author moises.alonso
 *
 */
public class StackNodes<T> implements IStack<T>{
	
	private Node<T> head;
	private int count;
		
	/**
	 *  This is the constructor that make the first value of the stack be null. 
	 *  The first value it's the head.
	 *  
	 *  @author moises.alonso
	 */
	public StackNodes() {
		head = null;
	}
	
	/**
	 * This put a new vlaue in the stack, verify if the stack it's empty, if it is, 
	 * this new value will be the head.
	 * 
	 * @author moises.alonso
	 */
	@Override
	public void push(T value) {
		Node<T> newNode = new Node<T>(value);
		
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		count++;
	}
	
	/**
	 * This take of the last value of the stack and modify the state of
	 * the stack.
	 * 
	 * @author moises.alonso
	 * @return temp: T, the current value that it's the last.
	 */
	@Override
	public T pull() {
		
		if (count() == 0) {
			return null;
		} else if(count() == 1) {
			Node<T> temp = head;
			head = null;
			count--;
			return temp.getValue();
		} else {
			Node<T> temp = head;
			head = temp.getNext();
			count--;
			return temp.getValue();
		}
		
	}
	
	/**
	 * It returns the first value of the stack, but without 
	 * modifying the state of the stack.
	 * 
	 * @author moises.alonso
	 * @return head: T, the head value.
	 */
	@Override
	public T peek() {
		if (isEmpty()) {
			return null;
		} else {
			return head.getValue();
		}
	}
	
	/**
	 * It returns the amount of values in the stack.
	 * 
	 * @author moises.alonso
	 * @return count: int, the amount of values. 
	 */
	@Override
	public int count() {
		return count;
	}
	
	/**
	 * Indicates if the stack it's empty or not.
	 * 
	 * @author moises.alonso
	 * @return head == null || count == 0, that indicates if it's empty.
	 */
	@Override
	public boolean isEmpty() {
		return (head==null);
	}
}