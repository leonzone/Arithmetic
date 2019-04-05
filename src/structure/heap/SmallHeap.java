package structure.heap;

/**
 * @author: reiserx
 * Date:2019/4/2
 * Des: 小顶堆
 */
public class SmallHeap {
    private int[] a;
    private int n;
    private int count;


    public SmallHeap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int v) {
        if (count >= n) {
            return;
        }
        ++count;
        a[count] = v;
        int i = count;
        //堆化处理
        while (i / 2 > 0 && a[i / 2] > a[i]) {
            swap(a, i / 2, i);
            i = i / 2;
        }
    }

    public void delTop() {
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        a[count] = 0;
        --count;
        //从上往下堆化
        heapify(a, n, 1);
    }

    //从上往下堆化
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] > a[i * 2] && a[i * 2] != 0) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] > a[i * 2 + 1] && a[i * 2 + 1] != 0) {
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

    public void printAll() {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        SmallHeap heap = new SmallHeap(7);
        heap.insert(78);
        heap.insert(39);
        heap.insert(21);
        heap.insert(36);
        heap.insert(30);
        heap.printAll();
        heap.insert(11);
        heap.printAll();
        heap.delTop();
        heap.printAll();
        heap.delTop();
        heap.printAll();
////        PriorityQueue
//        PriorityQueue<E>
    }
}
