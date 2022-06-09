package Java.com.csqalgorithm.datastructures_.graph_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *  非并查集方法解决最小生成树
 */
public class Code07_Kruskal2 {

    public static class mySets{

        public static HashMap<Node, List<Node>> setMap;

        public mySets(List<Node> nodes){
            for(Node cur : nodes) {
                List<Node> set = new ArrayList<Node>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        public static boolean isSameSet(Node from,Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public static void union(Node from,Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for(Node toNode : toSet){
                fromSet.add(toNode);
                setMap.put(toNode,fromSet);
            }
        }

    }
    public static Set<Edge> kruskalMST2(Graph graph) {

    }
}
