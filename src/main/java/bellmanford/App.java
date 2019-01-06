package bellmanford;

import dijkstra.Edge;
import dijkstra.Vertex;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex("1"));
        vertexList.add(new Vertex("2"));
        vertexList.add(new Vertex("3"));
        vertexList.add(new Vertex("4"));
        vertexList.add(new Vertex("5"));

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(5, vertexList.get(0), vertexList.get(1)));
        edgeList.add(new Edge(-4, vertexList.get(0), vertexList.get(3)));
        edgeList.add(new Edge(8, vertexList.get(0), vertexList.get(2)));
        edgeList.add(new Edge(-2, vertexList.get(1), vertexList.get(0) ));
        edgeList.add(new Edge(-3, vertexList.get(2), vertexList.get(1)));
        edgeList.add(new Edge(9, vertexList.get(2),vertexList.get(3)));
        edgeList.add(new Edge(7, vertexList.get(3),vertexList.get(1)));
        edgeList.add(new Edge(6, vertexList.get(4),vertexList.get(0)));
        edgeList.add(new Edge(7, vertexList.get(4),vertexList.get(2)));

        BellmanFord bellmannFordAlgorithm = new BellmanFord(vertexList, edgeList);
        bellmannFordAlgorithm.compute(vertexList.get(4),vertexList.get(3));

    }

}
