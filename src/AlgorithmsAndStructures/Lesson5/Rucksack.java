package AlgorithmsAndStructures.Lesson5;

import java.util.*;

public class Rucksack {

    int w;
    private Item[] currentItems;
    private ArrayList<ArrayList<Item>> items;

    public Rucksack(int w, Item[] items) {
        this.w = w;
        this.items = new ArrayList<>();
        this.currentItems = Arrays.copyOf(items, items.length);
    }

    public static void main(String[] args) {
        Rucksack rucksackApp = new Rucksack(100,
                new Item[]{new Item(1, 100),
                new Item(6, 4),
                new Item(9, 9)});
        ArrayList<ArrayList<Item>> items = rucksackApp.getRucksack();
        System.out.println(items.size());
        for (ArrayList<Item> item : items) {
            System.out.println(item);
        }
    }

    private ArrayList<ArrayList<Item>> getRucksack() {
        items.clear();
        processRucksack(currentItems.length);
        return items;
    }

    private void processRucksack(int length) {
        if (length == 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            processRucksack(length - 1);
            items.add(new ArrayList<>(Arrays.asList(currentItems)));
            rotate(length);
        }
    }

    private void rotate(int length) {
        int pos = items.size() - length;
        Item temp = currentItems[pos];
        for (int i = pos + 1; i < currentItems.length; i++) {
            currentItems[i - 1] = currentItems[i];
        }
        currentItems[currentItems.length - 1] = temp;
    }
}
