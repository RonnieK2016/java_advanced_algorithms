package kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {


    public void spanningTree(List<Vertex> vertices, List<Edge> edges) {
        DisjoinSet disjoinSet = new DisjoinSet(vertices);

        Collections.sort(edges);
        List<Edge> path = new ArrayList<>();

        for (Edge edge : edges) {
            Vertex s = edge.getStartingVertex();
            Vertex t = edge.getTargetVertex();
            if(!disjoinSet.isSameSet(s.getNode(), t.getNode())) {
                path.add(edge);
                disjoinSet.union(s.getNode(), t.getNode());
            }
        }

        for(Edge edge : path) {
            System.out.println(edge.getStartingVertex() + " -> " + edge.getTargetVertex());
        }

    }

}
