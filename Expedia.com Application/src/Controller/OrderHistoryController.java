package Controller;

import DAO.ItemDao;
import DAO.UserItemsDao;
import Model.Item;

import java.util.List;

public class OrderHistoryController {
    public static void run(int userId){
        // Get all user items ids
        List<Integer> ids = UserItemsDao.getOrderedItemIDs(userId);
        for(int id : ids){
            // Get corresponding item to this id
            Item item = ItemDao.getItem(id);
            if(item != null){
                // Print the item
                item.printItem();
            }
        }
    }
}
