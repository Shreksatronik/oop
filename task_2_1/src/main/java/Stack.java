import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack - Класс, реализующий работу стека.
 *
 * @param <T> тип элементов.
 */

public class Stack<T> {


    private T[] stackArray;
    private int size = 0;
    private int capacity;


    public Stack() {
        stackArray = (T[]) new Object[10];
    }


    /**
     * Метод, который помещает элемент в стек.
     *
     * @param element элемент, который нам нужно положить в стек.
     */
    public void push(T element) {
        if (this.size >= stackArray.length) {
            int newSize = size + (size >> 1);
            stackArray = Arrays.copyOf(stackArray, newSize);
        }
        stackArray[size++] = element;
    }

    /**
     * Метод, который получает элемент из стека.
     *
     * @return элемент стека, если он существует, в противном случае выдает исключение.
     * @throws IndexOutOfBoundsException выдает это исключение, если стек пуст.
     */
    public T pop() throws Exception {
        if (size <= 0) {
            Exception e;
            throw e = new IndexOutOfBoundsException("Stack is empty");
        } else {
            T element = stackArray[--size];

            int reducedSize = size;
            if (size >= stackArray.length && size < (reducedSize + (reducedSize << 1))) {
                System.arraycopy(stackArray, 0, stackArray, 0, size);
            }
            return element;
        }
    }

    /**
     *
     * @param arr - стек который мы хотим добавить
     */
    public void pushStack(Stack arr) throws Exception {
        int n = arr.count();
        if (n == stackArray.length) {
            stackArray = Arrays.copyOf(stackArray, 2 * stackArray.length);
        }
        T[] buf=(T[]) new Object[n];
        for(int i=0;i<n;i++){
            buf[i]=(T) arr.pop();
        }
        for (int i = 0; i < n; i++) {
            this.push(buf[n-i-1]);
        }
    }

    /**
     *
     * @param n - размер стека который мы хотим удалить
     * @return - возвращает стек
     */
    public Stack popStack(int n) throws Exception {
        if (size < 0) {
            Exception e;
            throw e = new IndexOutOfBoundsException("Stack is empty");
        }
        if(size-n<0){
            Exception e;
            throw e = new IndexOutOfBoundsException("Stack is empty");
        }
        int a = size - n;
        Stack<T> sstack = new Stack();
        for(int i = 0; i<n;i++) {
            sstack.push(this.stackArray[a+i+1]);
            this.pop();
        }
        return sstack;
    }


    /**
     * Метод, который получает количество элементов в стеке.
     *
     *
     * @return количество запушенных элементов в стеке.
     */
    public int count() {
        return size;
    }
}