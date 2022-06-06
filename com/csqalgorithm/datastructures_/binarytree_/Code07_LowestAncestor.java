package Java.com.csqalgorithm.datastructures_.binarytree_;

public class Code07_LowestAncestor {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Node lowestAncestor1(Node head,Node o1,Node o2){
        if(head == null || head == o1 || head == o2){
            return head;
        }

        Node left = lowestAncestor1(head.left, o1, o2);
        Node right = lowestAncestor1(head.right, o1, o2);

        if(left != null && right != null){
            return head;
        }
        return left != null  ? left : right;
    }

    public static Node lowestAncestor2(Node head,Node a,Node b){
        return process(head,a,b).ans;
    }

    public static class Info{
        public boolean findA;
        public boolean findB;
        public Node ans;

        public Info(boolean findA, boolean findB, Node ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }

    public static Info process(Node x,Node a,Node b){
        if(x == null){
            return new Info(false,false,null);
        }

        Info leftInfo = process(x.left,a,b);
        Info rightInfo = process(x.right,a,b);

        boolean findA = (x == a) || leftInfo.findA || rightInfo.findA;
        boolean findB = (x == b) || leftInfo.findB || rightInfo.findB;
        Node ans = null;
        if(leftInfo.ans != null){
            ans = leftInfo.ans;
        } else if(rightInfo.ans != null){
            ans = rightInfo.ans;
        } else {
            if (findA && findB) {
                ans = x;
                }
            }
        return new Info(findA,findB,ans);
    }
}
