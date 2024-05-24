package graph;

import java.util.*;

public class GraphTSP extends AbstractGraph{
    private final int MIN_LINK_VALUE = 3;
    private final int MAX_LINK_VALUE = 6;

    public GraphTSP(int nodes){
        graph = new int[nodes][nodes];
        generateRandomGraph();
    }

    protected void generateRandomGraph(){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0){
                    int value = new Random().nextInt(MIN_LINK_VALUE, MAX_LINK_VALUE);
                    graph[i][j] = value;
                    graph[j][i] = value;
                }
            }
        }
    }
}