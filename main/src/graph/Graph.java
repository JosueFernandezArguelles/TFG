package graph;

import java.util.*;

public class Graph {
    private final int MIN_LINK_VALUE = 3;
    private final int MAX_LINK_VALUE = 6;

    private int [][] graph;

    public Graph(int nodes){
        this.graph = new int[nodes][nodes];
        generateRandomGraph();
    }

    private void generateRandomGraph(){
        for(int i = 0; i < graph[0].length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0){
                    int value = new Random().nextInt(MIN_LINK_VALUE, MAX_LINK_VALUE);
                    graph[i][j] = value;
                    graph[j][i] = value;
                }
            }
        }
    }

    public void printGraph(){
        for(int i = 0; i < graph[0].length; i++){
            for(int j = 0; j < graph[0].length; j++){
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] getGraph(){
        return this.graph;
    }
}