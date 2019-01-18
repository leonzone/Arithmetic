package arithmetic.sort;

/**
 * Created by reiserx on 2017/12/21.
 * test of arithmetic.sort
 */
public class SortTest {

    public static void main(String[] args) {
        String[] s = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
//        Sort arithmetic.sort = new MergeSort();
//        Sort arithmetic.sort = new QuickSort();
//        Sort arithmetic.sort = new ShellSort();
//        Sort arithmetic.sort = new InsertSort();
//        Sort arithmetic.sort = new ChooseSort();
        Sort sort = new BubbleSort();
        System.out.println("--------before arithmetic.sort-----------");
        sort.show(s);
        sort.sort(s);
        System.out.println("--------after  arithmetic.sort-----------");
        sort.show(s);
    }
}
