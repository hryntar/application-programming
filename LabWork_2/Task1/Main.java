package LabWork_2.Task1;

public class Main {
    public static void main(String[] args) {
        Graph directedGraph = new Graph(true);
        directedGraph.addNode("A");
        directedGraph.addNode("B");
        directedGraph.addNode("C");
        directedGraph.addNode("D");

        directedGraph.addEdge("A", "B");
        directedGraph.addEdge("A", "C");
        directedGraph.addEdge("B", "D");
        directedGraph.addEdge("C", "D");

        System.out.println("Орінтований граф:");
        directedGraph.printGraph();
        directedGraph.removeEdge("A", "C");
        System.out.println("Після видалення ребра A -> C:");
        directedGraph.printGraph();
        directedGraph.removeNode("D");
        System.out.println("Після видалення вершини D:");
        directedGraph.printGraph();

        Graph undirectedGraph = new Graph(false);
        undirectedGraph.addNode("X");
        undirectedGraph.addNode("Y");
        undirectedGraph.addNode("Z");

        undirectedGraph.addEdge("X", "Y");
        undirectedGraph.addEdge("Y", "Z");
        undirectedGraph.addEdge("X", "Z");

        System.out.println("Неорієнтований граф:");
        undirectedGraph.printGraph();
    }
}
