package Java.com.csqalgorithm.datastructures_.graph_;

import java.util.*;


public class Code05_Kruskal {

    // Union-Find Set
    public static class UnionFind {

        private static HashMap<Node, Node> fatherMap;

        private static HashMap<Node, Integer> sizeMap;

        public UnionFind() {

            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
        }

        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node findFather(Node n) {
            Stack<Node> path = new Stack<>();
            while (fatherMap.get(n) != n) {
                path.add(n);
                n = fatherMap.get(n);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), n);
            }
            return n;
        }

        public boolean isSameSet1(Node from, Node to) {
            return findFather(from) == findFather(to);
        }

//        public void union2(Node from, Node to){
//            List<Node> fromSet = fatherMap.get(from);
//            List<Node> toSet = fatherMap.get(to);
//        }
        public void union(Node from, Node to) {
            if (from == null || to == null) {
                return;
            }
            Node aDai = findFather(from);
            Node bDai = findFather(to);
            if (aDai != bDai) {
                int aSetSize = sizeMap.get(aDai);
                int bSetSize = sizeMap.get(bDai);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aDai, bDai);
                    sizeMap.put(bDai, aSetSize + bSetSize);
                    sizeMap.remove(aDai);
                } else {
                    fatherMap.put(bDai, aDai);
                    sizeMap.put(aDai, aSetSize + bSetSize);
                    sizeMap.remove(bDai);
                }
            }
        }
    }
    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> kruskalMST(Graph graph) {

        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for(Edge edge : graph.edges){
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if(!unionFind.isSameSet1(edge.from,edge.to)){
                result.add(edge);
                unionFind.union(edge.from,edge.to);
            }
        }
        return result;
    }
}
