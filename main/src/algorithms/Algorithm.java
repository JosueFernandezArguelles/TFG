package algorithms;

import java.util.List;

public interface Algorithm {

    void TSP();
    int getTotalDistance();
    List<Integer> getVisited();
}
