package graph;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GraphKSAT extends AbstractGraph{

    private int K;

    public GraphKSAT(int clauses, int variables, int K){
        this.graph = new int[clauses][variables];
        this.K = K;
        generateRandomGraph();
    }

    private void generateRandomGraph(){
        for(int i = 0; i < graph.length; i++){
            Set<Integer> selectedIndices = new HashSet<>();
            // Seleccionar K índices únicos aleatorios en la fila
            while (selectedIndices.size() < K) {
                selectedIndices.add(new Random().nextInt(graph[0].length));
            }
            for (int j = 0; j < graph[0].length; j++) {
                graph[i][j] = selectedIndices.contains(j) ? new Random().nextInt(2) < 0.5 ? -1 : 1 : 0;
            }
        }
    }
}