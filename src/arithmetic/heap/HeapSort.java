package arithmetic.heap;

/**
 * @author: reiserx
 * Date:2019/4/4
 * Des:堆排序
 */
public class HeapSort {
    public void sort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        heapify(a);
        sortHeap(a);
    }


    private void heapify(int[] a) {
        //堆化处理
        for (int i = 0; i < a.length; i++) {
            while (i / 2 > 0 && a[i / 2] < a[i]) {
                swap(a, i / 2, i);
                i = i / 2;
            }
        }
        printAll(a);

    }

    private void sortHeap(int[] a) {
        int count = a.length - 1;
        for (int i = 1; i < a.length - 1; i++) {
            int maxV = a[1];
            a[1] = a[count];
            a[count] = maxV;
            --count;
            //从上往下堆化
            heapify(a, count, 1);
            printAll(a);
        }
        printAll(a);

    }

    //从上往下堆化
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i == maxPos) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] a, int top, int leaf) {
        int tmp = a[top];
        a[top] = a[leaf];
        a[leaf] = tmp;
    }

    public void printAll(int[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //index 0 无用
        int[] items = {0, 3, 5, 1, 8, 15, 6};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(items);
    }
}
