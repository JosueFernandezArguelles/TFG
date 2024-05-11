import algorithms.ApproximationAlgorithm;
import algorithms.BruteForce;
import graph.Graph;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args){

        String result = "";

        for (int i = 5; i < 14; i++){ // Número de nodos [5-13]
            result += "NÚMERO DE NODOS: " + i + "\n";
            for(int j = 0; j < 50; j++){ //Repeticiones para cada nodo
                Graph graph = new Graph(i);
                //Approximation

                ApproximationAlgorithm ap = new ApproximationAlgorithm(graph);
                double start = System.currentTimeMillis();
                ap.TSP();
                double end = (System.currentTimeMillis() - start)/1000.000;
                result += String.format("Algoritmo aproximado -> distancia: %s, tiempo: %s s \n", ap.getTotalDistance(), end);

                //BruteForce

                BruteForce bf = new BruteForce(graph);
                start = System.currentTimeMillis();
                bf.TSP();
                end = (System.currentTimeMillis() - start)/1000.000;
                result += String.format("Algoritmo de fuerza bruta -> distancia: %s, tiempo: %s s \n", bf.getTotalDistance(), end);

                System.out.println("Número de nodos: " + i);
                System.out.println("Ejecución: " + j);
            }
        }

        try {
            FileWriter fw = new FileWriter("results.txt", true);
            fw.write(result);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
