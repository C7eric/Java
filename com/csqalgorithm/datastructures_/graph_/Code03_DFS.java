package Java.com.csqalgorithm.datastructures_.graph_;

import java.util.HashSet;
import java.util.Stack;

public class Code03_DFS {
    public static void dfs(Node start){
        if (start == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        HashSet<Node> set = new HashSet<>();
        stack.add(start);
        set.add(start);
        System.out.println(start.value);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            for(Node next : cur.nexts){
                if(!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
