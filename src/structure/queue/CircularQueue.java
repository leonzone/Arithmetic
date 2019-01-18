package structure.queue;

/**
 * Author: reiserx
 * Date:2019/1/9
 * Des:循环队列
 */
public class CircularQueue {

    private String[] container;
    private int size = 0;
    private int head = 0;
    private int tail = 0;


    public CircularQueue(int size) {
        this.size = size;
        container = new String[size];
    }


    //入队
    public void enqueue(String value) {
        //判断队列已满
        if ((tail + 1) % size == head) {
            return;
        }
        container[tail] = value;
        tail = (tail + 1) % size;

    }

    //出队
    public String dequeue() {
        //判断队列空了
        if (head == tail) {
            return null;
        }
        String value = container[head];
        head = (head + 1) % size;
        return value;
    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue("5");
        queue.enqueue("2");
        queue.enqueue("8");
        queue.enqueue("0");
        System.out.print(queue.dequeue() + "-->");
        System.out.print(queue.dequeue() + "-->");
        System.out.print(queue.dequeue() + "-->");
        System.out.print(queue.dequeue());

    }
}
