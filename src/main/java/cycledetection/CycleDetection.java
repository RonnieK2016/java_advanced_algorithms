package cycledetection;

import dfs.Vertex;

import java.util.List;

public class CycleDetection {

    public void detectCycle(List<Vertex> vertices) {
        for(Vertex vertex : vertices) {
            detectCycle(vertex);
        }
    }

    public void detectCycle(Vertex rootVertex) {
        rootVertex.setBeingVisited(true);
        rootVertex.setVisited(false);

        for(Vertex vertex : rootVertex.getNeighbours()) {
            if(vertex.isBeingVisited()) {
                System.out.println("Cycle is detected on vertex " + vertex.getId());
                return;
            }

            if(!vertex.isVisited()) {
                detectCycle(vertex);
            }
        }

        rootVertex.setVisited(true);
        rootVertex.setBeingVisited(false);
    }

}
