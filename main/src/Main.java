import algorithms.ApproximationAlgorithm;
import algorithms.BruteForce;
import graph.Graph;
import graph.Node;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Main {
    public static void main(String[] args){

        StringBuilder result = new StringBuilder();

        for(int i = 0; i<1 ; i++) {

            result.append("Grafo: ").append(i).append("\n");

            long startGraph = System.currentTimeMillis();

            Graph graph = new Graph();
            graph.generateRandomGraph();

            result.append("Número de nodos:").append(graph.getNodes().size()).append("\n");

            System.out.printf("Tiempo de creación del grafo: %s segundos \n", (System.currentTimeMillis() - startGraph) / 1000);

            //Algoritmo aproximado

            long startAlgorithm = System.currentTimeMillis();

            ApproximationAlgorithm ap = new ApproximationAlgorithm(graph);
            ap.TSPApproximation();
            ap.result();

            System.out.printf("Tiempo del algoritmo aproximado: %s segundos \n", (System.currentTimeMillis() - startAlgorithm) / 1000.000);
            result.append("Tiempo del algoritmo aproximado: ").append((System.currentTimeMillis() - startAlgorithm) / 1000.000).append(" segundos \n");

            //Fuerza bruta

            BruteForce bf = new BruteForce(graph);
            bf.TSPBruteForce();
            bf.result();
        }

        try {
            FileWriter fw = new FileWriter("results.txt", true);
            fw.write(String.valueOf(result));
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
