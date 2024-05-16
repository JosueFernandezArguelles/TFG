package algorithms;
import graph.Graph;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAlgorithm implements Algorithm{

    protected int[][] graph;
    protected List<Integer> visited = new ArrayList<>();

    protected int totalDistance = 0;

    public AbstractAlgorithm(Graph g){
        this.graph = g.getGraph();
    }

    public int getTotalDistance(){
        return this.totalDistance;
    }
}
