package structure.queue;

/**
 * Author: reiserx
 * Date:2019/1/9
 * Des:顺序队列
 */
public class ArrayQueue {

    private String[] container;
    private int size = 0;
    private int head = 0;
    private int tail = 0;


    public ArrayQueue(int size) {
        this.size = size;
        container = new String[size];
    }


    //入队
    public void enqueue(String value) {
        if (tail == size) {
            if (head == 0) {
                return;
            }
            for (int i = head; head < tail; i++) {
                container[i - head] = container[i];
            }
            tail -= head;
            head = 0;
        }
        container[tail] = value;
        ++tail;

    }

    //出队
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String value = container[head];
        ++head;
        return value;
    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue("5");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        System.out.print(queue.dequeue() + "-->");
        System.out.print(queue.dequeue() + "-->");
        System.out.print(queue.dequeue() + "-->");
        System.out.print(queue.dequeue());

    }
}
