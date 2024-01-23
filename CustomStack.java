import java.util.LinkedList;

public class CustomStack<T> {
    private LinkedList<T> stack;

    public CustomStack() {
        this.stack = new LinkedList<>();
    }

    public void push(T value) {
        stack.push(value);
    }

    public T pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
