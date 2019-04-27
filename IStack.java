package eg.edu.alexu.csd.datastructure.stack.cs;

public interface IStack {
	/**
	 * @author Essam
	* Removes the element at the top of stack and returns that element.
	*
	* @return top of stack element, or through exception if empty
	*/
	public Object pop();
	/**
	 * @author Essam
	* Get the element at the top of stack without removing it from stack.
	*
	* @return top of stack element, or through exception if empty
	*/
	public Object peek();
	/**
	 * @author Essam
	* Pushes an item onto the top of this stack.
	*
	* @param object
	* to insert
	* @return void
	*/
	public void push(Object element);
	/**
	 * @author Essam
	* Tests if this stack is empty
	*
	* @return true if stack empty
	*/
	public boolean isEmpty();
	/**
	 * @author Essam
	* Returns the number of elements in the stack.
	*
	* @return number of elements in the stack
	*/
	public int size();
	}