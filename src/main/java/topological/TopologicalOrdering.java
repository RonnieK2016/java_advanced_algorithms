package topological;

import dfs.Vertex;

import java.util.Stack;

public class TopologicalOrdering {

    private Stack<Vertex> visited;

    public TopologicalOrdering() {
        this.visited = new Stack<Vertex>();
    }

    public void dfs(Vertex rootNode) {
        rootNode.setVisited(true);

        for(Vertex child : rootNode.getNeighbours()) {
            if(!child.isVisited()) {
                dfs(child);
            }
        }

        visited.push(rootNode);
    }

    public Stack<Vertex> getVisited() {
        return visited;
    }
}
