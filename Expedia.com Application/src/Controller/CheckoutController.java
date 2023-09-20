package Controller;

import DAO.ItemDao;
import Model.Item;
import Model.ShoppingCart;
import View.CheckoutView;

import java.util.List;

public class CheckoutController {
    public static void checkout(int userID){
        try {
            CheckoutView.printCart();
            // PaymentController.pay()
            //if(PaymentController.pay()){
            CheckoutView.displaySuccessMessage();
            confirmItinerary();
            //}else
            //CheckoutView.displayErrorMessage();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Error: An error occurred while processing the checkout.");
        }
    }
    private static void confirmItinerary(){
        List<Item> list = ShoppingCart.getINSTANCE().getItems();
        for(Item item : list){
            try {
                int itemID = item.getItemIdFromDatabase();

            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println("Error: An error occurred while confirming the itinerary.");
            }
        }
    }
}
