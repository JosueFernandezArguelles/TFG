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

        String resultAP = "";
        String resultBF = "";

        for (int i = 5; i < 14; i++){ // Número de nodos [5-13]
            resultAP += "NÚMERO DE NODOS: " + i + "\n";
            resultBF += "NÚMERO DE NODOS: " + i + "\n";
            for(int j = 0; j < 50; j++){ //Repeticiones para cada nodo
                Graph graph = new Graph(i);
                //Approximation

                ApproximationAlgorithm ap = new ApproximationAlgorithm(graph);
                double start = System.currentTimeMillis();
                ap.TSP();
                double end = (System.currentTimeMillis() - start)/1000.000;
                resultAP += String.format("%s %ss \n", ap.getTotalDistance(), end);

                //BruteForce

                BruteForce bf = new BruteForce(graph);
                start = System.currentTimeMillis();
                bf.TSP();
                end = (System.currentTimeMillis() - start)/1000.000;
                resultBF += String.format("%s %ss \n", bf.getTotalDistance(), end);

                System.out.println("Número de nodos: " + i);
                System.out.println("Ejecución: " + j);
            }
        }

        try {
            FileWriter fwap = new FileWriter("resultsAP.txt", true);
            fwap.write(resultAP);
            fwap.close();
            FileWriter fwbf = new FileWriter("resultsBF.txt", true);
            fwbf.write(resultBF);
            fwbf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
