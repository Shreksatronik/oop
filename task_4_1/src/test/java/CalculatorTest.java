import Arithmetic.Arithmetics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest extends Arithmetics{

    @Test
    public void sub_Test() {
        double x = 1678.2;
        double y = 212.244;
        double result = x - y;
        Assertions.assertEquals(result, sub(x, y));
    }

    @Test
    public void mult_Test() {
        double x = 738.23;
        double y = 934.3;
        double result = x * y;
        Assertions.assertEquals(result, mult(x, y));
    }
    @Test
    public void sqrt_Test() {
        double x = 225.0;
        double result = 15.0;
        Assertions.assertEquals(result, sqrt(x));
    }

    @Test
    public void add_Test() {
        double x = 13.1;
        double y = 17.52;
        double result = x + y;
        Assertions.assertEquals(result, add(x, y));
    }

    @Test
    public void log_Test() {
        double x = 5.0;
        double y = 125.0;
        double result = 3.0;
        Assertions.assertEquals(result, log(x, y), 0.00001);
    }

    @Test
    public void pow_Test() {
        double x = 2.0;
        double y = 6.0;
        double result = 64.0;
        Assertions.assertEquals(result, pow(x, y));
    }


    @Test
    public void cos_Test() {
        double x = 1.0;
        double result = 0.5403023059;
        Assertions.assertEquals(result, cos(x), 0.000000001);
    }

    @Test
    public void sin_Test() {
        double x = 1.0;
        double result = 0.8414709848;
        Assertions.assertEquals(result, sin(x), 0.000000001);
    }
    @Test
    public void div_Test() {
        double x = 9874.2;
        double y = 223.1;
        double result = x / y;
        Assertions.assertEquals(result, div(x, y));
    }
    @Test
    public void calculator_Test(){
        Calculator calculator = new Calculator();
        String input = "sin + - 1 2 1";
        double result = 0.0;
        Assertions.assertEquals(result, calculator.calculator(input), 0.0001);
    }
}

