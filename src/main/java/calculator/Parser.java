package calculator;

import java.util.Vector;
import java.util.Stack;

public class Parser {
    private final Vector<String> postfixExp = new Vector<>();
    private final String expression;

    private boolean isOperand(Character c){
        return c >= '0' && c <= '9';
    }

    private int getOperatorWeight(Character op){
        int weight = -1;
        switch(op){
            case '+':
            case '-':
                weight = 1;
                break;
            case '*':
            case '/':
                weight = 2;
                break;
        }
        return weight;
    }

    private boolean isOperator(Character c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean hasHigherPrecedence(Character op1, Character op2){
        int op1Weight = getOperatorWeight(op1);
        int op2Weight = getOperatorWeight(op2);
        if(op1Weight == op2Weight) {
            return true;
        }
        return op1Weight > op2Weight;
    }

    private void infixToPostfix() {
        Stack<Character> stackOperators = new Stack<>();
        StringBuilder operandSb = new StringBuilder();
        for(char c: expression.toCharArray()){
            if(isOperand(c)) {
                operandSb.append(c);
            }
            else if(isOperator(c)) {
                if(operandSb.length() > 0) {
                    postfixExp.add(operandSb.toString());
                    operandSb = new StringBuilder();    // Clear operandSb
                }
                // Mientras hayan operadores en el stack de mayor o igual precedencia que el actual sacarlos del stack
                while(!stackOperators.empty() && hasHigherPrecedence(stackOperators.peek(), c)) {
                    postfixExp.add(stackOperators.pop().toString());
                }
                // Si es de mayor precedencia ponerlo en el stack
                stackOperators.add(c);
            }
        }
        if(operandSb.length() > 0) {
            postfixExp.add(operandSb.toString());
        }
        // Saca del Stack operadores (de ser el caso)
        while(!stackOperators.isEmpty()) {
            postfixExp.add(stackOperators.pop().toString());
        }
    }

    public Parser(String _expression){
        expression = _expression;
    }

    public Vector<String> getPostfixVector(){
        infixToPostfix();
        return postfixExp;
    }
}
