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

    //Add element to the top of the stack
    public void push(T value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            System.out.println("Inserting :" + value);
            top++;
            stackArray[top] = value;
        }
    }

    //Remove element from the top of the stack
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        }
        return stackArray[top--];
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return (T) stackArray[top];
        }
    }

    public T peekNth(int n) {
        if (isEmpty() || n < 0 || n > top) {
            System.out.println("Invalid operation: Stack is empty or N is out of range");
            return null;
        } else {
            int index = top-n;
            return (T) stackArray[index];
        }
    }

    public int size() {

        return top + 1;
    }

    public void duplicateStack() {
        Stack<T> tempStack = new Stack<>(maxSize);

        // Copy elements from the original stack to the temporary stack
        while (!isEmpty()) {
            //tempStack.push(peek()); // Push the element to tempStack
            tempStack.push(peek());
            pop();
            //show tempStack
            // System.out.println("tempStack: " + tempStack.peek());

        }
        //System.out.println("tempStack : ");
        while (!isEmpty()) {
           System.out.println("tempStack: " + tempStack.peek());
        }
      //  System.out.println("tempStack: " + tempStack.peek());

        /* Copy elements back to the original stack while maintaining the order
        while (!tempStack.isEmpty()) {
            T temp = tempStack.peek(); // Pop from tempStack
            tempStack.pop();
            push(temp); // Push onto the original stack
        }
         */
    }

    public void mergeStack() {
        Stack<T> tempStack = new Stack<T>(maxSize);
        while (!isEmpty()) {
            tempStack.push(peek());
            pop();
        }
        while (!tempStack.isEmpty()) {
            push(tempStack.peek());
            tempStack.pop();
        }
    }

    public boolean isEmpty() {

        return (top == -1);
    }

    public boolean isFull() {

        return (top == maxSize - 1);
    }

    public void printStack() {
        System.out.println("The Stack is: ");
        for (int i = 0; i <= top; i++) {
            System.out.println(stackArray[i]);
        }
    }
}
