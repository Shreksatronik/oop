import java.util.Scanner;

import java.util.Stack;

import Arithmetic.Arithmetics;

public class Calculator extends Arithmetics {

    /**
     * проверка является ли числом
     * @param input - строка
     * @return - true/false
     */
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

    /**
     * pop
     * @param stack
     * @return
     * @throws Exception
     */
    private double protectedPop(Stack<Double> stack) throws Exception {
        try {
            return stack.pop();
        } catch (Exception e) {
            throw new Exception("Empty stack");
        }
    }

    /**
     * калькулятор выполняющий простые арифметические функции
     * @param input
     * @return
     * @throws Exception
     */
    public double calculator(String input) throws Exception {
        String[] inputString = input.split(" ");
        Stack<Double> stack = new Stack<>();

        for (int i = inputString.length - 1; i > 0; --i) {
            double x;
            double y;
            if (isNumber(inputString[i])) {
                stack.push(Double.parseDouble(inputString[i]));
            } else {
                switch (inputString[i]) {
                    case "+":
                        x = protectedPop(stack);
                        y = protectedPop(stack);
                        stack.push(add(x, y));
                        break;
                    case "-":
                        x = protectedPop(stack);
                        y = protectedPop(stack);
                        stack.push(sub(x, y));
                        break;
                    case "*":
                        x = protectedPop(stack);
                        y = protectedPop(stack);
                        stack.push(mult(x, y));
                        break;
                    case "/":
                        x = protectedPop(stack);
                        y = protectedPop(stack);
                        if (y != 0)
                            stack.push(div(x, y));
                        break;
                    case "log":
                        x = protectedPop(stack);
                        if (x > 0)
                            stack.push(log(x));
                        break;
                    case "pow":
                        x = protectedPop(stack);
                        y = protectedPop(stack);
                        stack.push(pow(x, y));
                        break;
                    case "sqrt":
                        x = protectedPop(stack);
                        if (x >= 0)
                            stack.push(sqrt(x));
                        break;
                    case "sin":
                        x = protectedPop(stack);
                        stack.push(sin(x));
                        break;
                    case "cos":
                        x = protectedPop(stack);
                        stack.push(cos(x));
                        break;
                }
            }


        }
        return stack.pop();
    }
}


