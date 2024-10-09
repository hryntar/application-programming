package LabWork_2.Task3;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final List<Cell> storage = new ArrayList<>();
    private final int maxCells;

    public Storage(int maxCells) {
        this.maxCells = maxCells;
    }

    public void addItem(Item item) {
        for (Cell cell : storage) {
            try {
                cell.addItem(item);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Товар " + item.getItemID() + " не влазить, переносимо в іншу комірку...");
            }
        }

        if (storage.size() < maxCells) {
            Cell newCell = new Cell();
            newCell.addItem(item);
            storage.add(newCell);
        } else {
            throw new IllegalStateException("На складі не має вільних комірок");
        }
    }

    public String getItem(int cellIndex, int itemIndex) {
        if (cellIndex < storage.size() && itemIndex < storage.get(cellIndex).getItems().size()) {
            Item item = storage.get(cellIndex).getItems().get(itemIndex);
            return item.toString();
        } else {
            throw new IllegalArgumentException("Товар не знайдено");
        }
    }

    public void printStorageItems() {
        for (int cellIndex = 0; cellIndex < storage.size(); cellIndex++) {
            System.out.println("Комірка " + (cellIndex + 1) + ":");
            System.out.println(storage.get(cellIndex));
        }
    }
}