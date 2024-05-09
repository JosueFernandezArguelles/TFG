package algorithms;
import graph.Graph;
import java.util.ArrayList;
import java.util.List;
public class BruteForce extends AbstractAlgorithm{
    public BruteForce(Graph g){
        super(g);
    }

    public void TSP(){
        int n = graph.length;
        int[] bestPath = null;
        int bestCost = Integer.MAX_VALUE;
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }

        // Calcular costo para cada permutación y encontrar el mínimo
        for (List<Integer> perm : permute(nodes)) {
            int[] permArray = new int[n];
            for (int i = 0; i < n; i++) {
                permArray[i] = perm.get(i);
            }
            int currentCost = calculateCost(permArray, graph);
            if (currentCost < bestCost) {
                bestCost = currentCost;
                bestPath = permArray;
            }
        }
        this.totalDistance = bestCost;
        assert bestPath != null;
        for(int i : bestPath){
            this.visited.add(i);
        }
    }

    private int calculateCost(int[] path, int[][] matrixCosts) {
        int totalCost = 0;
        for (int i = 0; i < path.length - 1; i++) {
            int origen = path[i];
            int destino = path[i + 1];
            totalCost += matrixCosts[origen][destino];
        }
        // Suma el costo de retorno al punto inicial
        totalCost += matrixCosts[path[path.length - 1]][path[0]];
        return totalCost;
    }

    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) continue; // element already exists, skip
                tempList.add(num);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}