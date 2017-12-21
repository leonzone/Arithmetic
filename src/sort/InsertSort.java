package sort;

/**
 * Created by reiserx on 2017/12/21.
 * the arithmetic of inser sort
 */
public class InsertSort extends Sort {
    @Override
    public void sort(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j >0&&less(a[j],a[j-1]) ; j--) {
                exch(a,j,j-1);
            }
        }
    }
}
