package util;

import graph.Link;
import graph.Node;

import java.util.List;
import java.util.Map;

public class Checker {

    /**
     * Comprueba si un nodo está en el grafo.
     * @param node
     * @param graph
     */
    public static void checkIsInGraph(Node node, Map<Node, List<Link>> graph) {
        if( !graph.containsKey(node) ){
            throw new IllegalArgumentException(String.format("ERROR: Node %s is not in the graph", node));
        }
    }

    /**
     * Comprueba si existe un link entre dos nodos.
     * @param start
     * @param end
     * @return
     */
    public static boolean existsLink(Node start, Node end, Map<Node, List<Link>> graph){
        for(Link l : graph.get(start)){
            if( l.equals(start, end) ){
                return true;
            }
        }
        return false;
    }
}
