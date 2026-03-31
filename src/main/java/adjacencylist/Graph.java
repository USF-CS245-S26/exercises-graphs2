package adjacencylist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private Edge[] graph; // adjacency list for this graph

    // Static nested class Edge
    public static class Edge { // Class Edge
        private int neighbor; // id of the neighbor (id of the destination node)
        private Edge next; // reference to the next "edge"

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    } // class Edge

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }


    /**
     * Print the adjacency list
     */
    public void printAdjacencyList() {
        for (int i = 0; i < graph.length; i++) {
            Edge curr = graph[i];
            // let's go through all the outgoing edges for vertex i
            while (curr != null) {
                System.out.println(i + ", " + curr.neighbor); // print each neighbor of i
                curr = curr.next;
            }
        }
    }

    /**
     * Return the number of vertices in the graph
     * @return number of vertices
     */
    public int getNumVertices() {
        return graph.length;
    }

    /**
     * Adds the given edge as an outgoing edge for the given vertex.
     * Modifies the adjacency list.
     *
     * @param vertexId id of the vertex
     * @param edge     outgoing edge
     *                 Do not modify.
     */
    public void addEdge(int vertexId, Edge edge) {
        Edge head = graph[vertexId]; // head of the linked list for this  node
        graph[vertexId] = edge; // insert in front
        if (head != null) {
            edge.next = head;
        }
    }


    /**
     * Print nodes that have no outgoing edges
     */
    public void printNodesWithoutOutgoingEdges() {
        // FILL IN CODE:

    }

    /**
     * Print all the vertices we can directly reach from a given vertex
     * by following outgoing edges
     * @param vertexId vertex
     */
    public void printNeighbors(int vertexId) {
       // FILL IN CODE:

    }

    /**
     * Print nodes that have no incoming edges from other nodes
     */
    public void printNodesWithoutIncomingEdges() {
        boolean[] hasIncoming = new boolean[graph.length]; // for each vertex id, stores true if this vertex id has at least one incoming edge, and false otherwise
       // FILL IN CODE:

    }


    /** A helper method for dfsMain - runs DFS once from the given source vertex
     *
     * @param vertex source vertex
     * @param visited an array, where for each vertex id we store true if it has been visited,
     * and false otherwise
     */
    void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex);
        // Iterate over outgoing edges of this vertex
        // For each edge, get the neighbor, and if it has not been visited, call dfs recursively on the neighbor
       // FILL IN CODE:

    }

    /**
     * Iterative DFS implementation that uses a stack.
     * @param vertex source vertex
     * @param visited array that stores true for each vertex id that has been visited
     */
    void dfsWithStack(int vertex, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex); // push the source vertex onto the stack
        while (!stack.isEmpty()) {
            // FILL IN CODE:
            // pop the vertex nextV from the stack, mark it as visited,
            // iterate over the neighbors of nextV,
            // if the neighbor has not been visited, push it onto the stack



        }

    }


    /** Runs dfs starting from each vertex that has not been visited.
     * Makes sure all vertices are visited (may involve running dfs several times).
     * If the graph is connected, it would be enough to run dfs once.
     */
    public void dfsMain() {
        boolean visited[]  = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                //dfs(i, visited);  // Could instead call dfsWithStack
                dfsWithStack(i, visited);

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
            // FILL IN CODE:
            // Dequeue and go over the neighbors.Add unvisited neighbors to the queue.
            // Decide when to mark vertices as visited.


        } // while queue is not empty
    }


    /** Runs BFS starting from every vertex that has not been visited.
     *
     */
    public void bfsMain() {
        boolean visited[]  = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                bfs(i, visited);
        }
    }
}


