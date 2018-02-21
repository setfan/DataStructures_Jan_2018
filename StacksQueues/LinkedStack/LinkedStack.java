package LinkedStack;


public class LinkedStack<E> {

    private Node firstElement;
    private int size;

    public LinkedStack() {
        this.firstElement = null;

        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void push(E item) {
        Node newNode = new Node(item);

        if (this.size == 0) {
            this.firstElement = newNode;
        } else {
            newNode.next = this.firstElement;
            this.firstElement = newNode;
        }
        this.size++;
    }

    public E pop() {
        if (this.size == 0) {
            throw new  IllegalArgumentException("The collection is empty.");
        }

        E elem = this.firstElement.value;

        this.firstElement = this.firstElement.next;

        this.size--;

        return elem;
    }

    private class Node {
        private E value;
        private Node next;

        Node(E value) {
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] array = (E[]) new Object[this.size];
        Node currentElement = this.firstElement;
        for (int i = 0; i < this.size; i++) {
            array[i] = currentElement.value;
            currentElement = currentElement.next;
        }
        return array;
    }
}
