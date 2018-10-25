package sort;

/**
 * Created by reiserx on 2017/12/21.
 * the  arirhmetic of quick sort
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
        sort(a, j+1, hi);

    }

    private int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo ;
        int j = hi+1;
        while (true) {
            //samller
            while (less(a[++i],v)){
                if(i==hi){
                    break;
                }
            }
            //bigger
            while (less(v,a[--j])){
                if(j==lo){
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;

    }
}
