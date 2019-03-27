package arithmetic.sort;

/**
 * Created by reiserx on 2017/12/21.
 * the  arirhmetic of quick arithmetic.sort
 */
public class QuickSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {

        if (lo >= hi) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);

    }

    private int partition(Comparable[] a, int p, int r) {
        Comparable pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (less(a[j], pivot)) {
                exch(a, i, j);
                i++;
            }
        }
        exch(a, i, r);
        System.out.println("i=" + i);
        return i;
    }
}



