package algorithms;
import graph.Graph;
public class BruteForce extends AbstractAlgorithm{
    public BruteForce(Graph g){
        super(g);
    }

    @Override
    public void TSP() {
        int n = graph.length;
        int[] bestPath = null;
        int bestCost = Integer.MAX_VALUE;
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }

        // Initialize the array to keep track of the permutation index
        int[] indexes = new int[n];

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(nodes, i % 2 == 0 ? 0 : indexes[i], i);

                int currentCost = calculateCost(nodes);
                if (currentCost < bestCost) {
                    bestCost = currentCost;
                    bestPath = nodes.clone();
                }

                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }

        this.totalDistance = bestCost;
        assert bestPath != null;
        for (int j : bestPath) {
            this.visited.add(j);
        }
    }

    @Override
    public void KSAT() {

    }

    @Override
    public boolean isSatisfied() {
        return this.satisfied;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private int calculateCost(int[] path) {
        int totalCost = 0;
        for (int i = 0; i < path.length - 1; i++) {
            totalCost += graph[path[i]][path[i + 1]];
        }
        // Suma el costo de retorno al punto inicial
        totalCost += graph[path[path.length - 1]][path[0]];
        return totalCost;
    }
}