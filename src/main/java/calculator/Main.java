package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String expression = reader.readLine();
            if (expression.isEmpty()) {
                continue;
            }
            else if (expression.contains("exit")) {
                System.exit(0);
            }
            CalculatorFacade calculator = new CalculatorFacade();
            double result = calculator.getResult(expression);
            System.out.println(result);
        }
    }
}
