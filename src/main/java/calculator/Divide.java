package calculator;

public class Divide {
    private final Float operand1;
    private final Float operand2;

    public Divide(Float op1, Float op2) {
        operand1 = op1;
        operand2 = op2;
    }

    public Float getResult() {
        return operand1 / operand2;
    }
}
