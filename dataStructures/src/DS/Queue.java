package DS;

public class Queue {

    /**
     * queue
     * @param <E>
     */
    public class queue<E> {
        //circular queue
        E queueContent[];
        int front = -1;
        int rear = -1;
        int capacity;

        /**
         * queue Constructor
         * @param capacity
         */
        public queue(int capacity){
            this.capacity = capacity;
            this.queueContent = (E[]) new Object[capacity];
        }

        /**
         * enqueue element to queue
         * @param element
         */
        public void enqueue(E element){
            if(front == -1 && rear == -1){
                front = 0;
                rear = 0;
                queueContent[rear] = element;
            }
            else if((rear + 1) % capacity == front){
                System.out.println("Queue is full");
            }
            else{
                rear = (rear + 1) % capacity;
                queueContent[rear] = element;
            }
        }

        /**
         * dequeue element from queue
         */
        public void dequeue(){
            if(front == -1 && rear == -1){
                System.out.println("Queue is empty");
            }
            else if(front == rear){
                front = -1;
                rear = -1;
            }
            else{
                front = (front + 1) % capacity;
            }
        }

        /**
         * get front element of queue
         * @return front element of queue
         */
        public E front(){
            if(front == -1 && rear == -1){
                System.out.println("Queue is empty");
                return null;
            }
            else{
                return queueContent[front];
            }
        }

        /**
         * get rear element of queue
         * @return rear element of queue
         */
        public boolean isEmpty(){
            if(front == -1 && rear == -1){
                return true;
            }
            else{
                return false;
            }
        }

        /**
         * get size of queue
         * @return size of queue
         */
        public int size(){
            if(front == -1 && rear == -1){
                return 0;
            }
            else if(front == rear){
                return 1;
            }
            else{
                return (capacity - front + rear + 1) % capacity;
            }
        }

        /**
         * print queue
         */
        public void printQueue(){
            if(front == -1 && rear == -1){
                System.out.println("Queue is empty");
            }
            else{
                for(int i = front; i != rear; i = (i + 1) % capacity){
                    System.out.println(queueContent[i]);
                }
                System.out.println(queueContent[rear]);
            }
        }

        /**
         * clear queue
         */
        public void clear(){
            front = -1;
            rear = -1;
        }
        /**
         * reverse queue
         */
        public void reverse() {
            if (front == -1 && rear == -1) {
                System.out.println("Queue is empty");
            } else {
                E temp;
                for (int i = front, j = rear; i < j; i = (i + 1) % capacity, j = (j - 1) % capacity) {
                    temp = queueContent[i];
                    queueContent[i] = queueContent[j];
                    queueContent[j] = temp;
                }
            }
        }
        /**
         * duplicate queue
         */
        public void duplicateQueue() {
            if (front == -1 && rear == -1) {
                System.out.println("Queue is empty");
            } else {
                E temp;
                for (int i = front, j = rear; i < j; i = (i + 1) % capacity, j = (j - 1) % capacity) {
                    temp = queueContent[i];
                    queueContent[i] = queueContent[j];
                    queueContent[j] = temp;
                }
            }
        }
        /**
         * search queue
         */
        public void search(E element) {
            if (front == -1 && rear == -1)
            {
                System.out.println("Queue is empty");
            }
            else
            {
                for (int i = front; i != rear; i = (i + 1) % capacity)
                {
                    if (queueContent[i] == element)
                    {
                        System.out.println("Element found at index " + i);
                        return;
                    }
                }
                if (queueContent[rear] == element)
                {
                    System.out.println("Element found at index " + rear);
                }
                else
                {
                    System.out.println("Element not found");
                }
            }
        }

    }
}
