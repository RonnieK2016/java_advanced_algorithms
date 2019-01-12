package kosaraju;

public class Kosaraju {

    private Graph graph;
    private int componentsCount;
    private boolean[] visited;

    public Kosaraju(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getVertices().size()];
    }

    public void computeAlgorithm() {
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph.getTransposedGraph().getVertices());
        depthFirstOrder.dfs();;

        for(Vertex vertex : depthFirstOrder.getReversedList()) {
            if(!visited[vertex.getId()]) {
                componentsCount++;
                dfs(vertex);
            }
        }
    }

    private void dfs(Vertex root) {
        visited[root.getId()] = true;
        root.setComponentId(componentsCount);

        for(Vertex vertex : root.getNeighbours()) {
            if(!visited[vertex.getId()]) {
                dfs(vertex);
            }
        }
    }

    public int getComponentsCount() {
        return componentsCount;
    }
}
