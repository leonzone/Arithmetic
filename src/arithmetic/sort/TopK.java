package arithmetic.sort;

/**
 * @author: reiserx
 * Date:2019/3/29
 * Des:找到第 K 大元素
 */
public class TopK {

    public int find(int[] a, int top, int p, int r) {

        int q = partition(a, p, r);
        if (q == top) {
            return a[q];
        } else if (q > top) {
            return find(a, top, p, q - 1);
        } else {
            return find(a, top, q + 1, r);
        }
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


    public static void main(String[] args) {
        TopK topK = new TopK();
        System.out.println(topK.find(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 3}, 5, 0, 8));
    }


}
