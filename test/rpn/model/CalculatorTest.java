package rpn.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {
    private CalculatorModel myCalculator;


    @BeforeEach
    void setup () {
        myCalculator = new CalculatorModel("English");
    }


    @Test
    void testAdd () {
        assertEquals(3, myCalculator.getResult("1 2 Add"));
        assertEquals(10, myCalculator.getResult("1 2 3 4 Add Add Add"));
        assertEquals(12, myCalculator.getResult("1 5 Add 6 Add"));
    }

    @Test
    void testMultiply () {
        assertEquals(2, myCalculator.getResult("1 2 Multiply"));
        assertEquals(24, myCalculator.getResult("1 2 3 4 Multiply Multiply Multiply"));
        assertEquals(30, myCalculator.getResult("1 5 Multiply 6 Multiply"));
    }

    @Test
    void testCombined () {
        assertEquals(7, myCalculator.getResult("1 2 Multiply 5 Add"));
        assertEquals(14, myCalculator.getResult("1 2 3 4 Multiply Add Multiply"));
        assertEquals(0, myCalculator.getResult("1 10 Add 0 Multiply"));
    }

    @Test
    void testUnknownOperation () {
        // Something using a badly-implemented operation
        assertThrows(UnsupportedOperationException.class, () -> myCalculator.getResult("Bad"));
    }

    @Test
    void testCalculatorExceptions() {
        CalculatorModel calculator = new CalculatorModel("English");
        CalculatorException exception = assertThrows(CalculatorException.class, () -> calculator.getResult("6"));
        String actual = exception.getMessage();
        String expected = "1 operands given, at least 2 needed";
        assertTrue(actual.contains(expected));
        exception = assertThrows(CalculatorException.class, () -> calculator.getResult("4 4 5 Add"));
        actual = exception.getMessage();
        expected = "Unused operands";
        assertTrue(actual.contains(expected));
    }
}
