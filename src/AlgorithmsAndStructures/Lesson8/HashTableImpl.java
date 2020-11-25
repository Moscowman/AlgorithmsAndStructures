package AlgorithmsAndStructures.Lesson8;

import java.util.ArrayList;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private final int maxSize;

    static class Node<K, V> implements Entry<K, V> {

        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    private final ArrayList<Node>[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new ArrayList[this.maxSize * 2];
        for (int i = 0; i < data.length; i++) {
            data[i] = new ArrayList<>();
        }
    }

    @Override
    public boolean put(K key, V value) {
        int index = hash(key);

        if (size == maxSize) {
            return false;
        }

        data[index].add(new Node<>(key, value));
        size++;
        return false;
    }

    protected int getStep(K key) {
        return 1;
    }

    private int hash(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public V get(K key) {
        int[] index = indexOf(key);
        return index[0] == -1 ? null : (V) data[index[0]].get(index[1]).getValue();
    }

    private int[] indexOf(K key) {
        int index = hash(key);
        for (int i = 0; i < data[index].size(); i++) {
            Node node = data[index].get(i);
            if (node.getKey().equals(key)) {
                return new int[] {index, i};
            }
        }

        return new int[] {-1};
    }

    @Override
    public V remove(K key) {
        int[] index = indexOf(key);
        if (index[0] == -1) {
            return null;
        }

        Node<K, V> node = data[index[0]].get(index[1]);
        data[index[0]].remove(index[1]);
        size--;
        return node.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
        }
        System.out.println("----------");
    }
}
