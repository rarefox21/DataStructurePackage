package DS;
import java.util.*;
public class Vertex {
    public int id;
    public HashMap<Integer,Edge> edgeList;
    public Vertex neighbor;

    public Vertex(int id)
    {
        this.id=id;
        this.edgeList= new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void addEdge(Vertex neighbor) {
        this.neighbor = neighbor;
        edgeList.put(neighbor.getId(), new Edge(id, neighbor.getId()));
        neighbor.edgeList.put(id, new Edge(neighbor.id, id));


    }

    public void removeEdge(Vertex neighbor, int neighborID)
    {
        this.neighbor=neighbor;
        edgeList.remove(neighborID);
        neighbor.edgeList.remove(id);

    }

    public Collection<Edge> getEdges()
    {
        return edgeList.values();
    }

    public int getDegree() {
        return edgeList.size();
    }
}
