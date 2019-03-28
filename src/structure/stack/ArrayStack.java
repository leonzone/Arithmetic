package structure.stack;

/**
 * @author: reiserx
 * Date:2019/3/28
 * Des: 顺序栈（数组实现的栈）
 */
public class ArrayStack {
    private String[] items;
    private int size;
    private int count;

    public ArrayStack(int size) {
        this.size = size;
        this.items = new String[size];
        this.count = 0;
    }


    public void push(String item) {
        if (count >= items.length) {
            return;
        }
        items[count] = item;
        count++;

    }

    public String pop() {
        if (count <= 0) {
            return null;
        }
        return items[count--];
    }


}
