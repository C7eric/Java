package Java.com.csqalgorithm.datastructures_.binarytree_;

public class Code06_IsFull {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isFull(Node head) {
        if (head == null) {
            return false;
        }
        Info1 all = process1(head);
        return (1 << all.height) - 1 == all.nodes;
    }

    public static class Info1 {
        public int height;
        public int nodes;

        public Info1(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static Info1 process1(Node head) {
        if (head == null) {
            return new Info1(0, 0);
        }
        Info1 leftInfo = process1(head.left);
        Info1 rightInfo = process1(head.right);

        int height = Math.max(leftInfo.height, rightInfo.height);
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info1(height, nodes);
    }

    public static boolean isFull2(Node head) {
        if (head == null) {
            return false;
        }
        return process2(head).isFull;
    }

    public static class Info2 {
        public int height;
        public boolean isFull;

        public Info2(int height, boolean isFull) {
            this.height = height;
            this.isFull = isFull;
        }
    }

    public static Info2 process2(Node x) {
        if (x == null) {
            return new Info2(0, true);
        }
        Info2 leftInfo = process2(x.left);
        Info2 rightInfo = process2(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height);
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        return new Info2(height, isFull);
    }
}
