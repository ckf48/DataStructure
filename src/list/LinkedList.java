package list;

/**
 * @author ckf48
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;

    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public Node getHead() {
        return dummyHead.next;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        dummyHead.next = new Node(e, dummyHead);
//        size++;
        add(0, e);
    }

    //在链表中插入一个元素（练习思维用）
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        Node previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }

//            Node node = new Node(e);
//            node.next = previous.next;
//            previous.next = node;
        previous.next = new Node(e, previous.next);
        size++;

    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        Node previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }
        Node retNode = previous.next;
        previous.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    public boolean contain(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node current = dummyHead.next;
        while (current != null) {
            res.append(current).append("->");
            current = current.next;
        }
        res.append("null");
        return res.toString();
    }
}
