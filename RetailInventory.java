import java.util.*;

class Item {
    String name;
    int quantity;
    double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void display() {
        System.out.println("Name: " + name + ", Quantity: " + quantity + ", Price: $" + price);
    }
}

public class RetailInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> inventory = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Retail Inventory Management ---");
            System.out.println("1. Add Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Update Item Quantity");
            System.out.println("4. Delete Item");
            System.out.println("5. Search Item");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    inventory.add(new Item(name, quantity, price));
                    System.out.println("Item added!");
                    break;

                case 2:
                    System.out.println("\n--- Inventory List ---");
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory is empty.");
                    } else {
                        for (Item item : inventory) {
                            item.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter item name to update: ");
                    String updateName = scanner.nextLine();
                    boolean foundUpdate = false;
                    for (Item item : inventory) {
                        if (item.name.equalsIgnoreCase(updateName)) {
                            System.out.print("Enter new quantity: ");
                            item.quantity = scanner.nextInt();
                            foundUpdate = true;
                            System.out.println("Quantity updated.");
                            break;
                        }
                    }
                    if (!foundUpdate) System.out.println("Item not found.");
                    break;

                case 4:
                    System.out.print("Enter item name to delete: ");
                    String deleteName = scanner.nextLine();
                    Iterator<Item> iterator = inventory.iterator();
                    boolean foundDelete = false;
                    while (iterator.hasNext()) {
                        if (iterator.next().name.equalsIgnoreCase(deleteName)) {
                            iterator.remove();
                            foundDelete = true;
                            System.out.println("Item deleted.");
                            break;
                        }
                    }
                    if (!foundDelete) System.out.println("Item not found.");
                    break;

                case 5:
                    System.out.print("Enter item name to search: ");
                    String searchName = scanner.nextLine();
                    boolean foundSearch = false;
                    for (Item item : inventory) {
                        if (item.name.equalsIgnoreCase(searchName)) {
                            item.display();
                            foundSearch = true;
                        }
                    }
                    if (!foundSearch) System.out.println("Item not found.");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}