package LabWork_2.Task1;

import java.util.HashMap;
import java.util.Map;

class Node {
    private final String name;
    private final int value;
    private final Map<Node, Integer> neighbors;

    public Node(String name, int value) {
        this.name = name;
        this.value = value;
        this.neighbors = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public Map<Node, Integer> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Node node, int weight) {
        neighbors.put(node, weight);
    }

    public void removeNeighbor(Node node) {
        neighbors.remove(node);
    }
}
