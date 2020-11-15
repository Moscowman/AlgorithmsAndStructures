package AlgorithmsAndStructures.Lesson6;

import java.util.Random;

public class Test6 {

    public static void main(String[] args) {
//        testTree();
//        testRemoveElement();
        testTreeBalance();
    }

    private static void testTreeBalance() {
        final int TREE_DEPTH = 4;
        final int TREES_NO = 20;
        int noOfBalancedTrees = 0;
        Random random = new Random();
        TreeImpl[] trees = new TreeImpl[TREES_NO];
        for (int i = 0; i < TREES_NO; i++) {
            trees[i] = new TreeImpl<Integer>(TREE_DEPTH);
            for (int j = 0; j < Math.pow(2, TREE_DEPTH) - 1; j++) {
                trees[i].add(random.nextInt(201) - 100);
            }
            trees[i].display();
            if (trees[i].isBalanced()) {noOfBalancedTrees++;};
        }
        System.out.println("Сбалансировано " + noOfBalancedTrees * 100 / TREES_NO  + "% деревьев");
    }

    private static void testRemoveElement() {
        Tree<Integer> tree = new TreeImpl<>(100);
        tree.add(60);
        tree.add(25);
        tree.add(66);
        tree.add(15);
        tree.add(5);
        tree.add(20);
        tree.add(45);
        tree.add(30);
        tree.add(55);
        tree.add(32);

        tree.remove(25);
        tree.display();
    }

    private static void testTree() {
        Tree<Integer> tree = new TreeImpl<>(100);
        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(40);
        tree.add(55);
        tree.add(70);
        tree.add(31);
        tree.add(45);
        tree.add(67);
        tree.add(81);

        System.out.println("Find 70: " + tree.contains(70));
        System.out.println("Find 700: " + tree.contains(700));

        tree.display();
//        tree.traverse(Tree.TraverseMode.IN_ORDER, System.out::println);
//        tree.traverse(Tree.TraverseMode.PRE_ORDER, System.out::println);
//        tree.traverse(Tree.TraverseMode.POST_ORDER, System.out::println);
    }
}
