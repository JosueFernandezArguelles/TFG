package algorithms;

import graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BruteForce extends AbstractAlgorithm{

    public BruteForce(Graph g){
        super(g);
    }

    public void TSP(){
        int n = graph.length;
        int[] mejorCamino = null;
        int mejorCosto = Integer.MAX_VALUE;
        int[] puntos = new int[n];
        for (int i = 0; i < n; i++) {
            puntos[i] = i;
        }

        // Generar todas las permutaciones posibles de puntos
        List<List<Integer>> todasPermutaciones = permute(puntos);

        // Calcular costo para cada permutación y encontrar el mínimo
        for (List<Integer> perm : todasPermutaciones) {
            int[] permArray = new int[n];
            for (int i = 0; i < n; i++) {
                permArray[i] = perm.get(i);
            }
            int costoActual = calcularCosto(permArray, graph);
            if (costoActual < mejorCosto) {
                mejorCosto = costoActual;
                mejorCamino = permArray;
            }
        }
        this.totalDistance = mejorCosto;
        assert mejorCamino != null;
        for(int i : mejorCamino){
            this.visited.add(i);
        }
    }

    private int calcularCosto(int[] camino, int[][] matrizCostos) {
        int costoTotal = 0;
        for (int i = 0; i < camino.length - 1; i++) {
            int origen = camino[i];
            int destino = camino[i + 1];
            costoTotal += matrizCostos[origen][destino];
        }
        // Suma el costo de retorno al punto inicial
        costoTotal += matrizCostos[camino[camino.length - 1]][camino[0]];
        return costoTotal;
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