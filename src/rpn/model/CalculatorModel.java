package rpn.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import rpn.model.operations.Constant;
import rpn.model.operations.AddOperation;
import rpn.model.operations.MultiplyOperation;
import rpn.model.operations.NegateOperation;


/**
 * Represents a Calculator that recognizes arithmetic expressions given in RPN format.
 *
 * @author Robert C. Duvall
 */
public class CalculatorModel {

    private static final String DEFAULT_RESOURCE_PACKAGE = "Errors.properties";
    private static final String RESOURCE_DIRECTORY = "./resources/";
    private final ResourceBundle myResources;

    public CalculatorModel(String language) {
        this.myResources = ResourceBundle.getBundle(language + DEFAULT_RESOURCE_PACKAGE);
    }


    /**
     * Returns the result of executing the given operations.
     */
    public int getResult (String input) {
        return evaluateExpression(parse(input));
    }


    // convert individual strings into arithmetic operations
    private List<Operation> parse (String input) {
        List<Operation> expression = new ArrayList<>();
        for (String token : input.split(" ")) {
            expression.add(makeOperation(token));
        }
        return expression;
    }

    // execute each operation too produce a single result
    private int evaluateExpression (List<Operation> expression) throws CalculatorException {

        Stack<Integer> operands = new Stack<>();
        for (Operation operation : expression) {
            if (expression.size() < 2) {
                throw new CalculatorException(myResources.getString(String.format("NEED_MORE_OPS_MESSAGE",expression.size())));
            }
            if (operation.getNumOperandsNeeded() <= operands.size()) {
                operation.performOperation(operands);
            }
        }
        if (operands.size() != 1) {
            throw new CalculatorException(myResources.getString("UNUSED_OPS_MESSAGE"));
        }

        return operands.pop();
    }


    // convert individual strings into arithmetic operations
    private Operation makeOperation (String token) throws UnsupportedOperationException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // TODO: refactor this too remove conditionals and replace with reflection
        if (isNumber(token)) {
            return new Constant(token);
        }
//        else if (token.equals("Negate")) {
//            return new NegateOperation();
//        }
//        else if (token.equals("Add")) {
//            return new AddOperation();
//        }
//        else if (token.equals("Multiply")) {
//            return new MultiplyOperation();
//        }
        else {
            Class<?> cl = Class.forName(token);
            Object obj = cl.newInstance();
            Operation op = (Operation) obj;
            return op;
        }
//        else {
//            throw new UnsupportedOperationException(String.format("Unrecognized command: %s", token));
//        }
    }

    // verify that given string is a number
    private boolean isNumber (String s) {
        return s != null && s.matches("-?\\d+");
    }

    // NOTE: Do NOT do this!
    // Effective Java item 57: Use exceptions only for exceptional conditions.
//	protected boolean isNumber (String s) {
//		try {
//			Integer.parseInt(s);
//			// only got here if we did not throw exception
//			return true;
//		} catch (NumberFormatException | NullPointerException e) {
//			return false;
//		}
//	}
}
