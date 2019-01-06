package acyclicshortestpath;

import dijkstra.Edge;
import dijkstra.Vertex;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    private Stack<Vertex> visited;

    public TopologicalSort() {
        this.visited = new Stack<Vertex>();
    }


    public void  topologicalSort(List<Vertex> vertices) {
        for(Vertex vertex : vertices) {
            if(!vertex.isVisited()) {
                dfs(vertex);
            }
        }
    }

    public void dfs(Vertex rootNode) {
        rootNode.setVisited(true);

        for(Edge child : rootNode.getAdjacenciesList()) {
            if(!child.getTargetVertex().isVisited()) {
                dfs(child.getTargetVertex());
            }
        }

        visited.push(rootNode);
    }

    public Stack<Vertex> getVisited() {
        Collections.reverse(visited);
        return visited;
    }
}
