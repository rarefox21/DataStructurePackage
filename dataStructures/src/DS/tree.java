package DS;

public interface tree<T extends Comparable<T>> {
    public void insert(T data);
    public void delete(Node<T> data);
    public void traverse(travarseTech tech);
    public T search(T data);
    public Node<T> getRoot();
    public void setRoot(Node<T> root);
    public int nodeCount();
    public int height();
}
