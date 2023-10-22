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
    public void push(T value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            top++;
            stackArray[top] = value;
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");

        } else {
            top--;
        }
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
            int index = top - n;
            return (T) stackArray[index];
        }
    }

    public int size() {
        return top + 1;
    }

    public void duplicateStack(){
        Stack<T> tempStack = new Stack<T>(maxSize);
        while(!isEmpty()){
            tempStack.push(peek());
            pop();
        }
        while(!tempStack.isEmpty()){
            T temp = tempStack.peek();
            pop();
            push(temp);
            tempStack.push(temp);
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

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
