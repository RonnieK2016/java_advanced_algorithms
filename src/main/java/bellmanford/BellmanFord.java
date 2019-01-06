package bellmanford;

import dijkstra.Edge;
import dijkstra.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellmanFord {

    private List<Vertex> vertices;
    private List<Edge> edges;

    public BellmanFord(List<Vertex> vertexList, List<Edge> edgeList) {
        this.vertices = vertexList;
        this.edges = edgeList;
    }

    public void compute(Vertex startVertex, Vertex targetVertex) {
        startVertex.setMinDistance(0);

        for(int i = 0; i < (vertices.size() - 1); i++) {

            boolean wasChanged = false;

            for(Edge edge : edges) {
                Vertex s = edge.getStartVertex();

                if(s.getMinDistance() == Double.MAX_VALUE) {
                    continue;
                }

                Vertex t = edge.getTargetVertex();
                double newDistance = s.getMinDistance() + edge.getWeight();
                if(newDistance < t.getMinDistance()) {
                    t.setMinDistance(newDistance);
                    t.setPredecessor(s);
                    wasChanged = true;
                }
            }

            if(!wasChanged) {
                System.out.println("There was no changes to the graph. Exiting at " + i + " iteration ");
                break;
            }
        }

        if(negativeCycle()) {
            System.out.println("Negative cycle detected");
            return;
        }

        printShortestPath(targetVertex);
    }

    private boolean negativeCycle() {
        for(Edge edge : edges) {
            Vertex startVertex = edge.getStartVertex();

            if(startVertex.getMinDistance() == Double.MAX_VALUE) {
                continue;
            }

            Vertex targetVertex = edge.getTargetVertex();
            double newDistance = startVertex.getMinDistance() + edge.getWeight();
            if(newDistance < targetVertex.getMinDistance()) {
                return true;
            }
        }

        return false;
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
