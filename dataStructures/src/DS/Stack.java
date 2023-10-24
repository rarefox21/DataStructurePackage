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

    /**
     * Push an element to the top of the stack
     * @param value
     */
    public void push(T value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            top++;
            stackArray[top] = value;
        }
    }

    /**
     * Pop an element from the top of the stack
     */
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            top--;
        }
    }

    /**
     * Peek the top element of the stack
     * @return top element of the stack
     */
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return (T) stackArray[top];
        }
    }

    /**
     * Peek the Nth element of the stack
     * @param n
     * @return Nth element of the stack
     */
    public T peekNth(int n) {
        if (isEmpty() || n < 0 || n > top) {
            System.out.println("Invalid operation: Stack is empty or N is out of range");
            return null;
        } else {
            int index = top - n;
            return (T) stackArray[index];
        }
    }

    /**
     * Display the stack
     * @return size of the stack
     */
    public int size() {
        return top + 1;
    }

    /**
     * Display the stack
     */
    public void duplicateStack() {
        Stack<T> tempStack = new Stack<>(maxSize);

        // Copy elements from the original stack to the temporary stack
        while (!isEmpty()) {
            T temp = peek();
            pop();
            tempStack.push(temp);
        }

        // Copy elements back to the original stack while maintaining the order
        while (!tempStack.isEmpty()) {
            T temp = tempStack.peek(); // Pop from tempStack
            tempStack.pop();
            push(temp); // Push onto the original stack
        }
    }

    /**
     * Merge the stack
     */

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

    /**
     * Reverse the stack
     * @return is empty
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Check if the stack is full
     * @return is full
     */
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
