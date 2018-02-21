package ArrayStack;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 1; i <= 10; i++) {
            stack.push(i);

        }

        Integer[] arry = stack.toArray();

        for (int i = 1; i <= 7; i++) {
            stack.pop();

        }

        System.out.println(Arrays.toString(arry));
    }
}
