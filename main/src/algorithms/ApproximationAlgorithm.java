package algorithms;
import graph.Graph;

public class ApproximationAlgorithm extends AbstractAlgorithm{
    public ApproximationAlgorithm(Graph g){
        super(g);
    }

    public void TSP(){
        int startNode = 0;
        int currentNode = 0;
        int nextNode = 0;

        while(visited.size() != graph.length){
            int shortest = Integer.MAX_VALUE;

            for(int j = 0; j < graph[0].length; j++){
                if( currentNode != j && !visited.contains(j) && graph[currentNode][j] < shortest && j != startNode ) {
                    shortest = graph[currentNode][j];
                    nextNode = j;
                } else if (j == startNode && visited.size() == graph.length - 1) { //Evita que entre al nodo inicial antes de tiempo
                    shortest = graph[currentNode][startNode];
                    nextNode = startNode;
                }
            }
            visited.add(nextNode);
            totalDistance += shortest != Integer.MAX_VALUE ? shortest : 0;
            currentNode = nextNode;
        }
    }
}