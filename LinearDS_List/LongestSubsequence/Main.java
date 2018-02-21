package LongestSubsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        int startIndex = 0;
        int sequenceLenght = 1;

        int bestStartIndex = 0;
        int bestSequenceLenght = 0;

        for (int i = 1; i < nums.size(); i++)
        {
            if (nums.get(i) == nums.get(i - 1))
            {
                sequenceLenght++;
                if (sequenceLenght > bestSequenceLenght)
                {
                    bestStartIndex = startIndex;
                    bestSequenceLenght = sequenceLenght;
                }
            }
            else
            {
                startIndex = i;
                sequenceLenght = 1;
            }
        }
        for (int i = bestStartIndex; i < bestStartIndex + bestSequenceLenght; i++)
        {
            System.out.print(nums.get(i) + " ");
        }
        System.out.println();
    }
}
