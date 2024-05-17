package graph;

import java.util.*;

public class GraphTSP extends AbstractGraph{
    private final int MIN_LINK_VALUE = 3;
    private final int MAX_LINK_VALUE = 6;

    public GraphTSP(int nodes){
        graph = new int[nodes][nodes];
        generateRandomGraph();
    }

    @Override
    protected void doGenerateRandomGraph(int i, int j) {
        int value = new Random().nextInt(MIN_LINK_VALUE, MAX_LINK_VALUE);
        graph[i][j] = value;
        graph[j][i] = value;
    }
}