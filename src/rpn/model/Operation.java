package rpn.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Represents a general arithmetic operation.
 *
 * @author Robert C. Duvall
 */
public abstract class Operation {
	private int myNumOperands;

	/**
	 * Create operation that takes no arguments.
	 */
	protected Operation () {
		this(0);
	}

	/**
	 * Create operation that takes given number of arguments.
	 */
	protected Operation (int numOperands) {
		myNumOperands = numOperands;
	}


	/**
	 * Execute this operation within the given arithmetic expression.
	 */
	public void performOperation (Stack<Integer> expression) {
		List<Integer> operands = new ArrayList<>();
		for (int k = 0; k < myNumOperands; k += 1) {
			operands.add(expression.pop());
		}
		expression.push(execute(operands));
	}

	/**
	 * Returns number of operands needed for this operation.
	 */
	public int getNumOperandsNeeded () {
		return myNumOperands;
	}

	/**
	 * @see Object#toString()
	 */
	@Override
	public String toString () {
		return getClass().getSimpleName().replace("Operation", "");
	}


	/**
	 * Execute this operation on the given operands.
	 */
	protected abstract Integer execute (List<Integer> operands);
}
