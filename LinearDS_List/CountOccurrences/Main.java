package CountOccurrences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        nums.sort(Comparator.naturalOrder());

        List<Integer> items = nums.stream()
                .distinct()
                .collect(Collectors.toList());


        for (Integer num : items) {

            int occurance = 0;

            for (Integer item : nums) {
                if (item.equals(num)) {
                    occurance++;
                }
            }

            System.out.println(String.format("%s -> %s times", num, occurance));

        }
    }
}
