import DS.*;

public class Main {
    public static void main(String[] args) {

//        Stack<Integer> Stack = new Stack<Integer>(5);
//        Stack.push(1);
//        Stack.push(2);
//        Stack.push(3);
//
//        System.out.println("Peek: " + Stack.peek());
//        Stack.pop();
//        System.out.println("Peek: " + Stack.peek());
//        System.out.println("Stack size: " + Stack.size());
//        System.out.println("Is empty? " + Stack.isEmpty());
//        Stack.duplicateStack();





        //Rakin
        //linkedList<Integer> list = new linkedList<Integer>();

        // implimentation add(int index, E element)
//        list.add(0, 1);
//        list.add(1, 2);
//        list.add(2, 3);
//        list.add(3, 4);


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
        linkedList<Integer> list1 = new linkedList<Integer>();
        linkedList<Integer> list2 = new linkedList<Integer>();
        list1.add(0, 1);
        list1.add(1, 2);
        list1.add(2, 3);
        list2.add(0, 4);
        list2.add(1, 5);
        list2.add(2, 6);

        list1.mergeList(list2);

        list1.printList();
//
//        // implimentation printmergeList()
//        list1.merge(list1, list2);
//        list1.printList();


//          // implimentation remove(int index)
//        list.remove(1);

//        // implimentation removeFirst()
//        list.removeFirst();

//          // implimentation removeLast()
//        list.removeLast();


//        // implimentation reversal()
//        list.reversal();

        // implimentation search(E key)
//        if(list.search(100) == true){
//            System.out.println("Found");
//        }
//        else{
//            System.out.println("Not Found");
        //}


//        // implimentation traversal()
//        list.traversal();


//
//        // implimentation remove(int index)
//        list.remove(1);

        // implimentation printList()
//       list1.printList();







    }
}