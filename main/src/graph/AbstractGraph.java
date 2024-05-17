package graph;

import java.util.Random;

public abstract class AbstractGraph implements Graph{
    protected int [][] graph;

    protected void generateRandomGraph(){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0){
                    doGenerateRandomGraph(i, j);
                }
            }
        }
    }

    abstract void doGenerateRandomGraph(int i, int j);

    public void printGraph(){
        System.out.println("GRAPH:");
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
