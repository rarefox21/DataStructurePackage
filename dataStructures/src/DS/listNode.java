package DS;

public class listNode<E> {
    public E data;
    public listNode<E> next;

    public listNode(E data){
        this.data = data;
        this.next = null;
    }

    public void setData(E data){
        this.data = data;
    }

    public E getData(){
        return this.data;
    }

    public void setNext(listNode<E> next){
        this.next = next;
    }

    public listNode<E> getNext(){
        return this.next;
    }

    public void printNode(){
        System.out.println(this.data);
    }

}

