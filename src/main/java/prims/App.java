package prims;


import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Vertex> vertexList = new ArrayList<>();

        Vertex vertex0 = new Vertex("A");
        Vertex vertex1 = new Vertex("B");
        Vertex vertex2 = new Vertex("C");

        vertexList.add(vertex0);
        vertexList.add(vertex1);
        vertexList.add(vertex2);

        vertex0.addEdge(new Edge(vertex0, vertex1, 100));
        vertex0.addEdge(new Edge(vertex0, vertex2, 10));
        vertex1.addEdge(new Edge(vertex1, vertex2, 1));

        vertex1.addEdge(new Edge(vertex1, vertex0, 100));
        vertex2.addEdge(new Edge(vertex2, vertex0, 10));
        vertex2.addEdge(new Edge(vertex2, vertex1, 1));

        PrimsAlgorithm primsAlgorithm = new PrimsAlgorithm(vertexList);
        primsAlgorithm.computeMST(vertex2);
        primsAlgorithm.printMST();
    }
}
