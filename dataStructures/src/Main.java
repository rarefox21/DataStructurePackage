import DS.*;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> Stack = new Stack<Integer>(5);
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

       // Stack.pop();
        System.out.println("Peek: " + Stack.peek());
        System.out.println("Peek th: " + Stack.peekNth(0));
        System.out.println("Stack size: " + Stack.size());
        System.out.println("Is empty? " + Stack.isEmpty());
       // System.out.println("\nAfter popping out");
        Stack.printStack();
        Stack.duplicateStack();



    }
}