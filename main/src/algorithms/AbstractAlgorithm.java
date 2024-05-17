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
}
