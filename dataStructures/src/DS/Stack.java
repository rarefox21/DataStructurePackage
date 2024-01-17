package DS;

public class Stack<T> {
    private Integer maxSize;
    private T[] stackArray;
    private int top;

    public Stack(Integer maxSize) {
        this.maxSize = maxSize;
        this.stackArray = (T[]) new Object[maxSize];
        this.top = -1;
    }
    //ADDING ELEMENTS TO THE STACK
    public void push(T value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            System.out.println("Inserting " + value);
            stackArray[++top] = value;
        }
    }

    //REMOVING ELEMENTS FROM THE STACK
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            top--;
        }
    }

    //PEEKING AT THE TOP OF THE STACK
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return (T) stackArray[top];
        }
    }

    //PEEKING AT THE Nth ELEMENT FROM THE TOP OF THE STACK
    public T peekNth(int n) {
        if (isEmpty() || n < 0 || n > top) {
            System.out.println("Invalid operation: Stack is empty or N is out of range");
            return null;
        } else {
            int index = top - n;
            return (T) stackArray[index];
        }
    }

    //GETTING THE SIZE OF THE STACK
    public int size() {
        return top + 1;
    }

    //DUPLICATING THE STACK
    public void duplicateStack() {
        Stack<T> tempStack = new Stack<>(maxSize);

        // Copy elements from the original stack to the temporary stack
        while (!isEmpty()) {
            T temp = peek();
            pop();
            tempStack.push(temp);
        }

        // Copy elements back to the original stack while maintaining the order
        System.out.println("Duplicating stack :");
        while (!tempStack.isEmpty()) {
            T temp = tempStack.peek(); // Pop from tempStack
            tempStack.pop();
            push(temp); // Push onto the original stack
        }
    }

    public void mergeStack(){
        Stack<T> tempStack = new Stack<T>(maxSize);
        while(!isEmpty()){
            tempStack.push(peek());
            pop();
        }
        while(!tempStack.isEmpty()){
            push(tempStack.peek());
            tempStack.pop();
        }
    }

    //CHECKING IF THE STACK IS EMPTY
    public boolean isEmpty() {
        return (top == -1);
    }

   //CHECKING IF THE STACK IS FULL
    public boolean isFull() {
        return (top == maxSize - 1);
    }
<<<<<<< HEAD

=======
    
>>>>>>> e1e11a9bab708d3ff1115c35f082fa16b2afa130
    //Print stack
    public void printStack() {
        System.out.println("THE STACK IS: ");
        for (int i = 0; i <= top; i++) {
            System.out.println(stackArray[i]);
        }
    }
}
