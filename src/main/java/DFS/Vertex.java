package DFS;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int id;
    private List<Vertex> neighbours;
    private boolean visited;

    public Vertex(int id) {
        this.id = id;
        this.neighbours = new ArrayList<Vertex>();
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(Vertex vertex) {
        neighbours.add(vertex);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getId() {
        return id;
    }
}
