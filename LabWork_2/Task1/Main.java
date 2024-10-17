package LabWork_2.Task1;

public class Main {
    public static void main(String[] args) {
        Graph directedGraph = new Graph(true);
        directedGraph.addNode("A", 1);
        directedGraph.addNode("B", 2);
        directedGraph.addNode("C", 3);
        directedGraph.addNode("D", 4);

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
        undirectedGraph.addNode("X", 1);
        undirectedGraph.addNode("Y", 2);
        undirectedGraph.addNode("Z", 3);

        undirectedGraph.addEdge("X", "Y");
        undirectedGraph.addEdge("Y", "Z");
        undirectedGraph.addEdge("X", "Z");

        System.out.println("Неорієнтований граф:");
        undirectedGraph.printGraph();
    }
}
