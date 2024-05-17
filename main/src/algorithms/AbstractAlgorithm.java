package algorithms;
import graph.Graph;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAlgorithm implements Algorithm{

    protected int[][] graph;
    protected List<Integer> visited = new ArrayList<>();

    protected int totalDistance = 0;
    protected boolean satisfied = false;

    public AbstractAlgorithm(Graph g){
        this.graph = g.getGraph();
    }

    @Override
    public int getTotalDistance(){
        return this.totalDistance;
    }

    @Override
    public boolean isSatisfied() {
        return this.satisfied;
    }

    protected boolean[] generateClauses(int[][] values){
        boolean[] clauses = new boolean[values.length];
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] != 0 && graph[i][j] == values[i][j]) {
                    clauses[i] = true;
                    break;
                }
            }
        }
        return clauses;
    }

    protected int countTrueClauses(boolean [] clauses){
        int count = 0;
        for (boolean b : clauses){
            if (b){
                count++;
            }
        }
        return count;
    }
}
