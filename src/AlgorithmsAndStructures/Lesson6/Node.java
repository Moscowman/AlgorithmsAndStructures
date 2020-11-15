package AlgorithmsAndStructures.Lesson6;

public class Node<T extends Comparable<? super T>> {

    private final T value;

    private Node<T> leftChild;
    private Node<T> rightChild;

    public int getDepth() {
        return depth;
    }

    private int depth;

    public Node(T value) {
        this.value = value;
        this.depth = 0;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
        leftChild.depth = depth + 1;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
        rightChild.depth = depth + 1;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public void addChild(Node<T> child) {
        if (child == null) {
            return;
        }
        if (isRightChild(child.getValue())) {
            setRightChild(child);
        } else {
            setLeftChild(child);
        }
    }

    public boolean isRightChild(T value) {
        return value.compareTo(this.value) > 0;
    }

    public boolean hasOnlyOneChild() {
        return leftChild == null ^ rightChild == null;
    }
}
