package graph;

import java.util.*;

public class Graph {

    private final int MIN_NODES = 13;
    private final int MAX_NODES = 14;
    private final int MIN_LINK_VALUE = 4;
    private final int MAX_LINK_VALUE = 8;

    private int [][] graph;
    private Random rand = new Random();

    public Graph(){
        int nodes = rand.nextInt(MIN_NODES, MAX_NODES);
        this.graph = new int[nodes][nodes];
        generateRandomGraph();
    }

    private void generateRandomGraph(){
        for(int i = 0; i < graph[0].length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0){
                    int value = rand.nextInt(MIN_LINK_VALUE, MAX_LINK_VALUE);
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