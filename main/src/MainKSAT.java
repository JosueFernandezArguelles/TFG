import algorithms.ApproximationAlgorithm;
import algorithms.BruteForce;
import graph.GraphKSAT;
import java.io.FileWriter;
import java.io.IOException;

public class MainKSAT {
    public static void main(String[] args){
        String resultAP = "";
        String resultBF = "";

        for (int i = 5; i < 17; i++){ // Número de variables y clausulas
            resultAP += "NÚMERO DE VARIABLES: " + i + "\n";
            resultBF += "NÚMERO DE VARIABLES: " + i + "\n";
            for(int j = 0; j < 100; j++){
                int K = 3;
                GraphKSAT graphKSAT = new GraphKSAT( (int) 4.24*i, i, K);

                double start = 0.000;
                double end = 0.000;

                //Approximation
                ApproximationAlgorithm ap = new ApproximationAlgorithm(graphKSAT);
                start = System.nanoTime();
                ap.KSAT();
                System.out.println(ap.isSatisfied());
                end = (System.nanoTime() - start)/1000000;
                resultAP += String.format("%s %s \n", ap.isSatisfied(), end);

                //Brute Force

                BruteForce bf = new BruteForce(graphKSAT);
                start =  System.nanoTime();
                bf.KSAT();
                System.out.println(bf.isSatisfied());
                end = (System.nanoTime() - start)/1000000;
                resultBF += String.format("%s %s \n", bf.isSatisfied(), end);

                System.out.println("Número de variables: " + i);
                System.out.println("Ejecución: " + j);
            }
        }

        try {
            FileWriter fwap = new FileWriter("resultsKSATAP.txt", true);
            fwap.write(resultAP);
            fwap.close();
            FileWriter fwbf = new FileWriter("resultsKSATBF.txt", true);
            fwbf.write(resultBF);
            fwbf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}