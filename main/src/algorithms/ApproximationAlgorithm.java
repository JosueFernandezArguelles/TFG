package algorithms;

import graph.Graph;
import java.util.Random;

public class ApproximationAlgorithm extends AbstractAlgorithm{
    public ApproximationAlgorithm(Graph g){
        super(g);
    }

    public void TSP(){
        int currentNode = new Random().nextInt(0, graph.length);

        while(visited.size() != graph.length){
            int shortest = Integer.MAX_VALUE;
            int nextNode = 0;
            for(int j = 0; j < graph[0].length; j++){
                if( currentNode != j && !visited.contains(j) && graph[currentNode][j] < shortest ) {
                    shortest = graph[currentNode][j];
                    nextNode = j;
                }
            }
            visited.add(nextNode);
            totalDistance += shortest;
            currentNode = nextNode;
        }
    }
}