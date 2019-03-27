package structure.linkedlist;

/**
 * @author: reiserxu
 * Date:2019/1/18
 * Des: 单向链表
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
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
