package util;

import graph.Link;
import graph.Node;

import java.util.List;
import java.util.Map;

public class Checker {

    public static void checkIsInGraph(Node node, Map<Node, List<Link>> graph) {
        if( !graph.containsKey(node) ){
            throw new IllegalArgumentException(String.format("ERROR: Node %s is not in the graph", node));
        }
    }
}
