package dijkstra;

public class App {

    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        a.addNeighbour(new Edge(5,a,b));
        a.addNeighbour(new Edge(8,a,h));
        a.addNeighbour(new Edge(9,a,e));
        b.addNeighbour(new Edge(15,b,d));
        b.addNeighbour(new Edge(12,b,c));
        b.addNeighbour(new Edge(4,b,h));
        h.addNeighbour(new Edge(7,h,c));
        h.addNeighbour(new Edge(6,h,f));
        e.addNeighbour(new Edge(5,e,h));
        e.addNeighbour(new Edge(4,e,f));
        e.addNeighbour(new Edge(20,e,g));
        f.addNeighbour(new Edge(1,f,c));
        f.addNeighbour(new Edge(1,f,c));
        c.addNeighbour(new Edge(3,c,d));
        c.addNeighbour(new Edge(11,c,g));
        d.addNeighbour(new Edge(9,d,g));

        ShortestPathDijkstra shortestPath = new ShortestPathDijkstra();
        shortestPath.computePaths(a);

        System.out.println(shortestPath.getShortestPathTo(g));
    }
}
