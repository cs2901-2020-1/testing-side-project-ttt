package calculator;

import java.util.Stack;
import java.util.Vector;

public class Operation {
    private Vector <String> postfixExpression;
    private Stack <Float> operationNumbers = new Stack<Float>();

    private boolean isOperand(char C) {
        return Character.isDigit(C);
    }

    private int convertOperandToInt(String C) {
        try {
            int operand = Integer.parseInt(C);
            return operand;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean isOperator(char C) {
        return C == '+' || C == '-' || C == '*' || C == '/';
    }

    private Float executeOperation(char operation, Float operand1, Float operand2) {
        switch (operation) {
            case '+': {
                Addition addition = new Addition(operand1, operand2);
                return addition.getResult();
            }
            case '-': {
                Substraction substraction = new Substraction(operand1, operand2);
                return substraction.getResult();
            }
            case '*': {
                Multiplication multiplication = new Multiplication(operand1, operand2);
                return multiplication.getResult();
            }
            case '/': {
                Divide divide = new Divide(operand1, operand2);
                return divide.getResult();
            }
            default: {
                return -1.0f;
            }
        }
    }

    private Float solver() {
        for (String element : postfixExpression) {
            char temporal = element.charAt(0);
            if (isOperand(temporal)) {
                Integer numberElement = convertOperandToInt(element);
                Float value = numberElement.floatValue();
                operationNumbers.push(value);
            }
            else if (isOperator(temporal)) {
                Float operand2 = operationNumbers.peek();
                operationNumbers.pop();
                Float operand1 = operationNumbers.peek();
                operationNumbers.pop();
                Float result = executeOperation(temporal, operand1, operand2);
                operationNumbers.push(result);
            }
        }
        return operationNumbers.peek();
    }

    //PUBLIC SECTION

    public Operation(Vector <String> postfix) {
        postfixExpression = postfix;
    }

    public Float getResult() {
        return solver();
    }
}
