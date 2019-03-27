package structure.array;

/**
 * Author: reiserx
 * Date:2019/3/27
 * Des: Dynamic Array 大小固定的有序数组，支持动态增删改操作
 */
public class DArray {

    private int[] container;
    private int i;

    DArray(int size) {
        container = new int[size];
        i = -1;
    }


    public void add(int value) {
        if (i >= container.length) {
            throw new IndexOutOfBoundsException();
        }
        i++;
        if (i == 0) {
            container[i] = value;
        } else {
            if (container[i - 1] <= value) {
                container[i] = value;
            } else {
                insertValueInOrder(container, value, i);
            }
        }
    }

    private void insertValueInOrder(int[] container, int value, int index) {
        for (int i = index - 1; i >= 0; i--) {
            int v = container[i];
            if (v > value) {
                container[i + 1] = v;
            } else {
                container[i + 1] = value;
            }

        }
    }

    public boolean del(int index) {
        if (index > i || i == 0) {
            return false;
        }
        for (int j = index + 1; j < container.length; j++) {
            container[j - 1] = container[j];
        }
        container[i] = 0;
        i--;
        return true;
    }

    public void update(int index, int value) {
        if (index > i) {
            container[i] = value;
        } else {
            add(value);
        }

    }

    public static void main(String[] args) {
        DArray array = new DArray(5);
        array.add(1);
        array.add(3);
        array.add(5);
        array.add(7);
        array.add(2);
        array.del(0);
        array.update(1, 9);

        System.out.println(array);
    }
}
