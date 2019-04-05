package arithmetic.heap;

import structure.heap.PriorityQueueBaseHeap;

/**
 * @author: reiserx
 * Date:2019/4/4
 * Des:合并多个有序数组
 */
public class CombinMultiSortArray {

    public void combin(int[]... arrays) {

        int[] sizes = new int[arrays.length];
        PriorityQueueBaseHeap heap = new PriorityQueueBaseHeap(5);
        while (true) {
            boolean flag = false;
            for (int i = 0; i < arrays.length; i++) {
                int[] a = arrays[i];
                int index = sizes[i];
                if (index < a.length) {
                    addValueToQueue(heap, a[index]);
                    flag = true;
                    sizes[i]++;
                }
            }

            if (!flag) {
                break;
            }
        }
        heap.printAll();
    }


    private void addValueToQueue(PriorityQueueBaseHeap heap, int value) {
        if (!heap.add(value)) {
            heap.printAll();
            heap.clean();
            heap.add(value);
        }
    }

    public static void main(String[] args) {
        int[] a = {33, 44, 55, 66, 77, 88, 99, 100};
        int[] b = {31, 41, 51, 61, 71, 81, 91, 101};
        int[] c = {39, 49, 59, 69, 79, 89, 99, 109, 118};

        CombinMultiSortArray combiner = new CombinMultiSortArray();
        combiner.combin(a, b, c);
    }


}
