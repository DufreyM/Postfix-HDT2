public class CustomStack <T>{
    private Node<T> lastNode;
    private Node<T> firstNode;

    public void push(T value){
        if(lastNode == null){
            lastNode = new Node<T>(value);
            firstNode = lastNode;
        } else{
            Node<T> current = new Node<T>(value);
            current.setNext(firstNode);
            firstNode = current;
        }
    }

    public T pop(){
        if(firstNode != null){
            Node<T> current = firstNode;
            firstNode = firstNode.getNext();
            return current.getValue();
        } else{
            return firstNode.getValue();
        }

    }
}
