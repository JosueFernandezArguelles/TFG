package graph;

public abstract class AbstractGraph implements Graph{
    protected int [][] graph;

    public void printGraph(){
        System.out.println("GRAPH:");
        for(int i = 0; i < graph.length; i++){
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
