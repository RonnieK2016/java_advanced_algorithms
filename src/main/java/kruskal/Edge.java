package kruskal;

public class Edge implements Comparable<Edge> {

    private double weight;
    private Vertex startingVertex;
    private Vertex targetVertex;

    public Edge(Vertex startingVertex, Vertex targetVertex, double weight) {
        this.startingVertex = startingVertex;
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getStartingVertex() {
        return startingVertex;
    }

    public void setStartingVertex(Vertex startingVertex) {
        this.startingVertex = startingVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.getWeight());
    }
}
