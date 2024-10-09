package LabWork_2.Task3;

public class Item {
    private final int size;
    private final String name;
    private final int itemID;

    public Item(int size, String name, int itemID) {
        this.size = size;
        this.name = name;
        this.itemID = itemID;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public int getItemID() {
        return itemID;
    }

    @Override
    public String toString() {
        return "Назва: " + name + ", ID: " + itemID + ", Розмір: " + size;
    }
}