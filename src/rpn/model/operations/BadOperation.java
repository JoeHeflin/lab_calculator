package rpn.model.operations;

import rpn.model.Operation;


/**
 * Represents an operation that should not be able to be created.
 *
 * @author Robert C. Duvall
 */
public abstract class BadOperation extends Operation {
	// should not be possible to create this class using NEW
	// however, with reflection, can write the following code but it throws an exception
	//     return (Operation)Class.forName("rpn.model.operations.BadOperation").getConstructors()[0].newInstance();
}
