package Java.com.csqalgorithm.datastructures_.binarytree_;

public class Code01_RecursiveTraversalBinaryTree {
    public static class Node {

        public int value;
        public Node left;
        public Node right;        public Node(int value) {
            this.value = value;
        }
    }

    public static void f(Node head){
        if(head == null){
            return;
        }
        // 1
        f(head.left);
        // 2
        f(head.right);
        // 3
    }


    /**
     *  先序打印所有节点
     * @param head  二叉树 head 节点
     */
    public static void prePrintNodes(Node head){
        if(head == null){
            return;
        }

        System.out.println(head.value);
        prePrintNodes(head.left);
        prePrintNodes(head.right);
    }

    /**
     *  中序打印所有节点
     * @param head 二叉树 head 节点
     */
    public static void inPrintNodes(Node head){
        if(head == null){
            return;
        }

        inPrintNodes(head.left);
        System.out.println(head.value);
        inPrintNodes(head.right);
    }

    /**
     *  后序打印所有节点
     * @param head 二叉树 head 节点
     */
    public static void posPrintNodes(Node head){
        if(head == null){
            return;
        }

        posPrintNodes(head.left);
        posPrintNodes(head.right);
        System.out.println(head.value);
    }
}
