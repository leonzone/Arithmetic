package sort;

/**
 * Created by reiserx on 2017/12/21.
 * the arithmetic of shell sort
 */
public class ShellSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j-=h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
