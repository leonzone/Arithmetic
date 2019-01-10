package queue;

/**
 * Author: reiserx
 * Date:2019/1/9
 * Des:链式队列
 */
public class LinkedlistQueue {

    private ListNode container;
    private ListNode head;
    private ListNode tail;

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public LinkedlistQueue() {

    }

    public void enqueue(int value) {
        ListNode newNode = new ListNode(value);
        if (container == null) {
            container = newNode;
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public int dequeue() {
        int value = head.val;
        head = head.next;
        return value;
    }

    public static void main(String[] args) {
        LinkedlistQueue queue = new LinkedlistQueue();
        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(7);
        System.out.print(queue.dequeue() + "-->");
        System.out.print(queue.dequeue() + "-->");
        System.out.print(queue.dequeue());

    }
}
