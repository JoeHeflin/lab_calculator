package rpn.view;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import rpn.model.CalculatorException;
import rpn.model.CalculatorModel;

import java.util.List;
import java.util.ResourceBundle;


/**
 * A class used to display the results of a user entering an arithmetic expression in RPN format.
 *
 * @author Robert C. Duvall
 */
public class CalculatorView {
	// use Java's dot notation, like with import, for properties
	private static final String RESOURCE_PACKAGE = CalculatorView.class.getPackageName() + ".resources.";
	// use file system notation, standard Unix slashes, for other kinds of files
	public static final String DEFAULT_STYLESHEET = "/" + RESOURCE_PACKAGE.replaceAll("\\.", "/") + "default.css";
	// examples used to make buttons for quick input
	public static final List<Pair<String, String>> EXAMPLES = List.of(
			new Pair<>("1 + 2", "1 2 Add"),
			new Pair<>("(1 + 2) * 3", "1 2 Add 3 Multiply"),
			new Pair<>("Bad", "Bad")
	    );

	private Label myAnswer;
	private TextField myInput;
	private CalculatorModel myModel;
	private ResourceBundle myResources;


	/**
	 * Create a view of the given model with text displayed in the given language.
	 */
	public CalculatorView (CalculatorModel model, String language) {
		myModel = model;
		myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE + language);
	}


	/**
	 * Returns a scene of the given size containing all the interactive components of the view.
	 */
	public Scene makeScene (int width, int height) {
		VBox panel = new VBox();
		panel.getStyleClass().add("vbox");

		panel.getChildren().add(makeInputPanel("InputLabel"));
		panel.getChildren().add(makeExamplePanel("ExampleLabel"));
		panel.getChildren().add(makeAnswerPanel("AnswerLabel"));

		Scene scene = new Scene(panel, width, height);
		scene.getStylesheets().add(getClass().getResource(DEFAULT_STYLESHEET).toExternalForm());
		return scene;
	}

	private Node makeInputPanel (String label) {
		myInput = new TextField();
		myInput.setOnAction(event -> evaluateExpression(myInput.getText()));
		return makeLabelledPanel(label, myInput);
	}

	private Node makeExamplePanel (String label) {
		Button[] buttons = new Button[EXAMPLES.size()];
		// make button for each example
		for (int k = 0; k < EXAMPLES.size(); k += 1) {
			String expression = EXAMPLES.get(k).getValue();
			Button b = new Button(EXAMPLES.get(k).getKey());
			b.setOnAction(event -> evaluateExpression(expression));
			buttons[k] = b;
		}
		return makeLabelledPanel(label, buttons);
	}

	private Node makeAnswerPanel (String label) {
		myAnswer = new Label();
		myAnswer.getStyleClass().add("answer");
		return makeLabelledPanel(label, myAnswer);
	}

    // add all of the given nodes to a panel with given label
	private Node makeLabelledPanel (String label, Node ... nodes) {
		HBox panel = new HBox(new Label(myResources.getString(label)));
		panel.getStyleClass().add("hbox");
        // add given nodes to this panel after the label
		for (Node n : nodes) {
			panel.getChildren().add(n);
		}
		return panel;
	}

	// use model to evaluate the entered expression
	private void evaluateExpression (String expression) {
		try {
			// set text in case button was pressed instead of text field
			myInput.setText(expression);
			// display answer
			myAnswer.setText("" + myModel.getResult(expression));
		}
		catch (CalculatorException e) {
			myAnswer.setText("<error>");
		}
	}
}
