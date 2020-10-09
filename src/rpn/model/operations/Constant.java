package rpn.model.operations;

import java.util.List;
import rpn.model.Operation;


/**
 * Represents a constant value.
 *
 * @author Robert C. Duvall
 */
public class Constant extends Operation {
    private int myValue;


    /**
     * Create basic constant with given value.
     */
    public Constant (String number) {
        // verified as a number before being passed
        myValue = Integer.parseInt(number);
    }


    /**
     * @see Operation#execute(List)
     */
    @Override
    public Integer execute (List<Integer> operands) {
        return myValue;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString () {
        return "" + myValue;
    }
}
