package kruskal;

import java.util.ArrayList;
import java.util.List;

public class DisjoinSet {

    private int setsCount;
    private int nodesCount;
    private List<Node> parentNodes;

    public DisjoinSet(List<Vertex> vertices) {
        parentNodes = new ArrayList<>(vertices.size());
        makeSets(vertices);
    }

    private void makeSets(List<Vertex> vertices) {
        for(Vertex vertex : vertices) {
            makeSet(vertex);
        }
    }

    private void makeSet(Vertex vertex) {
        Node node = new Node(nodesCount, 0, null);
        vertex.setNode(node);
        parentNodes.add(node);
        setsCount++;
        nodesCount++;
    }

    public int find(Node x) {
        Node curNode = x;

        while(curNode.getParent() != null) {
            curNode = curNode.getParent();
        }

        //path compression
        Node rootNode = curNode;
        curNode = x;
        while(curNode != rootNode) {
            Node temp = curNode;
            curNode.setParent(rootNode);
            curNode = temp.getParent();
        }
        return rootNode.getId();
    }

    public void union(Node a, Node b) {
        int rootAId = find(a);
        int rootBId = find(b);

        if(rootAId == rootBId) {
            return;
        }

        a = parentNodes.get(rootAId);
        b = parentNodes.get(rootBId);

        if(a.getRank() < b.getRank()) {
            a.setParent(b);
        }
        else {
            b.setParent(a);
            if(a.getRank() == b.getRank()) {
                a.setRank(a.getRank() + 1);
            }
        }

        this.setsCount--;
    }

    public boolean isSameSet(Node a, Node b) {
        return find(a) == find(b);
    }

}
