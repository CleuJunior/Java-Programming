public class DoublyLinkedList <T> {
    private Node<T> first = null;
    private Node<T> last = null;

    public void push(T value) { insert(value, true); }

    public T pop() {
        T back = last.getValue();
        last = last.getPrevious();
        first.setPrevious(last);

        return back;
    }

    public T shift() {
        T front = first.getValue();
        last.setNext(first.getNext());
        first = first.getNext();
        first.setPrevious(last);

        return front;
    }

    public void unshift(T value) { insert(value, false); }

    private void insert(T value, boolean atBack) {
        Node<T> node = new Node<>(value);
        if(first == null) {
            first = node;
            last = node;
            node.setPrevious(node);
            node.setNext(node);
        } else {
            node.setPrevious(last);
            node.setNext(first);
            last.setNext(node);
            first.setPrevious(node);
            if(atBack) last = node;
            else first = node;
        }
    }
}