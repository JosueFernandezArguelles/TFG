package algorithms;

import graph.Graph;
import graph.Link;
import graph.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BruteForce {

    private Graph graph;
    private List<Link> route = new ArrayList<>();
    private int totalDistance = 0;

    public BruteForce(Graph g){
        this.graph = g;
    }

    public void TSPBruteForce(){
        List<Map.Entry<Node, List<Link>>> entries = new ArrayList<>(graph.getGraph().entrySet());
        List<List<Map.Entry<Node, List<Link>>>> permutations = new ArrayList<>();
        permute(entries, 0, permutations);
        route = findShortestPath(permutations).get(0).getValue();
    }

    public void result(){
        System.out.println("Distancia total: " + totalDistance);
        System.out.println("Camino más corto: " + route);
    }

    public <T> void permute(List<Map.Entry<T, List<Link>>> entries, int start, List<List<Map.Entry<T, List<Link>>>> result) {
        if (start == entries.size() - 1) {
            result.add(new ArrayList<>(entries));
        } else {
            for (int i = start; i < entries.size(); i++) {
                Collections.swap(entries, i, start);
                permute(entries, start + 1, result);
                Collections.swap(entries, start, i);
            }
        }
    }

    /**
     * Calcula el valor de un determinado camino
     * @param path
     * @return
     */
    public int calculatePathWeight(List<Map.Entry<Node, List<Link>>> path) {
        int weight = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            Node currentNode = path.get(i).getKey();
            List<Link> links = path.get(i).getValue();
            Node nextNode = path.get(i + 1).getKey();
            for (Link link : links) {
                if (link.getEnd().equals(nextNode)) {
                    weight += link.getValue();
                    break;
                }
            }
        }
        weight += path.get(path.size() - 1).getValue().get(0).getValue();
        return weight;
    }

    /**
     * Calcula el camino más corto teniendo en cuenta todas las permutaciones
     * @param permutations
     * @return
     */
    public List<Map.Entry<Node, List<Link>>> findShortestPath(List<List<Map.Entry<Node, List<Link>>>> permutations) {
        List<Map.Entry<Node, List<Link>>> shortestPath = null;
        int shortestWeight = Integer.MAX_VALUE;
        for (List<Map.Entry<Node, List<Link>>> permutation : permutations) {
            int currentWeight = calculatePathWeight(permutation);
            if (currentWeight < shortestWeight) {
                totalDistance = shortestWeight = currentWeight;
                shortestPath = permutation;
            }
        }
        return shortestPath;
    }
}