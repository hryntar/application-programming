package LabWork_2.Task3;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage(3);

        Item item1 = new Item(2, "Item 1", 101);
        Item item2 = new Item(1, "Item 2", 102);
        Item item3 = new Item(3, "Item 3", 103);
        Item item4 = new Item(2, "Item 4", 104);
        Item item5 = new Item(1, "Item 5", 105);
        Item item6 = new Item(2, "Item 6", 106);
        Item item7 = new Item(4, "Item 7", 107);

        storage.addItem(item1);
        storage.addItem(item2);
        storage.addItem(item3);
        storage.addItem(item4);
        storage.addItem(item5);
        storage.addItem(item6);

        try {
            storage.addItem(item7); // цей товар не вміститься в жодну комірку
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Склад:");
        storage.printStorageItems();

        try {
            String itemDetails = storage.getItem(0, 0); // отримуємо конкретний товар
            System.out.println("Знайдений товар: " + itemDetails);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            String itemDetails = storage.getItem(2, 3); // товару не існує
            System.out.println("Знайдений товар: " + itemDetails);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
