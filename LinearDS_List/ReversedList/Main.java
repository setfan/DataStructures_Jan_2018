package ReversedList;

public class Main {
    public static void main(String[] args) {


        ReversedList<Integer> myList = new ReversedList<>();

        for (int i = 1; i <= 10; i++) {
            myList.add(i);

        }


        System.out.println(myList.get(9));
        System.out.println();
        myList.forEach(System.out::println);


    }
}
