package SortWords;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> words = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));

        words.sort(String::compareTo);

        words.forEach(a -> System.out.print(a + " "));
    }
}
