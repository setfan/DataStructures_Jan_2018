import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(Node node) {
        this.copy(node);
    }

    private void copy(Node node) {
        if(node == null){
            return;
        }

        this.insert(node.value);
        this.copy(node.left);
        this.copy(node.right);
    }

    public Node getRoot() {
        return this.root;
    }

    public void insert(T value) {
        if (this.root == null) {
            this.root = new Node(value);
            return;
        }
        Node parent = null;
        Node current = this.root;

        while (current != null){

            int compare = current.value.compareTo(value);

            if (compare > 0){
                parent = current;
                current = current.left;
            } else if (compare < 0){
                parent = current;
                current = current.right;

            } else {
                return;
            }
        }

        Node newNoed = new Node(value);
        if (parent.value.compareTo(value) > 0){
            parent.left = newNoed;
        } else {
            parent.right = newNoed;
        }
    }

    public boolean contains(T value) {
        Node current = this.root;

        while (current != null){
            if (value.compareTo(current.value) < 0){
                current = current.left;
            } else if (value.compareTo(current.value) > 0){
                current = current.right;
            } else {
                break;
            }
        }
        return current != null;
    }

    public BinarySearchTree<T> search(T item) {
        Node current = this.root;

        while (current != null){
            if (item.compareTo(current.value) < 0) {
                current = current.left;
            } else if (item.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                break;
            }
        }
        return new BinarySearchTree<>(current);
    }

    public void eachInOrder(Consumer<T> consumer) {

        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node node, Consumer<T> consumer){
        if (node == null){
            return;
        }

        this.eachInOrder(node.left, consumer);
        consumer.accept(node.value);
        this.eachInOrder(node.right, consumer);

    }

    public Iterable<T> range(T from, T to) {
        Deque<T> queue = new LinkedList<>();
        this.range(this.root, queue, from, to);
        return queue;
    }

    private void range(Node node, Deque<T> queue, T startRange, T endRange) {
        if (node == null) {
            return;
        }
        int compareStart = startRange.compareTo(node.value);
        int compareEnd = endRange.compareTo(node.value);
        if (compareStart < 0) {
            this.range(node.left, queue, startRange, endRange);
        }
        if (compareStart <= 0 && compareEnd >= 0) {
            queue.addLast(node.value);
        }
        if (compareEnd > 0) {
            this.range(node.right, queue, startRange, endRange);
        }
    }

    class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}

