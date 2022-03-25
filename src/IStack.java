/**
 * This interface it's use to simulate the functionality of a stack.
 * 
 * @author moises.alonso
 *
 */
public interface IStack<T> {
	/**
	 * This method it is use to put a value in the stack.
	 * @param value
	 */
	void push(T value);
		
	/**
	 * This method it is use to take of a value from the stack.
	 * 
	 * @author moises.alonso
	 * @return A value type T, that mean's whatever value inside.
	 */
	T pull();
	
	/**
	 * This method it's use to take the first value from the stack.
	 * 
	 * @author moises.alonso
	 * @return
	 */
	T peek();
	
	/**
	 * This method return the amount of values that are inside in the stack.
	 * 
	 * @author moises.alonso
	 */
	int count();
	
	/**
	 * This method verify if there's any value in the stack.
	 * 
	 * @author moises.alonso
	 */
	boolean isEmpty();
}