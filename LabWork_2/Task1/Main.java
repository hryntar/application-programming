package LabWork_2.Task1;

public class Main {
    public static void main(String[] args) {
        Graph directedGraph = new Graph(true);
        directedGraph.addNode("A", 10);
        directedGraph.addNode("B", 20);
        directedGraph.addNode("C", 30);
        directedGraph.addNode("D", 40);

        directedGraph.addEdge("A", "B", 5);
        directedGraph.addEdge("A", "C", 10);
        directedGraph.addEdge("B", "D", 15);
        directedGraph.addEdge("C", "D", 20);

        System.out.println("Орінтований граф:");
        directedGraph.printGraph();
        directedGraph.removeEdge("A", "C");
        System.out.println("Після видалення ребра A -> C:");
        directedGraph.printGraph();
        directedGraph.removeNode("D");
        System.out.println("Після видалення вершини D:");
        directedGraph.printGraph();

        Graph undirectedGraph = new Graph(false);
        undirectedGraph.addNode("X", 50);
        undirectedGraph.addNode("Y", 60);
        undirectedGraph.addNode("Z", 70);

        undirectedGraph.addEdge("X", "Y", 25);
        undirectedGraph.addEdge("Y", "Z", 35);
        undirectedGraph.addEdge("X", "Z", 45);

        System.out.println("Неорієнтований граф:");
        undirectedGraph.printGraph();
    }
}
