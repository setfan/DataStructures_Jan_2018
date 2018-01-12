package arrayList;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<T> implements Iterable<T>{
    private final String OUT_OF_BOUNDARY_EXCEPTION = "Index out of boundary %s.";
    private final int DEFAULT_CAPACITY = 2;
    private T[] items;
    private int size;
    private int count;

    public ArrayList(Class<T> type, int capacity) {

        this.initializeInnerCollection(capacity);
        this.size = capacity;
    }

    public ArrayList() {
        this.initializeInnerCollection(DEFAULT_CAPACITY);
        this.size = DEFAULT_CAPACITY;
    }

    @SuppressWarnings("unchecked")
    private void initializeInnerCollection(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be negative!");
        }

        items = (T[]) new Object[capacity];
    }


    public int getCount(){
        return this.count;
    }


    public T get(int index) {
        if (index < 0 || index > this.count) {
            throw new IllegalArgumentException(String.format(OUT_OF_BOUNDARY_EXCEPTION, index));
        }
        return this.items[index];
    }

    public void add(T element) {

        if (this.count + 1 >= this.size) {
            this.sizeUp();
        }

        this.items[count] = element;

        this.count++;
    }

    private void sizeUp() {
        T[] newCollection = Arrays.copyOf(items, items.length * 2);

        this.size *= 2;
        items = newCollection;
    }

    private void sizeDown() {
        T[] newCollection = Arrays.copyOf(items, items.length / 2);

        this.size /= 2;
        items = newCollection;
    }

    public T removeAt(int index) {
        T item = this.get(index);

        this.items[index] = null;

        this.shiftLeft(index);
        if (this.count + 1 < this.size / 3) {
            this.sizeDown();
        }

        this.count--;
        return item;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.count - 1; i++) {
            this.items[i] = this.items[i + 1];

        }
    }


    public void set(int index, T item) {

        if (index < 0 || index > this.count) {
            throw new IllegalArgumentException(String.format(OUT_OF_BOUNDARY_EXCEPTION, index));
        }

        this.items[index] = item;
    }

    @Override
    public Iterator<T> iterator() {
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<T> {
        int index;

        @Override
        public boolean hasNext() {

            return this.index < count;
        }

        @Override
        public T next() {
            return items[this.index++];
        }
    }
}
