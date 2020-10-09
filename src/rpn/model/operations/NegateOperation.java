package rpn.model.operations;

import rpn.model.Operation;
import java.util.List;


/**
 * Represents the unary negation operation for one number.
 *
 * @author Robert C. Duvall
 */
public class NegateOperation extends Operation {
	/**
     * Create basic negation operation.
	 */
	public NegateOperation () {
		super(1);
	}


	/**
	 * @see Operation#execute(List)
	 */
	@Override
	public Integer execute (List<Integer> operands) {
		return -operands.get(0);
	}
}
