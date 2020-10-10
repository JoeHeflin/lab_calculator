import java.awt.Dimension;
import javafx.application.Application;
import javafx.stage.Stage;
import rpn.model.CalculatorModel;
import rpn.view.CalculatorView;


/**
 * A simple RPN calculator in which parentheses are not needed to raise operator precedence:
 *   https://en.wikipedia.org/wiki/Reverse_Polish_notation
 *
 * @author Robert C. Duvall
 */
public class Main extends Application {
    public static final String TITLE = "RPN Calculator";
    public static final Dimension DEFAULT_SIZE = new Dimension(640, 480);
    public static final String LANGUAGE = "English";


    /**
     * @see Application#start(Stage)
     */
    @Override
    public void start (Stage stage) {
        // create program specific components
        CalculatorModel model = new CalculatorModel("English");
        CalculatorView display = new CalculatorView(model, LANGUAGE);
        // give the window a title
        stage.setTitle(TITLE);
        // add our user interface components to Frame and show it
        stage.setScene(display.makeScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height));
        stage.show();
    }

    /**
     * Start of the program.
     */
    public static void main (String[] args) {
        launch(args);
    }
}
