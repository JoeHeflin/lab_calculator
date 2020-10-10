package rpn.model.operations;

import rpn.model.Operation;

import java.util.List;

/**
 * Represents the binary multiplication operation between two numbers.
 *
 * @author Robert C. Duvall
 */
public class MultiplyOperation extends Operation {
	/**
	 * Create basic multiplication operation.
	 */
	public MultiplyOperation () {
		super(2);
	}


	/**
	 * @see Operation#execute(List)
	 */
	@Override
	public Integer execute (List<Integer> operands) {
		return operands.get(0) * operands.get(1);
	}
}
