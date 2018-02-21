package LinkedQueue;


import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedQueue <E> implements Iterable<E>{

    private Node head;
    private Node tail;
    private int size;

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public void enqueue(E element) {
        if (this.size == 0){
            this.head = this.tail = new Node(element);
        } else {
            Node newTail = new Node(element);
          this.tail.next = newTail;
            this.tail = newTail;
        }
        this.size++;
    }

    public E dequeue() {
        if (this.size == 0){
            throw new IllegalArgumentException("List is empty.");
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

    public int size() {
        return this.size;
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
    @SuppressWarnings("unchecked")
    public void forEach(Consumer<? super E> action) {
        Node current = this.head;

        while (current != null){
            E e = (E) current.getValue();
            action.accept(e);
            current = current.next;
        }
    }


    @SuppressWarnings("unchecked")
    public E[] toArray() {
        Node<E> currentNode = head;
        E[] array = (E[]) new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            array[i] = currentNode.value;
            currentNode = currentNode.next;
        }
        return array;
    }
}
