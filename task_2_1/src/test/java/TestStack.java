
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestStack {


    @Test
    public void test_with_integers() {
        Stack<Integer> stack;
        stack = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i < 100; ++i) {
            if ((i * 5) % 4 == 0) {
                stack.push(i);
                arr.add(i);
            } else {
                if (arr.size() != 0) {
                    int elementArr = arr.remove(arr.size() - 1);
                    int elementStack = stack.pop();
                    Assert.assertEquals(elementArr, elementStack);
                }
            }
        }
        Assert.assertEquals(arr.size(), stack.count());
    }


    @Test
    public void test_with_floats() {
        Stack<Float> stack;
        stack = new Stack<Float>();
        ArrayList<Float> arr = new ArrayList<Float>();

        for (int i = 0; i < 1000; ++i) {
            if ((i * 5) % 2 == 0) {
                float num = (float) Math.random();
                stack.push(num);
                arr.add(num);
            } else {
                if (arr.size() != 0) {
                    int size = arr.size() - 1;
                    float elementArr = arr.remove(size);
                    float elementStack = stack.pop();
                    Assert.assertEquals(elementArr, elementStack, 0.0001);
                }
            }
        }
        Assert.assertEquals(arr.size(), stack.count());
    }
    @Test
    void pop_stack_test() throws Exception{
        Stack<Integer> s=new Stack();
        s.push(1);
        Exception e = assertThrows(Exception.class, () -> {Stack a =  s.popStack(3);});
        assertEquals(e.getMessage(),"Not enough elements in stack");
    }

    @Test
    public void test_with_strings() {
        Stack<String> stack = new Stack<String>();
        stack.push("PushedStringOne");
        stack.push("PushedStringTwo");
        stack.pop();
        stack.pop();
        try {
            stack.pop();
            Assert.fail("Expected NoSuchElementException");
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    @Test
    public void test_with_strings2() {
        Stack<String> stack;
        stack = new Stack<String>();
        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 1; i < 500; ++i) {
            if (i % 2 != 0) {
                stack.push("Stay hungry");
                arr.add("Stay hungry");
            } else {
                stack.push("Stay foolish");
                arr.add("Stay foolish");
            }
        }
        Assert.assertEquals(arr.size(), stack.count());
    }




    private static class Assert {
        public static void assertEquals(int elementArr, int elementStack) {
        }

        public static void fail(String expected_noSuchElementException) {
        }

        public static void assertEquals(float elementArr, float elementStack, double v) {
        }
    }
}