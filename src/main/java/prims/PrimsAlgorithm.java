package prims;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    private double cost;
    private HashSet<Vertex> unvisited;
    private PriorityQueue<Edge> heap;
    private List<Edge> mST;

    public PrimsAlgorithm(List<Vertex> vertices) {
        unvisited = new HashSet<>();
        unvisited.addAll(vertices);
        mST = new ArrayList<>();
        heap = new PriorityQueue<>();
    }

    public void computeMST(Vertex vertex) {
        unvisited.remove(vertex);

        while (!unvisited.isEmpty()) {
            for(Edge edge : vertex.getEdges()) {
                if(unvisited.contains(edge.getTargetVertex())) {
                    heap.add(edge);
                }
            }

            Edge min = heap.remove();

            if(!unvisited.contains(min.getStartVertex()) && !unvisited.contains(min.getTargetVertex())) {
                vertex = min.getTargetVertex();
            }
            else {
                mST.add(min);
                unvisited.remove(min.getTargetVertex());
                vertex = min.getTargetVertex();
                cost += min.getWeight();
            }
        }
    }

    public void printMST() {

        System.out.println("Cost of mst " + cost);

        for(Edge edge : mST) {
            System.out.print(edge.getStartVertex() + " - " + edge.getTargetVertex() + " >> ");
        }
        System.out.println("");
    }

}
