package AlgorithmsAndStructures.Lesson6;

import java.util.function.Consumer;

public interface Tree<E extends Comparable<? super E>> {

    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER,
    }

    boolean add(E value);

    boolean contains(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    boolean isBalanced();

    void traverse(TraverseMode mode, Consumer<E> action);

    void display();

}
