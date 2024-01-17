package DS;

public class DoublyLinkedList {
    public DoublyNode head;
    public DoublyNode tail;
    public int length;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void insertAtHead(int data){
        DoublyNode newNode = new DoublyNode(data);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else{
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head = newNode;
        }
        this.length++;
    }

    public void insertAtTail(int data){
        DoublyNode newNode = new DoublyNode(data);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            this.tail = newNode;
        }
        this.length++;
    }

    public void insertAt(int data, int index){
        if(index < 0 || index > this.length){
            System.out.println("Invalid index");
            return;
        }
        if(index == 0){
            this.insertAtHead(data);
            return;
        }
        if(index == this.length){
            this.insertAtTail(data);
            return;
        }
        DoublyNode newNode = new DoublyNode(data);
        DoublyNode temp = this.head;
        for(int i = 0; i < index - 1; i++){
            temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        newNode.setPrev(temp);
        temp.getNext().setPrev(newNode);
        temp.setNext(newNode);
        this.length++;
    }

    public void deleteAtHead(){
        if(this.head == null){
            System.out.println("List is empty");
            return;
        }
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        }else{
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }
        this.length--;
    }

    public void deleteAtTail(){
        if(this.head == null){
            System.out.println("List is empty");
            return;
        }
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        }else{
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }
        this.length--;
    }

    public void deleteAt(int index){
        if(index < 0 || index >= this.length){
            System.out.println("Invalid index");
            return;
        }
        if(index == 0){
            this.deleteAtHead();
            return;
        }
        if(index == this.length - 1){
            this.deleteAtTail();
            return;
        }
        DoublyNode temp = this.head;
        for(int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
        this.length--;
    }

    /**
     * Print all elements of linked list
     *
     * @return
     */

    public void printList() {
        DoublyNode currentNode = this.head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    /**
     * insert element at index of linked list
     *
     * @param data
     * @param index
     */

    public void insert(int data, int index) {
        DoublyNode newNode = new DoublyNode(data);

        if (head == null) {
            if (index != 0) {
                return;
            } else {
                head = newNode;
            }
        }

        if (head != null && index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        DoublyNode current = head;
        int i = 0;

        while (current != null) {
            if (i + 1 == index) {
                if (current.next != null) {
                    newNode.next = current.next;
                    newNode.next.prev = newNode;
                }

                current.next = newNode;
                newNode.prev = current;
                break;
            }

            current = current.next;
            i++;
        }
    }


    /**
     * delete element at index of linked list
     *
     * @param index
     */

    public void delete(int index) {
        if (head == null) {
            return;
        }

        DoublyNode current = head;
        int i = 0;

        while (current != null) {
            if (i == index) {
                if (current.next != null) {
                    current.next.prev = current.prev;
                }

                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
            }

            current = current.next;
            i++;
        }

    }

    /**
     * traverse linked list
     * Time complexity O(n)
     * Space complexity O(1)
     * @return
     * @throws Exception
     */

    public void traverse() {
        DoublyNode current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    /**
     * search element in linked list
     * Time complexity O(n)
     * Space complexity O(1)
     * @param data
     * @return
     * @throws Exception
     */

    public boolean search(int data) {
        DoublyNode current = head;

        while (current != null) {
            if (current.data == data) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    /**
     * reverse linked list
     * Time complexity O(n)
     * Space complexity O(1)
     * @throws Exception
     */

    public void reverse() {
        DoublyNode current = head;
        DoublyNode temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    /**
     * remove duplicate elements from linked list
     * Time complexity O(n)
     * Space complexity O(1)
     * @throws Exception
     */

    public void removeDuplicates() {
        DoublyNode current = head;
        DoublyNode temp = null;

        while (current != null) {
            temp = current.next;

            while (temp != null) {
                if (current.data == temp.data) {
                    temp.prev.next = temp.next;

                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                }

                temp = temp.next;
            }

            current = current.next;
        }
    }

    /**
     * merge two linked list
     * Time complexity O(n)
     * Space complexity O(1)
     * @param list
     * @throws Exception
     */

    public void merge(DoublyLinkedList list) {
        DoublyNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = list.head;
        list.head.prev = current;
    }






}
