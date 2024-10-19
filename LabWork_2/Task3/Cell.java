package LabWork_2.Task3;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final List<Item> items = new ArrayList<>();
    private static final int MAX_ITEMS_PER_CELL = 5;
    private static final int MAX_VOLUME_PER_CELL = 100;

    public void addItem(Item item) {
        if (items.size() >= MAX_ITEMS_PER_CELL) {
            throw new IllegalArgumentException("У комірці досягнуто максимальну кількість товарів");
        }

        int totalVolume = getTotalVolume();
        if (totalVolume + item.getVolume() <= MAX_VOLUME_PER_CELL) {
            items.add(item);
        } else {
            throw new IllegalArgumentException("Товар з ID " + item.getItemID() + " завеликий для цієї комірки");
        }
    }

    public int getTotalVolume() {
        int totalVolume = 0;
        for (Item item : items) {
            totalVolume += item.getVolume();
        }
        return totalVolume;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append("  Товар ").append(i + 1).append(": ").append(items.get(i)).append("\n");
        }
        return sb.toString();
    }
}
