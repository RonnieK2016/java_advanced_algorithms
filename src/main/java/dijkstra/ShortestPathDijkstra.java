package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathDijkstra {

    public void computePaths(Vertex startVertex) {
        startVertex.setMinDistance(0);
        PriorityQueue<Vertex> vertices = new PriorityQueue<>();
        vertices.add(startVertex);
        while(!vertices.isEmpty()) {
            Vertex actualVertex = vertices.poll();
            for(Edge edge : actualVertex.getAdjacenciesList()) {
                Vertex targetVertex = edge.getTargetVertex();
                double newDistance = actualVertex.getMinDistance() + edge.getWeight();
                if(newDistance < targetVertex.getMinDistance()) {
                    vertices.remove(targetVertex);
                    targetVertex.setMinDistance(newDistance);
                    targetVertex.setPredecessor(actualVertex);
                    vertices.add(targetVertex);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex vertex) {
        Vertex nextVertex = vertex;
        List<Vertex> path = new ArrayList<>();
        while (nextVertex != null) {
            path.add(nextVertex);
            nextVertex = nextVertex.getPredecessor();
        }
        Collections.reverse(path);
        return path;
    }
}
