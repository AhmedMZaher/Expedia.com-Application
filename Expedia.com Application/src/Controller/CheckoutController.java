package Controller;

import DAO.ItemDao;
import DAO.UserItemsDao;
import Model.Item;
import Model.ShoppingCart;
import View.CheckoutView;

import java.util.List;

public class CheckoutController {
    public static void checkout(int userId){
        try {
            CheckoutView.printCart();
            // PaymentController.pay()
            //if(PaymentController.pay()){
            CheckoutView.displaySuccessMessage();
            confirmItinerary(userId);
            //}else
            //CheckoutView.displayErrorMessage();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Error: An error occurred while processing the checkout.");
        }
    }
    private static void confirmItinerary(int userId){
        List<Item> list = ShoppingCart.getINSTANCE().getItems();
        for(Item item : list){
            try {
                int itemID = item.getItemIdFromDatabase();
                UserItemsDao.addItem(itemID, userId);
            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println("Error: An error occurred while confirming the itinerary.");
            }
        }
    }
}
