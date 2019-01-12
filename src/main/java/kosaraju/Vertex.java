package kosaraju;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int id;
    private String name;
    private List<Vertex> neighbours;
    private int componentId;
    private boolean visited;

    public Vertex(int id, String name) {
        this.id = id;
        this.name = name;
        neighbours = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(Vertex vertex) {
        neighbours.add(vertex);
    }

    @Override
    public String toString() {
        return name;
    }
}
