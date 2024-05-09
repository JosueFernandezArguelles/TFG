package algorithms;

import graph.Graph;
import graph.Link;
import graph.Node;

import java.util.ArrayList;
import java.util.List;

public class ApproximationAlgorithm {

    private Graph graph;
    private List<Node> visited = new ArrayList<>();
    private int totalDistance = 0;

    public ApproximationAlgorithm(Graph g){
        this.graph = g;
    }

    public void TSPApproximation(){
        List<Node> nodes = graph.getNodes();

        Node current = nodes.get(0);

        while(visited.size() != nodes.size()){
            int distance = Integer.MAX_VALUE;
            Node next = null;
            for( Link l : graph.getLinks(current)){
                if( !visited.contains( l.getEnd() ) && l.getValue() < distance){
                    next = l.getEnd();
                    distance = l.getValue();
                }
            }
            if(next == null){
                System.out.println("No se puede hacer el recorrido completo");
                break;
            }
            visited.add(next);
            current = next;
            totalDistance += distance;
        }
    }

    public void result(){
        System.out.println(visited);
        System.out.println("Distancia total: " + totalDistance);
    }
}
