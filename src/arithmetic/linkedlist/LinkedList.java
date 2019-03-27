package arithmetic.linkedlist;

import structure.linkedlist.ListNode;

public class LinkedList {

    /**
     * 反转链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

    /**
     * 检测环
     */
    public  boolean hasCycle(ListNode list) {
        if (list == null) return false;

        ListNode fast = list.next;
        ListNode slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }

    /**
     * 合并两个有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode watcher = new ListNode(0);
        ListNode node = watcher;

        while (true) {

            if (l1 == null) {
                watcher.next = l2;
                break;
            }
            if (l2 == null) {
                watcher.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                watcher.next = l1;
                l1 = l1.next;
            } else {
                watcher.next = l2;
                l2 = l2.next;
            }
            watcher = watcher.next;

        }

        return node.next;

    }


    /**
     * 返回链表的倒数第 n 个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode afterPreN = head;
        while (n-- != 0) {
            afterPreN = afterPreN.next;
        }
        if (afterPreN != null) {
            while (afterPreN.next != null) {
                pre = pre.next;
                afterPreN = afterPreN.next;
            }
            pre.next = pre.next.next;
        } else {
            head = head.next;
        }
        return head;
    }

    /**
     * 返回链表的中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast.next==null){
            slow = slow.next;
        }
        return slow;

    }


    /**
     * 创建测试数据
     *
     * @param data [XX,XX,XX]
     * @return {@link ListNode}
     */
    public static ListNode createTestData(String data) {
        if (data.equals("[]")) return null;
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        int len = split.length;
        ListNode[] listNode = new ListNode[len + 1];
        listNode[0] = new ListNode(Integer.valueOf(split[0]));
        for (int i = 1; i < len; i++) {
            listNode[i] = new ListNode(Integer.valueOf(split[i]));
            listNode[i - 1].next = listNode[i];
        }
        return listNode[0];
    }

    public static void print(ListNode listNode) {
        if (listNode == null) {
            System.out.println("null");
            return;
        }
        StringBuilder str = new StringBuilder("[" + String.valueOf(listNode.val));
        ListNode p = listNode.next;
        while (p != null) {
            str.append(",").append(String.valueOf(p.val));
            p = p.next;
        }
        System.out.println(str.append("]"));

    }

}