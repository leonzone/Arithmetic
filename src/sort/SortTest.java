package sort;

/**
 * Created by reiserx on 2017/12/21.
 * test of sort
 */
public class SortTest {

    public static void main(String[] args) {
        String[] s = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
//        Sort sort = new MergeSort();
        Sort sort = new QuickSort();
//        Sort sort = new ShellSort();
//        Sort sort = new InsertSort();
//        Sort sort = new ChooseSort();
        System.out.println("--------before sort-----------");
        sort.show(s);
        sort.sort(s);
        System.out.println("");
        System.out.println("--------after  sort-----------");
        sort.show(s);
    }
}
