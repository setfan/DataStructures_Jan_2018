package CircularQueue;

import java.security.InvalidParameterException;

public class CircularQueue<E> {
    private static final int DEFAULT_CAPACITY = 4;

    private int size;
    private E[] elements;
    private int startIndex;
    private int endIndex;

    @SuppressWarnings("unchecked")
    public CircularQueue(int initialCapacity) {
        this.elements = (E[]) new Object[initialCapacity];
        this.startIndex = 0;
        this.endIndex = 0;

    }

    public CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return this.size;
    }

    private  void setSize(int size) {
        this.size = size;
    }

    public void enqueue(E element) {
        if (this.size >= this.elements.length){
            this.grow();
        }

        this.elements[this.endIndex] = element;
        this.endIndex = (this.endIndex + 1) % this.elements.length;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        E[] newCollection = (E[]) new Object[this.size * 2];

        this.copyAllElements(newCollection);
        this.elements = newCollection;
        this.startIndex = 0;
        this.endIndex = this.size;
    }

    private void copyAllElements(E[] newCollection) {
        for (int i = 0; i < this.size; i++) {
            int index = (i + this.startIndex) % this.elements.length;
            newCollection[i] = this.elements[index];

        }
    }

    public E dequeue() {
        if (this.size == 0){
            throw new InvalidParameterException("The queue is empty!");
        }
        E result = this.elements[startIndex];
        this.startIndex = (this.startIndex +1) % this.elements.length;
        this.size--;
        return result;

    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] newCollection = (E[]) new Object[this.size];

        this.copyAllElements(newCollection);

        return  newCollection;
    }

}
