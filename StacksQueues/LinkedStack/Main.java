package LinkedStack;

public class Main {
    public static void main(String[] args) {

        LinkedStack<Integer> stack = new LinkedStack<Integer>();

        for (int i = 1; i <= 10; i++) {
            stack.push(i);

        }

        Integer[] arr = stack.toArray();

        for (Integer integer : arr) {
            System.out.println(integer);
        }

    }
}
