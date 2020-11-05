package AlgorithmsAndStructures.Lesson3;

public interface Deque<E> {

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();

    E peekLeft();

    E peekRight();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    boolean isFull();
}
