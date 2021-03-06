package Java.com.csqalgorithm.datastructures_.linkedlist;

public class Code02_FindFirstIntersectNode {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public static Node getIntersectNode(Node head1,Node head2){

            if(head1 == null || head2 == null){
                return null;
            }
            Node loop1 = getLoopNode(head1);
            Node loop2 = getLoopNode(head2);
            if(loop1 == null && loop2 == null){
                return noLoop(head1,head2);
            }
            if(loop1 != null && loop2 != null){
                return bothLoop(head1,loop1,head2,loop2);
            }
            return null;
        }
    }

    /**
     * 找到链表第一个入环节点，如果无环返回 null
     * @param head 链表头节点
     * @return 第一个入环节点
     */
    public static Node getLoopNode(Node head){

        if(head == null || head.next == null || head.next.next == null){
            return null;
        }

        // n1 慢  n2 快
        Node slow = head.next;
        Node fast = head.next.next;
        while(slow != fast){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow fast 相遇
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 如果两个链表都无环，返回第一个相交节点
     *  如果不相交，返回 null
     * @param head1 链表 1 头节点
     * @param head2 链表 2 头节点
     * @return 两个链表第一个相交节点
     */
    public static Node noLoop(Node head1,Node head2) {
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while(cur1.next != null){
            n++;
            cur1 = cur1.next;
        }
        while(cur2.next != null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }

        // n 表示 链表长度 1 减去 链表长度 2 的值
        cur1 = n > 0 ? head1 :head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while(n != 0){
            n--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


    /**
     *  两个有环链表，返回第一个相交节点
     *   如果不相交，返回 null
     * @param head1 第一个链表  头结点
     * @param loop1  第一个链表入环节点
     * @param head2 第二个链表 头节点
     * @param loop2   第二个链表 入环节点
     * @return
     */
    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while(cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while(n != 0){
                n--;
                cur1 = cur1.next;
            }
            while(cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while(cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }

    }
}
