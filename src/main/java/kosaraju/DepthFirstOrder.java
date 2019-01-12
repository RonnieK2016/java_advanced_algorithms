package kosaraju;

import java.util.List;
import java.util.Stack;

public class DepthFirstOrder {

    private Stack<Vertex> reversedList;
    private List<Vertex> vertices;

    public DepthFirstOrder(List<Vertex> vertices) {
        this.vertices = vertices;
        reversedList = new Stack<>();
    }

    public void dfs() {
        for(Vertex vertex : vertices) {
            if(!vertex.isVisited()) {
                dfs(vertex);
            }
        }
    }

    public void dfs(Vertex root) {
        root.setVisited(true);

        for(Vertex vertex : root.getNeighbours()) {
            if(!vertex.isVisited()) {
                dfs(vertex);
            }
        }

        reversedList.push(root);
    }

    public Stack<Vertex> getReversedList() {
        return reversedList;
    }
}
