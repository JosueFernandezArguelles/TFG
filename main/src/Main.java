import algorithms.ApproximationAlgorithm;
import algorithms.BruteForce;
import graph.Graph;
import graph.Node;

import java.util.List;

public class Main {
    public static void main(String[] args){
        Graph graph = new Graph();
        graph.generateRandomGraph();
        graph.printGraph();

        ApproximationAlgorithm ap = new ApproximationAlgorithm(graph);
        ap.TSPApproximation();
        ap.result();
    }
}
