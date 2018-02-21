package arrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            myList.add(i);

        }

        myList.forEach(System.out::println);


    }
}
