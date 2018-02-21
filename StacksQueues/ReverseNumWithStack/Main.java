package ReverseNumWithStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> numStack = new ArrayDeque<>();


        for (int item : nums) {
            numStack.push(item);
        }

        while (!numStack.isEmpty()) {
            System.out.print(numStack.pop() + " ");
        }

    }
}
