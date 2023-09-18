package Model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static final ShoppingCart INSTANCE = new ShoppingCart();
    private static List<Item> items;

    public static ShoppingCart getINSTANCE() {
        return INSTANCE;
    }

    public ShoppingCart() {
        if (items == null)
            items = new ArrayList<>();
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (Item item : items)
            totalCost += item.getPrice();
        return totalCost;
    }

    public void clearCart() {
        items.clear();
    }

    public void addItemToCart(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
