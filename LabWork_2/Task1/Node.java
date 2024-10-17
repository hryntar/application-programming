package LabWork_2.Task1;

import java.util.HashMap;
import java.util.Map;

class Node {
    private final String name;
    private final Map<Node, Integer> neighbors;

    public Node(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<Node, Integer> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Node node) {
        neighbors.put(node, 1);
    }

    public void removeNeighbor(Node node) {
        neighbors.remove(node);
    }
}
