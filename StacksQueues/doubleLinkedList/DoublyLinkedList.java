package doubleLinkedList;

import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedList<E> implements Iterable<E> {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.setSize();
    }

    public int size() {
        return this.size;
    }

    private void setSize() {
        this.size = 0;
    }


    @SuppressWarnings("unchecked")
    public void addFirst(E element) {
        if (this.size == 0){
            this.head = this.tail = new Node(element);
        } else {
            Node newHead = new Node(element);
            newHead.next = this.head;
            this.head.setPrevious(newHead);
            this.head = newHead;
        }
        this.size++;

    }

    @SuppressWarnings("unchecked")
    public void addLast(E element) {
        if (this.size == 0){
            this.head = this.tail = new Node(element);
        } else {
            Node newTail = new Node(element);
            newTail.previous = this.tail;
            this.tail.next = newTail;
            this.tail = newTail;
        }
        this.size++;
    }

    public E removeFirst() {
        if (this.size == 0){
            throw new InvalidParameterException("List is empty.");
        }
        E elemToRemove = (E) this.head.value;
        this.head = this.head.next;
        if (this.head != null){
            this.head.previous = null;
        } else {
            this.tail = null;
        }
        this.size--;
        return elemToRemove;
    }

    @SuppressWarnings("unchecked")
    public E removeLast() {
        if (this.size == 0){
            throw new InvalidParameterException("List is empty.");
        }
        E elemToRemove = (E) this.tail.value;
        this.tail = this.tail.getPrevious();
        if (this.tail != null){
            this.tail.next = null;
        } else {
            this.head = null;
        }
        this.size--;
        return elemToRemove;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] resultArray = (E[]) new Object[this.size];
        int index = 0;
        Node current = this.head;
        while (current != null){
            resultArray[index] = (E) current.value;
            current = current.getNext();
            index++;
        }

        return resultArray;
    }

    public class Node<E>{
        private E value;
        private Node next;
        private Node previous;

        Node(E value) {
            this.setValue(value);
            this.setNext(null);
            this.setPrevious(null);
        }

        public E getValue() {
            return this.value;
        }

        void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return this.next;
        }

        void setNext(Node next) {
            this.next = next;
        }

        Node getPrevious() {
            return this.previous;
        }

        void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> currentNode = head;
            @Override
            public boolean hasNext() {
                return this.currentNode != null;
            }

            @Override
            @SuppressWarnings("unchecked")
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

    @Override
    @SuppressWarnings("unchecked")
    public void forEach(Consumer<? super E> action) {
        Node current = this.head;

        while (current != null){
            E e = (E) current.getValue();
            action.accept(e);
            current = current.next;
        }
    }
}
