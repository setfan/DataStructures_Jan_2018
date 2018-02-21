package ReversedList;

import java.util.Arrays;
import java.util.Iterator;

public class ReversedList<T> implements Iterable<T> {
    private static final String OUT_OF_BOUNDARY_EXCEPTION = "Index out of boundary %s.";
    private static final int DEFAULT_CAPACITY = 2;
    private T[] items;
    private int size;


    public ReversedList(int capacity) {

        this.initializeInnerCollection(capacity);
     this.size = 0;
    }

    public ReversedList() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    private void initializeInnerCollection(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be negative!");
        }

        items = (T[]) new Object[capacity];
    }

    public int count(){
        return this.size;
    }

    public int capacity(){
        return this.items.length;
    }

    @SuppressWarnings("unchecked")
    public void add(T element) {

        if (this.size + 1 >= this.items.length) {
            this.sizeUp();
        }

        this.items[size] = element;

        this.size++;
    }

    private void copyAllElements(T[] newCollection) {
        for (int i = 0; i < size; i++) {
            newCollection[i+1] = this.items[i];

        }
    }

    public T get(int index) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException(String.format(OUT_OF_BOUNDARY_EXCEPTION, index));
        }
        return this.items[this.size -1 -index];
    }

    public void set(int index, T item) {

        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException(String.format(OUT_OF_BOUNDARY_EXCEPTION, index));
        }

        this.items[index] = item;
    }


    public T removeAt(int index) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException(String.format(OUT_OF_BOUNDARY_EXCEPTION, index));
        }
        int reverceIndex = this.size -1 -index;

        T item = this.get(reverceIndex);

        this.items[reverceIndex] = null;

        this.shiftLeft(reverceIndex);
        this.size--;
        if (this.size < this.items.length / 2) {
            this.sizeDown();
        }

        return item;
    }

    private void sizeUp() {
        T[] newCollection = Arrays.copyOf(this.items, this.items.length * 2);

        this.items = newCollection;
    }

    private void sizeDown() {
        T[] newCollection = Arrays.copyOf(this.items, this.items.length / 2);

        this.items = newCollection;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.items[i] = this.items[i + 1];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<T> {
        int index = size-1;

        @Override
        public boolean hasNext() {

            return this.index >= 0;
        }

        @Override
        public T next() {
            return items[this.index--];
        }
    }
}
