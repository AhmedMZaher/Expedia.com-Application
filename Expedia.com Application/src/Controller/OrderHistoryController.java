package Controller;

import DAO.ItemDao;
import DAO.UserItemsDao;
import Model.Item;

import java.util.List;

public class OrderHistoryController {
    public static void run(int userId){
        System.out.println("HELLLLLLLLLLLLLLLOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        // Get all user items ids
        List<Integer> ids = UserItemsDao.getOrderedItemIDs(userId);
        for(int id : ids){
            System.out.println("MAYBE: " + id);
            // Get corresponding item to this id
            Item item = ItemDao.getItem(id);
            if(item == null)
                System.out.println("TTTTTTTTTTTTTTTTTEEEEEEEESSSSSSSSSSST");
            // Print the item
            item.printItem();
        }
    }
}
