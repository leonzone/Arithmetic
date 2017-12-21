package sort;

/**
 * Created by reiserx on 2017/12/21.
 * 希尔排序
 */
public class ShellSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        int N = 1;
        while (N < a.length / 3) {
            N = N * 3 + 1;
        }

        while (N >= 1) {
            for (int i = 0; i < a.length; i++) {
                for (int j = i; j > N - 1 && less(a[j], a[j - N]); j--) {
                    exch(a, j, j - N);
                }
            }
            N = N / 3;
        }
    }
}
