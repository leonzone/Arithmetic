package structure.hash;

/**
 * @author: reiserx
 * Date:2019/4/1
 * Des:基于链表法解决冲突问题的散列表
 * 1、初始大小
 * 2、装载因子和动态扩容
 * 3、散列冲突解决方法
 * 4、散列函数
 */
public class HashBaseLikedList {

    private int capitity = 0;
    private float loadFactor = 0.75f;
    private int count = 0;
    private ListNode[] bucket;

    public HashBaseLikedList(int size) {
        this.capitity = size;
        bucket = new ListNode[size];
    }


    public void add(String val) {

        if (count >= capitity * loadFactor) {
            rehash();
        }

        ListNode newNode = new ListNode(val);
        int index = hash(newNode);
        ListNode oldNode = bucket[index];

        //旧的不存在，直接补上
        if (oldNode == null) {
            bucket[index] = newNode;
            count++;
        } else {
            // 添加到尾部或者更新数据
            while (oldNode.next != null && (!oldNode.equals(newNode))) {
                oldNode = oldNode.next;
            }
            if (oldNode.equals(newNode)) {
                System.out.println("update same node");
            } else {
                oldNode.next = newNode;
                count++;
            }
        }


    }


    /**
     * 动态扩容
     */
    private void rehash() {
        capitity = capitity * 2;
        System.out.println("count is " + count);
        ListNode[] newBucket = new ListNode[capitity];


        for (ListNode node : bucket) {
//            遍历每一个节点
            while (node != null) {
                int newIndex = hash(node);
                ListNode newIndexNode = newBucket[newIndex];
                if (newIndexNode == null) {
                    newBucket[newIndex] = node;
                } else {
                    while (newIndexNode.next != null) {
                        newIndexNode = newIndexNode.next;
                    }
                    newIndexNode.next = node;
                }
                ListNode tmp = node;
                node = node.next;
                tmp.next = null;
            }
        }
        bucket = newBucket;
    }


    int hash(Object key) {
        int h = key.hashCode();
        //capicity 表示散列表的大小
        return (h ^ (h >>> 16)) & (capitity - 1);
    }


    public class ListNode {

        public String val;
        public ListNode next;

        public ListNode(String x) {
            val = x;
            next = null;
        }

        @Override
        public boolean equals(Object obj) {
            return val.equals(((ListNode) obj).val);
        }

        @Override
        public int hashCode() {
            return val.hashCode();
        }

    }

    public static void main(String[] args) {
        HashBaseLikedList hashTable = new HashBaseLikedList(2);
        hashTable.add("qq");
        hashTable.add("aa");
        hashTable.add("mm");
        hashTable.add("qa");
        hashTable.add("qa3");
        hashTable.add("qa4");
        hashTable.add("aa");

        System.out.println(hashTable);
    }

}
