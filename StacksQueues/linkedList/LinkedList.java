package linkedList;

import java.security.InvalidParameterException;
import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.setSize(0);
    }

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    @SuppressWarnings("unchecked")
    public void addFirst(E item) {
        Node newNode = new Node(item);
        if (this.size == 0) {

            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }

        this.size++;
    }

    public void addLast(E item) {
        Node newNode = new Node(item);

        if (this.size == 0) {
            this.tail = newNode;
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public E removeFirst() {
        if (this.size == 0) {
            throw new InvalidParameterException("The collection is empty.");
        }

        E elem = this.head.value;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }

        this.size--;

        return elem;
    }

    public E removeLast() {
        if (this.size == 0) {
            throw new InvalidParameterException("The collection is empty.");
        }

        E elem = this.tail.value;

        if (this.size == 1) {
            this.head = null;
            this.tail = null;

        }

        Node parent = this.head;

        if (parent != null) {
            while (parent.next != this.tail) {

                parent = parent.next;
            }
        }

        if (parent != null) {
            parent.next = null;
        }
        this.tail = parent;

        this.size--;

        return elem;
    }


    private class Node {
        private E value;
        private Node next;

        Node(E value) {
            this.setValue(value);
        }

        public E getValue() {
            return value;
        }

        void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node currentNode = head;
            @Override
            public boolean hasNext() {
                return this.currentNode != null;
            }
            @Override
            public E next() {
                E element = this.currentNode.getValue();
                this.currentNode = this.currentNode.getNext();
                return element;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (E t : this) {
            result.append(t).append(" ");
        }

        return result.toString().trim();
    }

}
