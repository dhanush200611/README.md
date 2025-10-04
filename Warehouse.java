package java_project_f116;
import java.util.*;
class Warehouse {
    private String name;
    private Map<Product, Integer> inventory = new HashMap<>();

    public Warehouse(String name) { this.name = name; }

    public void addStock(Product p, int qty) {
        inventory.put(p, inventory.getOrDefault(p, 0) + qty);
    }

    public void removeStock(Product p, int qty) {
        int current = inventory.getOrDefault(p, 0);
        if (current < qty) throw new IllegalArgumentException("Insufficient stock for " + p);
        inventory.put(p, current - qty);
    }

    public int getStock(Product p) {
        return inventory.getOrDefault(p, 0);
    }

    public void printStock() {
        System.out.println("--- Stock in " + name + " ---");
        for (Map.Entry<Product,Integer> e : inventory.entrySet()) {
            System.out.println(e.getKey().getName() + ": " + e.getValue());
        }
    }
}