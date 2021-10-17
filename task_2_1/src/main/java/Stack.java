import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *Класс, реализующий работу стека.
 *
 * @param <T> тип элементов.
 */

public class Stack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] stackArray;
    private int size = 0;
    private int capacity;


    public Stack() {
        this.capacity = DEFAULT_CAPACITY;
        stackArray = (T[]) new Object[DEFAULT_CAPACITY];
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
    public T pop() throws IndexOutOfBoundsException {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        } else {
            T element = stackArray[--size];
            stackArray[size] = null;

            int reducedSize = size;
            if (size >= capacity && size < (reducedSize + (reducedSize << 1))) {
                System.arraycopy(stackArray, 0, stackArray, 0, size);
            }
            return element;
        }
    }

    /**
     *Реализация итератора для стека.
     *
     * @return следующий элемент стека.
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;

            public boolean hasNext() {
                return !(position == size);
            }

            public T next() throws NoSuchElementException {
                return stackArray[position++];
            }
        };
    }


    /**
     * Проверяет, пуст ли стек.
     *
     * @return 1 - если стек пуст, иначе возвращает 0.
     */
    public boolean isEmpty() {
        return size == 0;
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