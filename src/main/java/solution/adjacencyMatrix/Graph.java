package solution.adjacencyMatrix;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * A directed graph represented using an adjacency matrix.
 * If adjacencyMatrix[i][j] is 1, then there is an edge that goes from i to j.
 */
public class Graph {
    private int[][] adjacencyMatrix;

    /**
     * Constructor
     * @param n number of nodes
     */
    public Graph(int n) {
        adjacencyMatrix = new int[n][n];
    }

    /** Add an edge from node n1 to node n2
     *
     * @param n1 node n1
     * @param n2 node n2
     */
    public void addEdge(int n1, int n2) {
        adjacencyMatrix[n1][n2] = 1;
    }

    /**
     * Print nodes that have no outgoing edges
     */
    public void printNodesWithoutOutgoingEdges() {
        for (int i = 0 ; i < adjacencyMatrix.length; i++) { // go through all nodes,
            // check if there are any 1s in row i
            boolean foundOutgoingEdge = false;
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    foundOutgoingEdge = true;
                    break;
                }
            }
            if (!foundOutgoingEdge)
                System.out.println(i);

        }
    }

    /**
     * Print all the neighbors of a given vertex
     * @param vertexId vertex
     */
    public void printNeighbors(int vertexId) {
        // Iterate over the row for vertexId, if we find a value of 1, it means the corresponding column index is a neighbor of vertexId
        for (int j = 0; j < adjacencyMatrix.length; j++) {
            if (adjacencyMatrix[vertexId][j] == 1)
                System.out.println(j);
        }
    }

    /**
     * Print nodes that have no incoming edges from other nodes
     */
    public void printNodesWithoutIncomingEdges() {
        for (int i = 0; i < adjacencyMatrix.length; i++) { // go through all nodes
            // check if there are any 1s in column i
            boolean hasIncomingEdge = false;
            for (int j = 0; j < adjacencyMatrix.length; j++)  {
                if (adjacencyMatrix[j][i] == 1) {
                    hasIncomingEdge = true;
                }
            }
            if (!hasIncomingEdge)
                System.out.println(i);
        }
    }

    /**
     * Print incoming edges.
     * Find ids of vertices that have outgoing edges that point to vertexId
     * Ex: for the graph in main, for vertexId = 3, such vertices will be 2 and 5
     * So incoming edges for vertexId = 3, will be (2, 3) and (5, 3)
     * @param vertexId vertex
     */
    public void printIncomingEdges(int vertexId) {
        // An incoming edge is an edge that comes from some other vertex to vertexId
        for (int j = 0; j < adjacencyMatrix.length; j++) {
            if (adjacencyMatrix[j][vertexId] == 1)
                System.out.println(j + ", " + vertexId);
        }

    }

    /** A helper method for dfsMain - runs DFS once from the given source vertex
     *
     * @param vertex source vertex
     * @param visited an array, where for each vertex id we store true if it has been visited,
     * and false otherwise
     */
    public void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex);
        // Iterate over the row for this vertex
        // For each neighbor, if it has not been visited, call dfs recursively on the neighbor
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && !visited[i])
                dfs(i, visited);

        }

    }

    /**
     * Iterative DFS implementation that uses a stack.
     * @param vertex source vertex
     * @param visited array that stores true for each vertex id that has been visited
     */
    public void dfsWithStack(int vertex, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex); // push the source vertex onto the stack

        while (!stack.isEmpty()) {
            // pop the vertex from the stack, mark it as "visited"
            int nextV = stack.pop();
            visited[nextV] = true;
            System.out.println(nextV);
            // iterate over the row for the vertex nextV
            // if found a neighbor that has not been visited, push it onto the stack
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[nextV][j] == 1 && !visited[j]) {
                    stack.push(j);
                }
            }
        }
    }


    /** Runs dfs starting from each vertex that has not been visited.
     * Makes sure all vertices are visited (may involve running dfs several times).
     * If the graph is connected, it would be enough to run dfs once.
     */
    public void dfsMain() {
        boolean visited[]  = new boolean[adjacencyMatrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                //dfs(i, visited);
                dfsWithStack(i, visited); // instead of calling recursive dfs, we could call dfsWithStack
        }
    }

    /**
     * Run BFS from a given vertex
     * @param vertex source vertex
     * @param visited boolean array that for each vertex id stores true if it has been visited
     */
    void bfs(int vertex, boolean visited[]) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;
        System.out.println(vertex);
        while (!queue.isEmpty()) {
            int i = queue.remove();
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == 1 && !visited[j]) {
                    System.out.println(j);
                    queue.add(j);
                    visited[j] = true;
                }
            }

        } // white queue is not empty
    }


    /** Runs BFS starting from every vertex that has not been visited.
     *
     */
    public void bfsMain() {
        boolean visited[]  = new boolean[adjacencyMatrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                bfs(i, visited);
        }
    }

}
