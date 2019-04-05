package arithmetic.heap;

/**
 * @author: reiserx
 * Date:2019/4/4
 * Des:求一组动态数据集合的最大 Top K
 */
public class TopK {


    private int[] a;
    private int n;
    private int count;


    public TopK(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void add(int v) {
        if (count >= n) {
            poll();
            add(v);
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

    private int poll() {
        if (count == 0) {
            return -1;
        }
        int value = a[1];
        a[1] = a[count];
        a[count] = 0;
        --count;
        //从上往下堆化
        heapify(a, n, 1);
        return value;
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

    /**
     * 遍历
     */
    public void printAll() {
        for (int i = 1; i < a.length; i++) {
            System.out.print(poll() + ",");
        }
    }

    private void swap(int[] a, int top, int leaf) {
        int tmp = a[top];
        a[top] = a[leaf];
        a[leaf] = tmp;
    }

    public static void main(String[] args) {
        TopK topK = new TopK(5);
        int[] a = {33, 44, 11, 5, 1, 123, 56, 77, 88, 1, 8, 9, 100};
        for (int i = 0; i < a.length; i++) {
            topK.add(a[i]);
        }
        topK.printAll();
    }
}
