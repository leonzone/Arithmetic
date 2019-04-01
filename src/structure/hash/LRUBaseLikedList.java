package structure.hash;


/**
 * @author: reiserx
 * Date:2019/4/1
 * Des:最近最少使用策略 LRU（Least Recently Used)
 * 当查询到某个元素时，将它放到链表的末尾
 * 当插入某个元素时。如果存在更新后放到链表末尾、如果不存在直接放入链表末尾。
 */
public class LRUBaseLikedList {


    private ListNode head = null;
    private int capitity = 10;
    private ListNode[] bucket;


    public LRUBaseLikedList() {
        bucket = new ListNode[capitity];
    }

    int hash(Object key) {
        int h = key.hashCode();
        //capicity 表示散列表的大小
        return (h ^ (h >>> 16)) & (capitity - 1);
    }

    public void insertTail(int value) {
        ListNode newNode = new ListNode(value);

        int index = hash(newNode);
        System.out.println("index is " + index);
        ListNode oldNode = bucket[index];

        //旧的不存在，直接补上
        if (oldNode == null) {
            bucket[index] = newNode;
        } else {
            // 添加到尾部或者更新数据
            while (oldNode.hnext != null && (!oldNode.equals(newNode))) {
                oldNode = oldNode.hnext;
            }
            if (oldNode.equals(newNode)) {
                //将值放入到尾部
                moveToTail(oldNode);
                return;
            } else {
                oldNode.hnext = newNode;
            }
        }

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

    private ListNode select(int i) {
        ListNode newNode = new ListNode(i);
        int index = hash(newNode);
        ListNode node = bucket[index];
        if (node != null) {
            while (node != null) {
                if (node.equals(newNode)) {
                    moveToTail(node);
                    return node;
                }
                node = node.hnext;
            }
        }

        return null;
    }

    private void moveToTail(ListNode node) {
        ListNode tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }
        if (node.next == null) {
            return;
        }

        if (node.last == null) {
            head = node.next;
            node.next.last = null;
        } else {
            node.last.next = node.next;
            node.next.last = node.last;
        }

        node.next = null;
        tailNode.next = node;
        node.last = tailNode;

    }


    private void printAll() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println();
    }

    public void removeHead() {
        if (head != null) {
            head = head.next;
        }
    }

    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode last;
        public ListNode hnext;

        public ListNode(int x) {
            val = x;
            next = null;
            last = null;
            hnext = null;
        }

        @Override
        public boolean equals(Object obj) {
            return val == ((ListNode) obj).val;
        }

        @Override
        public int hashCode() {
            return val;
        }
    }

    public static void main(String[] args) {
        LRUBaseLikedList list = new LRUBaseLikedList();
        list.insertTail(3);
        list.insertTail(1);
        list.insertTail(5);
        list.insertTail(2);
        list.insertTail(3);
        list.select(5);
        list.printAll();
    }


}
