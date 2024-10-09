package LabWork_2.Task1;

import java.util.*;

public class Graph {
    private final Map<String, Node> nodes;
    private final boolean isDirected;

    public Graph(boolean isDirected) {
        this.nodes = new HashMap<>();
        this.isDirected = isDirected;
    }

    public Node addNode(String name, int value) {
        if (!nodes.containsKey(name)) {
            Node node = new Node(name, value);
            nodes.put(name, node);
            return node;
        }
        return nodes.get(name);
    }

    public void removeNode(String name) {
        Node nodeToRemove = nodes.get(name);
        if (nodeToRemove == null) return;

        for (Node node : nodes.values()) {
            node.removeNeighbor(nodeToRemove);
        }

        nodes.remove(name);
    }

    public void addEdge(String name1, String name2, int weight) {
        Node node1 = addNode(name1, 0);
        Node node2 = addNode(name2, 0);
        node1.addNeighbor(node2, weight);

        if (!isDirected) {
            node2.addNeighbor(node1, weight);
        }
    }

    public void removeEdge(String name1, String name2) {
        Node node1 = nodes.get(name1);
        Node node2 = nodes.get(name2);
        if (node1 != null && node2 != null) {
            node1.removeNeighbor(node2);
            if (!isDirected) {
                node2.removeNeighbor(node1);
            }
        }
    }

    public void printGraph() {
        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
            Node currentNode = entry.getValue();

            System.out.print(currentNode.getName() + " (" + currentNode.getValue() + ") -> ");

            for (Node neighbor : currentNode.getNeighbors().keySet()) {
                System.out.print(neighbor.getName() + " (" + neighbor.getValue() + ") ");
            }

            System.out.println();
        }
    }
}
