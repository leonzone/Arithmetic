package structure.heap;

/**
 * @author: reiserx
 * Date:2019/4/4
 * Des:优先队列
 */
public class PriorityQueueBaseHeap {

    private int[] a;
    private int n;
    private int count;


    public PriorityQueueBaseHeap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public boolean add(int v) {
        if (count >= n) {
            return false;
        }
        ++count;
        a[count] = v;
        int i = count;
        //堆化处理
        while (i / 2 > 0 && a[i / 2] > a[i]) {
            swap(a, i / 2, i);
            i = i / 2;
        }
        return true;
    }

    public void poll() {
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
        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }

    public void clean() {
        a = new int[a.length];
        n = a.length - 1;
        count = 0;
    }


    public static void main(String[] args) {
//        PriorityQueueBaseHeap heap = new PriorityQueueBaseHeap(7);
//        heap.add(78);
//        heap.add(39);
//        heap.add(21);
//        heap.add(36);
//        heap.add(30);
//        heap.add(99);
//        heap.printAll();
//        heap.poll();
//        heap.printAll();
//        heap.poll();
//        heap.printAll();
    }



}
