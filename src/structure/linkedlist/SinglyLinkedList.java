package structure.linkedlist;

/**
 * @author: reiserx
 * Date:2019/3/27
 * Des: 单向链表
 */
public class SinglyLinkedList {

    private ListNode head = null;

    public ListNode findByValue(int value) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        while (true) {
            node = node.next;
            if (node == null) {
                break;
            }
            if (node.val == value) {
                return node;
            }
        }

        return null;
    }

    public ListNode findByIndex(int index) {
        if (head == null) {
            return null;
        }
        int i = 0;
        ListNode node = new ListNode(-1);
        node.next = head;
        while (true) {

            node = node.next;
            if (node == null) {
                break;
            }
            if (i == index) {
                return node;
            }
            i++;
        }
        return null;

    }

    public void insertToHead(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    //顺序插入
    //链表尾部插入
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
        }
    }

    public void insertAfter(ListNode p, int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(ListNode p, int value) {
        ListNode newNode = new ListNode(value);

        if (p == null) {
            return;
        }
        if (head == p) {
            insertToHead(value);
            return;
        }

        ListNode q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;

    }

    public void delNode(int value) {

        if (head == null) {
            return;
        }

        ListNode p = head;
        ListNode q = null;
        while (p != null && p.val != value) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return;
        }

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }


    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.insertTail(1);
        linkedList.insertTail(3);
        linkedList.insertTail(5);
        linkedList.insertTail(7);
    }
}
