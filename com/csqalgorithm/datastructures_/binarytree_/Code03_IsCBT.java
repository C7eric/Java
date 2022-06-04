package Java.com.csqalgorithm.datastructures_.binarytree_;

import java.util.LinkedList;

public class Code03_IsCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

        public boolean isCBT1(Node head) {
            if (head == null) {
                return true;
            }

            LinkedList<Node> queue = new LinkedList<>();
            boolean leaf = false;
            Node left = null;
            Node right = null;
            queue.add(head);
            while (!queue.isEmpty()) {
                head = queue.poll();
                left = head.left;
                right = head.right;
                if (
                        (leaf && (left != null || right != null))
                                ||
                                (left == null && right == null)
                ) {
                        return false;
                }
                if(left != null){
                    queue.add(left);
                }
                if(right != null){
                    queue.add(right);
                }
                if(left == null || right == null){
                    leaf = true;
                }
            }
            return true;
        }

        public static boolean isCBT2(Node head){
            if(head == null){
                return true;
            }
            return process(head).isCBT;
        }

        public static class Info{
            public boolean isFull;
            public boolean isCBT;
            public int height;

            public Info(boolean full,boolean cbt,int h){

                isFull = full;
                isCBT = cbt;
                height = h;
            }
        }

        public static Info process(Node x){
            if(x == null){
                return new Info(true,true,0);
            }

            Info leftInfo = process(x.left);
            Info rightInfo = process(x.right);

            int height = Math.max(leftInfo.height,rightInfo.height) + 1;

            boolean isFull = leftInfo.isFull
                    && rightInfo.isFull
                    && leftInfo.height == rightInfo.height;

            boolean isCBT = false;

            if(isFull){
                isCBT = true;
            } else {
                if(leftInfo.isCBT && rightInfo.isCBT){

                    if(leftInfo.isCBT
                            && rightInfo.isFull
                            && leftInfo.height == rightInfo.height + 1){
                        isCBT = true;
                    }
                    if(leftInfo.isFull
                            && rightInfo.isFull
                            && leftInfo.height == rightInfo.height + 1){
                        isCBT = true;
                    }
                    if(leftInfo.isFull
                           && rightInfo.isCBT
                           && leftInfo.height == rightInfo.height ){
                        isCBT = true;
                    }
                }
            }
            return new Info(isFull,isCBT,height);
        }
    }



