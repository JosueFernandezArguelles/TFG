package algorithms;
import graph.Graph;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ApproximationAlgorithm extends AbstractAlgorithm{

    private final Random rand = new Random();

    public ApproximationAlgorithm(Graph g){
        super(g);
    }

    @Override
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

    @Override
    public void KSAT() {
        int repetitions = graph[0].length;
        //Asignación aleatoria de valores
        int [][] values = assignRandomValues();

        //Evaluar la formula
        boolean [] clauses = generateClauses(values);
        boolean satisfied = evaluateFormula(clauses);
        int trueClauses = countTrueClauses(clauses);
        List<Integer> changedVariables = new ArrayList<>();

        while (repetitions-- != 0){
            if(satisfied || changedVariables.size() == graph[0].length){ break; }

            //Cambio aletorio en una variable
            int variableToBeChanged =rand.nextInt(0, values[0].length);
            while (changedVariables.contains(variableToBeChanged)){
                variableToBeChanged = rand.nextInt(0, values[0].length);
            }
            changedVariables.add(variableToBeChanged);
            int [][] possibleNewValues = randomChange(values, variableToBeChanged);
            boolean [] possibleNewClauses = generateClauses(possibleNewValues);
            int numberNewTrueClauses = countTrueClauses(possibleNewClauses);

            if(numberNewTrueClauses > trueClauses){
                values = possibleNewValues;
                clauses = possibleNewClauses;
                trueClauses = numberNewTrueClauses;
                satisfied = evaluateFormula(clauses);
                repetitions++;
            }
        }

        this.satisfied = satisfied;
     }

    private boolean evaluateFormula(boolean[] clauses) {
        for(boolean b : clauses){
            if(!b){
                return false;
            }
        }
        return true;
    }

    private int [][] randomChange(int[][] values, int variableToBeChanged) {
        int[][] ret = values.clone();

        for(int i = 0; i < values.length; i++){
            int value = ret[i][variableToBeChanged];
            if(value != 0){
                ret[i][variableToBeChanged] = ret[i][variableToBeChanged] == 1 ? -1 : 1;
            }
        }
        return ret;
    }

    /**
     * Genera un valor aleatorio, -1 0 1, para cada variable.
     */
     private int [][] assignRandomValues(){
         int [][] values = new int[graph.length][graph[0].length];
         for(int j = 0; j < graph[0].length; j++){
             //Valor igual para cada variable
             int value = rand.nextInt(2) < 0.5 ? -1 : 1;
             for(int i = 0; i < graph.length; i++){
                 if(graph[i][j] != 0){
                     values[i][j] = value;
                 }
             }
         }
         return values;
     }
}