package graph;

import java.util.Random;

public class GraphKSAT extends AbstractGraph{

    public GraphKSAT(int clauses, int variables){
        this.graph = new int[clauses][variables];
        generateRandomGraph();
    }

    @Override
    void doGenerateRandomGraph(int i, int j) {
        int value = new Random().nextInt(-1, 2);
        graph[i][j] = value;
    }
}