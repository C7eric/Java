package Java.com.csqalgorithm.datastructures_.linkedlist;

/*
给你单链表的头指针 head
和两个整数 left 和 right
其中left <= right
请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */




public class Code03_ReverseBetween {

    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
        public  Node reverseBetween(Node head,int left,int right) {
            Node dummyNode = new Node(-1);
            dummyNode.next = head;

            Node pre = dummyNode;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }

            Node rightNode = pre;
            for (int i = 0; i < right -1 ; i++) {
                rightNode = rightNode.next;
            }

            Node leftNode = pre.next;
            Node curr = rightNode.next;

            pre.next = null;
            rightNode.next = null;

            reverseLinkedList(leftNode);

            pre.next = rightNode;
            leftNode.next = curr;
            return dummyNode.next;
        }

        private void reverseLinkedList(Node head){

            Node pre = null;
            Node cur = head;

            while(cur != null){
                Node next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
        }
}


}
