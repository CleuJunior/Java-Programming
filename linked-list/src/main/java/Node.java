class Node <T> {
    private final T VALUE;
    private Node<T> previous;
    private Node<T> next;

    public Node(final T value) { this.VALUE = value; }

    public T getValue() { return VALUE; }

    public void setPrevious(final Node<T> previous) { this.previous = previous; }

    public Node<T> getPrevious() { return previous; }

    public void setNext(final Node<T> next) { this.next = next; }

    public Node<T> getNext() { return next; }
}