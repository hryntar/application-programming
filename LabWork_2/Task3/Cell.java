package LabWork_2.Task3;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final List<Item> items = new ArrayList<>();
    private static final int MAX_ITEMS_PER_CELL = 5;

    public void addItem(Item item) {
        int totalSize = getTotalSize();
        if (totalSize + item.getSize() <= MAX_ITEMS_PER_CELL) {
            items.add(item);
        } else {
            throw new IllegalArgumentException("Товар з ID " + item.getItemID() + " завеликий");
        }
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (Item item : items) {
            totalSize += item.getSize();
        }
        return totalSize;
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
