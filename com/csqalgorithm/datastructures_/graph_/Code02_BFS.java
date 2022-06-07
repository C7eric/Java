package Java.com.csqalgorithm.datastructures_.graph_;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code02_BFS {

    /**
     *  从 node 开始 ，进行 广度 / 宽度 优先遍历
     */
    public static void bfs(Node start) {
        if (start == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
