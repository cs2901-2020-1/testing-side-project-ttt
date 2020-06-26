package calculator;

import java.util.Vector;

public class CalculatorFacade {
    public double getResult(String expression) {
        // Parser expression
        Parser parserObj = new Parser(expression);
        Vector <String> postfixExp = parserObj.getPostfixVector();
        //System.out.println(postfixExp);

        // Evaluate postfix expression

        Operation operation = new Operation(postfixExp);

        // Return result
        return operation.getResult();
    }
}
