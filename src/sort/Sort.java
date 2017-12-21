package sort;

/**
 * Created by reiserx on 2017/12/21.
 * sort superclass
 */
public abstract class Sort {

    public abstract void sort(Comparable[] a);

    public void show(Comparable[] a) {
        for (Comparable i : a) {
            System.out.print(i + "");
        }
    }

    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private boolean isSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }
}
