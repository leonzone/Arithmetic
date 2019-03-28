package structure.linkedlist;

/**
 * @author: reiserx
 * Date:2019/3/27
 * Des:循环单向链表
 */
public class CycleSinglyLinkedList {

    private ListNode head = null;

    public void insertToHead(int value) {
        if (head == null) {
            head = new ListNode(value);
            head.next = head;
            return;
        }

        ListNode newNode = new ListNode(value);
        ListNode q = head;
        while (q.next != head) {
            q = q.next;
        }

        q.next = newNode;
        newNode.next = head;
        head = newNode;

    }

    public void insertTail(int value) {
        if (head == null) {
            head = new ListNode(value);
            head.next = head;
            return;
        }
        ListNode newNode = new ListNode(value);
        ListNode q = head;
        while (q.next != head) {
            q = q.next;
        }

        newNode.next = head;
        q.next = newNode;
    }
}
