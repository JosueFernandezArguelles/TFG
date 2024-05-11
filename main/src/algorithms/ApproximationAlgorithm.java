package algorithms;

import graph.Graph;
import java.util.Random;

public class ApproximationAlgorithm extends AbstractAlgorithm{
    public ApproximationAlgorithm(Graph g){
        super(g);
    }

    public void TSP(){
        int currentNode = 0;
        int nextNode = 0;

        while(visited.size() != graph.length){
            int shortest = Integer.MAX_VALUE;

            for(int j = 0; j < graph[0].length; j++){
                if( !visited.contains(j) && graph[currentNode][j] < shortest ) {
                    shortest = graph[currentNode][j];
                    nextNode = j;
                }
            }
            visited.add(nextNode);
            totalDistance += shortest != Integer.MAX_VALUE ? shortest : 0;
            currentNode = nextNode;
        }
    }
}