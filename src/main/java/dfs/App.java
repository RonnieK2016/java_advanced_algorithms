package dfs;

import java.util.Collections;

public class App {
    public static void main(String[] args) {
        Vertex v1 = new Vertex(3);
        Vertex v2 = new Vertex(5);
        Vertex v3 = new Vertex(1);
        Vertex v4 = new Vertex(6);
        Vertex v5 = new Vertex(2);
        Vertex v7 = new Vertex(0);
        Vertex v8 = new Vertex(8);
        Vertex v9 = new Vertex(7);
        Vertex v10 = new Vertex(4);
        v1.addNeighbour(v2);
        v1.addNeighbour(v3);
        v2.addNeighbour(v4);
        v2.addNeighbour(v5);
        v3.addNeighbour(v7);
        v3.addNeighbour(v8);
        v5.addNeighbour(v9);
        v5.addNeighbour(v10);

        DFS dfs = new DFS();
        dfs.DFS(Collections.singletonList(v1));
    }
}
