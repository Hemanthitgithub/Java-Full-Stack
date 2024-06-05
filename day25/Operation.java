package day25;
import java.io.Serializable;

public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    private int number1;
    private int number2;
    private String operator;

    public Operation(int number1, int number2, String operator) {
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getOperator() {
        return operator;
    }

    public int getResult() throws IllegalArgumentException {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return number1 / number2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}