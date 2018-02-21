package SequenceWithQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        queue.add(n);
        List<Integer> nums = new ArrayList<>();
        nums.add(n);


        while (nums.size() <= 50){
            int current = queue.poll();
            queue.add(current+1);
            queue.add((2*current) +1);
            queue.add(current+2);
            nums.add(current+1);
            nums.add((2*current) +1);
            nums.add(current+2);
        }

        for (int i = 0; i < 50; i++) {
            System.out.print(nums.get(i));

            if (i != 49){
                System.out.print(", ");
            }

        }


    }
}
