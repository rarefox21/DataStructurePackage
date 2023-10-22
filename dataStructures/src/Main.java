import DS.*;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> Stack = new Stack<Integer>(5);
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);

        System.out.println("Peek: " + Stack.peek());
        Stack.pop();
        System.out.println("Peek: " + Stack.peek());
        System.out.println("Stack size: " + Stack.size());
        System.out.println("Is empty? " + Stack.isEmpty());
        Stack.duplicateStack();

    }
}