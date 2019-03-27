package structure.array;

/**
 * Author: reiserx
 * Date:2019/3/27
 * Des: Dynamic expansion Array 支持动态扩容的数组
 *
 */
public class DEArray {
    private int size = 10;
    private int[] container;
    private int index;


    public DEArray() {
        this.container = new int[size];
        this.index = -1;
    }


    public void add(int i) {
        index++;
        if (index >= container.length) {
            container = expanArray(container);
        }
        container[index] = i;

    }

    private int[] expanArray(int[] container) {
        size *= 2;
        int[] newContainer = new int[size];
        for (int i = 0; i < container.length; i++) {
            newContainer[i] = container[i];
        }
        return newContainer;
    }

    public static void main(String[] args) {
        DEArray array = new DEArray();
        for (int i = 0; i < 20; i++) {
            array.add(i);
        }
    }

}
