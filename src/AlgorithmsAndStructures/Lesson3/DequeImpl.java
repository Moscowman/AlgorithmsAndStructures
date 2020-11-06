package AlgorithmsAndStructures.Lesson3;

public class DequeImpl<E> implements Deque<E> {

    private static final int DEFAULT_TAIL = -1;
    private static final int DEFAULT_HEAD = 0;

    protected E[] data;
    protected int size;

    private int tail;
    private int head;

    public DequeImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = DEFAULT_TAIL;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }
        head--;
        if (head < DEFAULT_HEAD) {
            head = data.length - 1;
        }

        data[head] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }

        if (tail == DEFAULT_TAIL) {
            tail = data.length - 1;
        }

        E removedValue = data[tail--];
        size--;
        return removedValue;
    }

    @Override // O(1)
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }

        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        E removedValue = data[head++];
        size--;
        return removedValue;
    }

    @Override
    public E peekLeft() {
        return data[head];
    }

    @Override
    public E peekRight() {return data[tail];}

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return data.length == size;
    }
}
