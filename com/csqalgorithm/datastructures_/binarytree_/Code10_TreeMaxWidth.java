package Java.com.csqalgorithm.datastructures_.binarytree_;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Code10_TreeMaxWidth {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static int maxWidthUseMap(Node head) {
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node,Integer> levelMap = new HashMap<>();
        levelMap.put(head,1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = 0;
        while (!queue.isEmpty()) {

            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if(cur.left != null){
                levelMap.put(cur.left,curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right,curNodeLevel + 1);
                queue.add(cur.right);
            }
            if(curNodeLevel == curLevel){
                curLevelNodes++;
            } else {
                max = Math.max(max,curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max,curLevelNodes);
        return max;
    }

    public static int maxWidthNoMap(Node head){
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head;
        Node nextEnd = null;
        int max = 0;
        int curLevelNodes = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.left != null){
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if(cur.right != null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            if (cur == curEnd) {
                max = Math.max(max,curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }

    public static class levelOrder {
        public List<List<Integer>> levelOrder(Node head) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if(head == null){
                return res;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            while(!queue.isEmpty()){

                List<Integer> help = new ArrayList<>();
                int curLevelSizes = queue.size();
                for(int  i = 1;i <= curLevelSizes;++i){
                    Node cur = queue.poll();
                    help.add(cur.value);
                    if(cur.left != null){
                        queue.add(cur.left);
                    }
                    if(cur.right != null){
                        queue.add(cur.right);
                    }
                }
                res.add(help);
            }
            return res;
        }
    }
}
