package DS;


public class linkedList<E> {
    private listNode<E> head;
    private listNode<E> tail;
    private int size;

    /**
     * linkedList Constructor
     */
    public linkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * print linked list
     */
    public void printList(){
        listNode<E> currentNode = this.head;
        while(currentNode != null){
            currentNode.printNode();
            currentNode = currentNode.getNext();
        }
    }

    /**
     * Add element to the first of linked list
     */
    public void addFirst(E element){
        listNode<E> newNode = new listNode<E>(element);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    /**
     * Add element to the last of linked list
     */
    public void addLast(E element){
        listNode<E> newNode = new listNode<E>(element);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    /**
     * Add element to the index of linked list
     */
    public void add(int index, E element){
        if(index < 0 || index > this.size){
            System.out.println("Index out of bound");
        }
        else if(index == 0){
            this.addFirst(element);
        }
        else if(index == this.size){
            this.addLast(element);
        }
        else{
            listNode<E> newNode = new listNode<E>(element);
            listNode<E> currentNode = this.head;
            for(int i = 0; i < index - 1; i++){
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            this.size++;
        }
    }

    /**
     * Remove first element of linked list
     */
    public void removeFirst(){
        if(this.head == null){
            System.out.println("List is empty");
        }
        else{
            this.head = this.head.getNext();
            this.size--;
        }
    }

    /**
     * Remove last element of linked list
     */
    public void removeLast(){
        if(this.head == null){
            System.out.println("List is empty");
        }
        else if(this.head == this.tail){
            this.head = null;
            this.tail = null;
            this.size--;
        }
        else{
            listNode<E> currentNode = this.head;
            for(int i = 0; i < this.size - 2; i++){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
            this.tail = currentNode;
            this.size--;
        }
    }

    /**
     * Remove element at index of linked list
     */
    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            System.out.println("Index out of bound");
        } else if (index == 0) {
            this.removeFirst();
        } else if (index == this.size - 1) {
            this.removeLast();
        } else {
            listNode<E> currentNode = this.head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
            this.size--;
        }
    }
    /**
     * Traversal: visit each node exactly once
     */
    public void traversal() {
        listNode<E> currentNode = this.head;
        while (currentNode != null) {
            currentNode.printNode();
            currentNode = currentNode.getNext();
        }

    }
    /**
     * Search: find a particular node containing a given key
     */
    public listNode<E> search(E key) {
        listNode<E> currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getData() == key) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }
    /**
     * Reversal: reverse the order of the nodes
     */
    public void reversal() {
        listNode<E> currentNode = this.head;
        listNode<E> previousNode = null;
        listNode<E> nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
        this.head = previousNode;
    }
    /**
     * Duplicate Removal: remove all duplicate nodes
     */

    public void duplicateRemoval() {
        listNode<E> currentNode = this.head;
        listNode<E> nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.getNext();
            while (nextNode != null && currentNode.getData() == nextNode.getData()) {
                nextNode = nextNode.getNext();
            }
            currentNode.setNext(nextNode);
            currentNode = nextNode;
        }
    }
    /**
     * Merge: merge two  linked lists into one linked list
     */
    public void merge(linkedList<E> list1, linkedList<E> list2) {
        listNode<E> currentNode = list1.head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(list2.head);
        this.head = list1.head;
        this.tail = list2.tail;
        this.size = list1.size + list2.size;
    }





}
