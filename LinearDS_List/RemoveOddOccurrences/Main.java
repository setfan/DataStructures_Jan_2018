package RemoveOddOccurrences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        List<Integer> nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        List<Integer> itemsToremove = new ArrayList<>();
        int numToRemove = 0;

        for (int i = 0; i < nums.size(); i++) {
            int tmp = nums.get(i);
            int occurances = 0;

            for (Integer num : nums) {
                if (num == tmp){
                    occurances++;
                }
            }

            if (occurances % 2 != 0){
                itemsToremove.add(tmp);

            }

        }

        for (Integer item : itemsToremove) {
            while (nums.contains(item)){
                nums.remove(item);
            }
        }

        System.out.println(String.join(" ", nums.toString().replaceAll("[\\[\\],]", "")));
    }
}
