import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestStack {
    @Test
    void empty_test() throws Exception{
        Stack s=new Stack();
        Exception e = assertThrows(Exception.class, () -> {Integer a = (Integer) s.pop();});
        assertEquals(e.getMessage(),"Stack is empty");
        Exception e1 = assertThrows(Exception.class, () -> {
            Stack a =  s.popStack(3);
        });
        assertEquals(e1.getMessage(),"Stack is empty");
    }
    void pop_stack_test() throws Exception{
        Stack<Integer> s=new Stack();
        s.push(1);
        Exception e = assertThrows(Exception.class, () -> {
            Stack a =  s.popStack(3);
        });
        assertEquals(e.getMessage(),"Stack is empty");
    }
    @Test
    void working_with_Integer_test() throws Exception {
        Stack<Integer> s=new Stack();
        s.push((Integer)1);
        s.push((Integer)2);
        s.push((Integer)3);
        Integer x= (Integer) s.pop();
        assert (x==3);
        x=s.pop();
        assert(x==2);
        x=s.pop();
        assert(x==1);
    }

    @Test
    void working_with_String_test() throws Exception {
        Stack<String> s=new Stack();
        s.push((String)"1");
        s.push((String)"2");
        s.push((String)"3");
        String x= (String) s.pop();
        assert (x=="3");
        x=s.pop();
        assert(x=="2");
        x=s.pop();
        assert (x == "1");

    }

}