package primseager;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Vertex> vertices;
    private List<Edge> edgeList;

    public Graph() {
        this.vertices = new ArrayList<>();
        this.edgeList = new ArrayList<>();
    }

    public void addVertex(Vertex vertex){
        this.vertices.add(vertex);
    }

    public void addEdge(Edge edge){

        Vertex startVertex = edge.getStartVertex();
        Vertex targetVertex = edge.getTargetVertex();

        this.vertices.get(vertices.indexOf(startVertex)).addEdge(new Edge(startVertex, targetVertex, edge.getWeight()));
        this.vertices.get(vertices.indexOf(targetVertex)).addEdge(new Edge(targetVertex, startVertex, edge.getWeight()));

    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }

}
