package primseager;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

    private String name;
    private boolean visited;
    private Vertex previousVertex;
    private double distance = Double.POSITIVE_INFINITY;
    private List<Edge> edges;
    private Edge minEdge;


    public Vertex(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Edge getMinEdge() {
        return minEdge;
    }

    public void setMinEdge(Edge minEdge) {
        this.minEdge = minEdge;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.distance, o.getDistance());
    }
}
