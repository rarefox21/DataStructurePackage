import DS.*;

public class Main {
    public static void main(String[] args) {

   /*     Stack<Integer> Stack = new Stack<Integer>(5);
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);
        //Stack.pop();
        System.out.println("Peek: " + Stack.peek());
        System.out.println("Peek Nth: " + Stack.peekNth(2));
        System.out.println("Stack size: " + Stack.size());
        System.out.println("Is empty? " + Stack.isEmpty());
        System.out.println("Is full? " + Stack.isFull());
        Stack.printStack();
        Stack.duplicateStack();
       // Stack.mergeStack();
       */

/*
        queue q = new queue(5);

        //Adding element to queue

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);

       //remove element from queue
        q.dequeue();

        // size of queue
        System.out.println("Size of queue = " + q.size());

        //front element of queue
        System.out.println("Front element of queue = " + q.front());

        //queue is empty or not
        System.out.println("Queue is empty ? " + q.isEmpty());

        q.search(5);

        q.printQueue();

        //  q.clear();
        //print duplicate queue
       // q.duplicateQueue();
       // q.reverse();
       */
        Heap heap = new Heap(10);

        // Insert elements
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        // Print heap after insertion
        System.out.println("Heap after insertion:");
        for (int i = 0; i < heap.size; i++) {
            System.out.println(heap.heap[i]);
        }

        // Print max and min elements
        System.out.println("Max element: " + heap.maxElement());
        System.out.println("Min element: " + heap.minElement());

        // Delete root
        heap.delete(0);

        // Print heap after deletion
        System.out.println("Heap after deletion:");
        for (int i = 0; i < heap.size; i++) {
            System.out.println(heap.heap[i]);
        }
        // Print max and min elements
        System.out.println("Max element: " + heap.maxElement());
        System.out.println("Min element: " + heap.minElement());

        // Heapify a new array
        int[] newArray = {20, 15, 30, 25, 35};
        heap.heapify(newArray);

        // Print heap after heapify
        System.out.println("Heap after heapify:");
        for (int i = 0; i < heap.size; i++) {
            System.out.println(heap.heap[i]);
        }

        // Heap sort
        heap.heapSort();

        // Print heap after sort
        System.out.println("Heap after sort:");
        for (int i = 0; i < heap.size; i++) {
            System.out.println(heap.heap[i]);
        }

    }
}