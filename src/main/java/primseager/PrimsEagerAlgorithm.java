package primseager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsEagerAlgorithm {

    private double cost;
    private PriorityQueue<Vertex> heap;
    private List<Vertex> vertices;

    public PrimsEagerAlgorithm(List<Vertex> vertices) {
        heap = new PriorityQueue<>();
        this.vertices = vertices;
    }

    public void computeMST() {
        for(Vertex vertex : vertices) {
            if(!vertex.isVisited()) {
                greedyPrim(vertex);
            }
        }
    }

    private void greedyPrim(Vertex vertex) {
        vertex.setDistance(0);
        heap.add(vertex);

        while( !heap.isEmpty() ){
            Vertex v = heap.remove();
            visitVertex(v);
        }

    }

    private void visitVertex(Vertex vertex) {
        vertex.setVisited(true);

        for(Edge edge : vertex.getEdges()) {
            Vertex targetVertex = edge.getTargetVertex();

            if(targetVertex.isVisited()) {
                continue;
            }

            if(targetVertex.getDistance() > edge.getWeight()) {
                targetVertex.setDistance(edge.getWeight());
                targetVertex.setMinEdge(edge);

                if(heap.contains(targetVertex)) {
                    heap.remove(targetVertex);
                }

                heap.add(targetVertex);
            }
        }
    }

    public void printMST() {

        for(Vertex vertex : vertices) {
            Edge minEdge = vertex.getMinEdge();
            if(minEdge != null) {
                cost += minEdge.getWeight();
                System.out.print(minEdge.getStartVertex() + " - " + minEdge.getTargetVertex() + " >> ");
            }
        }
        System.out.println("");
        System.out.println("Spanning tree cost is " + cost);
    }

}
