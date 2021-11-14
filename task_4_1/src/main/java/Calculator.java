import java.util.Scanner;
import java.util.Stack;

import Arithmetic.Arithmetics;

public class Calculator extends Arithmetics {

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calculator(input));
        scanner.close();
    }

    private boolean isNumber(String input) {
        if (input == null) {
            return false;
        }
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    public double calculator(String input) {
        String[] inputString = input.split(" ");
        Stack <Double> stack = new Stack<>();

        for (int i = inputString.length - 1; i > 0 ; --i) {
            double x;
            double y;
            if (isNumber(inputString[i])) {
                stack.push(Double.parseDouble(inputString[i]));
            } else if (inputString[i].equals("+")) {
                x = stack.pop();
                y = stack.pop();
                stack.push(add(x, y));
            } else if (inputString[i].equals("-")) {
                x = stack.pop();
                y = stack.pop();
                stack.push(sub(x, y));
            } else if (inputString[i].equals("*")) {
                x = stack.pop();
                y = stack.pop();
                stack.push(mult(x, y));
            } else if (inputString[i].equals("/")) {
                x = stack.pop();
                y = stack.pop();
                stack.push(div(x, y));
            } else if (inputString[i].equals("log")) {
                x = stack.pop();
                y = stack.pop();
                stack.push(log(x, y));
            } else if (inputString[i].equals("pow")) {
                x = stack.pop();
                y = stack.pop();
                stack.push(pow(x, y));
            } else if (inputString[i].equals("sqrt")) {
                x = stack.pop();
                stack.push(sqrt(x));
            } else if (inputString[i].equals("sin")) {
                x = stack.pop();
                stack.push(sin(x));
            } else if (inputString[i].equals("cos")) {
                x = stack.pop();
                stack.push(cos(x));
            } else {
                System.out.println("Invalid syntax");
            }
        }
        return stack.pop();
    }

}

