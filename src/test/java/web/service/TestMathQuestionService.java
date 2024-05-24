import org.junit.Assert;
import org.junit.Test;
import web.service.MathQuestionService;

public class TestMathQuestionService {

    @Test
    public void testTrueAdd() {
        // Test addition of two numbers
        double result = MathQuestionService.q1Addition("1", "2");
        Assert.assertEquals("Addition of 1 and 2 should be 3", 3, result, 0);
    }

    @Test
    public void testAddNumber1Empty() {
        // Test addition with empty number1
        Double result = MathQuestionService.q1Addition("", "2");
        Assert.assertNull("Result should be null when number1 is empty", result);
    }
}
