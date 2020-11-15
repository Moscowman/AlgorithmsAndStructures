package AlgorithmsAndStructures.Lesson5;

import java.util.*;

public class Rucksack {

    int w;
    private ArrayList<Item> bestItems;
    private ArrayList<Item> currentItems;
    private ArrayList<Item> items;
    int currentValue;
    int currentWeight;
    int bestValue;

    public Rucksack(int w, Item[] items) {
        this.w = w;
        this.items = new ArrayList<>(Arrays.asList(items));
        bestItems = new ArrayList<>();
        currentItems = new ArrayList<>();
    }

    public static void main(String[] args) {
        Rucksack rucksackApp = new Rucksack(10,
                new Item[]{new Item(1, 100),
                        new Item(6, 4),
                        new Item(9, 9),
                        new Item(3, 20)});
        ArrayList<Item> items = rucksackApp.getRucksack();
        System.out.println(items.size());
        for (Item item : items) {
            System.out.println(item.getWeight() + " " + item.getPrice());
        }
    }

    private ArrayList<Item> getRucksack() {
        bestItems.clear();
        currentItems.clear();
        currentValue = 0;
        bestValue = 0;
        currentWeight = 0;
        processRucksack(0);
        return bestItems;
    }

    private void processRucksack(int position) {
        if (position >= items.size()) {
            return;
        }
        processRucksack(position + 1);
        Item currentItem = items.get(position);
        int currentItemPrice = currentItem.getPrice();
        int currentItemWeight = currentItem.getWeight();
        if (currentItemWeight + currentWeight > w) {
            return;
        }
        currentItems.add(currentItem);
        currentValue += currentItemPrice;
        currentWeight += currentItemWeight;
        if (currentValue > bestValue) {
            bestItems = new ArrayList<>(currentItems);
            bestValue = currentValue;
        }
        processRucksack(position + 1);
        currentValue -= currentItemPrice;
        currentWeight -= currentItemWeight;
        currentItems.remove(currentItems.size() - 1);

    }
}
