package mylist;

class Node<V> {
    V head;
    Node<V> tail;

    public Node(V value) {
        this.head = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
