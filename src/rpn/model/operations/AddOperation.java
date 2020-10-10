package rpn.model.operations;

import rpn.model.Operation;

import java.util.List;


/**
 * Represents the binary addition operation between two numbers.
 *
 * @author Robert C. Duvall
 */
public class AddOperation extends Operation {
	/**
	 * Create basic addition operation.
	 */
	public AddOperation () {
		super(2);
	}


	/**
	 * @see Operation#execute(List)
	 */
	@Override
	public Integer execute (List<Integer> operands) {
		return operands.get(0) + operands.get(1);
	}
}
