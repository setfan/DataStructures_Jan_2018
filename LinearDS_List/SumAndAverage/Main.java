package SumAndAverage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        int sum = nums.stream()
                .flatMapToInt(IntStream::of)
                .sum();

        double average = nums.stream()
                .flatMapToInt(IntStream::of)
                .average().getAsDouble();

        System.out.println(String.format("Sum=%d; Average=%.2f", sum, average));

    }
}
