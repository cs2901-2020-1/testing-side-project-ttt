package calculator;

public class Substraction {
    private final Float operand1;
    private final Float operand2;

    public Substraction(Float op1, Float op2) {
        operand1 = op1;
        operand2 = op2;
    }

    public Float getResult() {
        return operand1 - operand2;
    }
}
