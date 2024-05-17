class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    public T removeLast() {
        if (tail.prev == head) {
            return null;
        }
        Node<T> lastNode = tail.prev;
        lastNode.prev.next = tail;
        tail.prev = lastNode.prev;
        return lastNode.value;
    }

    public void remove(T value) {
        Node<T> current = head.next;
        while (current != tail) {
            if (current.value.equals(value)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                break;
            }
            current = current.next;
        }
    }

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
