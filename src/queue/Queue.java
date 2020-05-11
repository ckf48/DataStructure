package queue;

/**
 * @author ckf48
 */
public interface Queue<E> {
    void enqueue(E e);

    E dequeue();

    E getFront();

    boolean isEmpty();

    int getSize();
}
