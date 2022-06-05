package Java.com.csqalgorithm.datastructures_.binarytree_;

import java.util.ArrayList;

public class Code04_IsBST {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBST(Node head){
        if(head == null){
            return true;
        }
        ArrayList<Node> res = new ArrayList<>();
        process(head, res);
        for (int i = 0; i < res.size(); i++) {
            if(res.get(i).value <= res.get(i - 1).value){
                return false;
            }
        }
        return true;
    }

    public static void process(Node head, ArrayList<Node> res){
        if(head == null){
            return;
        }
        process(head.left,res);
        res.add(head);
        process(head.right,res);
    }


    public static boolean isBST2(Node head){
        if(head == null){
            return true;
        }
        return process(head).isBST;
    }

    public static class Info{

        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static Info process(Node x){
        if(x == null) {
            return null;
        }
            Info leftInfo = process(x.left);
            Info rightInfo = process(x.right);

            int  max = x.value;
            if(leftInfo != null){
                max = Math.max(max, leftInfo.max);
            }
            if(rightInfo != null){
                max = Math.max(max, rightInfo.max);
            }
            int min = x.value;
            if(leftInfo != null){
                min = Math.min(min, leftInfo.min);
            }
            if(rightInfo != null){
                min = Math.min(min, rightInfo.min);
            }

            boolean isBST = true;
            if(leftInfo != null && !leftInfo.isBST){
                isBST = false;
            }
            if(rightInfo != null && !rightInfo.isBST){
                isBST = false;
            }
            if(leftInfo != null && leftInfo.max < x.value){
                isBST = false;
            }
            if(rightInfo != null && rightInfo.min > x.value){
                isBST = false;
            }
            return new Info(isBST,max,min);
        }
}
