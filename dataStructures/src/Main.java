import DS.*;

public class Main {
    public static void main(String[] args) {
//ABRAR MUBEEN
//ID_210042128
/*
Stack<Integer> Stack = new Stack<Integer>(5);
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

<<<<<<< HEAD
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

        //Rakin


        //linkedList<Integer> list = new linkedList<Integer>();


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

//        // implimentation addFirst(E element)
//        list.addFirst(0);
//
//        // implimentation addLast(E element)
//        list.addLast(5);
//
//        // implimentation duplicateRemoval()
//        list.duplicateRemoval();
//
        // implimentation merge(linkedList<E> list1, linkedList<E> list2)
//        linkedList<Integer> list1 = new linkedList<Integer>();
//        linkedList<Integer> list2 = new linkedList<Integer>();
//        list1.add(0, 1);
//        list1.add(1, 2);
//        list1.add(2, 3);
//        list2.add(0, 4);
//        list2.add(1, 5);
//        list2.add(2, 6);
//
//        list1.mergeList(list2);
//
//        list1.printList();
//
//        // implimentation printmergeList()
//        list1.merge(list1, list2);
//        list1.printList();

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
    

        //QUEUE
//          queue q = new queue(5);
//
//        //Adding element to queue
//
//        q.enqueue(1);
//        q.enqueue(2);
//        q.enqueue(3);
//        q.enqueue(4);
//        q.enqueue(5);
//        q.enqueue(6);
//        q.printQueue();


       //remove element from queue
       /* q.dequeue();

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
        //bst
//        BST<Integer> bst = new BST<Integer>();
//        bst.insert(5);
//        bst.insert(3);
//        bst.insert(7);
//        bst.insert(2);
//        bst.insert(4);
//        bst.insert(6);
//
//        bst.traverse(travarseTech.INORDER);
//        System.out.println();
//        bst.traverse(travarseTech.PREORDER);
//        System.out.println();
//        bst.traverse(travarseTech.POSTORDER);
//        System.out.println();
//        bst.traverse(travarseTech.LEVELORDER);
//        System.out.println();

        //delete node
//        bst.delete(new Node<Integer>(5));
//        bst.traverse(travarseTech.INORDER);

        //search node
//        System.out.println(bst.search(5));
//        System.out.println(bst.search(2));

        //get root
//        System.out.println(bst.getRoot().getData());

        //set root
//        bst.setRoot(new Node<Integer>(10));
//        System.out.println(bst.getRoot().getData());

        //node count
//          System.out.println(bst.nodeCount());

            //height
//          System.out.println(bst.height());

        //copy tree
//            BST<Integer> bst2 = bst.copy();
//            bst2.traverse(travarseTech.INORDER);
//            System.out.println();
//
//            //count nodes
//            System.out.println(bst.countNodes());
//            System.out.println(bst2.countNodes());
//
//            //isSubtree
//            System.out.println(bst.isSubtree(bst2));


//            //calculateDiameter
//            System.out.println(bst.calculateDiameter());
//
//            //height
//            System.out.println(bst.height());

//            //findLowestCommonAncesstor
//            System.out.println(bst.findLowestCommonAncestor(2, 4));


/*
        //avl
          AVL<Integer> avl = new AVL<Integer>();
            avl.insert(5);
            avl.insert(3);
            avl.insert(7);
            avl.insert(2);
            avl.insert(4);
            avl.insert(6);

            AVL<Integer> avl2 = new AVL<Integer>();

            avl2.insert(5);
            avl2.insert(3);
            avl2.insert(7);
            avl2.insert(2);
            avl2.insert(4);
            avl2.insert(6);
*/

//            avl.traverse(travarseTech.INORDER);
//            System.out.println();
//            avl.traverse(travarseTech.PREORDER);
//            System.out.println();
//            avl.traverse(travarseTech.POSTORDER);
//            System.out.println();
//            avl.traverse(travarseTech.LEVELORDER);
//            System.out.println();


  //            delete node
//            avl.delete(new Node<Integer>(5));
//            avl.traverse(travarseTech.INORDER);
//            System.out.println();
//            avl.traverse(travarseTech.LEVELORDER);
//            System.out.println();

        //search node
//        System.out.println(avl.search(5));
//
//        //get root
//        System.out.println(avl.getRoot().getData());
//
//            //set root
//            avl.setRoot(new Node<Integer>(10));
//            System.out.println(avl.getRoot().getData());

            //node count

//            System.out.println(avl.nodeCount());

                //height
//            System.out.println(avl.height());

            //node count

//            System.out.println(avl.nodeCount());
//
//                //minValueNode
//            System.out.println(avl.minValueNode(avl.getRoot()).getData());
//

//clone tree
//            AVL<Integer> avl2 = avl.cloneTree();
//            avl2.traverse(travarseTech.INORDER);
//            System.out.println();


        //findLowestCommonAncesstor
//            System.out.println(avl.findLCA(2, 4));

        //isSubtree
//            System.out.println(avl.isSubtree(avl2));
        //haspathsum
//            System.out.println(avl.hasPathSum(12));

        //calculateDiameter
//            System.out.println(avl.calculateDiameter());


    Graph graph=new Graph();
    Graph graph2=new Graph();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(3);
        graph2.addVertex(3);



    // Edge Operations
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(1, 5);



    // Print the graph
        graph.printGraph();
        graph2.printGraph();
        graph.BFS(2);
        graph.DFS(2);
        graph.hasCycle();
        graph.isSubgraph(graph2);
        graph.ShortestPath(2,4);





}

}