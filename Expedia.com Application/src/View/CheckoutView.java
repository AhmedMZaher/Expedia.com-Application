package View;

import Model.Item;
import Model.ShoppingCart;

import java.util.List;

public class CheckoutView {
    public static void printCart(){
        List<Item> list = ShoppingCart.getINSTANCE().getItems();
        System.out.println("Total Cost: " + ShoppingCart.getINSTANCE().getTotalCost());
        for(Item item : list)
            item.printItem();
    }

    public static void displaySuccessMessage() {
        System.out.println("Reservation Confirmed");
    }
    public static void displayErrorMessage() {
        System.out.println("Reservation failed, Please Try again");
    }

}
