package Java.com.csqalgorithm.datastructures_.binarytree_;

public class Code05_IsBalanced {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBalanced1(Node head) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process(head,ans);
        return ans[0];
    }

    public static int process(Node head,boolean[] ans) {
        if(!ans[0] || head == null){
            return -1;
        }
        int leftHeight = process(head.left, ans);
        int rightHeight = process(head.right, ans);

        if(Math.abs(leftHeight - rightHeight) > 1){
            ans[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalanced2(Node head){
        return process(head).isBalance;
    }

    public static class Info{
        public int height;
        public boolean isBalance;

        public Info(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public static Info process(Node head){
        if(head == null){
            return new Info(0,true);
        }

        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalance = true;
        if(!leftInfo.isBalance){
            isBalance = false;
        }
        if(!rightInfo.isBalance){
            isBalance = false;
        }
        if(Math.abs(leftInfo.height - rightInfo.height) > 1){
            isBalance = false;
        }
        return new Info(height,isBalance);
    }
}
