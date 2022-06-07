package Java.com.csqalgorithm.datastructures_.graph_;

import java.util.*;

public class Code04_TopologySort {

    // direct graph no loop
    public static List<Node> sortedTopology(Graph graph) {

        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();

        /**
         * public Collection<V> values() {
         *         Collection<V> vs = values;
         *         if (vs == null) {
         *             vs = new Values();
         *             values = vs;
         *         }
         *         return vs;
         *     }
         */

        for(Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for(Node next : cur.nexts){

                /**
                 *  HashMap.get(e);  @return  e.value / null
                 * public V get(Object key) {
                 *         Node<K,V> e;
                 *         return (e = getNode(key)) == null ? null : e.value;
                 *     }
                 */
                inMap.put(next,inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
