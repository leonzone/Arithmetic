package arithmetic.sorts;

/**
 * Created by reiserx on 2018/10/25.
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 4, 5, 1, 9, 20, 13, 16};
        Sorts sorts = new Sorts();
        sorts.insertSort(arr);
//        arithmetic.sorts.bubbleSort(arr);
        print(arr);

    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
