import algorithms.ApproximationAlgorithm;
import algorithms.BruteForce;
import graph.Graph;
import java.io.FileWriter;
import java.io.IOException;

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

                double start = 0.000;
                double end = 0.000;

                ApproximationAlgorithm ap = new ApproximationAlgorithm(graph);
                start = System.nanoTime();
                ap.TSP();
                end = (System.nanoTime() - start)/1000000;
                resultAP += String.format("%s %s \n", ap.getTotalDistance(), end);

                //BruteForce

                BruteForce bf = new BruteForce(graph);
                start =  System.nanoTime();
                bf.TSP();
                end = (System.nanoTime() - start)/1000000;
                resultBF += String.format("%s %s \n", bf.getTotalDistance(), end);

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
