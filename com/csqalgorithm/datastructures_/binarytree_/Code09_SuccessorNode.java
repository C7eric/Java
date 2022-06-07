package Java.com.csqalgorithm.datastructures_.binarytree_;

public class Code09_SuccessorNode {
    public static class Node{

        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getSuccessorNode(Node node){
        if(node == null){
            return node;
        }
        if(node.right != null){
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.right == node) {
                node = parent;
                parent = node.parent;
            }
            return node;
        }
    }

    public static Node getLeftMost(Node node){
        if (node == null) {
            return node;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
