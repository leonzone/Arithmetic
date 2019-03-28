package structure.linkedlist;

/**
 * @author: reiserx
 * Date:2019/3/27
 * Des: 双向链表
 */
public class DoubleLinkedList {

    private ListNode head = null;

    public void insertToHead(int value) {

        ListNode newNode = new ListNode(value);
        //空链表，可以插入新节点作为head，也可以不操作
        if (head == null) {
            head = newNode;

        } else {
            ListNode q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
            newNode.last = q;
        }

    }

    public void insertTail(int value) {

        ListNode newNode = new ListNode(value);
        //空链表，可以插入新节点作为head，也可以不操作
        if (head == null) {
            head = newNode;

        } else {
            ListNode q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
            newNode.last = q;
        }

    }


    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode last;

        public ListNode(int x) {
            val = x;
            next = null;
            last = null;
        }

        @Override
        public boolean equals(Object obj) {
            return val == ((ListNode) obj).val;
        }

        @Override
        public int hashCode() {
            return super.hashCode() + val;
        }
    }

}



