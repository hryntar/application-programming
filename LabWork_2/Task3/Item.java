package LabWork_2.Task3;

public class Item {
    private final int length;
    private final int width;
    private final int height;
    private final String name;
    private final long itemID;

    public Item(int length, int width, int height, String name, long itemID) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.name = name;
        this.itemID = itemID;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public long getItemID() {
        return itemID;
    }

    public int getVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return "Назва: " + name + ", ID: " + itemID +
                ", Розміри (ДxШxВ): " + length + "x" + width + "x" + height;
    }
}
