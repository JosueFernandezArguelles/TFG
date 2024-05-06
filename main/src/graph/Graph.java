package graph;

import util.Checker;

import java.util.*;

public class Graph {

    private Map<Node, List<Link>> graph;

    public Graph(){
        this.graph = new HashMap<>();
    }

    public void addNode(Node node){
        graph.put(node, new ArrayList<>());
    }

    public void addLink(Node start, Node end, int value){
        Checker.checkIsInGraph(start, this.graph);
        Checker.checkIsInGraph(end, this.graph);
        graph.get(start).add(new Link(start, end, value));
        //Añadir enlace en la otra dirección al ser un grafo no dirigido
        graph.get(end).add(new Link(end, start, value));
    }

    public List<Link> getLinks(Node node){
        Checker.checkIsInGraph(node, graph);
        return graph.get(node);
    }

    public Graph generateRandomGraph(){
        int nodes = new Random().nextInt(10,30);
        generateRandomNodes(nodes);
        generateRandomLinks(nodes);
        return this;
    }

    private void generateRandomLinks(int nodes) {
    }

    private void generateRandomNodes(int nodes){
        for (int i = 0; i < nodes; i++ ){
            addNode(new Node(i));
        }
    }
}