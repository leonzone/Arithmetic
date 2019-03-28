package structure.stack;

import structure.linkedlist.ListNode;

/**
 * @author: reiserx
 * Date:2019/3/28
 * Des:链式栈
 */
public class LinkedListStack {
    ListNode top = null;

    public void push(int item) {
        ListNode newNode = new ListNode(item);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null) {
            return -1;
        } else {
            ListNode node = top;
            top = top.next;
            return node.val;
        }
    }
}
