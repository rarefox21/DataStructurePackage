package DS;
import java.util.*;
import java.util.Stack;

public class Graph {
    public HashMap<Integer, Vertex> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(int vertexID) //adds vertex to the graph
    {
        vertices.put(vertexID, new Vertex(vertexID));   //adds vertex to the hashMap via vertexID as the key
    }

    public void removeVertex(int vertexID) {
        Vertex removedVertex = vertices.remove(vertexID);
        for (Vertex vertex : vertices.values()) {
            vertex.removeEdge(removedVertex, vertexID);
        }
    }

    public void addEdge(int vertexId1, int vertexId2) {
        Vertex vertex1 = vertices.get(vertexId1);
        Vertex vertex2 = vertices.get(vertexId2);

        if (vertex1 != null && vertex2 != null) {
            vertex1.addEdge(vertex2);
            vertex2.addEdge(vertex1);
        }
    }

    public void removeEdge(int vertexId1, int vertexId2) {
        Vertex vertex1 = vertices.get(vertexId1);
        Vertex vertex2 = vertices.get(vertexId2);

        if (vertex1 != null && vertex2 != null) {
            vertex1.removeEdge(vertex2, vertexId2);
            vertex2.removeEdge(vertex1, vertexId1);
        }
    }

    public void printGraph() {
        for (Vertex vertex : vertices.values()) {
            System.out.printf(vertex.id + "->");
            List<Edge> edges = new ArrayList<>(vertex.getEdges());
            for (int i = 0; i < edges.size(); i++) {
                System.out.printf("%d", edges.get(i).getVertex2());
                if (i < edges.size() - 1) {
                    System.out.printf(",");
                }
            }
            System.out.println();
        }
    }

    public void BFS(int startVertexId) {
        Vertex startVertex = vertices.get(startVertexId);
        if (startVertex == null) {
            System.out.println("Vertex Not Found");
            return;
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        queue.add(startVertex);
        visited.add(startVertexId);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            System.out.printf("%d ", currentVertex.getId());
            for (Edge edges : currentVertex.getEdges()) {
                Vertex neighbor = vertices.get(edges.getVertex2());
                if (neighbor != null && !visited.contains(neighbor.getId())) {
                    queue.add(neighbor);
                    visited.add(neighbor.getId());
                }
            }
        }
        System.out.println();
    }

    public void DFS(int startVertexId) {
        Vertex startVertex = vertices.get(startVertexId);
        if (startVertex == null) {
            System.out.println("Vertex Not Found");
            return;
        }
        Set<Integer> visited = new HashSet<>();
        java.util.Stack<Vertex> stack = new Stack<>();

        stack.add(startVertex);
        visited.add(startVertexId);

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();
            System.out.printf("%d ", currentVertex.getId());
            for (Edge edges : currentVertex.getEdges()) {
                Vertex neighbor = vertices.get(edges.getVertex2());
                if (neighbor != null && !visited.contains(neighbor.getId())) {
                    stack.add(neighbor);
                    visited.add(neighbor.getId());
                }
            }
        }
        System.out.println();
    }

    public void ShortestPath(int startVertexId, int endVertexId) {
        Vertex startVertex = vertices.get(startVertexId);
        Vertex endVertex = vertices.get(endVertexId);

        if (startVertex == null || endVertex == null) {
            System.out.println("Vertex not found.");
            return;
        }

        Map<Vertex, Vertex> parentMap = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertexId);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex == endVertex) {
                List<Integer> path = reconstructPath(parentMap, startVertex, endVertex);
                System.out.print("Shortest Path: ");
                printPath(path);
                System.out.println("Length: " + (path.size() - 1));
                return;
            }

            for (Edge edge : currentVertex.getEdges()) {
                Vertex neighbor = vertices.get(edge.getVertex2());
                if (neighbor != null && !visited.contains(neighbor.getId())) {
                    queue.add(neighbor);
                    visited.add(neighbor.getId());
                    parentMap.put(neighbor, currentVertex);
                }
            }
        }

        System.out.println("No path found between the given vertices.");
    }

    private List<Integer> reconstructPath(Map<Vertex, Vertex> parentMap, Vertex startVertex, Vertex endVertex) {
        List<Integer> path = new ArrayList<>();
        Vertex currentVertex = endVertex;

        while (currentVertex != null) {
            path.add(currentVertex.getId());
            currentVertex = parentMap.get(currentVertex);
        }

        Collections.reverse(path);
        return path;
    }
    private void printPath(List<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }


    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        boolean hasCycle = false;

        for (Vertex vertex : vertices.values()) {
            if (!visited.contains(vertex.getId()) && hasCycleDFS(vertex, -1, visited)) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            System.out.println("Has Cycle");
        } else {
            System.out.println("Does not have Cycle");
        }

        return hasCycle;
    }

    private boolean hasCycleDFS(Vertex currentVertex, int parent, Set<Integer> visited) {
        visited.add(currentVertex.getId());

        for (Edge edge : currentVertex.getEdges()) {
            int neighborId = edge.getVertex2();
            if (!visited.contains(neighborId)) {
                if (hasCycleDFS(vertices.get(neighborId), currentVertex.getId(), visited)) {
                    return true;
                }
            } else if (neighborId != parent) {
                return true;
            }
        }

        return false;
    }

    public boolean isSubgraph(Graph subgraph) {
        for (Vertex subgraphVertex : subgraph.vertices.values()) {
            if (!this.vertices.containsKey(subgraphVertex.getId())) {
                System.out.println("Not a Subgraph");
                return false;
            }
            for (Edge subgraphEdge : subgraphVertex.getEdges()) {
                Vertex mainGraphVertex = this.vertices.get(subgraphVertex.getId());
                if (mainGraphVertex == null || !mainGraphVertex.getEdges().contains(subgraphEdge)) {
                    System.out.println("Not a Subgraph");
                    return false;
                }
            }
        }
        System.out.println("Is a Subgraph");
        return true;
    }
}
