package arithmetic.sort;

/**
 * Created by reiserx on 2018/10/25.
 * 排序
 */
public class Sorts {


    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean swap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }


    /**
     * 插入排序
     */
    public void insertionSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 选择排序
     */
    public void selectionSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i + 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }

            }
            if (a[minIndex] < a[i]) {
                int tmp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = tmp;
            }
        }


    }


    /**
     * 并归排序：先分组、合并时排序
     */
    public void mergeSort(int[] a) {
        mergeSortInternally(a, 0, a.length - 1);
    }

    private void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = p + (r - p) / 2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = a[start++];
        }

        for (i = 0; i <= r - p; ++i) {
            a[p + i] = tmp[i];
        }
    }


    /**
     * 快速排序
     */
    public void quickSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        quick_sort_c(a, 0, n - 1);
    }

    public void quick_sort_c(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);
        quick_sort_c(a, p, q - 1);
        quick_sort_c(a, q + 1, r);
    }

    private int partition(int[] a, int p, int r) {
        int pivot = a[r];

        int i = p;
        for (int j = p; j < r; j++) {
            //类似与选择排序，把小于 pivot 的都放置到左边
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        if (i < r) {
            a[r] = a[i];
            a[i] = pivot;
        }

        return i;
    }


    public void printAll(int[] items) {

        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + ",");
        }
        System.out.println();
        System.out.println("-----------------");
    }


    public static void main(String[] args) {

        Sorts sorts = new Sorts();
        int[] items = new int[]{1, 2, 3, 4, 9, 4, 5};
        sorts.mergeSort(items);
        sorts.printAll(items);

        int[] items2 = new int[]{4, 5, 6, 3, 2, 1};
        sorts.bubbleSort(items2);
        sorts.printAll(items2);


        int[] items3 = new int[]{4, 5, 6, 2, 3, 1};
        sorts.insertionSort(items3);
        sorts.printAll(items3);

        int[] items4 = new int[]{4, 5, 6, 2, 3, 1};
        sorts.selectionSort(items4);
        sorts.printAll(items4);

        int[] items5 = new int[]{4, 5, 6, 2, 3, 1, 9, 1, 0, 4};
        sorts.quickSort(items5);
        sorts.printAll(items5);
    }
}
