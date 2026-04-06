package solution.adjacencyMatrix;

public class GraphAdjMatrixMain {
    public static void main(String[] args) {
        Graph graph = new Graph(6); // 5 nodes
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);
        graph.addEdge(5, 3);
        /**

         0 ------- 1------>4
         |
         |
         |
         2---------------->3<--- 5
         */

        System.out.println("No outgoing edges:");
        graph.printNodesWithoutOutgoingEdges(); // 3, 4
        System.out.println("No incoming edges:");
        graph.printNodesWithoutIncomingEdges(); // 5
        // graph.printIncomingEdges(3);
        System.out.println("DFS Main: ");
        graph.dfsMain();
        System.out.println("BFS Main: ");
        graph.bfsMain();

    }
}
