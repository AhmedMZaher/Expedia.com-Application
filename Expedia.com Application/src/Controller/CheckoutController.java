package Controller;

import DAO.ItemDao;
import Model.Item;
import Model.ShoppingCart;
import View.CheckoutView;

import java.util.List;

public class CheckoutController {
    public static void checkout(int userID){
        CheckoutView.printCart();
//        PaymentController.pay()
        //if(PaymentController.pay()){
            CheckoutView.displaySuccessMessage();
            confirmItinerary();
//        }else
            CheckoutView.displayErrorMessage();
    }
    private static void confirmItinerary(){
        List<Item> list = ShoppingCart.getINSTANCE().getItems();
        for(Item item : list){
            int itemID = item.getItemIdFromDatabase();
        }
    }
}
