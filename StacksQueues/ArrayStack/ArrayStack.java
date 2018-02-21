package ArrayStack;

import java.util.Arrays;
import java.util.LinkedList;

public class ArrayStack<E> {
    private static final int INITIAL_CAPACITY = 16;
    private E[] elements;
    private int size;

    public ArrayStack(int capacity) {
        this.elements = (E[]) new Object[capacity];
        this.size = 0;

    }

    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    public int size() {
        return this.size;
    }

    public void push(E element) {
        if (this.size >= this.elements.length) {
            this.grow();
        }

        this.elements[this.size++] = element;
    }
    public E pop() {
        int index = this.size-1;
        if (this.size == 0){
            throw new IllegalArgumentException("Stack is empty.");
        }
        E item = this.elements[index];

        this.elements[index] = null;

        if (this.size + 1 < this.elements.length / 3) {
            this.sizeDown();
        }

        this.size--;
        return item;

    }

    private void sizeDown() {
        E[] newCollection = Arrays.copyOf(elements, elements.length / 2);

        elements = newCollection;
    }

    @SuppressWarnings("unckecked")
    public E[] toArray() {
        E[] result = (E[]) new Object[this.elements.length*2];
        for (int i = 0; i < this.size; i++) {
            result[i] = this.elements[this.size-1-i];

        }

        return result;
    }


    private void grow() {
        E[] newCollection = Arrays.copyOf(elements, elements.length * 2);

        this.elements = newCollection;
    }


}
