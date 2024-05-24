public class MathQuestionService {

    public static double q1Addition(String number1, String number2) {
        // Parse the input numbers as doubles
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);

        // Perform addition operation
        double result = num1 + num2;

        return result;
    }

    public static double q2Subtraction(String number1, String number2) {
        // Parse the input numbers as doubles
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);

        // Perform subtraction operation
        double result = num1 - num2;

        return result;
    }
}
