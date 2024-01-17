package DS;

public class DoublyNode {
    public int data;
    public DoublyNode next;
    public DoublyNode prev;

    public DoublyNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return this.data;
    }

    public void setNext(DoublyNode next){
        this.next = next;
    }

    public DoublyNode getNext(){
        return this.next;
    }

    public void setPrev(DoublyNode prev){
        this.prev = prev;
    }

    public DoublyNode getPrev(){
        return this.prev;
    }

    public void printNode(){
        System.out.println(this.data);
    }
}
