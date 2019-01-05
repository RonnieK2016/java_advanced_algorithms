package DFS;

import java.util.List;
import java.util.Stack;

public class DFS {

    private Stack<Vertex> stack;

    public DFS() {
        stack = new Stack<Vertex>();
    }

    public void DFS(List<Vertex> vertexList) {
        for(Vertex vertex : vertexList) {
            DFSRecurs(vertex);
        }
    }

    public void DFSRecurs(Vertex rootNode) {
        if(rootNode.isVisited()) {
           return;
        }
        rootNode.setVisited(true);
        System.out.println("Visiting " + rootNode.getId());

        for(Vertex child : rootNode.getNeighbours()) {
            DFSRecurs(child);
        }
    }

    public void DFS(Vertex rootNode) {
         stack.push(rootNode);
         while(!stack.isEmpty()) {
             Vertex vertex = stack.pop();
             vertex.setVisited(true);

             System.out.println("Visiting " + vertex.getId());

             for(Vertex child : vertex.getNeighbours()) {
                 if(!child.isVisited()) {
                     stack.push(child);
                 }
             }
         }
    }

}
