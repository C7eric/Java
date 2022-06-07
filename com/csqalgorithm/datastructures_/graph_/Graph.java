package Java.com.csqalgorithm.datastructures_.graph_;

import java.util.HashMap;
import java.util.HashSet;

/**
 *  图的结构描述
 */
public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<Integer,Node>();
        edges = new HashSet<Edge>();
    }
}
