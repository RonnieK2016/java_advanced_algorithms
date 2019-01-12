package kosaraju;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex(0, "0"));
        vertexList.add(new Vertex(1, "1"));
        vertexList.add(new Vertex(2, "2"));
        vertexList.add(new Vertex(3, "3"));
        vertexList.add(new Vertex(4, "4"));
        vertexList.add(new Vertex(5, "5"));
        vertexList.add(new Vertex(6, "6"));
        vertexList.add(new Vertex(7, "7"));


        List<Edge> edgeList = new ArrayList<Edge>();

        edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(1)));

        edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(2)));
        edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(4)));
        edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(5)));

        edgeList.add(new Edge(1, vertexList.get(2), vertexList.get(3)));
        edgeList.add(new Edge(1, vertexList.get(2), vertexList.get(6)));

        edgeList.add(new Edge(1, vertexList.get(3), vertexList.get(2)));
        edgeList.add(new Edge(1, vertexList.get(3), vertexList.get(7)));

        edgeList.add(new Edge(1, vertexList.get(4), vertexList.get(0)));
        edgeList.add(new Edge(1, vertexList.get(4), vertexList.get(5)));

        edgeList.add(new Edge(1, vertexList.get(5), vertexList.get(6)));

        edgeList.add(new Edge(1, vertexList.get(6), vertexList.get(5)));

        edgeList.add(new Edge(1, vertexList.get(7), vertexList.get(3)));
        edgeList.add(new Edge(1, vertexList.get(7), vertexList.get(6)));

        Graph graph = new Graph(vertexList,edgeList);

        Kosaraju kosarajuAlgorithm = new Kosaraju(graph);
        kosarajuAlgorithm.computeAlgorithm();

        System.out.println("Number of components found - " + kosarajuAlgorithm.getComponentsCount());

        for(Vertex vertex : vertexList){
            System.out.println(vertex+" in component "+vertex.getComponentId());
        }

    }
}
