package structure.heap;

/**
 * @author: reiserx
 * Date:2019/4/2
 * Des: 大顶堆
 */
public class BigHeap {

    private int[] a;
    private int n;
    private int count;


    public BigHeap(int capacity) {
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
        while (i / 2 > 0 && a[i / 2] < a[i]) {
            swap(a,  i,i/2);
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

    public void printAll() {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        BigHeap heap = new BigHeap(7);
//        heap.insert(78);
//        heap.insert(39);
//        heap.insert(21);
//        heap.insert(36);
//        heap.insert(30);
//        heap.insert(99);
        heap.insert(3);
        heap.insert(5);
        heap.insert(1);
        heap.insert(8);
        heap.insert(15);
        heap.insert(6);
        heap.printAll();
//        heap.delTop();
//        heap.printAll();
//        heap.delTop();
//        heap.printAll();
//        PriorityQueue
//        PriorityQueue<E>
    }


}
