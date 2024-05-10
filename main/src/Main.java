import algorithms.ApproximationAlgorithm;
import algorithms.BruteForce;
import graph.Graph;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args){

        StringBuilder result = new StringBuilder();

        Graph graph = new Graph();
        graph.printGraph();

        //Approximation

        ApproximationAlgorithm ap = new ApproximationAlgorithm(graph);
        ap.TSP();
        System.out.println(ap.getTotalDistance());
        System.out.println(ap.getVisited());

        //BruteForce

        long start = System.currentTimeMillis();

        BruteForce bf = new BruteForce(graph);
        bf.TSP();
        System.out.println(bf.getTotalDistance());
        System.out.println(bf.getVisited());

        double end = (System.currentTimeMillis() - start)/1000.000;

        System.out.println(end);

        /*
        try {
            FileWriter fw = new FileWriter("results.txt", true);
            fw.write(String.valueOf(result));
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
    }
}
