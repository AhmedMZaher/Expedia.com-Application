package Model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static List<Item> items;

    public ShoppingCart() {
        if(items == null)
            items = new ArrayList<>();
    }
    public static double getTotalCost(){
        double totalCost = 0;
        for(Item item : items)
            totalCost += item.getPrice();
        return totalCost;
    }
}
