package acyclicshortestpath;

import dijkstra.Edge;
import dijkstra.Vertex;
import topological.TopologicalOrdering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AcyclicShortestPath {

    private List<Vertex> vertices;

    public AcyclicShortestPath(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public void computeShortestPath(Vertex startVertex, Vertex targetVertex) {
        startVertex.setMinDistance(0);
        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.topologicalSort(vertices);
        for(Vertex actualVertex : topologicalSort.getVisited()) {
            for(Edge edge : actualVertex.getAdjacenciesList()) {
                Vertex s = edge.getStartVertex();
                Vertex t = edge.getTargetVertex();
                double newDistance = s.getMinDistance() + edge.getWeight();
                if(newDistance  < t.getMinDistance()) {
                    t.setMinDistance(newDistance);
                    t.setPredecessor(s);
                }
            }
        }

        if(targetVertex.getMinDistance() == Double.MAX_VALUE) {
            System.out.println("No shortest path found");
        }
        else {
            printShortestPath(targetVertex);
        }
    }

    private void printShortestPath(Vertex targetVertex) {
        if(targetVertex.getMinDistance() == Double.MAX_VALUE) {
            System.out.println("No shortest path found!");
            return;
        }
        List<Vertex> path = new ArrayList<>();
        Vertex vertex = targetVertex;
        while(vertex != null) {
            path.add(vertex);
            vertex = vertex.getPredecessor();
        }
        Collections.reverse(path);
        System.out.println(path);
    }
}
